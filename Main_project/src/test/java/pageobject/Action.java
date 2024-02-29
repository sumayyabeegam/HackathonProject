package pageobject;
 
import java.io.IOException;
import java.sql.Driver;
import java.time.Duration;
import java.util.List;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.ExcelData;
 
public class Action extends BasePage{
	public Action(WebDriver driver)
	{
		super(driver);
	}

	//Elements
	@FindBy(xpath= "//div[@id='O365_HeaderRightRegion']")
	WebElement Ele;
	@FindBy(xpath="//div[@id='mectrl_currentAccount_primary']")
	WebElement user;
//	@FindBy(xpath="//div[@title='All Apps & Tools']")
//	WebElement AppandTools;
	@FindBy(xpath = "//div[@id=\"89c5ffca-2ffb-4052-a723-e99c8c9a14ef\"]")
	WebElement AppandTools;
	@FindBy(xpath="//div[@title='OneCognizant']")
	WebElement onecognizant;
	@FindBy(xpath="//div[text()='OneCognizant']")
	WebElement onecc;
	@FindBy(xpath="//input[@id='oneC_searchAutoComplete']")
	WebElement cgsd;
	@FindBy(xpath="//input[@id='oneC_searchAutoComplete']")
	WebElement serch;
	@FindBy(xpath="//div[@class='appsResultText']")
	WebElement livegsd;
	@FindBy(xpath="//p[text()='Welcome to the all-in-one Live Support!']")
	WebElement message;
	@FindBy(xpath="//a[@id='menu1']")
	WebElement dlang;
	@FindBy(xpath="//*[@class=\"dropdown-menu langList show\"]")
	List<WebElement> listlang;
	@FindBy(xpath="//a[@id='menu2']")
	WebElement dcountry;
	@FindBy(xpath="")
	List<WebElement> lcountry;
	
	@FindBy (xpath="//a[@id='menu2']")
	WebElement c2;
	@FindBy (xpath="//div[text()=\"IT Infra Support\"]")
	WebElement info1;
	@FindBy (xpath="(//div[@class=\"eachTileRow\"])[1]//div[@class=\"col-md-12 application-tiles\"]") 
	List<WebElement> tool1;
	@FindBy (xpath="//div[text()=\"Human Resources\"]")
	WebElement info2;
	@FindBy (xpath="(//div[@class=\"eachTileRow\"])[2]//div[@class=\"col-md-12 application-tiles\"]")
	List<WebElement> tool2;
	@FindBy (xpath="//div[text()=\"IT Application Support\"]")
	WebElement info3;
	@FindBy (xpath="(//div[@class=\"eachTileRow\"])[3]//div[@class=\"col-md-12 application-tiles\"]")
	List<WebElement> tool3;
	@FindBy (xpath="//div[text()=\"Policy & Process Support\"]")
	WebElement info4;
	@FindBy (xpath="(//div[@class=\"eachTileRow\"])[4]//div[@class=\"col-md-12 application-tiles\"]")
	List<WebElement> tool4;
	@FindBy (xpath="/html/body/nav[1]/div/form/div[2]/ul/li/a")
	List<WebElement> Conlist1;


//	@FindBy(xpath="//input[@id=\\\"i0116\\\"]")
//    WebElement username;
//	@FindBy(xpath="//*[@id=\\\"idSIButton9\\\"]")
//	WebElement usernameclick;
//	@FindBy(xpath="//input[@type=\\\"password\\\"]")
//	WebElement password;
//	@FindBy(xpath ="//input[@value=\\\"Sign in\\\"]")
//	WebElement signin;
//	public void username() {
//		try {
//			username.sendKeys("2304071@cognizant.com");
//			usernameclick.click();
//			}
//			catch(Exception e) {
//			}
//	}
//	public void password() throws InterruptedException {
//		Thread.sleep(5000);
//		try {
//			password.sendKeys("Fathima@1970");
//			signin.click();
//		}catch(Exception e) {
//		}
//	}
//	public void authentication() {
//		try {
//			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
//			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"KmsiCheckboxField\"]")));
//		    WebElement d = username;
//		    d.click();
//		    }
//			catch (Exception e) {}    
// 
//	}

