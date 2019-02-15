package Assignment2;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Stack;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class WordReverseTest {
	private static WordReverse word;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		word=new WordReverse();
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		word=null;
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testWordReverse() {
		String str="I LOVE MY INDIA";
		String str1=word.wordReverse(str);
		assertNotNull(str1);
	}

}
