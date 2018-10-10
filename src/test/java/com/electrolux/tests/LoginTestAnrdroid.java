package com.electrolux.tests;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.electrolux.pom.AppHomepageObject;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class LoginTestAnrdroid {

	private AndroidDriver<MobileElement> driver;
	private AppHomepageObject appHomepage;

	@BeforeTest
	@Parameters({ "device", "app_package", "activity", "version", "appiumServer" })
	public void deviceSetUp(String device, String app_package, String activity, String version, String appiumServer)
			throws InterruptedException, MalformedURLException, InterruptedException {
		
		System.out.println("inside -----" );
		Thread.sleep(1000);
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("appium-version", "1.8.1");
		caps.setCapability("platformName", Platform.ANDROID);
		caps.setCapability("deviceName", "AndyWin");
		caps.setCapability(MobileCapabilityType.APP, "C:\\update-appium\\Test.apk");
		caps.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.ANDROID);
		caps.setCapability(MobileCapabilityType.VERSION, version);
		caps.setCapability("appWaitActivity","SplashActivity, SplashActivity,OtherActivity, *, *.SplashActivity");
		Thread.sleep(1000);
		// Set job name
		driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
	
		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		/*WebDriverWait driverWait;

		int timeoutInSeconds = 60;
*/		// must wait at least 60 seconds for running on Sauce.
		// waiting for 30 seconds works locally however it fails on Sauce.
//		driverWait = new WebDriverWait(driver, timeoutInSeconds);

//		WebElement continueButton = driverWait.until(ExpectedConditions
//				.visibilityOfElementLocated((MobileBy.xpath("//android.view.View[@content-desc=\"CONTINUE\"]"))));
//		
		Thread.sleep(10000);	
		List continueButton = driver.findElementsByAccessibilityId("CONTINUE");
		System.out.println("Number of elements in the list "+continueButton.size());
		Thread.sleep(20000);
		//continueButton.click();

		// MobileElement continueButton = (MobileElement)
		// driver.findElementByAccessibilityId("CONTINUE");
		// continueButton.click();

		/*
		 * System.out.println(
		 * "*****************************************************");
		 * System.out.println("Setting up device and desired capabilities");
		 * DesiredCapabilities cap = DesiredCapabilities.android();
		 * cap.setCapability(MobileCapabilityType.DEVICE_NAME, "AndyWin");
		 * cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 120);
		 * cap.setCapability(MobileCapabilityType.APP,
		 * "C:\\update-appium\\Test.apk");
		 * cap.setCapability(MobileCapabilityType.PLATFORM_NAME,
		 * Platform.ANDROID); cap.setCapability(MobileCapabilityType.VERSION,
		 * version); URL url = new URL(appiumServer); driver = new
		 * AppiumDriver<WebElement>(url,cap);
		 * driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		 * //appHomepage = new AppHomepageObject(driver); Thread.sleep(4000);
		 * WebDriverWait wait = new WebDriverWait(driver,10); WebElement
		 * continueButton =
		 * wait.until(ExpectedConditions.visibilityOfElementLocated((MobileBy.
		 * xpath("//android.view.View[@content-desc=\"CONTINUE\"]"))));
		 * continueButton.click();
		 */

		// MobileElement continueButton = (MobileElement)
		// driver.findElementByAccessibilityId("CONTINUE");
		// continueButton.click();

		

	}

	@Given("^Customer is on the App Homepage on Android Device$")
	public void user_is_on_Home_Page() throws Throwable {
		System.out.println("*********************2************************" + driver);

		System.out.println("*****************************************************");
		System.out.println("Calling Home Page Class");

	}

	@When("^Customer Navigates to the  Log in Page$")
	public void user_Navigate_to_LogIn_Page() throws Throwable {

		appHomepage.navigateToLoginPage();
	}

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

	@Then("^Successful login message is displayed on the dashboard page$")
	public void message_displayed_Login_Successfully() throws Throwable {
		// Write code here that turns the phrase above into concrete actions

		// throw new PendingException();
	}

	public static void main(String[] args) {
		
	}
}
