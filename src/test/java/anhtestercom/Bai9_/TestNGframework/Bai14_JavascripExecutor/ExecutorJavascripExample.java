package anhtestercom.Bai9_.TestNGframework.Bai14_JavascripExecutor;

import Keysword.WedUI;
import anhtestercom.Bai9_.TestNGframework.common.Basetest_OLD;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

public class ExecutorJavascripExample extends Basetest_OLD {

    @Test
    public void testScript01(){
        driver.get("https://demo.activeitzone.com/ecommerce/user/login");
        WedUI.sleep(2);
//        driver.findElement(By.xpath("//i[@class='la la-close fs-20']")).click();
//        driver.findElement(By.xpath("//a[normalize-space()='Login']")).click();
        //WedUI.sleep(2);

        //Khai báo và khởi tạo giá trị đối tượng
        JavascriptExecutor Js = (JavascriptExecutor) driver;
        Js.executeScript("arguments[0].click();",driver.findElement(By.xpath("//i[@class='la la-close fs-20']")));
        driver.findElement(By.xpath("//a[normalize-space()='Login']")).click();
    }

}