	public void EleClick() throws InterruptedException
	{
		Thread.sleep(50000);
		Ele.click();
		Thread.sleep(3000);
	}	
	public String userverify() 
	{
		String username = user.getText();
		return username;
	}	
	public void GetUserVerify() throws InterruptedException
	{
		Assert.assertEquals(userverify(), "Beegam, Sumayya (Cognizant)");
		Thread.sleep(5000);
		Ele.click();
	}
	public String onec() 
	{
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();",AppandTools);
		String oc=onecognizant.getText();
		return oc;
	}
	public void Getonec() 
	{
		Assert.assertEquals(onec(),"OneCognizant");
	}
	public void oneclick() throws InterruptedException
	{
		onecc.click();
		Thread.sleep(3000);
	}
	public void cgsdclick() throws InterruptedException 
	{
		Thread.sleep(3000);
		cgsd.click();
	}
	public void serchgsd() throws InterruptedException 
	{
		Thread.sleep(3000);
		serch.sendKeys("gsd");
	}
	public void livegsdclick() {
		livegsd.click();
	}
	public void url() throws InterruptedException {
		Thread.sleep(3000);
		String p=driver.getCurrentUrl();
		String Url = "https://onecognizant.cognizant.com/Home?GlobalAppId=926";
		Assert.assertEquals(p, Url);
	}
	public String wmessage() throws InterruptedException 
	{
		Thread.sleep(5000);
		driver.switchTo().frame(1);
		String welcome = message.getText();
		return welcome;
	}	
	public void welmsg() throws InterruptedException
	{
		Thread.sleep(8000);
		Assert.assertEquals(wmessage(),"Welcome to the all-in-one Live Support!");
	}
	public void dlang() throws InterruptedException
	{
		dlang.click();
		String deflang=dlang.getText();
		System.out.println(deflang);
		Thread.sleep(3000);
	}	
	public void listoflanguage() throws InterruptedException {
		 for(WebElement a:listlang) 
		 {
			String langNames =a.getText();
			System.out.println("List of available Languages:");
			System.out.println(langNames);
		}
		}
//	public void defaultcountry() throws InterruptedException {
//		dcountry.click();
//		String defcountry=dcountry.getText();
//		System.out.println(defcountry);
//		Thread.sleep(6000);
//	}
	public void listofcountries() throws InterruptedException, IOException {
		int row=0;
		Thread.sleep(5000);
		for(WebElement c:lcountry) {
			String countryName=c.getText();
			System.out.println(countryName);
			ExcelData.write("Sheet1",row,0,countryName);
//			System.out.println("List of available Country:");
//			System.out.println(countryName);
			row++;
		}
		Thread.sleep(5000);
	}
	public void defaultcountryinfo() throws InterruptedException 
	{
		System.out.println("Default Country information:");
		System.out.println("----------------------------");
		toolTipinfo();
		Thread.sleep(6000);
	}
	
	public void randomcountryinfo() throws InterruptedException 
	{
	    int r1 = (int)Math.ceil(55*Math.random()),r2;
	    do {
	    	r2 = (int)Math.ceil(55*Math.random());
	    }while(r1==r2);
	    System.out.println("Random No1:"+r1);
	    System.out.println("Random No2:"+r2);
	    Thread.sleep(2000);
	    Conlist1.get(r1).click();
	    System.out.println("Random Country information:");
		System.out.println("---------------------------");
		System.out.println(" ");
	    toolTipinfo();
	    driver.findElement(By.xpath("(//a[@id='menu2'])[1]")).click();
	    Thread.sleep(2000);
	    Conlist1.get(r2).click();
	    System.out.println("Random Country information:");
		System.out.println("---------------------------");
		System.out.println(" ");
		toolTipinfo();
		Thread.sleep(6000);
		driver.quit();
	}
	public void toolTipinfo() 
	{
	    String c22 = c2.getText();
	    System.out.println(c22);
	    System.out.println(" ");
	    //
		String tool = info1.getText();
		System.out.println(tool);
	    for(WebElement comments:tool1) {
	    	System.out.println("----------------------------");
	    	System.out.println(comments.getText());
	    	System.out.println(comments.getAttribute("data-bs-original-title"));
	    	System.out.println(" ");
	    }
	    //
		String too2 = info2.getText();
		System.out.println(too2);
	    for(WebElement com2:tool2) {
	    	System.out.println("----------------------------");
	    	System.out.println(com2.getText());
	    	System.out.println(com2.getAttribute("data-bs-original-title"));
	    	System.out.println(" ");
	    }
	    //
		String too3 = info3.getText();
		System.out.println(too3);
	    for(WebElement com3:tool3) {
	    	System.out.println("----------------------------");
	    	System.out.println(com3.getText());
	    	System.out.println(com3.getAttribute("data-bs-original-title"));
	    	System.out.println(" ");
	    }
	    //
		String too4 = info4.getText();
		System.out.println(too4);
	    for(WebElement com4:tool4) {
	    	System.out.println("----------------------------");
	    	System.out.println(com4.getText());
	    	System.out.println(com4.getAttribute("data-bs-original-title"));
	    	System.out.println(" ");
	    }
    }

}