package oppg_3;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class HamburgersjappeBQ {

	public static void main(String[] args) {
		final String[] kokker = {"Anne", "Erik", "Knut"};
		final String[] servitorer = {"Mia", "Per"};
		final int KAPASITET = 4;
        System.out.println("I denne simuleringen har vi\n     3 kokker " 
		        + java.util.Arrays.toString(kokker) 
		        + "\n     2 servitører " 
		        + java.util.Arrays.toString(servitorer) 
        		+ "\nKapasiteten til brettet er " 
        		+ KAPASITET 
        		+ " hamburgere.\nVi starter ...");
        
        BlockingQueue<Hamburger> brett = new ArrayBlockingQueue<>(KAPASITET);
        
        for (String navn : kokker) {
        	new KokkBQ(brett, navn).start();
        }
        for (String navn : servitorer) {
        	new ServitorBQ(brett, navn).start();
        }
	}
}