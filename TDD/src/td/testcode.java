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
		result = strcalc.Add("1\n2,3");
		assertEquals(6, result);
		result = strcalc.Add("1\n2\n9");
		assertEquals(12, result);
		result = strcalc.Add("1353535\n24635346\n95634536");
		assertEquals(121623417, result);
		result = strcalc.Add("//;\n1;2");
		assertEquals(3, result);
		result = strcalc.Add("//'\n14'19");
		assertEquals(33, result);
		result = strcalc.Add("//%\n143532556%674543748");
		assertEquals(818076304, result);
	}
}