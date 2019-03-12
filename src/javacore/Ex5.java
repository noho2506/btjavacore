package javacore;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;

import QuanLySinhVien.Loi;

public class Ex5 {
	/*Nhập một mảng số nguyên a0, a1, a2, …, an-1. In ra màn hình các phần tử xuất hiện trong mảng đúng 1 lần.*/
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Nhập độ dài của mảng:");
		boolean cont= true;
		int n= 0;
		do {
			try {
				n=Integer.parseInt(input.nextLine());
				if (n<1) {
					throw new Loi("Lỗi! Vui lòng nhập lớn hơn 0");
				}
				cont=false;
			}catch (NumberFormatException e) {
				cont=true;
				System.out.println("Lỗi! Nhập lại : ");
			}catch (Loi e) {
				System.out.println(e.getMessage());
				cont=true;
			}
		} while (cont);
		int[] A = new int[n];
		for (int i = 0; i < A.length; i++) {
			do {
				try {
					System.out.print("Nhập phần tử thứ " + i+": ");
					A[i]= Integer.parseInt(input.nextLine());
					cont=false;
				}catch (NumberFormatException e) {
					cont=true;
					System.out.println("Lỗi! Nhập lại : ");
				}
			} while (cont);
		}
		Map<Integer , Integer> wordMap= new LinkedHashMap<>();
		for (int i = 0; i < A.length; i++) {
			if (wordMap.containsKey(A[i])) {
				int count = wordMap.get(A[i]) +1;
				wordMap.put(A[i], count);
			}else {
				wordMap.put(A[i], 1);
			}
		}
		 System.out.println("Các phần tử xuất hiện trong mảng đúng 1 lần : ");
			for (Integer key : wordMap.keySet()) {/*keyset:để trả đối tượng Set có chứa tất cả các keys.*/
				if (wordMap.get(key)==1) {
					System.out.print(" - "+key + "  ");
					
				}
			}
			
		   }

	
}
