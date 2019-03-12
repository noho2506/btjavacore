package QuanLySinhVien;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class SinhVienAction {
	public void menu() {
		System.out.println("------------Menu------------");
		System.out.println("  1. Add Student");
		System.out.println("  2. Edit Student by id");
		System.out.println("  3. Delete Student by id");
		System.out.println("  4. Sort Student by gpa");
		System.out.println("  5. Sort Student by name");
		System.out.println("  6. Show Student");
		System.out.println("  0. Exit");
	}
	public ArrayList<SinhVien> inputData(int n) {
		// TODO Auto-generated method stub
		ArrayList<SinhVien> list = new ArrayList<>();
		Scanner input = new Scanner(System.in);
		int id,age=0;
		String name,address;
		float gpa=0;
		boolean cont = true;
		for (int i = 1; i <= n; i++) {
			do {
				try {
					System.out.println("Nhập đối tượng thứ "+i);
					System.out.println("ID: ");
					id = Integer.parseInt(input.nextLine());
					if (checkId(list, id)!=null) {
						System.out.println("Trùng ID! Nhập lại ID: ");
						id = Integer.parseInt(input.nextLine());
					}
					System.out.println("Tuổi: ");
					do {
						try {
							age = Integer.parseInt(input.nextLine());
							if (age<0) {
								throw new Loi("Vui lòng nhập tuổi lớn hơn 0");
							}
							cont=false;
						} catch (NumberFormatException e) {
							cont = true;
							System.out.println("Lỗi! Nhập lại tuổi : ");
						}catch (Loi e) {
							System.out.println(e.getMessage());
							cont=true;
						}
					} while (cont);
					System.out.println("Tên: ");
					name= input.nextLine();
					System.out.println("Địa chỉ: ");
					address = input.nextLine();
					System.out.println("Điểm Trung Bình: ");
					do {
						try {
							gpa = Float.parseFloat(input.nextLine());
							if (gpa>10||gpa <0) {
								throw new Loi("Lỗi! Nhập điểm trung bình từ 0-10");
							}
							cont=false;
						} catch (NumberFormatException e) {
							cont=true;
							System.out.println("Lỗi! Nhập lại ĐTB:");
						}catch (Loi e) {
							System.out.println(e.getMessage());
							cont = true;
						}
					} while (cont);
					SinhVien obj = new SinhVien(id, name, age, address, gpa);
					list.add(obj);
					cont = false;
				} catch (Exception e) {
					cont = true;
					System.out.println("Lỗi! Nhập lại : ");
				}
			} while (cont);
		}
		return list;
	}
	public SinhVien checkId(ArrayList<SinhVien> list, int id) {
		for (SinhVien sinhVien : list) {
			if (id == sinhVien.getId()) {
				return sinhVien;
			}
		}
		return null;
	}
	public void displayData(ArrayList<SinhVien> list) {
		System.out.println("------>>>DANH SÁCH SINH VIÊN<<<<------");
		for (int i = 0; i < list.size(); i++) {
			System.out.println("=>Sinh viên thứ "+ i++);
			i--;
			System.out.println(" -Tuổi: "+list.get(i).getAge());
			System.out.println(" -Tên: "+list.get(i).getName());
			System.out.println(" -Điểm Trung bình: "+list.get(i).getGpa());
			System.out.println(" -Địa chỉ: "+list.get(i).getAddress());
		}
	}
	public void edit(ArrayList<SinhVien> list, int id) {
		Scanner input = new Scanner(System.in);
		System.out.println("Sửa thông tin SV có ID: "+id);
		boolean count = true;
		for (SinhVien sinhVien : list) {
			if (sinhVien.getId()==id) {
				do {
					try {
						System.out.print("Tên: ");
						sinhVien.setName(input.nextLine());
						System.out.print("Tuổi");
						sinhVien.setAge(Integer.parseInt(input.nextLine()));
						System.out.print("Địa chỉ: ");
						sinhVien.setAddress(input.nextLine());
						System.out.print("Điểm trung bình");
						sinhVien.setGpa(Float.parseFloat(input.nextLine()));
						count = false;
					} catch (Exception e) {
						System.out.println("Lỗi khi nhập! Nhập lại ");
					}	
				} while (count);
				
			}
		}
	}
	public void del(ArrayList<SinhVien> list, int id) {
		Scanner input = new Scanner(System.in);
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getId()==id) {
				list.remove(i);
			}
		}
	}
	public void sortGpa(ArrayList<SinhVien> list) {
		Collections.sort(list, new Comparator<SinhVien>() {
			@Override
			public int compare(SinhVien o1, SinhVien o2) {
				if (o1.getGpa()>o2.getGpa()) {
					return 1;
				}
				return -1;
			}
			
		});
		System.out.println("---Thứ tự giảm dần của Sinh viên theo gpa--- ");
		displayData(list);
		Collections.reverse(list);
		System.out.println("---Thứ tự tăng dần của Sinh viên theo gpa--- ");
		displayData(list);
	}
	public void sortName(ArrayList<SinhVien> list) {
		Collections.sort(list, new Comparator<SinhVien>() {

			@Override
			public int compare(SinhVien o1, SinhVien o2) {
				return o1.getName().compareTo(o2.getName());
			}
		});
		
	}
}
