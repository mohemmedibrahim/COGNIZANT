SELECT u.user_id, u.name
FROM users u
WHERE u.user_id NOT IN (
    SELECT r.user_id
    FROM registrations r
    WHERE r.reg_date >= CURDATE() - INTERVAL 90 DAY
);
