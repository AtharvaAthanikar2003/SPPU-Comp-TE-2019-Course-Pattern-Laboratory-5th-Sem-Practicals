/*
DBMS Lab Assignment No.6
Cursors: (All types: Implicit, Explicit, Cursor FOR Loop, Parameterized Cursor)
Write a PL/SQL block of code using parameterized Cursor that will merge the data available in the newly created table N_RollCall with the 
data available in the table O_RollCall. If the data in the first table already exist in the second table then that data should be skipped.
*/
create table oldroll(roll int,Name varchar(20));
create table newroll(roll int,Name varchar(20)); 
insert into newroll values(2,'Dhanashree');
insert into newroll values(5,'Asmita');
insert into oldroll values(2,'Hema');
insert into oldroll values(5,'Aditi');
insert into oldroll values(4,'Srushti');
insert into oldroll values(5,'Asmita');
select * from newroll;
select * from oldroll;

Delimiter $$
create procedure rolllist()
    begin
    declare a int;
    declare a1 varchar(10);
    declare b int;
    declare b1 varchar(10);
    declare done int default false;
    declare c1 cursor for select roll,name from oldroll;
    declare c2 cursor for select roll,name from newroll;
    declare continue handler for not found set done=true;
    open c1;
    open c2;
    loop1:loop
    fetch c1 into a,a1;
    if done then
    leave loop1;
    end if;
    loop2:loop
    fetch c2 into b,b1;
    if done then
    insert into newroll values(a,a1);
    leave loop2;
    end if;
    if a1=b1 then
    leave loop2;
    end if;
    end loop;
    end loop;
    close c1;
    close c2;
    end $$
call rolllist() $$
select * from newroll $$
