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
    public static boolean isReversibleSum(int num) {
        int sumPrime = 0;
        for(int i = 2; i < num; i++){//find factors
            if(isPrime(i)&&(num%i==0)){//specify prime factors
                String parser = String.valueOf(i);
                int tempSum = 0;
                for(int j = 0; j < parser.length();j++){//sum digits
                    tempSum+=Integer.parseInt(parser.substring(j,j+1));
                }//sum digits
                if(i*i==num){//case that factors are the same number
                    tempSum*=2;//double the sum of digits for the given number    
                }
                sumPrime+=tempSum;                
            }
        }//this works as intended        
        int sumDigits = 0;
        String parser = Integer.toString(num);//turns the number into a string
        for(int i = 0; i < parser.length(); i++){//checks every spot in the string
            sumDigits+=Integer.parseInt(parser.substring(i,i+1));//takes each digit from the String and adds to sum
        }//this works as intended
        String backwards = "";
        for(int i = parser.length()-1; i >= 0; i--){
            backwards += parser.substring(i,i+1);//turns out i forgot to put a plus here >:(
        }
        int back = Integer.parseInt(backwards);//turns back into int for comparison 
        return (num == back) && (sumPrime == sumDigits);	
    }
    /* 
     This method returns true if the array is Incremental false otherwise. 
     An array is called Incremental if it has the following properties:
     - The value of the first element equals the sum of the next two elements, which is equals to the next three elements, equals to the sum of the next four elements, etc.
     - It has a size of x*(x+1)/2 for some positive integer x .
     For example {6, 2, 4, 2, 2, 2, 1, 5, 0, 0} isIncremental, whereas {2, 1, 2, 3, 5, 6} is not
    */
    public static  boolean isIncremental(int[] array) {//TODO
        int indexCheck = 2;//intial value
        int index = 1;
        int sum = 0;
        int value = array[0];
        int target = 0;	
        for(int i = 1; i < array.length; i++){
            sum+=array[i];
           // System.out.println("array[i]: "+array[i]+" index: "+index+" indexCheck: "+indexCheck + " sum: "+sum); //DEBUG
            if(index == indexCheck){
                target = index;//saves for comparison at the end
                index = 0;     //resets index
                indexCheck++;  //moves the next amount of indecies to move
                if(sum!=value) return false;
                sum = 0;       //resets sum for given run
            }
            index++; //increment AFTER checking 
        }
        return target*(target+1)/2 == array.length;
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
    public static void descendingSort (int[] data){
        int temp = 0;
        int[] tempData = new int[data.length] 
        for(int i = 0; i <data.length;i++){
            tempData[i] = data[i];
        }//copies array into temp array
        for(int i=0; i < data.length; i++){
            temp = data[i];                   //saves number to be moved
            tempIndex = findMax(tempData);
            data[i] = data[tempIndex];//sets maximum to that spot
            data[tempIndex] = temp;   //moves old number to where max was
            tempData[tempIndex] = 0;  //destroy max to make my findMax method work
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
                if(i!=j && array[i]+array[j]==10){//if not comparing same number and their sum is 10
                    sumPairs++;
                    array[i] = -1;//this will lock the pair from being counted twice
                    array[j] = -1;//and being considered from other pairs
                    //normally you would use a copy as to not destroy the original data but that wasn't required for this.
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
        int[] arr = new int[n*n];//declare array of appropriate size
        int block = n-1;         //how many digits to block
        int maxBlock = block;    //how many digits the block will block for a given count cycle
        int count = n;           //will be assigned to array
        for(int i = 0; i < arr.length; i++){
            if(block != 0){     //if block is still enabled
                arr[i] = 0;     //make spot = 0
                block--;        //decrement the block
            }else{
                arr[i] = count; //block disabled assign appropriate value
            }	
            count--;            //decrement count regardless of block
            if(count == 0){     //if count is zero after decrement
                maxBlock--;     //new cycle decrement max block
                block = maxBlock;//set block to appropriate size
                count = n;	    //reset count
            }
        }
        return arr;
    }
    /* 
    This method returns true if the array is Summative, false otherwise.
    An array is called Summative if the nth element (n >0) of the array is the sum of the first n elements. 
    For example, {2, 2, 4, 8, 16, 32, 64} is Summative, whereas {1, 1, 2, 4, 9, 17} is not.
    */

    public static boolean isSummative(int array[]) { 
        int sum = array[0];
        for(int i=1; i < array.length; i++){
            if(array[i]!=sum) return false;
            sum+=array[i];
        }
        return true;
    }
    /*
    public static void main(String[] debug){
        int[] arr = {1, 1, 2, 4, 9, 17};
        System.out.println(isSummative(arr));
        //System.out.println("length: "+arr.length);
    }
    */
}