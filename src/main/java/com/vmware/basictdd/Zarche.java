package com.vmware.basictdd;

import java.util.Random;

public class Zarche {
	private final int pips;
	private final Random random;
	private static final int MAX_SIDES = 6;
	
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
		return new Zarche(random, 
				random.nextInt(MAX_SIDES) + 1);
	}
}
