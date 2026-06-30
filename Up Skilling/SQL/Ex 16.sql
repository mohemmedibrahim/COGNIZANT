SELECT u.user_id, u.name
FROM users u
WHERE u.created_at >= CURDATE() - INTERVAL 30 DAY
AND NOT EXISTS (
    SELECT 1
    FROM registrations r
    WHERE r.user_id = u.user_id
);

