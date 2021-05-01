package org.rahulshettyacademy.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.rahulshettyacademy.PageComponents.FooterNav;
import org.rahulshettyacademy.PageComponents.NavigationBar;

public class TravelHomePage {


    By sectionElement =  By.id("traveller-home");
    By footerNavSectionElement = By.id("buttons");
    WebDriver driver;

    public TravelHomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void goTo(){
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

    }

    public NavigationBar getNavigationBar(){
        return new NavigationBar(driver,footerNavSectionElement);
    }

    public FooterNav getFooterNav(){
       return new FooterNav(driver,sectionElement);
    }

//    public void getLinksCount(String algo){
//        if(algo.equalsIgnoreCase("footer")){
//            new FooterNav().getLinkCount();
//        }
//    }
}
