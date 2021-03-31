package td;
import org.junit.Test;
import static org.junit.Assert.*;

public class testcode {
	
	@Test
	public void test() {
		StringCalculator strcalc = new StringCalculator();
		int result = strcalc.Add("H");
		assertEquals(0, result);
		result = strcalc.Add("");
		assertEquals(0, result);
	}
}