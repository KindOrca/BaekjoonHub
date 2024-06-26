# WITH TEMP AS (
#     SELECT EMP_NO, YEAR, AVG(SCORE) SCORE
#     FROM HR_GRADE
#     GROUP BY 1, 2
# )
# SELECT E.EMP_NO, EMP_NAME,
#     CASE WHEN SCORE >= 96 THEN 'S'
#     WHEN SCORE >= 90 THEN 'A'
#     WHEN SCORE >= 80 THEN 'B'
#     ELSE 'C' END AS GRADE,
#     CASE WHEN SCORE >= 96 THEN SAL*20/100
#     WHEN SCORE >= 90 THEN SAL*15/100
#     WHEN SCORE >= 80 THEN SAL*10/100
#     ELSE 0 END AS BONUS
# FROM HR_EMPLOYEES E
#     JOIN TEMP T ON E.EMP_NO = T.EMP_NO
# ORDER BY 1
SELECT E.EMP_NO, MAX(EMP_NAME) EMP_NAME,
    CASE WHEN AVG(score) >= 96 THEN 'S'
    WHEN AVG(score) >=90 THEN 'A'
    WHEN AVG(score) >= 80 THEN 'B'
    WHEN AVG(score) < 80 THEN 'C'
    end AS GRADE,
    CASE WHEN AVG(score) >= 96 THEN sal*0.2
    WHEN AVG(score) >= 90 THEN sal*0.15
    WHEN AVG(score) >= 80 THEN sal*0.1
    WHEN AVG(score) < 80 THEN 0 end AS BONUS
FROM HR_EMPLOYEES E
    JOIN HR_GRADE G ON E.emp_no = G.emp_no
GROUP BY 1
ORDER BY 1