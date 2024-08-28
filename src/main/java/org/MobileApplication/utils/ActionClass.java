package org.MobileApplication.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class ActionClass {
	
	AndroidDriver driver;
	public ActionClass(AndroidDriver driver)
	{
		
		this.driver = driver;
	}
	
	public void longPress(WebElement ele) 
	{
		((JavascriptExecutor)driver).executeScript("mobile: longClickGesture",              
				 ImmutableMap.of("elementId",((RemoteWebElement) ele).getId(),
				                "duration",2000));
		
	}
	
	public void scroll(WebElement ele2)
	{
		((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
				"elementId",((RemoteWebElement)ele2).getId(),
			    "direction", "down",
			    "percent", 1.0
			));
		
	}
	
	public void scrollToElement(String country)
	{
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+country+"\"));")).click();
	}
	
	
	protected Double getFormattedPrice(String price) 
	{
		String formattedprice = price.substring(1);
		Double newValue = Double.parseDouble(formattedprice);
		return newValue;
	}
	
	
	

}
