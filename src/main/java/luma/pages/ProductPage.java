package luma.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import luma.base.TestBase;

public class ProductPage extends TestBase {
	
	@FindBy(xpath="//span[text()='Autumn Pullie']")
	WebElement itemName;
	
	@FindBy(xpath="//div[@option-id=\"169\"]")
	WebElement productSize;
	
	@FindBy(xpath="//div[@option-id=\"53\"]")
	WebElement productColor;
	
	@FindBy(xpath="//button[@title=\"Add to Cart\"]")
	WebElement addToCartBtn;
	
	@FindBy(xpath="//span[text()=\"$57.00\"]")
	WebElement productFinalPrice;
	
	@FindBy(xpath="//div[@class=\"messages\"]/div[1]")
	WebElement successMsg;
	
	@FindBy(xpath="//div[@data-block=\"minicart\"]")
	WebElement shoppingCart;
	
	@FindBy(xpath="//button[@id=\"top-cart-btn-checkout\"]")
	WebElement checkOutBtn;
	
	public ProductPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	public void productAtrribute(){
		productSize.click();
		productColor.click();	
	}
	
	
	public String productName() {
		String item=itemName.getText();
		return item;
	}
	
	
	public String productPrice() {
		String price=productFinalPrice.getText();
		return price;
	}
	
	
	public String addToCart() {
		addToCartBtn.click();
		String msg=successMsg.getText();
		System.out.println(msg);
		return msg;
	}
	
	
	public void miniCart() throws InterruptedException {
		shoppingCart.click();
		Thread.sleep(2000);
		checkOutBtn.click();
	}
	
	

}
