package q1006;

import static org.junit.Assert.*;

import org.junit.Test;

public class MainTest {

	@Test
	public void test() {
//		fail("Not yet implemented");
		int result = Main.calculate(4, 5, 6, 7);
		System.out.println(result);
		assertTrue(result == 19575);
	}

}
