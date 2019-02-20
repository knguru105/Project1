package Assignment2;

import static org.junit.jupiter.api.Assertions.*;
import java.util.LinkedList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;

public class MaintainCharacterTest {
	private static MaintainCharacter MAINTAIN_CHARS;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		MAINTAIN_CHARS = new MaintainCharacter();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		MAINTAIN_CHARS = null;
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testReadCharacters() {
		LinkedList<Character> list = MAINTAIN_CHARS.readCharacters("rajur");
		String reverse ="";
		for(Character character : list) {
			reverse +=character;
		}
		assertEquals("ruja", reverse);
	}

}