//
///**
// * Java's primitive data types int and long can represent the numbers
// * in the following range.
// *
// *           Integer: (-2147483648, 2147483647)
// *           Long Integer: (-9223372036854775808, 9223372036854775807)
// *
// * We want to represent numbers that larger than 9223372036854775807.
// * One idea is to use an array to store each digit of the big number.
// * For example: 9223372036854775807 is stored in an array as
// * [9,2,2,3,3,7,2,0,3,6,8,5,4,7,7,5,8,0,7].
// *
// *
// * In this project, you will implement the BigInteger class, which can
// * store any size integer and perform basic arithmetic operations on the
// * number.
// */
//package biginteger;
//import javax.print.DocFlavor;
//import java.math.BigDecimal;
//import java.time.LocalTime;
//import java.util.Arrays;
//import java.util.Collections;
//public class BigInteger {
//	private static final boolean POSITIVE   = true;
//	private static final boolean NEGATIVE = false;
//	/**
//	 * // this array stores the number. Each digit of the number is an
//	 * element of the array
//	 */
//	private final int[] number;
//	/**
//	 * sign of this BigInteger. POSITIVE or NEGATIVE
//	 */
//	private final boolean sign;
//	/**
//	 * Default constructor, creates a BigInteger object whose value is 0.
//	 * and whose sign is positive
//	 *
//	 * This constructor will assign sign of the BigInteger
//	 * and will assign BigInteger array called number to 0
//	 */
//	public BigInteger(){
//		//TODO
//		//replace assignments for number and sign with accordance to constructor description
//		int [] arr = {0};
//		number = arr ;
//		this.sign = POSITIVE;
//	}
//	/**
//	 * Constructor, creates a BigInteger object with given sign and given array of numbers
//	 * @param sign of a number
//	//  * @param array of integers
//	 * This constructor will assign sign of the BigInteger
//	 * and will copy all elements of the given array into BigInteger array called number
//	 */
//	public BigInteger(boolean sign, int[] val){
//		//TODO
//		//replace assignments for number and sign with accordance to constructor description
//		this.number =  val;
//		this.sign = sign;
//	}
//	/**
//	 * Create a BigInteger object using the number given as string.
//	 * If the string starts with "-", it indicates, the number is negative.
//	 *        in this case assign sign to negative and store all numbers from  a String in number array
//	 * If the string starts with "+", or a digit, the number is positive.
//	 *        in this case assign sign to positive and store all numbers from  a String in number array
//	 * If the string is null or empty, the number is zero. zero is a positive number.
//	 *        in this case assign sign to positive and store 0 in number array
//	 * If string contains non-digit characters, throw IllegalArgumentException
//	 *        in this case use the following syntax to throw an exception:
//	 *                    throw new IllegalArgumentException();
//	 *
//	 *
//	 *
//	 * @param :n the number in string format.
//	 *  For example:
//	 *     BigInteger b1 = new BigInteger("1234567890");
//	 *  b1 is a BigInteger with value of 1234567890 stored in number array
//	 *  BigInteger b2 = new BigInteger("-1234567");
//	 *  b1 is a BigInteger with value of -1234567 stored in number array
//	 *  BigInteger b3 = new BigInteger("+123");
//	 *  b3 is a BigInteger with value of +123 stored in number array
//	 *  BigInteger b3 = new BigInteger("+123xyz");
//	 *  throw IllegalArgumentException
//	 */
//	public BigInteger(String strNumber){
////    this();    //use to call the default constructor
//		//TODO
//		boolean check = false;
//		int [] res = new int [0];
//		if (strNumber.startsWith("-")) {
//			this.sign = NEGATIVE;
//			res = new int [strNumber.length() - 1];
//			check = true;
//		} else if (strNumber.startsWith("+")){
//			this.sign = POSITIVE;
//			res = new int [strNumber.length() - 1];
//			check = true;
//		} else {
//			this.sign = POSITIVE;
//			res = new int [strNumber.length()];
//		}
//		if (check){
//			for (int i = 1,k = 0; i < strNumber.length();i++,k++){
//				res[k] = Integer.parseInt(strNumber.charAt(i) + "");
//			}
//		} else{
//			for (int i = 0; i < strNumber.length();i++){
//				res[i] = Integer.parseInt(strNumber.charAt(i) + "");
//			}
//		}
//		this.number = res;
//		//replace assignments for number and sign with accordance to constructor description
//	}
//	/**
//	 * Create a BigInteger object using another another BigInteger.
//	 * This constructor will take another BigInteger as a parameter and will copy all the values into
//	 * this BigInteger and assign the sign
//	 * @param another: BigInteger object
//	 *     BigInteger b = new BigInteger("1234567890")
//	 *
//	 * Create a new BigInteger object using b
//	 *  BigInteger b2 = new BigInteger(b)
//	 */
//	public BigInteger(BigInteger another){
//		//TODO
//		this(another.sign,another.number);
//		//replace assignments for number and sign with accordance to constructor description
////    this.number =  another.number;
////    this.sign = another.sign;
//	}
//	/**
//	 * Adds two BigIntegers, and creates a new BigInteger with the result of the addition
//	 *
//	 * IMPORTANT: Pay attention to the integer sign and length
//	 *        When two positive values are added, the result is positive (2+2=4)
//	 *      When one positive and one negative numbers are added,
//	 *            the result can be negative (-4 + 2 = -2) or positive (-2 + 3 = 1)
//	 *      When two negative values are added, the result is negative (-2 + -2 = -4)
//	 *      When both numbers are zeroes, the result is zero as well
//	 *
//	 * Two add two big integers, we cad add each digit at the same index
//	 * from the two arrays. For example:
//	 * a:[1,2,3,4]
//	 * b:[5,6,7,8]
//	 * a+b is
//	 * [6,9,1,2]
//	 *
//	 * @param b: BigInteger to be added to this BigInteger Object
//	 * @return: a new BigInteger object, whose value is the sum of this and b, two BigInteger
//	 *          objects
//	 */
//	public  BigInteger add(BigInteger b){
//		String first = "";
//		String first1 = "";
//
//		String re = "";
//		Long result ;
//
//		if (!b.sign){
//			first += "-";
//		}
//		if (!this.sign){
//			first1 += "-";
//		}
//
//		for (int num: this.number){
//			first1 += num ;
//		}
//		for (int num: b.number){
//			first += num ;
//		}
//
//
//		result = Math.addExact(Long.parseLong(first),Long.parseLong(first1));
//       String r = result + "";
//return new BigInteger(r);
//
//
//		}
//
//
//
//
//
//
//
////
////		if ((!this.sign && !b.sign) || (this.sign && b.sign)){
////			result = Math.addExact(Integer.parseInt(first) , Integer.parseInt(first1));
////		}
////		if (result >= 0){
////			check = true;
////		} else {
////			check = false;
////		}
////		String res = result + "";
////		int [] arr = new int [res.length()];
////		if (check) {
////			for (int i = 0; i < arr.length; i++) {
////				arr[i] = Integer.parseInt(res.charAt(i) + "");
////			}
////		} else {
////			for (int i = 0,k = 1;k < res.length();k++,i++){
////				arr[i] = Integer.parseInt(res.charAt(k) + "");
////			}
////		}
////
////		if ((this.sign && !b.sign) || (!this.sign && b.sign)){
////			return sub(b);
////		}
////		if (check) {
////			return new BigInteger(POSITIVE, arr);
////		}
////		return new BigInteger(this.sign,arr);
////	}
//	/**
//	 * Subtracts BigInteger b from this BigInteger, and creates a new BigInteger with
//	 * the result of the subtraction.
//	 * @param b: BigInteger to be subtracted from this BigInteger Object
//	 * @return: a new BigInteger object
//	 */
//	public BigInteger sub(BigInteger b){
//		//TODO
//
//		String first = "";
//		String first1 = "";
//
////
//		if (!b.sign && this.sign){
//			first += "-";
//		}
//		if (!this.sign && b.sign){
//			first1 += "-";
//		}
//
//		for (int num: this.number){
//			first1 += num +"";
//		}
//		for (int num: b.number){
//			first += num + "";
//		}
////
//	Long f = Long.parseLong(first);
//		Long f1 = Long.parseLong(first1);
//		String r = f - f1 + "";
////
////		return new BigInteger(r);
////		String one="";
////		String two="";
////		if(!this.sign&&b.sign){
////			one+="-";
////		}else if(!b.sign&&this.sign){
////			two+="-";
////		}else {
////			one="";
////			two="";
////		}
////		if(this.number.length<19&&b.number.length<19) {
////			for (int i = 0; i < this.number.length; i++) {
////				one += this.number[i];
////			}
////			for (int i = 0; i < b.number.length; i++) {
////				two += b.number[i];
////			}
////			long one1 = Long.parseLong(one);
////			long two2 = Long.parseLong(two);
////			long sub = one1 - two2;
////			String sub2 = "" + sub;
////			BigInteger bigI = new BigInteger(sub2);
////			return bigI;
////		}
////		return null;
//if(isZero()){
//	return null;
//}
//return new BigInteger(r);
//}
//	/**
//	 * Compares this BigInteger with the specified BigInteger.
//	 * @param b: BigInteger to which this BigInteger is to be compared.
//	 * @return:  -1, 0 or 1 as this BigInteger is numerically less than,
//	 * equal to, or greater than b
//	 */
//	public int compareTo(BigInteger b) {
//		String a = "";
//		String B = "";
//		int result = 0;
//		for (int num: b.number){
//			a += num + "";
//		}
//		for (int num: this.number){
//			B += num + "";
//		}
//		if (this.sign && !b.sign){
//			return 1;
//		} else if (!this.sign && b.sign) {
//			return -1;
//		} else {
//			result = a.compareTo(B);
//		}
//		return result;
//	}
//	/**
//	 * Returns an int array containing this BigInteger.
//	 * The array will contain each digit of this BigInteger as an element
//	 * @return: an int array containing this BigInteger, ignore the sign
//	 */
//	public int[] toArray(){
//		return this.number;
//	}
//	/**
//	 * Check if the BigInteger is zero
//	 * @return true if BigInteger value is zero. False otherwise
//	 */
//	public boolean isZero(){
//		//TODO
//		if (this.number.length == 0 || this.number[0] == 0)
//			return true;
//		return  false;
//	}
//	/**
//	 * Returns the length of this BigInteger. length is the number of digits in a BigInteger
//	 * @return: length of this integer
//	 */
//	public int length(){
//		//TODO
//		return this.number.length;
//	}
//	/**
//	 * Returns the sign of this BigInteger.
//	 * @return: sign of this integer
//	 */
//	public boolean sign(){
//		return sign;
//	}
//	/**
//	 * returns the the BigInteger in string format. If the number is
//	 * negative, return string must start with a "-"
//	 * @return BigInteger in a String format
//	 */
//	public String toString(){
//		String result = "";
//		if (this.sign){
//			result += "";
//		}
//		else {
//			result+= "-";
//		}
//		for (int i = 0;i < this.number.length;i++){
//			result += this.number[i] + "";
//		}
//		return result;
//	}
//}








