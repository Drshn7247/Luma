package luma.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import luma.base.TestBase;

public class HomePage extends TestBase{
	
	@FindBy(xpath="//span[text()='Women']")
	WebElement womenSection;
	
	@FindBy(xpath="//a[@id=\"ui-id-9\"]")
	WebElement womenTops;
	
	@FindBy(xpath="//span[text()='Hoodies & Sweatshirts']")
	WebElement womenHoodies;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public void selectCatagory() {
		Actions act=new Actions(driver);
		act.moveToElement(womenSection)
		.moveToElement(womenTops)
		.moveToElement(womenHoodies).click().build().perform();
	}

}
