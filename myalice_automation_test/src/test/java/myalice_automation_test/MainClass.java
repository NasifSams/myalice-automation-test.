package myalice_automation_test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;



public class MainClass {
	
	WebDriver driver;
	ExtentReports extent;
	
	@BeforeSuite
	public void ExtentSetUp() {
		extent= new ExtentReports();
		ExtentSparkReporter spark = new ExtentSparkReporter("MyTestReport.html");
		
		spark.config().setTheme(Theme.DARK);
		spark.config().setDocumentTitle("Web Testing Automation Assessment");
		spark.config().setReportName("Nasif Sadiq");
		extent.attachReporter(spark);
		
		
	   
	}
	@BeforeMethod
	public void setUp()  {
		 // System.setProperty("C:\\eclipse\\chrome-win64\\chrome.exe\"", "C:\\eclipse");
		     driver= new ChromeDriver();
		
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));   
		  driver.get("https://myalice-automation-test.netlify.app/");
		  driver.manage().window().maximize();
		  
	
		  
		  
	}
	
	@Test(priority=1)
	public void LogInTest() throws InterruptedException {
		ExtentTest test=extent.createTest("Login Functionality","myalice-automation-test").assignAuthor("Nasif").assignDevice("Windows 11: Chrome Browser");
        
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));   

		  PageObjectClass pm= new PageObjectClass(driver);
		
		//giving email
		pm.setUserName("testuser");
		test.info("testuser");
		
		
		
		pm.setPassword("password");
		test.info("Password:password");
		
		
		pm.clickLoginBtn();
		
		String expectedTitle="React App";
		String actualTitle=driver.getTitle();
		if(expectedTitle.contains(actualTitle)) {
			test.pass("Log in Successful");
		}
		else 
			test.fail("Log In Failed" ,MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64()).build());
		

		
		    
		
		
	}
	
	@Test(priority=2)
	public void Manga_Search_and_isplay() throws InterruptedException {
		ExtentTest test=extent.createTest("Manga Search and Display","myalice-automation-test").assignAuthor("Nasif").assignDevice("Windows 11: Chrome Browser");
        
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));   

		  PageObjectClass pm= new PageObjectClass(driver);
		
		//giving email
		pm.setUserName("testuser");
		test.info("testuser");
		
		
		
		pm.setPassword("password");
		test.info("Password:password");
		
		
		pm.clickLoginBtn();
		

		String expectedTitle="React App";
		String actualTitle=driver.getTitle();
		if(expectedTitle.contains(actualTitle)) {
			test.pass("the user is on the manga search page.");
		}
		else {
			test.fail("Log In Failed" ,MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64()).build());
		}

		
		//Search Naruto
		
		pm.setmangaSearch("Naruto");
		
		//click search 
		pm.clickSearch();
		
		String MangaName=driver.findElement(By.id("manga-name")).getText();
		
		if(MangaName.contains("Naruto")) {
			test.pass("Naruto displayed");
		}
		else {
			test.fail("Search Failed" ,MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64()).build());

		}
		//Search One Piece
		        pm.mangaSearch.clear();
				pm.setmangaSearch("One Piece");
				
				//click search 
				pm.clickSearch();
				
				String OnePiece=driver.findElement(By.id("manga-name")).getText();
				
				if(OnePiece.contains("One Piece")) {
					test.pass("One Piece displayed");
				}
				else {
					test.fail("Search Failed" ,MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64()).build());

				}
		
				//Search Seven Deadly Sins
		        pm.mangaSearch.clear();
				pm.setmangaSearch("Seven Deadly Sins");
				
				//click search 
				pm.clickSearch();
				
				String Seven_Deadly_Sins=driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/p")).getText();
				
				if(Seven_Deadly_Sins.contains("Seven Deadly Sins")) {
					test.pass("No manga found displayed");
				}
				else {
					test.fail("Search Failed" ,MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64()).build());

				}
				//Search No manga found
				
				
				Thread.sleep(2000);
		        pm.mangaSearch.clear();
				pm.setmangaSearch("No manga found");
				
				//click search 
				pm.clickSearch();
				
				String No_manga_found=driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/p")).getText();
				
				if(No_manga_found.contains("No manga found")) {
					test.pass("No manga found displayed");
				}
				else {
					test.fail("Search Failed: No manga found " ,MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64()).build());

				}
		
		
	}
	
	@Test(priority=3)
	public void MangaDetailsModal() {
		ExtentTest test=extent.createTest("Manga Details Modal","myalice-automation-test").assignAuthor("Nasif").assignDevice("Windows 11: Chrome Browser");
        
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));   

		  PageObjectClass pm= new PageObjectClass(driver);
		
		//giving email
		pm.setUserName("testuser");
		test.info("testuser");
		
		
		
		pm.setPassword("password");
		test.info("Password:password");
		
		
		pm.clickLoginBtn();
		

		String expectedTitle="React App";
		String actualTitle=driver.getTitle();
		if(expectedTitle.contains(actualTitle)) {
			test.pass("the user is on the manga search page.");
		}
		else {
			test.fail("the user is not on the manga search page." ,MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64()).build());
		}
		
		//Manga Details Modal
		pm.clcikdetails();
		
		String Name= driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[3]/div/h3")).getText();
		if(Name.contains("Bleach")) {
			test.pass("Details opened");
		}
		else {
			test.fail("Details page is not opened" ,MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64()).build());
		}
		
		pm.clickCloseBtn();
		test.info("Close Btn Clicked");
		
		String expectedTitle1="React App";
		String actualTitle1=driver.getTitle();
		if(expectedTitle1.contains(actualTitle1)) {
			test.pass("the user is on the manga search page.");
		}
		else {
			test.fail("the user is not on the manga search page." ,MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64()).build());
		}
		
	}
	
	@AfterMethod
	public void tearDown1() {
		
		driver.close();
		
	}
	@AfterSuite
	public void tearDwon() {
		extent.flush();
		
	}
	public String getBase64() {
		return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
	}


}
