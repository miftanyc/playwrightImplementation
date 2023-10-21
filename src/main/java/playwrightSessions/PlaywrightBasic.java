package playwrightSessions;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class PlaywrightBasic {

	public static Playwright playwright;
	public static Browser browser = null;
	
	public static void main(String[] args) {
		
		initializeBrowser();
		tearDown();
		closePlaywrightConnection();
		
	}
	
	
	public static void initializeBrowser() {
		
		String browserName = "chromium";
		//String browserType = "chrome";
		String url = "https://www.amazon.com";
		
		playwright = Playwright.create();
		
	
		LaunchOptions lp = new LaunchOptions();
		//lp.setChannel(browserType);
		lp.setHeadless(false);
		
		if(browserName.equalsIgnoreCase("chromium")) {
			browser = playwright.chromium().launch(lp);
		}else if (browserName.equalsIgnoreCase("firefox")) {
			browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
		}else if (browserName.equalsIgnoreCase("webkit")) {
			browser = playwright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(false));
		}
		BrowserContext context = browser.newContext();
		Page page = context.newPage();
		page.navigate(url);
		
		
//		page.pause();// To open INSPECTOR or PWDEBUG from following Line
		
		
		String retrievedTitle = page.title();
		String retrievedURL = page.url();
		System.out.println("Title of the page: "+ retrievedTitle);
		System.out.println("URL of the page: "+retrievedURL);

	}
	
	public static void tearDown() {
		
		browser.close();
		
	}
	public static void closePlaywrightConnection() {
		
		playwright.close();
		
	}

}
