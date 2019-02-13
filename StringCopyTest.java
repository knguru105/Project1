package StringProblem;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Ignore;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StringCopyTest {
	private static StringCopy stringcopy;
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		stringcopy=new StringCopy();
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		stringcopy=null;
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}
	
	@Test
	
	void test() {
		
		
		String j = stringcopy.stringCopy("Java","C program");
		assertEquals("Java", j);
	}


	@Ignore
	void test1() {
		
		
		String j = stringcopy.stringCopy("1","C program");
		assertEquals("Java", j);
	}
}
