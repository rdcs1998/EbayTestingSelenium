package test.ebay;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProductsPage extends Base {
    private final WebDriver driver;
    private Utils utils;

    public ProductsPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        this.utils = new Utils();
    }

    public String xpProductNames = "//h3[contains(@class, 's-item__title')]";
    public String xpProductPrices = "//span[@class='s-item__price']";
    public String xpLinkProductName = "//h3[contains(@class, 's-item__title') and text()='$product']";
    public String xpBtnBuyItNow = "//a[contains(text(), 'Buy It Now')]";

    public void search() {
        searchProduct("iphone");
        getProductDescriptions();
        getProductPrices();
    }

    public void getProductDescriptions() {
        utils.explicitlyWait(driver, "(" + xpProductNames + ")[1]");
        List<WebElement> listBrands = driver.findElements(By.xpath(xpProductNames));
        System.out.println("No of products retrieved: " + listBrands.size());
        for (WebElement brand : listBrands) {
            System.out.println("Brand: " + brand.getText());
        }
    }

    public void getProductPrices() {
        utils.explicitlyWait(driver, "(" + xpProductPrices + ")[1]");
        List<WebElement> listPrices = driver.findElements(By.xpath(xpProductPrices));
        System.out.println("No of prices retrieved: " + listPrices.size());
        for (WebElement price : listPrices) {
            System.out.println("Price: " + price.getText());
        }
    }

    public void buyItNow(String product) {
        searchProduct(product);
        WebElement linkProduct = utils.explicitlyWait(driver, xpLinkProductName.replace("$product", product));
        linkProduct.click();

        WebElement btnBuyItNow = utils.explicitlyWait(driver, xpBtnBuyItNow);
        btnBuyItNow.click();
    }
}
