package stepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginStepDefinitions {
    WebDriver driver;
    @Given("^user is already in login page$")
    public void loginPage(){
        System.setProperty("webdriver.chrome.driver","/Users/saleemkhan/Jahidul project/CucumberBDDFrameWork2018/browserDriver/chromedriver");
        driver= new ChromeDriver();
        driver.get("https://www.freecrm.com/");
    }

    @When("^title of login page is FreeCRM$")
    public void title_of_login_page_is_FreeCRM()  {
        String title = driver.getTitle();
        System.out.println(title);
        Assert.assertEquals("#1 Free CRM software in the cloud for sales and service", title);

    }

    @Then("^user enters username and user enters password$")
    public void user_enters_username_and_user_enters_password() {
        driver.findElement(By.name("username")).sendKeys("naveenk");
        driver.findElement(By.name("password")).sendKeys("test@123");

    }

    @Then("^user click on login button$")
    public void user_click_on_login_button() {
        WebElement loginButton = driver.findElement(By.xpath("//*[@id='loginForm']/div/div/input"));
        JavascriptExecutor je =(JavascriptExecutor)driver;
        //Confusion
        je.executeScript("arguments[0].click();", loginButton);

    }

    @Then("^user is on homepage$")
    public void user_is_on_homepage()  {
        String title = driver.getTitle();
        System.out.println(title);
        Assert.assertEquals("CRMPRO", title);

    }

    @Then("^close the browser$")
    public void close_the_browser()  {
        driver.close();

    }





}
