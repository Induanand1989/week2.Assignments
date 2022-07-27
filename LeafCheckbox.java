package week2.day2.Assignments;


import java.time.Duration;


import org.openqa.selenium.By;

import org.openqa.selenium.chrome.ChromeDriver;


import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafCheckbox {

	public static void main(String[] args) {
		//setup
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		//load url
		driver.get("http://leafground.com/pages/checkbox.html");
		//maximize
		driver.manage().window().maximize();
		//implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		//select the languages
		driver.findElement(By.xpath("//label[text()='Select the languages that you know?']/following::input[3]")).click();
		System.out.println("languages have selected");

		//confirm the check box is selected
		boolean selected = driver.findElement(By.xpath("(//div[@class='example'])[2]/input")).isSelected();
		System.out.println(" Selenium is checked is " +selected);

		//deselect only checked
		boolean select=driver.findElement(By.xpath("(//label[text()='DeSelect only checked']/following::input)[2]")).isSelected();

		if(select){
			driver.findElement(By.xpath("(//label[text()='DeSelect only checked']/following::input)[2]")).click();

		}
		System.out.println("Deselected the selected");

		//select all check boxes
		

		for (int i = 1; i <=6; i++) {
			driver.findElement(By.xpath(("//label[text()='Select all below checkboxes ']/following-sibling::input["+i+"]"))).click();

         }	
        System.out.println("All boxes selected");
        driver.close();

	}
}