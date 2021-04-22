package test.ebay;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePage extends Base {
    private final WebDriver driver;
    private Utils utils;

    public HomePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        this.utils = new Utils();
    }

    public String xpLinkHome = "//span[text()='Home']";
    public String xpLinkSaved = "//a[text()='Saved']";
    public String xpLinkMotors = "(//a[text()='Motors'])[1]";
    public String xpLinkElectronics = "(//a[text()='Electronics'])[2]";
    public String xpLinkFashion = "(//a[text()='Fashion'])[2]";
    public String xpLinkHealthAndBeauty = "(//a[text()='Health & Beauty'])[1]";
    public String xpLinkHomeAndGarden = "(//a[text()='Home & Garden'])[1]";
    public String xpLinkSports = "(//a[text()='Sports'])[1]";
    public String xpLinkCollectiblesAndArt = "(//a[text()='Collectibles and Art'])[1]";
    public String xpLinkIndustrialEquipment = "(//a[text()='Industrial equipment'])[1]";
    public String xpBtnRegister = "//button[@id='EMAIL_REG_FORM_SUBMIT']";
    public String xpLinkAdvanced = "//a[text()='Advanced']";

    public void selectTab(String xpathTab) {
        WebElement tab = utils.explicitlyWait(driver, xpathTab);
        tab.click();
    }

    public void clickTabs() {
        selectTab(xpLinkHome);
        navigateBack();
        selectTab(xpLinkSaved);
        navigateBack();
        selectTab(xpLinkMotors);
        navigateBack();
    }

    public void searchDailyDeals(String product) {
        WebElement lnkDailyDeals = utils.explicitlyWait(driver, xpLinkDailyDeals);
        lnkDailyDeals.click();

        utils.explicitlyWait(driver, xpTxtFeaturedDeals);

        WebElement searchDailyDeals = utils.explicitlyWait(driver, xpSearchDailyDeals);
        utils.inputText(searchDailyDeals, product);

        utils.explicitlyWait(driver, "(//span[@itemprop=\"name\"])[1]");

        List<WebElement> listBrands = driver.findElements(By.xpath(xpTxtBrands));
        System.out.println("No of " + product + " brands retrieved: " + listBrands.size());
        for (WebElement brand : listBrands) {
            if (brand.getText().contains(product)) {
                System.out.println("PASS: Brand: " + brand.getText() + " belongs to " + product);
            } else {
                System.out.println("FAIL: Brand: " + brand.getText() + " does not belong to " + product);
            }
        }
    }
}
