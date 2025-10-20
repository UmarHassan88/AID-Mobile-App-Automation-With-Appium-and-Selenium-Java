import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;

public class Testxz {
    private static final Logger log = LoggerFactory.getLogger(Testxz.class);

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        navigate(driver);
        login(driver);
        driver.quit();
    }

    public static void navigate(WebDriver driver1) {
        driver1.get("https://dashboard.aqaryint.com/");
        driver1.findElement(By.xpath("//*[@id=\"home\"]/div/div/div[1]/div/div[3]/div/div/div/div/a")).click();
        ArrayList<String> tabs = new ArrayList<>(driver1.getWindowHandles());
        driver1.switchTo().window(tabs.get(1));
    }
    public static void login(WebDriver test) throws InterruptedException {
        test.findElement(By.name("email")).sendKeys("mark@admin.com");
        test.findElement(By.name("password")).sendKeys("mark");
        test.findElement(By.xpath("//*[@id=\":r0:\"]")).click();
        Thread.sleep(5000);
    }
}
