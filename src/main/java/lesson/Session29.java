package lesson;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class Session29 {

	static Playwright pw;
	static Browser br;
	static BrowserContext ctx;
	static Page page;
	
	public static void main(String[] args) {
		initialize_Browser();
		
		handling_Popup_Tab();
		
		create_A_NewTab_A_Navigate_A_Webpage();
		
		close_Browser();
	}
	
	
	public static void handling_Popup_Tab() {
		page.navigate("https://www.orangehrm.com/");
		
		Page popup = page.waitForPopup(() -> {
			page.click("img[alt='facebook logo']");
		});
		popup.waitForLoadState();	//Wait for element to appear
		System.out.println("Title of Popup Window: "+popup.title());
		popup.close();
		System.out.println("Title of Main Window: "+page.title());
		
	}
	
	
	public static void create_A_NewTab_A_Navigate_A_Webpage() {
		
		Page blankTab = page.waitForPopup(() -> {
		page.click("a[target='_blank']");
			//This will open a Blank New tab
		});
		blankTab.waitForLoadState();	//Wait for element to appear
		blankTab.navigate("https://www.google.com/");
		System.out.println("Tile of BlankTab Navigated Webpage: "+blankTab.title());
		blankTab.close();
	}
	
	
	public static void initialize_Browser() {
		pw = Playwright.create();
		br = pw.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		ctx = br.newContext();
		page= ctx.newPage();
	}
	
	
	public static void close_Browser() {
		page.close();
		ctx.close();
		pw.close();
	}
	
}
