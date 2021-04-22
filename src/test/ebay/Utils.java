package test.ebay;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static java.util.concurrent.TimeUnit.SECONDS;

public class Utils {
    public static void inputText(WebElement element, String text) {
        element.click();
        element.clear();
        element.sendKeys(text);
    }

    public static WebElement explicitlyWait(WebDriver driver, String xpath) {
        driver.manage().timeouts().implicitlyWait(0, SECONDS);
        WebDriverWait wait = new WebDriverWait(driver, 20);
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
        System.out.println("Element with xpath: " + xpath + " is displayed: " + element.isDisplayed());
        driver.manage().timeouts().implicitlyWait(30, SECONDS);
        return element;
    }
}
