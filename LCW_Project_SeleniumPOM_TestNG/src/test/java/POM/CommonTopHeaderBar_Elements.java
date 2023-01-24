package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CommonTopHeaderBar_Elements {

    public CommonTopHeaderBar_Elements(WebDriver driver){PageFactory.initElements(driver,this);}
    @FindBy(xpath="(//a[text()='Aksesuar'])[1]")
    public WebElement aksesuarLink;

    @FindBy(xpath = "//div[@class='mega-menu ']//a[text()='Tüm Aksesuar Ürünleri']")
    public WebElement tümAksesuarUrunleri;

    @FindBy(xpath ="//div[@class='mega-menu ']" )
    public WebElement megaMenu;

    @FindBy(css = "span[class='badge-circle']")
    public WebElement cartButton;

    @FindBy(xpath = "(//div[@class='drop-down-menu__wrapper'])[3]")
    public WebElement dropdownAddToCartVerificationBox;

    @FindBy(css = "a[class='main-header-logo']")
    public WebElement lcwaikikiBackToHomePageLogo;
}
