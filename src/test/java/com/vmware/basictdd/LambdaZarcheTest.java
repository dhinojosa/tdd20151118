package com.vmware.basictdd;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Random;

import org.testng.annotations.Test;

public class LambdaZarcheTest {
	@Test(groups={"unit"})
	public void testSimpleRollOf4() {
		LambdaZarche zarche = 
				new LambdaZarche(() -> 4);
		LambdaZarche newZarche = zarche.roll();
		//assertThat(newZarche.getPips()).isEqualTo(4);
	}
	
	@Test(groups={"integration"})
	public void testIntegration() {
		Random random = new Random();
		LambdaZarche zarche = 
				new LambdaZarche(() -> random.nextInt(6) + 1);
		LambdaZarche newZarche = zarche.roll();
		//assertThat(newZarche.getPips()).isEqualTo(4);
	}
}
