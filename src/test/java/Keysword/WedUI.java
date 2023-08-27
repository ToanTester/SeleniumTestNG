package Keysword;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.plaf.PanelUI;
import java.time.Duration;

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
}
