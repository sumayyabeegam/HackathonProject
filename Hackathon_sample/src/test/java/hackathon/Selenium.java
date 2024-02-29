package hackathon;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.logging.log4j.core.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


public class Selenium {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stubWebdriverManage().chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://emicalculator.net/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.xpath("//a[text()='Car Loan']")).click();
		
		Thread.sleep(3000);
		
		
		WebElement car_loan_amount=driver.findElement(By.xpath("//input[@id='loanamount']"));
		car_loan_amount.clear();
		car_loan_amount.sendKeys("1500000");
		WebElement loan_interest=driver.findElement(By.xpath("//*[@id='loaninterest']"));
		loan_interest.clear();
		loan_interest.sendKeys(Keys.BACK_SPACE);
//		text.sendKeys(Keys.BACK_SPACE);
//		text.sendKeys(Keys.BACK_SPACE);
		loan_interest.sendKeys("9.5");
		//System.out.println(car_loan_amount.getLocation());
		//action.dragAndDropBy(car_loan_amount, -130, 40).build().perform();
		WebElement loan_term=driver.findElement(By.xpath("//input[@id='loanterm']"));
		loan_term.clear();
		loan_term.sendKeys(Keys.BACK_SPACE);
		loan_term.sendKeys("1");
		
		
		WebElement emi_ele=driver.findElement(By.xpath("//div[@id='emiamount']"));
		String emi=emi_ele.getText();	
		System.out.println("Emi"+emi);
		
//		String[] s1=emi.split("₹");
//		String[] s2=s1[1].split(",");
//		String sp=s2[0]+s2[1];
//		int emiInt=Integer.parseInt(sp);
//		System.out.println(emiInt);
		
		driver.findElement(By.xpath("(//*[@class='btn btn-secondary'])[1]")).click();
		loan_term.sendKeys(Keys.BACK_SPACE);
		driver.findElement(By.xpath("(//*[@class='btn btn-secondary'])[1]")).click();
		WebElement interest_ele=driver.findElement(By.xpath("//div[@id='emitotalinterest']"));
		String interest=interest_ele.getText();
		System.out.println(interest);
		
		String[] s1=interest.split("₹");
		String[] s2=s1[1].split(",");
		String interest_amount=s2[0]+s2[1];
		int emiInt=Integer.parseInt(interest_amount);
		//System.out.println(emiInt);
		
		String total_pay=driver.findElement(By.xpath("//div[@id='emitotalamount']")).getText();
		String[] s3=total_pay.split("₹");
		String[] s4=s3[1].split(",");
		String pm=s4[0]+s4[1]+s4[2];
		int pmInt=Integer.parseInt(pm);
		//System.out.println(pmInt);
		
		System.out.println("Priciple amount:"+(pmInt-emiInt));
		
		driver.findElement(By.xpath("//a[@title='Calculators']")).click();
		driver.findElement(By.xpath("//a[@title='Home Loan EMI Calculator']")).click();
		
		WebElement home_price=driver.findElement(By.xpath("//input[@id='homeprice']"));
		home_price.clear();
		home_price.sendKeys(Keys.BACK_SPACE);
		home_price.sendKeys("2000000");
		
		WebElement downpay_el=driver.findElement(By.xpath("//input[@id='downpayment']"));
		downpay_el.sendKeys(Keys.BACK_SPACE);
		downpay_el.sendKeys("20");
		
		WebElement home_tenure=driver.findElement(By.xpath("//input[@id='homeloanterm']"));
		home_tenure.clear();
		home_tenure.sendKeys(Keys.BACK_SPACE);
		home_tenure.sendKeys(Keys.BACK_SPACE);
		home_tenure.sendKeys("5");
		
