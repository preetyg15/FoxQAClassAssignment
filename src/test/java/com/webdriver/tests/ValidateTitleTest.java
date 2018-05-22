package com.webdriver.tests;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.webdriver.pages.LandingPage;
import com.webdriver.utils.TestBase;

public class ValidateTitleTest extends TestBase {
	public static Logger log = LogManager.getLogger(TestBase.class.getName());
	public static WebDriver driver; 

	@Test
	public void validateTitle() throws IOException{
		driver = initializeDriver();
		//LoginButton click
		String title = prop.getProperty("Title");
		
		LandingPage lp = new LandingPage(driver);
		String actualTitle = lp.getTitle();
		AssertJUnit.assertEquals(actualTitle,title,"Presents");
		log.info("successfully validated the text message");
		//Assert.assertEquals(actualTitle,"Fox Presents","Strings are not matching");--->message is shown only when error message is thrown
		driver.close();
	}
	@AfterTest
	public void teardown() {
		driver.close();
		// driver = null;
	}

}
