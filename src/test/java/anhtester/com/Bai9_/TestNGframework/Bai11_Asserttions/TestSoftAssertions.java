package anhtester.com.Bai9_.TestNGframework.Bai11_Asserttions;

import anhtester.com.Bai9_.TestNGframework.common.Basetest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


public class TestSoftAssertions extends Basetest {

    @Test
    public void testSoftasserttions() throws InterruptedException {
        driver.get("https://rise.fairsketch.com/signin");
        String textSignin = driver.findElement(By.xpath("//div//h2[normalize-space()='Sign in']")).getText();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(textSignin, "Sign In", "Mong muốn về Title chưa đúng");

        String textbutton = driver.findElement(By.xpath("//button[normalize-space()='Sign in']")).getText();
        softAssert.assertEquals(textbutton, "Sign In", "Text button không đúng");
        //Cuối cùng của softAssert phải dùng hàm assertAll để kiểm tra và xác nhận các trường hợp trên
        softAssert.assertAll();
    }
}
