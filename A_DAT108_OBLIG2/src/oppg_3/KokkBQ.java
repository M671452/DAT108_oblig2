package oppg_3;

import java.util.concurrent.BlockingQueue;

public class KokkBQ extends Thread {
	private final BlockingQueue<Hamburger> brett;
	private final String navn;
	private static int hamburgerNummer = 1;
	
	public KokkBQ(BlockingQueue<Hamburger> brett, String navn) {
		this.brett = brett;
		this.navn = navn;
	}
	
	@Override
	public void run() {
		try {
			while (true) {
				Thread.sleep((int) (Math.random() * 4000) + 2000);
				Hamburger hamburger = new Hamburger(hamburgerNummer++);
				brett.put(hamburger);
				System.out.println(navn + "(kokk) legger på hamburger " + hamburger + ". Brett " + brett);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
