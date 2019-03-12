package javacore;

import java.util.Scanner;

public class Ex1 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Nhập n:");
		int n;
		boolean check= true;
		do {
			try {
				n = Integer.parseInt(input.nextLine());
				if (n>0) {
					
					int kq=1;
					for (int i = 1; i <= n; i++) {
						kq = kq * i;
					}
					System.out.println("Kết quả "+ n+"! = " +kq);
					check=false;
				}else {
					System.out.println("Lỗi! Nhập lại n >=0");
				}
				
				
			} catch (Exception e) {
				System.out.println("Lỗi! Nhập lại n : ");
			}
		} while (check);
	
		
		
	}
}
