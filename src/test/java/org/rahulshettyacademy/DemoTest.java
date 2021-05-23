package org.rahulshettyacademy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.rahulshettyacademy.PageComponents.MultiTrip;
import org.rahulshettyacademy.PageComponents.RoundTrip;
import org.rahulshettyacademy.PageObjects.TravelHomePage;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DemoTest extends BaseTest{

    WebDriver driver;
    TravelHomePage travelHomePage;

    @BeforeTest
    public void setup(){
        driver = initializeDriver();
        travelHomePage = new TravelHomePage(driver);
    }

    @Test(dataProvider = "getData")
    public void flightTest(HashMap<String, String> reservationDetails){

        travelHomePage.goTo();
        System.out.println(travelHomePage.getFooterNav().getFlightAttibute());
        System.out.println(travelHomePage.getNavigationBar().getFlightAttibute());
        System.out.println(travelHomePage.getFooterNav().getLinkCount());
        System.out.println(travelHomePage.getNavigationBar().getLinkCount());
        //one way, round trip, multi trip
        //checkAvaibility
        travelHomePage.setBookingStrategy("multitrip");

//        HashMap<String,String> reservationDetails = new <String, String>HashMap();
//        reservationDetails.put("origin", "MAA");
//        reservationDetails.put("destination", "HYD");
//        reservationDetails.put("destination", "DEL");

        travelHomePage.checkAvail(reservationDetails);
        //travelHomePage.getLinksCount("footer");
    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }

    @DataProvider
    public Object [][] getData(){
        //C:\out\reservationDetails.json
        HashMap<String,String> reservationDetails = new <String, String>HashMap();
        reservationDetails.put("origin", "MAA");
        reservationDetails.put("destination", "HYD");
        reservationDetails.put("destination", "DEL");

        HashMap<String,String> reservationDetails1 = new <String, String>HashMap();
        reservationDetails1.put("origin", "MAA");
        reservationDetails1.put("destination", "HYD");
        reservationDetails1.put("destination", "VTZ");

        List<HashMap<String, String>> l = new ArrayList();
        l.add(reservationDetails);
        l.add(reservationDetails1);


        return new Object[][]{
                {
                    l.get(0)
                },
                {
                    l.get(1)
                }
        };
    }
}
