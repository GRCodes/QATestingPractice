package QAtest;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageOjects.currentPage;
import resources.foundation;

public class homePage extends foundation 
{

	public static Logger Log = LogManager.getLogger(foundation.class.getName());
	@Test(dataProvider="getData")
	
	public void pageNavigation(String userName, String userPassword, String userEmailAddress) throws IOException
	{
		
		driver = initializeDriver();
		Log.info("Driver is Successfully Initialized");
		driver.get("https://jsfiddle.net/rlourenco/cp6bc9ka/4/embedded/result/");
		
		currentPage c=new currentPage(driver);
		
		c.getFirstName().sendKeys(userName);
		Log.info("UserName entered");
		c.lastName().sendKeys(userPassword);
		Log.info("Password is entered");
		c.emailAddress().sendKeys(userEmailAddress);
		Log.info("Email Address is Entered");
		c.submitButton().click();
		Log.info("Submit Button is Clicked");
		System.out.println(c.driver.switchTo().alert().getText());
		Log.info("Alert is Captured");
		driver.quit();
		Log.info("Driver Windows is Closed");
	}
	
	@DataProvider
	public Object[][] getData()
	{
		//For all valid field argument
		Object[][] data = new Object[11][3];
		data[0][0]="John";
		data[0][1]="doe";
		data[0][2]="jdoe@gmail.com";
		//Missing Username 
		
		data[1][0]=" ";
		data[1][1]="doe";
		data[1][2]="jdoe@gmail.com";
		
		//Missing Password
		data[2][0]="John";
		data[2][1]="";
		data[2][2]="jdoe@gmail.com";
		
		//Missing Email Address
		data[3][0]="John";
		data[3][1]="doe";
		data[3][2]=" ";
		
		//Missing Username and Password
		data[4][0]=" ";
		data[4][1]=" ";
		data[4][2]="jdoe@gmail.com";
		
		//Missing Username and Email
		data[5][0]=" ";
		data[5][1]="doe";
		data[5][2]=" ";
		
		//Missing Password and Email
		data[6][0]="John";
		data[6][1]=" ";
		data[6][2]=" ";
		
		//Alpha-numeric input in Username Field
		data[7][0]="John@123.com ";
		data[7][1]="doe";
		data[7][2]="jdoe@outlook.com";
		
		//Alpha-numeric input in Password
		data[8][0]="John ";
		data[8][1]="doe##.com";
		data[8][2]="jdoe@gmail.com";
		
		//invalid Email Address
		data[9][0]="John@yahoo.com";
		data[9][1]="doe";
		data[9][2]="jdoegmail.com";
		
		//empty submission
		data[10][0]=" ";
		data[10][1]=" ";
		data[10][2]=" ";
		
		return data;
	}
	
}
