
SELECT 
    s.speaker_id,
    sp.name,
    COUNT(s.session_id) AS total_sessions
FROM sessions s
JOIN speakers sp ON s.speaker_id = sp.speaker_id
GROUP BY s.speaker_id, sp.name
HAVING COUNT(s.session_id) > 1;
