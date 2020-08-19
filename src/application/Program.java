package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Contract;
import entities.Installment;
import services.ContractService;
import services.OnlinePaymentService;
import services.PaypalService;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("Enter contract data: ");
		System.out.print("Number: ");
		int number = sc.nextInt();
		System.out.print("Data (dd/MM/yyyy): ");
		Date date = sdf.parse(sc.next());
		System.out.print("Contract value: ");
		double value = sc.nextDouble();
		
		Contract contrato = new Contract(number, date, value);

		System.out.print("Enter number of installments: ");
		int installmentNumber = sc.nextInt();		
		
		PaypalService servicoDePagamento = new PaypalService();
		
		ContractService processamento = new ContractService(servicoDePagamento);
		processamento.processContract(contrato, installmentNumber);
		
		System.out.println("Parcelas: ");
		for (Installment x : contrato.getInstallments()) {
			System.out.println(x);
		}

		
		
		
		sc.close();
	}

}
