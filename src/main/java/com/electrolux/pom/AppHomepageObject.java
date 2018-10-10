package com.electrolux.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;

public class AppHomepageObject {
	private AppiumDriver<MobileElement> driver;
	
	public AppHomepageObject(AppiumDriver<MobileElement> driver) {
		
		this.driver = driver;
	}
	
	public void navigateToLoginPage(){
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement continueButton = wait.until(ExpectedConditions
				.visibilityOfElementLocated((MobileBy.xpath("//android.view.View[@content-desc=\"CONTINUE\"]"))));
		
		continueButton.click();
	}

}
