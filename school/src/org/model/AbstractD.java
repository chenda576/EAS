package org.model;

import java.util.HashSet;
import java.util.Set;

/**
 * AbstractD entity provides the base persistence definition of the D entity. @author
 * MyEclipse Persistence Tools
 */

public abstract class AbstractD implements java.io.Serializable {

	// Fields

	private String deptNo;
	private String deptName;
	private String addr;
	private Set ts = new HashSet(0);
	private Set ses = new HashSet(0);
	private Set cs = new HashSet(0);

	// Constructors

	/** default constructor */
	public AbstractD() {
	}

	/** minimal constructor */
	public AbstractD(String deptNo, String deptName) {
		this.deptNo = deptNo;
		this.deptName = deptName;
	}

	/** full constructor */
	public AbstractD(String deptNo, String deptName, String addr, Set ts,
			Set ses, Set cs) {
		this.deptNo = deptNo;
		this.deptName = deptName;
		this.addr = addr;
		this.ts = ts;
		this.ses = ses;
		this.cs = cs;
	}

	// Property accessors

	public String getDeptNo() {
		return this.deptNo;
	}

	public void setDeptNo(String deptNo) {
		this.deptNo = deptNo;
	}

	public String getDeptName() {
		return this.deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getAddr() {
		return this.addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public Set getTs() {
		return this.ts;
	}

	public void setTs(Set ts) {
		this.ts = ts;
	}

	public Set getSes() {
		return this.ses;
	}

	public void setSes(Set ses) {
		this.ses = ses;
	}

	public Set getCs() {
		return this.cs;
	}

	public void setCs(Set cs) {
		this.cs = cs;
	}

}