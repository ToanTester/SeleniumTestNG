package anhtester.com.Bai9_.TestNGframework.Bai16_ThucHanhCRM;

import Keysword.WedUI;
import anhtester.com.Bai9_.TestNGframework.common.Basetest;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class LoginText extends Basetest {

    @Test
    public void loginCRM_Checkfieldbatbuoc(){
        driver.get("https://crm.anhtester.com/admin/authentication");
        driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
        WedUI.waitForElementVisible(driver,3,By.xpath("//form/div[1]"));

        SoftAssert softAssert = new SoftAssert();
        //Kiểm tra Element tồn tại trong DOM
        boolean emailrequied = WedUI.checkElementExist(driver, "//form/div[1]");
        boolean passrequied = WedUI.checkElementExist(driver, "//form/div[2]");
        System.out.println("Tình trạng Element Email trong DOM: " + emailrequied);
        System.out.println("Tình trạng Element Pass trong DOM: " + passrequied);
        softAssert.assertTrue(WedUI.checkElementExist(driver, "//form/div[1]"),"Tình trạng Element Email không tồn tại trong DOM");
        softAssert.assertTrue(WedUI.checkElementExist(driver, "//form/div[2]"),"ình trạng Element Pass không tồn tại trong DOM");

        //Kiểm tra Element hiển thị trên UI
        boolean messageEmailrequied = driver.findElement(By.xpath("//form/div[1]")).isEnabled(); //Hiển thị thông báo Email
        boolean messagePassrequied = driver.findElement(By.xpath("//form/div[2]")).isEnabled();//Hiển thị thông báo Pass
        System.out.println("Tình trạng hiển thị thông báo Email: " + messageEmailrequied);
        System.out.println("Tình trạng hiển thị thông báo Pass: " + messagePassrequied);
        softAssert.assertTrue(messageEmailrequied, "Thông báo email không hiển thị");
        softAssert.assertTrue(messagePassrequied, "Thông báo passds không hiển thị");

        //Kiểm tra text hiển thị của Thông  báo
        String textMessagePassrequied = driver.findElement(By.xpath("//form/div[1]")).getText(); //Text Hiển thị thông báo Email
        String textMessageEmailrequied = driver.findElement(By.xpath("//form/div[2]")).getText();//Text Hiển thị thông báo Pass
        System.out.println("Text hiển thị thông báo Email: " + textMessageEmailrequied);
        System.out.println("Text hiển thị thông báo Pass: " + textMessagePassrequied);
        softAssert.assertEquals(textMessageEmailrequied, "The Email Address field is required.01","Text hiển thị thông báo Email chưa đúng");
        softAssert.assertEquals(textMessagePassrequied, "The Password field is required.02","Text hiển thị thông báo Pass chưa đúng");
        System.out.println("đóng pass");
        softAssert.assertAll();

    }

}
