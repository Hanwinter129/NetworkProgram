package mini;

// 정보를 저장하는 메소드

public class memList {
	private int num;
	private int num2;
	private String name;
	private String phone;
	private String sns_id;
	


	public memList() {
	}

	
	
	public int getNum2() {
		return num2;
	}



	public void setNum2(int num2) {
		this.num2 = num2;
	}



	public memList(int num, int num2, String name, String phone, String sns_id) {
		super();
		this.num = num;
		this.num2 = num2;
		this.name = name;
		this.phone = phone;
		this.sns_id = sns_id;
	}



	public int getNum() {
		return num;
	}


	public void setNum(int num) {
		this.num = num;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getSns_id() {
		return sns_id;
	}

	public void setSns_id(String sns_id) {
		this.sns_id = sns_id;
	}

	@Override
	public String toString() {
		return "[ 등록날짜 : " + num +"월 "+num2+"일,"+ " 이름 : " + name + ", 핸드폰 번호 : " + phone + ", sns id : " + sns_id + "]";
	}



	
	
	
}