/**
 * Java's primitive data types int and long can represent the numbers
 * in the following range.
 *
 * 			Integer: (-2147483648, 2147483647)
 * 			Long Integer: (-9223372036854775808, 9223372036854775807)
 *
 * We want to represent numbers that larger than 9223372036854775807.
 * One idea is to use an array to store each digit of the big number.
 * For example: 9223372036854775807 is stored in an array as
 * [9,2,2,3,3,7,2,0,3,6,8,5,4,7,7,5,8,0,7].
 *
 *
 * In this project, you will implement the BigInteger class, which can
 * store any size integer and perform basic arithmetic operations on the
 * number.
 */
package biginteger;

import java.util.ArrayList;
import java.util.Collections;

public class BigInteger {

	private static final boolean POSITIVE   = true;
    private static final boolean NEGATIVE = false;

	/**
	 * // this array stores the number. Each digit of the number is an
	 * element of the array
	 */
	private final int[] number;
	/**
	 * sign of this BigInteger. POSITIVE or NEGATIVE
	 */
    private final boolean sign;

    /**
	 * Default constructor, creates a BigInteger object whose value is 0.
	 * and whose sign is positive
	 *
	 * This constructor will assign sign of the BigInteger
	 * and will assign BigInteger array called number to 0
	 */
	public BigInteger(){
		//TODO
		number = new int[1];
		number [0] =  0;
		this.sign = POSITIVE;

		//replace assignments for number and sign with accordance to constructor description
		//his.sign = false;
	}
    /**
	 * Constructor, creates a BigInteger object with given sign and given array of numbers
	 * @param sign of a number
	 * @param array of integers
	 * This constructor will assign sign of the BigInteger
	 * and will copy all elements of the given array into BigInteger array called number
	 */
	public BigInteger(boolean sign, int[] val){
		//TODO
	    //replace assignments for number and sign with accordance to constructor description
		number =  val;
		this.sign = sign;
	}

