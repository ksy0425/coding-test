-- 코드를 입력하세요
SELECT A.ANIMAL_ID, A.NAME
FROM ANIMAL_INS A
         JOIN ANIMAL_OUTS O ON A.ANIMAL_ID = O.ANIMAL_ID
WHERE TIMESTAMPDIFF(SECOND, A.DATETIME, O.DATETIME) < 0
ORDER BY A.DATETIME ASC;

/*
TIMESTAMPDIFF(unit, datetime_expr1, datetime_expr2)
계산식은 datetime_expr2 - datetime_expr1
즉, 두 번째 인자에서 첫 번째 인자를 뺀 값을 지정한 단위로 반환
*/