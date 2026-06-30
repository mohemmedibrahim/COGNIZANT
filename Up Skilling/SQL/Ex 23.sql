SELECT 
    DATE_FORMAT(reg_date, '%Y-%m') AS month,
    COUNT(*) AS total_registrations
FROM registrations
WHERE reg_date >= CURDATE() - INTERVAL 12 MONTH
GROUP BY DATE_FORMAT(reg_date, '%Y-%m')
ORDER BY month;
