package com.example.demo.service;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

public class Solution {
   public static void main(String[] args) throws IOException {
	   int k = 7,c=0;
	   SortedSet<Integer> set = new TreeSet<Integer>();
	   List<Integer> list = new ArrayList<Integer>();
	   list.addAll(Arrays.asList(278, 576, 496, 727, 410, 124, 338, 149, 209, 702, 282, 718, 771, 575, 436));
	   for(int i=0;i<list.size();i++) {
			/*
			 * for(int j=i+1;j<list.size();j++) { if((list.get(i)+list.get(j))%k != 0) { //
			 * System.out.println(list.get(i)+list.get(j)); set.add(list.get(i));
			 * set.add(list.get(j)); } }
			 */
		   if(list.get(i)%k !=0)
			   c++;
       }
	   //System.out.println(set.size());
	   System.out.println(c);
   }
}
