USE jm_security_task;

INSERT INTO roles (id, role, description) VALUES (1, "ROLE_ADMIN", "Administrator");
INSERT INTO roles (id, role, description) VALUES (2, "ROLE_USER", "User");

INSERT INTO users (id, email, password, username) VALUES (1, "qwe@qwe.qwe", "qwe", "qwe");
INSERT INTO users (id, email, password, username) VALUES (2, "asd@asd.asd", "asd", "asd");

INSERT INTO user_role (user_id, role_id) VALUES (1, 1);
INSERT INTO user_role (user_id, role_id) VALUES (2, 2);
