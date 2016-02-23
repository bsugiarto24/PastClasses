/**
 *Bear
 *@author Bryan Sugiarto
 *@version lab15
 */
public class Bear implements TotemPole {
	
	private TotemPole r;
	
	public Bear(TotemPole rest){
		r = rest;
	}
	public int power() {
		return r.power()+5;
	}

	public int height() {
		return r.height()+1;
	}

	public boolean chiefPole(int bearCount) {
		if(bearCount==2)
			return true;
		return r.chiefPole(bearCount+1);
	}
	
}
