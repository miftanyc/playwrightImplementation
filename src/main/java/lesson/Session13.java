package lesson;


/*Learning Visible Element Filtering
	 	Either by "Tagname:visible"				ie "button:visible"
	 	or by "Tagname >> visible=true"			ie "button >> visible=true"
	 	or "text=targeText >> visible = true"	ie "text=login >> visible = true"
	 */


import java.util.List;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.BrowserType.LaunchOptions;

public class Session13 {
	
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
		visibileElement();
		
		
		
		
		page.close();
		context.close();
		pw.close();	

	}
	public static void visibileElement() {
		System.out.println("----------- All Link in it webpage --------------------");
		page.navigate("https://www.amazon.com/");
		List<String> innerTexts = page.locator("a:visible").allInnerTexts();
		for(String innerText : innerTexts ) {
			if(innerText.length()>0)
			System.out.println(innerText);
		}
		
		System.out.println("----------- Link With Amazon Word in it --------------------");
		List<String> innerTextsWithAmazonWord = page.locator("a:has-text('Amazon')").allInnerTexts();
		for(String innerTextWithAmazonWord : innerTextsWithAmazonWord ) {
			if(innerTextWithAmazonWord.length()>0)
			System.out.println(innerTextWithAmazonWord);
		}
		
		int imageCount = page.locator("//img >> visible=true").count();
		System.out.println("Total image in this webpage: "+imageCount);
		
	}
}
