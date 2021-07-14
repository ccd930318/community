CREATE TABLE MEM
(
    MemNo INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    MemAccount VARCHAR(20) NOT NULL,
    MemPassword VARCHAR(20) NOT NULL,
    MemStatus int NOT NULL DEFAULT 0,
    MemVrfed int DEFAULT 0,
    MemNoVrftime datetime, 
    MemName VARCHAR(100) NOT NULL,
    MemMobile varchar(20) NOT NULL,
    MemCity varchar(20) NOT NULL,
    MemDist varchar(20) NOT NULL,
    MemAdd varchar(100) NOT NULL,
    MemEmail varchar(50) NOT NULL,
    MemBirth date NOT NULL,
    MemJointime datetime NOT NULL,
    UsderStatus INT NOT NULL DEFAULT 0,
    ECash INT NOT NULL DEFAULT 0,
    Avatar blob
);