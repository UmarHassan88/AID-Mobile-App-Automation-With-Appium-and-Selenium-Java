package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import javax.swing.*;
import java.awt.event.KeyEvent;

public class Login extends SignUp{
    By username = By.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View[4]/android.view.View/android.widget.EditText[1]");
    By password = By.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View[4]/android.view.View/android.widget.EditText[2]");

    public void loginFeatures() throws InterruptedException {
        Thread.sleep(2000);
        WebElement email = wait.until(ExpectedConditions.visibilityOfElementLocated(username));
        email.click();
        email.sendKeys(containEmail());

        WebElement pass = wait.until(ExpectedConditions.elementToBeClickable(password));
        pass.click();
        pass.sendKeys(signUpPassword);
        Thread.sleep(1000);
        Actions act = new Actions(driver);
        act.sendKeys(Keys.ENTER).perform();
        clickElement(By.xpath("//android.view.View[@content-desc=\"Login\"]"));
    }
}
