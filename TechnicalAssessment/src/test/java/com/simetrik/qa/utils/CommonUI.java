package com.simetrik.qa.utils;

import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CommonUI extends Constants{

	public static void openBrowser(String browser) {
		try {
 
			switch (browser.toLowerCase()) {

			case "chrome":
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				break;
}
		}catch (Exception e) {
			System.out.println("Browser has [" + browser + "] value. Make sure to pass [chrome]");
			e.printStackTrace();
	}
}
}
