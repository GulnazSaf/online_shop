import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class LoginTest extends TestBase{

    @Test (enabled = true)
    public void loginTest() {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        String urlCurrent =  driver.getCurrentUrl();
        Assert.assertEquals(urlCurrent, "https://www.saucedemo.com/inventory.html");
    }

    @Test (enabled = true)
    public void productsPageTest() {
        String urlCurrent =  driver.getCurrentUrl();
        Assert.assertEquals(urlCurrent, "https://www.saucedemo.com/inventory.html");
        List<WebElement> products= driver.findElements(By.xpath("//*[@class='inventory_item']"));
        Assert.assertEquals(products.size(), 6);

    }

    @Test
    public void addToCartTest () {
        driver.manage().window().maximize();
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        List<WebElement> products= driver.findElements(By.xpath("//*[@class='inventory_item']"));
        double max = 0;
        WebElement productMaxPrice = null;
        for (WebElement product:products) {
            String price = product.findElement(By.xpath(".//*[@class='inventory_item_price']")).
                        getText().replace("$", "");
            double currentPrice = Double.parseDouble(price);
            if (currentPrice > max) {
                max = currentPrice;
                productMaxPrice = product;
            }
        }
        productMaxPrice.findElement(By.tagName("button")).click();
        String removeButton = productMaxPrice.findElement(By.xpath(".//button")).getText();
        int quantityInCart = Integer.parseInt(driver.findElement(By.xpath("//*[@class='shopping_cart_link']")).getText());
        System.out.println( quantityInCart);

        //Asserts that remove button appeared for added item
        Assert.assertEquals(removeButton, "Remove", "Remove button did not appear");
        //Assert that item added to cart
        Assert.assertEquals(quantityInCart,1, "Item have not been added to cart");
        }

    @Test
    public void productsAddedToCartTest () {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        WebElement product = driver.findElement(By.xpath("//*[@class='inventory_item']"));
        String productId = product.findElement(By.tagName("a")).getAttribute("id");
        product.findElement(By.tagName("button")).click();
        driver.findElement(By.xpath("//a[@class='shopping_cart_link']"));
        Assert.assertTrue(driver.findElement(By.id(productId)).isDisplayed());
    }

}


