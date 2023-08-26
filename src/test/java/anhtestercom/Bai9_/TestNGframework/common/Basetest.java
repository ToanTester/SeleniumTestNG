package anhtestercom.Bai9_.TestNGframework.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class Basetest {

    public WebDriver driver;

    @BeforeMethod
    public void createDriver() {
        //WebDriverManager.chromedriver().setup();
        System.out.println("Start Chrome browser");
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        //pageLoadTimeout: Chờ đợi Page load xong khoảng thời gian 30s
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
    }

    @AfterMethod
    public void closeDriver() {
        System.out.println("Close Chrome browser");
        driver.quit();
    }
}
