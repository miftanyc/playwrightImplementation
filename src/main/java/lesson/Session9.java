package lesson;

import java.util.List;

// learning creating WebElement locator

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class Session9 {

	public static void main(String[] args) {
		
//		sigleElement(); 
//		nthElement();
//		multipleElement();
		
	}
	
	public static void sigleElement() {

		Playwright pw = Playwright.create();
		Browser browser = pw.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		BrowserContext context = browser.newContext();
		Page page = context.newPage();
		page.navigate("https://tutorialsninja.com/demo/");
		
		//Single Elment
		Locator component = page.locator("//a[text()='Components']");
		Locator monitor = page.locator("//a[text()='Monitors (2)']");
		component.hover();
		monitor.click();
		
		page.close();
		context.close();
		pw.close();
		
	}
	
	public static void nthElement() {

		Playwright pw = Playwright.create();
		Browser browser = pw.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		BrowserContext context = browser.newContext();
		Page page = context.newPage();
		page.navigate("https://tutorialsninja.com/demo/");
		
		//Multiple locator found with this text option
		Locator component = page.locator("text= Components");
		int totalElement = component.count();
		System.out.println("Total Component Element Found: "+totalElement);
		
		component.first().hover(); //or
//		component.nth(0).hover();

		Locator monitor = page.locator("//a[text()='Monitors (2)']");
		monitor.click();
		
		page.close();
		context.close();
		pw.close();
		
	}
	
	public static void multipleElement() {
		Playwright pw = Playwright.create();
		Browser browser = pw.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		BrowserContext context = browser.newContext();
		Page page = context.newPage();
		page.navigate("https://www.orangehrm.com/en/30-day-free-trial");
		
		//Multiple locator found with this text option
		Locator countryOptions = page.locator("select#Form_getForm_Country option");
		int totalElement = countryOptions.count();
		System.out.println("Total Component Element Found: "+totalElement);
		
		//Method 1: country List using for loop
		System.out.println("All The Country using For loop are: ");
		for(int i=0; i<totalElement; i++) {
			String contryName = countryOptions.nth(i).textContent(); // one by one capture textContent
			System.out.print(contryName);
		}
		
		//Method2" country List using ForEach loop
		List<String> countryList = countryOptions.allTextContents(); //Capture All textContent
		System.out.println("All Coutry in for Each Loop are: ");
		for(String country:countryList) {
			System.out.println(country);
		}

		//Method 3: country List using For Lamda loop
		System.out.println("All Coutry in for Lamda Loop are: ");
		countryList.forEach(element-> System.out.println(element));
		
		
		page.close();
		context.close();
		pw.close();
	}

}
