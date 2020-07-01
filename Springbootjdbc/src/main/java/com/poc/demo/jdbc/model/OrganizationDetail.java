package com.poc.demo.jdbc.model;

public class OrganizationDetail {
	
	private int org_tid;

	private String orgName;

	private int noOfemp;

	public int getOrg_tid() {
		return org_tid;
	}

	public void setOrg_tid(int org_tid) {
		this.org_tid = org_tid;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public int getNoOfemp() {
		return noOfemp;
	}

	public void setNoOfemp(int noOfemp) {
		this.noOfemp = noOfemp;
	}

	private int tid;

	private String orgname;

	private int yearofreg;

	public int getTid() {
		return tid;
	}

	public void setTid(int tid) {
		this.tid = tid;
	}

	public String getOrgname() {
		return orgname;
	}

	public void setOrgname(String orgname) {
		this.orgname = orgname;
	}

	public int getYearofreg() {
		return yearofreg;
	}

	public void setYearofreg(int yearofreg) {
		this.yearofreg = yearofreg;
	}

	@Override
	public String toString() {
		return "OrganizationDetail [org_tid=" + org_tid + ", orgName=" + orgName + ", noOfemp=" + noOfemp + ", tid="
				+ tid + ", orgname=" + orgname + ", yearofreg=" + yearofreg + "]";
	}
	
	

}
