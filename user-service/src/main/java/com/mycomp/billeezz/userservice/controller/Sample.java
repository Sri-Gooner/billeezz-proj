package com.mycomp.billeezz.userservice.controller;

import java.util.HashMap;
import java.util.Map;

public class Sample extends Sample1{
	int i=0;
	Sample(int i){
		this.i = i;
	}
	static void sample(){
		try
		{
		int b=10/0;
		}catch(ArithmeticException e)
		{
		System.out.println("ArithmeticException occurred");
		int c=20/0;
		}
	}
	
	void sam(){
		System.out.println("sam");
	}
	
	
	public static void main(String[] args) {
		//Sample.sample();
		//System.out.println(1/0);
		System.out.println("-----");
		System.out.println(7%2);
		int a = 'A';
		System.out.println(a);
		
		Map<Integer,String> mp = new HashMap<Integer,String>();
		mp.put(1,"s");
		mp.put(1, "s1");
		System.out.println(mp);
		
		Sample ss = new Sample(10);
		Sample ss1 = ss;
		System.out.println(ss.equals(ss1));
		Integer[] a1 = new Integer[5];
		a1[0]="";
	}
}
