/*
DBMS Exp No.3
Activity to be Submitted by Students
Design SQL queries for suitable database application using SQL DML statements: 
all types of Join, Sub-Query and View.
*/

/*
1.Create following Tables
cust_mstr(cust_no,fname,lname)
add_dets(code_no,add1,add2,state,city,pincode)
Retrieve the address of customer Fname as 'xyz' and Lname as 'pqr'.
*/

create database bank;
use Bank;
create table cust_mstr(cust_no int,fname varchar(100),lname varchar(100));
select * from cust_mstr; 
select * from add_dets; 
select * from cust_mstr inner join add_dets oncust_mstr.cust_no=add_dets.code_no where fname='xyz' and lname='pqr';

/*
2.Create following Tables
cust_mstr(custno,fname,lname) 
acc_fd_cust_dets(codeno,acc_fd_no)
fd_dets(fd_sr_no,amt)
List the customer holding fixed deposit of amount more than 5000.
*/

select * from acc_fd_cust_dets; 
select * from fd_dets; 
select * from cust_mstr join fd_dets on cust_mstr.cust_no=fd_dets.fd_sr_no where amt>5000;
 
/*
3. Create following Tables
emp_mstr(e_mpno,f_name,l_name,m_name,dept,desg,branch_no)
branch_mstr(name,b_no)
List the employee details along with branch names to which they belong
*/

select * from emp_mstr;
select * from branch_mstr;
select * from emp_mstr join branch_mstr on emp_mstr.branch_no=branch_mstr.b_no; 

/*
4. Create following Tables
emp_mstr(emp_no,f_name,l_name,m_name,dept)
cntc_dets(code_no,cntc_type,cntc_data) 
List the employee details along with contact details using left outer join & right join.
*/

select * from cntc_dets;
select * from emp_mstr left join cntc_dets on emp_mstr.e_mpno=cntc_dets.code_no;
select * from emp_mstr right join cntc_dets on emp_mstr.e_mpno=cntc_dets.code_no;
 
/*
5. Create following Tables 
cust_mstr(cust_no,fname,lname) 
add_dets(code_no,pincode) 
List the customer who do not have bank branches in their vicinity.
*/

select * from cust_mstr;
select * from add_dets; 
select * from cust_mstr where cust_no not in (select code_no from add_dets,branch_mstr 
where add_dets.pincode=branch_mstr.pincode);
 
/*
6. a) Create View on borrower table by selecting any two columns and 
      perform insert update delete operations
*/

create view VIEW as select cust_name,loan_no from Borrower;
select * from VIEW;
insert into view values("Ram",8);
update view set loan_no=9 where cust_name="Vaibhav";
delete from view where loan_no=2;
 
/*
b) Create view on borrower and depositor table by selecting any one column from each table 
   perform insert update delete operations.
*/

create view OH(loan_no,cust_name) as select Borrower.loan_no,Borrower.cust_name from Borrower,Depositor
where Borrower.loan_no=Depositor.acc_no;
select * from OH;
insert into OH(loan_no,cust_name) values(5,"Jay");
select * from OH;
update OH set loan_no=8 where cust_name="Aniket";
select * from OH; 
 
/* 
c) create updateable view on borrower table by selecting any two columns and perform insert, 
   update and delete operations.
*/

create view my_view as select cust_name,loan_no from Borrower;
select * from my_view;
insert into my_view values("chetan",10);
select * from my_view;
update my_view set loan_no=11 where cust_name="Ram";
select * from my_view; 
delete from my_view where loan_no=5;
select * from my_view;
