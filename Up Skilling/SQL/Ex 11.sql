SELECT 
    DATE(created_at) AS reg_day,
    COUNT(user_id) AS new_users
FROM users
WHERE created_at >= CURDATE() - INTERVAL 7 DAY
GROUP BY DATE(created_at)
ORDER BY reg_day;
