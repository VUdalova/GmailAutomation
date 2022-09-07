import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import java.net.URL;


public class GmailAutomation {
    private static final String APPIUM = "http://localhost:4723/wd/hub";

    private AndroidDriver driver;

    @Before
    public void setUp() throws Exception {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("platformVersion", "9");
        caps.setCapability("deviceName", "emulator-5554");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("noReset", true);
        caps.setCapability("appPackage", "com.google.android.gm");
        caps.setCapability("appActivity", "com.google.android.gm.GmailActivity");
        driver = new AndroidDriver(new URL(APPIUM), caps);
    }

    @After
    public void afterTest() {
        driver.quit();
    }

    @Test
    public void loginToApp() {
        driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc=\"Open navigation drawer\"]")).click();
        WebElement element = driver.findElement(By.className("android.widget.TextView"));
        Assert.assertTrue(element.isDisplayed(), "Viktoria Udalova");
    }
}