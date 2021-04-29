package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class interview {


    @Test
    public void test(){

        System.setProperty("webdriver.chrome.driver","resources/chromedriverer.exe");
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.amazon.com/");
        driver.manage().window().maximize();

        driver.quit();



    }


}
