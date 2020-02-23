package com.alds.hr.klarna;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author rohsingh
 * 
 * 
1. You're given a number and you should write the multiples of 3 and 5 up to that number. Using a set is straightforward.

2. You're given a String consisting of positive integers delimited by whitespace. You must get these integers and weight sort them. 
	Sort first according to the sum of digits in each integer, if the sums are equal, the smaller one comes first. Use Java8 Comparator.comparing

3. Typical BraceChecker question. See if left parentheses match right parentheses. Use stack!  
 *
 */
public class Klarna {
      
	public static void mutipleOf3And5(int n) {
		Set<Integer> out = IntStream.range(3, n).filter(i -> (i % 3 == 0) || (i % 5 == 0)).boxed()
				.collect(Collectors.toSet());
		System.out.println(out);
	}
    
	public static void weightSorting(String in) {
		List<Integer> out = Stream.of(in.split(" ")).map(Integer::valueOf).sorted((i1, i2) -> i1.compareTo(i2))
				.collect(Collectors.toList());
		System.out.println(out);
	}
    
	public static boolean braceChecker(String in) {
		Stack<Character> s = new Stack<Character>();
		// Iterating over the entire string.
		for (char st : in.toCharArray()) {
			// If the input string contains an opening parenthesis,
			// push in on to the stack.
			if (st == '(' || st == '{' || st == '[') {
				s.push(st);
			} else {
				// In the case of valid parentheses, the stack cannot be
				// be empty if a closing parenthesis is encountered.
				if (s.empty()) {
					return false;
				}
				// If the input string contains a closing bracket,
				// then pop the corresponding opening parenthesis if present.
				char top = (Character) s.peek();
				if (st == ')' && top == '(' || st == '}' && top == '{' || st == ']' && top == '[') {
					s.pop();
				}
			}
		}
		if(!s.empty()) {
			return false;
		} 
		return true;
	}
    
	
	// 1
    private final int SIZE = 6;
    private final int NUMBER_OF_LASTCHARS_NOTTO_MASK = 4;

    /**
     * It is assumed that creditCardNumber starts with a digit and ends with 4 digits.
     * @param creditCardNumber
     * @return masked creditCardNumber
     */
    public String maskify(String creditCardNumber) {

        if (creditCardNumber == null || creditCardNumber.isEmpty()) {
            return "";
        }

        if (creditCardNumber.length() < SIZE) {
            return creditCardNumber;
        }

        if (creditCardNumber.replaceAll("\\D", "").length() < SIZE) {
            return creditCardNumber;
        }

        int cardLength = creditCardNumber.length();

        String inner = creditCardNumber.substring(1, cardLength - NUMBER_OF_LASTCHARS_NOTTO_MASK);
        inner = inner.replaceAll("[0-9]", "#");

        creditCardNumber = creditCardNumber.charAt(0) + inner + creditCardNumber.substring(cardLength - NUMBER_OF_LASTCHARS_NOTTO_MASK);
        return creditCardNumber;

    }
    
    
    // 2
    private final int EDGE_CASES = 10;

    public String numberToOrdinal(Integer number) {
        String ordinal, ordinalSuffix;

        if (number.equals(0)) {
            return number.toString();
        }

        if(isEdgeCase(number)){
            ordinalSuffix = "th";
        }else{
            ordinalSuffix = determineOrdinalSuffix(number);
        }

        ordinal = number.toString();
        return ordinal.concat(ordinalSuffix);

    }

    private boolean isEdgeCase(Integer number){
        int modeToTen = number % 10;
        int modeToHundred = number % 100;
        return ((modeToHundred - modeToTen) == EDGE_CASES);
    }

    private String determineOrdinalSuffix(Integer number){
        String ordinalSuffix;
        number = number % 10;
        switch (number){
            case 1:
                ordinalSuffix = "st";
                break;
            case 2:
                ordinalSuffix = "nd";
                break;
            case 3:
                ordinalSuffix = "rd";
                break;
            default:ordinalSuffix = "th";
        }
        return ordinalSuffix;
    }
    
    
    // 3
    private final List<String> operators = Stream.of(Operator.values()).map(Operator::getOp).collect(Collectors.toList());
    private Stack<Double> bucket = new Stack<>();

    public double evaluate(String expr) {
        if(expr == null || expr.isEmpty()){
            return 0.0;
        }

        Arrays.stream(expr.split(" ")).forEach(input->{
            if (operators.contains(input)) {
                Double operand2 = bucket.pop();
                Double operand1 = bucket.pop();
                Double result = Operator.valueOf(input).apply(operand1, operand2);
                bucket.push(result);
            }else{
                bucket.push(Double.parseDouble(input));
            }
        });
        return bucket.pop();
    }

    private double applyOperator(String operator, Double operand1, Double operand2){
        Double result = null;
        switch (operator){
            case "/":
                result = operand1 / operand2;
                break;
            case "*":
                result = operand1 * operand2;
                break;
            case "-":
                result = operand1 - operand2;
                break;
            case "+":
                result = operand1 + operand2;
                break;
        }

        return result;
    }
    
    enum Operator {
        DIVIDE("/") {
        	@Override
        	public Double apply(Double op1, Double op2) {
        		return op1 / op2;
        	}
        },
        ADD("+") {
			@Override
			public Double apply(Double op1, Double op2) {
				return op1 + op2;
			}
		},
        SUBTRACT("-") {
			@Override
			public Double apply(Double op1, Double op2) {
				return op1 - op2;
			}
		},
        MUTIPLY("*") {
			@Override
			public Double apply(Double op1, Double op2) {
				return op1 * op2;
			}
		};
      
        String op;
      
        Operator(String op) {
          this.op = op;
        }
      
        public String getOp() {
          return op;
        }
        
        public abstract Double apply(Double op1, Double op2);
    }
    
    public static void main(String[] args) {
        mutipleOf3And5(20);
    }
    
}
