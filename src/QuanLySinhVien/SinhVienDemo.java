package QuanLySinhVien;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

public class SinhVienDemo {
	public static void main(String[] args) {
		SinhVienAction obj = new SinhVienAction();
		ArrayList<SinhVien> list= null;
		Scanner input = new Scanner(System.in);
		obj.menu();
		boolean cont=true,cont1=true;
		int chon=0,n=0;
		do {
			do {
				System.out.println("Mời bạn chọn chức năng: ");
				try {
					chon=Integer.parseInt(input.nextLine());
					if (chon<0 || chon>7) {
						System.out.println("fsdfs");
						throw new Loi("Mời chọn từ 0- 6 ");
					}
					cont = false;
				} catch (NumberFormatException e) {
					cont=true;
					System.out.println("Lỗi! Chọn lại :");
				}catch (Loi e) {
					System.out.println(e.getMessage());
					cont=true;
				}
			} while (cont);
			switch (chon) {
			case 1:
				do {
					System.out.println("Bạn muốn nhập bao nhiêu sinh viên ");
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
				list=obj.inputData(n);
				break;
			case 2:
				if (list!=null) {
					do {
						System.out.println("Nhập ID bạn muốn sửa: ");
						try {
							int id = Integer.parseInt(input.nextLine());
							if (obj.checkId(list, id)!=null) {
								obj.edit(list, id);
								cont=false;
							}else {
								throw new Loi("Lỗi! ID không tồn tại! Nhập lại: ");
							}
						} catch (NumberFormatException e) {
							cont=true;
						}catch (Loi e) {
							System.out.println(e.getMessage());
							cont = true;
						}
					} while (cont);
				}else {
					System.out.println("Không có dữ liệu ");
				}
				break;
			case 3:
				if (list!=null) {
					do {
						try {
							System.out.println("Nhập ID bạn muốn xóa: ");
							int id = Integer.parseInt(input.nextLine());
							if (obj.checkId(list, id)!=null) {
								obj.del(list, id);
								System.out.println("Xóa thành công!");
								cont=false;
							}else {
								throw new Loi("Lỗi! ID không tồn tại! Nhập lại: ");
							}
						} catch (NumberFormatException e) {
							cont=true;
						}catch (Loi e) {
							System.out.println(e.getMessage());
							cont = true;
						}
					} while (cont);
				}else {
					System.out.println("Không có dữ liệu ");
				}	
				break;
			case 4:
				if (list!=null) {
					obj.sortGpa(list);
				}else {
					System.out.println("Không có dữ liệu ");
				}
				break;
			case 5:
				if (list!=null) {
					System.out.println("Sắp xếp Sinh Viên theo TÊN: ");
					obj.sortName(list);
					obj.displayData(list);
				}else {
					System.out.println("Không có dữ liệu ");
				}
				break;
			case 6:
				obj.displayData(list);
				break;
			case 0:
				System.out.println("Goodbye!");
				cont = true;
				break;
			default:
				System.out.println("Mời bạn nhập từ 0-6 ");
				cont=true;
				break;
			}
			cont1=true;
		} while (cont1);
	}
}
