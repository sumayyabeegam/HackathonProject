package mini_project;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Scanner;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ecommerce_automation {
	
	public static WebDriver driver;
	
	
	//Method to initialize Edge browser
	public void edge(){
		 driver=new EdgeDriver();
		 driver.get("https://www.flipkart.com/");
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				 
	}
	//Method to initialize Chrome browser
	public void chrome(){
		 driver=new ChromeDriver();
		 driver.get("https://www.flipkart.com/");
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				 
	}
	public void work() throws InterruptedException, IOException {	
	//driver.findElement(By.xpath("//*[@class='_30XB9F']")).click();
				
		// To locate search box
		
		WebElement element=driver.findElement(By.name("q"));
		String Data = Excel.getExcelData();
		element.sendKeys(Data);
		element.sendKeys(Keys.ENTER);
		
		// To validate whether mobiles are under 15000
		String str=driver.getTitle();
		if(str.equals("Mobiles Under 15000- Buy Products Online at Best Price in India - All Categories | Flipkart.com")) {
			System.out.println("pass");
		}
		else {
			System.out.print("fail");
		}
		
		
		//To drag the price bar to 10000 as max price
		Select s=new Select(driver.findElement(By.xpath("(//select[@class='_2YxCDZ'])[2]")));
		s.selectByValue("10000");

		Thread.sleep(3000);
		
		//To select the operating system version name as “Pie”
		WebElement el=driver.findElement(By.xpath("//*[text()='Operating System Version Name']"));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView;", el);
		js.executeScript("arguments[0].click();", el);
		Thread.sleep(2000);
		
		// To select '11 More' under operatng system version
		WebElement el1=driver.findElement(By.xpath("//*[text()='11 MORE']"));
		js.executeScript("arguments[0].scrollIntoView;", el1);
		js.executeScript("arguments[0].click();", el1);

		Thread.sleep(3000);
		
		// To select 'pie'
		WebElement el3=driver.findElement(By.xpath("(//label[@class='_2iDkf8 t0pPfW'])[36]"));
		js.executeScript("arguments[0].click();", el3);
		
		Thread.sleep(3000);
		// To Click on “Newest First” to display latest products on top
		WebElement el2=driver.findElement(By.xpath("//*[text()='Newest First']"));
		js.executeScript("arguments[0].click();", el2);
		Thread.sleep(2000);
		
		//To display the names of first five mobiles
		List<WebElement> list=driver.findElements(By.xpath("//*[@class='_4rR01T']"));
		List<WebElement> price=driver.findElements(By.xpath("//*[@class='_30jeq3 _1_WHN1']"));
		int count=0;
		Thread.sleep(3000);
		for(WebElement ele:list) {
			System.out.println(ele.getText());
			
			count++;
			if(count==5) {
				break;
			}
		}
		Thread.sleep(3000);
		
		//To display the prices of first five mobiles
		int count1=0;
		for(WebElement elem:price) {
			System.out.println(elem.getText());
			count1++;
			if(count1==5) {
				break;
			}
		}
		// To validate whether the first mobile price is “Less than 30000”
		String str1=driver.findElement(By.xpath("(//*[@class='_30jeq3 _1_WHN1'])[1]")).getText();
		String[] s1=str1.split("₹");
		String[] s2=s1[1].split(",");
		String sp= s2[0]+s2[1];
		int p=Integer.parseInt(sp);
		if(p<30000) {
			System.out.print("pass");
		}
		else {
			System.out.print("fail");
		}
		
	}
	// To close the browser
	public void close() {
		driver.quit();
	}
	public static void main(String[] args) throws InterruptedException, IOException {
		
		System.out.println("Enter which browser");
		Scanner sc=new Scanner(System.in);
		String string=sc.nextLine();
		ecommerce_automation e=new ecommerce_automation();
		if(string.equals("chrome")) {
			e.chrome();
		}
		else if(string.equals("edge")) {
			e.edge();
		}
		else {
			System.out.print("chrome/edge");
		}
		
		e.work();
		e.close();
	}

}
