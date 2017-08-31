package Polinomio;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Polinomio {
	
	Integer grado;
	Integer[] vector;
	
	public Polinomio() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			String lec = br.readLine();
			// 5x^3+3x^2-1
			// 10x^7+6x^5+8
			String[] terminos = separarPolinomio(lec);
			grado = getGrado(terminos[0]);
			vector = new Integer[grado + 2];
			setPolinomio(terminos);
			for(int i = 0; i < vector.length; i++) {
				System.out.print(vector[i] + " ");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String[] separarPolinomio(String cad) {
		List<String> term = new ArrayList<>();
		int beginIndex = 0;
		for(int i = 0; i < cad.length(); i++) {
			if (cad.charAt(i) == '+') {
				term.add(cad.substring(beginIndex, i));
				beginIndex = i + 1;
			} else if (cad.charAt(i) == '-') {
				if (cad.charAt(i - 1) != '^') {
					term.add(cad.substring(beginIndex, i));
					beginIndex = i;
				}
			}
		}
		term.add(cad.substring(beginIndex, cad.length()));
		System.out.println(term);
		
		String[] arr = new String[term.size()];
 		return term.toArray(arr);
	}
	
	public int getGrado(String ter) {
		return Character.getNumericValue(ter.charAt(ter.indexOf('^') + 1));
	}
	
	public void setPolinomio(String[] terminos) {
		vector[0] = grado;
		for(String termino : terminos) {
			int coeficiente = 0, exponente = 0;
			for(int i = 0; i < termino.length(); i++) {
				if (Character.isAlphabetic(termino.charAt(i))) {
					coeficiente = Integer.parseInt(termino.substring(0, i));
				} else if (termino.charAt(i) == '^') {
					exponente = Integer.parseInt(termino.substring(i + 1, termino.length()));
				}
			}
			vector[(grado + 1) - exponente] = coeficiente;
		}
		for(int i = 0; i < vector.length; i++) {
			if (vector[i] == null) {
				vector[i] = 0;
			}
		}
	}
	
	public static void main(String[] args) {
		System.out.println("Ingrese un polinomio bien shimbita pues mi pá:");
		new Polinomio();
	}
}
