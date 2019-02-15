package com.ominiwyse.assignment5;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MstTest {
private static Mst ms;
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	ms=new Mst();
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	ms=null;
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testAddVertex() {
		int a=ms.addVertex('A');
		assertEquals('A', a);
		int b=ms.addVertex('B');
		assertEquals('B', b);
		//fail("Not yet implemented");
	}

	@Test
	void testAddEdge() {
		//fail("Not yet implemented");
	}

	@Test
	void testDisplayVertex() {
		//fail("Not yet implemented");
	}

}
