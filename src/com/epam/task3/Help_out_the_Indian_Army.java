package com.epam.task3;
/*
 * PROBLEM STATEMENT
Protection of the Indian border and safe transport of items from one point to another along the border are the paramount jobs for the Indian army. However they need some information about the protection status along the length of the border. The border can be viewed as the real x-axis. Along the axis, Indian army has N checkpoints for lookout. 

We know that each checkpoint is located at an integer location xi. Each checkpoint must have a fleet of armed men which are responsible for guarding the neighboring areas of the checkpoint and provide military assistance of all kinds. The size of the fleet is based on the location of the checkpoint and how active the region is for terrorist activities. 

Given the number of armed men assigned at the ith checkpoint, as pi, this information is available for all checkpoints. 
With the skills of the armed men, it is known that if for the ith checkpoint, the length on the x axis that they can defend is a closed interval [xi-pi, xi+pi].

Now, your task is to transport some military items from position S to the end position E on the x-axis. 

* Input:
First line of the input contains 3 integers N, S and E. N is the number of checkpoints that the Indian Army has on the border.
Then N lines follow. ith line contains 2 integers, xi and pi.

* Output:
Print the total distance of the x-axisfrom S to E, that is not protected by the armed forces.

* Constraints:
	1 <= N <= 105
	1 <= xi, pi <= 1018
	xi + pi <= 1018
	1 <= S <= E <= 1018

* SAMPLE INPUT 
	5 229 8419
	1795 95
	4873 720
	3149 81
	6101 2325
	3674 629

* SAMPLE OUTPUT 
	2626

*/
import java.util.*;
public class Help_out_the_Indian_Army 
{
public static void main(String args[] ) throws Exception
	{
        int i,no_of_test_cases;
        long starting_point,ending_point,sum=0;
        long a[] = new long[10000000];
        long b[] = new long[1000000]; 
        TreeMap<Long,Long> map=new TreeMap<Long,Long>();
        Scanner sc= new Scanner(System.in);
        no_of_test_cases=sc.nextInt();
        starting_point=sc.nextLong();
        ending_point=sc.nextLong();
        for(i=0;i<no_of_test_cases;i++)	
        {
            a[i]=sc.nextLong();		//total no of army people assigned at that corresponding check point
            b[i]=sc.nextLong(); 	//armed men assigned at that corresponding check point 
        } 
        /*
         * //In the below for loop we storing the ranges of each check ponit into tree map 
         * as tree map takes the values and removes the dublicates 
         * and store the values in sorted order all the values in 
         * the tree map are in sorted order
         */
       for(i=0;i<no_of_test_cases;i++)
       {
           map.put(a[i]-b[i],a[i]+b[i]);	 
       }
       Long low=starting_point;	
       Long high,plow,phigh;
       /*
        * In the below for loop we are calculating the uncoverd area 
        * between starting area and ending area
        */
       for(Map.Entry treemap:map.entrySet())
        { 
    	   		plow=(long)treemap.getKey();
                phigh=(long)treemap.getValue();
       
             
                 high=phigh;
                if(ending_point<plow)
                break;
                if(low<plow)
                sum=sum+plow-low;
                if(high>low)
                low=high;
                 
          }
             if(low<ending_point)
             sum=sum+ending_point-low;
             System.out.println(sum);
             sc.close();
}
}


