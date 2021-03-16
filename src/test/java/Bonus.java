import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.testng.AssertJUnit.assertEquals;

public class Bonus {
    private static WebDriver chromeDriver;

    @BeforeClass
    public static void Bonus(){
        chromeDriver = SingleDriver.getDriverInstance();
    }

    @Test
    public void testTheMarket(){
        chromeDriver.get(Constans.THE_MARKET);
        chromeDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        String in = chromeDriver.getPageSource();
        int i = 0;
        Pattern p = Pattern.compile("news");
        Matcher m = p.matcher(in);
        while (m.find()) {
            i++;
        }
        System.out.println(i+" times news exists in the page");
    }

//    @Test
//    public void testJavaScript(){
//        ((JavascriptExecutor)chromeDriver).executeScript("window.print();");
//
//    }

    @Test
    public void testQuestion2WithNgTest(){
chromeDriver.get(Constans.WEB_TEST_NAME2);
        WebElement firstName = chromeDriver.findElement(By.className("ng-pristine"));
        firstName.clear();
        firstName.sendKeys("Alex");
        assertEquals(chromeDriver.findElement(By.xpath("//input")).getAttribute("value"),"Alex");
    }


    @AfterClass
    public void afterAll() {
        chromeDriver.quit();
    }
}
