package org.model;

import java.util.Set;

/**
 * C entity. @author MyEclipse Persistence Tools
 */
public class C extends AbstractC implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public C() {
	}

	/** minimal constructor */
	public C(String cno, String cname, Integer rate) {
		super(cno, cname, rate);
	}

	/** full constructor */
	public C(String cno, D d, String cname, Integer rate, Integer credit,
			Set xes, Set gs, Set os) {
		super(cno, d, cname, rate, credit, xes, gs, os);
	}

}
