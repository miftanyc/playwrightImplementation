package lesson;

	//Locator using right-of, left-of, above, below, near

import java.util.List;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class Session17 {

	static Page page;
	public static void main(String[] args) {
		
		Playwright pw = Playwright.create();

		LaunchOptions lo= new LaunchOptions();
			lo.setChannel("chrome");
			lo.setHeadless(false);
		Browser browser = pw.chromium().launch(lo);
		BrowserContext context = browser.newContext();
		page = context.newPage();
		
		page.navigate("https://selectorshub.com/xpath-practice-page/");
		
		
		//Write Method Here
		
		//Following are userName | Joe.Root | Garry.White | Jasmine.Morgan | Jordan.Mathews | John.Smith |
		//For Joe.Root
		checkBoxSelectionUsingLeftOfSelector("Joe.Root");
		System.out.println(getRoleUsingrightOffSelector("Joe.Root"));
		
		System.out.println(getAboveUserUsingAboveSelector("Joe.Root"));
		System.out.println(getBelowUserUsingBelowSelector("Joe.Root"));
		getNearUserUsingNearSelector("Joe.Root");
		
		
		//For Garry.White
		checkBoxSelectionUsingLeftOfSelector("Garry.White");
		System.out.println(getRoleUsingrightOffSelector("Garry.White"));
		
		//For Jasmine.Morgan
		checkBoxSelectionUsingLeftOfSelector("Jasmine.Morgan");
		System.out.println(getRoleUsingrightOffSelector("Jasmine.Morgan"));
		
		//For Jordan.Mathews
		checkBoxSelectionUsingLeftOfSelector("Jordan.Mathews");
		System.out.println(getRoleUsingrightOffSelector("Jordan.Mathews"));
		
		//For John.Smith
		checkBoxSelectionUsingLeftOfSelector("John.Smith");
		System.out.println(getRoleUsingrightOffSelector("John.Smith"));
		
		
		
		
		
		page.close();
		context.close();
		pw.close();

	}
	
	public static void checkBoxSelectionUsingLeftOfSelector(String userName) {
		page.locator(("input[type='checkbox']:left-of(a:text('"+ userName +"'))")).first().click();
		//or page.locaor(("input[type='checkbox']:left-of(:has-text('Joe.Root'))"));
		
	}
	
	public static String getRoleUsingrightOffSelector(String userName) {
		String userRole = page.locator("td:right-of(a:text('"+ userName +"'))").first().textContent();
		userRole = userName +" user roll is: "+ userRole;
		return userRole;
	}
	
	public static String getAboveUserUsingAboveSelector(String userName) {
		String aboveUser = page.locator("a:above(a:text('"+userName+"'))").first().textContent();
		aboveUser = aboveUser+ " is ABOVE of " + userName;
		return aboveUser;
	}

	
	public static String getBelowUserUsingBelowSelector(String userName) {
		String belowUser = page.locator("a:below(a:text('"+userName+"'))").first().textContent();
		belowUser = belowUser+ " is Below of " + userName;
		return belowUser;
	}
	
	public static void getNearUserUsingNearSelector(String userName) {
		List<String> elementSOfNearUser = page.locator("td:near(a:text('"+userName+"'), 120)").allTextContents();
		for (String ele: elementSOfNearUser) {
			ele = ele+ " is within 120 Pixel near of " + userName;
			System.out.println(ele);
		}
	}
}
