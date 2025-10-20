package org.example;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import javax.swing.*;
import java.util.concurrent.TimeUnit;

import java.time.Duration;
import java.util.ArrayList;


public class Anonymous {
    public static WebDriver x;

    @Test
    public static void login() {
        WebDriverWait w = new WebDriverWait(x, Duration.ofSeconds(10));
        x.get("https://dashboard.aqaryint.com/");

        WebElement a = w.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[normalize-space()='View Dashboard'])[1]")));
        a.click();

        ArrayList<String> y = new ArrayList<>(x.getWindowHandles());
        x.switchTo().window(y.get(1));
        WebElement signin = w.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@id='outlined-adornment-email-login'])[1]")));
        signin.sendKeys("mark@admin.com");
        WebElement pass = w.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@id='outlined-adornment-password-login'])[1]")));
        pass.sendKeys("mark");
        WebElement signenter = w.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[normalize-space()='Sign In'])[1]")));
        signenter.click();
        String title = x.getTitle();
        if (title.equals("Welcome to Aqary International | Aqary International")){
            System.out.println("Welcome to Aqary International");
        }
        else{
            System.out.println("Not Equal");
        }
    }

    public static void Statistics(WebDriver s){
        WebDriverWait w = new WebDriverWait(s, Duration.ofSeconds(10));
        WebElement Stats = w.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[normalize-space()='Analytics'])[1]")));
        Stats.click();
        WebElement Orders = w.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[normalize-space()='Month'])[1]")));
        Orders.click();
        //s.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.println("Clicked Statistics Project");
        s.manage().window().minimize();

    }
    public static void Projects(WebDriver y){
        y.manage().window().maximize();
        WebDriverWait y1 = new WebDriverWait(y, Duration.ofSeconds(10));
        y.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement pr = y.findElement(By.xpath("(//button[normalize-space()='Projects'])[1]"));
        pr.click();
        WebElement AddProject = y1.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@role='button'])[3]")));
        AddProject.click();
        System.out.println("Clicked Add Project");
        WebElement ProjectName = y1.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@id='projectTitle'])[1]")));
        ProjectName.sendKeys("umar");
        WebElement LicenseNumber = y1.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@id='licenseNumber'])[1]")));
        LicenseNumber.sendKeys("123");
        WebElement dropdown = y1.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@id='masterDeveloperSelector'])[1]")));
        dropdown.click();

        WebElement dropdown2 = y1.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"masterDeveloperSelector-option-0\"]")));
        dropdown2.click();
    }

        public static void location(WebDriver d){
        WebDriverWait w1 = new WebDriverWait(d, Duration.ofSeconds(10));
        Actions act = new Actions(d);
            WebElement dropdowncountry = w1.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@id='locationCountrySelect'])[1]")));
            dropdowncountry.click();
            WebElement dropdowncountrysel = w1.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"locationCountrySelect-option-1\"]")));
            dropdowncountrysel.click();

            WebElement dropdownstate = w1.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@id='locationState'])[1]")));
            dropdownstate.click();
            WebElement dropdownstatesel = w1.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"locationState-option-1\"]")));
            dropdownstatesel.click();
            System.out.println("Clicked Location!");

            WebElement t = w1.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@id='locationCitySelector'])[1]")));
            t.click();

            WebElement ownership = w1.until(ExpectedConditions.elementToBeClickable(By.xpath("(//label[normalize-space()='Select ownership type'])[1]")));
            act.moveToElement(ownership);

            WebElement t1 = w1.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"locationCitySelector-option-0\"]")));
            t1.click();
            String x = "Add Project | Aqary International";
            if (d.getTitle().toString() == x) {
                System.out.println("true");
            }
            else{
                System.out.println("false");
            }


            //d.quit();
        }

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        login();
        Statistics(driver);
        Projects(driver);
        location(driver);

    }
}
