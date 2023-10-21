package lesson;

	//Downloading Files

import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Download;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class Session25 {

	static Page page;
	
	public static void main(String[] args) {
		Playwright pw = Playwright.create();
		Browser browser = pw.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		BrowserContext contex = browser.newContext();
		page = contex.newPage();
		
		page.navigate("https://chromedriver.storage.googleapis.com/index.html?path=114.0.5735.90/");
		
		Download download = page.waitForDownload(() -> {
			download_A_File();
		});
		System.out.println("Download File URL: "+download.url());
		System.out.println("Download File page title: "+download.page().title());
		System.out.println("Where in the System File Downloaded: "+download.path().toString());
		
		//Change the Storage location of Downloaded File
		download.saveAs(Paths.get(System.getProperty("user.dir")+"\\Download\\chromium.zip"));
		
		//To check the Given File name is Applied to file
		System.out.println(download.suggestedFilename());
		
		
		page.close();
		contex.close();
		pw.close();
	
	}
	
	public static void download_A_File() {
		page.click("a:text('chromedriver_win32.zip')");
	}

}
