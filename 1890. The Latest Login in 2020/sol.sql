SELECT l.user_id , l.time_stamp as last_stamp
FROM Logins l
WHERE YEAR(l.time_stamp)=2020
AND l.time_stamp=(SELECT MAX(time_stamp)
FROM Logins
WHERE user_id=l.user_id
AND YEAR(time_stamp)=2020
);