	/**
	 * Create a BigInteger object using the number given as string.
	 * If the string starts with "-", it indicates, the number is negative.
	 * 		in this case assign sign to negative and store all numbers from  a String in number array
	 * If the string starts with "+", or a digit, the number is positive.
	 * 		in this case assign sign to positive and store all numbers from  a String in number array
	 * If the string is null or empty, the number is zero. zero is a positive number.
	 * 		in this case assign sign to positive and store 0 in number array
	 * If string contains non-digit characters, throw IllegalArgumentException
	 * 		in this case use the following syntax to throw an exception:
	 * 						throw new IllegalArgumentException();
	 *
	 *
	 *
	 * @param en: the number in string format.
	 *  For example:
	 * 	BigInteger b1 = new BigInteger("1234567890");
	 *  b1 is a BigInteger with value of 1234567890 stored in number array
	 *  BigInteger b2 = new BigInteger("-1234567");
	 *  b1 is a BigInteger with value of -1234567 stored in number array
	 *  BigInteger b3 = new BigInteger("+123");
	 *  b3 is a BigInteger with value of +123 stored in number array
	 *  BigInteger b3 = new BigInteger("+123xyz");
	 *  throw IllegalArgumentException
	 */
	public BigInteger(String strNumber){
		//this();	//use to call the default constructor
		if(!strNumber.equals("")){
		ArrayList<Integer> digit = new ArrayList<>();//it is easier to store
		if(strNumber.startsWith("-")){
			this.sign= NEGATIVE;
			for (int i = 1; i <strNumber.length(); i++) {
					digit.add(Integer.parseInt(""+strNumber.charAt(i)));
			}
		}
		  else{
			this.sign = POSITIVE;
			if(strNumber.startsWith("+")){
				for (int i = 1; i <strNumber.length(); i++) {
					digit.add(Integer.parseInt(""+strNumber.charAt(i)));
				}
			}else{
			for (int i = 0; i <strNumber.length(); i++) {
				digit.add(Integer.parseInt("" + strNumber.charAt(i)));
			}
			}
		}
     //converting from Arraylist to int array;
		this.number = new int[digit.size()];
		for (int i = 0; i < number.length; i++) {
			number[i] = digit.get(i);
		}}
		else{
			this.sign = POSITIVE;
			number = new int[1];
			number [0] =  0;
		}


	    //replace assignments for number and sign with accordance to constructor description

	}
	/**
	 * Create a BigInteger object using another another BigInteger.
	 * This constructor will take another BigInteger as a parameter and will copy all the values into
	 * this BigInteger and assign the sign
	 * @param another: BigInteger object
	 * 	BigInteger b = new BigInteger("1234567890")
	 *
	 * Create a new BigInteger object using b
	 *  BigInteger b2 = new BigInteger(b)
	 */
	public BigInteger(BigInteger another){
		this.sign = another.sign;
		this.number = another.number;
	    //replace assignments for number and sign with accordance to constructor description


	}



