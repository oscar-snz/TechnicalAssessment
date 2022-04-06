package com.simetrik.qa.utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.Keys;

public class CommonUI extends Constants {

	public static void openBrowser(String browser) {
		try {

			switch (browser.toLowerCase()) {

			case "chrome":
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				break;

			case "firefox":
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				break;
			}
		} catch (Exception e) {
			System.out.println("Browser has [" + browser + "] value. Make sure to pass [chrome/firefox]");
			e.printStackTrace();
		}
	}

	public static void navigate(String url) {

		try {
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.get(url);

		} catch (Exception e) {
			System.out.println("Check the url [" + url + "], make sure it contains correct format");
			e.printStackTrace();

		}

	}

	public static boolean isDisplayed(WebElement element) {
		try {

			return element.isDisplayed();

		} catch (Exception e) {

			System.out.println("Element is not displayed:" + element);
			e.printStackTrace();

			return false;
		}
	}

	public static void enter(WebElement element, String value) {

		if (isDisplayed(element)) {
			element.clear();
			element.sendKeys(value);

		}

	}

	public static void sendEnter(WebElement element) {
		if (isDisplayed(element)) {
			element.sendKeys(Keys.RETURN);
		}
	}

	public static void quitBrowser() {

		try {

			driver.quit();

		} catch (Exception e) {
			System.out.println("Driver object is null");
			e.printStackTrace();
		}
	}
}
