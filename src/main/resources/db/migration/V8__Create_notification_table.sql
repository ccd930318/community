create table notification
(
    id bigint auto_increment primary key,
    notifier bigint not null,
    notifier_name varchar(100) null,
    receiver bigint not null,
    outerid bigint not null,
    outer_title varchar(256) null,
    type int not null,
    gmt_create bigint not null,
    status int default 0 not null
);