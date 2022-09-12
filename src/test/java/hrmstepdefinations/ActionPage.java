package hrmstepdefinations;


import java.time.Duration;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ActionPage {
	WebDriver driver;
	WebElement hrmusername;
	WebDriverWait wait;
	String expectedpassword;
	WebElement hrmpassword;
	public ActionPage(Hooks hook)
	{
		this.driver=hook.driver;
	}
	@Given("user need to be HRM homepage")
	public void user_need_to_be_hrm_homepage() {
		
		Duration sec=Duration.ofSeconds(5);
		wait=new WebDriverWait(driver,sec);
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
	}

	@When("user enter username")
	public void user_enter_username() throws Throwable {
		By hrmusernameL=By.xpath("//input[@placeholder='Username']");
		wait.until(ExpectedConditions.visibilityOfElementLocated(hrmusernameL));
	    hrmusername=driver.findElement(hrmusernameL);
		hrmusername.sendKeys("Admin");
		Thread.sleep(3000);
	    
	}

	@Then("verify username contains entered text or not")
	public void verify_username_contains_entered_text_or_not() {
		String actualusername=hrmusername.getAttribute("value");
		Assert.assertEquals("Admin",actualusername);
	}

	@Then("close browser")
	public void close_browser() {
		 driver.close();
	   
	}

@When("user enter password {string}")
public void user_enter_password(String pass) throws Throwable {
	expectedpassword=pass;
	By hrmpasswordL=By.xpath("//input[@placeholder='Password']");
	wait.until(ExpectedConditions.visibilityOfElementLocated(hrmpasswordL));
	hrmpassword=driver.findElement(hrmpasswordL);
	hrmpassword.sendKeys(pass);
	Thread.sleep(3000);
   
}
@Then("verify password contains entered text or not")
public void verify_password_contains_entered_text_or_not() {
	String actualpassword=hrmpassword.getAttribute("value");
	Assert.assertEquals(expectedpassword,actualpassword);
    
}
@When("user enter hrm username {string}")
public void user_enter_hrm_username(String rownum, DataTable table) {
    
    List<List<String>> info=table.asLists();
    int row=Integer.parseInt(rownum);
    String uname=info.get(row).get(0);
    
    By hrmusernameL=By.xpath("//input[@placeholder='Username']");
	wait.until(ExpectedConditions.visibilityOfElementLocated(hrmusernameL));
    hrmusername=driver.findElement(hrmusernameL);
	hrmusername.sendKeys(uname);
    
    		
}
@When("user enter hrm password {string}")
public void user_enter_hrm_password(String rownum, DataTable table) {
	    List<List<String>> info=table.asLists();
	    int row=Integer.parseInt(rownum);
	    String pass=info.get(row).get(0);
	    By hrmpasswordL=By.xpath("//input[@placeholder='Password']");
		wait.until(ExpectedConditions.visibilityOfElementLocated(hrmpasswordL));
		hrmpassword=driver.findElement(hrmpasswordL);
		hrmpassword.sendKeys(pass);
	  
}
@When("click on login")
public void click_on_login() {
    By loginBtnL=By.xpath("//button[normalize-space()='Login']");
    WebElement loginBtn=driver.findElement(loginBtnL);
    loginBtn.click();
}
@Then("verify dashboard must open")
public void verify_dashboard_must_open() {
    String expectedURL="viewEmployeeList";
    String actualURL=driver.getCurrentUrl();
    boolean status=actualURL.contains(expectedURL);
    Assert.assertTrue("Test script failed as Employee list page is not loaded", status);
}
@Then("verify invalid credentials error msg is visible")
public void verify_invalid_credentials_error_msg_is_visible() {
    By errormsgL=By.xpath("//*[text()='Invalid credentials']");
    WebElement errormsg=driver.findElement(errormsgL);
    Assert.assertTrue(errormsg.isDisplayed());
    
}
@When("user enter orange hrm username as {string}")
public void user_enter_orange_hrm_username_as(String uname) {
	 By hrmusernameL=By.xpath("//input[@placeholder='Username']");
		wait.until(ExpectedConditions.visibilityOfElementLocated(hrmusernameL));
	    hrmusername=driver.findElement(hrmusernameL);
		hrmusername.sendKeys(uname);
	    
}
@When("user enter orange hrm password as {string}")
public void user_enter_orange_hrm_password_as(String pass) {
	By hrmpasswordL=By.xpath("//input[@placeholder='Password']");
	wait.until(ExpectedConditions.visibilityOfElementLocated(hrmpasswordL));
	hrmpassword=driver.findElement(hrmpasswordL);
	hrmpassword.sendKeys(pass);
  
}
@Then("verify result page must contain either error msg or employeelist url")
public void verify_result_page_must_contain_either_error_msg_or_employeelist_url() {
	String expectedURL="viewEmployeeList";
    String actualURL=driver.getCurrentUrl();
    if(actualURL.contains(expectedURL))
    {
    	Assert.assertTrue(true);
    }
    else {
    By errormsgL=By.xpath("//*[text()='Invalid credentials']");
    WebElement errormsg=driver.findElement(errormsgL); 
    Assert.assertTrue(errormsg.isDisplayed());
    }
    
}
@When("verifyoutput")
public void verifyoutput() {
    Assert.assertTrue(false);
}




}
