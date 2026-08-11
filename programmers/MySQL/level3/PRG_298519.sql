-- 코드를 작성해주세요
SELECT COUNT(ID) AS FISH_COUNT, MAX(LENGTH) AS MAX_LENGTH, FISH_TYPE
FROM FISH_INFO
GROUP BY FISH_TYPE
HAVING AVG(COALESCE(LENGTH, 10)) >= 33
ORDER BY FISH_TYPE ASC;

/*
IFNULL(컬럼, 대체값)
컬럼이 NULL이면 대체값을 사용하고, NULL이 아니면 원래 값을 사용

COALESCE(값1, 값2, 값3, ...)
왼쪽부터 확인해서 NULL이 아닌 첫 번째 값을 반환
COALESCE(A, B, C, D)
A가 NULL이 아니면 → A
A가 NULL이면 B 확인
B도 NULL이면 C 확인
C도 NULL이면 D
전부 NULL이면 NULL
*/