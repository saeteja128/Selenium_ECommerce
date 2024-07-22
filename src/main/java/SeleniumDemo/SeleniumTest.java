package SeleniumDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import javax.xml.xpath.XPath;
import java.time.Duration;

public class SeleniumTest {
    WebDriver driver;
    WebElement hamburger;
    WebElement HomeButton;

    @BeforeTest
    public void SetUp() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://anupdamoda.github.io/AceOnlineShoePortal/index.html");
        driver.manage().window().maximize();
        String expectedTitle = driver.getTitle();
        System.out.println("Expected Title:"+ expectedTitle);
    }

    @Test
    public void TestSteps(){
        hamburger = driver.findElement(By.xpath("//div[@id='menuToggle']/input"));
        hamburger.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@id='menu']/a/li[contains(text(),'Sign In Portal')]")));
        HomeButton = driver.findElement(By.xpath("//ul[@id='menu']/a/li[contains(text(),'Sign In Portal')]"));
        HomeButton.click();

        driver.findElement(By.xpath("//div[@class='form-group']/input[@id='usr']")).sendKeys("Sai");
        driver.findElement(By.xpath("//div[@class='form-group']/input[@id='pwd']")).sendKeys("Password");
        driver.findElement(By.xpath("//input[@class='btn btn-info']")).click();

        String text = driver.findElement(By.xpath("//h3[@id='ShoeType'][contains(text(),'Formal Shoes')]")).getText();
        System.out.println("Text Stored: " +text);

        String ExpectedTitle = "Formal Shoes";
        Assert.assertEquals(text, ExpectedTitle);

        driver.close();
    }
}
