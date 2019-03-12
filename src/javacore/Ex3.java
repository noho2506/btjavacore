package javacore;

import java.util.Scanner;

public class Ex3 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Nhập chuỗi ký tự: ");
		String chuoi= input.nextLine();
		char space = ' ';
		char tab = '\t';
		char line ='\n';
		boolean count = true;
		int dem=0;
		for (int i = 0; i < chuoi.length(); i++) {
			if ((chuoi.charAt(i)!= space) && (chuoi.charAt(i)!= tab)&&(chuoi.charAt(i)!= line)) {
				  if(count) {
	                    dem++;
	                    count = false;
	                }
	            } else {
	            	count = true;
	            }
			
			}
		System.out.println("Chuỗi '"+chuoi+ "'có " +dem+ " từ");
		
		}
		
		
		
	
}
