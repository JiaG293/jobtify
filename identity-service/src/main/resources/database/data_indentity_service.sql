CREATE SCHEMA IF NOT EXISTS identity_service;

SET search_path TO identity_service;

-- ADMIN
INSERT INTO identity_service.roles (name, description)
VALUES ('ADMIN', 'Admin role'),
       ('USER_CANDIDATE', 'User candidate role'),
       ('USER_COMPANY', 'User company role');

--user: admin || password: admin
INSERT INTO identity_service.users (user_id, username, email, phone, password, is_active)
VALUES ('aaff2004-156a-49e5-b091-721da6af2f3c', 'admin', 'admin@gmail.com', '1111111111', '$2a$12$DWh.yec/1To4yifNQ6aTk.sVuun9T1p9EMYFiGMnfEP9qLCiZ.Eye',
        true);

INSERT INTO identity_service.users_roles(roles_name, user_user_id)
VALUES ('ADMIN', 'aaff2004-156a-49e5-b091-721da6af2f3c');



--USER_CANDIDATE
--user: <ten> || password: 123
INSERT INTO identity_service.users (user_id, username, email, phone, password, is_active)
VALUES ('31fba4f2-256f-44b4-a4c7-5cff9a5b7942', 'cong', 'cong@example.com', '0123456789', '$2a$12$etWL69IwBH78b0hEn/ZU1u8E8ucPbmQ3EghEOAF5r4jtbJdY97FUu', true),
       ('1b0f6caa-4553-4d16-9874-a3dbf0666488', 'giau', 'giau@example.com', '0987654321', '$2a$12$etWL69IwBH78b0hEn/ZU1u8E8ucPbmQ3EghEOAF5r4jtbJdY97FUu', true),
       ('d6acce12-365f-40b0-b8ec-df2fb5693692', 'sang', 'sang@example.com', '0987654312', '$2a$12$etWL69IwBH78b0hEn/ZU1u8E8ucPbmQ3EghEOAF5r4jtbJdY97FUu', true),
       ('33ed0f00-b286-4972-95ec-b3a119b9c54c', 'lan', 'lan@example.com', '0987654313', '$2a$12$etWL69IwBH78b0hEn/ZU1u8E8ucPbmQ3EghEOAF5r4jtbJdY97FUu', true),
       ('c6db837d-c46d-486c-807a-437a10f3490c', 'khoa', 'khoa@example.com', '0987654314', '$2a$12$etWL69IwBH78b0hEn/ZU1u8E8ucPbmQ3EghEOAF5r4jtbJdY97FUu', true),
       ('3c1db785-58cd-4223-8449-f805c82c7ad1', 'chau', 'chau@example.com', '0987654315', '$2a$12$etWL69IwBH78b0hEn/ZU1u8E8ucPbmQ3EghEOAF5r4jtbJdY97FUu', true),
       ('bd096e33-a5ca-4878-8e44-c6c79d059e7c', 'ngoc', 'ngoc@example.com', '0987654316', '$2a$12$etWL69IwBH78b0hEn/ZU1u8E8ucPbmQ3EghEOAF5r4jtbJdY97FUu', true),
       ('acf86d11-49ba-4e02-b5ac-9c9c43719ef9', 'tam', 'tam@example.com', '0987654317', '$2a$12$etWL69IwBH78b0hEn/ZU1u8E8ucPbmQ3EghEOAF5r4jtbJdY97FUu', true),
       ('e8eddddc-dbc5-4aa1-b2cb-706b9ca6d8f3', 'hung', 'hung@example.com', '0987654318', '$2a$12$etWL69IwBH78b0hEn/ZU1u8E8ucPbmQ3EghEOAF5r4jtbJdY97FUu', true),
       ('350c3938-edce-4e04-b528-27ffcba6dd82', 'nhi', 'nhi@example.com', '0987654319', '$2a$12$etWL69IwBH78b0hEn/ZU1u8E8ucPbmQ3EghEOAF5r4jtbJdY97FUu', true);

INSERT INTO identity_service.users_roles(roles_name, user_user_id)
VALUES ('USER_CANDIDATE', '31fba4f2-256f-44b4-a4c7-5cff9a5b7942'),
       ('USER_CANDIDATE', '1b0f6caa-4553-4d16-9874-a3dbf0666488'),
       ('USER_CANDIDATE', 'd6acce12-365f-40b0-b8ec-df2fb5693692'),
       ('USER_CANDIDATE', '33ed0f00-b286-4972-95ec-b3a119b9c54c'),
       ('USER_CANDIDATE', 'c6db837d-c46d-486c-807a-437a10f3490c'),
       ('USER_CANDIDATE', '3c1db785-58cd-4223-8449-f805c82c7ad1'),
       ('USER_CANDIDATE', 'bd096e33-a5ca-4878-8e44-c6c79d059e7c'),
       ('USER_CANDIDATE', 'acf86d11-49ba-4e02-b5ac-9c9c43719ef9'),
       ('USER_CANDIDATE', 'e8eddddc-dbc5-4aa1-b2cb-706b9ca6d8f3'),
       ('USER_CANDIDATE', '350c3938-edce-4e04-b528-27ffcba6dd82');


--USER_COMPANY

--user: <ten-cong-ty> || password: 123
INSERT INTO identity_service.users (user_id, username, email, phone, password, is_active)
VALUES ('5ead5f1b-e04d-468b-a8b9-9c3c78857599', 'techcompany', 'hire@techcorp.com', '0111111111', '$2a$12$etWL69IwBH78b0hEn/ZU1u8E8ucPbmQ3EghEOAF5r4jtbJdY97FUu', true),
       ('3601c6a4-2fad-41d2-82bb-e789cbc98f34', 'financecompany', 'hire@financeinc.com', '0111111112', '$2a$12$etWL69IwBH78b0hEn/ZU1u8E8ucPbmQ3EghEOAF5r4jtbJdY97FUu', true),
       ('922a7248-f499-41cf-a163-536f9ef093cf', 'lgcompany', 'tuyendung@lg.com.vn', '0111111113', '$2a$12$etWL69IwBH78b0hEn/ZU1u8E8ucPbmQ3EghEOAF5r4jtbJdY97FUu', true),
       ('b91eccd8-3f30-4d7a-95f3-487189a23952', 'boschcompany', 'hire@bosch.com', '0111111114', '$2a$12$etWL69IwBH78b0hEn/ZU1u8E8ucPbmQ3EghEOAF5r4jtbJdY97FUu', true),
       ('1a25a379-19ff-4dab-b5b6-5a4f80edb791', 'vietcombankcompany', 'tuyendung@vietcombank.com.vn', '0111111115', '$2a$12$etWL69IwBH78b0hEn/ZU1u8E8ucPbmQ3EghEOAF5r4jtbJdY97FUu', true);

INSERT INTO identity_service.users_roles(roles_name, user_user_id)
VALUES ('USER_COMPANY', '5ead5f1b-e04d-468b-a8b9-9c3c78857599'),
       ('USER_COMPANY', '3601c6a4-2fad-41d2-82bb-e789cbc98f34'),
       ('USER_COMPANY', '922a7248-f499-41cf-a163-536f9ef093cf'),
       ('USER_COMPANY', 'b91eccd8-3f30-4d7a-95f3-487189a23952'),
       ('USER_COMPANY', '1a25a379-19ff-4dab-b5b6-5a4f80edb791');




