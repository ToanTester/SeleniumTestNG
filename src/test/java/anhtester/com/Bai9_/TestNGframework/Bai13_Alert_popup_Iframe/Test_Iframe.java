package anhtester.com.Bai9_.TestNGframework.Bai13_Alert_popup_Iframe;

import anhtester.com.Bai9_.TestNGframework.common.Basetest;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class Test_Iframe extends Basetest {
    @Test
    public void iFrame01() throws InterruptedException {

        driver.navigate().to("https://anhtester.com/contact");
        Thread.sleep(8000);
        System.out.println("iframe total: " + driver.findElements(By.tagName("iframe")).size());
        Thread.sleep(3000);
//        //----Switch to content of Messenger--------
        driver.switchTo().frame(0);
        System.out.println(driver.findElement(By.tagName("strong")).getText());
//
//        //1. Switch to Parent frame
        driver.switchTo().parentFrame();

        //2. Switch to iframe icon of Messenger
        driver.switchTo().frame(1);
        driver.findElement(By.tagName("svg")).click(); //Nhấn icon để ẩn messenger chat đi
        Thread.sleep(2000);
    }
}
