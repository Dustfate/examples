package callback;

public class Question {

	public void executeMessage(CallBack callBack, String question) {
		System.out.println("问题--->" + question);

		// 模拟办自己的事情需要很长时间
		for (int i = 0; i < 10000; i++) {

		}
		
		String result = "答案是2";
		
		callBack.solve(result);

	}

}
