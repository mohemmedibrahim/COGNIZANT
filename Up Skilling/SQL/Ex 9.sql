SELECT 
    o.organizer_id,
    o.name,
    COUNT(e.event_id) AS total_events,
    SUM(CASE WHEN e.event_date > CURDATE() THEN 1 ELSE 0 END) AS upcoming_events,
    SUM(CASE WHEN e.event_date < CURDATE() THEN 1 ELSE 0 END) AS completed_events,
    SUM(CASE WHEN e.status = 'cancelled' THEN 1 ELSE 0 END) AS cancelled_events
FROM organizers o
LEFT JOIN events e ON o.organizer_id = e.organizer_id
GROUP BY o.organizer_id, o.name;
