import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.openqa.selenium.By;

public class selenium_saucedemo_automation {


		    public static void main(String[] args) throws InterruptedException {

		        // Launch browser
		        WebDriver driver = new ChromeDriver();
		        driver.get("https://www.saucedemo.com/");

		        // ---------------- LOGIN ----------------
		        driver.findElement(By.id("user-name")).sendKeys("standard_user");
		        driver.findElement(By.id("password")).sendKeys("secret_sauce");
		        driver.findElement(By.id("login-button")).click();

		        // Verify login
		        String title = driver.findElement(By.className("app_logo")).getText();
		        System.out.println("Page Title: " + title);
		        Assert.assertEquals(driver.findElement(By.xpath("//div[@class='app_logo']")).getText(), "Swag Labs");

		        // ---------------- SELECT PRODUCT ----------------
		        driver.findElement(By.className("inventory_item_name")).click();

		        // click on particular product
		        driver.findElement(By.xpath("//div[@data-test='inventory-item-name']")).click();

		        // Add to cart
		        driver.findElement(By.id("add-to-cart")).click();

		        // ---------------- CART ----------------
		        driver.findElement(By.className("shopping_cart_link")).click();

		        System.out.println(driver.findElement(By.className("cart_quantity_label")).getText());
		        System.out.println(driver.findElement(By.className("cart_item")).getText());

		        // Continue shopping
		        driver.findElement(By.id("continue-shopping")).click();

		        // Go back to cart
		        driver.findElement(By.className("shopping_cart_link")).click();

		        // ---------------- CHECKOUT ----------------
		        driver.findElement(By.id("checkout")).click();

		        driver.findElement(By.id("first-name")).sendKeys("Snehitha");
		        driver.findElement(By.id("last-name")).sendKeys("Mullapudi");
		        driver.findElement(By.id("postal-code")).sendKeys("177565");

		        driver.findElement(By.id("continue")).click();

		        System.out.println(driver.findElement(By.id("checkout_summary_container")).getText());

		        // Finish order
		        driver.findElement(By.id("finish")).click();

		        // Verify order success
		        String confirmation = driver.findElement(By.className("complete-header")).getText();
		        System.out.println("Order Status: " + confirmation);

		        // ---------------- LOGOUT ----------------
		        driver.findElement(By.id("react-burger-menu-btn")).click();
		        Thread.sleep(2000); // will replace with waits later
		        driver.findElement(By.id("logout_sidebar_link")).click();

		        // Close browser
		        driver.quit();
		    
		

	}

}
