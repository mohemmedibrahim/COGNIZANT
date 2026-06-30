SELECT 
    u.user_id,
    u.name,
    COUNT(DISTINCT r.event_id) AS events_attended,
    COUNT(DISTINCT f.feedback_id) AS feedback_count
FROM users u
LEFT JOIN registrations r ON u.user_id = r.user_id
LEFT JOIN feedback f ON u.user_id = f.user_id
GROUP BY u.user_id, u.name;
