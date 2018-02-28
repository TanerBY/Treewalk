package treewalk.treewalk;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import junit.framework.TestCase;

public class AppTest extends TestCase {
	
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private String expectedOutcome = "Alfred Hitchcock (A9)\r\n" + 
			"|Cary Grant (A8)\r\n" + 
			"||\\-Peter Lorre (A6)\r\n" + 
			"||\\-Toshiro Mifune (A7)\r\n" + 
			"||Hedy Lamarr (A6)\r\n" + 
			"|||\\-Marie Dressler (A6)\r\n" + 
			"|||Yul Brynner (A6)\r\n" + 
			"||||\\-Waheeda Rehman (A5)\r\n" + 
			"||||Robert Donat (A4)\r\n" + 
			"|||||\\-Lionel Barrymore (A3)\r\n" + 
			"|||\\-Meena Kumari (A1)\r\n" + 
			"|||\\-Hema Malini (A1)\r\n" + 
			"|Grace Kelly (A8)\r\n" + 
			"||\\-Omar Sharif (A7)\r\n" + 
			"|\\-Jean Harlow (A8)\r\n" + 
			"|Vivien Leigh (A8)\r\n" + 
			"||Steve McQueen (A7)\r\n" + 
			"|||\\-Montgomery Clift (A6)\r\n" + 
			"|||\\-Alain Delon (A6)\r\n" + 
			"|||\\-Ethel Waters (A6)\r\n" + 
			"|||\\-Anna May Wong (A6)\r\n" + 
			"||\\-Doris Day (A7)\r\n" + 
			"||\\-Carole Lombard (A6)\r\n" + 
			"||\\-Sidney Poitier (A4)\r\n";

	
	public void testApp() {
		System.setOut(new PrintStream(outContent));
		App.main(null);
		assertEquals(expectedOutcome, outContent.toString());
	}
}
