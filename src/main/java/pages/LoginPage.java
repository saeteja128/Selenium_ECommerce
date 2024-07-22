package pages;

import Utils.ExcelDataSupplier;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;

import java.time.Duration;
import java.util.Properties;

public class LoginPage {
    private WebDriver driver;
    CommonMethods commonmethods;

    private By EmailField = By.xpath("//input[@id='email']");
    private By PasswordField = By.xpath("//input[@id='pass']");
    private By SignInButton = By.xpath("//div//button[@class='action login primary']");
    private By CreateAnAccount = By.xpath("//a[@class='action create primary']/span");
    private By AssertCreateAccountText = By.xpath("//fieldset[@class='fieldset create info']/legend/span");

    private By FirstNameField = By.id("firstname");
    private By LastNameField = By.id("lastname");
    private By SignUpEmail = By.id("email_address");
    private By SignUpPassword = By.id("password");
    private By SignUpConfirmPassword = By.id("password-confirmation");
    private By SignUpCreateAnAccount = By.xpath("//button[@class='action submit primary']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void fillingLoginCredentials(String eusername, String epassword) {
        commonmethods = new CommonMethods(driver);
        commonmethods.fillTextField(EmailField, eusername);
        commonmethods.fillTextField(PasswordField, epassword);
        commonmethods.ClickButton(SignInButton);
    }

    public void fillingSignUpCredentials(String firstname, String lastname, String email, String password) {
        commonmethods = new CommonMethods(driver);
        commonmethods.ClickButton(CreateAnAccount);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(AssertCreateAccountText));
        commonmethods.fillTextField(FirstNameField, firstname);
        commonmethods.fillTextField(LastNameField, lastname);
        commonmethods.fillTextField(SignUpEmail, email);
        commonmethods.fillTextField(SignUpPassword, password);
        commonmethods.fillTextField(SignUpConfirmPassword, password);
        commonmethods.ClickButton(SignUpCreateAnAccount);
    }

    public void SignIn_SignUp(String euser, String eusername, String epassword, String firstname, String lastname, String email, String password) {
        if (euser.equalsIgnoreCase("yes")) {
            System.out.println("Logging in using existing user credentials ");
            fillingLoginCredentials(eusername, epassword);
            System.out.println("Username: " +eusername);
            System.out.println("Password: " +epassword);
        } else if (euser.equalsIgnoreCase("no")) {
            System.out.println("Creating new User Account and Logging to the website");
            fillingSignUpCredentials(firstname, lastname, email, password);
        } else {
            System.out.println("Provided wrong Input");
        }
    }
}
