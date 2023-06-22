package vTiger.Practice;

import org.testng.annotations.Test;

public class ReadDataFromCmdLine 
{

	@Test
	public void read()
	{
		String BROWSER=System.getProperty("browser");
		System.out.println(BROWSER);
		
		String URL=System.getProperty("URL");
		System.out.println(URL);
	}
}
