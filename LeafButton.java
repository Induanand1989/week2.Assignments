package week2.day2.Assignments;


import java.time.Duration;

import org.openqa.selenium.By;

import org.openqa.selenium.chrome.ChromeDriver;



import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafButton {

	public static void main(String[] args) {
		//setup
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		//load the url
		driver.get("http://leafground.com/pages/Button.html");
		//maximize
		driver.manage().window().maximize();
		//implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		//go to home page
		driver.findElement(By.xpath("//button[@id='home']")).click();
		//click button
		driver.findElement(By.xpath("//h5[text()='Button']")).click();
		//get position
		System.out.println(driver.findElement(By.xpath("//button[text()='Get Position']")).getLocation());
		//what color am i
		System.out.println(driver.findElement(By.xpath("//button[text()='What color am I?']")).getCssValue("background-color"));
		//get size
		System.out.println(driver.findElement(By.xpath("//button[text()='What is my size?']")).getSize());
		//get title
		System.out.println(driver.getTitle());
		//close browser
		driver.close();






	}

}

