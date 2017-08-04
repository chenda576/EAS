package org.model;

import java.util.Set;

/**
 * T entity. @author MyEclipse Persistence Tools
 */
public class T extends AbstractT implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public T() {
	}

	/** minimal constructor */
	public T(String tno, D d, String password, String tname) {
		super(tno, d, password, tname);
	}

	/** full constructor */
	public T(String tno, D d, String password, String tname, String addr,
			Set xes, Set gs, Set os) {
		super(tno, d, password, tname, addr, xes, gs, os);
	}

}
