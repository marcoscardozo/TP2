package tp;

public class Recursion {

	public static int minimo(int[] arr) {
		if (arr.length == 0)
			return 0;
		return minimo(arr, arr[0], 0);
	}

	private static int minimo(int[] arr, int min, int indice) {
		if (indice > arr.length - 1)
			return min;
		if (arr[indice] < min) {
			min = arr[indice];
			return minimo(arr, min, indice + 1);
		} else {
			return minimo(arr, min, indice + 1);
		}
	}
	public static int divisionSustractiva(int dividendo, int divisor) {
		if(divisor > dividendo)
			return 0;
		return divisionSustractiva(dividendo-divisor, divisor) + 1;
	}
	private static int divisionSustractiva(int dividendo, int divisor, int cont) {
		if(dividendo < divisor) // caso base
			return cont;
		return divisionSustractiva(dividendo-divisor, divisor, cont + 1);
	}	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arreglo = { 1, 2, 3, 4, -1, -4, 99};
//		System.out.println(minimo(arreglo));
//		System.out.println(divisionSustractiva(129, 129));
		int x = 2476; 
		int cont = 0;
		for (int i = 0; i <4 ; i++) {
			x = x / 10;
			cont = cont + x;
			System.out.println(x);			
		}
		System.out.println( 276 % 10 / 10);
	}

}
