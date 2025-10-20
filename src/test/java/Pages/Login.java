package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import javax.swing.*;
import java.awt.event.KeyEvent;

public class Login extends Setup{
    By username = By.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View[4]/android.view.View/android.widget.EditText[1]");
    By password = By.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View[4]/android.view.View/android.widget.EditText[2]");
    By signUp = By.xpath("//android.view.View[@content-desc=\"Create Account\"]");

    public void redirectSignUp(){
        WebElement signUpClick = wait.until(ExpectedConditions.elementToBeClickable(signUp));
        signUpClick.click();
    }
    public void loginFeatures() throws InterruptedException {
        WebElement email = wait.until(ExpectedConditions.visibilityOfElementLocated(username));
        email.click();
        int random = randomGenerator();
        email.sendKeys("umarhassan88+test"+random+"@gmail.com");
        int num = 88;
        if(random!=num){
            email.clear();
            Thread.sleep(1000);
            email.sendKeys("umarhassan88+test"+num+"@gmail.com");


        WebElement pass = wait.until(ExpectedConditions.elementToBeClickable(password));
        pass.click();
        pass.sendKeys("Aqary@88");
        Thread.sleep(1000);
        Actions act = new Actions(driver);
        act.sendKeys(Keys.ENTER).perform();
        clickElement(By.xpath("//android.view.View[@content-desc=\"Login\"]"));

        }
    }
}
