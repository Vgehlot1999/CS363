-- 1
Select snum, ssn 
from students
where name = 'Becky';

-- 2
Select name, level
from major
where snum = (select snum from students where ssn = '123097834');

-- 3
Select name
from courses
where department_code = (select code from departments where name = 'Computer Science');

-- 4
Select name, level
from degrees
where department_code = (select code from departments where name = 'Computer Science');

-- 5
Select s.name
from students s
where snum in (select snum from minor);

-- 6
Select count(s.name)
from students s
where snum in (select snum from minor);

-- 7
select name, count(name)
from students
where snum = (select snum from register where course_number = (select number from courses where name = 'Algorithm'));

-- 8
Select name, snum
from students
where dob = (select min(dob) from students); 

-- 9
Select name, snum
from students
where dob = (select max(dob) from students); 

-- 10
Select name, snum, ssn
from students
where name like '%n%' or name like '%N%'; 

-- 11
Select name, snum, ssn
from students
where name not like '%n%' or name not like '%N%'; 

-- 12
Select number, name, count(distinct r.snum)
from courses
Left join register r on r.course_number = courses.number group by 1;

-- 13
Select name
from students
where snum in (select snum from register where regtime = 'Fall2015');

-- 14
Select number, name
from courses
where department_code in (select code from departments where name = 'Computer Science');

-- 15
Select name
from courses
where department_code in (select code from departments where name = 'Computer Science' or name = 'Landscape Architect');
