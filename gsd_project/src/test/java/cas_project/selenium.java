package cas_project;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class selenium {
    
	public static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
         driver= new EdgeDriver();
         WebDriverManager.edgedriver().setup();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //Thread.sleep(5000);
        driver.get("https://be.cognizant.com/");
        //appURL=https://cognizantonline.sharepoint.com/sites/Be.Cognizant/SitePages/Home.aspx

        driver.manage().window().maximize();
        Thread.sleep(5000);
//         driver.findElement(By.xpath("//input[@name='loginfmt']")).sendKeys("2304071@cognizant.com");
//        driver.findElement(By.xpath("//input[@id='idSIButton9']")).click();
//        Thread.sleep(5000);
//        WebElement el=driver.findElement(By.xpath("//input[@name='passwd']"));
//        el.sendKeys("Fathima@1970");
//        el.sendKeys(Keys.ENTER);
        
        JavascriptExecutor js=(JavascriptExecutor)driver;
        Thread.sleep(5000);
        WebElement el2=driver.findElement(By.xpath("//div[@class=\'_8ZYZKvxC8bvw1xgQGSkvvA==\']"));
        Thread.sleep(5000);
		js.executeScript("arguments[0].click();", el2);
//        
		 Thread.sleep(5000);
        WebElement el1=driver.findElement(By.xpath("//div[@id='mectrl_currentAccount_primary']"));
       
        String name=el1.getText();
        System.out.println(name);
        
        Thread.sleep(5000);
        String actual_name="Beegam, Sumayya (Cognizant)";
        if(actual_name.equals(name))
        {
        	System.out.println("Pass");
        }
        else
        {
        	System.out.println("Fail");
        }
        Thread.sleep(5000);
       WebElement el4=driver.findElement(By.xpath("//div[@title='OneCognizant']"));
       if(el4.isDisplayed())
        {
    	   js.executeScript("arguments[0].click();", el4);
    	   //el4.click();
    	   System.out.println("OneCognizant is present");
        }
       Thread.sleep(5000);
       
       Set<String> windowids = driver.getWindowHandles();
		  List<String> windis = new ArrayList<String>(windowids);
		  String parent = windis.get(0);
		  String child = windis.get(1);
		  driver.switchTo().window(child);
		
//		  WebElement search=driver.findElement(By.xpath("//*[@class='searchBasedTopBar']/li"));
//		  ////div[@class='waves-effect waves-circle searchBarIcon']
//		  js.executeScript("arguments[0].click();", search);
		  driver.findElement(By.xpath("//input[@id='oneC_searchAutoComplete']")).sendKeys("gsd");
		  driver.findElement(By.xpath("//div[@class=\"appsResultText\"]")).click();
		  Thread.sleep(7000);
		  driver.switchTo().frame(1);
		  
		  boolean wellmsg=driver.findElement(By.xpath("//p[text()='Welcome to the all-in-one Live Support!']")).isDisplayed();
		  System.out.println(wellmsg);
		  Thread.sleep(3000);
		  
		  driver.findElement(By.xpath("(//a[@id=\"menu1\"])[1]")).click();
       
   		  List<WebElement> options=driver.findElements(By.xpath("//ul[contains(@class, \"dropdown-menu langList show\")]/li"));
   		  ////ul[contains(@role,'menuitem')][1]
   		WebElement langsel=driver.findElement(By.xpath("(//span[@class='optionLangSelected'])[1]"));
   		System.out.println("default language:");
   		System.out.println(langsel.getText());
   		System.out.println("List of languages");
   		 System.out.println("-------------------");
   		  for(WebElement a:options)
   		  {
   			 System.out.println(a.getText());
   			  Thread.sleep(3000);
   			 
   		  }
   		  
   		driver.findElement(By.xpath("(//a[@id='menu2'])[1]")).click();
   		List<WebElement> country=driver.findElements(By.xpath("//ul[@class='dropdown-menu countryList pt-0 show']"));
   		System.out.println(country.size());
   		WebElement countysel=driver.findElement(By.xpath("(//span[@class='optionCountrySelected'])[1]"));
   		System.out.println("default country:");
   		System.out.println(countysel.getText());
   		System.out.println("List of countries");
   		System.out.println("-------------------");
   		
   		for(WebElement a:country)
		  {//(//ul[@class='dropdown-menu countryList pt-0'])[1]
			 System.out.println(a.getText());
			  Thread.sleep(3000);
		  }
   		
   		
   		Thread.sleep(2000);
   		//To print data under each heading
   		WebElement heading1=driver.findElement(By.xpath("//div[text()='IT Infra Support']"));
   		System.out.println(heading1.getText());
   		System.out.println("-------------------");
   		
   		List<WebElement> first=driver.findElements(By.xpath("(//div[@class='eachTileRow'])[1]"));
   		for(WebElement a:first)
   		{
   			System.out.println(a.getText());
   		}
   		
   		WebElement heading2=driver.findElement(By.xpath("//div[text()='Human Resources']"));
   		System.out.println(heading2.getText());
   		System.out.println("-------------------");
   		List<WebElement> second=driver.findElements(By.xpath("(//div[@class='eachTileRow'])[2]"));
   		for(WebElement a:second)
   		{
   			System.out.println(a.getText());
   		}
   		
   		WebElement heading3=driver.findElement(By.xpath("//div[text()='IT Application Support']"));
   		System.out.println(heading3.getText());
   		System.out.println("-------------------");
   		List<WebElement> third=driver.findElements(By.xpath("(//div[@class='eachTileRow'])[3]"));
   		for(WebElement a:third)
   		{
   			System.out.println(a.getText());
   		}
   		
   		WebElement heading4=driver.findElement(By.xpath("//div[text()='Policy & Process Support']"));
   		System.out.println(heading4.getText());
   		System.out.println("-------------------");
   		List<WebElement> forth=driver.findElements(By.xpath("(//div[@class='eachTileRow'])[4]"));
   		for(WebElement a:forth)
   		{
   			System.out.println(a.getText());
   		}
   		
   		//to print the tooltip
   		List<WebElement> list=new ArrayList(driver.findElements(By.xpath("//div[@class='p-1 flex-fill']/div")));
   		for(WebElement list1:list) {
   			System.out.println(list1.getAttribute("data-bs-original-title"));
   		}
   		 
   		List<WebElement> Conlist1 = driver.findElements(By.xpath("/html/body/nav[1]/div/form/div[2]/ul/li/a"));
	    int r1 = (int)Math.ceil(55*Math.random()),r2;
	    do {
	    	r2 = (int)Math.ceil(55*Math.random());
	    }while(r1==r2);
	    System.out.println(r1);
	    System.out.println(r2);
	    System.out.println(" ");
	    Conlist1.get(r1).click();
	    toolTipinfo();
	    driver.findElement(By.xpath("(//a[@id='menu2'])[1]")).click();
	    Conlist1.get(r2).click();
	    toolTipinfo();
    	//driver.switchTo().defaultContent();
	    driver.close();
	}
	private static void toolTipinfo() {
		System.out.println("information present in randomly selected country");
		System.out.println("------------------------------------------------");
		System.out.println(" ");
		WebElement c2 = driver.findElement(By.xpath("(//a[@id='menu2'])[1]"));
	    String c22 = c2.getText();
	    System.out.println(c22);
	    List<WebElement> tool1 = driver.findElements(By.xpath("//ul[@class='dropdown-menu countryList pt-0 show']"));
	    int tip1 = tool1.size();
	    for(int i=1;i<=tip1;i++) {
	    	String ttinfo1 = driver.findElement(By.xpath("//ul[@class='dropdown-menu countryList pt-0 show']")).getText();
	    	System.out.println("----------------------------");
	    	System.out.println(ttinfo1);
	    	System.out.println(" ");
	    }
	    //
	    List<WebElement> tool2 = driver.findElements(By.xpath("//ul[@class='dropdown-menu countryList pt-0 show']"));
	    int tip2 = tool2.size();
	    for(int i=1;i<=tip2;i++) {
	    	String ttinfo2 = driver.findElement(By.xpath("//ul[@class='dropdown-menu countryList pt-0 show']")).getText();
	    	System.out.println("----------------------------");
	    	System.out.println(ttinfo2);
	    	System.out.println(" ");
	    }
	    //
	    List<WebElement> tool3 = driver.findElements(By.xpath("//ul[@class='dropdown-menu countryList pt-0 show']"));
	    int tip3 = tool3.size();
	    for(int i=1;i<=tip3;i++) {
	    	String ttinfo3 = driver.findElement(By.xpath("//ul[@class='dropdown-menu countryList pt-0 show']")).getText();
	    	System.out.println("----------------------------");
	    	System.out.println(ttinfo3);
	    	System.out.println(" ");
	    }
	    List<WebElement> tool4 = driver.findElements(By.xpath("//ul[@class='dropdown-menu countryList pt-0 show']"));
	    int tip4 = tool4.size();
	    for(int i=1;i<=tip4;i++) {
	    	String ttinfo4 = driver.findElement(By.xpath("//ul[@class='dropdown-menu countryList pt-0 show']")).getText();
	    	System.out.println("----------------------------");
	    	System.out.println(ttinfo4);
	    	System.out.println(" ");
	    }
   		
   		
	}}
	


