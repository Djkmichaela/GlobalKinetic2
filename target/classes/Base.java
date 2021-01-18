package UniversalAPPMaven.UniversalAppMaven;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.ServerSocket;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class Base {
	
	public static AppiumDriverLocalService Service;

	public AppiumDriverLocalService startServer()
	{
		//
	boolean flag=	checkIfServerIsRunnning(4723);
	if(!flag)
	{
		
		Service=AppiumDriverLocalService.buildDefaultService();
		Service.start();
	}
		return Service;
		
	}
	
public static boolean checkIfServerIsRunnning(int port) {
		
		boolean isServerRunning = false;
		ServerSocket serverSocket;
		try {
			serverSocket = new ServerSocket(port);
			
			serverSocket.close();
		} catch (IOException e) {
			//If control comes here, then it means that the port is in use
			isServerRunning = true;
		} finally {
			serverSocket = null;
		}
		return isServerRunning;
	}

	
	/*
	 * public static void startEmulator() throws IOException, InterruptedException {
	 * 
	 * Runtime.getRuntime().exec(System.getProperty("user.dir") +
	 * "\\src\\main\\java\\Resources\\startEmulator.bat"); Thread.sleep(6000); }
	 */
	 

	public static AndroidDriver<AndroidElement> Capabilities(String AppName) throws InterruptedException, IOException {
		

		
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")
				+ "\\src\\main\\java\\UniversalAPPMaven\\UniversalAppMaven\\Global.properties");
		
		
		Properties prop = new Properties();
		prop.load(fis);

		AndroidDriver<AndroidElement> driver;
		File appDir = new File("src");
		File app = new File(appDir, (String) prop.get(AppName));
		// File APP = new File(System.getProperty("user.dir") +
		// "\\src\\UAMPMusicPlayerApp.apk");
		DesiredCapabilities cap = new DesiredCapabilities();
		String device = (String) prop.get("device");
		
		//startEmulator();
		cap.setCapability("deviceName", device);
		cap.setCapability("platformVersion", "7.1.1");
		cap.setCapability("platformName", "Android");
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");// for android only
		cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT,14);
		cap.setCapability("app", app.getAbsolutePath());
		// cap.setCapability("appPackage", "com.android.settings");
		// cap.setCapability("appActivity", "com.android.settings.Settings");
		driver = new AndroidDriver<>(new URL("http://0.0.0.0:4723/wd/hub"), cap);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		return driver;

	}
	public String getScreenShot(String testCaseName, WebDriver driver) throws IOException {

		
	    File src =((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir") + "\\reports\\" + testCaseName + ".png";
		FileUtils.copyFile(src, new File(destinationFile));
		return destinationFile;

	}
	
}
