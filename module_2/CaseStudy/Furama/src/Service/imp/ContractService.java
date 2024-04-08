package Service.imp;

import java.util.List;
import java.util.Scanner;

import Model.Contract;
import Repo.Interface.IContractRepository;
import Repo.imp.ContractRepository;
import Service.Interface.IContractService;

public class ContractService implements IContractService {
	private IContractRepository contractRepo = new ContractRepository();
	Scanner sc = new Scanner(System.in);
	@Override
	public void displayAll() {
		// TODO Auto-generated method stub
		List<Contract> contractList = contractRepo.getAll();
		for(Contract c : contractList) {
			System.out.println(c);
		}
	}

	@Override
	public void add() {
		// TODO Auto-generated method stub
		try {
			System.out.print("Input Booking Code : ");
			String bookingCode = sc.nextLine();
			System.out.println("Input contract number :");
			String contractNumber = sc.nextLine();
			System.out.println("Input depsoit number : ");
			double depsoitNumber = Double.parseDouble(sc.nextLine());
			System.out.println("Input total payment : ");
			double totalNumber = Double.parseDouble(sc.nextLine());
			Contract contract = new Contract(bookingCode,contractNumber,depsoitNumber,totalNumber);
			contractRepo.add(contract);
		    System.out.println("--------Add New Contract Successful-------");

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Failed to add a new contract");
		}
		

	}

	@Override
	public void editByID() {
		// TODO Auto-generated method stub
		
	}

}
