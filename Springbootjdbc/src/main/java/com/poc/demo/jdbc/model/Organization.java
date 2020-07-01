package com.poc.demo.jdbc.model;

public class Organization {

	private int org_tid;

	private String orgName;

	private int noOfemp;

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

	public int getOrg_tid() {
		return org_tid;
	}

	public void setOrg_tid(int org_tid) {
		this.org_tid = org_tid;
	}

	@Override
	public String toString() {
		return "Organization [org_tid=" + org_tid + ", orgName=" + orgName + ", noOfemp=" + noOfemp + "]";
	}

}
