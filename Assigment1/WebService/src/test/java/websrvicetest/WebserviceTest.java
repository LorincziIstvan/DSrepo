package websrvicetest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import edu.utcn.ds.lab1.webservice.TimeZoneServlet;

public class WebserviceTest {
	
	private String prefix="<xml><timezone><time>";
	private String sufix="</time><zone>asd</zone></timezone></xml>";

	
	@Test
	public void testWebService(){
		String expected=prefix+"0"+sufix;
		assertEquals(expected,TimeZoneServlet.calculateResult("181"));
		expected=prefix+"-12"+sufix;
		assertEquals(expected,TimeZoneServlet.calculateResult("12"));
		expected=prefix+"11"+sufix;
		assertEquals(expected,TimeZoneServlet.calculateResult("350"));
		
		
		
	}
}
