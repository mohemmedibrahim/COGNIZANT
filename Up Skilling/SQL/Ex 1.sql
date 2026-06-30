SELECT e.event_id, e.event_name, e.event_date
FROM users u
JOIN registrations r ON u.user_id = r.user_id
JOIN events e ON r.event_id = e.event_id
WHERE u.city = e.city
  AND e.event_date >= CURDATE()
ORDER BY e.event_date ASC;
