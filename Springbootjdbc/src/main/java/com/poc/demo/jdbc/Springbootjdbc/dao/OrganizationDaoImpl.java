package com.poc.demo.jdbc.Springbootjdbc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.poc.demo.jdbc.model.Organization;
import com.poc.demo.jdbc.model.OrganizationDetail;

@Repository
@Transactional
public class OrganizationDaoImpl implements OrganzationDao {

	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	private SqlParameterSource paramSource(Organization organization) {
		// TODO Auto-generated method stub
		MapSqlParameterSource mSource = new MapSqlParameterSource();
		mSource.addValue("org_tid", organization.getOrg_tid());
		mSource.addValue("orgName", organization.getOrgName());
		mSource.addValue("noOfemp", organization.getNoOfemp());
		System.out.println(mSource.getValues().entrySet());
		return mSource;
	}

	@Autowired
	public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate)
			throws DataAccessException {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}

	public List<Organization> getAllOrgs() {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM orgdetail";
		List<Organization> result = namedParameterJdbcTemplate.query(sql, new OrgMapper());

		return result;

	}

	public Organization getOrgById(int tid) {
		// TODO Auto-generated method stub

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("org_tid", tid);

		String sql = "SELECT * FROM orgdetail WHERE org_tid=:org_tid";
		Organization result = namedParameterJdbcTemplate.queryForObject(sql, params, new OrgMapper());
		return result;
	}

	public Integer updateOrgsDetail(Organization orgs) {
		// TODO Auto-generated method stub
		String sql = "UPDATE orgdetail set orgName= :orgName,noOfemp=:noOfemp where org_tid=:org_tid";
		return namedParameterJdbcTemplate.update(sql, paramSource(orgs));

	}

	public void deleteOrgsDet(int orgId) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM orgdetail WHERE org_tid= :org_tid";
		namedParameterJdbcTemplate.update(sql, new MapSqlParameterSource("org_tid", orgId));

	}

	public boolean orgsExist(String orgName, int yearofReg) {
		// TODO Auto-generated method stub
		return false;
	}

	private static final class OrgMapper implements RowMapper<Organization> {

		public Organization mapRow(ResultSet rs, int rowNum) throws SQLException {
			Organization org = new Organization();
			org.setOrg_tid(rs.getInt("org_tid"));
			org.setOrgName(rs.getString("orgName"));
			org.setNoOfemp(rs.getInt("noOfemp"));
			return org;
		}

	}

	private static final class ObjectMapper implements RowMapper<OrganizationDetail> {

		public OrganizationDetail mapRow(ResultSet rs, int rowNum) throws SQLException {
			System.out.println(
					rs.getInt(0) + rs.getString(1) + rs.getInt(2) + rs.getInt(3) + rs.getString(4) + rs.getInt(5));
			OrganizationDetail orgdetail = new OrganizationDetail();
			// Organization org = new Organization();

			orgdetail.setOrg_tid(rs.getInt("org_tid"));
			orgdetail.setOrgName(rs.getString("orgName"));
			orgdetail.setNoOfemp(rs.getInt("noOfemp"));
			orgdetail.setTid(rs.getInt("tid"));
			orgdetail.setOrgname(rs.getString("orgname"));
			orgdetail.setYearofreg(rs.getInt("yearofreg"));
			return orgdetail;

		}

	}

	public void addOrgDet(Organization orgs) throws DuplicateKeyException {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO orgdetail(org_tid,orgName,noOfemp)" + "VALUES(:org_tid,:orgName,:noOfemp)";
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("org_tid", orgs.getOrg_tid());
		paramMap.put("orgName", orgs.getOrgName());
		paramMap.put("noOfemp", orgs.getNoOfemp());

		// Passing map containing named params
		// try {
		int status = namedParameterJdbcTemplate.update(sql, paramMap);
				if (status != 0) {
			System.out.println("the value of org id inserted is " + orgs.getOrg_tid());
		} else {
			System.out.println("org id inserted is   " + orgs.getOrg_tid());
		}
	}

	/*@Override
	public OrganizationDetail getOrganzationAllId(int tid) {
		// TODO Auto-generated method stub
		
		 * Organization orgs=new Organization(); OrganizationDetail
		 * organizationDetail=new OrganizationDetail();
		 // String sql="SELECT orgs.tid, orgdetail.noOfemp, orgs.orgname,orgs.yearofreg
			// FROM orgs INNER JOIN orgdetail ON orgs.tid=orgdetail.org_tid and
			// orgs.orgname=orgdetail.orgName";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("org_tid", tid);
		params.put("tid", tid);
		String sql = "SELECT orgs.tid, orgdetail.noOfemp, orgs.orgname,orgs.yearofreg FROM orgs INNER JOIN orgdetail ON orgs.tid=orgdetail.org_tid";
		
		OrganizationDetail result = (OrganizationDetail) namedParameterJdbcTemplate.query(sql, params,
				new ObjectMapper());
		return result;

	}*/

}