
SELECT 
    e.event_id,
    e.event_name,
    COUNT(DISTINCT r.user_id) AS total_registrations,
    AVG(f.rating) AS avg_rating
FROM events e
LEFT JOIN registrations r ON e.event_id = r.event_id
LEFT JOIN feedback f ON e.event_id = f.event_id
WHERE e.status = 'completed'
GROUP BY e.event_id, e.event_name;
