package testBase;

import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class webAPI {



    public static WebDriver driver = null;
    public static WebDriverWait wait;
    public static Wait fluentWait;
   // static DataReader dataReader = new DataReader();
  // public static Logger logger;





    public void clickOnElement(String locator) {
        try {
            driver.findElement(By.cssSelector(locator)).click();
        } catch (Exception ex) {
            try {
                driver.findElement(By.className(locator)).click();
            } catch (Exception ex2) {
                try {
                    driver.findElement(By.id(locator)).click();
                } catch (Exception ex3) {
                    driver.findElement(By.xpath(locator)).click();
                }
            }
        }
    }

    public void typeOnElement(String locator, String value) {
        try {
            driver.findElement(By.cssSelector(locator)).sendKeys(value);
        } catch (Exception ex) {
            driver.findElement(By.xpath(locator)).sendKeys(value);
        }
    }

    public static void typeOnElementNEnter(String locator, String value) {
        try {
            driver.findElement(By.cssSelector(locator)).sendKeys(value, Keys.ENTER);
        } catch (Exception ex1) {
            try {
                System.out.println("First Attempt was not successful");
                driver.findElement(By.name(locator)).sendKeys(value, Keys.ENTER);
            } catch (Exception ex2) {
                try {
                    System.out.println("Second Attempt was not successful");
                    driver.findElement(By.xpath(locator)).sendKeys(value, Keys.ENTER);
                } catch (Exception ex3) {
                    System.out.println("Third Attempt was not successful");
                    driver.findElement(By.id(locator)).sendKeys(value, Keys.ENTER);
                }
            }
        }
    }

    public static void typeOnElementNEnter(String locator, String value, WebDriver driver1) {
        try {
            driver1.findElement(By.cssSelector(locator)).sendKeys(value, Keys.ENTER);
        } catch (Exception ex1) {
            try {
                System.out.println("First Attempt was not successful");
                driver1.findElement(By.id(locator)).sendKeys(value, Keys.ENTER);
            } catch (Exception ex2) {
                try {
                    System.out.println("Second Attempt was not successful");
                    driver1.findElement(By.name(locator)).sendKeys(value, Keys.ENTER);
                } catch (Exception ex3) {
                    System.out.println("Third Attempt was not successful");
                    driver1.findElement(By.xpath(locator)).sendKeys(value, Keys.ENTER);
                }
            }
        }
    }

    public void clearField(String locator) {
        driver.findElement(By.id(locator)).clear();
    }

    public void navigateBack() {
        driver.navigate().back();
    }

    public static void clickOnElement(String locator, WebDriver driver1) {
        try {
            driver1.findElement(By.cssSelector(locator)).click();
        } catch (Exception ex1) {
            try {
                driver1.findElement(By.xpath(locator)).click();
            } catch (Exception ex2) {
                driver1.findElement(By.id(locator)).click();
            }
        }
    }

    public void typeOnInputField(String locator, String value) {
        try {
            driver.findElement(By.cssSelector(locator)).sendKeys(value);
        } catch (Exception ex) {
            driver.findElement(By.id(locator)).sendKeys(value);
        }

    }

    public void clickByXpath(String locator) {
        driver.findElement(By.xpath(locator)).click();
    }

    public void typeByCss(String locator, String value) {
        driver.findElement(By.cssSelector(locator)).sendKeys(value);
    }

    public void typeByCssNEnter(String locator, String value) {
        driver.findElement(By.cssSelector(locator)).sendKeys(value, Keys.ENTER);
    }

    public void typeByXpath(String locator, String value) {
        driver.findElement(By.xpath(locator)).sendKeys(value);
    }

    public void takeEnterKeys(String locator) {
        driver.findElement(By.cssSelector(locator)).sendKeys(Keys.ENTER);
    }

    public void clearInputField(String locator) {
        driver.findElement(By.cssSelector(locator)).clear();
    }

    public List<WebElement> getListOfWebElementsById(String locator) {
        List<WebElement> list = new ArrayList<WebElement>();
        list = driver.findElements(By.id(locator));
        return list;
    }

    public static List<String> getTextFromWebElements(String locator) {
        List<WebElement> element = new ArrayList<WebElement>();
        List<String> text = new ArrayList<String>();
        element = driver.findElements(By.cssSelector(locator));
        for (WebElement web : element) {
            String st = web.getText();
            text.add(st);
        }
        return text;
    }

    public static List<String> getTextFromWebElements(String locator, WebDriver driver1) {
        List<WebElement> element = new ArrayList<WebElement>();
        List<String> text = new ArrayList<String>();
        element = driver1.findElements(By.cssSelector(locator));
        for (WebElement web : element) {
            String st = web.getText();
            text.add(st);
        }
        return text;
    }

    public static List<WebElement> getListOfWebElementsByCss(String locator) {
        List<WebElement> list = new ArrayList<WebElement>();
        list = driver.findElements(By.cssSelector(locator));
        return list;
    }

    public static List<WebElement> getListOfWebElementsByCss(String locator, WebDriver driver1) {
        List<WebElement> list = new ArrayList<WebElement>();
        list = driver1.findElements(By.cssSelector(locator));
        return list;
    }

    public List<WebElement> getListOfWebElementsByXpath(String locator) {
        List<WebElement> list = new ArrayList<WebElement>();
        list = driver.findElements(By.xpath(locator));
        return list;
    }

    public String getCurrentPageUrl() {
        String url = driver.getCurrentUrl();
        return url;
    }

    public void navigateForward() {
        driver.navigate().forward();
    }

    public String getTextByCss(String locator) {
        String st = driver.findElement(By.cssSelector(locator)).getText();
        return st;
    }

    public String getTextByXpath(String locator) {
        String st = driver.findElement(By.xpath(locator)).getText();
        return st;
    }

    public String getTextById(String locator) {
        return driver.findElement(By.id(locator)).getText();
    }

    public String getTextByName(String locator) {
        String st = driver.findElement(By.name(locator)).getText();
        return st;
    }

    public List<String> getListOfString(List<WebElement> list) {
        List<String> items = new ArrayList<String>();
        for (WebElement element : list) {
            items.add(element.getText());
        }
        return items;
    }

    public void selectOptionByVisibleText(WebElement element, String value) {
        Select select = new Select(element);
        select.selectByVisibleText(value);
    }

    public static void sleepFor(int sec) throws InterruptedException {
        Thread.sleep(sec * 1000);
    }

    public static void mouseHover(WebElement element) {
        try {
            Actions hover = new Actions(driver);
            hover.moveToElement(element).perform();
        } catch (Exception ex) {
            driver.navigate().refresh();
            System.out.println("1st mouse-hover attempt failed - Attempting 2nd time");
            WebDriverWait wait = new WebDriverWait(driver, 10);
            Actions hover = new Actions(driver);
            wait.until(ExpectedConditions.visibilityOf(element));
            hover.moveToElement(element).perform();
        }
    }

    public void mouseHoverByCSS(String locator) {
        try {
            WebElement element = driver.findElement(By.cssSelector(locator));
            Actions action = new Actions(driver);
            Actions hover = action.moveToElement(element);
        } catch (Exception ex) {
            System.out.println("First attempt has been done, This is second try");
            WebElement element = driver.findElement(By.cssSelector(locator));
            Actions action = new Actions(driver);
            action.moveToElement(element).perform();
        }
    }

    public void mouseHoverByXpath(String locator) {
        try {
            WebElement element = driver.findElement(By.xpath(locator));
            Actions action = new Actions(driver);
            Actions hover = action.moveToElement(element);
        } catch (Exception ex) {
            System.out.println("First attempt has been done, This is second try");
            WebElement element = driver.findElement(By.xpath(locator));
            Actions action = new Actions(driver);
            action.moveToElement(element).perform();
        }
    }

    //handling Alert
    public void okAlert() {
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    public void cancelAlert() {
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
    }

    //iFrame Handle
    public void iframeHandle(WebElement element) {
        driver.switchTo().frame(element);
    }

    public void goBackToHomeWindow() {
        driver.switchTo().defaultContent();
    }

    //get Links
    public void getLinks(String locator) {
        driver.findElement(By.linkText(locator)).findElement(By.tagName("a")).getText();
    }

    //Taking Screen shots
    public void takeScreenShot() throws IOException {
        File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        //FileUtils.copyFile(file, new File("screenShots.png"));
    }

    //Synchronization
    public void waitUntilClickAble(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public void waitUntilVisible(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void waitUntilSelectable(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        boolean element = wait.until(ExpectedConditions.elementToBeSelected(locator));
    }

    public static void fluentWaitWithPolling() {
        fluentWait = new FluentWait(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(Exception.class);
    }

    public void upLoadFile(String locator, String path) {
        driver.findElement(By.cssSelector(locator)).sendKeys(path);
        /* path example to upload a file/image
           path= "C:\\Users\\rrt\\Pictures\\ds1.png";
         */
    }

    public void clearInput(String locator) {
        driver.findElement(By.cssSelector(locator)).clear();
    }

    public void keysInput(String locator) {
        driver.findElement(By.cssSelector(locator)).sendKeys(Keys.ENTER);
    }

    //Handling New Tabs
    public static WebDriver handleNewTab(WebDriver driver1) {
        String oldTab = driver1.getWindowHandle();
        List<String> newTabs = new ArrayList<String>(driver1.getWindowHandles());
        newTabs.remove(oldTab);
        driver1.switchTo().window(newTabs.get(0));
        return driver1;
    }

    public static boolean isPopUpWindowDisplayed(WebDriver driver1, String locator) {
        boolean value = driver1.findElement(By.cssSelector(locator)).isDisplayed();
        return value;
    }

    public void typeOnInputBox(String locator, String value) {
        try {
            driver.findElement(By.id(locator)).sendKeys(value, Keys.ENTER);
        } catch (Exception ex1) {
            System.out.println("ID locator didn't work");
        }
        try {
            driver.findElement(By.name(locator)).sendKeys(value, Keys.ENTER);
        } catch (Exception ex2) {
            System.out.println("Name locator didn't work");
        }
        try {
            driver.findElement(By.cssSelector(locator)).sendKeys(value, Keys.ENTER);
        } catch (Exception ex3) {
            System.out.println("CSS locator didn't work");
        }
    }


    // Customer Made Helper Methods for Amex.com
    public void brokenLink() throws IOException {
        //Step:1-->Get the list of all the links and images
        List<WebElement> linkslist = driver.findElements(By.tagName("a"));
        linkslist.addAll(driver.findElements(By.tagName("img")));

        System.out.println("Total number of links and images--------->>> " + linkslist.size());

        List<WebElement> activeLinks = new ArrayList<WebElement>();
        //Step:2-->Iterate linksList: exclude all links/images which does not have any href attribute
        for (int i = 0; i < linkslist.size(); i++) {
            //System.out.println(linkslist.get(i).getAttribute("href"));
            if (linkslist.get(i).getAttribute("href") != null && (!linkslist.get(i).getAttribute("href").contains("javascript") && (!linkslist.get(i).getAttribute("href").contains("mailto")))) {
                activeLinks.add(linkslist.get(i));
            }
        }
        System.out.println("Total number of active links and images-------->>> " + activeLinks.size());

        //Step:3--> Check the href url, with http connection api
        for (int j = 0; j < activeLinks.size(); j++) {
            HttpURLConnection connection = (HttpURLConnection) new URL(activeLinks.get(j).getAttribute("href")).openConnection();
            connection.connect();
            String response = connection.getResponseMessage();
            connection.disconnect();
            System.out.println(activeLinks.get(j).getAttribute("href") + "--------->>> " + response);
        }
    }

    public void inputValueInTextBoxByWebElement(WebElement webElement, String value) {
        webElement.sendKeys(value + Keys.ENTER);
    }

    public void clearInputBox(WebElement webElement) {
        webElement.clear();
    }

    public String getTextByWebElement(WebElement webElement) {
        String text = webElement.getText();
        return text;
    }

    public void getCurrentTime() {
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        Date date = new Date();
        System.out.println(formatter.format(date));
        System.out.println(" my test suite started at this time --> " + formatter.format(date));
    }

    private ArrayList<String> getList(By by) {
        List<WebElement> list = driver.findElements(by);
        System.out.println(list.size());
        ArrayList<String> linkList = new ArrayList<String>();
        for (int i = 0; i <= list.size() - 1; i++) {
            linkList.add(list.get(i).getText());
            System.out.println(list.get(i).getText() + " Added to linkList Array");
        }
        return linkList;
    }

    public static void clickJScript(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);
    }

    public void scrollToElementJScript(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", element);
    }

    public static void mouseHoverJScript(WebElement element) {
        try {
            if (isElementPresent(element)) {
                String mouseOverScript = "if(document.createEvent){var evObj = document.createEvent('MouseEvents');evObj.initEvent('mouseover', true, false); arguments[0].dispatchEvent(evObj);} else if(document.createEventObject) { arguments[0].fireEvent('onmouseover');}";
                ((JavascriptExecutor) driver).executeScript(mouseOverScript, element);
                System.out.println("Hover performed\n");
            } else {
                System.out.println("UNABLE TO HOVER OVER ELEMENT\n");
            }
        } catch (StaleElementReferenceException e) {
            System.out.println("ELEMENT WITH " + element
                    + " IS NOT ATTACHED TO THE PAGE DOCUMENT"
                    + e.getStackTrace());
        } catch (NoSuchElementException e) {
            System.out.println("ELEMENT " + element + " WAS NOT FOUND IN DOM"
                    + e.getStackTrace());
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("ERROR OCCURED WHILE HOVERING\n"
                    + e.getStackTrace());
        }
    }

    public static boolean isElementPresent(WebElement element) {
        boolean flag = false;
        try {
            if (element.isDisplayed()
                    || element.isEnabled())
                flag = true;
        } catch (NoSuchElementException e) {
            flag = false;
        } catch (StaleElementReferenceException e) {
            flag = false;
        }
        return flag;
    }

    // --------------------- EDIT BOX / TYPE -----------------------
    public void typeByXpath1(String loc, String val) {
        driver.findElement(By.xpath(loc)).clear();
        driver.findElement(By.xpath(loc)).sendKeys(val);
    }

    public void typeById(String loc, String val) {
        driver.findElement(By.id(loc)).sendKeys(val);
    }

    public void typeByCss1(String loc, String val) {
        driver.findElement(By.cssSelector(loc)).clear();
        driver.findElement(By.cssSelector(loc)).sendKeys(val);
    }

    public void typeByName(String loc, String val) {
        driver.findElement(By.name(loc)).sendKeys(val);
    }

    // ------------------- CLICK -----------------
    public void clickByXpath1(String loc) {
        driver.findElement(By.xpath(loc)).click();
    }

    public void clickByCss(String loc) {
        driver.findElement(By.cssSelector(loc)).click();
    }

    public void clickById(String loc) {
        driver.findElement(By.id(loc)).click();
    }

    public void clickByName(String loc) {
        driver.findElement(By.name(loc)).click();
    }

    public void clickByLinkText(String loc) {
        driver.findElement(By.linkText(loc)).click();
    }

    // ---------------- RADIO BUTTON

    public void assertEqualByXpath(String loc, String expValue) {
        String act = driver.findElement(By.xpath(loc)).getText();
        // act is coming from Domain -- the one developer build and release
        String exp = expValue; // exp is coming from Requirement or Mock-up
        Assert.assertEquals(act, exp);
    }

    // Slider Handlaing
    // https://stackoverflow.com/questions/15171745/how-to-slidemove-slider-in-selenium-webdriver

    public void waitTimeExplicit(String locator) {
        // Explicit wait
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));
    }

    public void waitTimeUsingFluent(String locator) {
        // Fluent Wait
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(2))
                .withMessage("Time out after 30 seconds")
                .ignoring(NoSuchElementException.class);
    }


    public void clickOnElement1(String locator) {
        try {
            driver.findElement(By.cssSelector(locator)).click();
        } catch (Exception ex) {
            try {
                driver.findElement(By.xpath(locator)).click();
            } catch (Exception ex1) {
                try {
                    driver.findElement(By.id(locator)).click();
                } catch (Exception ex2) {
                    try {
                        driver.findElement(By.name(locator)).click();
                    } catch (Exception ex3) {
                        try {
                            driver.findElement(By.className(locator)).click();
                        } catch (Exception ex4) {
                            driver.findElement(By.tagName(locator)).click();
                        }
                    }
                }
            }
        }
    }


    public void typeOnElement1(String locator, String value) {
        try {
            driver.findElement(By.cssSelector(locator)).sendKeys(value);
        } catch (Exception ex) {
            try {
                driver.findElement(By.xpath(locator)).sendKeys(value);
            } catch (Exception ex1) {
                try {
                    driver.findElement(By.id(locator)).sendKeys(value);
                } catch (Exception ex2) {
                    try {
                        driver.findElement(By.name(locator)).sendKeys(value);
                    } catch (Exception ex3) {
                        try {
                            driver.findElement(By.className(locator)).sendKeys(value);
                        } catch (Exception ex4) {
                            driver.findElement(By.tagName(locator)).sendKeys(value);
                        }
                    }
                }
            }
        }
    }


    public void clickOnLink(String locator) {
        try {
            driver.findElement(By.linkText(locator)).click();
        } catch (Exception ex) {
            driver.findElement(By.partialLinkText(locator)).click();
        }
    }

    public void getTitle() {
        driver.getTitle();
    }

    public void clearField1(String locator) {
        try {
            driver.findElement(By.cssSelector(locator)).clear();
        } catch (Exception ex) {
            try {
                driver.findElement(By.xpath(locator)).clear();
            } catch (Exception ex1) {
                try {
                    driver.findElement(By.id(locator)).clear();
                } catch (Exception ex2) {
                    try {
                        driver.findElement(By.name(locator)).clear();
                    } catch (Exception ex3) {
                        try {
                            driver.findElement(By.className(locator)).clear();
                        } catch (Exception ex4) {
                            driver.findElement(By.tagName(locator)).clear();
                        }
                    }
                }
            }
        }
    }


    public String getCurrentUrl() {
        String url = driver.getCurrentUrl();
        return url;
    }


    /**
     * Helper Methods To Use in Asserts
     */

    // Hover over dropdown and make sure it is visible (built-in page refresh)
    public void hoverOverDropdown(WebElement elementToHover) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(elementToHover));

        try {
            Thread.sleep(1000);
            mouseHover(elementToHover);
            System.out.println("Hovered over dropdown\n");
        } catch (InterruptedException e) {
            try {
                driver.navigate().refresh();
                System.out.println("Couldn't hover over dropdown --- Refreshing page\n");

                wait.until(ExpectedConditions.visibilityOf(elementToHover));
                Thread.sleep(1000);

                mouseHoverJScript(elementToHover);
            } catch (Exception e1) {
                e.getMessage();
            }
        }
    }

    // Gets text from List<WebElements> and compares against expected String array from Excel workbook
