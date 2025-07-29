package testscript;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constants;
import pages.LoginPage;

import utilities.ExcelUtility;

public class LoginTest extends Base
{
	@Test(description = "To verify that the user can login with valid username and password")
	public void toVerifyWhethertheUserIsAbleToLoginUsingValidCredentials() throws IOException 
	{
		String username = ExcelUtility.getStringData(1, 0, "csologinpage");
		String password = ExcelUtility.getStringData(1, 1, "csologinpage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsername(username);
		loginpage.enterPassword(password);
		loginpage.clickLogin();
		boolean dashboardalert = loginpage.isDashboardDisplayed();
		Assert.assertTrue(dashboardalert, Constants.LOGINTESTVALIDCREDENTIALS);
		
	}
	@Test(description = "To verify that the user can login with invalid username and valid password")
	public void toVerifyWhethertheUserIsAbleToLoginUsingInValidUsernameValidPassword() throws IOException 
	{
		String username = ExcelUtility.getStringData(1, 0, "invalid");
		String password = ExcelUtility.getStringData(1, 1, "invalid");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsername(username);
		loginpage.enterPassword(password);
		loginpage.clickLogin();
		//boolean dashboardalert = loginpage.isDashboardDisplayed();
		//Assert.assertTrue(dashboardalert, Constants.LOGINTESTINVALIDUSERNAMEANDVALIDPASSWORD);
		
	}
}
