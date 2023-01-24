package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Accessorries_Category_Page_Elements {
    public Accessorries_Category_Page_Elements(WebDriver driver){PageFactory.initElements(driver, this);}


    @FindBy(xpath = "(//img[@class='product-image__image'])[1]")
    public WebElement starWarsCanta;

    @FindBy(xpath = "(//a[@href='https://www.lcwaikiki.com/tr-TR/TR/etiket/cocuk-aksesuarlari'])[1]")
    public WebElement cocukCategory;

    @FindBy(xpath = "(//div[@class='product_card__image_placeholder'])[3]")
    public WebElement baskiliKizSemsiye;


    @FindBy(xpath="(//a[text()='Kadın&Erkek'])[1]")
    public WebElement kadinErkekButon;



}