//    public static boolean compareWebElementListToExpectedStringArray(By by, String path, String sheetName) throws IOException {
//        List<WebElement> actualList = driver.findElements(by);
//        String[] expectedList = dataReader.fileReaderStringXSSF(path, sheetName);
//
//        String[] actual = new String[actualList.size()];
//
//        for (int j = 0; j < actualList.size(); j++) {
//            actual[j] = actualList.get(j).getText().replaceAll("&amp;", "&").replaceAll("’", "'").trim();
//            actual[j].replaceAll("&amp;", "&").replaceAll("’", "'").trim();
////            escapeHtml4(actual[j]);
////            escapeHtml3(actual[j]);
//        }
//
//        int falseCount = 0;
//        boolean flag = false;
//        for (int i = 0; i < expectedList.length; i++) {
//            if (actual[i].equalsIgnoreCase(expectedList[i])) {
//                flag = true;
//                System.out.println("ACTUAL STRING " + (i + 1) + ": " + actual[i]);
//                System.out.println("EXPECTED STRING " + (i + 1) + ": " + expectedList[i] + "\n");
//            } else {
//                System.out.println("***FAILED AT INDEX " + (i + 1) + "***\nEXPECTED STRING: " + expectedList[i] +
//                        "\nACTUAL STRING: " + actual[i] + "\n");
//                falseCount++;
//            }
//        }
//        if (falseCount > 0) {
//            flag = false;
//        }
//        return flag;
//    }

    // Gets text from String[] and compares against expected String array from Excel workbook
