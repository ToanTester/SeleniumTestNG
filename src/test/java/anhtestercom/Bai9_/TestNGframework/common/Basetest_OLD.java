package anhtestercom.Bai9_.TestNGframework.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.time.Duration;

public class Basetest_OLD {

    public WebDriver driver;

    @BeforeMethod
    public void createDriver() {
        //WebDriverManager.chromedriver().setup();
        System.out.println("Start Chrome browser");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        //implicitlyWait: Thời gian chờ đợi ngầm cho mỗi câu lệnh tìm kiếm Element với khoảng thời gian 10s
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //pageLoadTimeout: Chờ đợi Page load xong khoảng thời gian 30s
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
    }

    @AfterMethod
    public void closeDriver() {
        System.out.println("Close Chrome browser");
        driver.quit();
    }
}
