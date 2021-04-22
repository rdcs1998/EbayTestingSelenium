package test.ebay;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.IOException;

public class Main {
    public static void main(String args[]) {
        WebDriver driver = null;
		try {
			driver = new Main().getDriver();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        Base base = new Base(driver);
        HomePage homePage = new HomePage(driver);
        AdvancedSearch AdvancedSearch = new AdvancedSearch(driver);
        ProductsPage ProductsPage = new ProductsPage(driver);
        
        base.navigateToURL();
        base.searchProduct("food");
    }

    public WebDriver getDriver() throws IOException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\rdcs2\\eclipse-workspace\\Selenium\\chromedriver.exe");
		WebDriver targetDriver = new ChromeDriver();
		return targetDriver;
    }
}
