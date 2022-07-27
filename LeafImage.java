package week2.day2.Assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafImage {
	public static void main(String[] args) {
		//setup
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		//load url
		driver.get("http://leafground.com/pages/Image.html");
		//maximize
		driver.manage().window().maximize();
		//implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		//click on image to go home page
		driver.findElement(By.xpath("//img[@src='../images/home.png']")).click();
		driver.navigate().back();
		System.out.println("click on image to go home page is clicked");
	
		//to check the image is broken
		driver.findElement(By.xpath("//label[text()='Am I Broken Image?']/following-sibling::img")).click();
		System.out.println("Broken image is clicked");
		//click me using mouse or keyboard
		driver.findElement(By.xpath("//img[@src='../images/keyboard.png']")).click();
		System.out.println("click me using mouse or keyboard is clicked");
		driver.close();
		
	}

}