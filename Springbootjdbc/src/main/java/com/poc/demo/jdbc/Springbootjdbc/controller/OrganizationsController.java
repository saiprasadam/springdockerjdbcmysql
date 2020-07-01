package com.poc.demo.jdbc.Springbootjdbc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;


import com.poc.demo.jdbc.model.Organization;
import com.poc.demo.jdbc.model.OrganizationDetail;
import com.poc.demo.jdbc.Springbootjdbc.service.OrganzationService;
import com.poc.demo.jdbc.exception.CustomCommonException;

import io.swagger.annotations.Api;

//@PropertySource("classpath:application.properties")
		/* {
	            "classpath:/application.properties",
	            "classpath:/${spring.profiles.active}/application-${spring.profiles.active}.properties"
	    })*/
@RestController
@Service
@RequestMapping("/orgdetailjdbc")
@Api(value="OrganizationDetail", description="Display the Organization Detail")
public class OrganizationsController {
	@Autowired
	private OrganzationService oganzationService;
	
	
	@GetMapping("findby/{id}")
	public ResponseEntity<Organization> getorgsById(@PathVariable("id") Integer id) {
		Organization organization = oganzationService.getOrganzationById(id);
		return new ResponseEntity<Organization>(organization, HttpStatus.OK);
	}
	/*@GetMapping("find/{id}")
	public ResponseEntity<OrganizationDetail> getorgsId(@PathVariable("id") Integer id) {
		OrganizationDetail organization = oganzationService.getOrganzationIdAll(id);
		return new ResponseEntity<OrganizationDetail>(organization, HttpStatus.OK);
	}*/
		@GetMapping("find")
	public ResponseEntity<List<Organization>> getAllorgss() {
			//System.out.println("---"+down);
		List<Organization> list = oganzationService.getAllOrgs();
		
		return new ResponseEntity<List<Organization>>(list, HttpStatus.OK);
	}
	//@PostMapping("insert")
		@RequestMapping(value = "/inser", method = RequestMethod.POST,consumes= MediaType.APPLICATION_JSON_VALUE)
	public String addorgs(@RequestBody Organization organization, UriComponentsBuilder builder) {
        boolean flag = oganzationService.addOrganzationDet(organization);
        System.out.println("------"+flag);
        if (flag == false) {
        	//return CustomCommonException.checkBoolen(flag); 
        	//return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/orgs/{id}").buildAndExpand(organization.getOrg_tid()).toUri());
       // return addorgs(organization, builder);
        return CustomCommonException.checkBoolen(flag);
	}
	@PutMapping("update")
	public ResponseEntity<Organization> updateorgs(@RequestBody Organization organization) {
		oganzationService.updateOrganzationDet(organization);
		return new ResponseEntity<Organization>(organization, HttpStatus.OK);
	}
	@DeleteMapping("delete/{id}")
	public ResponseEntity<Void> deleteorgs(@PathVariable("id") Integer id) {
		oganzationService.deleteOrganzationDet(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}	
} 