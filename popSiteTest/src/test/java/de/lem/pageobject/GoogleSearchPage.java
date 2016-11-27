package de.lem.pageobject;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GoogleSearchPage {

  protected WebDriver driver;

  @FindBy(name = "q")
  private WebElement searchField;

  @FindBy(name = "btnG")
  private WebElement searchButton;

  public GoogleSearchPage(final WebDriver driver) {
    this.driver = driver;
  }

  public void open(final String url) {
    driver.get(url);
  }

  public void close() {
    driver.quit();
  }

  public String getTitle() {
    return driver.getTitle();
  }

  public void searchFor(final String searchTerm) {
    typeSearchTerm(searchTerm);
    clickOnSearch();
    // searchField.sendKeys(searchTerm);
    // searchButton.click();
  }

  public void typeSearchTerm(final String searchTerm) {
    searchField.sendKeys(searchTerm);
    waitForAjax();
  }

  public void clickOnSearch() {
    searchButton.click();
  }

  private void waitForAjax() {
    boolean finish = false;
    while (!finish) {
      // finish = (Boolean)((JavascriptExecutor)driver).executeScript("return jQuery.active == 0");
      finish = "complete".equals(
          ((JavascriptExecutor) driver).executeScript("return document.readyState").toString());
      System.out.println("finished: " + finish);
    }
  }
}
