package javacore;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Ex4 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Nhập chuỗi ký tự: ");
		String chuoi= input.nextLine();
		StringTokenizer st= new StringTokenizer(chuoi);
		Map<String , Integer> wordMap= new LinkedHashMap<>();
		 while (st.hasMoreTokens()) {  
	         String word =st.nextToken();
	         if (wordMap.containsKey(word)) {
				int count = wordMap.get(word) +1;
				wordMap.put(word, count);
			}else {
				wordMap.put(word, 1);
			}
	     } 
		 System.out.println("Số lần xuất hiện của từ : ");
			for (String key : wordMap.keySet()) {
				System.out.println(" - "+ key + "  "+ wordMap.get(key));
			}
	}
}