//    public static boolean compareTextListToExpectedStringArray(String[] actualArray, String path, String sheetName) throws IOException {
//        String[] expectedList = dataReader.fileReaderStringXSSF(path, sheetName);
//
//        int falseCount = 0;
//        boolean flag = false;
//        for (int i = 0; i < expectedList.length; i++) {
//            if (actualArray[i].replaceAll("&amp;", "&").replaceAll("’", "'").trim().equalsIgnoreCase(expectedList[i])) {
//                flag = true;
//                System.out.println("ACTUAL " + (i + 1) + ": " + actualArray[i]);
//                System.out.println("EXPECTED " + (i + 1) + ": " + expectedList[i] + "\n");
//            } else {
//                System.out.println("FAILED AT INDEX " + (i + 1) + "\nEXPECTED STRING: " + expectedList[i] + "\nACTUAL STRING: "
//                        + actualArray[i]);
//                falseCount++;
//            }
//        }
//        if (falseCount > 0) {
//            flag = false;
//        }
//        return flag;
//    }

    // Compares actual string against an expected string from Excel workbook
//    public static boolean compareTextToExpectedString(String actual, String path, String sheetName) throws IOException {
//        String[] expectedArray = dataReader.fileReaderStringXSSF(path, sheetName);
//        String expected = expectedArray[0];
//
//        boolean flag;
//        if (actual.replaceAll("&amp;", "&").replaceAll("’", "'").trim().equalsIgnoreCase(expected)) {
//            flag = true;
//            System.out.println("ACTUAL STRING: " + actual + "\nEXPECTED STRING: " + expected);
//        } else {
//            flag = false;
//            System.out.println("***DOES NOT MATCH***\nEXPECTED STRING: " + expected + "\nACTUAL STRING: " + actual);
//        }
//        return flag;
//    }

    // Gets text from List<WebElements> and compares against expected String array from Excel workbook
