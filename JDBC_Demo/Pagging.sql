DROP TABLE DummyTable;

CREATE TABLE DummyTable(
	id INT PRIMARY KEY
	, name VARCHAR(150) NOT NULL
)

DECLARE @count INT = 1;
WHILE @count <= 100000
BEGIN
	INSERT INTO DummyTable(id,name) VALUES (@count , 'dummy' + CAST(@count AS VARCHAR(10)))
	SET @count = @count + 1;
END

SELECT * FROM DummyTable

DELETE DummyTable WHERE id = 3 OR id = 4

DECLARE @PageSize INT = 10
DECLARE @PageIndex INT = 1;

SELECT id,name FROM 
(SELECT ROW_NUMBER() OVER (ORDER BY id asc) as rownum, id,name
FROM DummyTable) t
WHERE 
rownum >= (@PageIndex - 1)*@PageSize + 1 AND rownum <= @PageIndex * @PageSize