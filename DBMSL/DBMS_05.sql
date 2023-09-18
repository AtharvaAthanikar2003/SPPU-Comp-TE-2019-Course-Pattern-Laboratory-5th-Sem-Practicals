/*
DBMS Exp No.5 :- Named PL/SQL Block: PL/SQL Stored Procedure and Stored Function.
Problem Statement : Write a Stored Procedure namely proc_Grade for the categorization of student. 
If marks scored by students in examination is <=1500 and marks>=990 then student will be placed in distinction category, 
if marks scored are between 989 and900 category is first class, if marks 899 and 825 category is Higher Second Class.
*/

create database student_marks;
use student_marks;
create table student_grade(student_name varchar(20),marks int, category varchar(20));
CREATE PROCEDURE proc_gradess(IN student_nm varchar(20),IN exam_marks int)
    -> BEGIN
    -> DECLARE grade_category varchar(50);
    -> IF exam_marks <= 1500 AND exam_marks>=990 THEN
    -> SET grade_category="Distinction";
    -> ELSEIF exam_marks >= 900 AND exam_marks <=989 THEN
    -> SET grade_category="First Class";
    -> ELSEIF exam_marks >=825 AND exam_marks <= 899 THEN
    -> SET grade_category="Higher Second Class";
    -> ELSE
    -> SET grade_category="No Category";
    -> END IF;
    -> INSERT INTO student_grade(student_name,marks,category)
    -> VALUES(student_nm,exam_marks,grade_category);
    -> END $$
call proc_gradess("Shailesh",1100);
    -> $$
call proc_gradess("Atharva",1000);
    -> $$
call proc_gradess("Ritesh",1200);
    -> $$
call proc_gradess("Swapnil",950);
    -> $$
call proc_gradess("Yash",930);
    -> $$
call proc_gradess("Gaurav",970);
    -> $$
call proc_gradess("Shreedhar",980);
    -> $$
select * from student_grade;
    -> $$
