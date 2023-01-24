package TESTS;

import POM.Accessorries_Category_Page_Elements;
import POM.CommonTopHeaderBar_Elements;
import POM.Home_Page_Elements;
import POM.ProductPage_Elements;
import UTILS.BaseDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.sql.DriverManager;
import java.time.Duration;
public class CompleteTest extends BaseDriver {

    Accessorries_Category_Page_Elements accessorries_category_page_elements;
    CommonTopHeaderBar_Elements commonTopHeaderBar_elements;
    Home_Page_Elements home_page_elements;
    ProductPage_Elements productPage_elements;
    String expectedHomePageURL="https://www.lcwaikiki.com/tr-TR/TR";
    String expectedAksesuarLinkPageURL="https://www.lcwaikiki.com/tr-TR/TR/lp/kadin-erkek-cocuk-bebek-aksesuar";
    String expectedTumAksesuarUrunleriPageURL= "https://www.lcwaikiki.com/tr-TR/TR/etiket/tum-aksesuar-urunleri-2022";
    String expectedStarWarsCantaProductPageUrl="https://www.lcwaikiki.com/tr-TR/TR/urun/LC-WAIKIKI/erkek-cocuk/Okul-Cantasi/5841113/2484007";
    String expectedKizEldivenPageUrl="https://www.lcwaikiki.com/tr-TR/TR/urun/LC-WAIKIKI/kiz-cocuk/Eldiven/5915788/2549118";
    String expectedAddToCartVerificationText="Sepetinize 1 adet ürün eklenmiştir.";
    String expectedHomePageUrl="https://www.lcwaikiki.com/tr-TR/TR";

    String expectedCocukAksesuarlariPageUrl="https://www.lcwaikiki.com/tr-TR/TR/etiket/cocuk-aksesuarlari";


    @Test(priority=1)
    public void navigateToHomePageTest(){

        home_page_elements = new Home_Page_Elements(driver);
        WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(10));

        home_page_elements.acceptAllCookiesButton.click();

        String actualHomePageCurrentURL= driver.getCurrentUrl();
        System.out.println("Home Page URL"+ actualHomePageCurrentURL);
        Assert.assertEquals(actualHomePageCurrentURL,expectedHomePageURL);
        Assert.assertTrue(actualHomePageCurrentURL.contains("https://www.lcwaikiki.com/tr-TR/TR"));
    }

    @Test(priority = 2)
    public void navigateToKadinErkekCocukBebekAksesuarPageTest() {

        commonTopHeaderBar_elements = new CommonTopHeaderBar_Elements(driver);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        commonTopHeaderBar_elements.aksesuarLink.click();
        Assert.assertEquals(driver.getCurrentUrl(),expectedAksesuarLinkPageURL);

    }
    @Test(priority = 3)
    public void navigateToCocukAksesuarPage(){

        accessorries_category_page_elements = new Accessorries_Category_Page_Elements(driver);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.elementToBeClickable(accessorries_category_page_elements.cocukCategory));
        accessorries_category_page_elements.cocukCategory.click();
        Assert.assertEquals(driver.getCurrentUrl(),expectedCocukAksesuarlariPageUrl);

    }
        @Test(priority = 4)
        public void navigateToProductPageTest(){
        productPage_elements= new ProductPage_Elements(driver);

        accessorries_category_page_elements = new Accessorries_Category_Page_Elements(driver);


        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(accessorries_category_page_elements.starWarsCanta));
        accessorries_category_page_elements.starWarsCanta.click();

        String currentStarWarsCantaProductPageUrl= driver.getCurrentUrl();
        Assert.assertEquals(currentStarWarsCantaProductPageUrl,expectedKizEldivenPageUrl);
    }
        @Test(priority = 5)
        public void starWarsCantaAddToCartTest() throws InterruptedException {

        productPage_elements= new ProductPage_Elements(driver);
        WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(10));

        wait.until(ExpectedConditions.elementToBeClickable(productPage_elements.kizEldivenSize3_5Yas));
        productPage_elements.kizEldivenSize3_5Yas.click();

        wait.until(ExpectedConditions.elementToBeClickable(productPage_elements.addToCartButton));
        productPage_elements.addToCartButton.click();

        wait.until(ExpectedConditions.visibilityOf(commonTopHeaderBar_elements.dropdownAddToCartVerificationBox));
        String currentAddToCartVerificationText= commonTopHeaderBar_elements.dropdownAddToCartVerificationBox.getText();
        System.out.println(currentAddToCartVerificationText);

        Assert.assertTrue(currentAddToCartVerificationText.contains(expectedAddToCartVerificationText));
    }

        @Test(priority = 6)
        public void navigateToCartPageTest(){

        productPage_elements= new ProductPage_Elements(driver);
        commonTopHeaderBar_elements= new CommonTopHeaderBar_Elements(driver);
        WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(10));

        wait.until(ExpectedConditions.elementToBeClickable(commonTopHeaderBar_elements.cartButton));
        commonTopHeaderBar_elements.cartButton.click();

        wait.until(ExpectedConditions.urlContains("https://www.lcwaikiki.com/tr-TR/TR/sepetim"));
        Assert.assertTrue(driver.getCurrentUrl().contains("https://www.lcwaikiki.com/tr-TR/TR/sepetim"));

    }

        @Test(priority = 7)
        public void navigateBackToHomePage(){
        commonTopHeaderBar_elements= new CommonTopHeaderBar_Elements(driver);
        WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(10));

        commonTopHeaderBar_elements.lcwaikikiBackToHomePageLogo.click();

        wait.until(ExpectedConditions.urlToBe("https://www.lcwaikiki.com/tr-TR/TR"));
        Assert.assertEquals(driver.getCurrentUrl(),expectedHomePageUrl);

    }

}