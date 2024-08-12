# Expense-Tracker

<h6>The code is a Java-based console application designed to help users track their expenses. The application is divided into three main classes: Expense, ExpenseManager, and ExpenseTracker. Each class has specific responsibilities in managing and interacting with the expense data. Here's a detailed explanation:</h6>

<h3>1. Expense Class:</h3>
<h6>The Expense class is a simple data structure that holds information about a single expense. It implements the Serializable interface, which allows instances of the class to be serialized (converted into a byte stream) so they can be saved to a file.</h6>

<h4>Fields:</h4>
<h6>description:  A String that holds a brief description of the expense.<br>
amount:  A double that stores the monetary value of the expense.<br>
category:  A String that categorizes the expense (e.g., "Food", "Transport").<br>
date:  A Date object representing when the expense was incurred.</h6>

<h4>Constructor:</h4>
<h6>Initializes all the fields with the values provided when an Expense object is created.</h6>

<h4>Methods:</h4>
<h6>toString(): This method returns a string representation of the Expense object, which is useful for printing the object details.<br>
Getter methods (getDescription(), getAmount(), getCategory(), getDate()): These methods allow access to the private fields of the Expense class.</h6>

-------------------------------------------------------------------------------------------------------------------------------------------------------------------------

<h3>2. ExpenseManager Class:</h3>
<h6>The ExpenseManager class is responsible for managing a collection of Expense objects. It provides functionality to add, view, categorize, and save/load expenses.</h6>

<h4>Fields:</h4>
<h6>expenses: A List<Expense> that stores all the expenses. This is the main data structure used by the application to keep track of expenses.</h6>
  
<h4>Constructor:</h4>
<h6>Initializes the expenses list and calls the loadExpenses() method to load any previously saved expenses from a file.</h6>

<h4>Methods:</h4>
<h6>addExpense(Expense expense):</h6>
<h6>Adds a new Expense object to the expenses list.<br>
Calls saveExpenses() to persist the updated list to a file.</h6>

<h6>Viewexpenses():</h6>
<h6>Returns a new ArrayList containing all the expenses. This prevents external code from modifying the original list.<h6>

<h6>getExpensesByCategory(String category):</h6>
<h6>Filters the expenses list to return only those that match the specified category.</h6>

<h6>getTotalExpenses():</h6>
<h6>Iterates through the expenses list and sums up the amount of each expense. Returns the total.</h6>

<h6>saveExpenses():</h6>
<h6>Serializes the expenses list and saves it to a file named expenses.dat. If an IOException occurs, an error message is printed.</h6>

<h6>loadExpenses():
<h6>Tries to load the expenses.dat file. If the file exists, it deserializes the content back into the expenses list.<br>
If the file is not found, it initializes the list as empty and prints a message indicating no previous data was found.</h6>
