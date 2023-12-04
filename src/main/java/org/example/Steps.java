package org.example;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class Steps {
    WebDriver driver;
    @Given("^Open the Firefox and launch the application$")
    public void open_the_Firefox_and_launch_the_application() throws
            Throwable
    {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\Rashad\\IdeaProjects\\untitled5\\geckodriver.exe");

        // Initialize the WebDriver
        driver = new FirefoxDriver();

        // Set implicit wait to handle dynamic elements
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.println("User is on the login page");
        driver.get("http://www.demo.guru99.com/v4");
    }

    @When("^Enter the Username (.*) and Password (.*)$")
    public void enter_the_Username_and_Password(String username, String password) throws Throwable {
        driver.findElement(By.name("uid")).sendKeys(username);
        driver.findElement(By.name("password")).sendKeys(password);
    }


    @Then("^Reset the credential$")
    public void Reset_the_credential() throws Throwable
    {
        driver.findElement(By.name("btnReset")).click();
    }




}