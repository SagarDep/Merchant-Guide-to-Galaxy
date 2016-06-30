package com.thoughtworks.marchant_guide.convertor;

import java.util.LinkedHashMap;
import java.util.Stack;
import java.util.regex.Pattern;

/*
 * Currency class handle all responsibility related to Currency conversion. 
 * 
 *  Main functions of this class are :-
 *  1) Validate input symbols according to Roman Numeric system rules and give meaningful error message 
 *  2) Convert input symbols into credit units.
 */

public final class UniversalCurrencyConvertor {

	private static UniversalCurrencyConvertor currencyInstance;
	public final LinkedHashMap<Character, Integer> currencyMap = new LinkedHashMap<Character, Integer>() {
		{
			put(UniversalConstants.ROMAN_I, 1);
			put(UniversalConstants.ROMAN_V, 5);
			put(UniversalConstants.ROMAN_X, 10);
			put(UniversalConstants.ROMAN_L, 50);
			put(UniversalConstants.ROMAN_C, 100);
			put(UniversalConstants.ROMAN_D, 500);
			put(UniversalConstants.ROMAN_M, 1000);
		}
	};

	private UniversalCurrencyConvertor() {
	}

	public static UniversalCurrencyConvertor getCurrencyInstance() {

		if (null == currencyInstance) {
			currencyInstance = new UniversalCurrencyConvertor();

		}
		return currencyInstance;

	}

	public LinkedHashMap<Character, Integer> getCurrencyMap() {

		return currencyMap;
	}

	/*
	 * 
	 * 1) The symbols "I", "X", "C", and "M" can be repeated three times in
	 * succession, but no more.
	 * 
	 * 2) They may appear four times if the third and fourth are separated by a
	 * smaller value, such as XXXIX.)
	 * 
	 * 3) "D", "L", and "V" can never be repeated.
	 * 
	 * 4) A number written in [16]Arabic numerals can be broken into digits. For
	 * example, 1903 is composed of 1, 9, 0, and 3. To write the Roman numeral,
	 * each of the non-zero digits should be treated separately. Inthe above
	 * example, 1,000 = M, 900 = CM, and 3 = III. Therefore, 1903 = MCMIII.
	 */

	public final String checkSymentic(String string) {

		String errorMessage = null;

		// "I", "X", "C", and "M" can be repeated three times
		if (Pattern.compile(UniversalConstants.REGEX_MORE_THAN_3_OCCURANCE)
				.matcher(string).find()) {

			errorMessage = UniversalConstants.ERROR_MESSAGE_4_OCCURANCE;

		}

		// "D", "L", and "V" can never be repeated
		if (Pattern.compile(UniversalConstants.REGEX_MORE_THAN_ONE_OCCURANCE)
				.matcher(string).find()) {

			errorMessage = UniversalConstants.ERROR_MESSAGE_2_OCCURANCE;

		}

		// "I" cannot occure more than once in from of C,X,L,C,D,M
		if (Pattern
				.compile(
						UniversalConstants.REGEX_MORE_THAN_1_OCCURANCE_OF_I_AS_PREFIX)
				.matcher(string).find()) {

			errorMessage = UniversalConstants.ERROR_MESSAGE_2_OCCURANCE_I_PREFIX;
		}

		// "X" cannot occure more than once in from of L,C,D,M
		if (Pattern
				.compile(
						UniversalConstants.REGEX_MORE_THAN_1_OCCURANCE_OF_X_AS_PREFIX)
				.matcher(string).find()) {

			errorMessage = UniversalConstants.ERROR_MESSAGE_2_OCCURANCE_X_PREFIX;

		}

		// "C" cannot occure more than once in from of D,M
		if (Pattern
				.compile(
						UniversalConstants.REGEX_MORE_THAN_1_OCCURANCE_OF_C_AS_PREFIX)
				.matcher(string).find()) {

			errorMessage = UniversalConstants.ERROR_MESSAGE_2_OCCURANCE_C_PREFIX;

		}

		return errorMessage;
	}

	/*
	 * This metod compute total crdit point value of given input according to
	 * Roman Numeral rules
	 */
	public double calculateCredit(String input) {

		int totalUnits = 0;
		Stack<Character> symbolStack = new Stack<Character>();

		for (Character character : input.toCharArray()) {
			symbolStack.add(character);
		}

		Character nextSymbol = null, currentSymbol;

		// Input is empty
		if (symbolStack.size() == 0) {
			return 00;
		}

		// input have only one symbol
		else if (symbolStack.size() == 1) {

			return convertUnitsToCredits(currencyMap.get(symbolStack.pop()));

		} else {

			// input have more than one symbol
			while (!symbolStack.isEmpty()) {

				// pop end element
				currentSymbol = symbolStack.pop();

				// peek next symbol.
				// Important Note 'H' is invalid

				if (!symbolStack.isEmpty()) {
					nextSymbol = symbolStack.peek();
				} else {
					nextSymbol = 'H';
				}

				// "I" can be subtracted from "V" and "X" only.

				// "X" can be subtracted from "L" and "C" only.

				// "C" can be subtracted from "D" and "M" only.

				// "V","L", and "D" can never be subtracted.
				//
				// Only one small-value symbol may be subtracted from any
				// large-value symbol.

				if (nextSymbol != 'H'
						&& (nextSymbol == UniversalConstants.ROMAN_I && (currentSymbol == UniversalConstants.ROMAN_V || currentSymbol == UniversalConstants.ROMAN_X))

						|| (nextSymbol == UniversalConstants.ROMAN_X && (currentSymbol == UniversalConstants.ROMAN_L || currentSymbol == UniversalConstants.ROMAN_C))

						|| (nextSymbol == UniversalConstants.ROMAN_C && (currentSymbol == UniversalConstants.ROMAN_D || currentSymbol == UniversalConstants.ROMAN_M))) {

					totalUnits += currencyMap.get(currentSymbol)
							- currencyMap.get(symbolStack.pop());

				} else {

					totalUnits += currencyMap.get(currentSymbol);
				}
			}
		}

		return convertUnitsToCredits(totalUnits);
	}

	/*
	 * Coverts units to credit depend on current metal type
	 */
	private double convertUnitsToCredits(int numberOfUnits) {

		// Credit for iron
		if (UniversalConstants.currentMetalType == UniversalConstants.METAL_IRON) {

			return numberOfUnits * UniversalConstants.IRON_PER_UNIT;

		}
		// Credit for Silver
		else if (UniversalConstants.currentMetalType == UniversalConstants.METAL_SILVER) {

			return numberOfUnits * UniversalConstants.SILVER_PER_UNIT;

		}
		// Credit for Gold
		else if (UniversalConstants.currentMetalType == UniversalConstants.METAL_GOLD) {

			return numberOfUnits * UniversalConstants.GOLD_PER_UNIT;

		}
		// just checking credits
		else {
			return numberOfUnits;
		}
	}

}
