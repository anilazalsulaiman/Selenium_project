package TestNG;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterClass {
  @Test
  @Parameters({"param","param1"}) //select only testng annotation
  public void testParameter(int a,String name) {
	  System.out.println(a);
	  System.out.println(name);
  }
}
