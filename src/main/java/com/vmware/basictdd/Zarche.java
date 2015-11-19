package com.vmware.basictdd;

import java.util.Random;

public class Zarche {

	private int pips;
	private Random random;

	public Zarche(Random random) {
		this(random, 1);
	}

	public Zarche(Random random, int pips) {
	   this.random = random;
	   this.pips = pips;
	}

	public int getPips() {
		return pips;
	}

	public Zarche roll() {
		return new Zarche(random, random.nextInt(6) + 1);
	}
}
