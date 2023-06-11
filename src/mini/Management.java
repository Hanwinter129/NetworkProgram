package mini;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

public class Management {
	
	Scanner sc = new Scanner(System.in);
	List<memList> addList = new ArrayList<memList>();
	List<memList> searchList = new ArrayList<memList>();
	memList m = new memList();
	Calendar cal = Calendar.getInstance();
	Regexhelper rg = Regexhelper.getInstance();
	
	// 실행 메소드
	public void start() {

		while(true) {
				
			System.out.println("===========================================");
			System.out.println();
			System.out.println("             인맥관리 프로그램");
			System.out.println();
			System.out.println("===========================================");
			System.out.println();
			System.out.println("     1.검색         2. 등록        3. 삭제 ");
			System.out.println();
			System.out.println(" 4.리스트       5. 인맥관리 프로그램       6. 종료 ");
			System.out.println();
			System.out.println("메뉴번호 >> ");
			// sc.hasNextInt() 메소드를 사용하여 입력값이 정수인지 여부를 검사
				if (sc.hasNextInt()) {
					int num = sc.nextInt();
					switch(num) {
					case 1 : 
							search();
							break;
					case 2 : 				
							add();
							break;
					case 3 : 
							delete();
							break;
					case 4 : 
							list(addList);
							break;
					case 5 : 
							// 연락처 랜덤 출력 메소드
						    int i = (int)(Math.random()*addList.size());
							System.out.println("오늘은 "+addList.get(i).getName()+"님께 연락해보세요");
							System.out.println("-----------------------------------------------");
							System.out.println("핸드폰 번호 : " + addList.get(i).getPhone());
							System.out.println("SNS ID : " + addList.get(i).getSns_id());
							break;		
					case 6 : 
							System.out.println("*******감사합니다*******"); 
							return;
					default : 
							System.out.println("다시 입력하세요.");
					}
				} else {
	                sc.next(); // 입력값을 버림
	                System.out.println("숫자를 입력하세요");
	            }
			// while문이 끝나고 새로 시작하기 전 2초 지연을 줌
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				} 
				
			}
	}
	
	// 텍스트 파일에 저장하는 메소드
	public void writing (List<memList> addList) {
		
	try (BufferedWriter bw = new BufferedWriter(new FileWriter("outline.txt"))){ //
		for(int i = 0; i < addList.size(); i++ ) {
			memList writes = (memList) addList.get(i);
			bw.write("[등록날짜 : "+writes.getNum()+"월 "+writes.getNum2()+"일");
			bw.write(" 이름 : "+writes.getName()+", ");
			bw.write("핸드폰 : "+writes.getPhone()+", ");
			bw.write("sns id : "+writes.getSns_id()+"]");
			bw.write("\n");
		}		
	} catch (IOException e) {
		e.printStackTrace();
	}
	}
	
	 // arrayList에 추가하는 메소드
	public void add() {  
	
	for(;;) {	
		System.out.println("이름>>");
		m.setName(sc.next());
		if(!rg.isKor(m.getName())) {
			System.out.println("이름은 한글로 입력해주세요");
			System.out.println("*******입력 실패*******");
			continue;
		}
	
		System.out.println("핸드폰번호>>");
		m.setPhone(sc.next());
		if (!rg.isPhone(m.getPhone())) {
			System.out.println("핸드폰 번호가 잘못되었습니다.");
			System.out.println("*******입력 실패*******");
			continue;
		}

		System.out.println("SNS id>>");
		m.setSns_id(sc.next());
	

		// 정보를 받아 추가하기 전에 현재 입력 날짜를 저장함
		m.setNum(cal.get( Calendar.MONTH ) + 1);
		m.setNum2(cal.get( Calendar.DAY_OF_MONTH));
		System.out.println("*******입력 완료*******");
		System.out.println();
		System.out.println();
		System.out.println();
		addList.add(new memList(m.getNum(), m.getNum2(), m.getName(), m.getPhone(), m.getSns_id()));
		writing(addList);
		break;
		}
	}
	
		
	// 배열 삭제 메소드
	public void delete() {
		System.out.println("삭제할 이름을 입력하세요.");
		String name = sc.next();
		
		for(int i = 0; i<addList.size();i++) {
			memList mem = addList.get(i);
			
			if (mem.getName().equals(name)) {
				addList.remove(i);
			
				writing(addList);
		
				System.out.println();
				System.out.println();
				System.out.println("*******삭제 완료*******");
				System.out.println();
			
						
			} 
			} System.out.println("*******삭제가 완료되었습니다.*******");
	}
	
	// 배열 찾아서 출력하는 메소드
	public void search() {
		System.out.println("찾으시는 이름을 입력하세요");
		System.out.println(">>");
		String name = sc.next();
		for(int i = 0; i < addList.size() ; i++) {
			memList mem = addList.get(i);
	
			if (mem.getName().equals(name)) {
				System.out.println();
				System.out.println("등록 날짜 : " + mem.getNum() + "월 " + mem.getNum2() + "일");	
				System.out.println("이름 : " + mem.getName());	
				System.out.println("핸드폰 번호 : " + mem.getPhone());	
				System.out.println("SNS ID : " + mem.getSns_id());	
				System.out.println();
				
			} 
		}  System.out.println("*******검색이 완료되었습니다.*******");
	}
	
	
	// 배열 전체를 출력하는 메소드
	public void list(List<memList> addList) {
		
		if (addList.size()==0) {
			System.out.println();
			System.out.println();
			System.out.println("*********리스트가 없습니다*********");
			System.out.println();
			System.out.println();
		} 
		for( int i = 0; i < addList.size();i++) {
			
				System.out.println(addList.get(i).toString());	
			
			}
		}


}


