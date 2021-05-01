package org.rahulshettyacademy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.rahulshettyacademy.PageObjects.TravelHomePage;
import org.testng.annotations.Test;

public class DemoTest {

    @Test
    public void flightTest(){
        System.setProperty("webdriver.chrome.driver", "C:\\Tools\\Driver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        TravelHomePage travelHomePage = new TravelHomePage(driver);
        travelHomePage.goTo();
        System.out.println(travelHomePage.getFooterNav().getFlightAttibute());
        System.out.println(travelHomePage.getNavigationBar().getFlightAttibute());
        System.out.println(travelHomePage.getFooterNav().getLinkCount());
        System.out.println(travelHomePage.getNavigationBar().getLinkCount());
        //one way, round trip, multi trip
        travelHomePage.roundTrip().checkAcaibility();
        travelHomePage.multiTrip().checkAcaibility();
        //checkAvaibility
        travelHomePage.checkAvaibility(rountTrip);
        travelHomePage.getLinksCount("footer");

    }
}
