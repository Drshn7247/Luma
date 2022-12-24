package luma.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import luma.base.TestBase;

public class SearchedProductsPage extends TestBase{
	JavascriptExecutor js;
	Select items;
	
	@FindBy(xpath="(//select[@id=\"limiter\"])[2]")
	WebElement perPageLimiter;
	
	@FindBy(xpath="//div[text()=\"Price\"]")
	WebElement priceFilter;
	
	@FindBy(xpath="//span[text()='$50.00']")
	WebElement priceTagFilter;
	
	@FindBy(xpath="//div[@class=\"products wrapper grid products-grid\"]/ol/li[5]")
	WebElement autumnProduct;
	
	public SearchedProductsPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void selectPerPageItems() {
		js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView()", perPageLimiter);
		items=new Select(perPageLimiter);
		items.selectByValue("36");
	}
	
	public void applyPriceFilter() {
		js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView()", priceFilter);
		priceFilter.click();
		priceTagFilter.click();
	}
	
	public void selectProduct() {
		js.executeScript("arguments[0].scrollIntoView()", autumnProduct);
		autumnProduct.click();
	}

}
