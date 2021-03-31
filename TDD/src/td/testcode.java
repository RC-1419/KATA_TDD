package td;
import org.junit.Test;
import static org.junit.Assert.*;

public class testcode {
	
	@Test
	public void test() {
		StringCalculator strcalc = new StringCalculator();
		int result = strcalc.Add("");
		assertEquals(0, result);
		result = strcalc.Add("1,2");
		assertEquals(3, result);
		result = strcalc.Add("143532556,674543748");
		assertEquals(818076304, result);
		result = strcalc.Add("14,19");
		assertEquals(33, result);
	}
}