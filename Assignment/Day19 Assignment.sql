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
