package com.epam.task3;
/*PROBLEM STATEMENT
 * A young mischievous boy Harsh, got into a trouble when his mechanical workshop teacher told him to cut Iron rods. The rod cutting algorithm is as follows:

Step 1. If the rod can be divided into two equal parts, cut it and choose any one of them.

Step 2. Else cut the rod into two parts having non-zero integral lengths such that the difference between the lengths of the two pieces is minimized, and then choose the piece having smaller length.

Step 3. Repeat the above algorithm with the currently chosen piece. If the length of the currently chosen piece becomes 1 , stop the algorithm.

There can be special rods which require Step 2 in every step of its cutting. Harsh want to find out the number of such special rods. Help Harsh to find out the answer.

Input:
The first line of the input will contain T, the number of test-cases. 
Each subsequent T lines will contain an integer N, where N is the range of lengths of rods from 1 to N .

Output:
For each test-case print the required answer. 

* Constraints:
1<T<1000
1<=N<=10^9

* SAMPLE INPUT               
	2
	3
	2

* SAMPLE OUTPUT 
	1
	0

*/

import java.util.*;
public class Rod_Cutting_Problem {
	 public static void main(String args[] ) throws Exception {
	       int no_of_testcases,input,i,j,no_of_special_rods=0;
	       int rod;
	       Scanner sc=new Scanner(System.in);
	       no_of_testcases=sc.nextInt();
	       for(i=0;i<no_of_testcases;i++)
	       {
	           input=0;
	           no_of_special_rods=0;
	           input=sc.nextInt();
	           rod=3;
	           for(j=rod;j<=input;j=j*2+1)
	           {
	              no_of_special_rods++;
	           }
	          
	           System.out.println(no_of_special_rods);
	         }
	       sc.close();
	    }
	
}
