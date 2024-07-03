WITH TEMP AS (
    SELECT USER_ID, JOINED, COUNT(*) OVER() TOTAL
    FROM USER_INFO
    WHERE YEAR(JOINED) = 2021
)
SELECT YEAR(SALES_DATE) YEAR, MONTH(SALES_DATE) MONTH, COUNT(DISTINCT T.USER_ID) PURCHASED_USERS, ROUND(COUNT(DISTINCT T.USER_ID)/TOTAL, 1) PURCHASED_RATIO
FROM TEMP T
    LEFT JOIN ONLINE_SALE O ON O.USER_ID = T.USER_ID
GROUP BY 1, 2
HAVING YEAR IS NOT NULL
ORDER BY 1, 2