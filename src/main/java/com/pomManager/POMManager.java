package com.pomManager;

import org.openqa.selenium.WebDriver;

import com.pom.ComponentsPage;
import com.pom.HomePage;
import com.pom.MonitorsPage;

public class POMManager {

	public WebDriver driver;

	private HomePage homePage;
	private ComponentsPage componentsPage;
	private MonitorsPage monitorsPage;

	public POMManager(WebDriver driver) {
		this.driver = driver;
	}

	public HomePage getHomePage() {
		if (homePage == null) {
			homePage = new HomePage(driver);
		}
		return homePage;
	}

	public ComponentsPage getComponentsPage() {
		if (componentsPage == null) {
			componentsPage = new ComponentsPage(driver);
		}
		return componentsPage;
	}

	public MonitorsPage getMonitorsPage() {
		if (monitorsPage == null) {
			monitorsPage = new MonitorsPage(driver);
		}
		return monitorsPage;
	}
}
