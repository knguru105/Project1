package Assingment1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TowersOfHanoiTest {
	private static TowersOfHanoi tower;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		tower=new TowersOfHanoi();
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		tower=null;
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void test() {
		 tower.hanoi(3, "A", "B", "C");
		equals(6);
		
	}

}
