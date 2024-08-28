package org.MobileApplication.PageObject.android;

import org.MobileApplication.utils.ActionClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class FormPage extends ActionClass{
	
	AndroidDriver driver;
	
	public FormPage(AndroidDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "com.androidsample.generalstore:id/spinnerCountry")
	private WebElement dropDown;

	
	@FindBy(id="com.androidsample.generalstore:id/nameField")
	private WebElement nameField;
	
	@FindBy(id = "com.androidsample.generalstore:id/radioFemale")
	private WebElement female;
	
	@FindBy(id = "com.androidsample.generalstore:id/radioMale")
	private WebElement male;
	
	@FindBy(id = "com.androidsample.generalstore:id/btnLetsShop")
	private WebElement shopButton;
	
	public void selectCountry(String country)
	{
		dropDown.click();
		scrollToElement(country);
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+country+"\"));"));	
		
	}
	
	public void setName(String name)
	{
		nameField.click();
		nameField.sendKeys(name);
		driver.hideKeyboard();
	}
	
	public void setGender(String gender)
	{
		if(gender.equalsIgnoreCase("male"))
			male.click();
		else
			female.click();	
	}
	
	public ProductCatalog submitTheForm()
	{
		shopButton.click();
		return new ProductCatalog(driver);
	}
	
}
