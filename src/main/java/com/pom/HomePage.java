package com.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

	WebDriver driver;
	WebDriverWait wait;
	Actions a;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 15);
		this.a = new Actions(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[text()='Components']")
	private WebElement componentsMenu;

	@FindBy(xpath = "//a[text()='Show All Components']")
	private WebElement showAllComponentsOption;

	public WebElement getComponentsMenu() {
		return componentsMenu;
	}

	public WebElement getShowAllComponentsOption() {
		return showAllComponentsOption;
	}

	public void hoverOverComponentsMenu() throws InterruptedException {
		Thread.sleep(5000);
		WebElement component = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Components']")));
		a.moveToElement(component).build().perform();
		component.click();
	}

	public void clickShowAllComponents() throws InterruptedException {
		
		WebElement allComponents = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Show All Components']")));
		allComponents.click();
	}

}
