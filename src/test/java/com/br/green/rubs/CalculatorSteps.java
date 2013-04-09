package com.br.green.rubs;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.jbehave.core.annotations.Aliases;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

public class CalculatorSteps {

	Calculator calculator;
	int firstParameter = 0;
	int secondParameter = 0;
	
	@Given("a calculator app is selected")
	@Aliases(values={"a new calculator"})
	public void createCalculator() {
		calculator = new Calculator();
	}
	
	@When("first parameter is $param1 and second parameter is $param2")
	public void setParameterValues(int param1, int param2) {
		firstParameter = param1;
		secondParameter = param2;
	}
	
	@Then("the sum result should be $result")
	public void doTheSum(int result) {
		int sum = calculator.sum(firstParameter, secondParameter);
//		assertEquals("The expected value(" + result + ") is equal to the calculated value(" + sum + ")", sum, result);
		assertEquals(sum, result);
	}

	@Then("the minus result should be $result")
	public void doTheMinus(int result) {
		assertEquals(calculator.minus(firstParameter, secondParameter), result);
	}

	@Then("the sum result should not be $result")
	public void doTheWrongSum(int result) {
		int sum = calculator.sum(firstParameter, secondParameter);
		assertFalse("The result is wrong as expected. Calculated: [" + sum + "] Received: [" + result + "]", (sum == result));
	}
	
}
