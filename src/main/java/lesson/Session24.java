package lesson;

		/*To upload a File Web Element in webpage must have [input type='file'] this attribute.
		if type=file is not available you can not use playwright to upload the file
		In that case Ask your developer to Update this information
		
		
		Learning on Uploading and Removing File
		
		*/

import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.FilePayload;

public class Session24 {

	static Page page;
	
	public static void main(String[] args) throws InterruptedException {
		Playwright pw = Playwright.create();
		Browser browser = pw.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		BrowserContext contex = browser.newContext();
		page = contex.newPage();
		
		page.navigate("https://davidwalsh.name/demo/multiple-file-upload.php");
		
		
		//Write Your Method Here
		Thread.sleep(2000);
		uploading_Single_File();
		
		Thread.sleep(5000);
		remove_Uploaded_File();
		
		Thread.sleep(5000);
		uploading_Multiple_File();
		
		Thread.sleep(5000);
		remove_Uploaded_File();
		
		Thread.sleep(5000);
		create_A_File_And_Upload_It();
		
		Thread.sleep(10000);
		
		
		page.close();
		contex.close();
		pw.close();
	
	}
	
	public static void uploading_Single_File() {
		page.setInputFiles("input#filesToUpload", Paths.get("C:\\Test Engineer\\Eclipse IDE\\Workspace\\PlaywrightProject\\Notes\\InspectorCommand.txt"));
	}
	
	public static void uploading_Multiple_File() {
		page.setInputFiles("input#filesToUpload", new Path[] {
													Paths.get("C:\\\\Test Engineer\\\\Eclipse IDE\\\\Workspace\\\\PlaywrightProject\\\\Notes\\\\InspectorCommand.txt"),
													Paths.get("C:\\Test Engineer\\Eclipse IDE\\Workspace\\PlaywrightProject\\Notes\\Selectors.txt"),
													Paths.get("C:\\Test Engineer\\Eclipse IDE\\Workspace\\PlaywrightProject\\Tracing\\trace.zip"),
												});
	}
	
	public static void remove_Uploaded_File() {
		page.setInputFiles("input#filesToUpload", new Path[0]);
	}
	
	
	public static void create_A_File_And_Upload_It() {	
		page.navigate("https://cgi-lib.berkeley.edu/ex/fup.html");
		
		page.setInputFiles("input[name='upfile']", new FilePayload("Test.text", "text/plain", "This File is Created to Upload".getBytes(StandardCharsets.UTF_8)));
		page.click("input[value='Press']");
	}
}
