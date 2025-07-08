package practice;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebElement;


public class prac1 {

	public static void main(String[] args) {
		System.out.println("Test Started");
		String baseUrl="https://rahulshettyacademy.com/AutomationPractice/";
		
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get(baseUrl);
		
		//clicking radio button
		driver.findElement(By.xpath("//div[@id='radio-btn-example']//label[@for='radio1']/input")).click();
		
		
		
		// enter value in text field
		driver.findElement(By.xpath("//div[@id='select-class-example']//input")).sendKeys("india");
		
		// handeling Auto suggession box
			//explicit wait
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[contains(@class,'ui-menu')]")));
		
		driver.findElement(By.xpath("//ul/li[@class='ui-menu-item']/div[text()='India']")).click();
		
		
		
		WebElement dropdownElement = driver.findElement(By.id("dropdown-class-example"));
		dropdownElement.click();
		Select dropdown = new Select(dropdownElement);

		// Select by visible text
		dropdown.selectByVisibleText("Option2");

		// Or by value
		dropdown.selectByValue("option1");

		// Or by index
		dropdown.selectByIndex(2);
		
		
		//checkbox
		WebElement checkbox=driver.findElement(By.id("checkbox-example"));
		checkbox.findElement(By.xpath("//input[@value='option1']")).click();
		
		// new window
		driver.findElement(By.xpath("//fieldset/button[contains(text(),'Open Window')]")).click();
		 Object[] windowHandles=driver.getWindowHandles().toArray();
	        driver.switchTo().window((String) windowHandles[1]);
	        //assert on title of new window
	        String title=driver.getTitle();
	      System.out.println(title);
	      
		
		
		
		
		
try {
	Thread.sleep(5000);
} catch (InterruptedException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
		
		
		driver.quit();
		System.out.println("test closed");

	}

}
