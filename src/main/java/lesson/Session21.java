package lesson;

	//Handling Dynamic Table

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Locator;

public class Session21 {

	static Page page;
	public static void main(String[] args) {

		Playwright pw = Playwright.create();
		LaunchOptions lo = new LaunchOptions();
			lo.setChannel("chrome");
			lo.setHeadless(false);
		Browser browser = pw.chromium().launch(lo);
		BrowserContext context = browser.newContext();
		page = context.newPage();
		
		page.navigate("https://datatables.net/extensions/select/examples/initialisation/checkbox.html");
		
		//Write Method Here
		get_How_Many_Row_Of_a_Table();
		select_Checkbox_Of_A_Targeted_Name("Ashton Cox");
		printout_Table_Information();
		
		
		
		page.close();
		context.close();
		pw.close();

	}
	
	public static void get_How_Many_Row_Of_a_Table(){
		Locator tableRow = page.locator("table#example tr");
		System.out.println("Total Number of row: "+ tableRow.count());
	}
	
	public static void select_Checkbox_Of_A_Targeted_Name(String userName) {
		Locator tableRow = page.locator("table#example tr");
		tableRow.locator(":scope", new Locator.LocatorOptions().setHasText(userName)).locator(".select-checkbox").click();
		
	}
	
	public static void printout_Table_Information() {
		Locator tableRow = page.locator("table#example tr");
		tableRow.locator(":scope").allInnerTexts().forEach(e->System.out.println(e));
	}

}
