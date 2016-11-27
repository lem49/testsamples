package de.lem.pageobject;

import org.hamcrest.core.StringContains;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.PageFactory;

public class GoogleSearchTest {
	
	private GoogleSearchPage page;
	private WebDriver driver;
	
	@Before
	public void before(){
		String driverPath = "C:\\Users\\marle_000\\Downloads\\";
		System.setProperty("webdriver.edge.driver", driverPath + "MicrosoftWebDriver.exe");
		driver = new EdgeDriver();
//		page = PageFactory.initElements(new PhantomJSDriver(), GoogleSearchPage.class);
		
		page = PageFactory.initElements(driver, GoogleSearchPage.class);
		page.open("http://google.de");
	}
	
	@After
	public void after(){
		page.close();
	}
	
	@Test
	public void search() throws Exception{
		System.out.println("Title: " + page.getTitle());
		System.out.println("typing search");
		page.typeSearchTerm("selenium");
//		Thread.sleep(2000);
		System.out.println("startSearch");
		page.clickOnSearch();
//		Thread.sleep(2000);
		System.out.println("assert title");
//		page.searchFor("selenium");
		Assert.assertThat(page.getTitle(), StringContains.containsString("selenium"));
	}

}
