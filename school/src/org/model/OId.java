package org.model;

/**
 * OId entity. @author MyEclipse Persistence Tools
 */
public class OId extends AbstractOId implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public OId() {
	}

	/** full constructor */
	public OId(C c, T t, String term) {
		super(c, t, term);
	}

}
