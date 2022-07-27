

package week2.day2.Assignments;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafDropDown {

	public static void main(String[] args) {
		//setup
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		//load url
		driver.get("http://leafground.com/pages/Dropdown.html");
		//maximize
		driver.manage().window().maximize();
		//implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		//select dropdown using index
		WebElement index = driver.findElement(By.xpath("//select[@id='dropdown1']"));
		Select dropdown1 = new Select(index);
		dropdown1.selectByIndex(1);

		//select dropdown using text
		WebElement text = driver.findElement(By.xpath("//select[@name='dropdown2']"));
		Select dropdown2 = new Select(text);
		dropdown2.selectByVisibleText("Selenium");

		//select dropdown using value
		WebElement value = driver.findElement(By.xpath("//select[@name='dropdown3']"));
		Select dropdown3 = new Select(value);
		dropdown3.selectByValue("1");

		//get the number of dropdown option
		WebElement option =driver.findElement(By.xpath("//select[@class='dropdown']"));
		Select Size = new Select(option);
		List<WebElement> List = Size.getOptions();
		System.out.println(List.size());
	
		//select by SendKeys
		driver.findElement(By.xpath("//option[contains(text(),'sendKeys ')]//..")).sendKeys("Selenium");

		//select programs
		WebElement program = driver.findElement(By.xpath("(//option[contains(text(),'programs')]//..)[1]"));
		Select dropdown5 = new Select(program);

		if(dropdown5.isMultiple()) {
			//select multiple values
			dropdown5.selectByIndex(1);
			dropdown5.selectByIndex(2);
			dropdown5.selectByVisibleText("UFT/QTP");

		}
	}


}