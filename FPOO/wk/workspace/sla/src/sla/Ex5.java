package sla;
//5 - Fa�a um programa que leia e monte dois vetores de n�meros inteiros com 20 n�meros cada. Depois de montados gere um terceiro vetor formado pela diferen�a dos 
//dois vetores lidos, um quarto vetor formado pela soma dos dois vetores lidos e por �ltimo um quinto vetor formado pela multiplica��o dos dois vetores lidos.

import java.util.Random;
import java.util.Scanner;

public class Ex5 {
	static Scanner scan = new Scanner(System.in);
	static Random r = new Random();
	public static void main(String[] args) {
	int v1[]=new int[20];
	int v2[]=new int[20];
	int v3[]=new int[20];
	int v4[]=new int[20];
	int v5[]=new int[20];
		for(int i=0;i<v1.length;i++) {
			v1[i]=r.nextInt(10);
			v2[i]=r.nextInt(10);
		}
		for(int i=0;i<v1.length;i++) {
			v3[i]=v1[i]-v2[i];
			v4[i]=v1[i]+v2[i];
			v5[i]=v1[i]*v2[i];
		}
		System.out.println("1� vetor");
		for(int i=0;i<v1.length;i++) {
			System.out.print(v1[i]+"\t");
		}
		System.out.println("\n2� vetor");
		for(int i=0;i<v1.length;i++) {
			System.out.print(v2[i]+"\t");	
			}
		System.out.println("\n3� vetor");
		for(int i=0;i<v1.length;i++) {
			System.out.print(v3[i]+"\t");
		}
		System.out.println("\n4� vetor");
		for(int i=0;i<v1.length;i++) {
			System.out.print(v4[i]+"\t");
		}
		System.out.println("\n5� vetor");
		for(int i=0;i<v1.length;i++) {
			System.out.print(v5[i]+"\t");	
		}
	}
}
