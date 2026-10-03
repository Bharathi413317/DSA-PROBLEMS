# Write your MySQL query statement below
-- select * ,
-- case
--  when sex='f' then 'm'

--  when sex='m' then 'f'
--  END AS new_sex
-- --  from table;
-- SELECT *,
--        CASE
--            WHEN sex = 'f' THEN 'm'
--            WHEN sex = 'm' THEN 'f'
--        END AS new_sex
-- FROM Salary;
update Salary
set sex = case
   WHEN sex = 'f' THEN 'm'
          WHEN sex = 'm' THEN 'f'

    end;
