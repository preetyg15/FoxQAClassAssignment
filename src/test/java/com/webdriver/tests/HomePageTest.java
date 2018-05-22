package com.webdriver.tests;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.webdriver.pages.AllShows;
import com.webdriver.pages.ExcelDriven;
import com.webdriver.pages.HomePage;
import com.webdriver.pages.Login;
import com.webdriver.pages.Shows;
import com.webdriver.utils.TestBase;

//import junit.framework.Assert;

public class HomePageTest extends TestBase {

	public static Logger log = LogManager.getLogger(TestBase.class.getName());
	public static WebDriver driver;

	@BeforeTest

	public void initialize() throws IOException {
		driver = initializeDriver();
	}

	@Test(dataProvider = "getData")
	public void loginFox(String Username, String Password, String Text) throws IOException, InterruptedException {
		driver.get(prop.getProperty("url"));
		log.info("navigate to home page");
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		Thread.sleep(10000);
		// LoginButton click
		// String Username = prop.getProperty("UserName");
		// String Password = prop.getProperty("Password");
		Login signin = new Login(driver);

		signin.LoginClick(Username, Password);
		System.out.println(Text);
		log.info(Text);
		// Assert.assertTrue(signin.LoginClick(Username, Password),"User failed to log
		// in");
		// driver.close();
	}

	@AfterTest
	public void teardown() {
		driver.close();
		// driver = null;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// Both parametrisation and datadriving can be achieved with dataprovider in
	// testng
	@DataProvider
	public Object[][] getData() {
		// Row--how many different data types text should run
		// column stands for how many values per each text--3
		Object[][] data = new Object[2][3];
		// 0th row
		data[0][0] = "non restricted user";// username
		data[0][1] = "1223";// password//
		data[0][2] = "restricted user";// text
		// 1st row
		data[1][0] = " restricted user";
		data[1][1] = "45678";
		data[1][2] = "non restricted user";

		return data;

	}

	// public static WebDriver driver;

	public static String[][] datafx = new String[4][1];

	public static String[][] dataFoxSports = new String[4][1];

	public static String[][] dataNationalGeo = new String[4][1];

	public static String[][] dataAllShows = new String[4][1];

	public static int row = 0;

	// @Test(testName = "TC-1", priority = 1, enabled = true)

	public void initialize1() throws IOException, InterruptedException

	{

		// Initialize

		driver = initializeDriver();

		// Login Button click

		String Username = prop.getProperty("UserName");

		String Password = "Password";

		Login signin = new Login(driver);

		signin.LoginClick(Username, Password);

		driver.close();

		driver = initializeDriver();

		// Shows Button click

		HomePage page = new HomePage(driver);

		page.showsClick();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		Thread.sleep(3000);

		JavascriptExecutor jse = (JavascriptExecutor) driver;

		jse.executeScript("window.scrollBy(0,40000)");

		Thread.sleep(8000);

	}

	@Test(testName = "TC-2", priority = 2, enabled = true)

	public void updateDataMovies() throws IOException, InterruptedException

	{

		String xlsFilePath = prop.getProperty("xlsFilePath");

		String Sheetname = "Sheet1";

		Shows sh = new Shows(driver);

		String[][] obj = sh.movies();

		ExcelDriven excel = new ExcelDriven();

		excel.updateXLSRow(xlsFilePath, Sheetname, obj);

	}

	@Test(testName = "TC-12", priority = 12, enabled = true)

	public void allShowsPage() throws InterruptedException {

		// AllShows button click

		AllShows allshow = new AllShows(driver);

		allshow.allShowsClick();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		Thread.sleep(3000);

		JavascriptExecutor jse = (JavascriptExecutor) driver;

		for (int second = 0;; second++) {

			if (second >= 60) {

				break;

			}

			jse.executeScript("window.scrollBy(0,800)", ""); // y value '800' can be altered

			Thread.sleep(3000);

		}

		Thread.sleep(5000);

	}

	@Test(testName = "TC-13", priority = 13, enabled = true, dataProvider = "getData")

	public void testDataAllShows(String movie) throws InterruptedException, IOException {

		String xlsFilePathnew = prop.getProperty("xlsFilePathnew");

		String Sheetname = "Sheet1";

		AllShows allshow = new AllShows(driver);

		String str = allshow.moviesVerify(movie, Sheetname, xlsFilePathnew);

		int col = 0;

		if (str != null)

		{

			dataAllShows[row][col] = str;

			row++;

			System.out.println("DataAllShowsArray" + str + row);

		}

	}

	@Test(testName = "TC-14", priority = 14, enabled = true)

	public void duplicateAllShows()

	{

		if (dataAllShows[0][0] != null)

		{

			String xlsFilePath = prop.getProperty("xlsFilePathnew");

			String Sheetname = "Sheet1";

			ExcelDriven excel = new ExcelDriven();

			excel.updateXLSRow(xlsFilePath, Sheetname, dataAllShows);

		}

	}

	// @DataProvider

	/*
	 * public static Object[][] getData() throws Exception {
	 * 
	 * String xlsFilePath=prop.getProperty("xlsFilePath");
	 * 
	 * String Sheetname="Sheet1";
	 * 
	 * ExcelDriven excel=new ExcelDriven();
	 * 
	 * Object[][] data =excel.getCellData(xlsFilePath,Sheetname);
	 * 
	 * return data;
	 * 
	 * }
	 */

}
