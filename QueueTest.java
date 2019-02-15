package Assignment2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Ignore;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class QueueTest {
	private static Queue q;
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		q=new Queue(5);
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		q=null;
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testEnqueue() {
		
		q.enqueue(4);
		q.enqueue(5);
		assertEquals(2, q.size());
	}

	@Ignore

	void testSize() {
		int b=q.size();
		assertEquals(2,b);
		
	}

	@Ignore
	
	void testIsEmpty() {
		q.isEmpty();
		assertEquals(0, q.size());
		
	}

	@Test
	
	void testIsFull() {
		q.isFull();
		assertEquals(2, q.size());
	
	}

}
