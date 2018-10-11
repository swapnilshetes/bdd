package com.electrolux.tests;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.electrolux.pom.AppHomepageObject;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import java.util.Date;


public class LoginTestAnrdroid {

	private AndroidDriver<MobileElement> driver;
	private AppHomepageObject appHomepage;
	
	static String NodePath="C:/Program Files/nodejs/node.exe";
	static String AppiumMainJS_path = "C:/Program Files (x86)/Appium/resources/app/node_modules/appium/build/lib/main.js";
	static AppiumDriverLocalService service;
	static SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
	
	

	@BeforeClass
	@Parameters({ "device", "app_package", "activity", "version", "appiumServer"  ,"port" , "dvudid"})
	public void deviceSetUp(String device, String app_package, String activity, String version, String appiumServer , int port, String dvudid)
			throws InterruptedException, MalformedURLException, InterruptedException {
		
		System.out.println("inside -----" );
		Thread.sleep(1000);
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, device);
		caps.setCapability(MobileCapabilityType.UDID, device);
		caps.setCapability(MobileCapabilityType.APP, "C:\\update-appium\\Test.apk");
		caps.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.ANDROID);
		caps.setCapability(MobileCapabilityType.VERSION, version);
		caps.setCapability("appWaitActivity","SplashActivity, SplashActivity,OtherActivity, *, *.SplashActivity");
		/*service = AppiumDriverLocalService.buildService( new AppiumServiceBuilder()
				.usingDriverExecutable (new File (NodePath))
				.withAppiumJS(new File(AppiumMainJS_path))
				);
	
		System.out.println("------>>"+service.getUrl());
		System.out.println(":: Starting Appium Server ::" + df.format(new Date())+ "\n **************************************");
		service.start();
		*/
			
		// Set job name
		driver = new AndroidDriver<MobileElement>(new URL(appiumServer), caps);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		System.out.println("*********************2************************" + driver);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement continueButton = wait.until(ExpectedConditions
				.visibilityOfElementLocated((MobileBy.xpath("//android.view.View[@content-desc=\"CONTINUE\"]"))));
		
		continueButton.click();

	}
	@Test
	@Given("^Customer is on the App Homepage on Android Device$")
	public void user_is_on_Home_Page() throws Throwable {
		System.out.println("*********************2************************" + driver);

		System.out.println("*****************************************************");
		System.out.println("Calling Home Page Class");

	}
	
	@Test
	@When("^Customer Navigates to the  Log in Page$")
	public void user_Navigate_to_LogIn_Page() throws Throwable {

		appHomepage.navigateToLoginPage();
	}
	
	@Test
	@When("^Enters Username and Password in the login fields$")
	public void user_enters_UserName_and_Password() throws Throwable {
		WebElement username = driver.findElementByXPath("//*[@class='android.widget.EditText'][1]");
		username.sendKeys("electrolux.test2018@gmail.com");
		WebElement password = driver.findElementByXPath("//*[@class='android.widget.EditText'][2]");
		password.sendKeys("Indecomm@123");
		WebElement login = driver.findElementByXPath("//android.view.View[@content-desc=\"LOG IN\"]");
		login.click();

		// WebDriverWait wait = new WebDriverWait(driver,1);
		// WebElement login =
		// wait.until(ExpectedConditions.visibilityOfElementLocated((MobileBy.xpath("//android.view.View[@text='LOG
		// IN']"))));
		// login.click();

		Thread.sleep(3000);
		// Write code here that turns the phrase above into concrete actions
		// throw new PendingException();
	}
	
	@Test
	@Then("^Successful login message is displayed on the dashboard page$")
	public void message_displayed_Login_Successfully() throws Throwable {
		// Write code here that turns the phrase above into concrete actions

		// throw new PendingException();
	}

	public static void main(String[] args) {
		
	}
}
