package lesson;

//Learning Shadow DOM element manupulation

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Locator;

public class Session12 {
	
	static Page page;
	
	public static void main(String[] args) {
		Playwright pw = Playwright.create();
		
		LaunchOptions lo = new LaunchOptions();
		lo.setChannel("chrome");
		lo.setHeadless(false);
		Browser browser = pw.chromium().launch(lo);
		BrowserContext context = browser.newContext();
		page= context.newPage();
		
		
		//Write Method Here 
		shadowDOM1();
		
		
		
		
		page.close();
		context.close();
		pw.close();	

	}
	
	public static void shadowDOM1() {
		
		page.navigate("https://books-pwakit.appspot.com/");
		page.locator("book-app[apptitle='BOOKS'] input#input").fill("Science Friction");
		String text = page.locator("book-app[apptitle='BOOKS'] div.books-desc").textContent();
		System.out.println(text);
	}

}
