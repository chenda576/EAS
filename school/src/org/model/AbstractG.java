package org.model;

/**
 * AbstractG entity provides the base persistence definition of the G entity. @author
 * MyEclipse Persistence Tools
 */

public abstract class AbstractG implements java.io.Serializable {

	// Fields

	private GId id;
	private Integer ngrade;
	private Integer tgrade;
	private Integer fgrade;

	// Constructors

	/** default constructor */
	public AbstractG() {
	}

	/** minimal constructor */
	public AbstractG(GId id) {
		this.id = id;
	}

	/** full constructor */
	public AbstractG(GId id, Integer ngrade, Integer tgrade, Integer fgrade) {
		this.id = id;
		this.ngrade = ngrade;
		this.tgrade = tgrade;
		this.fgrade = fgrade;
	}

	// Property accessors

	public GId getId() {
		return this.id;
	}

	public void setId(GId id) {
		this.id = id;
	}

	public Integer getNgrade() {
		return this.ngrade;
	}

	public void setNgrade(Integer ngrade) {
		this.ngrade = ngrade;
	}

	public Integer getTgrade() {
		return this.tgrade;
	}

	public void setTgrade(Integer tgrade) {
		this.tgrade = tgrade;
	}

	public Integer getFgrade() {
		return this.fgrade;
	}

	public void setFgrade(Integer fgrade) {
		this.fgrade = fgrade;
	}

}