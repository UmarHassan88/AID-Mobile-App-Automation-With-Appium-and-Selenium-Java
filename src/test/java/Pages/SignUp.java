package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class SignUp extends Setup{

    By name = By.xpath("//android.widget.ScrollView/android.view.View[2]/android.widget.EditText[1]");

    By email = By.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View[4]/android.view.View[2]/android.widget.EditText[2]");

    By phone = By.xpath("//android.view.View[@content-desc=\"+971\"]/android.widget.EditText");

    By next = By.xpath("//android.view.View[@content-desc=\"Next\"]");

    //Assertion Locators
    By usernameAssert = By.xpath("//android.view.View[@content-desc=\"Username is Required\"]");
    By emailAssert = By.xpath("//android.view.View[@content-desc=\"Email is Required\"]");
    public void Assertions() throws InterruptedException {
        WebElement nextInv = wait.until(ExpectedConditions.elementToBeClickable(next));
        nextInv.click();
        Thread.sleep(2000);
        Assert.assertTrue(driver.findElement(usernameAssert).isDisplayed());
        Assert.assertTrue(driver.findElement(emailAssert).isDisplayed());

    }
    public void SignUpMain() throws InterruptedException {
        //Click Next for Validations
        Assertions();
        WebElement sendName = wait.until(ExpectedConditions.elementToBeClickable(name));
        sendName.click();
        sendName.sendKeys("Umar");
        Thread.sleep(1500);
        emailValidations();
        WebElement sendPhone = wait.until(ExpectedConditions.elementToBeClickable(phone));
        sendPhone.click();
        sendPhone.sendKeys("0503343432");
        Thread.sleep(1500);
        WebElement nextClick = wait.until(ExpectedConditions.elementToBeClickable(next));
        nextClick.click();
        signUp2ndPage();
    }

    By firstName = By.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View[4]/android.view.View/android.view.View[2]/android.view.View/android.widget.EditText[1]");
    By lastName = By.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View[4]/android.view.View/android.view.View[2]/android.view.View/android.widget.EditText[2]");
    By password = By.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View[4]/android.view.View/android.view.View[2]/android.view.View/android.widget.EditText[3]");
    By confirmPassword = By.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View[4]/android.view.View/android.view.View[2]/android.view.View/android.widget.EditText[4]");
    By signUp = By.xpath("(//android.view.View[@content-desc=\"Sign Up\"])[2]");


    public void signUp2ndPage() throws InterruptedException {
        Thread.sleep(1500);
        waitElem(firstName).sendKeys("umar");
        waitElem(lastName).sendKeys("hassan");
        waitElem(password).sendKeys("Aqary88");
        Thread.sleep(1500);
        Assert.assertTrue(driver.findElement(By.xpath("//android.view.View[@content-desc=\"Password must be at least 8 characters\"]")).isDisplayed());
        waitElem(password).clear();
        waitElem(password).sendKeys("Aqary@88");
        waitElem(confirmPassword).sendKeys("Aqary88");
        Thread.sleep(1500);
        Assert.assertTrue(driver.findElement(By.xpath("//android.view.View[@content-desc=\"Passwords do not match\"]")).isDisplayed());
        waitElem(confirmPassword).clear();
        waitElem(confirmPassword).sendKeys("Aqary@88");
        Actions action = new Actions(driver);
        action.sendKeys(Keys.ENTER);
        Thread.sleep(1500);
        waitElem(signUp).click();


    }
    public void emailValidations() throws InterruptedException {
        WebElement sendEmail = wait.until(ExpectedConditions.elementToBeClickable(email));
        sendEmail.click();
        sendEmail.sendKeys("umarhassanzia88");
        Thread.sleep(1500);
        sendEmail.clear();
        sendEmail.sendKeys("umarhassanzia88+test88@gmail.com");


    }
}
