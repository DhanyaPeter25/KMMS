package testscript;

import java.io.IOException;

import org.testng.annotations.Test;

import pages.ScheduleMeetingPage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class SheduleMeetingTest extends Base
{
	ScheduleMeetingPage schedulemeetingpage;
	
@Test(description = "To verify the user can login and click on Meetings menu")
public void toVerifyTheUserCanClickMeetingsMenu() throws IOException
{
	String username = ExcelUtility.getStringData(1, 0, "csologinpage");
	String password = ExcelUtility.getStringData(1, 1, "csologinpage");
	LoginPage loginpage = new LoginPage(driver);
	loginpage.enterUsername(username);
	loginpage.enterPassword(password);
	schedulemeetingpage =  loginpage.clickLogin();
	schedulemeetingpage.clickMeetings();
}

@Test()
public void toVerifyTheUserCanEnterMeetingDetails() throws IOException
{
	String username = ExcelUtility.getStringData(1, 0, "csologinpage");
	String password = ExcelUtility.getStringData(1, 1, "csologinpage");
	String title = ExcelUtility.getStringData(0, 0, "Meeting_Title");
	String fileno = ExcelUtility.getStringData(0, 1, "Meeting_Title");
	LoginPage loginpage = new LoginPage(driver);
	loginpage.enterUsername(username);
	loginpage.enterPassword(password);
	schedulemeetingpage = loginpage.clickLogin();
	schedulemeetingpage.clickMeetings().enterMeetingTitle(title);
	schedulemeetingpage.enterFileNo(fileno);
	schedulemeetingpage.enterDate();
	schedulemeetingpage.enterStartTime();
	schedulemeetingpage.enterChairedBy();
}

}
