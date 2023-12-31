package Keysword;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import javax.swing.plaf.PanelUI;
import java.time.Duration;
import java.util.List;

public class WedUI {
    public static void sleep(double second){
        try
        {
            Thread.sleep((long) (1000 * second));
        }
        catch (InterruptedException e)
        {
            throw new RuntimeException(e);
        }
    }

    public static void waitForElementVisible(WebDriver driver, int second, By by)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(second));
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public static Boolean checkElementExist(WebDriver driver, String xpath){
        List<WebElement> listElement = driver.findElements(By.xpath(xpath));
        if (listElement.size() > 0)
        {
            System.out.println("Element " + xpath + "exiting.");
            return true;
        } else {
            System.out.println("Element" + xpath + "NOT exits.");
            return  false;
        }
    }

//     * Wait for Page loaded
//     * Chờ đợi trang tải xong (Javascript tải xong)
//     */
    public static void waitForPageLoaded(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30), Duration.ofMillis(500));
        JavascriptExecutor js = (JavascriptExecutor) driver;

        //Wait for Javascript to load
        ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return js.executeScript("return document.readyState").toString().equals("complete");
            }
        };

        //Check JS is Ready
        boolean jsReady = js.executeScript("return document.readyState").toString().equals("complete");

        //Wait Javascript until it is Ready!
        if (!jsReady) {
            System.out.println("Javascript is NOT Ready.");
            //Wait for Javascript to load
            try {
                wait.until(jsLoad);
            } catch (Throwable error) {
                error.printStackTrace();
                Assert.fail("FAILED. Timeout waiting for page load.");
            }
        }
    }


}
