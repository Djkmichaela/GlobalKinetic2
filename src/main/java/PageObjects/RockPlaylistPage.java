package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class RockPlaylistPage {

	
	public RockPlaylistPage(AndroidDriver<AndroidElement> driver)
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Wish You'd Come True']")
	public WebElement Wish;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Home']")
	public WebElement Home;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text*='Hey Sailor']")
	public WebElement HeySailor;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Motocross']")
	public WebElement Motocross;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Keys To The Kingdom']")
	public WebElement KeysToTheKingdom;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text*='Drop and Roll']")
	public WebElement DropandRoll;
}
