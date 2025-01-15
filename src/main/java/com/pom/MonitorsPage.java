package com.pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MonitorsPage {

	WebDriver driver;

	public MonitorsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@class='col mb-3']/descendant::div[@class='description']/descendant::a")
	private List<WebElement> monitorsList;

	public List<WebElement> getMonitors() {
		return monitorsList;
	}

	public void printMonitorNames() {
		List<WebElement> monitors = getMonitors();
		for (WebElement monitor : monitors) {
			System.out.println(monitor.getText());
		}
	}
}
