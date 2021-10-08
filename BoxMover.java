import java.util.Arrays;
/**
 * Implement a constructor that initializes the private reference variable pointing to an array

   You have to implement shift that would move elements of the array to the left if given a negative number, or to the right, if given a positive number

   a = {1, 2, 3}, if we shift( -1) we get b = {2, 3, 1}
   a = {1, 2, 3}, if we shift( 1) we get b = {3, 1, 2}
   if shift number is bigger than the size of the array, it should still work by shifting in a circular manner
   
   Don't look into the case where n > Integer.MAX_VALUE or n < Integer.MIN_VALUE
   
   You have to implement reverse that would reverse the order of the elements of the array.

   a = {1, 2, 3}, if we reverse() we get b = {3, 2, 1}
 * 
 *
 */

public class BoxMover {
	
	private int[] arr;
	
	public BoxMover(int[] arr) {
		this.arr = arr;
	}
	
	public int[] shift(int n) {
		
		int[] temp = new int[arr.length];
		//right shift positive
		if(n > 0) {
			for(int i = 0; i < arr.length; i++) {
				int newPosition = (i + n) % arr.length;
				temp[newPosition] = arr[i];
			}
			return temp;
		}
		//left shift negative
		else
			for(int i = arr.length-1; i > 0; i--) {
				int leftShift = Math.abs(n);
				int newPosition = i + (arr.length - leftShift) % arr.length;
				temp[newPosition] = arr[i];
			}
		return temp;
	}
	
	public int[] reverse() {
		try {
		for(int i = 0; i < arr.length / 2; i++) {
		    int temp = arr[i];
		    arr[i] = arr[arr.length - i - 1];
		    arr[arr.length - i - 1] = temp;
		}
		}
		catch(Exception e) {
			
		}
		return arr;
	}
	
	
	public static void main(String[] args) {
		int[] arr = {10, 20, 30, 40, 50};
		BoxMover m = new BoxMover(arr);
		m.reverse();
		System.out.println("Reverse: " + Arrays.toString(arr));
		m.shift(5);
		System.out.println("Positive shift right: " + Arrays.toString(arr));
		m.shift(-1);
		System.out.println("Negative shift left: " + Arrays.toString(arr));
	}
	
}