	/**
	 * Adds two BigIntegers, and creates a new BigInteger with the result of the addition
	 *
	 * IMPORTANT: Pay attention to the integer sign and length
	 * 		When two positive values are added, the result is positive (2+2=4)
	 *      When one positive and one negative numbers are added,
	 *      		the result can be negative (-4 + 2 = -2) or positive (-2 + 3 = 1)
	 *      When two negative values are added, the result is negative (-2 + -2 = -4)
	 *      When both numbers are zeroes, the result is zero as well
	 *
	 * Two add two big integers, we cad add each digit at the same index
	 * from the two arrays. For example:
	 * a:[1,2,3,4]
	 * b:[5,6,7,8]
	 * a+b is
	 * [6,9,1,2]
	 *
	 * @param b: BigInteger to be added to this BigInteger Object
	 * @return: a new BigInteger object, whose value is the sum of this and b, two BigInteger
	 *          objects
	 */
	public BigInteger add(BigInteger b){

		//TO DO
		return null;
	}



	/**
	 * Subtracts BigInteger b from this BigInteger, and creates a new BigInteger with
	 * the result of the subtraction.
	 * @param b: BigInteger to be subtracted from this BigInteger Object
	 * @return: a new BigInteger object
	 */
	public BigInteger sub(BigInteger b){
		//TODO
		return null;
	}



