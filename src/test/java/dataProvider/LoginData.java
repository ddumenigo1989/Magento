package dataProvider;

import org.testng.annotations.DataProvider;

public class LoginData {
    @DataProvider(name = "users")
    public static Object[][] getLoginData(){
        return new Object[][]{
                //happy path
                {"scenario_correcto","Peter@mailinator.com","peter123"},
                //no registered
                {"scenario_incorrecto","John@mailinator.com","jhon123"},
                //without password
                //{"Peter@mailinator.com"," "},
                //with no username no password
                //{" "," "},

        };
    }

   /* @DataProvider(name = "users")
    public static Object[][] getLoginData(){
        Object[][] data = new Object[2][3];

        //primer juego de datos registrado
        data[0][0] = "Peter@mailinator.com";
        data[0][1] = "peter123";
        data[0][2] = "scenario_correcto";
        //segundo juego de datos no registrado
        data[1][0] = "John@mailinator.com";
        data[1][1] = "jhon123";
        data[1][2] = "scenario_incorrecto.";

        return data;
    }*/
}
