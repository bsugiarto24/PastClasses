/**
 *TotemPole
 *@author Bryan Sugiarto
 *@version lab15
 */

public interface TotemPole {

	public int power();  // the total power of the pole
	public int height(); // the number of heads in the pole
	public boolean chiefPole(int bearCount);  // is this pole worthy of a chief?
            // bearCount is how many bears encountered in a row so far
}
