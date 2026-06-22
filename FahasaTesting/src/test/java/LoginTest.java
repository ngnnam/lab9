import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginTest {

    public static void run(WebDriver driver) throws Exception {

        WebDriverWait wait =
                new WebDriverWait(driver, Duration.ofSeconds(20));

        try {
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

            driver.get("https://www.fahasa.com/customer/account/login/");

            WebElement username = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(By.id("login_username"))
            );
            username.clear();
            username.sendKeys("0779573222");

            WebElement password = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(By.id("login_password"))
            );
            password.clear();
            password.sendKeys("test@gmail");

            WebElement loginBtn = wait.until(
                    ExpectedConditions.elementToBeClickable(By.cssSelector(".fhs-btn-login"))
            );
            loginBtn.click();

            try {
                wait.until(ExpectedConditions.or(
                        ExpectedConditions.urlContains("customer/account"),
                        ExpectedConditions.visibilityOfElementLocated(
                                By.xpath("//*[contains(text(),'Tài khoản') or contains(text(),'Đăng xuất')]")
                        )
                ));

                System.out.println("LOGIN SUCCESS");

            } catch (TimeoutException e) {
                System.out.println("LOGIN FAILED");
                System.out.println("Thông tin đăng nhập không đúng hoặc hệ thống không chuyển trang.");
            }

        } catch (Exception e) {
            System.out.println("ERROR:");
            e.printStackTrace();
        }
    }
}