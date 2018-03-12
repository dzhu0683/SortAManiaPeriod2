import java.util.Arrays;

/*
 * Team 9
 * Period 2 AP Computer Science 
 * 3/7/18
 * Group members: Dustin, Evan, Darren, Kewu 
 *
 */

public class Team9SortCompetition extends SortCompetition {

	/*
	 * Challenge one
	 * array is sorted and median is returned
	 * 
	 */
	public int challengeOne(int[] arr) {
		int median;
		insertionSort(arr);
		if (arr.length % 2 == 0) {
		    median = (arr[(arr.length/2)] + (arr[(arr.length/2) - 1]))/2;
		}
		else {
		    median = arr[(arr.length/2)];
		}
		return median;
	}

	@Override
	/*
	 * Challenge two
	 * array is sorted and the query is searched for
	 * if an index equals the query, then it returns the index position
	 * else -1 is returned
	 */
	public int challengeTwo(String[] arr, String query) {
		bubbleSort(arr);
		for(int i =0; i < arr.length; i++) {
			if(arr[i].equals(query)) {
				return i;
			}
		}
		return  -1;
	}
	
	/*Challenge three
	 * same as challenge one
	 * 
	 */
	@Override
	public int challengeThree(int[] arr) {
		int median = 0;
		insertionSort(arr);
		if (arr.length % 2 == 0) {
		    median = (arr[(arr.length/2)] + (arr[arr.length/2 - 1]))/2;
		}
		else {
		    median = arr[(arr.length/2)];
		}
		return median;
	}

	@Override
	/* Challenge four
	 * returns median of median array 
	 * new array is created to store the medians of the arrays, which are sorted through challenge one
	 * then that new array is sorted
	 */
	public int challengeFour(int[][] arr) {
		int [] median = new int [arr.length];
		int med;
		for(int i = 0; i < arr.length; i++) 
		{
			median[i] = challengeOne(arr[i]);
		}
		
		med = challengeOne(median);
		return med;
	}
	
	
	//merge sort doesnt work for comparable
	@Override
	/*
	 * Challenge five
	 * same as challenge two but with comparable
	 * 
	 */
	public int challengeFive(Comparable[] arr, Comparable query) {
		selectionSort(arr);
		for(int i =0; i < arr.length; i++) {
			if(arr[i].equals(query)) {
				return i;
			}
		}
		return  -1;
	}

	

	@Override
	public String greeting() {
		
		return "Hello we are Team 9.";
	}
	
	
	
	
	
	// helper/sorting methods below (some are not used)
	
	//http://www.cs.uml.edu/~pkien/sorting/
	
	public static void insertionSort(int [] list1) {
		for(int i = 0; i < list1.length-1; i++) { //outer loop looking for an array smaller than the initial array
		//i is the value being sorted up the array
			for(int j= i+1 ; j  > 0 ; j--) { //j is the right value , j-1 is i
				//j counts down
				//j cant be less than or equal to zero as negative numbers return error
				if(list1[j] < list1[j-1]) { //if right value is less than value being sorted, they swap
					swap(list1,  j, j-1);
					}
				}
			}
		}
	
	public static int medfind(int [] arr)
	{
		int ans;
		if(arr.length%2==0)
		{
			ans = ((arr[(arr.length/2) - 1] + arr[(arr.length/2)])/2) ; 
		}
		else
			ans = arr[(arr.length/2)];
		return ans;
	}
	
	public static void swap(int []arr, int index1, int index2) {
		int temp = arr[index1];
		arr[index1] = arr[index2];
		arr[index2] = temp;
	}
	
	public void quickSort(int[] list1, int front, int back)
	{
		if(back>front) {
			int pivotPos = partition(list1, front, back);
			quickSort(list1, front, pivotPos-1); //values before pivot
			quickSort(list1, pivotPos, back); //values after pivot
		}
	}
	


	public static void bubbleSort(Comparable [] list1) {
		boolean swap = true;
		while(swap) { //while loop is used as there is a limited number of loops before everything gets sorted
			swap=false;
			for(int i = 0; i < list1.length-1; i++) { //loops through the loop; first value becomes current value i
				if(list1[i].compareTo(list1[i+1])>0) { // if the value to the right of a value is less than the current value
						bubbleSwap(list1, i, i+1);     // the values swap
						swap = true; //swap is true, so cycle repeats until everything is sorted
					}
				}
			}
		}
	
	
	public static void bubbleSort(String [] list1) {
		boolean swap = true;
		while(swap) { //while loop is used as there is a limited number of loops before everything gets sorted
			swap=false;
			for(int i = 0; i < list1.length-1; i++) { //loops through the loop; first value becomes current value i
				if(list1[i].compareTo(list1[i+1])>0) { // if the value to the right of a value is less than the current value
						bubbleSwap(list1, i, i+1);     // the values swap
						swap = true; //swap is true, so cycle repeats until everything is sorted
					}
				}
			}
		}
	
