package anhtester.com.Bai9_.TestNGframework.Bai13_Alert_popup_Iframe;

import Keysword.WedUI;
import anhtester.com.Bai9_.TestNGframework.common.Basetest;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Set;

public class TestAlert extends Basetest {

    @Test
    public void demoHandleAlertDismiss() {
        driver.get("http://demo.seleniumeasy.com/javascript-alert-box-demo.html");
        WedUI.sleep(2);
        //Mở Alert Dismiss, click vào nút "Click me!" thứ 2
        WebElement buttonClickme02 =  driver.findElement(By.xpath("(//button[text()='Click me!'])[2]"));
        // Khởi tạo class Actions
        Actions actions = new Actions(driver);
        actions.moveToElement(buttonClickme02).build().perform(); //Moveto scroll button "Click me"
        WedUI.sleep(1);
        buttonClickme02.click(); //Click button "Click me"
        WedUI.sleep(1);
        //Khởi tạo class Alert
        Alert alert2 = driver.switchTo().alert();
        alert2.dismiss(); //Click button Cancel
        WebElement checkBTCancel = driver.findElement(By.xpath("//p[normalize-space()='You pressed Cancel!']"));// Lấy Element Cancel
        Assert.assertTrue(checkBTCancel.isDisplayed(),"Chưa nhấn được nút Cancel");
        System.out.println("Trạng thái button Cancel: " + checkBTCancel.isDisplayed());
        WedUI.sleep(2);

        buttonClickme02.click(); //Click button "Click me
        alert2.accept();//lick button OK
        WebElement checkBTOK = driver.findElement(By.xpath("//p[@id='confirm-demo']")); // Lấy Element OK
        Assert.assertTrue(checkBTCancel.isDisplayed(),"Chưa nhấn được nút OK");
        System.out.println("Trạng thái button OK: " + checkBTCancel.isDisplayed());

        //Mở Alert Dismiss, click vào nút "Click me!" thứ 3
        WebElement buttonClickme03 =  driver.findElement(By.xpath(" //button[normalize-space()='Click for Prompt Box']"));
        actions.moveToElement(buttonClickme03).build().perform(); //Moveto scroll button "Click me"
        WedUI.sleep(1);
        buttonClickme03.click(); //Click button "Click me"
        WedUI.sleep(1);
        alert2.sendKeys("Toan");
        alert2.accept();
        WebElement text =  driver.findElement(By.xpath("//p[@id='prompt-demo']"));
        Assert.assertEquals(text.getText(), "You have entered 'Toann' !","Kết quả chưa đúng");
        WedUI.sleep(1);




        WedUI.sleep(1);
    }
}
