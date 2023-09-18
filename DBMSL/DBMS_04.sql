/*
DBMS Exp No.4 :- Unnamed PL/SQLcode block
Problem Statement 4 :-
Borrow(Roll_no, Name, DateofIssue, NameofBook, Status) 
Fine(Roll_no,Date,Amt)
Accept roll_no & name of book from user. Check the number of days (from date of issue), if days are between 15 to 30 then fine amount 
will be Rs 5 per day. If no. of days>30, per day fine will be Rs 50 per day & for days less than 30, Rs. 5 per day. After submitting the book, 
status will change from I to R. If condition of fine is true, then details will be stored into fine table. Also handles the exception by named 
exception handler or user define exception.
*/

create database library;
use library;
create table Fine(roll_no int,Date date,Amount int);
desc Fine;
create table Borrower(roll_no int AUTO_INCREMENT,Name varchar(50),Date_of_issue date,Book_name varchar(50),Status varchar(10),primary key(roll_no));
insert into Borrower(Name,Date_of_issue,Book_name,Status) values ("Himanshu",'2017-06-15',"SPM","Issued"), 
-> ("Abhay",'2023-08-17',"HCI","Issued"),
-> ("Pooja",'2023-06-13',"CN","Issued"),
-> ("Geeta",'2023-08-20',"TOC","Issued"),
-> ("Kalyani",'2023-06-24',"SPOS","Issued"),
-> ("Ritesh",'2023-4-13',"DBMS","Issued");
select* from Borrower;
delimiter $$
create procedure studfine(roll int,nm varchar(50))
-> begin
-> declare i_date date;
-> declare diff int;
-> declare fine_amt int;
-> DECLARE EXIT HANDLER FOR SQL EXCEPTION SELECT "Table not found";
-> select Date_of_issue into i_date from Borrower where roll_no=roll and Name=nm;
-> select DATEDIFF(CURDATE(),i_date)into diff;
-> if(diff>=15 and diff<=30)
-> then
-> set fine_amt=diff*5;
-> insert into Fine values(roll,CURDATE(),fine_amt);
-> elseif(diff>30)
-> then
-> set fine_amt=diff*50;
-> insert into Fine values(roll,CURDATE(),fine_amt);
-> end if;
-> update Borrower set Status="Return" where roll_no=roll and Name=nm;
-> end $$
call studfine(6,"Ritesh");
-> $$
select*from Borrower;
-> $$
select * from Fine;
-> $$
