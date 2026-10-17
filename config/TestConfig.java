package config;

//this class is used to defined basic configuration needed for execution like credentials and application link
public class TestConfig {

    //public static final String BASE_URL="https://www.saucedemo.com";
    public static final String BASE_URL="https://automationintesting.online";
    //public static final String LOGIN_URL = BASE_URL + "/";

    //for single user
/*    public static final String USERNAME = "standard_user";
    public static final String PASSWORD = "secret_sauce";*/

//    public static final String USERNAME = System.getenv("sauce_username");
//    public static final String PASSWORD = System.getenv("sauce_password");

    public static final String USERNAME = "admin";
    public static final String PASSWORD ="password";

    //for storage state file path
    public static final String USER_STATE = "auth/user.json";
//    public static final String EXPIRED_STATE = "auth/expired.json";
}
