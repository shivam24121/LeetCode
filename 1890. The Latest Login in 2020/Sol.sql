SELECT u.user_id,u.time_stamp AS last_stamp
FROM Logins u
WHERE YEAR(u.time_stamp)=2020
AND u.time_stamp=(SELECT MAX(time_stamp)
FROM Logins
WHERE user_id=u.user_id
and YEAR(time_stamp)=2020
);
