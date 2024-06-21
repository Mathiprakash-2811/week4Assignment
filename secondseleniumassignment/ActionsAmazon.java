package secondseleniumassignment;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ActionsAmazon {

	public static void main(String[] args) throws InterruptedException, IOException {
		
		ChromeDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.get("https://www.amazon.in/");
		
		 WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
	     
		 searchBox.sendKeys("oneplus 9 pro");
	        
		 searchBox.submit();
		 
		 String firstprice = driver.findElement(By.xpath("//span[text()='32,999']")).getText();
		 System.out.println("First product price : " + firstprice);
		 
		 String rating = driver.findElement(By.xpath("//span[text()='8']")).getText();
	    System.out.println("Rating for product : " + rating);
	        
	     driver.findElement(By.xpath("//span[text()='(Refurbished) OnePlus 9 Pro 5G (Morning Mist, 12GB RAM, 256GB Storage)']")).click();
	        
	     Set<String> windowHandles = driver.getWindowHandles();
	     
	     List<String> windows = new ArrayList<String>(windowHandles);
	     driver.switchTo().window(windows.get(1));
	        
	     File scr = driver.getScreenshotAs(OutputType.FILE);
	        
	     File trg = new File("./snaps/amazon.png");
	        
	     FileUtils.copyFile(scr,trg);
	     
	     driver.findElement(By.id("add-to-cart-button")).click();
	     
	     Thread.sleep(3000);
	      
	     String Total = driver.findElement(By.id("attach-accessory-cart-subtotal")).getText();
		
		 Thread.sleep(3000);
		
		
		 System.out.println(Total);
		 
		 if(firstprice.contains(Total))
		 {
			 System.out.println("verified");
		 }
		 
		 Thread.sleep(10000);
		 driver.quit();
	        }
	
	       

}
