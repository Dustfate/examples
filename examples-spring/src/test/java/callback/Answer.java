package callback;

public class Answer implements CallBack {
	
	private Question question;
	
	public Answer(Question question){
		this.question = question;
	}
	
	/** 
     * 小王通过这个方法去问小李的问题 
     * @param question  就是小王要问的问题,1 + 1 = ?
     */  
    public void askQuestion(final String q){
        //这里用一个线程就是异步，  
        new Thread(new Runnable() {
            @Override  
            public void run() {
                /** 
                 * 小王调用小李中的方法，在这里注册回调接口
                 * 这就相当于A类调用B的方法C
                 */  
            	question.executeMessage(Answer.this, q);
            }
        }).start();
        //小网问完问题挂掉电话就去干其他的事情了，诳街去了
        play();
    }  
  
    public void play(){
        System.out.println("我要逛街去了");  
    }
  
    /** 
     * 小李知道答案后调用此方法告诉小王，就是所谓的小王的回调方法 
     */  
    @Override  
    public void solve(String result) {  
        System.out.println("小李告诉小王的答案是--->" + result);  
    }
    
}
