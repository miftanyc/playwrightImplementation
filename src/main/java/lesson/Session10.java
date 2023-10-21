package lesson;

import java.util.List;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class Session10 {
	
	static Page page;
	
	public static void main(String[] args) {
		
		Playwright pw = Playwright.create();
		Browser browser = pw.chromium().launch(
				new BrowserType.LaunchOptions().setHeadless(false));
		BrowserContext context = browser.newContext();
		page = context.newPage();
		
		
		//Type Metho here to run
		//textSelector1();
		textSelector2();
		
		
		
		
//		page.close();
//		context.close();
//		pw.close();

	}
	
	public static void textSelector1() {
		page.navigate("https://demo.opencart.com/");
		Locator macBook = page.locator("'MacBook'");
		macBook.click();
		
		page.goBack();
		
		Locator components = page.locator("text=Components");
		int howManyComponent = components.count();
		System.out.println("Total Component Element: "+ howManyComponent);
		List<String> innertTextComponents = components.allInnerTexts(); //or
//		List<String> innertTextComponents = components.allTextContents();
		for(String innertTextComponent : innertTextComponents) {
			System.out.println(innertTextComponent);
		}
		
	}
	
	public static void textSelector2() {
		page.navigate("https://demo.opencart.com/");
		page.click("'My Account'");
		page.click("'Login'");
		
		//Varify Present of New Customer
		String newCustomerHeader = page.textContent("div#account-login h2:has-text('New Customer')");
		System.out.println("Header for New Customer: "+ newCustomerHeader);
		
		//login Now with Invalid Username and Parssword
		page.fill("input#input-email", "deeronTest@monkey.com");
		page.fill("input#input-password", "123456");
		page.click("form#form-login button:has-text('Login')");
	}
	

}
