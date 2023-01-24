package POM;

import UTILS.BaseDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home_Page_Elements extends BaseDriver {

    public Home_Page_Elements(WebDriver driver){PageFactory.initElements(driver,this);}

    @FindBy(id="#cookieseal-banner")
    public WebElement cookieBannerBox;

    @FindBy(xpath = "//button[text()='Tüm Çerezlere İzin Ver']")
    public WebElement acceptAllCookiesButton;

    @FindBy(css = "#close-button-1454703513202>span")
    public WebElement goruntuluMusteriHizmetleriCloseButton;

    @FindBy(id = "div[classname='ins-notification-content ins-notification-content-18145']")
    public WebElement goruntuluMusteriHizmetleriBox;



}