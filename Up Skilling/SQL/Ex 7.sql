SELECT 
    u.user_id,
    u.name,
    f.rating,
    f.comment,
    e.event_name
FROM feedback f
JOIN users u ON f.user_id = u.user_id
JOIN events e ON f.event_id = e.event_id
WHERE f.rating < 3;

