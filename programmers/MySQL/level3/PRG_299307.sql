-- 코드를 작성해주세요
SELECT ID, CASE
               WHEN SIZE_OF_COLONY <= 100 THEN 'LOW'
               WHEN SIZE_OF_COLONY > 100 AND SIZE_OF_COLONY <= 1000 THEN 'MEDIUM'
               WHEN SIZE_OF_COLONY > 1000 THEN 'HIGH'
    END AS SIZE
FROM ECOLI_DATA;

-- CASE 문은 보통 SELECT 절 안에서 사용해서 새로운 컬럼을 만드는데 사용