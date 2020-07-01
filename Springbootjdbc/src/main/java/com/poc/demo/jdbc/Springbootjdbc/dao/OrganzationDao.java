package com.poc.demo.jdbc.Springbootjdbc.dao;

import java.util.List;

import com.poc.demo.jdbc.model.Organization;
import com.poc.demo.jdbc.model.OrganizationDetail;
public interface OrganzationDao {

	List<Organization> getAllOrgs();

	Organization getOrgById(int tid);

	void addOrgDet(Organization orgs);

	Integer updateOrgsDetail(Organization orgs);

	void deleteOrgsDet(int orgId);

	boolean orgsExist(String orgName, int yearofReg);

	//OrganizationDetail getOrganzationAllId(int tid);


}
