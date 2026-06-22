import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        try {
            driver.manage().window().maximize();

            System.out.println("START FAHASA TEST");

            LoginTest.run(driver);
            Thread.sleep(2000);

            SearchTest.run(driver);
            Thread.sleep(2000);

            CartTest.run(driver);
            Thread.sleep(2000);

            PaymentTest.run(driver);
            Thread.sleep(2000);

            System.out.println("END FAHASA TEST");

        } catch (Exception e) {
            e.printStackTrace();

        }finally {

            driver.quit();
        }
    }
}