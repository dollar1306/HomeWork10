import com.paulhammant.ngwebdriver.ByAngular;
import com.paulhammant.ngwebdriver.NgWebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class Main {
        private static WebDriver chromeDriver;
        private static NgWebDriver ngWebDriver;

        @BeforeClass
        public static void beforeClass(){
            try {
                chromeDriver=SingleDriver.getDriverInstance();
                ngWebDriver = new NgWebDriver((JavascriptExecutor) chromeDriver);
                chromeDriver.get(Constans.WEB_TEST_NAME1);
                chromeDriver.manage().window().maximize();
                chromeDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            }catch (Exception e){
                e.printStackTrace();
                System.out.println("The driver not found");
            }
        }


        //1
//        @Test
//        public void testCheckBox() throws InterruptedException {
//
//            chromeDriver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
//            chromeDriver.findElement(By.id("checkbox")).isDisplayed();
//            chromeDriver.findElement(By.id("btn")).click();
//            chromeDriver.findElement(By.id("message")).isDisplayed();
//
//            chromeDriver.findElement(By.id("hidden")).click();
//            Thread.sleep(12000);
//            chromeDriver.findElement(By.cssSelector("div[style='']")).isDisplayed();
//
//            chromeDriver.findElement(By.id("rendered")).click();
//            WebDriverWait wait = new WebDriverWait(chromeDriver,10);
//            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("finish2")));
//            String output = chromeDriver.findElement(By.id("finish2")).getText();
//            assertEquals(output, "This is a new element");
//        }


        //2
//    @Test
//    public void testNgWebDriver(){
//            chromeDriver.get(Constans.WEB_TEST_NAME2);
//            ngWebDriver.waitForAngularRequestsToFinish();
//            WebElement firstName = chromeDriver.findElement(ByAngular.model("firstName"));
//            firstName.clear();
//            firstName.sendKeys("Boss:)))");
//            assertEquals(chromeDriver.findElement(By.xpath("//input")).getAttribute("value"),"Boss:)))");
//    }

        //3
        //Selenium defines different timeouts and wait mechanisms.
        // One of the timeouts is focused on the time a webpage needs to be loaded – the pageLoadTimeout
        // limits the time that the script allots for a web page to be displayed.



    //4
        public void testTestNG() throws InterruptedException {
            chromeDriver.get(Constans.WEB_TEST_NAME3);
            System.out.println(chromeDriver.findElement(By.id(Constans.SEVEN)).getSize());
            System.out.println(chromeDriver.findElement(By.id("six")).isDisplayed());
            WebCalculatorPage.pressNine();
            WebCalculatorPage.pressPlus();
            WebCalculatorPage.pressOne();
            WebCalculatorPage.pressEqual();
            Thread.sleep(1000);
            String result = "10";
            assertEquals(result, WebCalculatorPage.getResult());

    }


    @AfterClass
    public void afterAll() {
        chromeDriver.quit();
    }
}
