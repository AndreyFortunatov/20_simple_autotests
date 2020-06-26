package helpers;

import static java.lang.Boolean.parseBoolean;

public class Environment {

    public final static String
            selenoidUrl = System.getProperty("selenoid_url", ""),
            selenoidUsername = System.getProperty("selenoid_username", ""),
            selenoidPassword = System.getProperty("selenoid_password", "");

//            yandexMarketItemName = System.getProperty("yandexMarketItem", "HUAWEI P40 Lite");

    public final static boolean
            isHeadless = parseBoolean(System.getProperty("isHeadless", "false")),
            isSelenoid = selenoidUrl != "";
}
