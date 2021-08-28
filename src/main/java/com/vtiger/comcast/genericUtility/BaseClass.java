package com.vtiger.comcast.genericUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.beust.jcommander.Parameter;
import com.vtiger.comcast.pomrepositorylib.HomePage;
import com.vtiger.comcast.pomrepositorylib.LoginPage;

public class BaseClass {
	
	public WebDriver driver;
	public static WebDriver sdriver;
	public WebDriverUtility wu=new WebDriverUtility();
	public ExcelUtility eu=new ExcelUtility();
	public FileUtility fu=new FileUtility();
	public JavaUtility ju=new JavaUtility();

	
//	@Parameters("BROWSER")
	@BeforeClass(groups = {"SmokeTesting","RegressionTesting"})
	public void configBC() throws Throwable {
		String BROWSER = fu.getPropertyKeyValue("browser");
		
		System.out.println("=====Launch the Browser=====");
		if (BROWSER.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equals("firefox")) {
			driver = new FirefoxDriver();
		} else if (BROWSER.equals("edge")) {
			driver = new EdgeDriver();
		}

		sdriver=driver;
		
		driver.manage().window().maximize();
		wu.waitUntilPageLoad(driver);

	}

	@BeforeMethod(groups = {"SmokeTesting","RegressionTesting"})
	public void configBM() throws Throwable {
		String URL = fu.getPropertyKeyValue("url");
		driver.get(URL);

		String USERNAME = fu.getPropertyKeyValue("username");
		String PASSWORD = fu.getPropertyKeyValue("password");
		LoginPage loginPage=new LoginPage(driver);
		loginPage.loginToApp(USERNAME,PASSWORD);
	}
	
	@AfterMethod(groups = {"SmokeTesting","RegressionTesting"})
	public void configAM() {
		HomePage hp = new HomePage(driver);
		hp.logOut();
	}
	
	
	@AfterClass(groups = {"SmokeTesting","RegressionTesting"})
	public void configAC() {
		driver.quit();
	}
	
	

}
