package javacore;

import java.util.Scanner;

public class Ex6 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Nhập chiều dài của mảng");
		int n ;
		boolean check1= true,check2=true;
		do {
			try {
				n = Integer.parseInt(input.nextLine());
				int[] songuyen = new int[n];
				System.out.println("Nhập mảng: ");
				for (int i = 0; i < n; i++) {
					do {
						try {
							System.out.println("Songuyen["+i+"]: ");
							songuyen[i] = Integer.parseInt(input.nextLine());
							check2=false;
						} catch (Exception e) {
							check2=true;
							System.out.println("Lỗi! Nhập lại:");
						}
					} while (check2);
				}
				int temp;
				for (int i = 0; i < songuyen.length; i++) {
					for (int j = 0; j < songuyen.length; j++) {
						if (songuyen[i]>songuyen[j]) {
							temp= songuyen[j];
							songuyen[j]=songuyen[i];
							songuyen[i]=temp;
						}
					}
				}
				System.out.println("Thứ tự giảm dần của Mảng: ");
				for (int i = 0; i < songuyen.length; i++) {
					System.out.print(songuyen[i]+"  ");
					
				}
				check1 = false;
			} catch (Exception e) {
				System.out.println("Lỗi! Nhập lại n: ");
			}
		} while (check1);
		
	}
}
