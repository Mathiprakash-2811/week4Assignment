package secondseleniumassignment;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Set;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;



public class ActionBigBasket {

	public static void main(String[] args) throws InterruptedException, IOException {

           ChromeDriver driver = new ChromeDriver();
           
           driver.manage().window().maximize();
           
           driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
           
           driver.get("https://www.bigbasket.com/");
           
       
           driver.findElement(By.id("headlessui-menu-button-:R5bab6:")).click();
           
           Actions act = new Actions(driver);
           
           
           WebElement fg =  driver.findElement(By.linkText("Foodgrains, Oil & Masala"));
           act.moveToElement(fg).perform();

           
           WebElement rr =  driver.findElement(By.linkText("Rice & Rice Products"));
           act.moveToElement(rr).perform();
           
        
           WebElement br = driver.findElement(By.linkText("Boiled & Steam Rice"));
           br.click();
           
           Thread.sleep(3000);
           
           WebElement bb = driver.findElement(By.xpath("//input[@id='i-BBRoyal']/following-sibling::label[1]"));
           driver.executeScript("arguments[0].click();",bb);
          
   	       
           WebElement tpr = driver.findElement(By.xpath("//h3[text()='Tamil Ponni Boiled - Rice']"));
           //tpr.click();
           driver.executeScript("arguments[0].click();",tpr);
           
           Set<String> windowHandles = driver.getWindowHandles();
           
           List<String> windows = new ArrayList<String>(windowHandles);
           driver.switchTo().window(windows.get(1));
           
           Thread.sleep(2000);
           

   		  WebElement KG = driver.findElement(By.xpath("//span[text()='5 kg']"));
   		
   		  JavascriptExecutor executor1 = (JavascriptExecutor) driver;
   		  executor1.executeScript("arguments[0].click();", KG);
   		  
   		  String Price = driver.findElement(By.xpath("//td[text()='₹404']")).getText();
   		  System.out.println(Price);
   		  
   		  WebElement button = driver.findElement(By.xpath("//button[text()='Add to basket']"));
   		  button.click();
   		  
   		 String msg = driver.findElement(By.xpath("//p[text()='An item has been added to your basket successfully']")).getText();
		 System.out.println(msg);
		 
	        
	     File scr = driver.getScreenshotAs(OutputType.FILE);
	        
	     File trg = new File("./snaps/basket.png");
	        
	     FileUtils.copyFile(scr,trg);
	     
	     driver.close();
	     
	     driver.switchTo().window(windows.get(0));
	     
	     driver.close();
}

}
