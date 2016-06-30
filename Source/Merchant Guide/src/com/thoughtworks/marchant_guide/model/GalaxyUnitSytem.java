package com.thoughtworks.marchant_guide.model;

import java.util.ArrayList;

/*
 * Model class to hold Galaxy units white performing database operations
 */

public class GalaxyUnitSytem {

	private String galaxyName;
	private String I = "one";
	private String V = "five";
	private String X = "ten";
	private String L = "fifty";
	private String C = "hundred";
	private String D = "five_hundred";
	private String M = "thousand";

	public GalaxyUnitSytem(String galaxyName, String I, String V, String X,
			String L, String C, String D, String M) {

		this.galaxyName = galaxyName;
		this.I = I;
		this.V = V;
		this.X = X;
		this.L = L;
		this.C = C;
		this.D = D;
		this.M = M;
	}

	public ArrayList<String> toList() {

		ArrayList<String> units = new ArrayList<String>();
		units.add(I);
		units.add(V);
		units.add(X);
		units.add(L);
		units.add(C);
		units.add(D);
		units.add(M);

		return units;
	}

	/**
	 * @return the galaxyName
	 */
	public String getGalaxyName() {
		return galaxyName;
	}

	/**
	 * @param galaxyName
	 *            the galaxyName to set
	 */
	public void setGalaxyName(String galaxyName) {
		this.galaxyName = galaxyName;
	}

	/**
	 * @return the i
	 */
	public String getI() {
		return I;
	}

	/**
	 * @param i
	 *            the i to set
	 */
	public void setI(String i) {
		I = i;
	}

	/**
	 * @return the v
	 */
	public String getV() {
		return V;
	}

	/**
	 * @param v
	 *            the v to set
	 */
	public void setV(String v) {
		V = v;
	}

	/**
	 * @return the x
	 */
	public String getX() {
		return X;
	}

	/**
	 * @param x
	 *            the x to set
	 */
	public void setX(String x) {
		X = x;
	}

	/**
	 * @return the l
	 */
	public String getL() {
		return L;
	}

	/**
	 * @param l
	 *            the l to set
	 */
	public void setL(String l) {
		L = l;
	}

	/**
	 * @return the c
	 */
	public String getC() {
		return C;
	}

	/**
	 * @param c
	 *            the c to set
	 */
	public void setC(String c) {
		C = c;
	}

	/**
	 * @return the d
	 */
	public String getD() {
		return D;
	}

	/**
	 * @param d
	 *            the d to set
	 */
	public void setD(String d) {
		D = d;
	}

	/**
	 * @return the m
	 */
	public String getM() {
		return M;
	}

	/**
	 * @param m
	 *            the m to set
	 */
	public void setM(String m) {
		M = m;
	}

}
