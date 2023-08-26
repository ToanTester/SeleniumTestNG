package anhtestercom.Bai9_.TestNGframework.Bai15_Waits;

import anhtestercom.Bai9_.TestNGframework.common.Basetest_OLD;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

//===== GHI CHÚ ========//
//ImplicitWait: Thời gian chờ đợi ngầm cho mỗi câu lệnh
//              tìm kiếm findElement cho Cả Hệ Thông.
//             - Áp dụng chung một điều kiên là tìm thấy Locator của element
//ExplicitWait:Chỉ áp dụng cho một câu lệnh tìm kiếm chỉ định, chỉ dừng lại khi không thỏa < một điều kiện
//             cụ thể> cho từng câu lệnh
//Có thể reset (có thể gọi: Thay đổi): driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//            - Vidu: driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
public class TestImplicitWait extends Basetest_OLD {

    @Test
    public  void  loginCRM(){
        driver.get("https://rise.fairsketch.com/signin");
        driver.findElement(By.xpath("//button[normalize-space()='Sign in']")).click();
        driver.findElement(By.xpath(" //span[normalize-space()='Clients']")).click();
//        driver.findElement(By.xpath("")).click();
//        driver.findElement(By.xpath("")).click();
//        driver.findElement(By.xpath("")).click();

    }

}
