package secondseleniumassignment;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class Frame {

	public static void main(String[] args) {

           ChromeDriver driver = new ChromeDriver();
           
           driver.manage().window().maximize();
           
           driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
           
           driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_prompt");
           
           driver.switchTo().frame("iframeResult");
           
           driver.findElement(By.xpath("//button[text()='Try it']")).click();
           
           Alert alert = driver.switchTo().alert();
           
           System.out.println(alert.getText());
           
           //alert.sendKeys("Mathi");
           
           alert.accept();
           
           System.out.println(driver.findElement(By.id("demo")).getText());
           
           //alert.dismiss();
           
           //System.out.println(driver.findElement(By.id("demo")).getText());
           
 }

}
