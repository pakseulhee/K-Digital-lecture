import java.util.Scanner;

import acc.Account;
public class Bank {
	Scanner sc = new Scanner(System.in);
	Account[] accs = new Account[100];
	int accCnt;
	
	public int getAccCnt() {
		return accCnt;
	}
	
	public void createAccount() {
		System.out.println("--------");
		System.out.println("계좌생성");
		System.out.println("--------");
		System.out.print("계좌번호:");
		String id = sc.nextLine();
		System.out.print("이름:");
		String name = sc.nextLine();
		System.out.print("초기입금액:");
		int money = Integer.parseInt(sc.nextLine());
		accs[accCnt++] = new Account(id,name,money);
		System.out.println("결과:계좌가 개설되었습니다.");
	}
	
	public void accsList() {
		System.out.println("--------");
		System.out.println("계좌목록");
		System.out.println("--------");	
		for(int i=0; i<accCnt; i++) {
			System.out.println(accs[i].accInfo());
		}
	}
	
	private Account searchAccById(String id) {
		for(int i = 0; i<accCnt; i++) {
			if(accs[i].getId().equals(id)) {
				return accs[i];
			}
		}
		return null;
	}

	public void deposit() {
		System.out.println("------");
		System.out.println("입금");
		System.out.println("------");
		System.out.println("계좌번호:");
		String id = sc.nextLine();
		System.out.println("예금액:");
		int money = Integer.parseInt(sc.nextLine());
		Account acc = searchAccById(id);
		if(acc == null) {
			System.out.println("없는 계좌입니다.");
			return; 
		}
		acc.deposit(money);
		System.out.println("결과: 예금을 성공하였습니다.");
	}
	public void withdraw() {
		System.out.println("------");
		System.out.println("출금");
		System.out.println("------");
		System.out.println("계좌번호:");
		String id = sc.nextLine();
		System.out.println("출금액:");
		int money = Integer.parseInt(sc.nextLine());
		Account acc = searchAccById(id);
		if(acc == null) {
			System.out.println("결과: 없는 계좌입니다.");
			return; 
		}
		acc.deposit(money);
		System.out.println("결과: 출금을 성공하였습니다.");
	}
	
	public void accInfo() {
		System.out.println("------");
		System.out.println("계좌조회");
		System.out.println("------");
		System.out.print("계좌번호:");
		String id = sc.nextLine();
		Account acc = searchAccById(id);
		if(acc == null) {
			System.out.println("결과: 없는 계좌입니다.");
			return; 
		}
		System.out.println("결과: 계좌가 조회되었습니다.");
	}
	
	public int menu() {
		System.out.println("------------------------------------------------");
		System.out.println("1.계좌생성 | 2.계좌조회 | 3.계좌목록 | 4.예금 | 5.출금 | 0.종료");
		System.out.println("------------------------------------------------");
		System.out.print("선택>>");
		return Integer.parseInt(sc.nextLine());
	}
	
	
	public static void main(String[] args) {
		Bank bank = new Bank(); //자기자신을 포함한 객체를 생성시킬 수 있다.
		int sel;
		while((sel=bank.menu())!= 0) {
			switch(sel) {
			case 1: bank.createAccount(); break;
			case 2: bank.accInfo(); break;
			case 3: bank.accsList(); break;
			case 4: bank.deposit(); break;
			case 5: bank.withdraw(); break;
			}
		}
	}
}
