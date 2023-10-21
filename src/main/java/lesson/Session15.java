package lesson;

import java.util.List;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Locator;

public class Session15 {

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
		selectingElementByUsingElementWithinThisElement1();
		selectingElementByUsingElementWithinThisElement2();
		
		
		
		page.close();
		context.close();
		pw.close();	

	}
	
	public static void selectingElementByUsingElementWithinThisElement1() {
		page.navigate("https://www.orangehrm.com/en/30-day-free-trial/");
		Locator loc = page.locator("select#Form_getForm_Country:has(option[value='Afghanistan'])");
		List<String> getText = loc.allInnerTexts();
		System.out.println("All Text from OrangeHRM: ");
		getText.forEach(text-> System.out.println(text));
	}
	
	public static void selectingElementByUsingElementWithinThisElement2() {
		page.navigate("https://www.amazon.com/");
		Locator loc = page.locator("div.navFooterLinkCol :has-text('Careers')");
		List<String> getText = loc.allInnerTexts();
		System.out.println("All Text from Amazon Carrier Column: ");
		getText.forEach(text-> System.out.println(text));
	}
	
}
