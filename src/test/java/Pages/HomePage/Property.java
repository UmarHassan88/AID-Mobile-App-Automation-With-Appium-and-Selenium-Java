package Pages.HomePage;

import Pages.Login;
import Pages.Setup;
import Pages.SignUp;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Property extends Setup {

    @Test(priority = 1)
    public void propertySection() throws InterruptedException {
        Thread.sleep(1000);
        Assert.assertTrue(driver.findElement(By.xpath("(//android.widget.Button[@content-desc=\"View All\"])[1]")).isDisplayed());
        clickElement(By.xpath("(//android.widget.Button[@content-desc=\"View All\"])[1]"));
        clickElement(By.xpath("//android.widget.ImageView[@content-desc=\"Property\n" +
                "Explore our carefully curated collection of exceptional properties and unique.\n" +
                "15 Property\"]"));
        //Clicking the Listing Property
        clickElement(By.xpath("//android.view.View[@content-desc=\"Consultant\n" +
                "1/1\n" +
                "Villa\n" +
                "3 weeks ago\n" +
                " AED\n" +
                "6,500,000\n" +
                "Abu Dhabi City, Shakhbout City, Shakhbout City\n" +
                "8 Bedrooms\n" +
                "8 Bathrooms\n" +
                "10000 Sqft\"]"));
        /*Thread.sleep(2000);
        driver.findElement(
                MobileBy.AndroidUIAutomator(
                        "new UiScrollable(new UiSelector().scrollable(true))" +
                                ".scrollIntoView(new UiSelector().text(\"Target Text\"));"));*/

        Thread.sleep(1500);
        //Click Call
        clickElement(By.xpath("//android.widget.ImageView[@content-desc=\"Call\"]"));
        //Click Wanna Notified
        clickElement(By.xpath("//android.view.View[@content-desc=\"Wanna Notified?\"]"));

        //Invoke Login
        Login instance = new Login();
        instance.redirectSignUp();

        SignUp signupinst = new SignUp();
        signupinst.SignUpMain();




    }
}
