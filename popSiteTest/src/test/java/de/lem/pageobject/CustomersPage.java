package de.lem.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CustomersPage {

  private final WebDriver driver;

  @FindBy(id = "names:customerTable_data")
  private WebElement customers;

  public CustomersPage(final WebDriver driver) {
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

  public List<WebElement> getCustomers() {
    return customers.findElements(By.xpath("tr"));
  }

  public boolean isPresent(final String customer) {
    for (final WebElement customerRow : getCustomers()) {
      System.out.println("Customer: '" + customerRow.getText() + "'");
      if (customerRow.getText().equals(customer)) {
        return true;
      }
    }
    return false;
  }

  public CustomerDialog clickCusomer(final String name) {
    for (final WebElement customerRow : getCustomers()) {
      System.out.println("Customer: '" + customerRow.getText() + "'");
      if (customerRow.getText().equals(name)) {
        customerRow.click();
      }
    }
    return PageFactory.initElements(driver, CustomerDialog.class);
  }
}
