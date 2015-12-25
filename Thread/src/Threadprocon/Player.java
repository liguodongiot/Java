package Threadprocon;

/**
 * 生产者
 * @author liguodong
 */
public class Player implements Runnable{
	
	private Movie m;	
	
	public Player(Movie m) {
		super();
		this.m = m;
	}
	
	@Override
	public void run() {
		for(int i=0;i<20;i++){
			if(0==i%2){
				m.play("何以笙箫默");
			}else{
				m.play("功夫之王");
			}
		}
	}
}
