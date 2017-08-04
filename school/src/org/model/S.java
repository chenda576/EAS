package org.model;

import java.util.Set;

/**
 * S entity. @author MyEclipse Persistence Tools
 */
public class S extends AbstractS implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public S() {
	}

	/** minimal constructor */
	public S(String stuNo, D d, String password, String name, Integer gender,
			String birth) {
		super(stuNo, d, password, name, gender, birth);
	}

	/** full constructor */
	public S(String stuNo, D d, String password, String name, Integer gender,
			String birth, Set gs, Set xes) {
		super(stuNo, d, password, name, gender, birth, gs, xes);
	}

}
