package anhtester.com.Bai9_.TestNGframework.Bai10_AnnotationsTestNG;

import anhtester.com.Bai9_.TestNGframework.common.Basetest;
import net.bytebuddy.build.Plugin;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class LoginCMS extends Basetest {

    @Test (priority = 1, description = "Login CMS test")
    public void testAnhLoginCMS() throws InterruptedException {
        System.out.println("Run testAnhTesterBlog");
        driver.get("https://demo.activeitzone.com/ecommerce/login");
        driver.findElement(By.xpath("//button[normalize-space()='Copy']")).click();
        driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
        Thread.sleep(2000);
    }
    @Test (priority = 2, description = "Check blog Anhtester")
    public void testAnhTesterBlog() throws InterruptedException {
        driver.get("https://anhtester.com");
        driver.findElement(By.xpath("//a[normalize-space()='blog']")).click();
        Thread.sleep(2000);
    }
}
