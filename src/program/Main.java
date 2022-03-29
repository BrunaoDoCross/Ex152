package program;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.Company;
import entities.Individual;
import entities.TaxPayer;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<TaxPayer> list = new ArrayList<>();

		System.out.print("Digite a quantidade de pagantes: ");
		int x = sc.nextInt();
		for (int i = 1; i <= x; i++) {
			System.out.println("\nPagante #" + i);
			System.out.print("Individual ou compania (i/c)? ");
			char c = sc.next().charAt(0);
			System.out.print("Nome: ");
			String name = sc.next();
			System.out.print("Renda anual: ");
			Double anualIncome = sc.nextDouble();
			if (c == 'i' || c == 'I') {
				System.out.print("Gastos na saúde: ");
				Double healthExpenditures = sc.nextDouble();
				list.add(new Individual(name, anualIncome, healthExpenditures));
			} else {
				System.out.print("Quantidade de funcionários: ");
				int numberOfEmployees = sc.nextInt();
				list.add(new Company(name, anualIncome, numberOfEmployees));
			}

		}
		System.out.println("\n\nImpostos pagos:");
		Double total = 0.0;
		for (TaxPayer payer : list) {
			total += payer.tax();
			System.out.println(payer.getName() + ": $ " + String.format("%.2f", payer.tax()));
		}
		System.out.println("\nImpostos totais: $ " + String.format("%.2f", total));
		sc.close();
	}
}
