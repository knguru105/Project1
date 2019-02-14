package DeterminantMatrix;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Ignore;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DeterminantTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testDeterminantOfMatrix()
	{
		int[][] mat={{1, 0, 2 }, 
                {3, 0, 0}, 
                {2, 1, 4}
                };
		int b=Determinant.determinantOfMatrix(mat, 3);
		assertEquals(6, b);
	}
	@Ignore
	
	void testGetCofactor() {
		fail("Not yet implemented");
	}
	
	@Ignore
	void testDisplay() {
		
		fail("Not yet implemented");
	}

}
