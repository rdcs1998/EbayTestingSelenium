package test.ebay;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AdvancedSearch {
    private final WebDriver driver;
    private Utils utils;

    public AdvancedSearch(WebDriver driver) {
        this.driver = driver;
        this.utils = new Utils();
    }

    //Find items
    public String xpLinkFindItems = "//a[text()='Find items']";
    public String xpEnterSearchCriteria = "//input[@placeholder='Enter keywords or item number']";
    public String xpListSearchOptions = "//select[@aria-label='Keyword options']";
    public String xpSearchOptions = "//select[@aria-label='Keyword options']/option[text()='$option']";
    public String xpExclude = "//input[@name='_ex_kw']";
    public String xpListCategory = "//select[@name='_sacat']";
    public String xpCategoryOptions = "//select[ancestor::label[contains(text(), 'category')]]/option[text()='$option']";
    public String xpBtnSearchItems = "(//button[text()='Search'])[1]";

    //By seller
    public String xpLinkBySeller = "//a[text()='By seller']";
    public String xpChkBoxSellers = "//input[@type='checkbox' and ancestor::label[preceding-sibling::legend[text()='Sellers']]]";
    public String xpListSpecificSellers = "//select[@aria-label='Include or exclude menu']";
    public String xpSpecificSellersOptions = "//select[@aria-label='Include or exclude menu']/option[text()='$option']";
    public String xpInputSellers = "//input[contains(@title, 'Enter seller')]";
    public String xpRadioSavedSellers = "//input[@type='radio' and @value='LH_FavSellers=1']";
    public String xpRadioSellersWithStores = "//input[@type='radio' and @value='LH_SellerWithStore=1']";

    //Sort by
    public String xpListSortBy = "//select[@id='LH_SORT_BY']";
    public String xpSortByOptions = "//select[@id='LH_SORT_BY']/option[text()='$option']";
    public String xpListViewResults = "//select[@id='LH_VIEW_RESULTS_AS']";
    public String xpViewResultsOptions = "//select[@id='LH_VIEW_RESULTS_AS']/option[text()='$option']";
    public String xpListResults = "//select[@id='LH_IPP']";
    public String xpResultsOptions = "//select[@id='LH_IPP']/option[text()='$option']";
    public String xpBtnSellersSearch = "(//button[text()='Search'])[2]";

    //By item number
    public String xpLinkByItemNumber = "//a[text()='By item number']";
    public String xpEnterItemNumber = "//input[@name='_id']";
    public String xpBtnItemNumberSearch = "//button[text()='Search']";

    //Items in stores
    public String xpLinkItemsInStores = "//a[text()='Items in stores']";

    //Find Stores
    public String xpLinkFindStores = "//a[text()='Find Stores']";
    public String xpEnterStores = "//input[@name='_nkw']";

    public void findItems() {
        WebElement linkFindItems = utils.explicitlyWait(driver, xpLinkFindItems);
        linkFindItems.click();

        WebElement enterSearchCriteria = driver.findElement(By.xpath(xpEnterSearchCriteria));
        utils.inputText(enterSearchCriteria, "iphone");

        WebElement listSearchOptions = driver.findElement(By.xpath(xpListSearchOptions));
        listSearchOptions.click();
        WebElement optionSearchCriteria = utils.explicitlyWait(driver, xpSearchOptions.replace("$option", "Any words, any order"));
        optionSearchCriteria.click();

        WebElement inputExclude = driver.findElement(By.xpath(xpExclude));
        utils.inputText(inputExclude, "nothing");

        WebElement listCategory = driver.findElement(By.xpath(xpListCategory));
        listCategory.click();
        WebElement optionCategory = utils.explicitlyWait(driver, xpCategoryOptions.replace("$option", "Art"));
        optionCategory.click();

        WebElement btnSearchItems = driver.findElement(By.xpath(xpBtnSearchItems));
        btnSearchItems.click();
    }

    public void searchBySellers() {
        WebElement linkBySeller = utils.explicitlyWait(driver, xpLinkBySeller);
        linkBySeller.click();

        WebElement chkBoxSellers = driver.findElement(By.xpath(xpChkBoxSellers));
        chkBoxSellers.click();

        WebElement listSpecificSellers = driver.findElement(By.xpath(xpListSpecificSellers));
        listSpecificSellers.click();
        WebElement optionSellerSpecific = utils.explicitlyWait(driver, xpSpecificSellersOptions.replace("$option", "Exclude"));
        optionSellerSpecific.click();

        WebElement inputSellers = driver.findElement(By.xpath(xpInputSellers));
        utils.inputText(inputSellers, "abc");

        WebElement radioSavedSellers = driver.findElement(By.xpath(xpRadioSavedSellers));
        radioSavedSellers.click();

        sortBy();
    }

    public void sortBy() {
        WebElement listSortBy = driver.findElement(By.xpath(xpListSortBy));
        listSortBy.click();
        WebElement optionSortBy = utils.explicitlyWait(driver, xpSortByOptions.replace("$option", "Time: ending soonest"));
        optionSortBy.click();

        WebElement listViewResults = driver.findElement(By.xpath(xpListViewResults));
        listViewResults.click();
        WebElement optionViewResults = utils.explicitlyWait(driver, xpViewResultsOptions.replace("$option", "All items"));
        optionViewResults.click();

        WebElement listResults = driver.findElement(By.xpath(xpListResults));
        listResults.click();
        WebElement optionResults = utils.explicitlyWait(driver, xpResultsOptions.replace("$option", "100"));
        optionResults.click();

        WebElement btnSearchSorted = driver.findElement(By.xpath(xpBtnSellersSearch));
        btnSearchSorted.click();
    }

    public void searchByItemNo() {
        WebElement linkByItemNumber = utils.explicitlyWait(driver, xpLinkByItemNumber);
        linkByItemNumber.click();

        WebElement inputEnterItemNumber = driver.findElement(By.xpath(xpEnterItemNumber));
        utils.inputText(inputEnterItemNumber, "12345");

        WebElement btnSearchByItemNumber = driver.findElement(By.xpath(xpBtnItemNumberSearch));
        btnSearchByItemNumber.click();
    }

    public void searchItemsInStores() {
        WebElement linkItemsInStores = utils.explicitlyWait(driver, xpLinkItemsInStores);
        linkItemsInStores.click();

        WebElement enterSearchCriteria = driver.findElement(By.xpath(xpEnterSearchCriteria));
        utils.inputText(enterSearchCriteria, "iphone");

        WebElement listSearchOptions = driver.findElement(By.xpath(xpListSearchOptions));
        listSearchOptions.click();
        WebElement optionSearchCriteria = utils.explicitlyWait(driver, xpSearchOptions.replace("$option", "Any words, any order"));
        optionSearchCriteria.click();

        WebElement inputExclude = driver.findElement(By.xpath(xpExclude));
        utils.inputText(inputExclude, "nothing");

        WebElement listCategory = driver.findElement(By.xpath(xpListCategory));
        listCategory.click();
        WebElement optionCategory = utils.explicitlyWait(driver, xpCategoryOptions.replace("$option", "Art"));
        optionCategory.click();

        WebElement btnSearchItems = driver.findElement(By.xpath(xpBtnSearchItems));
        btnSearchItems.click();
    }

    public void findStores() {
        WebElement linkFindStores = utils.explicitlyWait(driver, xpLinkFindStores);
        linkFindStores.click();

        WebElement inputEnterStores = driver.findElement(By.xpath(xpEnterStores));
        utils.inputText(inputEnterStores, "ABCD");

        WebElement btnSearchByStoreName = driver.findElement(By.xpath(xpBtnItemNumberSearch));
        btnSearchByStoreName.click();
    }
}
