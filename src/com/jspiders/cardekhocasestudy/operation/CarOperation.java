package com.jspiders.cardekhocasestudy.operation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import com.jspiders.cardekhocasestudy.entity.Car;

public class CarOperation {
	private static Connection connection;
	private static PreparedStatement preparedStatement;
	private static String query;
	private static ResultSet resultSet;
	//private ArrayList<Car> cars=new ArrayList<>();

	public void addCar(Scanner scanner) {
		System.out.println("Enetr car id");
		int id=scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter car name");
		String name=scanner.nextLine();
		System.out.println("Enter car price");
		double price=scanner.nextDouble();
		try {
			openConnection();
			query="INSERT INTO car VALUES(?,?,?)";
			preparedStatement=connection.prepareStatement(query);
			preparedStatement.setInt(1, id);
			preparedStatement.setString(2, name);
			preparedStatement.setDouble(3, price);
			int res=preparedStatement.executeUpdate();
			if(res==1) {
				System.out.println("Car addded");
			}else {
				System.out.println("Not added");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
	}

	public  void findCarById(Scanner scanner) {
		System.out.println("Enter  car id");
		int id=scanner.nextInt();
		try {
			openConnection();
			query="SELECT * FROM car WHERE id=?";
			preparedStatement=connection.prepareStatement(query);
			preparedStatement.setInt(1, id);
			resultSet=preparedStatement.executeQuery();
			if(resultSet.next()) {
				System.out.println("Car id="+resultSet.getInt(1));
				System.out.println("Car name="+resultSet.getString(2));
				System.out.println("Car price="+resultSet.getDouble(3));
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
	public void getAllCars(Scanner scanner) {
		try {
			openConnection();
			query="SELECT * FROM car";
			preparedStatement=connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				System.out.println("Car id="+resultSet.getInt(1));
				System.out.println("Car name="+resultSet.getString(2));
				System.out.println("Car price="+resultSet.getDouble(3));
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
	}
	public void deleteCar(Scanner scanner) {
		System.out.println("Enetr car id to delete a car");
		int id=scanner.nextInt();
		try {
			openConnection();
			query="DELETE FROM car WHERE id=?";
			preparedStatement=connection.prepareStatement(query);
			preparedStatement.setInt(1, id);
			int res=preparedStatement.executeUpdate();
			if(res==1) {
				System.out.println("Car with id "+id+" is deleted");
				
			}else {
				System.out.println("Car not found");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
	}
	public void updateCar(Scanner scanner) {
		System.out.println("Enter car id");
		int id=scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter car name");
		String name=scanner.nextLine();
		System.out.println("Enter car price");
		double price=scanner.nextDouble();
		try {
			openConnection();
			query="UPDATE car SET name=?,price=? WHERE id=?";
			preparedStatement=connection.prepareStatement(query);
			preparedStatement.setString(1, name);
			preparedStatement.setDouble(2, price);
			preparedStatement.setInt(3, id);
			int res=preparedStatement.executeUpdate();
			if(res==1) {
				System.out.println("Car with id "+id+" is updated");
				
			}else {
				System.out.println("car is not updated");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
	private static void openConnection() throws SQLException {
		connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/weja4", "root", "root");
	}
	private static void closeConnection() throws SQLException {
		if(resultSet!=null) {
			resultSet.close();
			
		}
		if(preparedStatement!=null) {
			preparedStatement.close();
		}
		if(connection!=null) {
			connection.close();
		}
		
	}

	

	

	

}
