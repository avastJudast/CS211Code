//Julian Stapleton CS 211
public class NumberProcessor {
	/*
     This method returns true if its integer argument is "special", otherwise it returns false
     A number is defined to be special if where sum of its positive divisors equals to the number itself.   
     For example, 6 and 28 are "special whereas 4 and 18 are not.
     that is 2+3+1=6 and 14+2+7+4+1=28
    */
    public static boolean isSpecial(int n) {
        int sum = 0; 	
        for(int i = 1; i < n; i++){
            if(n%i == 0) sum+=i;	
            }
        return sum == n;
    }	 
    
    /*  
    This method returns true if a number is "UniquePrime", false otherwise. 
    A number is called "UniquePrime", if the number is a prime number and if
    we repeatedly move the first digit of the number  to the end, the number still remains prime. 
    For example, 197 is a prime number, if we move the first digit to the end, 
    we will have a number 971, which is a prime number, if we again move the first digit to the end, we get 719, which is a prime number.
    */
    
    public static boolean isPrime(int num){
        for(int i=2; i<num;i++){
            if(num%i==0) return false;
        }
        return true;
    }
	public static boolean isUniquePrime(int num) {
		String parser = Integer.toString(num);	
		for(int i=1; i <= Math.floor(Math.log10(num)); i++){//number of places
			if(!isPrime(num)) return false;
			parser = parser.charAt(parser.length()-1) + parser.substring(1,parser.length()-1);
			num = Integer.parseInt(parser);
		}
		return true;	
    } 
	/* 
    This method accepts an  integer and returns true if the number is SquareAdditive, false otherwise.
    Consider a k-digit number n. Square it and add the right k digits to the left k or k-1 digits.
    If the resultant sum is n, then n is called a SquareAdditive number. 
    For example, 9 is a SquareAdditive number
    9^2 = 81, and 8 + 1 = 9 
    */   
	public static boolean isSquareAdditive(int num) {
        int k = String.valueOf(num).length();
		String parser = Integer.toString(num*num);
		int sum = Integer.parseInt(parser.substring(0,k))+Integer.parseInt(parser.substring(parser.length()-k));
        return sum == num;  
	}
    /* 
    Considering the sequence 
    1,3,6,10,15,21,28...
    The method returns the nth sequence number. If n is <= 0, it returns 0
    */    
	public static int masonSequence(int num){
	    if(num <= 0) return 0;
		int sum = 0;
        for(int i=1; i <= num; i++){
            sum+=i;
        }
        return sum;
	}
    /*
    A composite integer is called ReversibleSum if it fulfills the following two conditions:
    1. The sum of its digits is the same as the sum of the digits of its prime factors. For example, 121 has two prime factors 11 * 11. 
     The sum of the digits of the two prime factors is 1 + 1 + 1 + 1 = 4 and the sum of the digits of 121 is 1 + 2 + 1 = 4.
    2. The reverse of the number equals to the number itself. For example, 121 has a reverse 121.
    The method returns true if the number is ReversibleSum
    */
    public static void main(String[] debug){
        System.out.println(isReversibleSum(121));
    }
    public static boolean isReversibleSum(int num) {//TODO
        int sumPrime = 0;
        for(int i = 2; i < num; i++){
            if(isPrime(i)) sumPrime+=i;
        }
        int sumDigits = 0;
        String parser = Integer.toString(num);
        for(int i = 0; i < parser.length()-1; i++){
            sumDigits+=Integer.parseInt(parser.substring(i,i+1));
        }
        String backwards = "";
        for(int i = parser.length()-1; i >= 0; i--){
            backwards = parser.substring(i,i+1);
        }
        int back = Integer.parseInt(backwards);
        return (num == back) && (sumPrime == sumDigits);	
    }
    /* 
     This method returns true if the array is Incremental false otherwise. 
     An array is called Incremental if it has the following properties:
     - The value of the first element equals the sum of the next two elements, which is equals to the next three elements, equals to the sum of the next four elements, etc.
     - It has a size of x*(x+1)/2 for some positive integer x .
     For example {6, 2, 4, 2, 2, 2, 1, 5, 0, 0} isIncremental, whereas {2, 1, 2, 3, 5, 6} is not
    */
    public static  boolean isIncremental(int[] array) {
        int indexSum = 0;
        int indexCheck = 2;
        int sum = 0;
        int checker = array[0];	
        for(int i = 1; i < array.length; i++){
            sum+=array[i];
            indexSum+=1;
            if(indexSum == indexCheck){
                indexSum = 0;
                indexCheck++;
                if(sum!=checker) return false;
                sum = 0;
            }
        }
        return indexSum*(indexSum+1)/2 == array.length;
    }
    //This method accepts array of integers and sort the array 
    public static int findMax(int[] data){
        int maximum = data[0];
        int index = 0;
        for(int i=0; i < data.length; i++){
            if(data[i] > maximum){
            maximum = data[i];
            index = i;	
            }
        }
        return index;
    }
    public static void descendingSort (int[] data){//TODO
        int temp = 0;
        for(int i=0; i < data.length; i++){
            temp = data[i];
            data[i] = data[findMax(data)];
            data[findMax(data)] = temp;	
        }
    }
    /* 
     This method returns true if the array is PairArray, false otherwise.
     An array is called PairArray if exactly one pair of its elements sum to 10. 
     For example, {4,16,6, 13} is PairArray as only 4 and 6 sum to 10
     The array {1,3,0,10,7} is not PairArray as more than one pair (10,0) and (3,7) sum to 10. 
     {4,1,11} is not also PairArray as no pair sums to 10
    */
    public static boolean isPairArray(int array[]) {
        int sumPairs = 0;
        for(int i = 0; i < array.length; i++){
            if(array[i] < 0) continue;
            for(int j = 0; j < array.length; j++){
                if(array[j] < 0) continue;
                if(i!=j && array[i]+array[j]==10){
                    sumPairs++;
                    array[i] = -1;//this will lock the pair from being counted twice
                    array[j] = -1;//and being considered from other pairs
                }
            }
        }
        return sumPairs == 1;
    }
    /*   
    this method accepts positive integer and returns an array of size n^2 with elements in a specific pattern. 
    For example, for n = 2, the method returns an array with elements {0,1,2,1}.
    input 	output array
    1 	{1}
    2 	{0, 1, 2, 1}
    3 	{0,0,1,0,2,1,3,2,1}
    4 	{0,0,0,1,0,0,2,1,0,3,2,1,4,3,2,1}
    */
    public static int [ ] arrayPattern(int n) {
        int[] arr = new int[n*n];
        int block = n-1;
        int count = n;
        for(int i = 0; i < arr.length; i++){
            if(block != 0){
                arr[i] = 0;
            }else{
                arr[i] = count;
            }	
            if((i+1)%n == 0){
                block--;
                count = n;	
            }
            count--;
        }
        return arr;
    }
    /* 
    This method returns true if the array is Summative, false otherwise.
    An array is called Summative if the nth element (n >0) of the array is the sum of the first n elements. 
    For example, {2, 2, 4, 8, 16, 32, 64} is Summative, whereas {1, 1, 2, 4, 9, 17} is not.
    */
    public static boolean isSummative(int array[]) { 
            sum = array[0];
        for(int i=1; i < array.length; i++){
            if(array[i]!=sum) return false;
            sum+=array[i];
        }
        return true;
    }
}
