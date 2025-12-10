package utilities;

import org.testng.annotations.DataProvider;

public class Dataset {


    @DataProvider(name = "invalidData")
    public static Object invalidCredentials(){

        Object[][] data = {{"standard_user", "sauce", "Epic sadface: Username and password do not match any user in this service"},
                           {"standard", "secret_sauce", "Epic sadface: Username and password do not match any user in this service"}};


        return data;
    }
}
