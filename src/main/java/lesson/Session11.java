package lesson;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.FrameLocator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

// handling iframe, frame
public class Session11 {
	
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
//		frameHandling();
		iframeHandling();
		
		
		
		
		page.close();
		context.close();
		pw.close();	
		
	}
	
	public static void frameHandling() {
		
		page.navigate("http://www.londonfreelance.org/courses/frames/");
		String header1 = page.frameLocator("frame[name='main']").locator("//h2[text()='Title bar ']").textContent();
		System.out.println("Titl bar inside the Frame reader as: "+header1);
		
		//if frame has Name Attribute it can be written as follow
		String header2=page.frame("main").locator("frame h2:has-text('Title bar ')").textContent();
		System.out.println("Titl bar inside the Frame reader that has name attribute : "+header2);
		
	}
	
	public static void iframeHandling() {
		
		page.navigate("https://www.formsite.com/templates/registration-form-templates/vehicle-registration-form/");
		page.click("img[title='Vehicle-Registration-Forms-and-Examples']");
		FrameLocator iframe = page.frameLocator("//iframe[contains(@id,frame-one)]");
		iframe.locator("input#RESULT_TextField-1").fill("Nayla Nilon");
		iframe.locator("input#RESULT_TextField-3").fill("yemen");
		iframe.locator("textarea#RESULT_TextArea-5").fill("Writing Test Message Here in Description Box");
		
	}
}