//    public static boolean compareAttributeListToExpectedStringArray(By by, String attribute, String path, String sheetName) throws IOException {
//        List<WebElement> actualList = driver.findElements(by);
//        String[] expectedList = dataReader.fileReaderStringXSSF(path, sheetName);
//
//        String[] actual = new String[actualList.size()];
//
//        for (int j = 0; j < actualList.size(); j++) {
//            actual[j] = actualList.get(j).getAttribute(attribute).replaceAll("&amp;", "&").replaceAll("’", "'").replaceAll("<br>", "\n").trim();
//            actual[j].replaceAll("&amp;", "&").replaceAll("’", "'").replaceAll("<br>", "\n").trim();
////            escapeHtml4(actual[j]);
////            escapeHtml3(actual[j]);
//        }
//
//        int falseCount = 0;
//        boolean flag = false;
//        for (int i = 0; i < expectedList.length; i++) {
//            if (actual[i].equalsIgnoreCase(expectedList[i])) {
//                flag = true;
//                System.out.println("ACTUAL " + attribute.toUpperCase() + " " + (i + 1) + ": " + actual[i]);
//                System.out.println("EXPECTED " + attribute.toUpperCase() + " " + (i + 1) + ": " + expectedList[i] + "\n");
//            } else {
//                System.out.println("FAILED AT INDEX " + (i + 1) + "\nEXPECTED " + attribute.toUpperCase() + ": " + expectedList[i] +
//                        "\nACTUAL " + attribute.toUpperCase() + ": " + actual[i] + "\n");
//                falseCount++;
//            }
//        }
//        if (falseCount > 0) {
//            flag = false;
//        }
//        return flag;
//    }

