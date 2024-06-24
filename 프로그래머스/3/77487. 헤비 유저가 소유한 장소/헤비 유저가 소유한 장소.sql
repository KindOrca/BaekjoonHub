WITH TEMP AS (
    SELECT HOST_ID
    FROM PLACES
    GROUP BY 1
    HAVING COUNT(*) >= 2
)
SELECT ID, NAME, HOST_ID
FROM PLACES
WHERE HOST_ID IN (SELECT HOST_ID FROM TEMP)
ORDER BY 1