package com.br.green.rubs;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;


public class TranslatorEngine {
	
	private WebDriver driver = null;
	private String source = "";
	
	public void setFirefoxDriver () {
//		driver = new FirefoxDriver();
		driver = new FirefoxDriver(new FirefoxBinary(new File("C:/Wilson/tools/FirefoxPortable/FirefoxPortable.exe")), null);
	}
	
	public void setChromeDriver () {
		driver = new ChromeDriver();
	}
	
	public void setSafariDriver () {
		driver = new SafariDriver();
	}

	public void setIEDriver () {
		File file = new File("C:/IEDriverServer.exe");
		System.setProperty("webdriver.ie.driver", file.getAbsolutePath());
		driver = new InternetExplorerDriver();
	}

	public String translateSource(String source, String fromLanguage, String toLanguage) {
		
		String translation = "";
		
		driver.get("http://translate.google.com.br");
		driver.findElement(By.xpath("//*[@id=\"gt-sl-gms\"]")).click();
				
		WebElement from = driver.findElement(By.xpath("//*[@id=\":" + this.searchLanguage(fromLanguage, Side.LEFT) + "\"]"));
		from.click();
		
		WebElement toLanguageBox = driver.findElement(By.xpath("//*[@id=\"gt-tl-gms\"]/div[1]"));
		toLanguageBox.click();
		
		WebElement to = driver.findElement(By.xpath("//*[@id=\":" + this.searchLanguage(toLanguage, Side.RIGHT) + "\"]"));
		to.click();
		
		WebElement element = driver.findElement(By.xpath("//*[@id=\"source\"]"));        
        element.sendKeys(source);
        element.submit();
        
        
        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                String result = d.findElement(By.xpath("//*[@id=\"result_box\"]")).getText(); 
            	return (!result.contains("...") || !result.isEmpty());
            }
        });        
        
        translation = driver.findElement(By.xpath("//*[@id=\"result_box\"]")).getText();
        
//        System.out.println("The translation is: " + translation);
        
        driver.quit();
        
        return translation;
        
		
	}
	
	private String searchLanguage(String language, Side side) {
		
		String boxID = "";
		
		if (language.equalsIgnoreCase("portugues") || language.equalsIgnoreCase("português") || language.equalsIgnoreCase("portuguese")) {
			if (side == Side.LEFT)
				boxID = "1f";
			else
				boxID = "39";
		} else if (language.equalsIgnoreCase("ingles") || language.equalsIgnoreCase("inglês") || language.equalsIgnoreCase("english")) {
			if (side == Side.LEFT)
				boxID = "z";
			else
				boxID = "2t";
		} else if (language.equalsIgnoreCase("frances") || language.equalsIgnoreCase("francês") || language.equalsIgnoreCase("french")) {
			if (side == Side.LEFT)
				boxID = "o";
			else
				boxID = "2i";
		} else if (language.equalsIgnoreCase("japones") || language.equalsIgnoreCase("japonês") || language.equalsIgnoreCase("japanese")) {
			if (side == Side.LEFT)
				boxID = "13";
			else
				boxID = "2x";
		} else if (language.equalsIgnoreCase("chines") || language.equalsIgnoreCase("chinês") || language.equalsIgnoreCase("chinese")) {
			if (side == Side.LEFT)
				boxID = "d";
			else
				boxID = "27";
		} else if (language.equalsIgnoreCase("espanhol") || language.equalsIgnoreCase("spanish")) {
			if (side == Side.LEFT)
				boxID = "k";
			else
				boxID = "2e";
		} else if (language.equalsIgnoreCase("italiano") || language.equalsIgnoreCase("italian")) {
			if (side == Side.LEFT)
				boxID = "12";
			else
				boxID = "2w";
		}
		
		return boxID;
	}
	
	private enum Side {
		LEFT,
		RIGHT
	}
	
}
