package com.epam.task3;
/*
 * PROBLEM STATEMENT
You have been given an array A of size N and an integer K. This array consists of N integers ranging from 1 to . Each element in this array is said to have a Special Weight. The special weight of an element  is .

You now need to sort this array in Non-Increasing order of the weight of each element, i.e the element with the highest weight should appear first, then the element with the second highest weight and so on. In case two elements have the same weight, the one with the lower value should appear in the output first.

* Input Format:

The first line consists of two space separated integers N and K. The next line consists of N space separated integers denoting the elements of array A.

* Output Format:

Print N space separated integers denoting the elements of the array in the order in which they are required.

*Constraints:
	1<=N<=10^5
	1<=A[i]<=10^7
	1<=k<=10^7

* Note: You need to print the value of each element and not their weight.

* SAMPLE INPUT 
	5 2
	1 2 3 4 5
	
* SAMPLE OUTPUT 
	1 3 5 2 4
	
 */
import java.util.*;
class Descendingweights 
{
    public static void main(String args[] ) throws Exception 
    {
       Scanner sc=new Scanner(System.in);
       int no_of_test_cases=sc.nextInt();
       int k=sc.nextInt();
       int array[]=new int[no_of_test_cases];
       for(int i=0;i<no_of_test_cases;i++)
    	   array[i]=sc.nextInt();
       int result[]=new int[no_of_test_cases];
       bucketsort(array,no_of_test_cases,k,result);
       /*
        * I am passing the variables into Bucket sort 
        * Bucket sort will sort the given element
        * The Bucket sort function which i wrote will sort the array based on the weights
        */
       for(int i=0;i<no_of_test_cases;i++)
    	   System.out.print(result[i]+" ");
        sc.close();
    }
    static void bucketsort(int array[],int n,int k,int result[])
    {
    	ArrayList<Integer> weight[]=new ArrayList[k];
    	for(int i=0;i<k;i++)
    		weight[i]=new ArrayList<>();
    	for(int i=0;i<n;i++)
    		weight[array[i]%k].add(array[i]);
    	int ind=0;
    	for(int j=k-1;j>=0;j--)
    	{
    		Collections.sort(weight[j]);
    		for(int i=0;i<weight[j].size();i++)
    			result[ind++]=weight[j].get(i);
    	}
    }
}