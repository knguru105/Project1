package Assignment2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Ignore;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StackTest {
	private static Stack stk;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		stk= new Stack(10);
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		stk=null;
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}
	
	@Ignore
	void testPush() 
	{
		stk.push(1);
		stk.push(2);
		assertEquals(2, stk.size());
		
		
		
	}

	@Ignore
	void testPop() {
		stk.pop();
		assertEquals(2, stk.size());
		
	}

	@Ignore
	void testPeek() {
	int b=stk.peek();
	assertEquals(2,b);
		
	}

	@Ignore
	void testSize() 
	{
		int a=stk.size();
		assertEquals(2, a);
		
	}

	@Test
	void testIsEmpty() {
		stk.isEmpty();
		assertEquals(0, stk.size());
		
	}

	@Ignore
	void testIsFull() {
		stk.isFull();
		assertEquals(2, stk.size());
		
	}

}
