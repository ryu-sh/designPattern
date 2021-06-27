package designPattern.dependencyInjection;

import java.util.Date;

public class DependencyInjection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			Date d = new Date();
			System.out.println(d.getDate());
	}
	
	public void useDate(Date d) {
		Date date = d;
		System.out.println(d.getDate());
	}
	
	// 생성자 통한 생성 (강한결합) 
	public void useMember1() {
		// 만약 Member 클래스의 생성자가 변경(private 등으로) 될경우 해당 라인 에러 컴파
		Member member = new Member();
	}
	
	// 의존성 주입 (약한결합) 
	public void useMember2(Member m) {
		Member member = m;
	}
	
	class Member{
		String name;
		String nickName;
		public Member() {
			
		}
	}

}
