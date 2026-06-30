SELECT 
    e.event_id,
    e.event_name,
    SUM(CASE WHEN r.type = 'pdf' THEN 1 ELSE 0 END) AS pdf_count,
    SUM(CASE WHEN r.type = 'image' THEN 1 ELSE 0 END) AS image_count,
    SUM(CASE WHEN r.type = 'link' THEN 1 ELSE 0 END) AS link_count,
    COUNT(r.resource_id) AS total_resources
FROM events e
LEFT JOIN resources r ON e.event_id = r.event_id
GROUP BY e.event_id, e.event_name;
