package com.poc.demo.jdbc.Springbootjdbc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.poc.demo.jdbc.model.Organization;
import com.poc.demo.jdbc.model.OrganizationDetail;
import com.poc.demo.jdbc.Springbootjdbc.dao.OrganzationDao;
@Service
public class OrganizationServiceImpl implements OrganzationService {
	
	@Autowired
	OrganzationDao organzationDao;
	
	@Value("${calmdown.new}")
	private String down;

	public List<Organization> getAllOrgs() {
		// TODO Auto-generated method stub
		System.out.println("---"+down);
		return organzationDao.getAllOrgs();
	}

	public Organization getOrganzationById(int tid) {
		// TODO Auto-generated method stub
		Organization organization=organzationDao.getOrgById(tid);
		return organization;
	}

	/*public OrganizationDetail getOrganzationIdAll(int tid) {
		// TODO Auto-generated method stub
		OrganizationDetail organization=organzationDao.getOrganzationAllId(tid);
		return organization;
	}*/
	public boolean addOrganzationDet(Organization orgs) {
		// TODO Auto-generated method stub
		if (organzationDao.orgsExist(orgs.getOrgName(),orgs.getNoOfemp())) {
	    	   return false;
	       }
		 organzationDao.addOrgDet(orgs);
		 
		return true;
	}

	public void updateOrganzationDet(Organization orgs) {
		// TODO Auto-generated method stub
		organzationDao.updateOrgsDetail(orgs);
		
	}

	public void deleteOrganzationDet(int orgId) {
		// TODO Auto-generated method stub
		organzationDao.deleteOrgsDet(orgId);
		
	}
}