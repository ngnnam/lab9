import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchTest {

    public static void run(WebDriver driver) {

        String keyword = "Đắc nhân tâm";

        try {
            WebElement searchBox =
                    driver.findElement(By.xpath("//input[@type='text']"));

            searchBox.sendKeys(keyword);
            searchBox.sendKeys(Keys.ENTER);

            String currentUrl = driver.getCurrentUrl();
            String pageSource = driver.getPageSource().toLowerCase();

            System.out.println("URL: " + currentUrl);

            if (currentUrl.contains("catalogsearch")
                    || pageSource.contains(keyword.toLowerCase())) {

                System.out.println("SEARCH TEST PASSED");

            } else {
                System.out.println("SEARCH TEST FAILED");
            }

        } catch (Exception e) {
            System.out.println("SEARCH TEST FAILED");
            e.printStackTrace();
        }
    }
}