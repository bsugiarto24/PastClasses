/**
  *Fraction
  *@author Bryan Sugiarto
  *@version Program1b
  */
  
  
public class Fraction{

   private int den;
   private int num;

   public Fraction(){
      den = 1;
      num = 0;
   }
   
   public Fraction(int numerator){
      den = 1;
      num = numerator;
   }
   
   public Fraction(int numerator,
      int denominator){
      if(denominator ==0){
         throw new IllegalArgumentException(
         "Denominator is Zero");
      }else if(denominator<0){
         num = -numerator;
         den = -denominator;
      }else{
         num = numerator;
         den = denominator;
      } 
      reduce();
   }

   public int getNumerator(){
      return num;
   }

   public int getDenominator(){
      return den;
   }
   
   public double value(){
      return (double)num/den;
   }
   
   public java.lang.String toString(){
      if(den==1)
         return ""+num;
      return num+"/"+den;
   }
   
   public boolean equals(java.lang.Object other){
      if(!(other instanceof Fraction))
         return false;
      else if(this==other)
         return true;
      else if(den==((Fraction)other).getDenominator()
              && num ==((Fraction)other).getNumerator())
         return true;
      return false;
   }
 
   public Fraction add(Fraction other){
	  int d = gcd(den,other.getDenominator());
      return new Fraction(num*other.getDenominator()/d+
    		  other.getNumerator()*den/d,
    		  den*other.getDenominator()/d);
   }
   
   public Fraction sub(Fraction other){
      return this.add(other.mul(new Fraction(-1)));
   }
   
   public Fraction mul(Fraction other){
      return new Fraction(num*other.getNumerator()
    		  ,den*other.getDenominator());
   }
   
   public Fraction div(Fraction other){
	   return new Fraction(num*other.getDenominator()
	    		  ,den*other.getNumerator());
   }
   
   private int gcd(int a, int b){
	   int i = 1;
	   int l = 1;
	   while(i<=Math.abs(a) && i<=Math.abs(b)){
		   if(a%i==0 && b%i==0)
			   l = i;
		   i++;
	   }
	   return l;
   }
   
   private void reduce(){
	   int g = gcd(num,den);
	   num/=g;
	   den/=g;
      if(num==0)
         den = 1;
   }
   
   
}