package oppg_3;

import java.util.concurrent.BlockingQueue;

public class ServitorBQ extends Thread {
	private final BlockingQueue<Hamburger> brett;
	private final String navn;
	
	public ServitorBQ(BlockingQueue<Hamburger> brett, String navn) {
		this.brett = brett;
		this.navn = navn;
	}
	
	@Override
	public void run() {
		try {
			while (true) {
				Thread.sleep((int) (Math.random() * 4000) + 2000);
				Hamburger hamburger = brett.take();
				System.out.println(navn + " (servitør) tar av hamburger " + hamburger + ". Brett: " + brett);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
