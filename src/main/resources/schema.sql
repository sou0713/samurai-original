DROP TABLE IF EXISTS files;
CREATE TABLE files (
    id INT AUTO_INCREMENT PRIMARY KEY,
    file_name VARCHAR(255),
    file_type VARCHAR(255),
    data BLOB
);