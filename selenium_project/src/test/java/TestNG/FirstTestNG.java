package TestNG;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FirstTestNG {
  @Test(priority = 3)
  public void testcase1() {
	  System.out.println("Test Case 1");
  }
  
  @Test(enabled = false)
  public void testcase2() { //skip the test case
	  System.out.println("Test Case 2");
  }
  @Test(priority = 1) 
  public void testcase3() {
	  System.out.println("Test Case 3");
  }
  @Test
  public void testcase4() {
	  System.out.println("Test Case 4");
  }
  @Test
  public void testcase5() {
	  System.out.println("Test Case 5");
  }
//  @BeforeMethod
//  public void beforeMethod() { //each time first check before method->normal 1st method->after method
//	  System.out.println("Before method is executed");
//  }
//  @AfterMethod
//  public void afterMethod() {
//	  System.out.println("After method is executed");
//  }
  
//  @BeforeClass
//  public void beforeClass() { //first run before method->All methods in class->after method
//	  System.out.println("Before class is executed");
//  }
//  @AfterClass
//  public void afterClass() {
//	  System.out.println("After class- executes all methods in class and after class is executed");
//  }
  
  @BeforeTest
  public void beforeTest() { 
	  //When run a package first run before test
	  //->All class in that package run randomly
	  //->after complete classes in package after test run
	  System.out.println("Before test -  is executed");
  }
  @AfterTest
  public void afterTest() {
	  System.out.println("After Test- All classes in a package is executed after test executes");
  }
  

//  @BeforeSuite
//  public void beforeSuit() { 
//	  //When run a package first run before test
//	  //->All class in that package run randomly
//	  //->after complete classes in package after test run
//	  System.out.println("Before Suite -  is executed");
//  }
//  @AfterSuite
//  public void afterSuit() {
//	  System.out.println("After Suit- is executed after the suit finish its execution");
//  }
  
}
