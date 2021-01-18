package UniversalAPPMaven.UniversalAppMaven;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageObjects.CinematicPlayListPage;
import PageObjects.GenrePlaylistPage;
import PageObjects.LandingPage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class PlaylistPage extends Base {
	
	   public AndroidDriver<AndroidElement> driver;
	   private static Logger log =
				 LogManager.getLogger(PlaylistPage.class.getName());
	   @BeforeTest
	   public void Initialize() throws InterruptedException, IOException {
		   Runtime.getRuntime().exec("taskkill /F /IM node.exe");
		   Thread.sleep(3000);
		  Service = startServer();
		   driver = Capabilities("GeneralApk");
		   driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		   log.info("Initialize Executed");
	   }
	   
	   
	   @Test
		public void CinePlay() throws InterruptedException {
			
			LandingPage lan = new LandingPage(driver);
			lan.Genres.click();
		
			GenrePlaylistPage gen = new GenrePlaylistPage(driver);
			
			gen.Cinematic.click();
			CinematicPlayListPage cin = new CinematicPlayListPage(driver);
			cin.TheStoryUnfolds.click();
			
			 Service.stop();
			 driver.close();
			 
			 log.info("CinePlay Executed");
			
	   }

}
