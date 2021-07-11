Create table comment(
	id BIGINT AUTO_INCREMENT PRIMARY KEY,
	parent_id BIGINT NOT NULL,
	content varchar(1024) NULL,
	type INT NOT NULL,
	commentator BIGINT NOT NULL,
	gmt_create BIGINT NOT NULL,
	gmt_modified BIGINT NOT NULL,
	like_count BIGINT default 0
);