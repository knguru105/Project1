package Omniwyse.com.Selection_sort;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class Selection_sortTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSelection_sort() {
		int[] arr= {3,5,4,8,6,9,2,-1,7};
		Selection_sort s=new Selection_sort();
		int[] expResult= {-1,2,3,4,5,6,7,8,9};
		int[] actualResult= s.selectionSort(arr);
		assertArrayEquals(expResult, actualResult);	
	}

}
