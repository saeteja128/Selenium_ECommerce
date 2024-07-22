package tests;

import Utils.ExcelDataSupplier;
import org.testng.annotations.Test;

public class e2eScenario extends BaseTest{

    @Test (priority = 1)
    public void NavigatingToLoginPage()
    {
        hp.getPageTitle();
        hp.ClickingSignInButton();
    }

    @Test (priority = 2, dataProvider = "getLoginData", dataProviderClass = ExcelDataSupplier.class)
    public void FillingLoginDetails(String existing_user, String eusername, String epassword, String first_name, String last_name, String email, String password)
    {
        lp.SignIn_SignUp(existing_user, eusername, epassword, first_name, last_name, email, password);
    }

    @Test (priority = 3, dataProvider = "getProductData", dataProviderClass = ExcelDataSupplier.class)
    public void FillingLoginDetails(String gender, String category_type, String product_type)
    {
        afterloginhomepage.GenderSelection(gender);
    }

}
