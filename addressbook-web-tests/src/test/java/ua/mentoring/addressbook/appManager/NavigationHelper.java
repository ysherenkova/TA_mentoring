package ua.mentoring.addressbook.appManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class NavigationHelper extends HelperBase{

  public NavigationHelper(WebDriver driver) {
    super(driver);
  }

  public void groupPage() {
    if (isElementPresent(By.tagName("h1"))
            && driver.findElement(By.tagName("h1")).getText().equals("Groups")
           && isElementPresent(By.name("new"))) { return;}
      click(By.xpath("/html/body/div/div[3]/ul/li[3]/a"));
  }

  public void gotoHomePage() {
    if (isElementPresent(By.name("maintable"))) {return; }
    click(By.xpath("//*[@id=\"nav\"]/ul/li[1]/a"));

  }
}
