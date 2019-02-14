package WriteReadBinaryfile;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class WriteAndReadTest {

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
	void testWriteData() {
		String s=WriteAndRead.writeData("C:\\Users\\user\\Desktop\\binary.bin");
		equals(s);
		
	}

	@Test
	void testReadData() {
		
		String s1=WriteAndRead.readData("C:\\Users\\user\\Desktop\\binary.bin");
		equals(s1);
		
	}

	@Test
	void testDeleteFile() {
		boolean s2=WriteAndRead.deleteFile("C:\\Users\\user\\Desktop\\binary.bin");
		equals(s2);		
	}

}
