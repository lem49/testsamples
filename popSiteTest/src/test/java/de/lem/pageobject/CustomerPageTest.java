package de.lem.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.PageFactory;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;

@FixMethodOrder()
public class CustomerPageTest {

  private CustomersPage page;
  private WebDriver driver;
  private final static String LEONARD = "Leonard";

  @Before
  public void before() {
    final String driverPath = "C:\\Users\\marle_000\\Downloads\\";
    System.setProperty("webdriver.edge.driver", driverPath + "MicrosoftWebDriver.exe");
    driver = new EdgeDriver();

    page = PageFactory.initElements(driver, CustomersPage.class);
    page.open("http://localhost:8080/popSite/");
  }

  @After
  public void after() {
    page.close();
  }

  @Test
  public void isLeonardPresentExpectedTrue() throws InterruptedException {
    Thread.sleep(2000);
    Assert.assertTrue(page.isPresent(CustomerPageTest.LEONARD));
    Thread.sleep(2000);
    Assert.assertFalse(page.clickCusomer("").isDisplayed());
    Thread.sleep(2000);
    final CustomerDialog cd = page.clickCusomer(CustomerPageTest.LEONARD);
    Assert.assertTrue(cd.isDisplayed());
    Thread.sleep(2000);
    cd.close();
    Assert.assertFalse(cd.isDisplayed());
    Thread.sleep(2000);
    Assert.assertEquals("Simple Facelet", page.getTitle());
  }
}
