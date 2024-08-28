package org.MobileApplication.TestUtils;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BaseTest {
		public AndroidDriver driver;
		public UiAutomator2Options option;
		public AppiumDriverLocalService service;

		
		@BeforeTest
		
	public void configureAppium() throws MalformedURLException, URISyntaxException
	{
		service = new AppiumServiceBuilder().withAppiumJS(new File("C://Users//atulk//AppData//Roaming//npm//node_modules//appium//build//lib//main.js"))
		.withIPAddress("127.0.0.1").usingPort(4723).build();
	
		option = new UiAutomator2Options();
		option.setDeviceName("Atul Kumar");
		option.setPlatformName("Android");
        driver = new AndroidDriver(new URI("http://127.0.0.1:4723/").toURL(),option);
      
	}	
		
		@AfterTest
		
	public void tearDown()
	{
		driver.quit();
		service.stop();
	}  
						
}
