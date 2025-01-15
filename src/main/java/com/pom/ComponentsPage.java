package com.pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ComponentsPage {

	WebDriver driver;

	public ComponentsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@id='content']/descendant::div[@class='row']/descendant::li/a")
	private List<WebElement> componentsList;

	public List<WebElement> getComponents() {
		return componentsList;
	}

	public void clickComponentByName(String componentName) {
		for (WebElement comp : componentsList) {
			if (comp.getText().equalsIgnoreCase(componentName)) {
				comp.click();
				break;
			}
		}
	}

}
