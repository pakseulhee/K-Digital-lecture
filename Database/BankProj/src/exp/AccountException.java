package exp;

public class AccountException extends Exception {
	//계좌번호가 틀립니다.
	//이미 존재하는 계좌번호입니다.
	//잔액이 부족합니다.
	//입금액이 잘못되었습니다.
	//0~5까지만 선택이 가능합니다.
	//1,2만 선택이 가능합니다.
	BankExpCode errCode;
	public AccountException() {}
	public AccountException(String message) {
		super(message);
	}
	public AccountException(String message, BankExpCode errCode) {
		super(message);
		this.errCode=errCode;
	}
	public AccountException(BankExpCode errCode) {
		super("계좌오류");
		this.errCode = errCode;
	}
	@Override
	public String getMessage() {
		String msg=  super.getMessage();
		switch(errCode) {
		case NOT_ACC: msg += ":계좌번호가 틀립니다."; break;
		case EXIST_ACC: msg += ":이미 존재하는 계좌번호입니다."; break;
		case WITHDRAW: msg += ":잔액이 부족합니다."; break;
		case DEPOSIT: msg += ":입금액이 잘못되었습니다."; break;
		case MAIN_MENU: msg += ":0~5까지만 선택이 가능합니다."; break;
		case ACC_MENU: msg += ":1,2만 선택이 가능합니다."; break;
		case LIST_MENU: msg += ":1,2,3만 선택이 가능합니다."; break;
		}
		return msg;
	}
	public BankExpCode getErrCode() {
		// TODO Auto-generated method stub
		return null;
	}
}
