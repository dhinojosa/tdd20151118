package com.vmware.basictdd;

import static org.assertj.core.api.Assertions.assertThat;
import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;

import java.util.Random;

import org.testng.annotations.Test;

public class ZarcheTest {

	// Atomic, Consistent

	@Test
	public void testDefaultIs1() {
		// Stub
		Random random = new Random();
		Zarche zarche = new Zarche(random);
		assertThat(zarche.getPips()).isEqualTo(1);
	}

	@Test
	public void testSimpleRollOf4() {
		// Stub
		Random random = new Random() {
			@Override
			public int nextInt(int bound) {
				return 3;
			}
		};

		// Dependency Injection, Inversion of Control
		Zarche zarche = new Zarche(random); // YES!!
		Zarche newZarche = zarche.roll();
		assertThat(newZarche.getPips()).isEqualTo(4);
	}

	@Test
	public void testSimpleRollOf2() {
		// Stub
		Random random = new Random() {
			@Override
			public int nextInt(int bound) {
				return 1;
			}
		};

		// Dependency Injection, Inversion of Control
		Zarche zarche = new Zarche(random); // YES!!
		Zarche newZarche = zarche.roll();
		assertThat(newZarche.getPips()).isEqualTo(2);
	}

	@Test
	public void testSimpleRollOf2Then4() {
		// Stub
		Random random = new Random() {
			int times = 0;

			@Override
			public int nextInt(int bound) {
				if (times == 0) {
					times++;
					return 1;
				} else
					return 3;
			}
		};

		// Dependency Injection, Inversion of Control
		Zarche zarche = new Zarche(random); // YES!!
		Zarche newZarche = zarche.roll();
		assertThat(newZarche.getPips()).isEqualTo(2);
		Zarche newZarche2 = newZarche.roll();
		assertThat(newZarche2.getPips()).isEqualTo(4);
	}
	
	@Test
	public void testSimpleRollOf2Then4UsingMock() {
		// Mock!
		// Setup
		Random random = createMock(Random.class);
		
		// Rehearsal
		expect(random.nextInt(6)).andReturn(1).once();
		expect(random.nextInt(6)).andReturn(3).once();
		
		// Rewind/Replay
        replay(random);
		
		// Dependency Injection, Inversion of Control
		Zarche zarche = new Zarche(random); // YES!!
		Zarche newZarche = zarche.roll();
		assertThat(newZarche.getPips()).isEqualTo(2);
		Zarche newZarche2 = newZarche.roll();
		assertThat(newZarche2.getPips()).isEqualTo(4);
		
		// Verify
		verify(random);
	}
	
	@Test
	public void testIntegrationWithARealRandom() {
	    Random random = new Random();
	    Zarche zarche = new Zarche(random);
	    for (int i = 0; i < 1000000; i++) {
	    	assertThat(zarche.roll().getPips())
	    	   .isGreaterThan(0)
	    	   .isLessThan(7); 
	    }
	}
	
	@Test
	public void testBUG3012() {
		Random random = createMock(Random.class);
		expect(random.nextInt(6)).andReturn(1).once();
        replay(random);
		
		Zarche zarche = new Zarche(random); // YES!!
		Zarche newZarche = zarche.roll();
		assertThat(newZarche.getPips()).isEqualTo(2);
		
		// Verify
		verify(random);
	}
	
	@Test
	public void testBUG3012WithZero() {
		Random random = createMock(Random.class);
		expect(random.nextInt(6)).andReturn(0).once();
        replay(random);
		
		Zarche zarche = new Zarche(random); // YES!!
		Zarche newZarche = zarche.roll();
		assertThat(newZarche.getPips()).isEqualTo(1);
		
		// Verify
		verify(random);
	}
	
	@Test
	public void testBUG3012WithSix() {
		Random random = createMock(Random.class);
		expect(random.nextInt(6)).andReturn(5).once();
        replay(random);
		
		Zarche zarche = new Zarche(random); // YES!!
		Zarche newZarche = zarche.roll();
		assertThat(newZarche.getPips()).isEqualTo(6);
		
		// Verify
		verify(random);
	}
}







