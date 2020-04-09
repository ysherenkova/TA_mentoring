package qa.instagram.UI;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import qa.instagram.pages.MyAccountPage;
import qa.instagram.pages.MyFeedPage;
import qa.instagram.pages.SignInPage;
import qa.instagram.utils.FileDownloader;
import qa.instagram.utils.FileUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static qa.instagram.pages.SignInPage.createSignInPage;

public class SmokeTest extends BaseTest {

  @Test
  public void loginTest() {
    SignInPage signInPage = createSignInPage();
    signInPage.setLogin(testConfig.targetAccount());
    signInPage.setPassword(testConfig.targetPassword());
    MyFeedPage myFeedPage = signInPage.clickSignInButton();
    myFeedPage.turnOffNotifications();
    MyAccountPage myAccountPage = myFeedPage.clickAccountName();

    Map<WebElement, String> allPhotos = myAccountPage.getAllPhotos();
    Assert.assertEquals(allPhotos.size(), myAccountPage.getNumberOfPost());

    List<String> fileUrls = new ArrayList<>(allPhotos.values());
    FileDownloader downloader = new FileDownloader(testConfig.photoDownloaderThreadLimit());

    FileUtils.storeToFs(downloader, fileUrls, (new File(testConfig.galleryAddress()).getAbsolutePath()));
    Assert.assertEquals(allPhotos.size(), FileUtils.countFilesInDir(new File(testConfig.galleryAddress()).getAbsolutePath()));
  }
}
