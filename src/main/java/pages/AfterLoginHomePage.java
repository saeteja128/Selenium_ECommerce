package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class AfterLoginHomePage {

    CommonMethods commonethods;
    Actions actions;
    private WebDriver driver;
    private By MenDropDown = By.xpath("(//a[@class='level-top ui-corner-all'])[3]//span[contains(text(),'Men')]");
    private By WomenDropDown = By.xpath("(//a[@class='level-top ui-corner-all'])[2]//span[contains(text(),'Women')]");
    private By MenCategoryTops = By.xpath("");
    private By MenCategoryBottoms = By.xpath("");
    private By WomenCategoryTops = By.xpath("(//ul[@id='ui-id-2']//li)[2]//ul//li//a[@id='ui-id-9']//span[contains(text(),'Tops')]");
    private By WomenCategoryBottoms = By.xpath("((//ul[@id='ui-id-2']//li)[2]//ul//li)[6]//a//span[contains(text(),'Bottoms')]");
    public AfterLoginHomePage(WebDriver driver)
    {
        this.driver = driver;
    }

    public void GenderSelection(String gender)
    {
        System.out.println("Entered the method Gender Selection based on input");
        actions = new Actions(driver);
        commonethods = new CommonMethods(driver);

        WebElement genderElement = null;
        if(gender.equalsIgnoreCase("men"))
        {
            genderElement = driver.findElement(MenDropDown);
            
        } else if (gender.equalsIgnoreCase("women")) {
            genderElement = driver.findElement(WomenDropDown);
        }
        else {
            System.out.println("Incorrcet Keyword: " +gender);
        }
        actions.moveToElement(genderElement).perform();
        System.out.println("Hovered on " +(gender.toUpperCase())+ " Dropdown successfully");
    }


}
