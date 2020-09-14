package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;


import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;


public class TestZalenium {

    RemoteWebDriver driver;
    DesiredCapabilities desiredCapabilities;
    WebDriverWait wait;

    @BeforeClass
    public void setup() throws MalformedURLException {
        desiredCapabilities= new DesiredCapabilities();
        desiredCapabilities.setCapability(CapabilityType.PLATFORM_NAME,Platform.LINUX);
        desiredCapabilities.setCapability(CapabilityType.BROWSER_NAME,BrowserType.FIREFOX);
        URL url = new URL("http://localhost:4444/wd/hub ");
        driver = new RemoteWebDriver(url, desiredCapabilities);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
        wait = new WebDriverWait(driver, 15);
        driver.get("https://www.keytorc.com");
    }

    @Test
    public void  test1(){
        ClickElementsByXpath("//a[@href= '/blog']", 0);
        ClickElementsByXpath("//a[@class= 'entire-meta-link']", 0);
        ClickElementsByXpath("//a[@href= '/blog']", 0);
        ClickElementsByXpath("//a[@class= 'entire-meta-link']", 1);
        ClickElementsByXpath("//a[@href= '/blog']", 0);
        ClickElementsByXpath("//a[@class= 'entire-meta-link']", 2);
    }
     public  void ClickElementsByXpath (String element, int x){
         wait.until(ExpectedConditions.elementToBeClickable(driver.findElements(By.xpath(element)).get(x))).click();
     }

    @AfterTest()
    public void tearDown() {
        driver.quit();
    }


}
