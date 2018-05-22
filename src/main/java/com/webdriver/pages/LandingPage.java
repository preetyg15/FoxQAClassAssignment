package com.webdriver.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.webdriver.repository.Locators;

public class LandingPage {
	
	 public LandingPage(WebDriver driver)
	 {
	   this.driver=driver;
	 }
	  
	
	public WebDriver driver;
	 @FindBy(how = How.XPATH, using = Locators.TITLE)
	 public WebElement title;

	public String getTitle() {
		 PageFactory.initElements(driver, this);
		 WebDriverWait wait = new WebDriverWait(driver,30);
		return title.getText();
	}
	/*public WebElement getTitle() {
		 PageFactory.initElements(driver, this);
		 WebDriverWait wait = new WebDriverWait(driver,30);
		return title;
	}*/
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
