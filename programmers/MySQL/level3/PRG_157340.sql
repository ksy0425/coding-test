-- 코드를 입력하세요
SELECT CAR_ID,
       CASE
           WHEN SUM(CASE
                        WHEN DATE '2022-10-16' BETWEEN START_DATE AND END_DATE
                            THEN 1 ELSE 0
               END) > 0
               THEN '대여중'
           ELSE '대여 가능'
           END AS AVAILABILITY
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
GROUP BY CAR_ID
ORDER BY CAR_ID DESC;

/*

컬럼명 BETWEEN 시작값 AND 끝값
컬럼명 >= 시작값 AND 컬럼명 <= 끝값과 동일, 즉 양쪽 끝값도 포함
DATE '2022-10-16' BETWEEN START_DATE AND END_DATE

*/