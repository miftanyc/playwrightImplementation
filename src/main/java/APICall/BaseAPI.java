package APICall;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.microsoft.playwright.APIRequest;
import com.microsoft.playwright.APIRequestContext;
import com.microsoft.playwright.Playwright;

public class BaseAPI {
	
	public APIRequestContext apiContext;
	
	
	
	@BeforeClass
	public APIRequestContext initializeAPIConncetion() {
	
		Playwright pw = Playwright.create();
		APIRequest apiRequest = pw.request();
		apiContext = apiRequest.newContext();
		return apiContext;
	}
	

	@AfterClass
	public void disposeAPIConnection() {
		apiContext.dispose();
		
	}
}
