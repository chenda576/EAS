package org.model;

/**
 * AbstractGId entity provides the base persistence definition of the GId
 * entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractGId implements java.io.Serializable {

	// Fields

	private C c;
	private S s;
	private T t;
	private String term;

	// Constructors

	/** default constructor */
	public AbstractGId() {
	}

	/** full constructor */
	public AbstractGId(C c, S s, T t, String term) {
		this.c = c;
		this.s = s;
		this.t = t;
		this.term = term;
	}

	// Property accessors

	public C getC() {
		return this.c;
	}

	public void setC(C c) {
		this.c = c;
	}

	public S getS() {
		return this.s;
	}

	public void setS(S s) {
		this.s = s;
	}

	public T getT() {
		return this.t;
	}

	public void setT(T t) {
		this.t = t;
	}

	public String getTerm() {
		return this.term;
	}

	public void setTerm(String term) {
		this.term = term;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof AbstractGId))
			return false;
		AbstractGId castOther = (AbstractGId) other;

		return ((this.getC() == castOther.getC()) || (this.getC() != null
				&& castOther.getC() != null && this.getC().equals(
				castOther.getC())))
				&& ((this.getS() == castOther.getS()) || (this.getS() != null
						&& castOther.getS() != null && this.getS().equals(
						castOther.getS())))
				&& ((this.getT() == castOther.getT()) || (this.getT() != null
						&& castOther.getT() != null && this.getT().equals(
						castOther.getT())))
				&& ((this.getTerm() == castOther.getTerm()) || (this.getTerm() != null
						&& castOther.getTerm() != null && this.getTerm()
						.equals(castOther.getTerm())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getC() == null ? 0 : this.getC().hashCode());
		result = 37 * result + (getS() == null ? 0 : this.getS().hashCode());
		result = 37 * result + (getT() == null ? 0 : this.getT().hashCode());
		result = 37 * result
				+ (getTerm() == null ? 0 : this.getTerm().hashCode());
		return result;
	}

}