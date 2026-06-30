SELECT 
    s1.event_id,
    s1.session_id AS session_1,
    s2.session_id AS session_2,
    s1.start_time AS start_1,
    s1.end_time AS end_1,
    s2.start_time AS start_2,
    s2.end_time AS end_2
FROM sessions s1
JOIN sessions s2 
    ON s1.event_id = s2.event_id
   AND s1.session_id < s2.session_id
WHERE 
    s1.start_time < s2.end_time
    AND s2.start_time < s1.end_time;
