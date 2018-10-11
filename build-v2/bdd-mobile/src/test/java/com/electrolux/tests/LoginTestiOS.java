package com.electrolux.tests;

import org.openqa.selenium.WebElement;

//import com.indecomm.api.AppiumDriverContext;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.AppiumDriver;

public class LoginTestiOS {

	@Given("^User is on Home Page on iOS$")
	public void user_is_on_Home_Page_on_iOS() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		//driver=AppiumDriverContext.getDriver("iOS");
		
		//WebElement Countinue = driver.findElementByXPath("//*[@text='CONTINUE']");
		//Countinue.click();
	}

	@When("^User Navigate to LogIn Page on iOS$")
	public void user_Navigate_to_LogIn_Page_on_iOS() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		

	}

	@When("^User enters UserName and Password on iOS$")
	public void user_enters_UserName_and_Password_on_iOS() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		//WebElement username=driver.findElementByXPath("//*[@placeholder='Email Address']");
		//username.sendKeys("devemerald@electrolux.com");
		//WebElement password=driver.findElementByXPath("//*[@placeholder='Password']");
		//password.sendKeys("Bhasha23@");
		
	}

	@Then("^Message displayed Login Successfully on iOS$")
	public void message_displayed_Login_Successfully_on_iOS() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		
		/*WebElement login=driver.findElementByXPath("//*[@text='LOG IN']");
		login.click();
		
		WebElement Appliances=driver.findElementByXPath("//*[@text='APPLIANCES']");
		Appliances.click();*/

	}

	
	
}
