package com.stepdefinition;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.POM_Page.Home_Page;
import com.Property_File.ConfigurationHelper;
import com.mav.practice.Advance_code.XLSX_Reader;
import com.runner.RunnerClassairasia;

import baseClassAirAsia.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinition extends BaseClass {

	public static WebDriver driver = RunnerClassairasia.driver;
	public static String from;
	public static String to;
	public static Home_Page h = new Home_Page(driver);

	@Given("user Launch The Url")
	public void user_launch_the_url() throws IOException {
		launchUrl(ConfigurationHelper.getInstance().getUrl());
		screenMaximize();
		implicitWait();
	}

	@When("click For a Trip Type")
	public void click_for_a_trip_type() throws InterruptedException {
		jsClick(h.getTriptype());
		sleep();
	}

	@When("enter The Source and Destination")
	public void enter_the_source_and_destination() throws IOException, InterruptedException {
		from = XLSX_Reader.particlarData("airasia", 1, 0);
		to = XLSX_Reader.particlarData("airasia", 1, 1);
		jsClick(h.getSource_click());
		sleep();
		h.getSource().sendKeys(from);
		sleep();
		h.getListclick().click();
		sleep();
		h.getDesti().sendKeys(to);
		h.getListclick1().click();
		sleep();
	}

	@When("select For Date and Count Of People")
	public void select_for_date_and_count_of_people() throws InterruptedException {

		clickonElement(h.getDatecontainer());
		sleep();
		jsScrollInToView(h.getDateselect());
		jsClick(h.getDateselect());
		sleep();
		clickonElement(h.getBack());
		sleep();
		clickonElement(h.getDropdown());
		sleep();
		clickonElement(h.getSeniorcitizzen());
		clickonElement(h.getDone());
	}

	@Then("click Search button and Take Screenshot")
	public void click_search_button_and_take_screenshot() throws IOException, InterruptedException {
		clickonElement(h.getFlightsearch());
		sleep();
		screenShot("airasia");
	}

}
