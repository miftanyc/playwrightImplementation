package lesson;


		// Video Recording of Test


import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Browser.NewContextOptions;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.AriaRole;

public class Session28 {
  
	public static void main(String[] args) {
		
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
      
     
		NewContextOptions nco = new NewContextOptions();
      		nco.setRecordVideoDir(Paths.get(System.getProperty("user.dir")+"/Video/"));
      		nco.setRecordVideoSize(640, 480);
      	BrowserContext context = browser.newContext(nco);
      		//or			   browser.newContext(new Browser.NewContextOptions().setRecordVideoDir(Paths.get(System.getProperty("user.dir")+"/Video/")).setRecordVideoSize(640, 480));
   
      
      	Page page = context.newPage();
      	page.navigate("https://tutorialsninja.com/demo/");
      
      	page.getByPlaceholder("Search").click();
      	page.getByPlaceholder("Search").fill("hp");
     
      	page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("")).click();
      	page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Products meeting the search criteria")).click();
      	page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("HP LP3065")).first().click();
      	page.getByText("Stop your co-workers in their tracks with the stunning new 30-inch diagonal HP L").click();
      	page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("HP LP3065")).click();
      	page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("$122.00")).click();
      	page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add to Cart")).click();
      	page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName(" 1 item(s) - $122.00")).click();
      	page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName(" View Cart")).click();
      	page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName(" My Account")).click();
      	page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Login")).click();
    
      	
      	context.close();
      	page.close();
      	playwright.close();
      }
  }
