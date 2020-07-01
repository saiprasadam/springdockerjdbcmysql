package com.poc.demo.jdbc.Springbootjdbc.service;

import java.util.List;

import com.poc.demo.jdbc.model.Organization;
import com.poc.demo.jdbc.model.OrganizationDetail;


public interface OrganzationService {
	 List<Organization> getAllOrgs();
	 Organization getOrganzationById(int tid);
     boolean addOrganzationDet(Organization org);
     void updateOrganzationDet(Organization org);
     void deleteOrganzationDet(int orgId);
     //OrganizationDetail getOrganzationIdAll(int tid);
     
}
