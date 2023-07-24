package TestNG;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderClass {
	
	@DataProvider (name = "data-provider")
	public Object[][] dpMethod(){
		return new Object[][] {{2, 3 }, {5, 7},{10,15}}; //single test case run multiple times
	}
	
  @Test(dataProvider ="data-provider" )
  public void testCase(int a,int b) 
  {
  System.out.println(a+b);
  }
}
