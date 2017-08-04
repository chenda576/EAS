package org.model;

import java.util.HashSet;
import java.util.Set;

/**
 * AbstractS entity provides the base persistence definition of the S entity. @author
 * MyEclipse Persistence Tools
 */

public abstract class AbstractS implements java.io.Serializable {

	// Fields

	private String stuNo;
	private D d;
	private String password;
	private String name;
	private Integer gender;
	private String birth;
	private Set gs = new HashSet(0);
	private Set xes = new HashSet(0);

	// Constructors

	/** default constructor */
	public AbstractS() {
	}

	/** minimal constructor */
	public AbstractS(String stuNo, D d, String password, String name,
			Integer gender, String birth) {
		this.stuNo = stuNo;
		this.d = d;
		this.password = password;
		this.name = name;
		this.gender = gender;
		this.birth = birth;
	}

	/** full constructor */
	public AbstractS(String stuNo, D d, String password, String name,
			Integer gender, String birth, Set gs, Set xes) {
		this.stuNo = stuNo;
		this.d = d;
		this.password = password;
		this.name = name;
		this.gender = gender;
		this.birth = birth;
		this.gs = gs;
		this.xes = xes;
	}

	// Property accessors

	public String getStuNo() {
		return this.stuNo;
	}

	public void setStuNo(String stuNo) {
		this.stuNo = stuNo;
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

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getGender() {
		return this.gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public String getBirth() {
		return this.birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public Set getGs() {
		return this.gs;
	}

	public void setGs(Set gs) {
		this.gs = gs;
	}

	public Set getXes() {
		return this.xes;
	}

	public void setXes(Set xes) {
		this.xes = xes;
	}

}