//    public static boolean compareListSizeToExpectedCount(By by, String path, String sheetName) throws IOException {
//        int[] expectedArray = dataReader.fileReaderIntegerXSSF(path, sheetName);
//        int expected = expectedArray[0];
//
//        List<WebElement> dropdownList = driver.findElements(by);
//        int actual = dropdownList.size();
//        System.out.println("Counted " + actual + " elements\n");
//
//        boolean flag;
//        if (actual == expected) {
//            flag = true;
//            System.out.println("ACTUAL COUNT: " + actual + "\nEXPECTED COUNT: " + expected);
//        } else {
//            flag = false;
//            System.out.println("***SIZE DOES NOT MATCH***\nACTUAL COUNT: " + actual + "\nEXPECTED COUNT: " + expected + "\n");
//        }
//        return flag;
//    }


    // Switches to newly opened tab, gets URL, closes new tab, switches back to parent tab
    public static String switchToTabAndGetURL() {
        java.util.Iterator<String> iter = driver.getWindowHandles().iterator();

        String parentWindow = iter.next();
        String childWindow = iter.next();

        driver.switchTo().window(childWindow);
        System.out.println("Switched to \"" + driver.getTitle() + "\" window");
        String actualURL = driver.getCurrentUrl();
        System.out.println(actualURL + "\n");
        driver.close();

        driver.switchTo().window(parentWindow);
        System.out.println("Switched back to \"" + driver.getTitle() + "\" window");
        System.out.println(driver.getCurrentUrl() + "\n");

        return actualURL;
    }

    // Switches to newly opened tab, gets URL and compares to expected URL in Excel workbook
