/*
/* Employee table creation */
CREATE TABLE Employee (
    Employee_id int AUTO_INCREMENT PRIMARY KEY,
    First_name VARCHAR(50),
	Last_name VARCHAR(50),
	Salary int,
	Joining_date Date,
    Departement  VARCHAR(50) 
);

/* Employee table creation */
CREATE TABLE reward (
    Employee_ref_id int,
    date_reward Date,
	amount int,
    FOREIGN KEY (Employee_ref_id) REFERENCES Employee(Employee_id)
);

/* queries to insert into employee */
INSERT INTO Employee (Employee_id, First_name, Last_name, Salary, Joining_date, Departement) VALUES (1, 'Bob', 'Kinto', 1000000, "2019-01-20", "Finance");
INSERT INTO Employee (Employee_id, First_name, Last_name, Salary, Joining_date, Departement) VALUES (2, 'Jerry', 'Kansxo', 6000000, "2019-01-15", "IT");
INSERT INTO Employee (Employee_id, First_name, Last_name, Salary, Joining_date, Departement) VALUES (3, 'Philip', 'Jose', 8900000, "2019-02-05", "Banking");
INSERT INTO Employee (Employee_id, First_name, Last_name, Salary, Joining_date, Departement) VALUES (4, 'John', 'Abraham', 2000000, "2019-02-25", "Insurance");
INSERT INTO Employee (Employee_id, First_name, Last_name, Salary, Joining_date, Departement) VALUES (5, 'Michael', 'Mathew', 2200000, "2019-02-28", "Finance");
INSERT INTO Employee (Employee_id, First_name, Last_name, Salary, Joining_date, Departement) VALUES (6, 'Alex', 'chreketo', 4000000, "2019-05-10", "IT");
INSERT INTO Employee (Employee_id, First_name, Last_name, Salary, Joining_date, Departement) VALUES (7, 'Yohan', 'Soso', 1230000, "2019-06-20", "Banking");

/* queries to insert into reward */
INSERT INTO reward (Employee_ref_id, date_reward, amount) VALUES (1, '2019-05-11', '1000');
INSERT INTO reward (Employee_ref_id, date_reward, amount) VALUES (2, '2019-02-15', '5000');
INSERT INTO reward (Employee_ref_id, date_reward, amount) VALUES (3, '2019-04-22', '2000');
INSERT INTO reward (Employee_ref_id, date_reward, amount) VALUES (1, '2019-06-20', '8000');



Assignment: 

1. Get all the employees
2. Display the firstname and the last name of all employees
3. Display all the values of the "First_Name" column using the alias "Employee Name"
4. Get all "Last_Name in lowercase
5. Get all the Last_Name in upper case
6. Get unique "Department"
7. Get the first 4 characters of "First_Name" column
8. Get the position of the letter 'h' in 'John'
9. Get all the values from the "First_Name" column after removing white space on the right
10.Get all the values from the "First_Name" column after removing white space on the left
11.Get the length of the text in the "First_Name" column
12.Get the employee's first name after replacing 'o' with '#'
13.Get the year, month and day from the "joining_date" column
14.Get all the employees in ascending order by first name 
15.Get all employees in the descending order by firstname
16.Get all employees in the ascending order by firstname and descending order by salary
17.Get employees whose firstname is "Bob"
18.Get employees whose firstname is "Bob" or"Alex"
19.Get employees whose first name is neither "Bob" nor "Alex"
20.Get all the details about employees whose firstname begins with 'J' and contains 4 letters.
21.Get all the details of employee whose participation month(joining_date) is "January"
22.Get all the details of the employees who joined before March 1, 2019
23.Get the difference betwen the "Joining_Date" and "date_reward" column
*/



/* 1st Assingment */
SELECT * FROM Employee;

/* 2nd Assignment */
SELECT First_name, Last_name FROM Employee;

/* 3rd Assignment */
SELECT First_name as 'Employee Name' FROM Employee;

/* 4th Assignment */
SELECT lower(Last_name) FROM Employee;

/* 5th Assignment */
SELECT upper(Last_name) FROM Employee;

/* 6th Assignment */
SELECT distinct Departement FROM Employee;

/* 7th Assignment */
SELECT substr(First_name FROM 1 FOR 4) FROM Employee;

/* 8th Assignment */
SELECT LOCATE('h', 'John');

/* 9th Assignment */
SELECT rtrim(First_name) FROM Employee;

/* 10th Assignment */
SELECT ltrim(First_name) FROM Employee;

/* 11th Assignment */
SELECT First_name, LENGTH(First_name) FROM Employee;

/* 12th Assignment */
SELECT replace(First_name, 'o', '#') as 'Replaced First_name' FROM Employee;

/* 13th Assignment */
SELECT DAY(Joining_date), MONTH(Joining_date), YEAR(Joining_date) FROM Employee;

/* 14th Assignment */
SELECT * FROM Employee ORDER BY First_name;

/* 15th Assignment */
SELECT * FROM Employee ORDER BY First_name DESC;

/* 16th Assignment */
SELECT First_name, Salary FROM Employee ORDER BY First_name ASC, Salary DESC;

/* 17th Assignment */
SELECT * FROM Employee WHERE First_name = 'Bob';

/* 18th Assignment */
SELECT * FROM Employee WHERE First_name in ('Bob', 'Alex');

/* 19th Assignment */
SELECT * FROM Employee WHERE First_name not in ('Bob', 'Alex');

/* 20th Assignment */
SELECT * FROM Employee WHERE First_name LIKE 'J%' AND char_length(First_name) = 4;

/* 21th Assignment */
SELECT * FROM Employee WHERE monthname(Joining_date) = 'January';

/* 22nd Assignment */
SELECT * FROM Employee WHERE Date('2019-03-01') = Joining_date;

/* 23rd Assingment */
SELECT datediff(e.Joining_date, r.date_reward) FROM Employee e, reward r;
SELECT datediff(e.Joining_date, r.date_reward) FROM Employee e, reward r WHERE e.Employee_id = r.Employee_id;
