package javacore;

import java.util.Scanner;

public class Ex2 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Nhập n:");
		int n;
		boolean count= true;
		String check;
		do {
			try {
				n= Integer.parseInt(input.nextLine());
				if (n>0) {
					System.out.println("Số nguyên tố nhỏ hơn "+n +":");
					for (int i = 1; i <= n; i++) {
						check="K";
						for (int j = 2; j <i; j++) {
							if ((i%j)==0) {
								check="C";
							}
						}
						if (check.equals("K")) {
							System.out.print(i+"   ");
						}
					}
					count = false;
				}else {
					System.out.println("Vui lòng nhập n lớn hơn 0. Nhập lại n:");
					
				}
			} catch (Exception e) {
				System.out.println("Lỗi! Nhập lại n:");
			}
		} while (count);
	
	}
}
