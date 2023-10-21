package lesson;
	
	//nth Element Locator

import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;

public class Session18 {

	public static void main(String[] args) {
		
		Playwright pw = Playwright.create();
		LaunchOptions lo = new LaunchOptions();
			lo.setChannel("chrome");
			lo.setHeadless(false);
		Browser browser = pw.chromium().launch(lo);
		BrowserContext context = browser.newContext();
		Page page = context.newPage();
		
		page.navigate("https://www.bigbasket.com/");
		
		String fistElement = page.locator("div.pr-4 li a >> nth=0").innerText();
		String lastElement = page.locator("div.pr-4 li a >> nth=-1").innerText();
		String secondElement = page.locator("div.pr-4 li a >> nth=1").innerText();
		
		
		System.out.println("First Element: "+fistElement);
		System.out.println("Last Element: "+lastElement);
		System.out.println("Second Element: "+secondElement);
		
		
		page.close();
		context.close();
		pw.close();
	}
}