//    public static boolean switchToTabAndCompareURL(String path, String sheetName) throws IOException {
//        java.util.Iterator<String> iter = driver.getWindowHandles().iterator();
//
//        String parentWindow = iter.next();
//        String childWindow = iter.next();
//
//        driver.switchTo().window(childWindow);
//        System.out.println("Switched to \"" + driver.getTitle() + "\" window");
//        String actualURL = driver.getCurrentUrl();
//        System.out.println(actualURL + "\n");
//        driver.close();
//
//        driver.switchTo().window(parentWindow);
//        System.out.println("Switched back to \"" + driver.getTitle() + "\" window");
//        System.out.println(driver.getCurrentUrl() + "\n");
//
//        boolean flag = compareTextToExpectedString(actualURL, path, sheetName);
//
//        return flag;
//    }

    // Loops through list of dropdown elements, clicks on each link individually, grabs each page URL, inserts into String[],
    // closes child page & switches back to parent page
    //
    // Compares String[] to expected URLs in Excel workbook
//    public static boolean clickLinksSwitchTabsCompareURLs(WebElement hoverElement, By by, String path, String sheetName) throws InterruptedException, IOException {
//        Wait fluentWait = new FluentWait(driver)
//                .withTimeout(Duration.ofSeconds(10))
//                .pollingEvery(Duration.ofSeconds(2))
//                .ignoring(Exception.class);
//        fluentWaitWithPolling();
//
//        List<WebElement> list = driver.findElements(by);
//        int listSize = list.size();
//        String[] actualURLs = new String[listSize];
//
//        int i = 0;
//        for (WebElement element : list) {
//            if (hoverElement.isEnabled()) {
//                fluentWait.until(ExpectedConditions.elementToBeClickable(element));
//                element.sendKeys(Keys.CONTROL, Keys.ENTER);
//                Thread.sleep(800);
//                actualURLs[i] = switchToTabAndGetURL();
//            } else if (!(hoverElement.isEnabled())) {
//                try {
//                    mouseHoverJScript(hoverElement);
//                } catch (Exception e) {
//                    mouseHover(hoverElement);
//                }
//                fluentWait.until(ExpectedConditions.elementToBeClickable(element));
//                element.sendKeys(Keys.CONTROL, Keys.ENTER);
//                Thread.sleep(800);
//                actualURLs[i] = switchToTabAndGetURL();
//            }
//            i++;
//        }
//        boolean flag = compareTextListToExpectedStringArray(actualURLs, path, sheetName);
//
//        return flag;
//    }


