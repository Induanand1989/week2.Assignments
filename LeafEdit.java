package week2.day2.Assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafEdit{
	public static void main(String[] args) {

		//setup the driver
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();

		//Load the url
		driver.get("http://leafground.com/pages/Edit.html");

		//max my window 
		driver.manage().window().maximize();

		//wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		driver.findElement(By.id("email")).sendKeys("induanandsai@gmail.com");
		
		//Get the title
		String title=driver.getTitle();
		System.out.println("The title is  : "+title);
		
		
		  if(title.contains("Edit"))
		  { System.out.println("I am in Edit html"); 
		  }else
		  System.out.println("I am not in Edit html");
		  
		  //Get the system current URL
		String url=driver.getCurrentUrl();
		System.out.println("The url is  : "+url);
		/*
		 * //Get the page source String source=driver.getPageSource();
		 * System.out.println("The source is  : "+source);
		 */
		
		WebElement inputfield = driver.findElement(By.xpath("//input[@value='Append ']"));
		inputfield.sendKeys("TEXT",Keys.TAB);		//append a text and press keyboard tab

		String attribute = driver.findElement(By.name("username")).getAttribute("value");
		System.out.println(attribute); //get default text entered

		driver.findElement(By.xpath("(//input[@name='username'])[2]")).clear(); //clear text
		System.out.println("cleared");

		boolean displayed = driver.findElement(By.xpath("//input[@disabled='true']")).isDisplayed();
		System.out.println(displayed); //confirm that edit field is enabled
		
		//Close the browser
		 driver.close();


	}
	

}
