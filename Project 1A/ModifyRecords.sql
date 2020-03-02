update students 
set name = 'Scott'
where ssn = '746897816';


update major
set name = 'Computer Science', level = 'MS'
where snum = (select snum from students where ssn = '746897816');


SET SQL_SAFE_UPDATES = 0;
delete from register
where regtime = 'Spring2015';
SET SQL_SAFE_UPDATES = 1;