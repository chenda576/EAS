package org.model;

/**
 * AbstractA entity provides the base persistence definition of the A entity. @author
 * MyEclipse Persistence Tools
 */

public abstract class AbstractA implements java.io.Serializable {

	// Fields

	private String id;
	private String password;

	// Constructors

	/** default constructor */
	public AbstractA() {
	}

	/** full constructor */
	public AbstractA(String id, String password) {
		this.id = id;
		this.password = password;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}