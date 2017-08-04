package org.model;

/**
 * G entity. @author MyEclipse Persistence Tools
 */
public class G extends AbstractG implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public G() {
	}

	/** minimal constructor */
	public G(GId id) {
		super(id);
	}

	/** full constructor */
	public G(GId id, Integer ngrade, Integer tgrade, Integer fgrade) {
		super(id, ngrade, tgrade, fgrade);
	}

}
