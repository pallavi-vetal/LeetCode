-- 1. Write a SQL query to find the products which have continuous increase in sales every year?
--  STEP 1 : First  get the previous year sales for each product.
SELECT  P.PRODUCT_NAME,
        S.YEAR,
        S.QUANTITY ,
        LEAD(S.QUANTITY,1,0) OVER (
                                 PARTITION BY P.PRODUCT_ID
                                 ORDER BY S.YEAR DESC
                                ) PREV_YEAR_QUANTITY
FROM PRODUCTS P,
     SALES S
WHERE P.PRODUCT_ID = S.PRODUCT_ID;

-- STEP 2 :We will find the difference between the quantities of a product with its previous year’s quantity.
--         If this difference is greater than or equal to zero for all the rows, then the product is a constantly increasing in sales.
SELECT A.PRODUCT_NAME
FROM
(
SELECT  P.PRODUCT_NAME,
        S.YEAR,
        S.QUANTITY -
        LEAD(S.QUANTITY,1,0) OVER (
                                    PARTITION BY P.PRODUCT_ID
                                    ORDER BY S.YEAR DESC
                                 ) DIFF
FROM    PRODUCTS P,
        SALES S
WHERE   P.PRODUCT_ID = S.PRODUCT_ID
) A
GROUP BY A.PRODUCT_NAME
HAVING MIN(A.DIFF)>=0;

-- 2. Write a SQL query to find the products which does not have sales at all?
-- SOLUTION 1 : USING LEFT OUTER JOIN
SELECT  A.PRODUCT_NAME
FROM
(
SELECT  PRODUCT_NAME,
        PRODUCT_ID
FROM    PRODUCTS
) A
LEFT OUTER JOIN
(
SELECT  PRODUCT_ID,
        QUANTITY
FROM SALES
) B
ON A.PRODUCT_ID = B.PRODUCT_ID
WHERE B.QUANTITY IS  NULL;

-- SOLUTION 2 : NOT EXISTS
SELECT  P.PRODUCT_NAME
FROM    PRODUCTS P
WHERE   NOT EXISTS(SELECT 1 FROM SALES S WHERE S.PRODUCT_ID=P.PRODUCT_ID);

-- 3. Write a SQL query to find the products whose sales decreased in 2012 compared to 2011?
-- SOLUTION 1
SELECT  A.PRODUCT_NAME
FROM
(
SELECT  P.PRODUCT_NAME,
        S.YEAR,
        S.QUANTITY,
        S.QUANTITY -
        LEAD(S.QUANTITY,1,0) OVER (
                                    PARTITION BY P.PRODUCT_ID
                                    ORDER BY S.YEAR DESC
                                  ) DIFF
FROM    PRODUCTS P,
        SALES S
WHERE   P.PRODUCT_ID = S.PRODUCT_ID
AND     S.YEAR IN ('2011','2012')
) A
GROUP BY PRODUCT_NAME
HAVING MIN(DIFF)<0
;

-- SOLUTION 2 :

SELECT  P.PRODUCT_NAME
FROM    PRODUCTS P,
        SALES SALES_2011,
        SALES SALES_2012
WHERE   SALES_2011.YEAR = '2011'
AND     SALES_2012.YEAR = '2012'
AND     SALES_2011.PRODUCT_ID = SALES_2012.PRODUCT_ID
AND     P.PRODUCT_ID = SALES_2012.PRODUCT_ID
AND     SALES_2012.QUANTITY < SALES_2011.QUANTITY
;

