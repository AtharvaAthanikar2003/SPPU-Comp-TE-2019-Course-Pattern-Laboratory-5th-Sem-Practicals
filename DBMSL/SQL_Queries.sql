/*
DBMS Exp No.2
Activity to be Submitted by Students
(Insert, Select, Update, Delete, operators, functions, setoperator, all constraints, view, index, synonym, sequence) 
Create following relations and excecute the queries given below.
Account(Acc_no,Branch_Name,Balance)
Branch(Branch_Name,Branch_City,Assets)
Customer(Cust_Name,Cust_Street,Cust_City)
Depositor(Cust_Name,Acc_No)
Loan(Loan_No,Branch_Name,Amount)
Borrower(Cust_Name,Loan_No)
*/

create database Bank;
use Bank;
select * from Account;
select * from Branch; 
select * from Customer; 
select * from Depositor; 
select * from Loan; 
select * from Borrower;
 
--1. Find the names of all branches in loan relation.
select branch_name from Loan;
 
--2. Find all loan numbers for loans made at Akurdi Branch with loan amount > 12000.
select loan_No from Loan where branch_name='akurdi' and amount>12000;
 
--3. Find all customers who have a loan from bank. Find their names,loan_no and loan amount.
select Loan.loan_no,cust_name,amount from Loan,Borrower where Loan.loan_no=Borrower.loan_no;
 
--4.List all customers in alphabetical order who have loan from Akurdi branch.
select loan.loan_no,cust_name,amount from Loan,Borrower where Loan.loan_no=Borrower.loan_no and branch_name='akurdi' order by cust_name asc;
 
--5. Find all customers who have an account or loan or both at bank.
select cust_name from Borrower union select cust_name from Depositor;
 
--6. Find all customers who have both account and loan at bank.
select cust_name from Borrower where cust_name in(select cust_name from Depositor); 
--7.Find all customer who have account but no loan at the bank.
select cust_name from Depositor where cust_name not in(select cust_name from Borrower);
 
--8. Find average account balance at Akurdi branch.
select branch_name,avg(balance) from Account where branch_name='akurdi';
 
--9. Find the average account balance at each branch
select branch_name,avg(balance) from Account group by branch_name;
 
--10. Find no. of depositors at each branch.
select branch_name,count(Account.Acc_No) from Depositor,Account where Depositor.acc_No=Account.Acc_No group by branch_name;

--11. Find the branches where average account balance > 12000.
select branch_name,avg(balance) from Account group by branch_name having avg(balance)>12000;

--12. Find number of tuples in customer relation.
select count(*) from Customer;

--13. Calculate total loan amount given by bank.
select sum(Amount) from Loan;

--14. Delete all loans with loan amount between 1300 and 1500.
delete from Loan where Amount>900 and Amount<2500;
select* from Loan;
delete from Branch where branch_name='nigdi';
select * from Branch;
