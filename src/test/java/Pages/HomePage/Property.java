package Pages.HomePage;

import Pages.Login;
import Pages.Setup;
import Pages.SignUp;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class Property extends Setup {

    @Test(priority = 1)
    public void propertySection() throws InterruptedException {
       System.out.println("Clicked View All...");
        Thread.sleep(1000);
        Assert.assertTrue(driver.findElement(By.xpath("(//android.widget.Button[@content-desc=\"View All\"])[1]")).isDisplayed());
        clickElement(By.xpath("(//android.widget.Button[@content-desc=\"View All\"])[1]"));
        clickElement(By.xpath("//android.widget.ImageView[@content-desc=\"Property\n" +
                "Explore our carefully curated collection of exceptional properties and unique.\n" +
                "15 Property\"]"));
        System.out.println("Clicked the Property Section...");

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
        System.out.println("Clicked the First Property...");

        /*Thread.sleep(2000);
        driver.findElement(
                MobileBy.AndroidUIAutomator(
                        "new UiScrollable(new UiSelector().scrollable(true))" +
                                ".scrollIntoView(new UiSelector().text(\"Target Text\"));"));*/

        Thread.sleep(1500);
        System.out.println("Scrolling at the Moment...");


        JavascriptExecutor js = (JavascriptExecutor) driver;

        Map<String, Object> params = new HashMap<>();
        params.put("left", 100);     // X start coordinate of swipe area
        params.put("top", 500);      // Y start coordinate
        params.put("width", 300);    // Width of swipe area
        params.put("height", 800);   // Height of swipe area
        params.put("direction", "up");
        params.put("percent", 0.8); // How far to swipe (0.0 to 1.0)

        js.executeScript("mobile: swipeGesture", params);

        /*JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("mobile: swipeGesture", Map.of(
                "direction", "up",
                "percent", 0.5
                */
        //Click Call
        clickElement(By.xpath("//android.widget.ImageView[@content-desc=\"Call\"]"));
        System.out.println("Clicked the Call Icon...");

        //Click Wanna Notified
        clickElement(By.xpath("//android.view.View[@content-desc=\"Wanna Notified?\"]"));
        System.out.println("Clicked Wanna Notified...");


        //Invoke Login

        System.out.println("This is the Login Page...");

        SignUp signupinst = new SignUp();

        signupinst.redirectSignUp();
        signupinst.SignUpMain();

        Login loginInstance = new Login();
        loginInstance.loginFeatures();




    }
}
