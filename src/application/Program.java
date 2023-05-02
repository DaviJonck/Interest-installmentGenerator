package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import entities.Contract;
import entities.Installment;
import services.ContractService;
import services.PaypalService;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		System.out.println("Enter the contract Data: ");
		
		System.out.println("Contract Number: ");
		int number = sc.nextInt();
		System.out.println("Date (dd/MM/yyyy): ");
		LocalDate date = LocalDate.parse(sc.next(), fmt);
		System.out.println("Contract Value: ");
		double contractValue = sc.nextDouble();
		Contract obj = new Contract(number,date,contractValue);
		System.out.println("Number of Installments: ");
		int n = sc.nextInt();
		
		
		ContractService contractService = new ContractService(new PaypalService());
		
		contractService.processContract(obj,n);
		for(Installment installment : obj.getInstalments()) {
			System.out.println(installment);
		}
		System.out.println("installments: ");
		
		
		
		
		
		
		
		
		
		
	sc.close();	
	} 

}
