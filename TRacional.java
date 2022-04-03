// --------------------> TRacional (static vesion)

class TRacional{
	//****ATRIBUTOS****
	private int num,den;
	
	//****METODOS****
	//CONSTRUCTORES
	TRacional(){
		num = 0;
		den = 1;
	}
	
	TRacional(int num, int den){
		this.num = num;
		if(den!=0)
			this.den = den;
		else
			this.den = Integer.MIN_VALUE;
		
	}

	//METODOS SET
	public void setNumerador(int num){
		this.num = num;
	}
	
	public void setDenominador(int den){
		this.den = den;
	}
	
	//METODOS GET
	public int getNumerador(){
		return num;
	}
	
	public int getDenominador(){
		return den;
	}
	
	//METODOS DIVERSOS
	
	private int mcd(int a, int b){
		if(b == 0)
			return a;
		else
			return mcd(b, a%b);
		
	}
	
	public void simplificaRacional(){
		int MCD;
		
		if(num>den)
			MCD = mcd(num,den);
		else
			MCD = mcd(den,num);
		num = num/MCD;
		den = den/MCD;
	}
	
	@Override
	public String toString(){
		String cadena;
		
		//SOLUCION DENOMINADOR NEGATIVO
		if(den<0){
			den = den*-1;
			num = num*-1;
		}
		
		if(den == 1){
			cadena = Integer.toString(num);
		}
		else if(num == 0){
			cadena = "0";
		}
		else{
			cadena = Integer.toString(num) + "/" + Integer.toString(den);
		}
		return cadena;
	}

	//SUMA
	public static TRacional sumaRacional(TRacional num1, TRacional num2){
		TRacional res = new TRacional();
		int numerador, denominador;
		
		numerador = num1.getNumerador()*num2.getDenominador() + num1.getDenominador()*num2.getNumerador();
		denominador = num1.getDenominador()*num2.getDenominador();
		
		res.setNumerador(numerador);
		res.setDenominador(denominador);
		return res;
	}
	
	//RESTA
	public static TRacional restaRacional(TRacional num1, TRacional num2){
		TRacional res = new TRacional();
		int numerador, denominador;
		
		numerador = num1.getNumerador()*num2.getDenominador() - num1.getDenominador()*num2.getNumerador();
		denominador = num1.getDenominador()*num2.getDenominador();
		
		res.setNumerador(numerador);
		res.setDenominador(denominador);
		return res;
	}
	
	//PRODUCTIO
	public static TRacional multiplicaRacional(TRacional num1, TRacional num2){
		TRacional res = new TRacional();
		int numerador, denominador;
		
		numerador = num1.getNumerador()*num2.getNumerador();
		denominador = num1.getDenominador()*num2.getDenominador();
		
		res.setNumerador(numerador);
		res.setDenominador(denominador);
		return res;
	}
	
	//DIVISION
	public static TRacional divideRacional(TRacional num1, TRacional num2){
		TRacional res = new TRacional();
		int numerador, denominador;
		
		numerador = num1.getNumerador()*num2.getDenominador();
		denominador = num1.getDenominador()*num2.getNumerador();
		
		res.setNumerador(numerador);
		res.setDenominador(denominador);
		return res;	
	}
}//FIN CLASE RACIONAL
