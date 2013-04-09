package com.br.green.rubs;

import static org.junit.Assert.assertEquals;

import org.jbehave.core.annotations.Aliases;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

public class TranslatorEngineSteps {

	TranslatorEngine engine = new TranslatorEngine();
	String result = "";
	
	@Given("a Firefox browser")
	@Aliases(values={"a firefox browser"})
	public void setFirefoxBrowser() {
		engine.setFirefoxDriver();
	}
	
	@Given("a Chrome browser")
	public void setChromeBrowser() {
		engine.setChromeDriver();
	}

	@Given("a Safari browser")
	public void setSafariBrowser() {
		engine.setSafariDriver();
	}

	@Given("a IE browser")
	public void setIEBrowser() {
		engine.setIEDriver();
	}

	@When("a text to be translated is $text from $from to $to")
	public void translate(String text, String from, String to) {
		result = engine.translateSource(text, from, to);
	}
	
	@Then("the translation should be $suggestion")
	public void checkResult(String suggestion) {
		assertEquals(suggestion, result);
	}
}
