package org.MobileApplication.PageObject.android;

import java.time.Duration;
import java.util.List;

import org.MobileApplication.utils.ActionClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;

public class CartPage extends ActionClass {
	
AndroidDriver driver;
	
	public CartPage(AndroidDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="com.androidsample.generalstore:id/productPrice")
	private List<WebElement> productList;
	
	@FindBy(id="com.androidsample.generalstore:id/totalAmountLbl")
	private WebElement totalAmount;
	
	@FindBy(id="com.androidsample.generalstore:id/termsButton")
	public WebElement terms;
	
	@FindBy(id="android:id/button1")
	private WebElement acceptButton;
	
	@FindBy(id="com.androidsample.generalstore:id/btnProceed")
	private WebElement proceed;
	
	@FindBy(className="android.widget.CheckBox")
	WebElement checkBox;
	
	public List<WebElement> getProductList()
	{
		return productList;
	}
	
	public double getProductSum()
	{
		int count = productList.size();
		double totalSum = 0;
		for(int i=0;i<count;i++)
		{
			String price = productList.get(i).getText();
			double sum = getFormattedPrice(price);
			totalSum = totalSum + sum;
		}
		return totalSum;
	}
		
		public double expectedValue()
		{
			String amount = totalAmount.getText().substring(1);
			double expectedAmount = getFormattedPrice(amount);
			return expectedAmount;
		}
	public void clickCheckbox()
	{
		checkBox.click();
	}
	
	public void acceptTermCondition() throws InterruptedException
	{
		
		longPress(terms);
		acceptButton.click();
	}
	public void clickCompletePurchase()
	{
		proceed.click();
	}
	
	
	
	

	

}
