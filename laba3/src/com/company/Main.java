package com.company;

public class Main {

	public static void main(String[] args) {
		
		int n = 6;
		
		double X = 0;
		double [] x = new double[n];
		double [] f = new double[n];
		double [][] y = new double[n][n];
		
		Logic L = new Logic();

		X = -0.2;
		
		x[0] = -1.2;
		x[1] = -0.6;
		x[2] = 0.5;
		x[3] = 1.5;
		x[4] = 1.9;
		x[5] = 2.6;
		
		f[0] = 3.38688;
		f[1] = -4.35456;
		f[2] = 11.71875;
		f[3] = 29.53125;
		f[4] = 26.00169;
		f[5] = 6.88896;
		
		y = L.div_sub(x,f,y,n);						// вычисление разделённых разностей функции
		L.print_matr(y,n);							// вывод матрицы разделённых разностей
		
													// вычисление и вывод значения полинома Ньютона
		System.out.println("\nПолином Лагранжа= " + L.Lagrange(X, x, f, y, n));
		System.out.println("Полином Ньютона NF= " + L.NewtonNF(X, x, f, y, n));
		System.out.println("Полином Ньютона NB= " + L.NewtonNB(X, x, f, y, n));
	}

}
