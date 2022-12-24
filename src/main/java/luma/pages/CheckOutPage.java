package luma.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import luma.base.TestBase;

public class CheckOutPage extends TestBase{
	
	@FindBy(xpath="//fieldset[@id=\"customer-email-fieldset\"]/div/div/input")
	WebElement emailField;
	
	@FindBy(xpath="//form[@class=\"form form-shipping-address\"]/div/div[1]/div/input")
	WebElement firstName;
	
	@FindBy(xpath="//form[@class=\"form form-shipping-address\"]/div/div[2]/div/input")
	WebElement lastName;
	
	@FindBy(xpath="//form[@class=\"form form-shipping-address\"]/div/div[3]/div/input")
	WebElement companyName;
	
	@FindBy(xpath="//form[@class=\"form form-shipping-address\"]/div/div[4]/div/input")
	WebElement cityName;
	
	@FindBy(xpath="//form[@class=\"form form-shipping-address\"]/div/div[7]/div/input")
	WebElement zipCode;
	
	@FindBy(xpath="//form[@class=\"form form-shipping-address\"]/div/div[9]/div/input")
	WebElement phoneNumber;
	
	@FindBy(xpath="//fieldset[@class=\"field street admin__control-fields required\"]/div/div/div/input")
	WebElement streetName;
	
	@FindBy(xpath="(//select[@class=\"select\"])[1]")
	WebElement stateName;
	
	@FindBy(xpath="(//select[@class=\"select\"])[2]")
	WebElement countryName;
	
	@FindBy(xpath="(//input[@type=\"radio\"])[2]")
	WebElement flatRateBtn;
	
	@FindBy(xpath="//span[text()='Next']")
	WebElement nextBtn;
	
	
	public CheckOutPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void sendEmail(String mail) {
		emailField.sendKeys(mail);
	}
	
	public void personalDetails(String name,String last,String company) {
		firstName.sendKeys(name);
		lastName.sendKeys(last);
		companyName.sendKeys(company);
	}
	
	public void scrollDown() {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView", zipCode);
	}
	
	public void address(String street, String city, String zip, String no) {
		streetName.sendKeys(street);
		cityName.sendKeys(city);
		zipCode.sendKeys(zip);
		phoneNumber.sendKeys(no);
	}
	
	public void selectCountry() {
		countryName.click();
		Select country=new Select(countryName);
		country.selectByValue("IN");
	}
	
	public void selectState() {
		stateName.click();
		Select state=new Select(stateName);
		state.selectByValue("553");	
	}
	
	public void shippingMethod() {
		boolean flag=flatRateBtn.isSelected();
		if(flag!=true) {
			flatRateBtn.click();
		}
		else {
			System.out.println("Already Selected");
		}
		
		nextBtn.click();
		
	}

}
