package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class LoginPage
{
        public WebDriver driver;
        public LoginPage(WebDriver driver)
        {
    		this.driver = driver;
    		PageFactory.initElements(driver, this);
    	}
		@FindBy(xpath = "//input[@id='username']")WebElement username;
		@FindBy(xpath = "//input[@id='inputChoosePassword']")WebElement password;
		@FindBy(xpath = "//button[@type='submit']")WebElement login;
		@FindBy(xpath = "//div[@class='menu-title'][normalize-space()='Dashboard']") WebElement dboard;
		public void enterUsername(String uname)
		{
			username.clear();
			username.sendKeys(uname);
		}
		public void enterPassword(String pwd)
		{
			password.clear();
			password.sendKeys(pwd);
		}
		public ScheduleMeetingPage clickLogin()
		{
			login.click();
			return  new ScheduleMeetingPage(driver);
		}
		public boolean isDashboardDisplayed()
		{
			return dboard.isDisplayed();
		}

}
