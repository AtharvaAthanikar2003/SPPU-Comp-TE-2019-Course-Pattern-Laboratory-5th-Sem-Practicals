/*
DBMS Lab Exp No.7 :- Database Trigger (All Types: Row level and Statement level triggers, Before and After Triggers).
Write a database trigger on Library table. The System should keep track of the records that are being updated or deleted. 
The old value of updated or deleted records should be added in Library_Audit table.
*/

Create database lab_7;
Use lab_7;
Create table oldroll(roll int, Name varchar(50));
Insert into oldroll values(1,"Atharva");
Insert into oldroll values(2,"Swapnil");
Insert into oldroll values(3,"Gaurav");
Insert into oldroll values(4,"Niranjan");
Select * from oldroll;
Create table logtable(roll int, Name varchar(30),Date varchar(30));

Delimiter $$
Create trigger
-> update_value
-> after update
-> on oldroll
-> for each row
-> begin
-> insert into logtable values (old.roll,old.name,curdate());
-> end;
-> $$
Update oldroll set Name='Nihar' where roll=2; $$
Select * from logtable; $$
Delete from oldroll where Name='Niranjan'; $$
Select * from logtable; $$

Delimiter $$
Create trigger
-> delete_value
-> after delete
-> on oldroll
-> for each row
-> begin
-> insert into logtable values (old.roll,old.name,curdate());
-> end;
-> $$
Delete from oldroll where name='Swapnil'; $$
Select * from logtable; $$
