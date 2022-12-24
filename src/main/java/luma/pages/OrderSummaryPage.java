package luma.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import luma.base.TestBase;

public class OrderSummaryPage extends TestBase {
	
	@FindBy(xpath="//td[@data-th='Order Total']//span[1]")
	WebElement orderTotal;
	
	@FindBy(xpath="//div[@class=\"product-item-name-block\"]/strong")
	WebElement cartProductName;
	
	@FindBy(xpath="(//div[@role='tab'])[2]/strong")
	WebElement viewCart;
	
	
	public OrderSummaryPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String invoice() {
		String invoiceTotal=orderTotal.getText();
		System.out.println(invoiceTotal);
		return invoiceTotal;
	}
	
	public String productCheck() {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", viewCart);
		String addedProduct=cartProductName.getText();
		return addedProduct;
	}

}
