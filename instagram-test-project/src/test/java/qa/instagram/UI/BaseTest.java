package qa.instagram.UI;

import org.aeonbits.owner.ConfigFactory;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import qa.instagram.core.WebDriverFactory;
import qa.instagram.utils.TestConfig;


public class BaseTest {
  protected static final TestConfig testConfig = ConfigFactory.create(TestConfig.class);

  @BeforeClass
  public static void beforeMethod() {
    WebDriverFactory.create(WebDriverFactory.BROWSER_CHROME);
    WebDriverFactory.getDriver().get(testConfig.siteUrl()); //get = open page
  }

  @AfterClass//(alwaysRun = true)
  public static void afterMethod() {
    WebDriverFactory.tearDown();
  }
}
