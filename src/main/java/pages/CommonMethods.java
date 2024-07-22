package pages;

import com.fasterxml.jackson.databind.annotation.JsonAppend;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Properties;

public class CommonMethods {
    private WebDriver driver;

    Properties prop;

    public CommonMethods(WebDriver driver) {
        this.driver = driver;
    }

    public void ClickButton(By locator) {
        driver.findElement(locator).click();
    }

    public void fillTextField(By locator, String sample) {
        driver.findElement(locator).sendKeys(sample);
    }

    public String getText(By locator) {
        String sampleText = driver.findElement(locator).getText();
        return sampleText;
    }


}
