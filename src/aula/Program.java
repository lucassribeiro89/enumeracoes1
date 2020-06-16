package aula;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import entities.Department;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevel;

public class Program {

	public static void main(String[] args) throws ParseException {


		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Digite o nome do departamento: ");
		String dapartment = sc.nextLine();
		System.out.println("Digite os dados do funcionário:");
		System.out.print("Nome: ");
		String workerName = sc.nextLine();
		System.out.print("Nível: ");
		String workerLevel = sc.nextLine();
		System.out.print("Salário Base: ");
		double baseSalary = sc.nextDouble();
		Worker worker = new Worker(workerName, WorkerLevel.valueOf(workerLevel), baseSalary, new Department(dapartment));
		System.out.print("Quantos contratos possui o trabalhador? ");
		int n = sc.nextInt();
		for (int i=1; i<=n; i++) {
			System.out.println("Digite os dados do contrato n#" + i + " :");
			System.out.print("Data (dd/mm/aaaa): ");
			Date contractDate = sdf.parse(sc.next());
			System.out.print("Valor por hora: ");
			double valuePerHour = sc.nextDouble();
			System.out.println("Duração em horas: ");
			int hours = sc.nextInt();
			HourContract contracts = new HourContract(contractDate, valuePerHour, hours);
			worker.addContract(contracts);
		}
		System.out.println();
		
		System.out.print("Digite o mês e o ano para calcular o valor total (mm/aaaa): ");
		String monthAndYear = sc.next();
		int c_month = Integer.parseInt(monthAndYear.substring(0, 2));
		int c_year = Integer.parseInt(monthAndYear.substring(3));	
		System.out.println("Nome: " + worker.getName());
		System.out.println("Departamento: " + worker.getDepartment().getName());
		System.out.println("Valor total para " + monthAndYear + " :" + String.format("%.2f", worker.income(c_year, c_month)));
			
		
		sc.close();

	}

}
