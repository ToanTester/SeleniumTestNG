package anhtestercom.Bai9_.TestNGframework.Bai15_Waits;

import Keysword.WedUI;
import anhtestercom.Bai9_.TestNGframework.common.Basetest;
import anhtestercom.Bai9_.TestNGframework.common.Basetest_OLD;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestExplicitWait extends Basetest {

    @Test
    public void addBrand() {
        driver.get("https://demo.activeitzone.com/ecommerce/login");
        driver.findElement(By.xpath("//button[normalize-space()='Copy']")).click();
        driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
        driver.findElement(By.xpath("//span[normalize-space()='Products']")).click();

        //Khai báo WedDriverWait = Explicit Wait
        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        //Chờ đợi menu Brand đến khi sẳn sàng hiển thị có thể thao tác được
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space()='Brand']")));
        WedUI.waitForElementVisible(driver,5,By.xpath("//span[normalize-space()='Brand']" ));
        driver.findElement(By.xpath("//span[normalize-space()='Brand']")).click();
        String textAddnewbrand = driver.findElement(By.xpath("//div[@class='card-header']//h5")).getText();
        Assert.assertEquals(textAddnewbrand, "Add New Brand", "Chưa đúng Tên Header Add New Brand ");
        System.out.println("Tên Header: " + textAddnewbrand);
        driver.findElement(By.xpath("//input[@id='search']")).sendKeys("acer", Keys.ENTER);

        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tbody//tr[1]//td[2]")));
        WedUI.waitForElementVisible(driver,3,By.xpath("//tbody//tr[1]//td[2]"));
        String textBrandName = driver.findElement(By.xpath("//tbody//tr[1]//td[2]")).getText();
        System.out.println("BrandName được tìm kiếm: " +textBrandName);
        Assert.assertEquals(textBrandName,"Acer","Kết quả tìm kiếm chưa đúng");
    }


}
