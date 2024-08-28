package org.MobileApplication.PageObject.android;

import java.util.List;

import org.MobileApplication.utils.ActionClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;

public class ProductCatalog extends ActionClass{
AndroidDriver driver;

	@FindBy(xpath = "//android.widget.TextView[@text='ADD TO CART']")
	private List<WebElement> addToCart;
	
	@FindBy(id = "com.androidsample.generalstore:id/appbar_btn_cart")
	private WebElement cart;
	
	
	
	public ProductCatalog(AndroidDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void addItemToCartByIndex(int index)
	{
		addToCart.get(index).click();
	}
	
	public void goToCartPage()
	{
		cart.click();
	}

}
