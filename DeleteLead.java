package week2.day2.Assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteLead {
	public static void main(String[] args) throws InterruptedException {

		//setup the driver
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();

		//Load the url
		driver.get("http://leaftaps.com/opentaps/control/login");

		//max my window 
		driver.manage().window().maximize();

		//wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		//Enter the user name
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("demosalesmanager");

		//Enter the password
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("crmsfa");

		//click login button
		driver.findElement(By.xpath("//input[@class='decorativeSubmit']")).click();

		//click CRM/SFA
		driver.findElement(By.xpath("//a[contains(text(),'CRM/SFA')]")).click();

		//click the lead button
		driver.findElement(By.xpath("//a[text()='Leads']")).click();

		//Click Find leads
		driver.findElement(By.xpath("//a[text()='Find Leads']")).click();

		//Click on Phone
		driver.findElement(By.xpath("//span[text()='Phone']")).click();


		

		//Enter phone number
		driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys("0123456789");

		
		//Click find leads button
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();

		//Capture lead ID of First Resulting lead and click
		Thread.sleep(2000);
		String text = driver.findElement(By.xpath("//div[contains(@class, 'x-grid3-col-partyId')]//a[1]")).getText();
		System.out.println(text);
		driver.findElement(By.xpath("//div[contains(@class, 'x-grid3-col-partyId')]//a[1]")).click();
		//Click delete
		driver.findElement(By.xpath("//a[@class='subMenuButtonDangerous']")).click();
		//click find leads
		driver.findElement(By.linkText("Find Leads")).click();
		driver.findElement(By.xpath("//input[@name='id']")).sendKeys(text);//search by id=13891
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();//click find leads
		String text2 = driver.findElement(By.xpath("//div[text()='No records to display']")).getText();//verify message
		System.out.println(text2);
		if (text2.contains("No records to display")) {

			System.out.println("Lead Sucessfuly deleted");

		}else {

			System.out.println("Lead is Not Deleted");

		}
		driver.close();

		String title1 = driver.getTitle();
		System.out.println(title1);
	}
}