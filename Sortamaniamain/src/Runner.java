import java.util.Arrays;
import java.util.Random;

public class Runner {
	
	public static int[] randomInts(int x) {
		int[] arr = new int [x];
		for(int i=0; i <x-1; i++) {
			arr[i] = (int) (Math.random()*x);
		}
		return arr;
	}
	
	public static Comparable[] randomStrings2(int x) {
		String[] arr = new String [x];
		Random r = new Random();
		    for(int i = 0; i < x; i++)
		    {
		        char[] word = new char[5]; 
		        for(int j = 0; j < word.length; j++)
		        {
		            word[j] = (char)('a' + r.nextInt(26));
		        }
		        arr[i] = new String(word);
		    }
		return arr;
	}
	
	//https://stackoverflow.com/questions/4951997/generating-random-words-in-java
	public static String[] randomStrings(int x) {
		String[] arr = new String [x];
		Random r = new Random();
		    for(int i = 0; i < x; i++)
		    {
		        char[] word = new char[5]; 
		        for(int j = 0; j < word.length; j++)
		        {
		            word[j] = (char)('a' + r.nextInt(26));
		        }
		        arr[i] = new String(word);
		    }
		return arr;
	}
	
	public static int[] mostlySortedInts (int x){
		Team9SortCompetition q = new Team9SortCompetition();
		int Sortedindexes =0;
		int Unsortedindexes =0;
		int arrindex = 0; 
		
		int[] Sortedarr = new int [(int) (x*.75)];
		int [] Unsortedarr = new int [x - Sortedarr.length-1];
		int [] arr = new int [x];
		
		for(int i=0; i <Sortedarr.length-1; i++) {
			Sortedarr[i] = (int) (Math.random()*x);
		}
		
		q.quickSort(Sortedarr, 0, Sortedarr.length-1);
		
		for(int a=0; a <Unsortedarr.length-1; a++) {
			Unsortedarr[a] = (int) (Math.random()*x);
		}
		
		
		for(int b=0; b <Sortedarr.length-1; b++) {
			arr[b] = Sortedarr[Sortedindexes];
			Sortedindexes ++;
			arrindex ++;
		}
		
		for(int c= Sortedarr.length; c <arr.length-1; c++) {
			arr[c] = Unsortedarr[Unsortedindexes];
			Unsortedindexes++;
			arrindex++;
		}
		
		
		return arr;
	}
	
	public static int [][] randMulti(int x){
		int[][] arr1 =  new int [x][x];
		for(int i=0; i < arr1.length; i++) {
			 for(int j=0;j<arr1[0].length;j++) {
				 arr1[i][j] = (int) (Math.random()*x);
			 }
		}
		return arr1;
	}
	
	
	public static void main(String[] args) {
		
		int [] randArr = randomInts(9);
		String [] randStrings = randomStrings(9);
		int [] randArr2 = mostlySortedInts(9);
		int [][] randArr3 = randMulti(5);
		String [] randStrings2 = {"abbcd", "bchdasjs", "iorererr", "yzjjzz", "xirire", "mcmmcncn"};
		
		
		
		for(int[] a : randArr3) {
		for (int b : a) {
		System.out.print(b + "\t");
		}
		 System.out.println("\n");
		}
		
		System.out.println("\n");
		Team9SortCompetition x = new Team9SortCompetition();
		


		long start = System.nanoTime();
		long end = System.nanoTime();
		long time = end - start;
		x.challengeOne(randArr);
		System.out.println("Challenge one took: " + time + " nanoseconds");
		System.out.println(Arrays.toString(randArr));
		System.out.println(x.challengeOne(randArr));
	
		
		start = System.nanoTime();
		end = System.nanoTime();
		time = end - start;
		x.challengeTwo(randStrings, "abcde");
		System.out.println("Challenge two took: " + time + " nanoseconds");
		System.out.println(x.challengeTwo(randStrings, "abcde"));
		
		start = System.nanoTime();
		end = System.nanoTime();
		time = end - start;
		x.challengeThree(randArr2);
		System.out.println("Challenge three took: " + time + " nanoseconds");
		System.out.println(Arrays.toString(randArr2));
		System.out.println(x.challengeThree(randArr2));
		
		start = System.nanoTime();
		end = System.nanoTime();
		time = end - start;
		x.challengeFour(randArr3);
		System.out.println("Challenge four took: " + time + " nanoseconds");
		for(int[] q : randArr3) {
			for (int w : q) {
			System.out.print(w + "\t");
			}
			 System.out.println("\n");
			}
			
			System.out.println("\n");	
		System.out.println(x.challengeFour(randArr3));
	
		
		start = System.nanoTime();
		end = System.nanoTime();
		time = end - start;
		x.challengeFive(randStrings2, "yirire");
		System.out.println("Challenge five took: " + time + " nanoseconds");
		System.out.println(Arrays.toString(randStrings2));
		System.out.println(x.challengeFive(randStrings2, "yzjjzz"));
}
}