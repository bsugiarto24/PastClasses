/**
 *TEST
 *@author Bryan Sugiarto
 *@version Lab6
 */

public class Tests {

	public static void main(String[] args) {
		D d = new D();
		B b = new E();
		A a = new D();
		C c = new C();
		E e = new E();
		
		//d .methodD((D)b); //S
		//d = a;            //DNC
		b = new E();        //A
		//b = (D)c;         //DNC
		//b.methodD(d);     //DNC
		//((D)b).methodD(d);//S 
		a = c;              //A   
		b.methodB();        //A
		//b = new B();      //DNC
		e.methodB();        //A


	}

}
