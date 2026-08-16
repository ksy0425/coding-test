SELECT ID,
       CASE
           WHEN PERCENT_RANK() OVER (ORDER BY SIZE_OF_COLONY) >= 0.75 THEN 'CRITICAL'
           WHEN PERCENT_RANK() OVER (ORDER BY SIZE_OF_COLONY) >= 0.50 THEN 'HIGH'
           WHEN PERCENT_RANK() OVER (ORDER BY SIZE_OF_COLONY) >= 0.25 THEN 'MEDIUM'
           ELSE 'LOW'
           END AS COLONY_NAME
FROM ECOLI_DATA
ORDER BY ID ASC;

/*
NTILE(4) → 데이터를 4등분(Quartile)으로 나눔
ORDER BY SIZE_OF_COLONY DESC → 큰 값이 상위 그룹에 들어가도록 정렬
각 행은 자동으로 1~4 그룹에 배정되고, 그에 따라 등급을 CASE문으로 매핑

SELECT ID,
       CASE NTILE(4) OVER (ORDER BY SIZE_OF_COLONY DESC)
           WHEN 1 THEN 'CRITICAL'   -- 상위 25%
           WHEN 2 THEN 'HIGH'       -- 25~50%
           WHEN 3 THEN 'MEDIUM'     -- 50~75%
           WHEN 4 THEN 'LOW'        -- 하위 25%
       END AS COLONY_NAME
FROM ECOLI_DATA
ORDER BY ID ASC;

*/