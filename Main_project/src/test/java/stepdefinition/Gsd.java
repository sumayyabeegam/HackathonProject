package stepdefinition;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.github.dockerjava.api.model.Driver;
import factory.Baseclass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobject.Action;
 
public class Gsd {
	Action a;
	public static WebDriver driver =Baseclass.getDriver();
	@Given ("open the link")
	public void Given_open_the_link() throws InterruptedException {
		Thread.sleep(5000);
	  a=new Action(Baseclass.getDriver());
      a.EleClick();
 
	}
	@Then("capture user information")
	public void capture_user_information() throws InterruptedException {
		Thread.sleep(3000);
		a.GetUserVerify();
	    }
 
	@When("OneCognizant is present or not")
	public void one_cognizant_is_present_or_not() {
	   a.Getonec();
	}
 
	@Then("Navigate to one cognizant")
	public void navigate_to_one_cognizant() throws InterruptedException {
		Thread.sleep(3000);
	    a.oneclick();
	}
 
	@Given("clicking of serch box")
	public void clicking_of_serch_box() throws InterruptedException {
		a=new Action(Baseclass.getDriver());
		Set<String> windowids = driver.getWindowHandles();
		  List<String> windis = new ArrayList<String>(windowids);
		  String parent = windis.get(0);
		  String child = windis.get(1);
		  driver.switchTo().window(child);
		Thread.sleep(2000);
		a.cgsdclick();
	}
 
	@When("Serching of GSD")
	public void serching_of_gsd() throws InterruptedException {
	    a.serchgsd();
	}
 
	@Then("Clicking of GSD Live Support")
	public void clicking_of_gsd_live_support() {
	  a.livegsdclick();  
	}
 
	@Then("Verify for successful navigation to GSD module")
	public void verify_for_successful_navigation_to_gsd_module() throws InterruptedException {
	 Thread.sleep(1000);
      a.url();
	}
 
	@Given("verify if welcome message id displayed or not")
	public void verify_if_welcome_message_id_displayed_or_not() throws InterruptedException {
		Thread.sleep(5000);
		a=new Action(Baseclass.getDriver());
		a.wmessage();
	}
 
	@Then("Print default selected language")
	public void print_default_selected_language() throws InterruptedException {
	    a.dlang();
	}
 
	@Then("Print all languages from drop down")
	public void print_all_languages_from_drop_down() throws InterruptedException {
	    a.listoflanguage();
	}
 
	@When("Print the default county")
	public void print_the_default_county() throws InterruptedException {
	    a=new Action(Baseclass.getDriver());
	    a.defaultcountryinfo();
 
	}
 
	@When("Print the list of country")
	public void print_the_list_of_country() throws InterruptedException, IOException {
	    a.listofcountries();
	}
	@When("Print the defaulr country info")
	public void print_the_info_in_defcountry() throws InterruptedException {
	    a.defaultcountryinfo();
	}
 
	@Then("Find the random number and print the list of query")
	public void find_the_random_number_and_print_the_list_of_query() throws InterruptedException {
		a.randomcountryinfo();
	}
}