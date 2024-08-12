# Expense-Tracker

<h6>The code is a Java-based console application designed to help users track their expenses. The application is divided into three main classes: Expense, ExpenseManager, and ExpenseTracker. Each class has specific responsibilities in managing and interacting with the expense data. Here's a detailed explanation:</h6>

<h3>1. Expense Class:</h3>
<h6>The Expense class is a simple data structure that holds information about a single expense. It implements the Serializable interface, which allows instances of the class to be serialized (converted into a byte stream) so they can be saved to a file.</h6>

<h4>Fields:</h4>
<h6>description: A String that holds a brief description of the expense.<br>
amount: A double that stores the monetary value of the expense.<br>
category: A String that categorizes the expense (e.g., "Food", "Transport").<br>
date: A Date object representing when the expense was incurred.</h6>

<h4>Constructor:</h4>
<h6>Initializes all the fields with the values provided when an Expense object is created.</h6>

<h4>Methods:</h4>
<h6>toString(): This method returns a string representation of the Expense object, which is useful for printing the object details.<br>
Getter methods (getDescription(), getAmount(), getCategory(), getDate()): These methods allow access to the private fields of the Expense class.</h6>
