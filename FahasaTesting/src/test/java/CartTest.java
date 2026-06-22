import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CartTest {

    public static void run(WebDriver driver) throws Exception {

        boolean productOpened = false;
        boolean cartAdded = false;
        boolean quantityUpdated = false;
        boolean itemRemoved = false;

        try {

            System.out.println("URL hiện tại trước CartTest: " + driver.getCurrentUrl());

            // Click sản phẩm đầu tiên từ trang kết quả SearchTest
            List<WebElement> products = driver.findElements(
                    By.xpath("//h2[contains(@class,'product-name-no-ellipsis')]//a")
            );

            if (products.size() > 0) {
                products.get(0).click();
                productOpened = true;
                System.out.println("Đã click sản phẩm đầu tiên");
            } else {
                System.out.println("Không tìm thấy sản phẩm nào từ kết quả SearchTest");
                return;
            }

            // Thêm vào giỏ hàng
            WebElement addToCart =
                    driver.findElement(By.cssSelector(".btn-cart-to-cart"));

            addToCart.click();

            System.out.println("Đã thêm vào giỏ hàng");

            Thread.sleep(2000);

            // Mở giỏ hàng
            driver.get("https://www.fahasa.com/checkout/cart/");

            Thread.sleep(2000);

            String pageSource = driver.getPageSource().toLowerCase();

            if (driver.getCurrentUrl().contains("checkout/cart")
                    && (pageSource.contains("giỏ hàng")
                    || pageSource.contains("cart"))) {

                cartAdded = true;
            }

            // Tăng số lượng
            System.out.println("Thêm số lượng sản phẩm");

            WebElement qtyInput =
                    driver.findElement(By.cssSelector(".qty-carts"));

            int beforeQty =
                    Integer.parseInt(qtyInput.getAttribute("value"));

            System.out.println("Số lượng trước khi tăng: " + beforeQty);

            WebElement plusBtn =
                    driver.findElement(By.cssSelector(".btn-add-qty"));

            plusBtn.click();

            Thread.sleep(1000);

            qtyInput =
                    driver.findElement(By.cssSelector(".qty-carts"));

            int afterQty =
                    Integer.parseInt(qtyInput.getAttribute("value"));

            System.out.println("Số lượng sau khi tăng: " + afterQty);

            if (afterQty > beforeQty) {
                quantityUpdated = true;
                System.out.println("Tăng số lượng thành công");
            } else {
                System.out.println("Không thể tăng số lượng sản phẩm");

                pageSource = driver.getPageSource().toLowerCase();

                if (pageSource.contains("không đủ")
                        || pageSource.contains("hết hàng")
                        || pageSource.contains("vượt quá tồn kho")) {

                    System.out.println("THÔNG BÁO: Số lượng hàng trong kho không đủ");
                }
            }
            System.out.println("Giảm số lượng sản phẩm");

            qtyInput =
                    driver.findElement(By.cssSelector(".qty-carts"));

            int qtyBeforeDecrease =
                    Integer.parseInt(qtyInput.getAttribute("value"));

            System.out.println("Số lượng trước khi giảm: "
                    + qtyBeforeDecrease);

            WebElement minusBtn =
                    driver.findElement(By.cssSelector(".btn-subtract-qty"));

            minusBtn.click();

            Thread.sleep(1000);

            qtyInput =
                    driver.findElement(By.cssSelector(".qty-carts"));

            int qtyAfterDecrease =
                    Integer.parseInt(qtyInput.getAttribute("value"));

            System.out.println("Số lượng sau khi giảm: "
                    + qtyAfterDecrease);

            boolean quantityDecreased = false;

            if (qtyAfterDecrease < qtyBeforeDecrease) {

                quantityDecreased = true;

                System.out.println("Giảm số lượng thành công");

            } else {

                System.out.println("Giảm số lượng thất bại");
            }

            // Xóa sản phẩm
            WebElement removeBtn =
                    driver.findElement(By.cssSelector(".btn-remove-desktop-cart"));

            removeBtn.click();

            itemRemoved = true;

            System.out.println("Đã click xóa sản phẩm");

            Thread.sleep(1000);

        } catch (Exception e) {
            e.printStackTrace();

        } finally {

            if (productOpened && cartAdded && quantityUpdated && itemRemoved) {
                System.out.println("CART TEST PASSED");
            } else {
                System.out.println("CART TEST FAILED");
                System.out.println("Mở sản phẩm: " + productOpened);
                System.out.println("Thêm vào giỏ hàng: " + cartAdded);
                System.out.println("Tăng số lượng: " + quantityUpdated);
                System.out.println("Xóa sản phẩm: " + itemRemoved);
            }
        }
    }
}