package BizCover.UI_Automation;

import java.util.List;
import java.util.concurrent.TimeUnit;

// TODO Auto-generated method stub
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import Object_Locators.MagentoPurchase;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class MagentoPurchaseSteps {

	public WebDriver driver;
	JavascriptExecutor js;
	By Quantity = By.xpath("(//input[@title='Qty'])");
	By Product_Item_Link = By.xpath("(//*[@class='product-item-link'])[1]");
	By Add_To_Cart = By.xpath("//*[@title='Add to Cart']");

	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver",
				"/Users/Vaibhav/Documents/Vaibhav_Assignement/chromedriver_win32/chromedriver.exe");
		driver = new ChromeDriver();
	}

	@After
	public void teardown() {
		driver.quit();
	}

	@Given("^I am on the Magento website$")
	public void i_am_on_the_Magento_website() throws Throwable {
		driver.get("https://magento.softwaretestingboard.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);

	}

	@When("^I login with valid credentials$")
	public void i_login_with_valid_credentials() throws Throwable {
		WebElement signInLink = driver.findElement(By.linkText("Sign In"));
		signInLink.click();

		WebElement emailField = driver.findElement(By.id("email"));
		emailField.sendKeys("vgajjar727@gmail.com");

		WebElement passwordField = driver.findElement(By.id("pass"));
		passwordField.sendKeys("Vaibhav@74");

		WebElement loginButton = driver.findElement(By.id("send2"));
		loginButton.click();
	}

	@And("^I add (\\d+) Men's Tops - Jackets and (\\d+) Men's Bottoms - Pants to the cart$")
	public void i_add_Men_s_Tops_Jackets_and_Men_s_Bottoms_Pants_to_the_cart(int numTops, int numBottoms)
			throws Throwable {
		WebElement menLink = driver.findElement(By.linkText("Men"));
		menLink.click();
		WebElement jacketsLink = driver.findElement(By.linkText("Jackets"));
		jacketsLink.click();

		WebElement Product1 = driver.findElement(Product_Item_Link);
		Product1.click();
		WebElement first_Jacket = driver
				.findElement(By.xpath("(//*[@class='swatch-option text'][contains(text(),'XS')])[1]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", first_Jacket);
		first_Jacket.click();
		Thread.sleep(4000);
		WebElement count = driver.findElement(Quantity);
		count.clear();
		count.sendKeys("2");

		WebElement Colour = driver.findElement(By.xpath("//*[@aria-label='Black']"));
		Colour.click();

		WebElement AddtoCart = driver.findElement(Add_To_Cart);
		AddtoCart.click();
		driver.get("https://magento.softwaretestingboard.com/men.html");
		// Thread.sleep(3000);

		WebElement topsLink = driver.findElement(By.linkText("Tops"));
		topsLink.click();

		js = (JavascriptExecutor) driver;

		WebElement top1 = driver.findElement(By.xpath("(//img[@class='product-image-photo'])[2]"));
		top1.click();
		WebElement first_Top = driver
				.findElement(By.xpath("(//*[@class='swatch-option text'][contains(text(),'M')])[1]"));
		first_Top.click();
		js.executeScript("window.scrollBy(0,250)", "");
		WebElement Colour1 = driver.findElement(By.xpath("//*[@aria-label='Blue']"));
		Colour1.click();

		WebElement AddtoCart1 = driver.findElement(MagentoPurchase.Final_Add_to_Cart);
		js.executeScript("arguments[0].click();", AddtoCart1);
		Thread.sleep(5000);

	}

	@And("^I proceed to checkout$")
	public void i_proceed_to_checkout() throws Throwable {
		WebElement myCart = driver.findElement(By.xpath("//a[@class='action showcart']"));
		myCart.click();
		WebElement proceedToCheckout = driver.findElement(MagentoPurchase.Checkout);
		proceedToCheckout.click();
		WebElement Next = driver.findElement(MagentoPurchase.Address_next);
		js.executeScript("arguments[0].click();", Next);
		WebElement place_Order = driver.findElement(MagentoPurchase.Order_Place);
		js.executeScript("arguments[0].click();", place_Order);
		WebElement Order = driver.findElement(MagentoPurchase.Order_Number);
		Order.click();
	}

	@And("^I verify the order summary$")
	public void i_verify_the_order() throws Throwable {
		List<WebElement> orders = driver.findElements(By.xpath("//*[@class='product name product-item-name']"));

		if (!orders.isEmpty()) {

			System.out.println("Order is placed");
		} else {
			System.out.println("Order is Not placed");
		}
	}
}
