package Part_1;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class StringManipTests {

	public StringManipTests(){
		
	}
	
	@Test
	public void test() {
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
		boolean[] isNumbers = new boolean[str.length()];
		String currentNum = "0";
		for (int i = 0; i < str.length(); i++) {
			if(Character.isDigit(str.charAt(i))){
				isNumbers[i] = true;
			}
		}
		for (int i = 0; i < isNumbers.length; i++) {
			if(isNumbers[i]){
				currentNum+=str.charAt(i);
			}else{
				count+=Integer.parseInt(currentNum);
				currentNum = "0";
			}
		}
		if(isNumbers.length > 1 && isNumbers[isNumbers.length-1]){
			count+=Integer.parseInt(currentNum);
		}
		return count;
	}
	
	

}
