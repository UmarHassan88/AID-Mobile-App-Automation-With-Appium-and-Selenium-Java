package Pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Random;

public class Setup {
    public static AppiumDriver driver;
    public static WebDriverWait wait;
    @BeforeSuite
    public void setUpSuite() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setCapability("ignoreHiddenApiPolicyError", true);
        options.setCapability("noReset", true);
        options.setDeviceName("sdk_gphone64_x86_64");
        options.setUdid("emulator-5554");
        options.setPlatformName("Android");
        options.setPlatformVersion("16");
        options.noReset();
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.aqary.investment");
        options.setAppActivity("com.aqary.aqary_mobile_whitelabel.MainActivity");
        driver = new AndroidDriver(new URL("http://localhost:4723"), options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    @AfterSuite
    public void tearDownSuite() {
        if (driver != null) {
            driver.quit();
        }
    }

    public void clickElement(By locator){
        WebElement elem = wait.until(ExpectedConditions.elementToBeClickable(locator));
        elem.click();
    }
    public int randomGenerator(){
        Random rand = new Random();
        int num = rand.nextInt(95);
        return num;
    }
    public WebElement waitElem(By locator){
        WebElement fn = wait.until(ExpectedConditions.elementToBeClickable(locator));
        fn.click();
        return fn;

    }
}
