package com.qittah.collectedMethod;

import static org.testng.Assert.assertTrue;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Driver;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;


// this class for inheritance any common method  
public class ParentClass 
{
	ChromeDriver Chdriver;
	FirefoxDriver Frdriver;

//Set Chrome browser
	public void chromeDriverDemo(String url)
	{
		String chromePath ;
		chromePath = System.getProperty("user.dir")+"\\Resources\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver",chromePath);
		Chdriver = new ChromeDriver();
		Chdriver.navigate().to(url);  //insert system url
	}
//Set Firefox browser 	
	public void fireFoxDeriverDemo(String url)
	{
		String fireFoxPath ;
		fireFoxPath = System.getProperty("user.dir")+"\\Resources\\geckodriver.exe";
		System.setProperty("webdriver.gecko.driver",fireFoxPath);
		Frdriver = new FirefoxDriver();
		Frdriver.navigate().to(url);  
	}
//Close the Chrome browser	
	public void closeChromeBrowser()
	{
		Chdriver.close();
		
	}
//Close the Firefox browser
	public void closeFirefoxbrowser()
	{
		Frdriver.close();
	}
	
//Assert home page through chrome browser 
	public void verifyHomePageChrome(String title)
	{
		Assert.assertEquals(Chdriver.getTitle(), title);
	}
//Assert home page through chrome browser 
	public void verifyHomePageFireFox(String title)
	{
		Assert.assertEquals(Frdriver.getTitle(), title);
	}
//User Logout()
	public void logOut()
	{
		WebElement logOutBtn = Chdriver.findElement(By.className(""));
		logOutBtn.click();
	}
//User Login 
	public void loginUser(String username ,String password , String loggedMsg)
	{
		
    	WebElement usernameTex = Chdriver.findElement(By.id(""));
    	WebElement passwordTxt = Chdriver.findElement(By.id(""));
    	usernameTex.clear();
    	passwordTxt.clear();
	    usernameTex.sendKeys(username);
	    passwordTxt.sendKeys(password);
	    WebElement loginButton = Chdriver.findElement(By.id(""));
	    loginButton.click();
	    WebElement successVerify = Chdriver.findElement(By.id(""));
	    Assert.assertTrue(successVerify.getText().contains(loggedMsg));	
	}
//Check Element exist or not 
	public boolean checkElementExist(By by)
	{
		try
		{
			Chdriver.findElement(by);
		    return true;
		} 
			
		catch (NoSuchElementException e) 
		{
			return false;
		}
	}
//Registration method 
	public void registrationMethod(String name,String cellPhone ,String Email ,String Password ,String ConfirmPassword)
	{
		WebElement usernameTxt = Chdriver.findElement(By.id(""));
    	WebElement emailTxt = Chdriver.findElement(By.id(""));
    	WebElement cellPhoneTxt    = Chdriver.findElement(By.id(""));
    	WebElement PassTxt   = Chdriver.findElement(By.id(""));
    	WebElement confirmPassTxt   = Chdriver.findElement(By.id(""));
    	usernameTxt.sendKeys(name);
    	emailTxt.sendKeys(Email);
    	cellPhoneTxt.sendKeys(cellPhone);
    	PassTxt.sendKeys(Password);
    	confirmPassTxt.sendKeys(ConfirmPassword);
        WebElement regButton = Chdriver.findElement(By.id(""));
	    regButton.click();
	    WebElement successVerify = Chdriver.findElement(By.id(""));
	    Assert.assertTrue(successVerify.getText().contains(""));	
		
	}
//Verify alert message box
	public void verifyAlertMsg()
	{
		WebElement btnAlert = Chdriver.findElement(By.id(""));
		btnAlert.click();
		Alert alert = Chdriver.switchTo().alert();
		alert.accept();
		String alertTxt = alert.getText();
		Assert.assertEquals(alertTxt, "");
	}
	
//Navigation methods
	public void navigationMethods()
	{
		Chdriver.navigate().back();
		Chdriver.navigate().forward();
		Chdriver.navigate().refresh();
		Frdriver.navigate().back();
		Frdriver.navigate().forward();
		Frdriver.navigate().refresh();
	}
//Verify drop down list values 
	public void verifyDropDown(String id)
	{
		WebElement dropList = Chdriver.findElement(By.id(id));
		Select selectOptions = new Select(dropList);
		Assert.assertEquals(3, selectOptions.getOptions().size());
	}
//Verify the default option of the drop down list 
	public void verifyDropDownDefaultSelection(String id)
	{
		WebElement dropList = Chdriver.findElement(By.id(id));
		Select selectOptions = new Select(dropList);
		Assert.assertEquals("", selectOptions.getFirstSelectedOption().getText());
	}
//Verify the table rows and columns data 	
	public void verifyTable()
	{
		//get all rows
		WebElement webTable = Chdriver.findElement(By.id(""));
		List<WebElement> rows = webTable.findElements(By.id(""));
		for (WebElement row : rows) 
		{
			List<WebElement> cols = row.findElements(By.id(""));
			for (WebElement col : cols)
			{
				
			}
		}
	}
//capture screen shot in case of test case fail	
	public void captureScreenShot(WebDriver wedriver,String screenShotName)
	{
		Path dest = Paths.get("./ScreenShot",screenShotName+".png");
		try
		{
			Files.createDirectories(dest.getParent());
			FileOutputStream out =new FileOutputStream(dest.toString());
			out.write(((TakesScreenshot) wedriver).getScreenshotAs(OutputType.BYTES));
			out.close();
		} 
		catch (IOException e) 
		{
			System.out.println("Exception while taking screen shot"+e.getMessage());
		}
	}
	

	
	
	
	
}
