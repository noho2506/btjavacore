package javacore;

import java.util.ArrayList;
import java.util.Scanner;

public class Ex7 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Nhập chiều dài của mảng");
		int n ;
		boolean check1= true, check2=false;
		String kiemtra="k";
		ArrayList<Integer>list = new ArrayList<>();
		do {
			try {
				n = Integer.parseInt(input.nextLine());
				System.out.println("Nhập mảng: ");
				for (int i = 0; i < n; i++) {
					list.add(Integer.parseInt(input.nextLine()));
				}
				int temp;
				do {

					for (int i = 0; i < list.size(); i++) {
						for (int j = 0; j < list.size(); j++) {
							if (list.get(i)<list.get(j)) {
								temp= list.get(j);
								list.set(j, list.get(i));
								list.set(i, temp);
							}
						}
					}
					System.out.println("Thứ tự tăng dần của Mảng: ");
					for (Integer integer : list) {
						System.out.print(integer+"   ");
					}
					System.out.println();
					System.out.print("Nhập thêm phần tử x :");
					Integer x= Integer.parseInt(input.nextLine());
					if (x!=null) {
						list.add(x);
						check2= true;
					}
					
					check1 = false;
				}while(check2);
				
			} catch (Exception e) {
				System.out.println("Lỗi! Nhập lại n: ");
			}
		} while (check1);
		
	}

}
