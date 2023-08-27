package anhtester.com.Bai9_.TestNGframework.Bai16_ThucHanhCRM;

import Keysword.WedUI;
import anhtester.com.Bai9_.TestNGframework.common.Basetest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ManageCustomers extends Basetest {

    @BeforeMethod
    public void loginCRM(){
        driver.get("https://crm.anhtester.com/admin/authentication");
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("admin@example.com");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("123456");
        driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
    }


    private String CUSTOMER_NAME = "Công ty Vũ Thảo";
    private String WEBSITE = "https://cmcglobal.com.vn/vi/home-vi/";

    @Test
    public void addCustomer(){
        driver.findElement(By.xpath("//span[normalize-space()='Customers']")).click();
        WedUI.waitForPageLoaded(driver);
        driver.findElement(By.xpath("//a[normalize-space()='New Customer']")).click();
        driver.findElement(By.id("company")).sendKeys(CUSTOMER_NAME);
        driver.findElement(By.id("vat")).sendKeys("10");
        driver.findElement(By.id("phonenumber")).sendKeys("0123456789");
        driver.findElement(By.id("website")).sendKeys(WEBSITE);
        WedUI.sleep(1);
        driver.findElement(By.xpath("//label[@for='groups_in[]']/following-sibling::div")).click();
        WedUI.sleep(1);
        driver.findElement(By.xpath("//label[@for='groups_in[]']/following-sibling::div//input[@type='search']")).sendKeys("Gold", Keys.ENTER);
        WedUI.sleep(1);
        driver.findElement(By.xpath("//label[@for='groups_in[]']/following-sibling::div")).click();
        WedUI.sleep(1);
        driver.findElement(By.id("address")).sendKeys("Viet Nam");
        driver.findElement(By.id("city")).sendKeys("Can Tho");
        driver.findElement(By.id("state")).sendKeys("Can Tho");
        driver.findElement(By.id("zip")).sendKeys("92000");
        WedUI.sleep(1);
        driver.findElement(By.xpath("//label[@for='country']/following-sibling::div")).click();
        WedUI.sleep(1);
        driver.findElement(By.xpath("//label[@for='country']/following-sibling::div//input[@type='search']")).sendKeys("Vietnam", Keys.ENTER);
        WedUI.sleep(1);
        driver.findElement(By.xpath("//div[@id='profile-save-section']//button[normalize-space()='Save']")).click();
        WedUI.waitForPageLoaded(driver);

        String getCustomer = driver.findElement(By.xpath("//input[@id='company']")).getAttribute("value");
        System.out.println("Tên Customer detaisl: " + getCustomer);

        Assert.assertEquals(getCustomer,CUSTOMER_NAME,"company chưa không đung");
        //Kiểm tra Save thành công chuyển hướng đến trang Customer Details
        WedUI.waitForPageLoaded(driver);
        driver.findElement(By.xpath("//span[normalize-space()='Customers']")).click();
        driver.findElement(By.xpath("//input[@class='form-control input-sm']")).sendKeys(CUSTOMER_NAME);
        WedUI.waitForPageLoaded(driver);
        WedUI.sleep(2);

        String getTextCustomerTable =  driver.findElement(By.xpath("//tbody/tr[1]/td[3]")).getText();
        System.out.println("Tên Customer lấy trong Table: " + getTextCustomerTable);
        Assert.assertEquals(getTextCustomerTable, CUSTOMER_NAME,"Tên Customer trong Table chưa đúng");




    }

}
