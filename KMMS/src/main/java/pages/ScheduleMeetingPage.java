package pages;

import java.time.LocalDate;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;

public class ScheduleMeetingPage 
{
	PageUtility pageutility;
	WebDriver driver;
	@FindBy(xpath="//div[normalize-space()='Meetings']") WebElement meetings_menu;
	
	@FindBy(xpath = "//body/aside[@class='sidebar-wrapper']/div[@class='simplebar-wrapper']/div[@class='simplebar-mask']"
			+ "/div[@class='simplebar-offset']/div[@class='simplebar-content-wrapper']/div[@class='simplebar-content']/"
			+ "div[@class='sidebar-nav mm-active']/ul[@id='sidenav']/li[@class='mm-active']/ul[@class='mm-collapse mm-show']/li[1]/a[1]")
	WebElement schdulemtng;
	@FindBy(xpath = "//input[@id='title']") WebElement title;
	@FindBy(xpath = "//input[@id='file_no']") WebElement efileno;
	@FindBy(xpath = "//input[@id='ms_date\']") WebElement date;
	@FindBy(xpath = "//span[@id='select2-start_time-container']") WebElement starttime;
	@FindBy(xpath = "//span[@id='select2-end_time-container']") WebElement endtime;
	@FindBy(xpath = "") WebElement chairedby;
	@FindBy(xpath = "") WebElement chairedbyuser;
	@FindBy(xpath = "") WebElement agenda;
	@FindBy(xpath = "") WebElement addagendabutton;
	public ScheduleMeetingPage(WebDriver driver)
    {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	public ScheduleMeetingPage clickMeetings()
	{
		
		meetings_menu.click();
		schdulemtng.click();
		return new ScheduleMeetingPage(driver);
	}
	public void enterMeetingTitle(String mtngtitle)
	{
		title.clear();
		title.sendKeys(mtngtitle);
	}
	public void enterFileNo(String fileno)
	{
		efileno.clear();
		efileno.sendKeys(fileno);
	}
	public void enterDate()
	{
		//LocalDate selectedDate = LocalDate.of(2025, 8, 3); //
		//String formattedDate = "30-07-2025";
		
        date.click();
       // date.clear();
		//date.sendKeys(formattedDate);
	}
	public void enterStartTime()
	{
		starttime.click();
		pageutility.selectByValue(starttime,"10:00 AM");
	}
	public void enterEndTime()
	{
		endtime.click();
		pageutility.selectByValue(starttime,"12:00 AM");
		
	}
	public void enterChairedBy()
	{
		chairedby.click();
		pageutility.selectByValue(chairedby, "Ministers");
	}
}