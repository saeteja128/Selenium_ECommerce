package tests;

import base.BaseClass;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import pages.AfterLoginHomePage;
import pages.CommonMethods;
import pages.HomePage;
import pages.LoginPage;

import java.util.Properties;

public class BaseTest {
    WebDriver driver;
    Properties prop;
    BaseClass bc;
    CommonMethods commonmethods;
    HomePage hp;
    LoginPage lp;
    AfterLoginHomePage afterloginhomepage;

    @BeforeTest
    public void setup()
    {
        bc = new BaseClass();
        prop = bc.init_prop();
        driver = bc.init_browser(prop);
        hp = new HomePage(driver);
        commonmethods = new CommonMethods(driver);
        lp =new LoginPage(driver);
        afterloginhomepage = new AfterLoginHomePage(driver);
    }

    @AfterTest
    public void teardown()
    {
        driver.quit();
    }

}
