package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;

import java.sql.Driver;
import java.time.Duration;
import java.util.ArrayList;

public class test2 {

    WebDriverWait wait;

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        getDashboard(driver);

    }
        public static void getDashboard(WebDriver z) {
            WebDriverWait wait = new WebDriverWait(z, Duration.ofSeconds(40));
            z.get("https://dashboard.aqaryint.com/");
            z.findElement(By.xpath("//*[@id=\"home\"]/div/div/div[1]/div/div[3]/div/div/div/div/a")).click();
            ArrayList<String> x = new ArrayList<>(z.getWindowHandles());
            z.switchTo().window(x.get(1));
            z.findElement(By.name("email")).sendKeys("mark@admin.com");
            System.out.println("Entered");
            z.findElement(By.name("password")).sendKeys("mark");
            z.findElement(By.xpath("//*[@id=\":r0:\"]")).click();
            WebElement click = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Projects']")));
            click.click();
            WebElement click1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@role='button'])[3]")));
            click1.click();
            System.out.println("Enter2");
            WebElement tittle = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='projectTitle']")));
            tittle.sendKeys("Mark");
            WebElement tittle1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@id='licenseNumber'])[1]")));
            tittle1.sendKeys("123");
            drop(z,"//*[@id=\"masterDeveloperSelector\"]", "//*[@id=\"masterDeveloperSelector-option-1\"]");
        }
    public static void drop(WebDriver z, String xpath1, String xpath2) {
        z.findElement(By.xpath(xpath1)).click();
        z.findElement(By.xpath(xpath2)).click();
    }
    }