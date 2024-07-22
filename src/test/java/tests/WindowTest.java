package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class WindowTest {

    @Test
    public void tabWindow() {
        WebDriver driver;

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.linkedin.com/home");

        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.google.com");

        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.cricbuzz.com/");
    }
}
