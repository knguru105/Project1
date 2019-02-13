package Assingment1;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Power1Test {
	private static Power1 power;
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		power=new Power1();
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		power=null;
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void test() {
		
		 int b= power.power(2, 0);
		 assertEquals(1, b);
		
	}

}
