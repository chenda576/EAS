package org.model;

/**
 * AbstractO entity provides the base persistence definition of the O entity. @author
 * MyEclipse Persistence Tools
 */

public abstract class AbstractO implements java.io.Serializable {

	// Fields

	private OId id;
	private String time;
	private String addr;

	// Constructors

	/** default constructor */
	public AbstractO() {
	}

	/** minimal constructor */
	public AbstractO(OId id, String time) {
		this.id = id;
		this.time = time;
	}

	/** full constructor */
	public AbstractO(OId id, String time, String addr) {
		this.id = id;
		this.time = time;
		this.addr = addr;
	}

	// Property accessors

	public OId getId() {
		return this.id;
	}

	public void setId(OId id) {
		this.id = id;
	}

	public String getTime() {
		return this.time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getAddr() {
		return this.addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

}