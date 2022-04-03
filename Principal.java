// --------------------> Principal (static vesion)

class Principal{
	public static void main(String[] args){
		TRacional r1 = new TRacional(-4,2);
		TRacional r2 = new TRacional(2,4);
		TRacional r3 = new TRacional();
		
		//SUMA
		r3 = TRacional.sumaRacional(r1,r2);
		r3.simplificaRacional();
		System.out.println(r1.toString() + " + " + r2.toString() + " = " + r3.toString());
		
		//RESTA
		r3 = TRacional.restaRacional(r1,r2);
		r3.simplificaRacional();
		System.out.println(r1.toString() + " - " + r2.toString() + " = " + r3.toString());
		
		//MULTIPLICACION
		r3 = TRacional.multiplicaRacional(r1,r2);
		r3.simplificaRacional();
		System.out.println(r1.toString() + " * " + r2.toString() + " = " + r3.toString());
		
		//DIVISION
		r3 = TRacional.divideRacional(r1,r2);
		r3.simplificaRacional();
		System.out.println(r1.toString() + " \u00f7 " + r2.toString() + " = " + r3.toString());
		
	}//FIN MAIN
	
}//FIN CALSE PRINCIPAL
