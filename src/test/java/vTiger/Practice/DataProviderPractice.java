package vTiger.Practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderPractice 
{
	@Test(dataProvider="phones")
	
	public void sampleDataTest(String name,String model,int qty)
	{
		System.out.println(name + "<->"+ model + "<->" + qty);
	}
	
	@DataProvider(name="phones")
	public Object[][] getdata()
	{
		Object[][] data=new Object[5][3];
				
	  
		data[0][0]="Samsung";
		data[0][1]="A80";
		data[0][2]=10;
		
		data[1][0]="Redmi";
		data[1][1]="N35";
		data[1][2]= 20;

		data[2][0]="Realme";
		data[2][1]="Narzo50";
		data[2][2]=30;
		
		data[3][0]="Vivo";
		data[3][1]="A97";
		data[3][2]=40;
		
		data[4][0]="Oppo";
		data[4][1]="B20";
		data[4][2]=50;
						
		return data;
				
	}
	

}
