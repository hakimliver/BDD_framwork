package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.en.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import pageObjects.homePage;
import testBase.webAPI;



public class MyStepdefs extends webAPI {
   // public static Logger logger;
     static Logger logger= LogManager.getLogger(MyStepdefs.class);

    static WebDriver driver;

    static homePage HomePage;

    @BeforeStep
    public static void getInit() {
        HomePage = PageFactory.initElements(driver, homePage.class);
    }
    @After
    public void closeBrowser() {
        driver.quit();
    }


    @Given("I am at home page")
    public void iAmAtHomePage() {
        logger.info("**** opening the browser*********");
        System.setProperty("webdriver.chrome.driver", "resources/chromedriverer.exe");
        driver = new ChromeDriver();
        logger.info("******* naviage to the url ********");
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
    }
    @When("I click on home page")

    public void iClickOnHomePage() {
        logger.info("********* opening the browser *********");
        HomePage.clickHome();
    }
    @Then("I verify I am at right page")
    public void iVerifyIAmAtRightPage() {
        logger.info("**** validation********");
       HomePage.validateDropDown();
    }

}
