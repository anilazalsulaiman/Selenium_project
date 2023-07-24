package TestNG;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GroupingClass {
  @Test(groups = {"critical"})
  public void test1() {
	  System.out.println("test1");
  }
  @Test(groups = {"high"})
  public void test2() {
	  System.out.println("test2");
  }
  @Test(groups = {"low"})
  public void test3() {
	  System.out.println("test3");
  }
  @Test
  public void test4() {
	  System.out.println("test4");
  }
  @Test
  public void test5() {
	  System.out.println("test5");
  }
  @BeforeMethod(alwaysRun = true)
  public void beforeMethod() {
	  System.out.println("before method execute");
  }
  @AfterMethod(alwaysRun = true)
	public void afterMethod() {
		System.out.println("after method execute");
	}
  
}
