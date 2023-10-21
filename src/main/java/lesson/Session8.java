package lesson;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

//Learning Context

public class Session8 {
	
	public static void main(String[] args) {
		Playwright pw = Playwright.create();
		Browser browser = pw.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		
		BrowserContext context1 = browser.newContext();
		Page page1 = context1.newPage();
		page1.navigate("https://tutorialsninja.com/demo/");
		page1.fill("input[placeholder='Search']", "HP");
		page1.click("button[class='btn btn-default btn-lg']");
		System.out.println(page1.title());
		
		BrowserContext context2 = browser.newContext();
		Page page2 = context2.newPage();
		page2.navigate("https://www.amazon.com/");	
		page2.fill("#twotabsearchtextbox", "HP");
		page2.click("#nav-search-submit-button");
		System.out.println(page2.title());
		
		
		
	}

}
