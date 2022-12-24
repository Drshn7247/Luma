package luma.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import luma.base.TestBase;
import luma.pages.CheckOutPage;
import luma.pages.HomePage;
import luma.pages.OrderSummaryPage;
import luma.pages.ProductPage;
import luma.pages.SearchedProductsPage;

public class LumaTest extends TestBase{
	HomePage homePage;
	SearchedProductsPage spp;
	ProductPage pp;
	CheckOutPage cop;
	OrderSummaryPage osp;
	String selectedItemName;
	String selectedprice;
	
	public LumaTest() {
		super();
	}
	
	@BeforeClass
	public void setUp() {
		initialization();
		homePage=new HomePage();
		spp=new SearchedProductsPage();
		pp=new ProductPage();
		cop=new CheckOutPage();
		osp=new OrderSummaryPage();
	}
	
	@Test(priority=1)
	public void selectSection() {
		homePage.selectCatagory();
	}
	
	
	@Test(priority=2)
	public void PerPageitems(){
		spp.selectPerPageItems();
	}
	
	
	@Test(priority=3)
	public void selectPrice(){
		spp.applyPriceFilter();;
	}
	
	
	@Test(priority=4)
	public void productSelection() {
		spp.selectProduct();
	}
	
	
	@Test(priority=5)
	public void selectProductDetails(){
		pp.productAtrribute();	
		selectedItemName=pp.productName();
		System.out.println("Product Selected name = "+selectedItemName);
		
		selectedprice=pp.productPrice();
		System.out.println("Product Selected price= "+selectedprice);
	}
	
	
	@Test(priority=6)
	public void productToCart() throws InterruptedException {
		Assert.assertEquals(pp.addToCart(), "You added Autumn Pullie to your shopping cart.");
		pp.miniCart();
	}
	
	
	@Test(priority=7)
	public void setfield() {
		cop.sendEmail(prop.getProperty("email"));
		
		cop.personalDetails(prop.getProperty("firstname"), prop.getProperty("lastname"),
				prop.getProperty("company"));
		
		cop.scrollDown();
		
		cop.address(prop.getProperty("street"), prop.getProperty("city"),
				prop.getProperty("zip"), prop.getProperty("number"));
		
		cop.selectCountry();
		cop.selectState();
		cop.shippingMethod();	
	}
	
	
	@Test(priority=8)
	public void checkProduct(){
		
		String finalProductName=osp.productCheck();
		System.out.println("Product in Invoice = "+finalProductName);
		
		Assert.assertEquals(finalProductName, selectedItemName);	
	}
	
	
	@Test(priority=9)
	public void checkProductprice() {
		
		String finalProductprice=osp.invoice();
		System.out.println("Invoice Price = "+finalProductprice);
		
		Assert.assertEquals(finalProductprice, selectedprice);	
	}
	
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
	

}
