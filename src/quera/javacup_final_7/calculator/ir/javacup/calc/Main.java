package quera.javacup_final_7.calculator.ir.javacup.calc;

import java.math.BigDecimal;

public class Main {

	public static void main(String[] args) {
		BigDecimal op1 = new BigDecimal(100);
		BigDecimal op2 = new BigDecimal(64);


		// single operand
		Calculable sqrt = operands -> {
			System.out.println("sqrt called");
			return BigDecimal.valueOf(Math.sqrt(operands[0].longValue()));
		};
		CalculatorProxy sqrtProxy = new CalculatorProxy(sqrt);

		System.out.println(sqrtProxy.doOperation(op1)); // op1: first time
		System.out.println(sqrtProxy.doOperation(op1)); // op1: second time
		System.out.println(sqrtProxy.doOperation(op2)); // op2: first time

		System.out.println();

		// two operands
		Calculable adder = operands -> {
			System.out.println("adder called");
			return operands[0].add(operands[1]);
		};
		Calculable adderProxy = new CalculatorProxy(adder);

		System.out.println(adderProxy.doOperation(op1, op2)); // op1,op2: first time
		System.out.println(adderProxy.doOperation(op1, op2)); // op1,op2: second time
		System.out.println(adderProxy.doOperation(op2, op1)); // op2,op1: first time
	}

}

