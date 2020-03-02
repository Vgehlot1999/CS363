Create Table students (
	snum integer,
    ssn integer,
    name varchar(10),
    gender varchar(1),
    dob datetime,
    c_addr varchar(20),
    c_phone varchar(10),
    p_addr varchar(20),
    p_phone varchar(10),
    Primary Key (ssn),
    Unique (snum));
    
Create Table departments (
	code integer,
    name varchar(50),
    phone varchar(10),
    college varchar(20),
    Primary Key (code),
    Unique (name));
    
Create Table degrees (
	name varchar(50),
    level varchar(5),
    department_code integer,
    Primary Key (name, level),
    Foreign Key (department_code) references departments(code));
    
Create Table courses (
	number integer,
    name varchar(50),
    description varchar(50),
    credithours integer,
    level varchar(20),
    department_code integer,
    Primary key (number),
    Foreign Key (department_code) references departments(code),
    Unique (name));
    
Create Table register (
	snum integer,
    course_number integer,
    regtime varchar(20),
    grade integer,
    Primary Key (snum, course_number),
    Foreign Key (snum) references students(snum),
    foreign Key (course_number) references courses(number));
    
Create Table major (
	snum integer,
    name varchar(50),
    level varchar(5),
    Primary Key (snum, name, level),
    Foreign Key (snum) references students(snum),
    Foreign Key (name, level) references degrees(name, level));
    
Create Table minor (
	snum integer,
    name varchar(50),
    level varchar(5),
    Primary Key (snum, name, level),
    Foreign Key (snum) references students(snum),
    Foreign Key (name, level) references degrees(name, level));
    
