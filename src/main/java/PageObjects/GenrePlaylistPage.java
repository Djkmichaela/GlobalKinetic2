package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class GenrePlaylistPage {

	
	public GenrePlaylistPage(AndroidDriver<AndroidElement> driver)
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Rock']")
	public WebElement Rock;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Cinematic']")
	public WebElement Cinematic;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text*='Jazz & Blues']")
	public WebElement JazzBlues;
}
