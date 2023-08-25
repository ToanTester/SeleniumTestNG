package BaiTap;

import Keysword.WedUI;
import anhtester.com.Bai9_.TestNGframework.common.Basetest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


public class TestNG_BT1 extends Basetest {

   @Test(priority = 1)
    public void loginCMS() {
        driver.get("https://demo.activeitzone.com/ecommerce/login");
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("admin@example.com");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("123456");
        driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
    }
    @Test(priority = 2)
    public void addCategory() {
        driver.findElement(By.xpath("//span[normalize-space()='Products']")).click();
        driver.findElement(By.xpath("//span[normalize-space()='Category']")).click();
        driver.findElement(By.xpath("//span[normalize-space()='Add New category']")).click();
        driver.findElement(By.xpath("//input[@id='name']")).sendKeys("Category_240823");
        WedUI.sleep(2);
        driver.findElement(By.xpath("//label[normalize-space()='Parent Category']/following-sibling::div/div")).click();
        driver.findElement(By.xpath("//input[contains(@aria-label,'Search')]")).sendKeys("computer", Keys.ENTER);
        WedUI.sleep(2);
        driver.findElement(By.xpath("//label[contains(normalize-space(),'Banner')]/following-sibling::div")).click();
        driver.findElement(By.xpath("//input[@placeholder='Search your files']")).sendKeys("apple");
        WedUI.sleep(2);
        driver.findElement(By.xpath("//span[normalize-space()='apple']")).click();
        WedUI.sleep(2);
        // Click add file
        driver.findElement(By.xpath("//button[normalize-space()='Add Files']")).click();
        WedUI.sleep(2);

        driver.findElement(By.xpath("//textarea[@name='meta_description']")).sendKeys("Category_240823");
        driver.findElement(By.xpath("//label[normalize-space()='Filtering Attributes']/following-sibling::div/div")).click();
        WedUI.sleep(1);
        driver.findElement(By.xpath("//input[@aria-controls='bs-select-3']")).sendKeys("Size", Keys.ENTER);
        WedUI.sleep(1);
        //Save
        driver.findElement(By.xpath("//button[normalize-space()='Save']")).click();
        WedUI.sleep(2);

        //Chức năng tìm kiếm
        driver.findElement(By.xpath("//input[@placeholder='Type name & Enter']")).sendKeys("Women", Keys.ENTER);
        WedUI.sleep(2);
        String categoryItem = driver.findElement(By.xpath("//tbody/tr[1]/td[2]")).getText(); // lấy text tìm kiếm
        System.out.println("Kết quả tìm kiếm: " + categoryItem);
        Assert.assertEquals(categoryItem,"Category_240823","KQMĐ: Kết quả tìm kiếm chưa đúng");
        WedUI.sleep(1);

    }

}
