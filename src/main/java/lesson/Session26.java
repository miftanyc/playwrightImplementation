package lesson;

	// Change Screen Size

import java.awt.Dimension;
import java.awt.Toolkit;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Browser.NewContextOptions;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class Session26 {
	
	static Page page;
	
	public static void main(String[] args) throws InterruptedException {
		Playwright pw = Playwright.create();
		Browser browser = pw.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		
		NewContextOptions nco = new NewContextOptions();
		nco.setViewportSize(get_Width_of_Dimention(), get_Height_of_Dimention());
		
		BrowserContext contex = browser.newContext(nco);
					//or 		browser.newContext(new Browser.NewContextOptions().setViewportSize(get_Width_of_Dimention(), get_Height_of_Dimention()));
		page = contex.newPage();
		
		page.navigate("https://www.amazon.com");
		
		Thread.sleep(7000);
		
		page.close();
		contex.close();
		pw.close();
	
	}
	
	
	
	//Following Three Method are to get Heigh and Width of Your ScreenSize
	public static Dimension get_Screen_Dimension() {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		return screenSize;
	}

	public static int get_Width_of_Dimention() {
		Dimension screenSize = get_Screen_Dimension();
		double width = screenSize.getWidth(); 	//You have to convert it to intiger
		int widthInInt = (int)width;
		return widthInInt;
	}
	
	public static int get_Height_of_Dimention() {
		Dimension screenSize = get_Screen_Dimension();
		double height = screenSize.getHeight();  //You have to convert it to intiger
		int heightInInt = (int)height;
		return heightInInt;
	} 
}
