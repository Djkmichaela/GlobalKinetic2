package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class JazzNBluesPlaylistPage {
	
	public JazzNBluesPlaylistPage(AndroidDriver<AndroidElement> driver)
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Jazz in Paris']")
	public WebElement JazzinParis;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Talkies']")
	public WebElement Talkies;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text*='The Messenger']")
	public WebElement TheMessenger;

}
