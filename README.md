# Expense-Tracker

<h6>The code is a Java-based console application designed to help users track their expenses. The application is divided into three main classes: Expense, ExpenseManager, and ExpenseTracker. Each class has specific responsibilities in managing and interacting with the expense data. Here's a detailed explanation:</h6>

<h3>1. Expense Class:</h3>
<h6>The Expense class is a simple data structure that holds information about a single expense. It implements the Serializable interface, which allows instances of the class to be serialized (converted into a byte stream) so they can be saved to a file.</h6>

<h4>Fields:</h4>
<h6><h5>description:</h5>  A String that holds a brief description of the expense.<br>
<h5>amount: </h5> A double that stores the monetary value of the expense.<br>
<h5>category: </h5> A String that categorizes the expense (e.g., "Food", "Transport").<br>
<h5>date: </h5> A Date object representing when the expense was incurred.</h6>

<h4>Constructor:</h4>
<h6>Initializes all the fields with the values provided when an Expense object is created.</h6>

<h4>Methods:</h4>
<h5>toString():</h5><h6>This method returns a string representation of the Expense object, which is useful for printing the object details.</h6>
<h5>Getter methods (getDescription(), getAmount(), getCategory(), getDate()): <h5><h6>These methods allow access to the private fields of the Expense class.</h6>

------------------------------------------------------------------------------------------------------------------------------------------------------------------------

<h3>2. ExpenseManager Class:</h3>
<h6>The ExpenseManager class is responsible for managing a collection of Expense objects. It provides functionality to add, view, categorize, and save/load expenses.</h6>

<h4>Fields:</h4>
<h5>expenses:</h5><h6> A List<Expense> that stores all the expenses. This is the main data structure used by the application to keep track of expenses.</h6>
  
<h4>Constructor:</h4>
<h6>Initializes the expenses list and calls the loadExpenses() method to load any previously saved expenses from a file.</h6>

<h4>Methods:</h4>
<h5>addExpense(Expense expense):</h5>
<h6>Adds a new Expense object to the expenses list.<br>
Calls saveExpenses() to persist the updated list to a file.</h6>

<h5>Viewexpenses():</h5>
<h6>Returns a new ArrayList containing all the expenses. This prevents external code from modifying the original list.<h6>

<h5>getExpensesByCategory(String category):</h5>
<h6>Filters the expenses list to return only those that match the specified category.</h6>

<h5>getTotalExpenses():</h5>
<h6>Iterates through the expenses list and sums up the amount of each expense. Returns the total.</h6>

<h5>saveExpenses():</h5>
<h6>Serializes the expenses list and saves it to a file named expenses.dat. If an IOException occurs, an error message is printed.</h6>

<h5>loadExpenses():</h5>
<h6>Tries to load the expenses.dat file. If the file exists, it deserializes the content back into the expenses list.<br>
If the file is not found, it initializes the list as empty and prints a message indicating no previous data was found.</h6>

------------------------------------------------------------------------------------------------------------------------------------------------------------------------

<h3>3. ExpenseTracker Class:</h3>
<h6>The ExpenseTracker class provides the user interface for the application. It allows users to interact with the ExpenseManager through a command-line menu.</h6>

<h4>Field:</h4>
<h6>manager: A static instance of ExpenseManager used to manage expenses.</h6>

<h4>Methods:</h4>
<h5>displayMenu():</h5>
<h6>Prints the menu options to the console. These options allow the user to add expenses, view expenses, view expenses by category, view the total amount of expenses, or exit the application.</h6>

<h4>main(String[] args):</h4>
<h6>The entry point of the application.<br>
Uses a Scanner object to read user input.<br>
Runs an infinite loop where it continuously displays the menu, gets the user's choice, and executes the corresponding action:</h6>

<h5>Add a new expense:</h5>
<h6>Prompts the user to enter details for the expense (description, amount, and category).<br>
Creates a new Expense object with the current date and passes it to the manager.addExpense() method.<br>
Notifies the user that the expense was added successfully.</h6>

<h5>View all expenses:</h5>
<h6>Calls manager.Viewexpenses() to retrieve all expenses.<br>
Prints each expense. If no expenses are recorded, a message is displayed.</h6>

<h5>View expenses by category:</h5>
<h6>Prompts the user to enter a category.<br>
Calls manager.getExpensesByCategory() with the specified category.<br>
Prints the filtered list of expenses. If no expenses match the category, a message is displayed.</h6>

<h5>View total expenses:</h5>
<h6>Calls manager.getTotalExpenses() and displays the total sum of all expenses.</h6>

<h5>Exit the application:</h5>
<h6>Breaks out of the loop and ends the program.</h6>

<h5>Default case:</h5>
<h6>Handles invalid input by prompting the user to try again.

------------------------------------------------------------------------------------------------------------------------------------------------------------------------

<h4>Summary of the Workflow:</h4>
<h6>The user runs the program, and the main menu is displayed.<br>
The user can add expenses, view all expenses, filter expenses by category, or view the total expenses.<br>
All data is saved to a file (expenses.dat) to persist between sessions.<br>
The program continuously loops until the user chooses to exit.<br>
This program provides a simple but effective way to manage personal expenses using a command-line interface.</h6>






