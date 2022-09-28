package com.POM_Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home_Page {

	public static WebDriver driver;

	@FindBy(id = "One Way")
	private WebElement triptype;
	@FindBy(xpath = "//div[@data-testid='source-field']")
	private WebElement source_click;
	@FindBy(id = "basic-url")
	private WebElement source;
	@FindBy(id = "list-item")
	private WebElement listclick;
	@FindBy(id = "basic-url")
	private WebElement desti;
	@FindBy(id = "list-item")
	private WebElement listclick1;
	@FindBy(xpath = "//div[@class='flight-search-date-picker-wrapper']")
	private WebElement datecontainer;
	@FindBy(xpath = "//div[text()='Oct 2022']//following-sibling::div/div[5]/div[7]")
	private WebElement dateselect;
	@FindBy(xpath = "//button[@class='btn-back']")
	private WebElement back;
	@FindBy(xpath = "//div[@data-testid='handleClick']")
	private WebElement dropdown;
	@FindBy(id = "scp")
	private WebElement seniorcitizzen;
	@FindBy(xpath = "//button[text()='Done']")
	private WebElement done;
	@FindBy(xpath = "//img[@alt='select']")
	private WebElement flightsearch;

	public Home_Page(WebDriver driver2) {
		this.driver = driver2;
		PageFactory.initElements(driver, this);
	}

	public WebElement getTriptype() {
		return triptype;
	}

	public WebElement getSource_click() {
		return source_click;
	}

	public WebElement getSource() {
		return source;
	}

	public WebElement getListclick() {
		return listclick;
	}

	public WebElement getDesti() {
		return desti;
	}

	public WebElement getListclick1() {
		return listclick1;
	}

	public WebElement getDatecontainer() {
		return datecontainer;
	}

	public WebElement getDateselect() {
		return dateselect;
	}

	public WebElement getBack() {
		return back;
	}

	public WebElement getDropdown() {
		return dropdown;
	}

	public WebElement getSeniorcitizzen() {
		return seniorcitizzen;
	}

	public WebElement getDone() {
		return done;
	}

	public WebElement getFlightsearch() {
		return flightsearch;
	}

}
