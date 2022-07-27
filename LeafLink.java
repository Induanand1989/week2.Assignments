package week2.day2.Assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafLink {

	public static void main(String[] args) {
		//setup
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		//load url
		driver.get("http://leafground.com/pages/Link.html");
		//maximize
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		//go to home page
		driver.findElement(By.xpath("(//a[text()='Go to Home Page'])[1]")).click();
		driver.findElement(By.linkText("HyperLink")).click();
		//without click where I to go?
		driver.navigate().to("http://leafground.com/pages/Button.html");
		driver.navigate().to("http://leafground.com/pages/Link.html");
		//verify am i broken
		driver.findElement(By.xpath("//a[text()='Verify am I broken?']")).click();
		String text = driver.findElement(By.xpath("//h1[text()='404 Not Found']")).getText();
		System.out.println(text);
		if(text.contains(text)) {
			System.out.println("The link is broken");
		}
		else {
			System.out.println("Not broken");
		}
		driver.navigate().to("http://leafground.com/pages/Link.html");
		//go to home page
		driver.findElement(By.xpath("//label[text()='(Interact with same link name)']")).click();
		driver.navigate().to("http://leafground.com/pages/Link.html");
		//how many links available in this page
		driver.findElement(By.xpath("//a[text()='How many links are available in this page?']")).click();
		System.out.println(driver.getCurrentUrl());

		driver.close();
	}

}
