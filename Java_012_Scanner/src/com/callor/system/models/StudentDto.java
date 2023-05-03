package com.callor.system.models;
/*
 * 클래스의 멤버변수, 멤버 method
 * 		멤버** : 현재의 클래스 scope 내부에서 선언된 변수, method
 * 		멤버변수 : field, 객체변수, 속성, Attribute	
 * Dto 클래스의 멤버 변수의 접근제한자
 * 		접근제한자는 public, private, protected가 있는데
 * 		멤버 변수, 멤버 method에 접근제한자가 없을때
 * 		package가 다른곳에서 멤버**에 접근하려고 하면 접근이 안된다
 * 
 * 		1.package가 다른곳에서 멤버**에 접근하려고 하면 접근이 안된다
 * 		2.public 접근제한자가 있으면 package에 관계없이 
 * 			현재 프로젝트의 어떤 곳에서든 자유롭게 접근이 가능
 * 		3.private 접근 제한자가 있으면 현재 클래스의 멤버 method 에서만 
 * 			접근이 가능하다
 * 
 * Dto 클래스의 멤버 변수와 getter, setter mehtod
 * 		java의 프로젝트 패턴에서 dto 클래스이 멤버 변수는 
 *   	모두 private으로 선언된
 *   	private으로 선언된 멤버 변수에 값을 저장,읽기 위하여
 *   	setter, getter method를 생선
 * Dto클래스를 객체로 생성한 후 멤버 면쉥 접근하기 위하여 멤법 변수를 직접
 * 		호명하지 않고 setter, getter methof라고 명명한다
 */
public class StudentDto {
	//학번 이름 학과 학년 전화번호
	private String stNum;
	private String stName;
	private String stDept;
	private int    stGrade;
	private String stTel;
	public String getStNum() {
		return stNum;
	}
	public void setStNum(String stNum) {
		this.stNum = stNum;
	}
	public String getStName() {
		return stName;
	}
	public void setStName(String stName) {
		this.stName = stName;
	}
	public String getStDept() {
		return stDept;
	}
	public void setStDept(String stDept) {
		this.stDept = stDept;
	}
	public int getStGrade() {
		return stGrade;
	}
	public void setStGrade(int stGrade) {
		this.stGrade = stGrade;
	}
	public String getStTel() {
		return stTel;
	}
	public void setStTel(String stTel) {
		this.stTel = stTel;
	}
	
	@Override
	public String toString() {
		return "StudentDto [stNum=" + stNum + ", stName=" + stName + ", stDept=" + stDept + ", stGrade=" + stGrade
					+ ", stTel=" + stTel + "]";
		
	/*
	 * StudentDto 클래스를 선언한 객체의 멤버(속성)에 저장된
	 * 값을 문자열로 만들어 return 해주는 method
	 * 
	 * 개발자가 정의한 클래스를 사용하는 객체변수를 생성하면 
	 * 	기본적으로 torString method는 소스코드에 나타나지 않는다
	 * 	하지만 객체.toString()처럼 method를 사용할 수 있다
	 * 	원래 toStirng() method는 개체의 정보중에서 메모리주소 등을 알려주는
	 * 	문자열을 생성하여 return하는 코드가 들어있다
	 * 
	 *  기본적으로 toString() method가 return하는 문자열은 별로 효용 가치가 없다
	 * 
	 */
	}
//	
	
	
	
}
