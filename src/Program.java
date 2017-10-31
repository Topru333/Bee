import java.util.Scanner;

/*******************************************************************************
 * Copyright (c) 2009-2017, Exactpro Systems
 * Quality Assurance & Related Software Development for Innovative Trading Systems.
 * London Stock Exchange Group.
 * All rights reserved.
 * This is unpublished, licensed software, confidential and proprietary
 * information which is the property of Exactpro Systems or its licensors.
 *******************************************************************************/

/**
 * @author nikita.shaposhnikov
 *
 */
public class Program {
	
	private static Double q1; // A speed
	private static Double q2; // B speed
	private static Double z;  // Bee speed
	private static Double dis;// Distance between A and B
	static int i = 0;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int count = 0;
		Scanner sc = new Scanner(System.in);
		System.out.println("input A speed");
		q1 = sc.nextDouble();
		System.out.println("input B speed");
		q2 = sc.nextDouble();
		System.out.println("input Bee speed");
		z = sc.nextDouble();
		System.out.println("input distance");
		dis = sc.nextDouble();
		
		// t = dis/(q1+z)
		// q1 * t = place where is first one
		// q2 * t = place where is second one
		Double t1 = getTime(dis,q1,q2),t2;
		while(true){
			t2 = getTime(dis,getNext(),z); // time to reach next one
			dis = (dis - getDistance(t2, q1)) - getDistance(t2, q2);
			if(!(t1-t2>0&&dis>0&&t2>0.001)) {
				System.out.println("stoped  t left " + t1);
				System.out.println("Count = " + count);
				return;
			}
			t1 = t1 -t2;
			count++;
			System.out.println("bee reached and time left = " + t1);
		}
		
	}
	
	private static Double getNext(){
		if(i++%2==0){
			return q1;
		}
		else{
			return q2;
		}
	}
	
	private static Double getTime(Double dis, Double q1, Double q2){
		return dis/(q1+q2);
	}
	private static Double getDistance(Double t, Double q){
		return t*q;
	}

}
