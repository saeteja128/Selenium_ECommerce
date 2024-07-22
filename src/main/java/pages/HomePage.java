package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    CommonMethods commonmethods;
    private WebDriver driver;
    private By SignInButton = By.xpath("//li[@class='authorization-link']/a[contains(text(),'Sign In')][1]");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }
    public void getPageTitle() {
        String pageTitle = driver.getTitle();
        System.out.println("Page Title: " + pageTitle);
        System.out.println("Printed the Page Title successfully");
    }

    public void ClickingSignInButton() {
        commonmethods = new CommonMethods(driver);
        commonmethods.ClickButton(SignInButton);
        System.out.println("Clicked the Sign In Button successfully");

    }

}
