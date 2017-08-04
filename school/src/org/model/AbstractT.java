package org.model;

import java.util.HashSet;
import java.util.Set;

/**
 * AbstractT entity provides the base persistence definition of the T entity. @author
 * MyEclipse Persistence Tools
 */

public abstract class AbstractT implements java.io.Serializable {

	// Fields

	private String tno;
	private D d;
	private String password;
	private String tname;
	private String addr;
	private Set xes = new HashSet(0);
	private Set gs = new HashSet(0);
	private Set os = new HashSet(0);

	// Constructors

	/** default constructor */
	public AbstractT() {
	}

	/** minimal constructor */
	public AbstractT(String tno, D d, String password, String tname) {
		this.tno = tno;
		this.d = d;
		this.password = password;
		this.tname = tname;
	}

	/** full constructor */
	public AbstractT(String tno, D d, String password, String tname,
			String addr, Set xes, Set gs, Set os) {
		this.tno = tno;
		this.d = d;
		this.password = password;
		this.tname = tname;
		this.addr = addr;
		this.xes = xes;
		this.gs = gs;
		this.os = os;
	}

	// Property accessors

	public String getTno() {
		return this.tno;
	}

	public void setTno(String tno) {
		this.tno = tno;
	}

	public D getD() {
		return this.d;
	}

	public void setD(D d) {
		this.d = d;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTname() {
		return this.tname;
	}

	public void setTname(String tname) {
		this.tname = tname;
	}

	public String getAddr() {
		return this.addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public Set getXes() {
		return this.xes;
	}

	public void setXes(Set xes) {
		this.xes = xes;
	}

	public Set getGs() {
		return this.gs;
	}

	public void setGs(Set gs) {
		this.gs = gs;
	}

	public Set getOs() {
		return this.os;
	}

	public void setOs(Set os) {
		this.os = os;
	}

}