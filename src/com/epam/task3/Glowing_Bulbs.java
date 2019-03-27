package com.epam.task3;
/* 
 * PROBLEM STATEMENT
There is an infinite series of bulbs indexed from 1. And there are 40 switches indexed from 1 to 40. Switch with index x is connected to the bulbs with indexes that are multiple of x. i.e switch 2 is connected to bulb 4, 6, 8 ....

You can easily observe that some bulbs are connected to multiple switches and some are not connected to any switch.

Chotu is playing with these switches, he wants to know the Kth glowing bulb from the start if certain switches are in ON state. If any of the switch is ON, connected to any bulb then bulb starts glowing. But chotu has special fond of prime numbers so he only puts prime indexed switches ON.

* INPUT-

First line contains number of test cases (T). Each test case contains two lines- First line contains a string S of length 40 containing 0s and 1s that represents the state of bulbs. 1 is ON , 0 is OFF. Second line contains one integer k. Atleast One switch is in ON condition.

* OUTPUT-

Output one integer per test case representing kth glowing bulb.

* CONSTRAINTS-

1 <= T <= 500

S contains only 0s and 1s. 1s are only at prime positions.

1 <= k <= 10^15

1 is not prime

* SAMPLE INPUT 
	3
	0110000000000000000000000000000000000000
	5
	0010000000000000000000000000000000000000
	5
	0100000000100000001000100000101000001000
	16807

* SAMPLE OUTPUT 
	8
	15
	26866

 */
import java.util.*;
public class Glowing_Bulbs {
	public static void main(String args[] ) throws Exception {
			Scanner sc = new Scanner(System.in);
			long no_of_test_cases = sc.nextLong();
	 
			while (no_of_test_cases-- > 0) {
				sc.nextLine();
				String input = sc.nextLine();
	 
				long k = sc.nextLong();
				long result = getones(k, input);
				/*
				 * I had passed the variables k,input into getones function
				 */
				System.out.println(result);
			}
			sc.close();
	}
 
		public static long getones(long k, String input) {
			ArrayList<Integer> ones = new ArrayList<>();
	
			for (int i = 0; i < input.length(); i++) {
				if (input.charAt(i) == '1') {
	 
					ones.add(i + 1); //passing the index into switches arraylist
				}
			}
			long res = 0;
			long low = 1;
			long high = 1000000000000000L;
			long mid = 0;
			while (low <= high) {
				mid = (low + high) / 2;
				/*
				 * passing mid and high variables into multiples function 
				 * it will the calculate the multiples and returns the 
				 * mutliple at specified position
				 */
				if (multiples(mid, ones) >= k) 
				{
					res = mid;
				high = mid - 1;
 
				} else
					low = mid + 1;
			}
	 
			return res;
	 
		}
	 
		public static long multiples(long mid, ArrayList<Integer> ones) {
			long ans = 0;
			for (long i = 1; i < (1 << ones.size()); i++) {
				long t = 1;
				long sign = -1;
				for (int j = 0; j < ones.size(); j++) {
					if (((i >> j) & 1) == 1) {
						t *= ones.get(j);
						sign *= -1;
				}
			}
 
			ans += (mid / t) * sign;
			}
			return ans;


}
}