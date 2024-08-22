package com.expensetracker;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Expense implements Serializable {
	private static final long serialVersion=1L;
	private String description;
	private double amount;
	private String category;
	private Date date;
	
	
	public Expense(String description, double amount, String category, Date date) {
		super();
		this.description = description;
		this.amount = amount;
		this.category = category;
		this.date = date;
	}


	@Override
	public String toString() {
		return "Expense [description=" + description + ", amount=" + amount + ", category=" + category + ", date="
				+ date + "]";
	}


	public static long getSerialversion() {
		return serialVersion;
	}


	public String getDescription() {
		return description;
	}


	public double getAmount() {
		return amount;
	}


	public String getCategory() {
		return category;
	}


	public Date getDate() {
		return date;
	}
	
	
}

//Class to manage expense
class ExpenseManager
{
	private List<Expense> expenses;
	public ExpenseManager() {
		expenses =new ArrayList<>();
		loadExpenses();
	}

	// method to addExpense
	public void addExpense(Expense expense)
	{
		expenses.add(expense);
		saveExpenses();
	}
	
	//Method to view all expencses
	public List<Expense> Viewexpenses()
	{
		return new  ArrayList<>(expenses);
	}
	
	// Method to get expenses category
	public List<Expense> getExpensesByCategory(String category)
	{
		List<Expense> result=new ArrayList<>();
			for (Expense expense :expenses)
			{
				if(expense.getCategory().equalsIgnoreCase((category)))
				{
					result.add(expense);
				}
			}
			return result;			
	}
	
	//method to get total expenses
	public double getTotalExpenses()
	{
		double total=0;
		for (Expense expense:expenses)
		{
			total+=expense.getAmount();
		}
		return total;
	}
		
	// Method to save expenses to a file 
	private void saveExpenses() {
		try(ObjectOutputStream oos=new ObjectOutputStream (new FileOutputStream("expenses.dat")))
		{
			oos.writeObject(expenses);
		}
		catch(IOException e)
		{
			System.out.println("Error saving expenses : "+e.getMessage());
			
		}
	}
	
	// Method to load expenses from a file
	private void loadExpenses()
	{
		try(ObjectInputStream ois=new ObjectInputStream (new FileInputStream("expenses.dat")))
		{
			expenses=(List<Expense>)ois.readObject();
		}
		catch(FileNotFoundException e)
		{
			System.out.println("NO exixting data found,Starting new.");
		}
		catch(IOException | ClassNotFoundException e)
		{
			System.out.println("Error loading expenses : "+e.getMessage());
		}
	}
}

 class ExpenseTracker
{
	private static ExpenseManager manager=new ExpenseManager();
	
	//Method to display menu options
	public static void displayMenu()
	{
		System.out.println("\n Expense Tracker");
		System.out.println("1. Add expense");
		System.out.println("2. View expense");
		System.out.println("3. View expenses by category");
		System.out.println("4. View total expenses");
		System.out.println("5. Exit");
		System.out.println("Enter your choice");
	}
	
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		while(true)
		{
			displayMenu();
			int choice=scanner.nextInt();
			scanner.nextLine();
			
			switch (choice)
			{
			case 1: 
					// add a new expense
				System.out.println("Enter Description : ");
				String description= scanner.nextLine();
				System.out.println("enter amount : ");
				double amount=scanner.nextDouble();
				scanner.nextLine();
				System.out.println("enter category : ");
				String category =scanner.nextLine();
				Date date=new Date();
				Expense expense=new Expense(description, amount, category, date);
				manager.addExpense(expense);
				System.out.println("Expenses added successfully..!");
				break;
			
			case 2:
				//Viewing all expenses
				System.out.println("Listing all expenses : ");
				List<Expense> expenses=manager.Viewexpenses();
					if(expenses.isEmpty())
					{
						System.out.println("No expense recorded");
					}
					else 
					{
						for(Expense exp :expenses)
						{
							System.out.println(exp);
						}
					}
				break;
				
			case 3:
				// Viewing the expenses by category
				System.out.println("Enter category : ");
				category=scanner.nextLine();
				System.out.println("Listing expenses for category : "+category);
				expenses=manager.getExpensesByCategory(category);
				if(expenses.isEmpty())
				{
					System.out.println("No expenses found for this category");
					
				}
				else
				{
					for(Expense exp :expenses)
					{
						System.out.println(exp);
					}
				}
					
			case 4:
				//view total expenses
				System.out.println("Total expenses : "+manager.getTotalExpenses());
			
			case 5: 
				//existing the program
				System.out.println("Existing...!");
				scanner.close();
				return;
			
			default: 
				System.out.println("Invalid choice., please try again");
			}
			
			
		}
				
	}

}
