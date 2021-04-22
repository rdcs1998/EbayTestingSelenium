package test.ebay;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Base {
    private final WebDriver driver;
    private Utils utils;

    public Base(WebDriver driver) {
        this.driver = driver;
        this.utils = new Utils();
    }

    public String url = "https://www.ebay.com/";
    String xpathSearchProduct = "//input[@placeholder='Search for anything']";
    String xpathBtnSearchProduct = "//input[@value='Search']";
    public String xpNotification = "//i[text()='Notification']";

    //Signin elements
    public String xpLinkSignin = "(//a[text()='Sign in'])[1]";
    public String xpUserId = "//input[@id='userid']";
    public String xpBtnContinue = "//button[text()='Continue']";
    public String xpPwd = "//input[@id='pass']";
    public String xpBtnSignin = "//button[@id='sgnBt']";

    //Register elements
    public String xpLinkRegister = "(//a[text()='register'])[1]";
    public String xpFirstName = "//input[@id='firstname']";
    public String xpLastName = "//input[@id='lastname']";
    public String xpEmail = "//input[@id='Email']";
    public String xpPwd2 = "//input[@id='password']";
    public String xpBtnRegister = "//button[@id='EMAIL_REG_FORM_SUBMIT']";

    //Daily Deals elements
    public String xpLinkDailyDeals = "//a[contains(text(), 'Daily Deals')]";
    public String xpSearchDailyDeals = "//input[@placeholder='Search for anything']";
    public String xpTxtSpotlightDeal = "//span[text()='Spotlight Deal']";
    public String xpTxtFeaturedDeals = "//span[text()='Featured Deals']";
    public String xpTxtDeals = "//h2[@class='dne-pattern-title']/span";
    public String xpTxtBrands = "//span[@itemprop=\"name\"]";
    public String xpTxtPrices = "//span[@itemprop=\"price\"]";

    //Help & Contact elements
    public String xpLinkHelpAndContact = "(//a[contains(text(), 'Help & Contact')])[1]";
    public String xpSearchHelp = "//input[contains(@placeholder, 'Search eBay Help')]";
    public String xpHelpCategories = "//h2[@class='main_title']";
    public String xpBrowseHelpArticles = "//span[@class='content']/span[@class='t2']";

    //Footer elements
    public String xpLinkCommunity = "(//a[text()='Community'])[1]";
    public String xpLinkAnnouncements = "(//a[text()='Announcements'])[1]";
    public String xpLinkCommunityTopics = "//article[contains(@class, 'custom-message-tile')]//a";

    public void navigateToURL() {
        driver.navigate().to(url);
    }

    public void navigateBack() {
        driver.navigate().back();
    }

    public void signin(String userName, String pwd) {
        WebElement lnkSignin = utils.explicitlyWait(driver, xpLinkSignin);
        lnkSignin.click();

        WebElement inputUserid = utils.explicitlyWait(driver, xpUserId);
        utils.inputText(inputUserid, userName);

        WebElement btnContinue = driver.findElement(By.xpath(xpBtnContinue));
        btnContinue.click();

        WebElement inputPwd = utils.explicitlyWait(driver, xpPwd);
        utils.inputText(inputPwd, pwd);

        WebElement btnSignin = driver.findElement(By.xpath(xpBtnSignin));
        btnSignin.click();
    }

    public void register(String firstName, String lastName, String email, String pwd) {
        WebElement lnkRegister = utils.explicitlyWait(driver, xpLinkRegister);
        lnkRegister.click();

        WebElement inputFirstName = utils.explicitlyWait(driver, xpFirstName);
        utils.inputText(inputFirstName, firstName);

        WebElement inputLastName = driver.findElement(By.xpath(xpLastName));
        utils.inputText(inputLastName, lastName);

        WebElement inputEmail = driver.findElement(By.xpath(xpEmail));
        utils.inputText(inputEmail, email);

        WebElement inputPwd = driver.findElement(By.xpath(xpPwd2));
        utils.inputText(inputPwd, pwd);

        WebElement btnContinue = driver.findElement(By.xpath(xpBtnRegister));
        btnContinue.click();
    }

    public void dailyDeals() {
        WebElement lnkDailyDeals = utils.explicitlyWait(driver, xpLinkDailyDeals);
        lnkDailyDeals.click();

        utils.explicitlyWait(driver, xpTxtFeaturedDeals);

        List<WebElement> listDeals = driver.findElements(By.xpath(xpTxtDeals));
        System.out.println("No of deal categories retrieved: " + listDeals.size());
        for (WebElement deal : listDeals) {
            System.out.println("Deal: " + deal.getText());
        }

        List<WebElement> listBrands = driver.findElements(By.xpath(xpTxtBrands));
        System.out.println("No of brands retrieved: " + listBrands.size());
        for (WebElement brand : listBrands) {
            System.out.println("Brand: " + brand.getText());
        }

        List<WebElement> listPrices = driver.findElements(By.xpath(xpTxtPrices));
        System.out.println("No of prices retrieved: " + listPrices.size());
        for (WebElement price : listPrices) {
            System.out.println("Price: " + price.getText());
        }
    }

    public void helpAndContact() {
        WebElement lnkHelpAndContact = utils.explicitlyWait(driver, xpLinkHelpAndContact);
        lnkHelpAndContact.click();

        WebElement searchHelp = utils.explicitlyWait(driver, xpSearchHelp);

        List<WebElement> listHelpCategories = driver.findElements(By.xpath(xpHelpCategories));
        System.out.println("No of help categories retrieved: " + listHelpCategories.size());
        for (WebElement item : listHelpCategories) {
            System.out.println("Help Category: " + item.getText());
        }

        List<WebElement> listBrowseHelpArticles = driver.findElements(By.xpath(xpBrowseHelpArticles));
        System.out.println("No of Browse Help Articles retrieved: " + listBrowseHelpArticles.size());
        for (WebElement item2 : listBrowseHelpArticles) {
            System.out.println("Browse Help Article: " + item2.getText());
        }

        utils.inputText(searchHelp, "search products");
    }

    public void searchProduct(String product) {
        WebElement inputSearchProduct = utils.explicitlyWait(driver, xpathSearchProduct);
        utils.inputText(inputSearchProduct, product);
        WebElement btnSearchProduct = driver.findElement(By.xpath(xpathBtnSearchProduct));
        btnSearchProduct.click();
    }

    public void getCommunityTopics() {
        WebElement lnkCommunity = utils.explicitlyWait(driver, xpLinkCommunity);
        lnkCommunity.click();

        utils.explicitlyWait(driver, "(" + xpLinkCommunityTopics + ")[1]");
        List<WebElement> listTopics = driver.findElements(By.xpath(xpLinkCommunityTopics));
        System.out.println("No of Community topics retrieved: " + listTopics.size());
        for (WebElement topic : listTopics) {
            System.out.println("Community topic: " + topic.getText());
        }
    }
}