	public static String[] mergeSort(String[] list) 
	{
		//Base case
		if(list.length == 1)
			return list;
		//Recursive step
		
		//two arrays left and right since merge sort is splitting up arrays by half then combining it back together sorted
		//left is 0 to to 1/2
		//right is 1/2 to end
		String[] left = Arrays.copyOfRange(list, 0, list.length/2);
		String[] right = Arrays.copyOfRange(list, list.length/2 , list.length); 
		return(merge(mergeSort(left), mergeSort(right)));
		
	}
	




	public static String[] merge(String[] list1 , String[] list2) {

			String [] combinedArray = new String[list1.length + list2.length]; //new array must be length of both arrays combined
			int x=0; //list1 indexes
			int y=0; //list2 indexes
			int z=0; //new array (combinedArray)
			boolean a = false;
			  while (x < list1.length && y < list2.length) //both arrays must be less than their intended length (any longer with break the code)
		        {
		            if (list1[x].compareTo(list2[y]) <= 0) //compares the values in the 2 arrays and see which is smaller
		            {
		               combinedArray[z] = list1[x]; //since the value in list1 is smaller in this case, list1[x] becomes part of the sorted array before list2[y]
		                x++; //x will count up as the values are placed into the merged array
		                z++; //z is the merged array index so it counts up as it fills in its slots
		            }
		            else  
		            {
		            	combinedArray[z] = list2[y]; //since list2[y] is smaller, it is placed before list1[x]
		                y++; //y counts up as values are placed into merged array
		                z++;
		            }
		            
		        	}
			  		
			  	
			  		//loops through the arrays to find values
			  		while (x < list1.length)
			  		{
			  			combinedArray[z] = list1[x];
			  			x++;
			  			z++;
			  		}

			  		while (y < list2.length)
			  		{
			  			combinedArray[z] = list2[y];
			  			y++; 
			  			z++;
			  		}
			  	

			    return combinedArray; //returns the merged sorted array 
		}
	
	public static void selectionSort(Comparable [] arr) {
		int x =0;
		Object temp;
		for (int i=0; i < arr.length-1; i++) {
			x =i;
			for(int j = i+1; j < arr.length; j++) {
				if(arr[j].compareTo(arr[x])<0)
					x = j;
			}
			if(i!=x) {
				swap(arr, x, i);
			}

		}
		
		
	}
	
	 private static void swap(Comparable[] list1, int index1, int index2) {
		 String temp = (String) list1[index1];
			list1[index1] = list1[index2];
			list1[index2] = temp;
		
	}

	public static void countingSort(int[] arr1)
	    {
	        int n = arr1.length;
	
	       int  output[] = new int[n];
	 
	        int count[] = new int[256];
	        for (int i=0; i<256; ++i)
	            count[i] = 0;
	 
	        for (int i=0; i<n; ++i)
	            ++count[arr1[i]];
	 
	        for (int i=1; i<=255; ++i)
	            count[i] += count[i-1];
	
	        for (int i = 0; i<n; ++i)
	        {
	            output[count[arr1[i]]-1] =   arr1[i];
	            --count[arr1[i]];
	        }
	 
	        for (int i = 0; i<n; ++i)
	            arr1[i] = output[i];
	    }
	
	
	public static void bubbleSwap(Comparable[] list1, int index1, int index2) {
		String temp = (String) list1[index1];
		list1[index1] = list1[index2];
		list1[index2] = temp;
	}
	
	public static void bubbleSwap(String[] list1, int index1, int index2) {
		String temp = (String) list1[index1];
		list1[index1] = list1[index2];
		list1[index2] = temp;
	}
	
	
	public static int partition(int[] list1, int front, int back) 
	{
		int pivot = list1[front];
		while (front < back) {
			while (list1[front] < pivot) {
				//since the value is less than the pivot then nothing happens and it counts up
				//until a grater value is found
				front++;
			}
			while (list1[back] > pivot) {
				//if the value is greater than the pivot nothing happens and it counts down
				//until smaller value is found
				back--;
			}
			if(front <= back) {
			//value swaps as conditions are met
			swap(list1, front, back);
			
			//everything continues on
			front++;
			back--;
			}
		}
		return front; //pivot index is returned
    }
}
