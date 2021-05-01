package org.rahulshettyacademy.PageComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.rahulshettyacademy.AbstractComponents.AbstractComponent;

public class FooterNav extends AbstractComponent {
    WebDriver driver;

    By flights = By.cssSelector("[title='Flights']");
    By links = By.cssSelector("a");

    public FooterNav(WebDriver driver, By sectionElement) {
        super(driver,sectionElement);
    }

    public String getFlightAttibute(){
        //driver.findElement(flights).click();
        //findElement(flights).click();
         return findElement(flights).getAttribute("class");
    }

    public int getLinkCount(){
        return findElements(links).size();
    }
}
