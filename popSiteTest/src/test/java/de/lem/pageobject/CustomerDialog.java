package de.lem.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CustomerDialog {

  @FindBy(id = "customerDialog:customerDialog")
  private WebElement dialog;

  private final WebDriver driver;

  public CustomerDialog(final WebDriver driver) {
    this.driver = driver;
  }

  public boolean isDisplayed() {
    return dialog.isDisplayed();
  }

  public void close() {
    dialog.findElement(By.className("ui-dialog-titlebar-close")).click();;
  }

}
