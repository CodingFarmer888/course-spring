DROP TABLE IF EXISTS TODO;
CREATE TABLE TODO (
ID INT AUTO_INCREMENT PRIMARY KEY, 
TITLE VARCHAR(255),
DUEDATE DATE,
STATUS INT
);