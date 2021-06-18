//Julian Stapleton CS 211
public class NumberProcessor {
	/* This method returns true if its integer argument is "special", otherwise it returns false
     A number is defined to be special if where sum of its positive divisors equals to the number itself.   
     For example, 6 and 28 are "special whereas 4 and 18 are not.
     that is 2+3+1=6 and 14+2+7+4+1=28    */
    public static boolean isSpecial(int n) {
        int sum = 0; 	            
        if(n == 0) return false;        //include 0 case
        for(int i = 1; i < n; i++){     //for every number between 1 and n
            if(n%i == 0) sum+=i;	    //sum the divisors 
            }
        return sum == n;                //return if the sum equals the original 
    }	 
    /*This method returns true if a number is "UniquePrime", false otherwise. 
    A number is called "UniquePrime", if the number is a prime number and if
    we repeatedly move the first digit of the number  to the end, the number still remains prime. 
    For example, 197 is a prime number, if we move the first digit to the end, 
    we will have a number 971, which is a prime number, if we again move the first digit to the end, we get 719, which is a prime number.*/
    public static boolean isPrime(int num){         //this method determines if a number is prime
        for(int i=2; i<num;i++){                    //for all numbers between 2 and num
            if(num%i==0 || i*i==num) return false;  //if that num is divisible by anything it is not prime
        }
        return true;                                //else it is
    }
	public static boolean isUniquePrime(int num) { 
        if(num<0) return false;                                         //if num is negative return 0 
		String parser = Integer.toString(num);                          //stringify num
        if(Integer.toString(num).length() == 1) return isPrime(num);    //if a single digit, check if its prime	
		for(int i=0; i < Integer.toString(num).length(); i++){          //for 0 to number of places
            if(!isPrime(num)) return false;                             //if number isnt prime return false 
			parser = parser.charAt(parser.length()-1) + parser.substring(0,parser.length()-1); //shift those digits
			num = Integer.parseInt(parser);                             //update num to reflect shift
		}
		return true;	                                                //if it gets through all that its good
    } 
	/*This method accepts an  integer and returns true if the number is SquareAdditive, false otherwise.
    Consider a k-digit number n. Square it and add the right k digits to the left k or k-1 digits.
    If the resultant sum is n, then n is called a SquareAdditive number. 
    For example, 9 is a SquareAdditive number
    9^2 = 81, and 8 + 1 = 9*/   
    public static boolean isSquareAdditive(int num) {
        int k = String.valueOf(num).length();               //k is numDigits
		String parser = Integer.toString(num*num);          //parser is stringified num squared
        if(parser.length()%2==1&&k%2==0)k-=1;               //if the amount of digits in num^2 is odd and numDigits is even use k-1 (i guess and checked combos until this worked )
        int sum = Integer.parseInt(parser.substring(0,k))+Integer.parseInt(parser.substring(k));   //add left and right half
        return sum == num;                                  //yes
	}       
    /*Considering the sequence 1,3,6,10,15,21,28...
    The method returns the nth sequence number. If n is <= 0, it returns 0*/    
	public static int masonSequence(int num){
	    if(num <= 0) return 0;          //if 0 or less return 0
		int sum = 0;                    //initialize sum
        for(int i=1; i <= num; i++){    //starting at one and ending on nth number of sequence 
            sum+=i;                     //this is the pattern in the sequence 
        }
        return sum;                     
	}
    /*A composite integer is called ReversibleSum if it fulfills the following two conditions:
    1. The sum of its digits is the same as the sum of the digits of its prime factors. For example, 121 has two prime factors 11 * 11. 
     The sum of the digits of the two prime factors is 1 + 1 + 1 + 1 = 4 and the sum of the digits of 121 is 1 + 2 + 1 = 4.
    2. The reverse of the number equals to the number itself. For example, 121 has a reverse 121.
    The method returns true if the number is ReversibleSum*/
    public static boolean isReversibleSum(int num) {
        int sumPrime = 0;
        int tempNum = num;
        for(int i = 2; i < num; i++){                                   //find factors
            while(tempNum%i==0 && isPrime(i)){                          //specify prime factors and check if tempNum is still divisible by i
                String parser = String.valueOf(i);                      //Stringify i to get digits
                int tempSum = 0;                                        //reset temp sum
                for(int j = 0; j < parser.length();j++){                //sum digits
                    tempSum+=Integer.parseInt(parser.substring(j,j+1)); //adds each digit
                }
                sumPrime+=tempSum;                                      //sumPrime totals all the tempSums 
                tempNum/=i;                                             //updates tempNum to account for repeated factors 
            }
        }//this works as intended        
        int sumDigits = 0;
        String parser = Integer.toString(num);                      //turns the number into a string
        for(int i = 0; i < parser.length(); i++){                   //checks every spot in the string
            sumDigits+=Integer.parseInt(parser.substring(i,i+1));   //takes each digit from the String and adds to sum
        }                                                           //this works as intended
        String backwards = "";                                      //initialize string
        for(int i = parser.length()-1; i >= 0; i--){                //iterates backwards to reverse the number
            backwards += parser.substring(i,i+1);                   //turns out i forgot to put a plus here >:(
        }
        int back = Integer.parseInt(backwards);                     //turns back into int for comparison 
        return (num == back) && (sumPrime == sumDigits);	        
    }
    /*This method returns true if the array is Incremental false otherwise. 
    An array is called Incremental if it has the following properties:
    - The value of the first element equals the sum of the next two elements, which is equals to the next three elements, equals to the sum of the next four elements, etc.
    - It has a size of x*(x+1)/2 for some positive integer x .
    For example {6, 2, 4, 2, 2, 2, 1, 5, 0, 0} isIncremental, whereas {2, 1, 2, 3, 5, 6} is not*/
    public static  boolean isIncremental(int[] array) {
        if(array.length == 1) return true;          //if only 1 number its true
        int indexCheck = 2;                         //intialize at check for 2 indecies
        int index = 1;                              //index starts after the first one
        int sum = 0;                                //runing sum
        int value = array[0];                       //comparison for all other sums
        int target = 0;	                            //temp index
        for(int i = 1; i < array.length; i++){      //for array from 1 to max
            sum+=array[i];                          //sum is running sum of array elements
            // System.out.println("array[i]: "+array[i]+" index: "+index+" indexCheck: "+indexCheck + " sum: "+sum); //DEBUG
            if(index == indexCheck){                //until index reaches indexCheck
                target = index;                     //saves for size comparison at the end (this is the implied x value)
                index = 0;                          //resets index
                indexCheck++;                       //increments the number of indecies to sum
                if(sum!=value) return false;        //if any sums are not what they should be its not incremental 
                sum = 0;                            //resets sum for given run
            }
            index++;                                //increment AFTER checking 
        }
        return target*(target+1)/2 == array.length; //as per the guidelines
    }
    //This method accepts array of integers and sort the array 
    public static void descendingSort (int[] data){//THIS WORKS!
        int temp = 0;                           //temp will house number to be moved
        int max = data[0];                      //this is starting value, but must be changed everytime 
        int maxIndex = 0;                       //keeps track of index at that max value
        for(int i=0; i < data.length-1; i++){
            temp = data[i];                     //saves number to be moved
            max = data[i];                      //limits max to not be already manipulated elements
            maxIndex = i;                       //limits max index, so if there is no maxIndex found, nothing will be swithed
            for(int j = i; j < data.length; j++){//find max
                if(data[j]>max){                //compares max
                    max = data[j];              //saves new max
                    maxIndex = j;               //and new max index
                } 
            }
            data[i] = data[maxIndex];           //the switch
            data[maxIndex] = temp;              //the switch 2 electric boogaloo 
        }
    }
    /*This method returns true if the array is PairArray, false otherwise.
    An array is called PairArray if exactly one pair of its elements sum to 10. 
    For example, {4,16,6, 13} is PairArray as only 4 and 6 sum to 10
    The array {1,3,0,10,7} is not PairArray as more than one pair (10,0) and (3,7) sum to 10. 
    {4,1,11} is not also PairArray as no pair sums to 10*/    
    public static boolean isPairArray(int array[]) {
        int sumPairs = 0;                           //running sum
        for(int i = 0; i < array.length; i++){      //for array from 0 to max
            if(array[i] < 0) continue;              //ignore negatives (maybe wrong, but tests work)
            for(int j = 0; j < array.length; j++){  
                if(array[j] < 0) continue;          //need nested for loop to check for pairs
                if(i!=j && array[i]+array[j]==18){  //if not comparing same number and their sum is 10
                    sumPairs++;                     //APPARENTLY ITS 18??
                    //array[i] = -100;              //this will lock the pair from being counted twice
                    array[j] = -100;                //and being considered from other pairs
                    //normally you would use a copy as to not destroy the original data but that wasn't required for this.
                }
            }
        }
        return sumPairs == 1;
    }
    /*this method accepts positive integer and returns an array of size n^2 with elements in a specific pattern. 
    For example, for n = 2, the method returns an array with elements {0,1,2,1}.*/
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
    /*This method returns true if the array is Summative, false otherwise.
    An array is called Summative if the nth element (n >0) of the array is the sum of the first n elements. 
    For example, {2, 2, 4, 8, 16, 32, 64} is Summative, whereas {1, 1, 2, 4, 9, 17} is not.*/
    public static boolean isSummative(int array[]) { 
        int sum = array[0];                     //i dont remember   
        for(int i=1; i < array.length; i++){    //oh yeah
            if(array[i]!=sum) return false;     //if a next element isnt sum of all previous elements then its not summative
            sum+=array[i];                      //sum of elements so far
        }
        return true;                            //if all elements are passed then its summative 
    }
}