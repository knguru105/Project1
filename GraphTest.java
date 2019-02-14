package Graph;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.Ignore;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GraphTest {
	private static Graph graph;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		graph=new Graph(5);
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		graph=null;
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testIsTree()
	{
		boolean b=graph.isTree();
		assertEquals(false, b);
		
	}
	@Ignore
	void testAddEdge() {
		fail("Not yet implemented");
	}

	@Ignore
	void testIsCyclicUtil() {
				
	}

}
