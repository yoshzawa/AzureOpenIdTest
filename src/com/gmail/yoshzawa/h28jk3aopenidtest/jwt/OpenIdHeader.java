package com.gmail.yoshzawa.h28jk3aopenidtest.jwt;

public class OpenIdHeader {
	private String typ;
	private String alg;
	private String kid;

	public OpenIdHeader() {
		this(null, null, null);
	}

	public OpenIdHeader(String typ, String alg, String kid) {
		setTyp(typ);
		setAlg(alg);
		setKid(kid);
	}

	public String getTyp() {
		return typ;
	}

	public void setTyp(String typ) {
		this.typ = typ;
	}

	public String getAlg() {
		return alg;
	}

	public void setAlg(String alg) {
		this.alg = alg;
	}

	public String getKid() {
		return kid;
	}

	public void setKid(String kid) {
		this.kid = kid;
	}

}
