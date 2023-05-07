--<ScriptOptions statementTerminator=";"/>

CREATE TABLE student (
	id BIGINT NOT NULL,
	first_name VARCHAR(255),
	last_name VARCHAR(255),
	class_id BIGINT,
	PRIMARY KEY (id)
);

CREATE TABLE class_room (
	id BIGINT NOT NULL,
	name VARCHAR(255),
	teacher_id BIGINT,
	class_id BIGINT,
	PRIMARY KEY (id)
);

CREATE TABLE teacher (
	id BIGINT NOT NULL,
	first_name VARCHAR(255),
	last_name VARCHAR(255),
	PRIMARY KEY (id)
);

CREATE INDEX FKfmmvesdpa6u860y79hpwrw839 ON class_room (teacher_id ASC);

CREATE INDEX FKcalsedhqf223y32r8p944n4jq ON class_room (class_id ASC);

CREATE INDEX FKt3mj3ri10grhbs2k0vn1ek1yn ON student (class_id ASC);

