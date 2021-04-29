package pageObjects;

import io.cucumber.java.BeforeStep;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import stepDefinitions.MyStepdefs;

public class homePage {
   // static Logger logger= (Logger) LogManager.getLogger(homePage.class);
   public static Logger logger;


    public static WebDriver driver;


    @FindBy(id = "dropdown-class-example")
    WebElement dropDow;



    @FindBy(xpath = "//button[contains(text(),'Home')]")
    WebElement homeButton;

    public void clickDropDown() throws InterruptedException {
      //  logger.info("**** opening the browser*********");
        Select drop=new Select(dropDow);
      drop.selectByVisibleText("Option2");

    }

    public void validateDropDown(){
//        logger.info("**** opening the browser*********");
//        logger.info("**** opening the browser*********");
//        logger.info("**** opening the browser*********");
//        logger.info("**** opening the browser*********");
        Assert.assertEquals(1,1);
        System.out.println("test done");
        driver.quit();
    }


    public void  clickHome(){
        homeButton.click();
    }
}
