package week2.day2.Assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditLead {

	public static void main(String[] args) {
		
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
		
		//Enter first name
		driver.findElement(By.xpath("(//input[@name='firstName'])[3]")).sendKeys("Indu"); 
		
		//Click Find leads button
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		
		// Click on first resulting lead
		driver.findElement(By.xpath("//a[@href='/crmsfa/control/viewLead?partyId=12624']")).click();

		// Verify title of the page
        String title1 = driver.getTitle();
		System.out.println(title1);
        // Click Edit
		driver.findElement(By.xpath("//a[@href='updateLeadForm?partyId=12624']")).click();
		//clear company name
		driver.findElement(By.xpath("//*[@id='updateLeadForm_companyName']")).clear();
		
		// Change the company name
		driver.findElement(By.xpath("//*[@id='updateLeadForm_companyName']")).sendKeys("Test Leaf New");
		//Click Update
		driver.findElement(By.xpath("//input[@name='submitButton']")).click();
		
		// Verify title of the page
		String title2 = driver.getTitle();
		System.out.println(title2);
		
		//Confirm the changed name appears
		String companyName = driver.findElement(By.xpath("//span[@id='viewLead_companyName_sp']")).getText();
		System.out.println("Changed Company Name ="+ companyName);
		
		//Close the browser
		 driver.quit();


	}

}
