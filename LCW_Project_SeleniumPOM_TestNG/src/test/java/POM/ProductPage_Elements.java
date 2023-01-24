package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage_Elements {

    public ProductPage_Elements(WebDriver driver){PageFactory.initElements(driver,this);}

    @FindBy(css="a[data-optionid='2559039']>div")
    public WebElement cicekDesenliSal;

    @FindBy(css = "a[size='Standart']")
    public WebElement standartSize;

    @FindBy(xpath = "(//a[text()='SEPETE EKLE'])[2]")
    public WebElement addToCartButton;

    @FindBy(xpath = "(//a[@size='3-5 Yaş'])[1]")
    public WebElement kizEldivenSize3_5Yas;


}
