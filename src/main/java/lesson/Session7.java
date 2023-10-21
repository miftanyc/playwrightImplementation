package lesson;

import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.Tracing;
import com.microsoft.playwright.options.AriaRole;

public class Session7 {
  public static void main(String[] args) {
    try (Playwright playwright = Playwright.create()) {
      Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
        .setHeadless(false));
      BrowserContext context = browser.newContext();
   
   // Start tracing before creating / navigating a page.
      context.tracing().start(new Tracing.StartOptions()
        .setScreenshots(true)
        .setSnapshots(true)
        .setSources(true));
      
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
    
   // Stop tracing and export it into a zip archive.
      context.tracing().stop(new Tracing.StopOptions()
        .setPath(Paths.get(System.getProperty("user.dir")+"/Tracing/trace.zip")));
    }
  }
}

	/*
	 To Read teh tracing file go to webpage "https://trace.playwright.dev/" and upload the tracing file to this webpage. 
	 It will show read this zip file and show the progress with screenshot.
	 */