//======================================my helper methods =============================================================================






    public void mouseOverXPATH(String element) {
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(By.xpath(element))).build().perform();
    }

    public void mouseOverID(String element) {
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(By.id(element))).build().perform();
    }

    public void mouseOverCSS(String element) {
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(By.cssSelector(element))).build().perform();
    }

    public void mouseOverNAME(String element) {
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(By.name(element))).build().perform();
    }

    public void mouseOverLINKTEXT(String element) {
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(By.linkText(element))).build().perform();
    }

    public void mouseOverCLASS(String element) {
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(By.className(element))).build().perform();
    }




    public static void verifyLinkActive(String linkUrl) {
        try {
            URL url = new URL(linkUrl);

            HttpURLConnection httpURLConnect = (HttpURLConnection) url.openConnection();

            httpURLConnect.setConnectTimeout(3000);

            httpURLConnect.connect();

            if (httpURLConnect.getResponseCode() == 200) {
                System.out.println(linkUrl + " - " + httpURLConnect.getResponseMessage());
            }
            if (httpURLConnect.getResponseCode() == HttpURLConnection.HTTP_NOT_FOUND) {
                System.out.println(linkUrl + " - " + httpURLConnect.getResponseMessage() + " - " + HttpURLConnection.HTTP_NOT_FOUND);
            }
        } catch (Exception e) {

        }
    }



//
//    public void pickDepart(String month, String date) {
//
//        while (true) {
//            String monthText = monthSelectText.getText();
//            if (monthText.equals(month)) {
//                break;
//            } else {
//                nextMonth.click();
//            }
//        }
//
//        for (WebElement allDates : calendarDates) {
//            String dateText = allDates.getText();
//            if (dateText.equals(date)) {
//                allDates.click();
//            }
//        }
//
//    }




    public static void selectDateByJS(WebDriver driver ,WebElement element, String dateVal){

        JavascriptExecutor js=((JavascriptExecutor)driver);
        js.executeScript("arguments[0].setAttribute('value','"+dateVal+"');",element);
    }



}
