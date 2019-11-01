//Grace Shang
// 10 October 2018
// Period 4
public class ArrayLab3 {
	public static void main () {
		int[]a1 = {5, 10, 15, 20, 25, 30, 35, 40};
		int[]a2 = {7, 14, 21, 28, 35, 42, 49, 56};
		int[] sumArr = sum(a1, a2);
		int appendNum = 200;
		int[] appendArr = append(a1, appendNum);
		int removeIdx = 5;
		int[] removeArr = remove(a2, removeIdx);
		int sumOfEvens = sumEven(appendArr);
		rotateRight(a1);
	
		
	public static int[] sum(int[] arr1, int[] arr2) {
//		new array which each element is the sum of the corresponding elements of the two arrays?
		int[] combinedArr = new int [arr1.length];
		for(int i = 0; i < arr1.length; i++) {
			combinedArr[i] = arr1[i] + arr2[2];
		}
		return combinedArr;
	}
		
	public static int[] append(int[] arr, int num) {
//		returns an array of integers of length n+1 that consists of the elements of arr with num appended to the end.
//		extends length by one and the last one is the sum of all the previous elements?	
		int n = arr.length; //length is set to n value
		int[] newArr = new int[arr.length +1];
		for(int i = 0; i <= n; i++) {
		newArr[i] = arr[i];
		}
		newArr[n] = num;
		return newArr;
	}

	public static int[] remove(int[] arr, int idx) {
//		returns an array of integers consisting of all of the elements of arr except for the element at index idx 
//		(thus, the returned array has a length of arr.length – 1)	
		int[] secondArr = new int[arr.length -1];
		for(int i = 0; i < secondArr.length; i++)
			
		}
		
	}
}
