SELECT u.name as name , SUM(t.amount) as balance
from  Users u
INNER JOIN
Transactions t
ON u.account=t.account
GROUP BY u.name
HAVING balance>10000;
