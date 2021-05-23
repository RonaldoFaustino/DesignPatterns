package org.rahulshettyacademy.PageComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.rahulshettyacademy.AbstractComponents.AbstractComponent;
import org.rahulshettyacademy.AbstractComponents.SearchFlightAvail;

import java.util.HashMap;
import java.util.function.Consumer;

public class MultiTrip  extends AbstractComponent implements SearchFlightAvail {

    private By from = By.id("ctl00_mainContent_ddl_originStation1_CTXT");
    private By to = By.id("ctl00_mainContent_ddl_destinationStation1_CTXT");
    private By submit = By.id("ctl00_mainContent_btn_FIndFlights");
    private By multiCity_rdo = By.id("ctl00_mainContent_rbtnl_Trip_2");
    private By destination_2 = By.id("ctl00_mainContent_ddl_destinationStation2_CTXT");
    private  By origin2 = By.id("");
    private By from2 = By.id("ctl00_mainContent_ddl_originStation2_CTXT");
    private By modalPopUp = By.id("MultiCityModelAlert");

    public MultiTrip(WebDriver driver, By sectionElement) {
        super(driver, sectionElement);
    }

    @Override
    public void checkAvail(HashMap<String, String> reservationDetails) {
        makeStateReady(s->selectOriginCity(reservationDetails.get("origin")));
        selectDestiantionCity(reservationDetails.get("destination"));
        selectOriginCity2(reservationDetails.get("origin"));
        selectDestiantionCity2(reservationDetails.get("destination"));
    }

    public void selectOriginCity(String origin){
        findElement(from).click();
        findElement(By.xpath("//a[@value='"+origin+"']")).click();
    }

    public void selectDestiantionCity(String destination){
        findElement(to).click();
        findElement(By.xpath("(//a[@value='"+destination+"'])[2]")).click();
    }

    private void selectOriginCity2(String origin2) {
        findElement(from2).click();
        findElement(By.xpath("(//a[@value='"+origin2+"'])[2]")).click();
    }
    public void selectDestiantionCity2(String destination2){
        findElement(destination_2).click();
        findElement(By.xpath("(//a[@value='"+destination2+"'])[4]")).click();
    }

    public void makeStateReady(Consumer<MultiTrip> consumer){
        System.out.println("I am inside multi trip");
        findElement(multiCity_rdo).click();
        findElement(modalPopUp).click();
        waitForElementToDisappear(modalPopUp);
        consumer.accept(this);
        System.out.println("am done");
    }

}
