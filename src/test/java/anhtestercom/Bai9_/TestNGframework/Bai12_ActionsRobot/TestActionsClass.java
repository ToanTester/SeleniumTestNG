package anhtestercom.Bai9_.TestNGframework.Bai12_ActionsRobot;

import anhtestercom.Bai9_.TestNGframework.common.Basetest_OLD;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import static java.lang.Thread.sleep;

public class TestActionsClass extends Basetest_OLD {
    @Test
    public void TestSendKeys() throws InterruptedException {

        driver.get("https://www.google.com/");

        WebElement element = driver.findElement(By.xpath("//textarea[@name='q']"));
        // Tạo đối tượng của Actions class và để driver vào
        Actions action = new Actions(driver);

        // Dùng action để gọi hàm sendkeys điền dữ liệu. Không dùng sendKeys của WebElement
        action.sendKeys(element, "Selenium Java").sendKeys(Keys.ENTER).build().perform();
        sleep(2000);

        WebElement keySeleniumJava = driver.findElement(By.xpath("//h3[normalize-space()='[Selenium Java] Bài 4: Cài đặt môi trường Selenium với Java']"));
        action.click(keySeleniumJava).perform();  //Click vào 1 element
        action.doubleClick(keySeleniumJava).perform(); // Click 2 lần chuột trái
        action.contextClick(keySeleniumJava).perform(); // Click chuột phải
        sleep(2000);
    }

    @Test
    public void moveToElement() throws InterruptedException {
        driver.get("https://www.google.com/");
        WebElement element = driver.findElement(By.xpath("//textarea[@name='q']"));
        // Tạo đối tượng của Actions class và để driver vào
        Actions action = new Actions(driver);
        // Dùng action để gọi hàm sendkeys điền dữ liệu. Không dùng sendKeys của WebElement
        action.sendKeys(element, "Selenium Java").sendKeys(Keys.ENTER).build().perform();
        sleep(2000);

        //moveto scroll tới element The Selenium Browser Automation Project
        WebElement movetoelement = driver.findElement(By.xpath("//h3[normalize-space()='The Selenium Browser Automation Project']"));
        action.moveToElement(movetoelement).build().perform();
        sleep(2000);
    }
    @Test
    public void DragAndDropW() throws InterruptedException {
        driver.get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");
        sleep(2000);

        // Bắt element cần kéo
        WebElement From = driver.findElement(By.xpath("//div[@id='box6']"));
        // Bắt element cần thả đến
        WebElement To = driver.findElement(By.xpath("//div[@id='countries']//div[1]"));

        sleep(2000);
        Actions action = new Actions(driver);
        // Kéo và thả
        action.dragAndDrop(From, To).build().perform();
        sleep(2000);
    }

    @Test
    public void inputTextUppercase() throws InterruptedException {
        driver.get("https://www.google.com/");
        Thread.sleep(2000);
        WebElement element = driver.findElement(By.xpath("//textarea[@name='q']"));

        Actions action = new Actions(driver);

        // Đè giữ phím SHIFT và nhập text -> Chữ in hoa
        action.keyDown(element, Keys.SHIFT).sendKeys("anh ").keyUp(Keys.SHIFT).sendKeys("tester").build().perform();
        Thread.sleep(1000);
    }

    @Test
    public void scrollPageDownAndUp() throws InterruptedException {
        driver.get("https://anhtester.com/");
        Actions action = new Actions(driver);

        Thread.sleep(1000);
        // Scroll cuối trang
        action.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();
        Thread.sleep(2000);
        // Scroll đầu trang
        action.keyDown(Keys.CONTROL).sendKeys(Keys.HOME).perform();

        Thread.sleep(2000);
    }
}
