package com.company;

public class Logic {

	public double [][] div_sub(double [] x, double [] f, double [][] y, int n) {		// вычисление разделённых разностей функции
		
		for(int m = 1; m < n; m++) {
			for(int k = 0; k < n-m; k++) {
				if(m == 1) y[k][m] = (f[k+1] - f[k]) / (x[k+1]-x[k]);
				else y[k][m] = (y[k+1][m-1] - y[k][m-1]) / (x[k+m] - x[k]);
			}
		}
		return y;
	}
	
	public double Lagrange(double X, double [] x, double [] f, double [][] y, int n) {	// вычисление значения полинома Лагранжа
		
		double Lagrange = 0;
		double denominator = 1;															// знаменатель
		double numerator = 1;															// числитель
		
		for(int k=0; k<n; k++) {
			numerator = 1;
			for(int i=0; i<n; i++) {
				if(i != k) numerator *= (X-x[i]);
			}
			denominator = 1;
			for(int j=0; j<n; j++) {
				if(j != k) denominator *= (x[k] - x[j]);
			}
			Lagrange += f[k] * numerator/denominator;
		}
		
		return Lagrange;
	}
	
	public double NewtonNF(double X, double [] x, double [] f, double [][] y, int n) {	// вычисление значения полинома Ньютона NF
		
		double Newton = f[0];
		double prod = 1;
		
		for(int k=1; k<n; k++) {
			prod *= (X - x[k-1]);
			Newton += y[0][k] * prod;
		}
		return Newton;
	}
	
	public double NewtonNB(double X, double [] x, double [] f, double [][] y, int n) {	// вычисление значения полинома Ньютона NB
		
		double Newton = f[n-1];
		double prod = 1;
		
		for(int k=1; k<n; k++) {
			prod *= (X - x[n-k]);
			Newton += y[n-k-1][k] * prod;
		}
		return Newton;
	}

	public void print_matr(double [][] y, int n) {										// вывод матрицы в консоль
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(j>0 && (n%j-1) == 0)
					System.out.println(String.format("%.3f", y[i][j]) + "\t");
				else
					System.out.print(String.format("%.3f", y[i][j]) + "\t");
			}
		}
	}
	
}
