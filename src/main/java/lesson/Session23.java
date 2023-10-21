package lesson;
	
	//Handling Alert, Pompt, and Confirm Using OnDialog Listener

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.BrowserType.LaunchOptions;

public class Session23 {

	static Page page;
	public static void main(String[] args) {

		Playwright pw = Playwright.create();
		LaunchOptions lo = new LaunchOptions();
			lo.setChannel("chrome");
			lo.setHeadless(false);
		Browser browser = pw.chromium().launch(lo);
		BrowserContext context = browser.newContext();
		page = context.newPage();
		
		//Create a listener for Alert
		page.onDialog(dialog ->{
			String text = dialog.message();
			System.out.println(text);
			dialog.accept("This String Part is only used when you use Pormpt Alert");
			//dialog.dismiss();
		});
		
		
		page.navigate("https://the-internet.herokuapp.com/javascript_alerts");
		
		//Write Method Here
		clickOnJSAlert();
		clickOnJSConfirm();
		clickOnJSPrompt();
		
		
		page.close();
		context.close();
		pw.close();

	}
	public static void clickOnJSAlert() {
		page.click("button[onclick='jsAlert()']");
		System.out.println(page.textContent("#result"));
	}

	public static void clickOnJSConfirm() {
		page.click("button[onclick='jsConfirm()']");
		System.out.println(page.textContent("#result"));
	}
	
	public static void clickOnJSPrompt() {
		page.click("button[onclick='jsPrompt()']");
		System.out.println(page.textContent("#result"));
	}

}
