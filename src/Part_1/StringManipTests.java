package Part_1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StringManipTests {

	@Test
	void test() {
		assertEquals(123, sumStringDigits("abc123xyz"));
		assertEquals(44, sumStringDigits("aa11b33"));
		assertEquals(18, sumStringDigits("7 11"));
		assertEquals(0, sumStringDigits("Chocolate"));
		assertEquals(7, sumStringDigits("5hoco1a1e"));
		assertEquals(7, sumStringDigits("5$$1;;1!!"));
		assertEquals(1245, sumStringDigits("a1234bb11"));
		assertEquals(0, sumStringDigits(""));
		assertEquals(25, sumStringDigits("a22bbb3"));
	}
	
	
	/*
	 * Complete the sumStringDigits method so that it takes all the numbers from the String (0 - 9)
	 * and returns the sum of the numbers. 
	 * Note: Character.isDigit(char) tests if a char is one of the chars '0', '1', .. '9'. 
	 * Note: Integer.parseInt(string) converts a string to an int.
	 * 
	 */
	public int sumStringDigits(String str) {
		int count = 0;
		boolean countMode = false;
		String currentNum = "0";
		int lastIndex = 0;
		int[] numbers = new int[str.length()];
		int currentIndex = 0;
		for (int i = 0; i < str.length(); i++) {
			if(countMode && !Character.isDigit(str.charAt(i))) {
				currentIndex++;
				currentNum = str.substring(lastIndex, lastIndex + currentIndex);
			}else {
				countMode = false;
				numbers[numbers.length] = Integer.parseInt(currentNum);
				currentIndex = 0;
			}
			if(Character.isDigit(str.charAt(i+1))) {
				lastIndex = i;
				countMode = true;
			}else {
				countMode = false;
			}
		}
		for (int i = 0; i < numbers.length; i++) {
			count+=numbers[i];
		}
		return count;
	}
	
	

}
