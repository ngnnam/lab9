import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class PaymentTest {

    public static void run(WebDriver driver) throws Exception {

        boolean productSelected = false;
        boolean paymentOpened = false;

        try {
            System.out.println("\nBắt đầu PAYMENT TEST");

            driver.get("https://www.fahasa.com/checkout/cart/");

            Thread.sleep(2000);

            List<WebElement> checkboxes =
                    driver.findElements(By.xpath("//input[contains(@class,'checkbox-add-cart')]"));

            if (checkboxes.size() > 0) {

                WebElement checkbox = checkboxes.get(0);

                if (!checkbox.isSelected()) {
                    checkbox.click();
                }

                productSelected = true;
                System.out.println("Đã tick chọn sản phẩm");

            } else {
                System.out.println("Không tìm thấy checkbox sản phẩm");
                return;
            }

            Thread.sleep(1000);

            WebElement checkoutBtn =
                    driver.findElement(
                            By.xpath("//button[contains(@class,'btn-proceed-checkout')]")
                    );

            checkoutBtn.click();

            System.out.println("Đã click nút Thanh toán");

            Thread.sleep(1000);

            WebElement confirmBtn =
                    driver.findElement(
                            By.cssSelector(".fhs-btn-orderconfirm")
                    );

            confirmBtn.click();

            System.out.println("Đã click Xác nhận thanh toán");

            Thread.sleep(1000);

            String currentUrl = driver.getCurrentUrl();
            String pageSource = driver.getPageSource().toLowerCase();

            System.out.println("URL Payment: " + currentUrl);

            if (currentUrl.contains("checkout")
                    || pageSource.contains("thanh toán")
                    || pageSource.contains("địa chỉ giao hàng")
                    || pageSource.contains("phương thức thanh toán")) {

                paymentOpened = true;
            }

        } catch (Exception e) {
            e.printStackTrace();

        } finally {

            if (productSelected && paymentOpened) {
                System.out.println("PAYMENT TEST PASSED");
            } else {
                System.out.println("PAYMENT TEST FAILED");
                System.out.println("Tick chọn sản phẩm: " + productSelected);
                System.out.println("Mở trang thanh toán: " + paymentOpened);
            }
        }
    }
}