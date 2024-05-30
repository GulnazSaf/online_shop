import com.saucedemo.base.TestBase;
import com.saucedemo.pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class LoginTest extends TestBase {

    LoginPage loginPage;

    public LoginTest() {super();}

    @BeforeClass
    public void beforeClass() {

    }

    @AfterMethod
    public void tearDown() {
        super.tearDown();
    }



    @Test(enabled = true)
    public void loginTest() {
        String urlCurrent = driver.getCurrentUrl();
        Assert.assertEquals(urlCurrent, "https://www.saucedemo.com/inventory.html");
    }
}




