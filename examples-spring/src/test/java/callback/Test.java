package callback;

public class Test {

	public static void main(String[] args) {
		Answer answer = new Answer(new Question());
		answer.askQuestion("1+1=?");
	}

}
