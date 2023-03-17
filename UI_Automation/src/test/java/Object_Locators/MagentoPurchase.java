package Object_Locators;

import org.openqa.selenium.By;

public class MagentoPurchase {

	
	public static final By Final_Add_to_Cart= By.xpath("//*[@class='action primary tocart']");
	public static final By Checkout=By.xpath("//button[@id='top-cart-btn-checkout']");
	public static final By Address_next=By.xpath("//*[contains(text(),'Next')]");
	public static final By Order_Place=By.xpath("//*[contains(text(),'Place Order')]");
	public static final By Order_Number=By.xpath("//a[@class='order-number']");
	
	
}
