package pageOjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class currentPage {

	public WebDriver driver;

	
	By getFirstName = By.id("firstName");
	By lastName = By.id("lastName");
	By emailAddress = By.id("emailAddress");
	By submitButton = By.id("bySubmit");


public currentPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
	
	this.driver=driver;
	driver.switchTo().frame(0);
	}


public WebElement getFirstName()
{
	
	return driver.findElement(getFirstName);
}

public WebElement lastName()
{
return driver.findElement(lastName);	
}

public WebElement emailAddress()
{
	return driver.findElement(emailAddress);
}

public WebElement submitButton()
{
	return driver.findElement(submitButton);
}
}