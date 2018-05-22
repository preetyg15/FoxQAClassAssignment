package com.webdriver.repository;

public class Locators {
//Login Locators
	/*public static final String Account_Sign_in = "//div[@class='Account_perksButtonContainer_3CaSA']/button[2]";
	public static final String User_Name="//input[@class='Account_signinField_mdMZF']";
	public static final String Password = "//div[@class='Account_signupPasswordContainer_3LRRa']/input";
	public static final String Sign_In_Tab="//div[@class='Account_signinButtonDesktop_2SO1g']//*[text()='Sign In']";*/
	
	//".Account_signIn_Q0B7n"----css selector
	//input[@name='signinEmail']---xpath
	//input[@name='signinPassword']--xpath
	

	//Login Locators

	public static final String Login_Tab = "//*[@id='path-1']"; //xpath

	public static final String Account_Sign_in =".Account_signIn_Q0B7n"; //cssSelector

	public static final String User_Name = "//input[@name='signinEmail']"; //xpath

	public static final String Password = "//input[@name='signinPassword']"; //xpath

	public static final String Sign_In_Tab =".Account_signinButtonDesktop_2SO1g > button:nth-child(1)";//cssSelector

	//HomePage Locators

	public static final String SHOWS = "//a[contains(@href,'/shows/')]";// xpath

	//public static final String Twenty_Four_Movie = "//a[@class='Tile_title_2XOxg MovieTile_title_1u6rs' and @href='/gordon-ramsays-24-hours-to-hell-back/']//child::div[1]";//xpath

	//Shows Locators

	public static final String FX = "//*[@class='PageHeaderBrowse_tab_19aN7 PageHeaderBrowseAltHeader_tab_2Lzol' and text()='FX']";// xpath

	//National Geographic Locators

	public static final String NATIONAL_GEOGRAPHIC = "//*[@class='PageHeaderBrowse_tab_19aN7 PageHeaderBrowseAltHeader_tab_2Lzol' and text()='National Geographic']";// xpath

	//Fox Sports Locators

	public static final String FOX_SPORTS = "//*[@class='PageHeaderBrowse_tab_19aN7 PageHeaderBrowseAltHeader_tab_2Lzol' and text()='FOX Sports']";// xpath

	//AllShows class locator

	public static final String ALLSHOWS = "//*[@class='PageHeaderBrowse_tab_19aN7 PageHeaderBrowseAltHeader_tab_2Lzol' and text()='All Shows']";// xpath

	
public static final String TITLE = "//span[@class='HomeSlideHeader_text_XnfMG']";


	
	
}
