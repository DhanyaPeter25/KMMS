package testscript;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class Base {
	WebDriver driver;

	@BeforeMethod
	public void browserInitialize() {
		driver = new ChromeDriver();
		driver.get("http://10.5.95.200");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
	}

	//@AfterMethod
	public void closeMethods() {
		if (driver != null) {
			try {
				driver.quit(); // More graceful than close()
			} catch (Exception e) {
				System.out.println("Driver already closed.");
			}
		}
	}
}
