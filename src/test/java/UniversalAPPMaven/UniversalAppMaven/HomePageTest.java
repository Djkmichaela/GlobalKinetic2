package UniversalAPPMaven.UniversalAppMaven;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import PageObjects.GenrePlaylistPage;
import PageObjects.LandingPage;
import PageObjects.RockPlaylistPage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class HomePageTest extends Base{
	
   public AndroidDriver<AndroidElement> driver;
   private static Logger log =
			 LogManager.getLogger(HomePageTest.class.getName());
   @BeforeTest
   public void Initialize() throws InterruptedException, IOException {
	   Runtime.getRuntime().exec("taskkill /F /IM node.exe");
	   Thread.sleep(3000);
	  Service = startServer();
	   driver = Capabilities("GeneralApk");
	  
	   log.info("Initialize Executed");
   }
   
   
   @Test
	public void PlayWishYouWould() throws InterruptedException {
		
		LandingPage lan = new LandingPage(driver);
		lan.Genres.click();
		GenrePlaylistPage gen = new GenrePlaylistPage(driver);
		gen.Rock.click();
		
		RockPlaylistPage rock = new RockPlaylistPage(driver);
		//rock.Wish.click();
		
		 driver.findElementByAndroidUIAutomator("UiSelector().className(\"android.widget.TextView\").text(\"Wish You'd Come True\")").click();
		 Service.stop();
		 driver.close();
		 
		 log.info("PlayWishYouWould Executed");
		
   }
   

	
	 
}
