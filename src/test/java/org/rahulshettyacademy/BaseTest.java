package org.rahulshettyacademy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {

    public WebDriver initializeDriver(){
        System.setProperty("webdriver.chrome.driver", "C:\\Tools\\Driver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        return driver;
    }
}
