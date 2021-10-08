import java.util.Arrays;
import java.util.Collections;
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
		//shift right if positive
		if(n > 0){
			for(int i = 0; i < n; i++){      
	            int last = arr[arr.length-1];    
	            for(int j = arr.length-1; j > 0; j--){    
	                arr[j] = arr[j-1];    
	            }    
	            arr[0] = last;
	        }
			return arr;
		}
		//shift left if negative
		else {
			int absVal = Math.abs(n);
			//This outer for loop helps repeat the number of shifts over and over again
			for(int i = 0; i < absVal; i++){  
				//Storing the First element
		         int first = arr[0];
		         //This inner loop shifts only once
		         for(int j = 0; j < arr.length-1; j++){  
		        	arr[j] = arr[j+1];  
		            }
		            arr[arr.length - 1] = first;  
		        }
			 return arr;
		}
	}
	
	public int[] reverse() {
		
		for(int i = 0; i < arr.length / 2; i++) {
		    int temp = arr[i];
		    arr[i] = arr[arr.length - i - 1];
		    arr[arr.length - i - 1] = temp;
		}
		return arr;
	}
	
	
	public static void main(String[] args) {
		int[] arr = {10, 20, 30, 40, 50};
		BoxMover m = new BoxMover(arr);
		m.reverse();
		System.out.println("Reverse: " + Arrays.toString(arr));
		m.shift(-2);
		System.out.println("Positive shift right: " + Arrays.toString(arr));
		m.shift(-1);
		System.out.println("Negative shift left: " + Arrays.toString(arr));
	}
	
}
