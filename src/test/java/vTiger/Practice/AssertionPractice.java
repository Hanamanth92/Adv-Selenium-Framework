package vTiger.Practice;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertionPractice 
{

	@Test
	public void test()
	{
		System.out.println("Step-1");
		System.out.println("Step-2");
		System.out.println("Step-3");
		Assert.assertEquals(false, true);
		System.out.println("Step-4");
		System.out.println("Step-5");
		System.out.println("Step-6");
	}
	
	@Test
	public void test1()
	{
		SoftAssert sa=new SoftAssert();
		System.out.println("Step-1");
		System.out.println("Step-2");
		
		sa.assertEquals(false, true);
		
		System.out.println("Step-3");
		System.out.println("Step-4");
		System.err.println("Step-5");
		System.out.println("step-6");
		
		sa.assertAll();
	}
	
}
