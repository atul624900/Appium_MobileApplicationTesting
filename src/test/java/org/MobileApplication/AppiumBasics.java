package org.MobileApplication;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.time.Duration;
import org.MobileApplication.PageObject.android.CartPage;
import org.MobileApplication.PageObject.android.FormPage;
import org.MobileApplication.PageObject.android.ProductCatalog;
import org.MobileApplication.TestUtils.BaseTest;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class AppiumBasics extends BaseTest{
	

	@DataProvider(name="getData")
	public Object[][] getDate()
	{
		return new Object [][]  {{"GeneralStore","Brazil","Atul Kumar","male"}};
	}
@Test(dataProvider="getData")
public void AppiumTest(String appName,String country,String name,String gender) throws MalformedURLException, URISyntaxException, InterruptedException
{
	 
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	FormPage form = new FormPage(driver);
	driver.findElement(AppiumBy.accessibilityId(appName)).click();
	form.selectCountry(country);
	form.setName(name);
	form.setGender(gender);
	ProductCatalog product = form.submitTheForm();
	//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	
	product.addItemToCartByIndex(0);
	product.addItemToCartByIndex(0);
	product.goToCartPage();
	CartPage cart =new CartPage(driver);
	double expectedAmount = cart.expectedValue();
	double actualAmount = cart.getProductSum();
	Assert.assertEquals(expectedAmount, actualAmount);
	System.out.println(expectedAmount +" "+actualAmount);
	cart.clickCheckbox();
	cart.acceptTermCondition();
	cart.clickCompletePurchase();
	
	
	
	
	}



	
}
