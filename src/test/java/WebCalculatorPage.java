import org.openqa.selenium.By;

public class WebCalculatorPage {
    public static void pressNine(){
        SingleDriver.getDriverInstance().findElement(By.id("nine")).click();
    }
    public static void pressPlus(){
        SingleDriver.getDriverInstance().findElement(By.id("add")).click();
    }
    public static void pressOne(){
        SingleDriver.getDriverInstance().findElement(By.id("one")).click();
    }
    public static void pressEqual(){
        SingleDriver.getDriverInstance().findElement(By.id("equal")).click();
    }
    public static String getResult(){
        return SingleDriver.getDriverInstance().findElement(By.id("screen")).getText();
    }


}
