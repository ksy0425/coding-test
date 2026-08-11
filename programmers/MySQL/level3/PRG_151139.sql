-- 코드를 입력하세요
SELECT CASE
           WHEN START_DATE BETWEEN DATE '2022-08-01' AND DATE '2022-08-31' THEN 8
           WHEN START_DATE BETWEEN DATE '2022-09-01' AND DATE '2022-09-30' THEN 9
           WHEN START_DATE BETWEEN DATE '2022-10-01' AND DATE '2022-10-31' THEN 10
           END AS MONTH, CAR_ID,
        COUNT(*) AS RECORDS
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
WHERE START_DATE BETWEEN DATE '2022-08-01' AND DATE '2022-10-31'
  AND CAR_ID IN (
    SELECT CAR_ID
    FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
    WHERE START_DATE BETWEEN DATE '2022-08-01' AND DATE '2022-10-31'
    GROUP BY CAR_ID
    HAVING COUNT(*) >= 5
    )
GROUP BY CASE
    WHEN START_DATE BETWEEN DATE '2022-08-01' AND DATE '2022-08-31' THEN 8
    WHEN START_DATE BETWEEN DATE '2022-09-01' AND DATE '2022-09-30' THEN 9
    WHEN START_DATE BETWEEN DATE '2022-10-01' AND DATE '2022-10-31' THEN 10
END, CAR_ID
ORDER BY MONTH ASC, CAR_ID DESC;

/*
1. FROM
테이블이나 뷰를 불러오고, 조인(join)이 있으면 조인을 먼저 수행합니다.
즉, 데이터의 “출발점”을 정합니다.

2. WHERE
개별 행(row) 단위로 조건을 걸어 필터링합니다.
아직 그룹핑 전이므로 집계 함수는 사용할 수 없습니다.

3. GROUP BY
WHERE로 걸러진 행들을 그룹으로 묶습니다.
그룹핑 기준이 되는 컬럼이나 표현식이 여기서 적용됩니다.

4. HAVING
그룹 단위로 조건을 걸어 필터링합니다.
집계 함수(COUNT, SUM, AVG 등)를 사용할 수 있습니다.
즉, WHERE는 “행 필터링”, HAVING은 “그룹 필터링”입니다.

5. SELECT
최종적으로 보여줄 컬럼을 선택합니다.
집계 결과나 별칭(alias)이 여기서 만들어집니다.

6. ORDER BY
SELECT 결과 집합을 정렬합니다.
이 단계에서만 별칭을 자유롭게 사용할 수 있습니다.
*/