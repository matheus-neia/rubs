package com.br.green.rubs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;


public class TranslatorEngine {
	
	private WebDriver driver = null;
	private String source = "";
	
	public void setFirefoxDriver () {
		driver = new FirefoxDriver();
		//testando
	}
	
	public void setChromeDriver () {
		driver = new ChromeDriver();
	}
	
	public void setSafariDriver () {
		driver = new SafariDriver();
	}
	
	public String translateSource(String source) {
		
		String translation = "";
		
		driver.get("http://translate.google.com.br");

		WebElement element = driver.findElement(By.name("text"));        
        element.sendKeys(source);
        element.submit();
        
        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                String result = d.findElement(By.id("result_box")).getText(); 
            	return (!result.contains("...") || !result.isEmpty());
            }
        });        
        
        translation = driver.findElement(By.id("result_box")).getText();
        
//        System.out.println("The translation is: " + translation);
        
        driver.quit();
        
        return translation;
        
		
	}
	
}
