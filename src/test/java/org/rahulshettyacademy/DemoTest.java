package org.rahulshettyacademy;

import org.openqa.selenium.WebDriver;
import org.rahulshettyacademy.PageObjects.TravelHomePage;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
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
    public Object [][] getData() throws IOException {
//        //C:\out\reservationDetails.json
//        HashMap<String,String> reservationDetails = new <String, String>HashMap();
//        reservationDetails.put("origin", "MAA");
//        reservationDetails.put("destination", "HYD");
//        reservationDetails.put("destination", "DEL");
//
//        HashMap<String,String> reservationDetails1 = new <String, String>HashMap();
//        reservationDetails1.put("origin", "MAA");
//        reservationDetails1.put("destination", "HYD");
//        reservationDetails1.put("destination", "VTZ");
//
//        List<HashMap<String, String>> l = new ArrayList();
//        l.add(reservationDetails);
//        l.add(reservationDetails1);

        List<HashMap<String, String>> l=getJsonData(System.getProperty("user.dir") + "//src//test//java//org//rahulshettyacademy//DataLoads//reservationDetails.json");
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
