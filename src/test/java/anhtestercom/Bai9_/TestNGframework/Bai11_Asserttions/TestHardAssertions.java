package anhtestercom.Bai9_.TestNGframework.Bai11_Asserttions;

import anhtestercom.Bai9_.TestNGframework.common.Basetest_OLD;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestHardAssertions extends Basetest_OLD {

    @Test(priority = 1)
    public void RunTest() {

        driver.get("https://anhtester.com");
        String message = "Tiêu đề chưa đúng";
        String expectedTitle = "Anh Tester Automation Testing";
        String actualTitle = driver.getTitle();

        System.out.println("*** Checking For The Title ***");

        Assert.assertEquals(actualTitle, expectedTitle, message);
        System.out.println("Hello");
    }

    @Test(priority = 2)
    public void TestAssertTrue() {

        driver.get("https://anhtester.com");
        String message = "Tiêu đề không chứa ";
        String actualTitle = driver.getTitle();
        String expectedTitle = "Anh Tester 123";
        System.out.println("*** Checking For The Title ***");

        Assert.assertTrue(actualTitle.contains(expectedTitle), message + expectedTitle);
        System.out.println("True: "+ actualTitle);
    }

}
