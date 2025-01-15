package com.stepDef;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.hooks.Hooks;
import com.pom.ComponentsPage;
import com.pom.HomePage;
import com.pom.MonitorsPage;
import com.pomManager.POMManager;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitions {

	WebDriver driver = Hooks.getDriver();
	POMManager pageObjectManager = new POMManager(driver);

	private HomePage homePage = pageObjectManager.getHomePage();
	private ComponentsPage componentsPage;
	private MonitorsPage monitorsPage;

	@Given("the user opens the OpenCart homepage")
	public void the_user_opens_the_open_cart_homepage() {

		homePage = pageObjectManager.getHomePage();
		driver.get("https://demo.opencart.com/");
		driver.manage().window().maximize();
	}

	@When("the user hovers over the {string} menu")
	public void the_user_hovers_over_the_menu(String menu) throws InterruptedException {
		if (menu.equalsIgnoreCase("Components")) {
			homePage.hoverOverComponentsMenu();
		}
	}

	@When("the user clicks on {string}")
	public void the_user_clicks_on(String componentName) throws InterruptedException {
		if (componentName.equalsIgnoreCase("Show All Components")) {
			homePage.clickShowAllComponents();
			componentsPage = pageObjectManager.getComponentsPage(); // Ensure ComponentsPage is initialized
		} else if (componentName.equalsIgnoreCase("Monitors (2)")) {
			componentsPage.clickComponentByName(componentName);
			monitorsPage = pageObjectManager.getMonitorsPage(); // Ensure MonitorsPage is initialized
		}
	}

	@Then("the user should see {int} components listed")
	public void the_user_should_see_components_listed(Integer expectedSize) {
		List<WebElement> components = componentsPage.getComponents();
		Assert.assertEquals(expectedSize.intValue(), components.size());
	}

	@Then("the user should see a list of monitors and their names")
	public void the_user_should_see_a_list_of_monitors_and_their_names() {
		monitorsPage.printMonitorNames(); // Utilizing the printMonitorNames method from MonitorsPage
	}

	@Then("the user should see breadcrumbs with a count")
	public void the_user_should_see_breadcrumbs_with_a_count() {
		List<WebElement> breadCrumbs = driver.findElements(By.xpath("//ul[@class='breadcrumb']/child::li"));
		System.out.println("Number of breadcrumbs present is: " + breadCrumbs.size());
	}
}
