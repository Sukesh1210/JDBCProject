package com.jspiders.cardekhocasestudy.main;

import java.util.Scanner;

import com.jspiders.cardekhocasestudy.operation.CarOperation;

public class CarMain {
	private static CarOperation carOperation=new CarOperation();
	private static Scanner scanner=new Scanner(System.in);
	
	
	public static void main(String[] args) {
		boolean flag=true;
		while(flag) {
			System.out.println("===================");
			System.out.println("Enetr 1 to add car \nEnetr 2 to Search car by id\nEnetr 3 to fetch all cars"
					+ "\nEnetr 4 to delete car\nEnetr 5 to update car\nEnetr 6 to exit");
			System.out.println("Enter your choice ");
			System.out.println("===================");
			int choice=scanner.nextInt();
			
			
			switch (choice) {
			case 1:
				carOperation.addCar(scanner);
				break;
			case 2:
				carOperation.findCarById(scanner);
				break;
			case 3:
				carOperation.getAllCars(scanner);
				break;
			case 4:
				carOperation.deleteCar(scanner);
				break;
			case 5:
				carOperation.updateCar(scanner);
			break;
			case 6:
				flag=false;
				System.out.println("Thank you");
				break;

			default:
				System.out.println("Invalid choice");
			}
		}
	}

}