	/**
	 * Compares this BigInteger with the specified BigInteger.
	 * @param b: BigInteger to which this BigInteger is to be compared.
	 * @return:  -1, 0 or 1 as this BigInteger is numerically less than,
	 * equal to, or greater than b

	 */
	public int compareTo(BigInteger b) {
		if(b.number.length==this.number.length && b.sign==this.sign){
			return 0;
		}else if(this.sign==POSITIVE && b.number.length<this.number.length ){
			return 1;
		}else if(this.sign==POSITIVE && b.sign==NEGATIVE && b.number.length==this.number.length ){
			return 1;
		}else if(this.sign==POSITIVE && b.sign==NEGATIVE &&  b.number.length>this.number.length ){
			return 1;
		}else
		return -1;
	}

	/**
	 * Returns an int array containing this BigInteger.
	 * The array will contain each digit of this BigInteger as an element
	 * @return: an int array containing this BigInteger, ignore the sign
	 */
	public int[] toArray(){
		//TODO
		return this.number;
	}
	/**
	 * Check if the BigInteger is zero
	 * @return true if BigInteger value is zero. False otherwise
	 */
	public boolean isZero(){
		//TODO
		if (this.number.length == 1 && this.number[0] == 0)
			return true;
		return  false;	}
	/**
	 * Returns the length of this BigInteger. length is the number of digits in a BigInteger
	 * @return: length of this integer
	 */
	public int length(){
		//TODO
		return this.number.length;
	}

	/**
	 * Returns the sign of this BigInteger.
	 * @return: sign of this integer
	 */
	public boolean sign(){
		return this.sign;
	}



	/**
	 * returns the the BigInteger in string format. If the number is
	 * negative, return string must start with a "-"
	 * @return BigInteger in a String format
	 */
	public String toString(){
		String str="";
		if(sign){
			for (int i = 0; i <this.number.length; i++) {
				str+=number[i];
			}
		}else{
			str+="-";
			for (int i = 0; i <this.number.length; i++) {
				str+=number[i];
			}
		}
		return str;

	}

}
