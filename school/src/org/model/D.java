package org.model;

import java.util.Set;

/**
 * D entity. @author MyEclipse Persistence Tools
 */
public class D extends AbstractD implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public D() {
	}

	/** minimal constructor */
	public D(String deptNo, String deptName) {
		super(deptNo, deptName);
	}

	/** full constructor */
	public D(String deptNo, String deptName, String addr, Set ts, Set ses,
			Set cs) {
		super(deptNo, deptName, addr, ts, ses, cs);
	}

}
