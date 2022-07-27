package week2.day2.Assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FaceBook {

	public static void main(String[] args) {
		//setup the driver
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		//Load the url
		driver.get(" https://en-gb.facebook.com/");
		//max my window
		driver.manage().window().maximize();
		//wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		//click the New Account Button
		driver.findElement(By.xpath("//a[text()='Create New Account']")).click();
		//Enter the First name
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Indumathi");
		//Enter the Last name
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Anandakumar");
		//Enter the Email
		driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys("induanandsai@gmail.com");
		//Enter the Password
		driver.findElement(By.xpath("//input[@id='password_step_input']")).sendKeys("Indumathi");

		//drop down
		//Find the Element day
		WebElement day =driver.findElement(By.xpath("//select[@id='day']"));
		// the Select class with web element
		Select drop1=new Select(day);
		drop1.selectByValue("20");

		WebElement month  = driver.findElement(By.xpath("//select[@id='month']"));
		// the Select class with web element month
		Select drop2=new Select(month);
		drop2.selectByValue("4");


		WebElement year = driver.findElement(By.xpath("//select[@id='year']")); 
		//the Select class with web element year
        Select drop3=new Select(year);
		drop3.selectByValue("1989");
		
		driver.findElement(By.xpath("//label[text()='Female']")).click();
		String title1 = driver.getTitle();
		System.out.println(title1);


	}

}
