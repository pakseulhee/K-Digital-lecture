package example06;
//파이널변수가 아닌 지역변수를 지역 필드에서 사용해서 에러가 난 케이스이다.
public class Chatting {
	void startChat(String chatId) {
		final String nickName = chatId;
		Chat chat = new Chat() {
			@Override
			public void start() {
				while(true) {
					String inputData = "안녕하세요";
					String message = "[" + nickName + "]" + inputData;
					sendMessage(message);
				}
			}
		};
		chat.start();
	}
	
	class Chat {
		void start() {}
		void sendMessage(String message) {}
	}
}
