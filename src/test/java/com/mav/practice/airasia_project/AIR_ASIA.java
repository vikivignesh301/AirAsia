package com.mav.practice.airasia_project;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.mav.practice.Advance_code.XLSX_Reader;

public class AIR_ASIA {

	public static WebDriver driver;
	public static String from;
	public static String to;

	public static void browserLaunch() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", ".\\Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.airasia.co.in/home");
		driver.manage().window().maximize();
		Thread.sleep(2000);
	}

	public static void tripDetails() throws InterruptedException, IOException {
		from = XLSX_Reader.particlarData("airasia", 1, 0);
		to = XLSX_Reader.particlarData("airasia", 1, 1);
		WebElement triptype = driver.findElement(By.id("One Way"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", triptype);
		WebElement source_click = driver.findElement(By.xpath("//div[@data-testid='source-field']"));
		js.executeScript("arguments[0].click()", source_click);
		Thread.sleep(1000);
		driver.findElement(By.id("basic-url")).sendKeys(from);
		Thread.sleep(1000);
		WebElement listclick = driver.findElement(By.id("list-item"));
		listclick.click();
		Thread.sleep(1000);
		driver.findElement(By.id("basic-url")).sendKeys(to);
		WebElement listclick1 = driver.findElement(By.id("list-item"));
		listclick1.click();
		Thread.sleep(1000);
	}

	public static void dateSelect() throws InterruptedException {

		WebElement datecontainer = driver.findElement(By.xpath("//div[@class='flight-search-date-picker-wrapper']"));
		datecontainer.click();
		Thread.sleep(1000);
		WebElement dateselect = driver
				.findElement(By.xpath("//div[text()='Oct 2022']//following-sibling::div/div[5]/div[7]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView()", dateselect);
		js.executeScript("arguments[0].click()", dateselect);
		Thread.sleep(1000);
		WebElement back = driver.findElement(By.xpath("//button[@class='btn-back']"));
		back.click();
		Thread.sleep(1000);
	}

	public static void no_Of_People() throws InterruptedException {

		WebElement dropdown = driver.findElement(By.xpath("//div[@data-testid='handleClick']"));
		dropdown.click();
		Thread.sleep(1000);
		WebElement seniorcitizzen = driver.findElement(By.id("scp"));
		seniorcitizzen.click();
		WebElement done = driver.findElement(By.xpath("//button[text()='Done']"));
		done.click();
		WebElement flightsearch = driver.findElement(By.xpath("//img[@alt='select']"));
		flightsearch.click();
	}

	public static void screenShot() throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File destination = new File(
				"C:\\Users\\VIGNESH S\\eclipse-workspace\\AIR_ASIA_PROJECT\\Screenshot\\airasia.png");
		FileUtils.copyFile(source, destination);
	}

	public static void main(String[] args) throws InterruptedException, IOException {
		browserLaunch();
		tripDetails();
		dateSelect();
		no_Of_People();
		screenShot();
	}
}
