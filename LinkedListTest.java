package Assignment2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Assignment2.LinkedList.Node;

class LinkedListTest {
	private static LinkedList list;


	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		list=new LinkedList();
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		list=null;
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testInsert() {
		LinkedList l;
		l=list.insert(list, 1);
		 l=list.insert(list, 2);
		assertEquals(2, l);
	}

	@Test
	void testDelete() {
		fail("Not yet implemented");
	}

	@Test
	void testSearch() {
		fail("Not yet implemented");
	}

}
