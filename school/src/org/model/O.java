package org.model;

/**
 * O entity. @author MyEclipse Persistence Tools
 */
public class O extends AbstractO implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public O() {
	}

	/** minimal constructor */
	public O(OId id, String time) {
		super(id, time);
	}

	/** full constructor */
	public O(OId id, String time, String addr) {
		super(id, time, addr);
	}

}
