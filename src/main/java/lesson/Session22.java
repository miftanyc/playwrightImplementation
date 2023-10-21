package lesson;

	//Storing Login Json to Login Later Using Joson File Without Using Login Script Again

import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.BrowserType.LaunchOptions;

public class Session22 {
	
	static Playwright pw;
	static Page page;
	static Browser browser;
	static BrowserContext context;
	
	public static void main(String[] args) {
		pw = Playwright.create();
		LaunchOptions lo = new LaunchOptions();
			lo.setChannel("chrome");
			lo.setHeadless(false);
		browser = pw.chromium().launch(lo);
		
		
		//Write Method Here
		//First Create the Login Json File
//		create_Login_Json_File();
		using_Login_json_To_Stay_Login_Without_Using_Login_Steps();
		
		
		

	}
	
	public static void create_Login_Json_File() {
		context = browser.newContext();
		page = context.newPage();
		page.navigate("https://tutorialsninja.com/demo/");
		
		page.click("i.fa-user");
		page.click("a:text('Login')");
		page.fill("input#input-email", "miftanyc+qa@gmail.com");
		page.fill("input#input-password", "123456");
		page.click("input[value='Login']");
		
		context.storageState(new BrowserContext.StorageStateOptions().setPath(Paths.get(System.getProperty("user.dir")+"\\LoginContext\\Login.json")));
		page.close();
		context.close();
		pw.close();
	}
	
	public static void using_Login_json_To_Stay_Login_Without_Using_Login_Steps() {
		context = browser.newContext(new Browser.NewContextOptions().setStorageStatePath(Paths.get(System.getProperty("user.dir")+"\\LoginContext\\Login.json")));
		page = context.newPage();
		page.navigate("https://tutorialsninja.com/demo/");
	}

}
