RuralBankAccount
Use of OOP concept
1.	Abstraction
We define an abstract class BankAccount that acts as the blueprint for all types of bank accounts.
•	The Common attributes in this class are:
	accountHolderName
	accountNumber
	balance


•	The Common methods of this class are:
	deposit()
	getDetails()
•	The Abstract method in this class is:
	withdraw(double amount),implemented differently in each subclass.
2.	Inheritance
Two classes ie SavingsAccount and CurrentAccount inherit from BankAccount:
•	SavingsAccount: Restricts withdrawals to balance and allows interest application.
•	CurrentAccount: Allows overdraft up to a certain limit.
This reduces code duplication and supports reusability.
3.	Encapsulation
All class attributes are marked private or protected. They are accessed or modified through:
•	Getters/setters (example; getBalance())
•	Properly encapsulated logic inside methods like withdraw() or deposit()

4.	Polymorphism
The program uses dynamic (runtime) polymorphism:
•	A BankAccount reference can point to either a SavingsAccount or CurrentAccount object.
•	The correct version of withdraw() is called at runtime using method overriding.
5.	Aggregation
A Customer class holds a list of BankAccount objects, representing the "has-a" relationship:
•	A customer can have multiple accounts (savings and current).
•	Accounts are not part of the Customer class directly, but is referenced.

Custom Exception Handling Implementation
SufficientBalanceException.java
A user-defined exception class that extends Exception. It handles two cases:
•	When a withdrawal from a savings account exceeds the current balance
•	When a withdrawal from a current account exceeds the allowed overdraft limit
This promotes safe banking practices and makes the system more user-friendly.
