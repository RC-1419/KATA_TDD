package td;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Assert;

public class testcode {

	@Test
	public void test() {
		StringCalculator strcalc = new StringCalculator();
		int result = strcalc.Add("");
		assertEquals(0, result);
		result = strcalc.Add("1,2");
		assertEquals(3, result);
		result = strcalc.Add("143532556,674543748");
		assertEquals(0, result);
		result = strcalc.Add("14,19");
		assertEquals(33, result);
		result = strcalc.Add("1\n2,3");
		assertEquals(6, result);
		result = strcalc.Add("1\n2\n9");
		assertEquals(12, result);
		result = strcalc.Add("1353535\n24635346\n95634536");
		assertEquals(0, result); 
		result = strcalc.Add("//;\n1;2");
		assertEquals(3, result);
		result = strcalc.Add("//'\n14'19");
		assertEquals(33, result);
		result = strcalc.Add("//%\n143532556%674543748");
		assertEquals(0, result);
		result = strcalc.Add("1000,2");
		assertEquals(1002, result);
		result = strcalc.Add("1001,1002");
		assertEquals(0, result);
		result = strcalc.Add("1000,1002");
		assertEquals(1000, result);
		result = strcalc.Add("100,1002");
		assertEquals(100, result);
		result = strcalc.Add("1,2,3,4");
		assertEquals(10, result);
		result = strcalc.Add("//;\n1;2");
		assertEquals(3, result);
		result = strcalc.Add("//[***]\n1***2***3");
		assertEquals(6, result);
		result = strcalc.Add("//[???]\n1???2???3");
		assertEquals(6, result);
		result = strcalc.Add("//[###]\n1###2###3");
		assertEquals(6, result);
		result = strcalc.Add("//[%%%]\n1%%%2000%%%3");
		assertEquals(4, result);
		result = strcalc.Add("//[%%%]\n1%%%1000%%%3");
		assertEquals(1004, result);
		result = strcalc.Add("//[%][#]\n1%1001#3");
		assertEquals(4, result);
		result = strcalc.Add("//[*][%]\n1*2%3");
		assertEquals(6, result);
		result = strcalc.Add("//[*][%]\n100*258%3000");
		assertEquals(358, result);
		RuntimeException exception = null;
		try {
			strcalc.Add("-1,2");
		}
		catch (RuntimeException e) {
	        exception = e;
	    }
	    Assert.assertEquals("negatives not allowed- -1 ", exception.getMessage());
	    try {
			strcalc.Add("-1,-2");
		}
		catch (RuntimeException e) {
	        exception = e;
	    }
	    Assert.assertEquals("negatives not allowed- -1 -2 ", exception.getMessage());
	}
}