		WebElement insurance=driver.findElement(By.xpath("//input[@id='homeloaninsuranceamount']"));
		insurance.sendKeys(Keys.BACK_SPACE);
		insurance.sendKeys("5000");
		WebElement table_ele=driver.findElement(By.xpath("//table[@class='noextras']/tbody"));
		String table=table_ele.getText();
		//System.out.println(table);
		int rows=table_ele.findElements(By.xpath("//table[@class='noextras']/tbody/tr")).size();// no of rows//table[@class='noextras']/tbody/tr
		//tr[@class='row no-margin yearlypaymentdetails']
		System.out.println("rows"+rows);
		Write.getCellData("Sheet1", 0, 0, "Year");
		Write.getCellData("Sheet1", 0, 1, "Principal");
		Write.getCellData("Sheet1", 0, 2, "Interest");
		Write.getCellData("Sheet1", 0, 3, "Taxes, Home Insurance & Maintenance");
		Write.getCellData("Sheet1", 0, 4, "Total Payment");
		Write.getCellData("Sheet1", 0, 5, "Balance");
		Write.getCellData("Sheet1", 0, 6, "Loan Paid To Date");
		Write.getCellData("Sheet1", 1, 0,"");
		
		for(int r=2;r<rows;r=r+2)
		{
			
			//table[@class='noextras']/tbody/tr[2]/td[1]
			//read data from webtable
			String year=driver.findElement(By.xpath("//table[@class='noextras']/tbody/tr["+r+"]/td[1]")).getText();
			String principal=driver.findElement(By.xpath("//table[@class='noextras']/tbody/tr["+r+"]/td[2]")).getText();
			String interest1=driver.findElement(By.xpath("//table[@class='noextras']/tbody/tr["+r+"]/td[3]")).getText();
			String tax=driver.findElement(By.xpath("//table[@class='noextras']/tbody/tr["+r+"]/td[4]")).getText();
			String total=driver.findElement(By.xpath("//table[@class='noextras']/tbody/tr["+r+"]/td[5]")).getText();
			String balance=driver.findElement(By.xpath("//table[@class='noextras']/tbody/tr["+r+"]/td[6]")).getText();
			String paid=driver.findElement(By.xpath("//table[@class='noextras']/tbody/tr["+r+"]/td[7]")).getText();
			
			System.out.println(year+principal+interest1+tax+total+balance+paid);
			
			//write data to excel
			Write.getCellData("Sheet1", r, 0, year);
			Write.getCellData("Sheet1", r, 1, principal);
			Write.getCellData("Sheet1", r, 2, interest1);
			Write.getCellData("Sheet1", r, 3, tax);
			Write.getCellData("Sheet1", r, 4, total);
			Write.getCellData("Sheet1", r, 5, balance);
			Write.getCellData("Sheet1", r, 6, paid);
			
			
		}
			
//		
		driver.findElement(By.xpath("//a[@title='Calculators']")).click();
		driver.findElement(By.xpath("//a[@title='Loan Calculator']")).click();
		
		System.out.println(driver.findElement(By.xpath("//input[@id='loanamount']")).isEnabled());
		
		WebElement slider=driver.findElement(By.xpath("//span[@class='ui-slider-handle ui-corner-all ui-state-default']"));
		Point ss=slider.getLocation();
		
		System.out.println(ss);
		
		
		
		Actions action = new Actions(driver);
		action.dragAndDropBy(slider, 100, 0).build().perform();
		Point ss2=slider.getLocation();
		System.out.println(ss2);
		
		if(ss!=ss2)
		{
			System.out.println("Pass");
		}
		else
		{
			System.out.println("fails");
		}
//		Assert.assertEquals(ss,ss2);
		
		System.out.println(driver.findElement(By.xpath("//input[@id='loaninterest']")).isEnabled());
		System.out.println(driver.findElement(By.xpath("(//span[@class='ui-slider-handle ui-corner-all ui-state-default'])[3]")).isEnabled());
		
		
		System.out.println(driver.findElement(By.xpath("//input[@id='loanterm']")).isEnabled());
		
		WebElement year_ele=driver.findElement(By.xpath("(//span[@class='ui-slider-handle ui-corner-all ui-state-default'])[4]"));
		Point year=year_ele.getLocation();
		
		System.out.println(year);
		
		
	}
}