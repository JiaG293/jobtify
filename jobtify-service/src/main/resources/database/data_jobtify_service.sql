-- CREATE SCHEMA IF NOT EXISTS jobtify_service;

SET search_path TO jobtify_service;


-- CLEAR TABLE TRUOC KHI INSERT

TRUNCATE TABLE jobtify_service.address RESTART IDENTITY CASCADE;
TRUNCATE TABLE jobtify_service.candidate RESTART IDENTITY CASCADE;
TRUNCATE TABLE jobtify_service.company RESTART IDENTITY CASCADE;
TRUNCATE TABLE jobtify_service.experience RESTART IDENTITY CASCADE;
TRUNCATE TABLE jobtify_service.job RESTART IDENTITY CASCADE;
TRUNCATE TABLE jobtify_service.skill RESTART IDENTITY CASCADE;


--table ADDRESS
INSERT INTO jobtify_service.address (add_id, country, zipcode, number, city, street) --258 smallint CountryCode VN :]]
VALUES ('548d0256-f6c7-4cf3-baac-57b83ef1cf0a', 258, '100014', '434', 'Ha Noi', 'Truong Chinh'),
       ('03f1d966-852e-4a99-9989-c2d6137e3a8e', 258, '700045', '55', 'Ho Chi Minh', 'Lai Hung Cuong'),
       ('4cd0aa59-a939-4d91-b37c-74fde84aee9b', 258, '300034', '537', 'Da Nang', 'Nguyen Tri Phuong'),
       ('1ecacd01-8565-4c15-88b1-c3e3451ace93', 258, '654321', '88', 'Ben Tre', 'Nguyen Van Cu'),
       ('e2ba1ed9-7650-471d-ae89-2b0339984b24', 258, '700035', '212', 'Ho Chi Minh', 'Vo Van Van'),
       ('e81ef259-fe5e-40df-a1fa-7b9dfced740c', 258, '141222', '45', 'Long An', 'Nguyen Thi Minh Khai'),
       ('a3865ecc-e9d3-4a5a-b17e-dbf05c3f930b', 258, '700075', '69', 'Ho Chi Minh', 'Nguyen Thi Tu'),
       ('36473305-26f7-47c0-bf22-680e88f8e9b6', 258, '700015', '949', 'Ho Chi Minh', 'Lac Long Quan'),
       ('06de8444-23af-4301-8647-13f203342e8e', 258, '141222', '232', 'Ha Noi', 'Le Trong Tan'),
       ('4088249e-34ec-43da-afdf-9b723c1200cb', 258, '700035', '29', 'Ho Chi Minh', 'Le Loi'),

       --Cong ty
       ('1ce6502a-8370-4662-bffc-c2fe497141a7', 258, '141222', '234', 'Ha Noi', 'Le Duan'),
       ('6fc237db-d35e-43e1-bae2-566c88a1d640', 258, '141222', '449', 'Ha Noi', 'Vo Nguyen Giap'),
       ('9a1f2223-215b-4bf8-b560-7ad13b2eb465', 258, '141222', '539', 'Ha Noi', 'Cong Hoa'),
       ('b5a0fde3-d070-4179-81a5-a1f49fc65b8c', 258, '141222', '451', 'Ho Chi Minh', 'Cong Hoa'),
       ('4ce93d0d-a88f-47db-a1d8-80afa8d3f77f', 258, '141222', '2525', 'Ho Chi Minh', 'Cong Hoa');


--table CANDIDATE
INSERT INTO jobtify_service.candidate (can_id, address, dob, status, phone, email, full_name, created_at, updated_at)
VALUES ('31fba4f2-256f-44b4-a4c7-5cff9a5b7942', '548d0256-f6c7-4cf3-baac-57b83ef1cf0a', '1996-01-01', 1, '0123456789',
        'cong@example.com', 'Le Thanh Cong', CURRENT_TIMESTAMP,
        current_timestamp),
       ('1b0f6caa-4553-4d16-9874-a3dbf0666488', '03f1d966-852e-4a99-9989-c2d6137e3a8e', '2002-03-29', 1, '0987654321',
        'giau@example.com', 'Nguyen Van Giau', CURRENT_TIMESTAMP,
        current_timestamp),
       ('d6acce12-365f-40b0-b8ec-df2fb5693692', '4cd0aa59-a939-4d91-b37c-74fde84aee9b', '1992-04-30', 1, '0987654312',
        'sang@example.com', 'Huynh Van Sang', CURRENT_TIMESTAMP,
        current_timestamp),
       ('33ed0f00-b286-4972-95ec-b3a119b9c54c', '1ecacd01-8565-4c15-88b1-c3e3451ace93', '2000-10-22', 1, '0987654313',
        'lan@example.com', 'Hoang Thi Lan', CURRENT_TIMESTAMP,
        current_timestamp),
       ('c6db837d-c46d-486c-807a-437a10f3490c', 'e2ba1ed9-7650-471d-ae89-2b0339984b24', '2001-02-11', 1, '0987654314',
        'khoa@example.com', 'Vu Anh Khoa', CURRENT_TIMESTAMP,
        current_timestamp),
       ('3c1db785-58cd-4223-8449-f805c82c7ad1', 'e81ef259-fe5e-40df-a1fa-7b9dfced740c', '1995-04-26', 1, '0987654315',
        'chau@example.com', 'Ngo Bao Chau', CURRENT_TIMESTAMP,
        current_timestamp),
       ('bd096e33-a5ca-4878-8e44-c6c79d059e7c', 'a3865ecc-e9d3-4a5a-b17e-dbf05c3f930b', '1992-07-03', 1, '0987654316',
        'ngoc@example.com', 'Dang Hong Ngoc', CURRENT_TIMESTAMP,
        current_timestamp),
       ('acf86d11-49ba-4e02-b5ac-9c9c43719ef9', '36473305-26f7-47c0-bf22-680e88f8e9b6', '1999-04-21', 1, '0987654317',
        'tam@example.com', 'Do Thanh Tam', CURRENT_TIMESTAMP,
        current_timestamp),
       ('e8eddddc-dbc5-4aa1-b2cb-706b9ca6d8f3', '06de8444-23af-4301-8647-13f203342e8e', '1998-07-05', 1, '0987654318',
        'hung@example.com', 'Truong Quoc Hung', CURRENT_TIMESTAMP,
        current_timestamp),
       ('350c3938-edce-4e04-b528-27ffcba6dd82', '4088249e-34ec-43da-afdf-9b723c1200cb', '1983-09-30', 1, '0987654319',
        'nhi@example.com', 'Duong Yen Nhi', CURRENT_TIMESTAMP,
        current_timestamp);


--table COMPANY
INSERT INTO jobtify_service.company (com_id, address, about, comp_name, email, phone, web_url)
VALUES ('5ead5f1b-e04d-468b-a8b9-9c3c78857599', '1ce6502a-8370-4662-bffc-c2fe497141a7', 'A leading tech company',
        'Tech Corp', 'hire@techcorp.com', '0111111111', 'https://techcorp.com'),

       ('3601c6a4-2fad-41d2-82bb-e789cbc98f34', '6fc237db-d35e-43e1-bae2-566c88a1d640', 'A leading finance company',
        'Finance Inc', 'hire@financeinc.com', '0111111111', 'https://financeinc.com'),

       ('922a7248-f499-41cf-a163-536f9ef093cf', '9a1f2223-215b-4bf8-b560-7ad13b2eb465', 'A leading tech company',
        'LG', 'tuyendung@lg.com.vn', '0987654321', 'https://lg.com.vn'),

       ('b91eccd8-3f30-4d7a-95f3-487189a23952', 'b5a0fde3-d070-4179-81a5-a1f49fc65b8c', 'A leading tech company',
        'Bosch', '@bosch.com', '0111111114', 'https://bosch.com'),

       ('1a25a379-19ff-4dab-b5b6-5a4f80edb791', '4ce93d0d-a88f-47db-a1d8-80afa8d3f77f', 'A leading finance company',
        'Vietcombank', 'tuyendung@vietcombank.com.vn', '0111111115', 'https://vietcombank.com.vn');


--table EXPERIENCE
INSERT INTO jobtify_service.experience (exp_id, can_id, from_date, to_date, role, company, work_desc)
VALUES ('cebb5267-f67b-4625-ba55-8e0a8c9fe007', '31fba4f2-256f-44b4-a4c7-5cff9a5b7942', '2015-01-01', '2018-01-01',
        'Software Engineer', 'Tech Corp', 'Web design UX/UI'),
       ('821256b7-bf47-4f15-b580-f15a72d00680', '1b0f6caa-4553-4d16-9874-a3dbf0666488', '2021-02-01', '2025-04-01',
        'Fresher Developer', 'IUH', 'Ky thuat phan mem'),
       ('3af0ff17-9651-41f5-8bc9-68fb265756d7', 'd6acce12-365f-40b0-b8ec-df2fb5693692', '2021-02-01', '2025-04-01',
        'Fresher Developer', 'IUH', 'Ky thuat phan mem'),
       ('1d032316-888e-4e48-bbc3-3d43bc08edb0', '33ed0f00-b286-4972-95ec-b3a119b9c54c', '2018-02-01', '2024-02-01',
        'Engineering Manager', 'Finance Inc', 'Developed software applications'),
       ('b0ea2872-a11f-4111-990d-ea264189d759', 'c6db837d-c46d-486c-807a-437a10f3490c', '2011-02-01', '2024-02-01',
        'Senior Developer', 'Tech Corp', 'Web design UX/UI'),
       ('e3122422-a9a1-4164-9440-1457a666dfa2', '3c1db785-58cd-4223-8449-f805c82c7ad1', '2018-02-01', '2024-02-01',
        'Project Manager', 'LG', 'Developed software applications'),
       ('f72f27ec-3d0c-4cf6-a74b-c071e9c00f6b', 'bd096e33-a5ca-4878-8e44-c6c79d059e7c', '2018-02-01', '2024-02-01',
        'Senior Developer', 'Bosch', 'Web design UX/UI'),
       ('197d6234-945d-4f3d-99c5-c10a18589b98', 'acf86d11-49ba-4e02-b5ac-9c9c43719ef9', '2014-02-01', '2024-02-01',
        'Tech Lead', 'NVIDIA', 'Developed software applications'),
       ('2bbf4624-ffb9-462d-9b0d-b19d0903f1f2', 'e8eddddc-dbc5-4aa1-b2cb-706b9ca6d8f3', '2018-02-01', '2024-02-01',
        'Architect', 'FPT', 'Web design UX/UI'),
       ('c4b892f3-24a5-46e1-b8ee-656b89bfbd8e', '350c3938-edce-4e04-b528-27ffcba6dd82', '2019-02-01', '2024-02-01',
        'Engineering Manager', 'TheGioiDiDong', 'Web design UX/UI');


--table JOB
INSERT INTO jobtify_service.job (job_id, company, job_desc, job_name, created_at, updated_at)
VALUES ('d2ff5b5b-943a-4df3-8301-8dc70e76efc2', '5ead5f1b-e04d-468b-a8b9-9c3c78857599',
        'Looking for a software engineer with experience in Java', 'Software Engineer', CURRENT_TIMESTAMP,
        current_timestamp),
       ('21473a61-5a69-4d3b-87c5-9acf5a40be78', '3601c6a4-2fad-41d2-82bb-e789cbc98f34',
        'Seeking a financial analyst with strong analytical skills', 'Financial Analyst', CURRENT_TIMESTAMP,
        current_timestamp),
       ('03116373-dd7f-44e1-88d9-83f67972e066', '5ead5f1b-e04d-468b-a8b9-9c3c78857599',
        'Develop a mobile application using Flutter and Dart', 'Mobile Developer', CURRENT_TIMESTAMP,
        current_timestamp),
       ('93403150-dec1-4a80-b28c-8ea9cd3861a8', '3601c6a4-2fad-41d2-82bb-e789cbc98f34',
        'Create machine learning models for predictive analytics', 'Data Scientist', CURRENT_TIMESTAMP,
        current_timestamp),
       ('7f23be00-8e64-4fc6-a717-d7c10c92cc60', '922a7248-f499-41cf-a163-536f9ef093cf',
        'Design user interfaces and improve user experience for web applications', 'UI/UX Designer', CURRENT_TIMESTAMP,
        current_timestamp),
       ('a12dedb6-559b-4bfa-b877-a4610fc6f86a', 'b91eccd8-3f30-4d7a-95f3-487189a23952',
        'Manage network infrastructure and ensure cybersecurity measures', 'Network Administrator', CURRENT_TIMESTAMP,
        current_timestamp),
       ('1f39e5c3-e492-4ee4-ad01-4ba27d7eb45f', '1a25a379-19ff-4dab-b5b6-5a4f80edb791',
        'Develop scalable backend services using Node.js and Express', 'Backend Developer', CURRENT_TIMESTAMP,
        current_timestamp),
       ('0192c1b6-507e-4e7c-b9db-a33f1b29b9a4', '5ead5f1b-e04d-468b-a8b9-9c3c78857599',
        'Implement database solutions and ensure data integrity', 'Database Administrator', CURRENT_TIMESTAMP,
        current_timestamp),
       ('48f5b45e-fc0b-49c9-9108-935d2c2f831e', '3601c6a4-2fad-41d2-82bb-e789cbc98f34',
        'Perform testing and ensure quality assurance for software products', 'QA Engineer', CURRENT_TIMESTAMP,
        current_timestamp),
       ('ec74f45d-1779-470d-abcf-594bbee3e32d', '922a7248-f499-41cf-a163-536f9ef093cf',
        'Lead teams to deliver enterprise software solutions', 'Project Manager', CURRENT_TIMESTAMP, current_timestamp),
       ('d06c4890-1f8d-4f10-8f51-4c7158ff9541', 'b91eccd8-3f30-4d7a-95f3-487189a23952',
        'Create and deploy cloud-native applications', 'Cloud Engineer', CURRENT_TIMESTAMP, current_timestamp),
       ('90402e38-4ff6-40e9-ae54-378fa661428b', '1a25a379-19ff-4dab-b5b6-5a4f80edb791',
        'Conduct research and develop AI-based systems', 'AI Researcher', CURRENT_TIMESTAMP, current_timestamp),
       ('f2b9819f-c4a1-4e9c-b9ff-7712a6e7cfe3', '5ead5f1b-e04d-468b-a8b9-9c3c78857599',
        'Analyze customer data and recommend strategies to boost engagement', 'Data Analyst', CURRENT_TIMESTAMP,
        current_timestamp),
       ('94087db2-6b51-45a0-ac45-68fd03a3d788', '3601c6a4-2fad-41d2-82bb-e789cbc98f34',
        'Develop APIs and integrate third-party services', 'API Developer', CURRENT_TIMESTAMP, current_timestamp),
       ('83b9e0a6-2fd4-4bd1-9807-cb11915e7e2e', '922a7248-f499-41cf-a163-536f9ef093cf',
        'Optimize website performance and improve SEO', 'Web Developer', CURRENT_TIMESTAMP, current_timestamp),
       ('11fd8088-c5aa-4e3f-9264-3efb473a4369', 'b91eccd8-3f30-4d7a-95f3-487189a23952',
        'Provide IT support and maintain systems', 'IT Support Specialist', CURRENT_TIMESTAMP, current_timestamp),
       ('9b03cb4a-dae9-4022-b4ea-c1280d03d30b', '1a25a379-19ff-4dab-b5b6-5a4f80edb791',
        'Oversee software development projects from initiation to completion', 'Technical Lead', CURRENT_TIMESTAMP,
        current_timestamp),
       ('056f71ab-6084-4c5d-8235-084109ef4c0f', '5ead5f1b-e04d-468b-a8b9-9c3c78857599',
        'Design engaging and responsive web experiences', 'Front-End Developer', CURRENT_TIMESTAMP, current_timestamp),
       ('fb247652-9a43-4ebf-813f-0382a50c2717', '3601c6a4-2fad-41d2-82bb-e789cbc98f34',
        'Monitor and improve application security measures', 'Security Specialist', CURRENT_TIMESTAMP,
        current_timestamp),
       ('7c12cc74-25ec-4126-a9a8-f30711e7d85e', '922a7248-f499-41cf-a163-536f9ef093cf',
        'Collaborate with stakeholders to define project requirements', 'Business Analyst', CURRENT_TIMESTAMP,
        current_timestamp),
       ('5bbdbd86-87b0-4660-8122-729b6281cccb', '1a25a379-19ff-4dab-b5b6-5a4f80edb791',
        'Train and mentor junior developers', 'Team Lead', CURRENT_TIMESTAMP, current_timestamp),
       ('a8953c96-06f0-4062-8c24-3ddd3daaaab7', 'b91eccd8-3f30-4d7a-95f3-487189a23952',
        'Create and manage DevOps pipelines for CI/CD', 'DevOps Engineer', CURRENT_TIMESTAMP, current_timestamp),
       ('5e382cab-361d-4ba7-93e6-10afad697b8e', '5ead5f1b-e04d-468b-a8b9-9c3c78857599',
        'Plan and execute digital marketing campaigns', 'Digital Marketing Specialist', CURRENT_TIMESTAMP,
        current_timestamp),
       ('f8be0c34-86c0-4fce-adda-0cfc78a24354', '3601c6a4-2fad-41d2-82bb-e789cbc98f34',
        'Develop and maintain mobile apps', 'Mobile App Developer', CURRENT_TIMESTAMP, current_timestamp);


--table SKILL
INSERT INTO jobtify_service.skill (skill_id, skill_type, skill_name, skill_desc)
VALUES ('3c020408-134f-40cd-8d1f-451239325957', 1, 'Java', 'Object-oriented programming language'),
       ('4447bfab-d83c-47f0-a0cf-ed2ebfd252ac', 1, 'Python', 'High-level programming language'),
       ('4ec19391-e475-45a4-a82a-975b58cd1420', 1, 'Data Analysis', 'Analyzing data to extract insights'),
       ('41673336-4248-484e-80cf-539545a0bdb9', 1, 'Machine Learning', 'Building predictive models from data'),
       ('02ff5329-1c77-47a6-8990-2ab78fe7994a', 1, 'Cloud Computing', 'Deploying scalable cloud solutions'),
       ('6967208b-2985-4fa9-9c9d-5e64a6915ba3', 1, 'Cybersecurity', 'Implementing network security protocols'),
       ('b9653698-1829-4897-9a64-8b3249829f79', 1, 'Web Development', 'Design and development of web applications'),
       ('8af179f9-01bc-4cce-b5b4-c1c58a69bb6f', 1, 'Mobile Development', 'Creating cross-platform mobile applications'),
       ('7d4bc046-e843-42f1-80c5-c991be9232e6', 1, 'Data Visualization', 'Visualizing data for decision making'),
       ('43a73084-ecf4-4e29-b009-7612e642d78e', 1, 'DevOps', 'CI/CD pipeline creation and maintenance'),
       ('323bdf2d-85f2-4c65-9301-969dbdfe4d85', 1, 'UI/UX Design', 'Improving user interfaces and user experience'),
       ('cbf1ebaf-cab8-42e8-93b5-c4aa02f2381f', 1, 'Big Data Analytics', 'Processing and analyzing big data sets'),
       ('59721847-17dc-41b2-9ae0-0e6619ecb2dd', 1, 'AI Research', 'Exploring AI models and solutions'),
       ('69cd6e0f-416e-4a4f-88eb-7a8d9a2dd591', 1, 'Blockchain', 'Implementing decentralized solutions'),
       ('3756ac1c-abe5-41c7-a77a-bb0337a54ca6', 1, 'IoT Solutions', 'Creating IoT architectures and systems'),
       ('17c2b261-42cd-40be-a9de-33aed6ef6e86', 1, 'Software Development',
        'Building software solutions for enterprise'),
       ('7bfcaf95-de8c-45ae-b1ff-3c18fa462d96', 1, 'Game Development', 'Design and develop game mechanics'),
       ('712026e9-f397-4972-9723-0d23e9fa083f', 1, 'Networking', 'Designing and maintaining network infrastructures'),
       ('f7f3d76c-789a-43bb-a889-6c57dc0483b3', 1, 'Digital Marketing', 'Designing digital marketing strategies'),
       ('43915b50-2971-456c-84e0-53d25c40963e', 1, 'SEO Optimization',
        'Optimizing website performance for search engines'),
       ('f5d16c63-200f-4d48-a9e0-31b11ed02829', 1, 'Technical Writing', 'Writing user manuals and technical guides'),
       ('f91d4496-1e22-4812-861e-885da53e2fe4', 1, 'ERP Implementation', 'Managing ERP system deployment'),
       ('4544e574-2604-4110-ab58-de8d534081a0', 1, 'Cloud Security', 'Securing cloud-based infrastructures'),
       ('ff431041-f6c2-4017-b85d-51bbc0cac965', 1, 'Data Engineering', 'Designing and managing data pipelines'),
       ('ad3c151f-022e-4b6c-83e1-439a51309aac', 1, 'Penetration Testing', 'Assessing security vulnerabilities'),
       ('d4d1cf0f-b662-43a6-84f0-031191776c90', 1, 'AI Model Deployment',
        'Deploying AI solutions in production environments'),
       ('6eb5713c-5d57-42df-b8c5-69854e247045', 1, 'Performance Optimization',
        'Improving application and system performance'),
       ('b8bf1d66-f139-41ac-8bc3-a4b4f7027bb7', 1, 'Cloud Solutions', 'Building optimized cloud services'),
       ('0634f949-e9ed-4332-af6a-4f2e39fe98d4', 1, 'Data Strategy', 'Creating strategies for data governance'),
       ('db82372a-663e-4a2e-8a0a-5367c4a04ead', 1, 'Mobile App Security', 'Securing mobile application deployments'),
       ('22c71aa6-1901-4f89-8bba-91b1527666ea', 1, 'Web Security', 'Implementing web security standards'),
       ('39063c19-713b-4150-aee7-20697fa6b0ee', 1, 'Cloud Infrastructure', 'Setting up scalable cloud infrastructures'),
       ('060fc416-9324-42a9-b776-16e052d917a0', 2, 'Leadership', 'Leading teams to success'),
       ('917f8d08-cb0a-4799-bd73-233532bf08d5', 2, 'Communication', 'Effective verbal and written communication'),
       ('3613dac9-49c1-4603-9060-fee7699d2b50', 2, 'Problem-Solving', 'Finding solutions to complex problems'),
       ('d977be27-a70c-4ab1-88ca-83e63355b238', 2, 'Time Management', 'Prioritizing tasks and meeting deadlines'),
       ('59d678be-83fb-4dfa-ac5d-531ba7022eee', 2, 'Team Collaboration', 'Working efficiently with team members'),
       ('b125d9ba-00b7-428a-92b6-1cece5eb3c66', 2, 'Adaptability', 'Adjusting to changing work environments'),
       ('f3d28f0c-0a09-42a5-ab12-19d28ea7e9d8', 2, 'Critical Thinking', 'Analyzing and making informed decisions'),
       ('7f8d3797-06e2-499c-b5a6-c93a621c46bb', 0, 'General Skill 1', 'Uncategorized general-purpose skill'),
       ('d2e2adc1-ad45-469a-9eff-9eaa37a4ac3b', 0, 'General Skill 2', 'Uncategorized general-purpose skill'),
       ('6d5f70fc-d064-4391-862f-4b0948f0e2dd', 0, 'General Skill 3', 'Uncategorized general-purpose skill');


--table CANDIDATE_SKILL
INSERT INTO jobtify_service.candidate_skill (can_id, skill_id, skill_level, more_infos, created_at, updated_at)
VALUES ('31fba4f2-256f-44b4-a4c7-5cff9a5b7942', '3c020408-134f-40cd-8d1f-451239325957', 2, 'Do something!!', CURRENT_TIMESTAMP,
        current_timestamp),
       ('31fba4f2-256f-44b4-a4c7-5cff9a5b7942', '4447bfab-d83c-47f0-a0cf-ed2ebfd252ac', 3, 'Do something!!', CURRENT_TIMESTAMP,
        current_timestamp),
       ('31fba4f2-256f-44b4-a4c7-5cff9a5b7942', '4ec19391-e475-45a4-a82a-975b58cd1420', 4, 'Do something!!', CURRENT_TIMESTAMP,
        current_timestamp),
       ('31fba4f2-256f-44b4-a4c7-5cff9a5b7942', '41673336-4248-484e-80cf-539545a0bdb9', 4, 'Do something!!', CURRENT_TIMESTAMP,
        current_timestamp),

       ('1b0f6caa-4553-4d16-9874-a3dbf0666488', '02ff5329-1c77-47a6-8990-2ab78fe7994a', 1, 'Do something!!', CURRENT_TIMESTAMP,
        current_timestamp),
       ('1b0f6caa-4553-4d16-9874-a3dbf0666488', '4447bfab-d83c-47f0-a0cf-ed2ebfd252ac', 1, 'Do something!!', CURRENT_TIMESTAMP,
        current_timestamp),
       ('1b0f6caa-4553-4d16-9874-a3dbf0666488', '3c020408-134f-40cd-8d1f-451239325957', 1, 'Do something!!', CURRENT_TIMESTAMP,
        current_timestamp),
       ('1b0f6caa-4553-4d16-9874-a3dbf0666488', '712026e9-f397-4972-9723-0d23e9fa083f', 1, 'Do something!!', CURRENT_TIMESTAMP,
        current_timestamp),

       ('d6acce12-365f-40b0-b8ec-df2fb5693692', 'f7f3d76c-789a-43bb-a889-6c57dc0483b3', 1, 'Do something!!', CURRENT_TIMESTAMP,
        current_timestamp),
       ('d6acce12-365f-40b0-b8ec-df2fb5693692', '43915b50-2971-456c-84e0-53d25c40963e', 1, 'Do something!!', CURRENT_TIMESTAMP,
        current_timestamp),
       ('d6acce12-365f-40b0-b8ec-df2fb5693692', '3c020408-134f-40cd-8d1f-451239325957', 1, 'Do something!!', CURRENT_TIMESTAMP,
        current_timestamp),
       ('d6acce12-365f-40b0-b8ec-df2fb5693692', '060fc416-9324-42a9-b776-16e052d917a0', 1, 'Do something!!', CURRENT_TIMESTAMP,
        current_timestamp),

       ('33ed0f00-b286-4972-95ec-b3a119b9c54c', 'd977be27-a70c-4ab1-88ca-83e63355b238', 2, 'Do something!!', CURRENT_TIMESTAMP,
        current_timestamp),
       ('33ed0f00-b286-4972-95ec-b3a119b9c54c', '59d678be-83fb-4dfa-ac5d-531ba7022eee', 3, 'Do something!!', CURRENT_TIMESTAMP,
        current_timestamp),
       ('33ed0f00-b286-4972-95ec-b3a119b9c54c', '43a73084-ecf4-4e29-b009-7612e642d78e', 2, 'Do something!!', CURRENT_TIMESTAMP,
        current_timestamp),
       ('33ed0f00-b286-4972-95ec-b3a119b9c54c', 'd2e2adc1-ad45-469a-9eff-9eaa37a4ac3b', 3, 'Do something!!', CURRENT_TIMESTAMP,
        current_timestamp),

       ('c6db837d-c46d-486c-807a-437a10f3490c', '6d5f70fc-d064-4391-862f-4b0948f0e2dd', 3, 'Do something!!', CURRENT_TIMESTAMP,
        current_timestamp),
       ('c6db837d-c46d-486c-807a-437a10f3490c', '59d678be-83fb-4dfa-ac5d-531ba7022eee', 2, 'Do something!!', CURRENT_TIMESTAMP,
        current_timestamp),
       ('c6db837d-c46d-486c-807a-437a10f3490c', '060fc416-9324-42a9-b776-16e052d917a0', 4, 'Do something!!', CURRENT_TIMESTAMP,
        current_timestamp),
       ('c6db837d-c46d-486c-807a-437a10f3490c', 'b8bf1d66-f139-41ac-8bc3-a4b4f7027bb7', 4, 'Do something!!', CURRENT_TIMESTAMP,
        current_timestamp),

       ('3c1db785-58cd-4223-8449-f805c82c7ad1', '6eb5713c-5d57-42df-b8c5-69854e247045', 4, 'Do something!!', CURRENT_TIMESTAMP,
        current_timestamp),
       ('3c1db785-58cd-4223-8449-f805c82c7ad1', 'ad3c151f-022e-4b6c-83e1-439a51309aac', 4, 'Do something!!', CURRENT_TIMESTAMP,
        current_timestamp),
       ('3c1db785-58cd-4223-8449-f805c82c7ad1', '4544e574-2604-4110-ab58-de8d534081a0', 4, 'Do something!!', CURRENT_TIMESTAMP,
        current_timestamp),
       ('3c1db785-58cd-4223-8449-f805c82c7ad1', '4ec19391-e475-45a4-a82a-975b58cd1420', 4, 'Do something!!', CURRENT_TIMESTAMP,
        current_timestamp),

       ('bd096e33-a5ca-4878-8e44-c6c79d059e7c', '4544e574-2604-4110-ab58-de8d534081a0', 2, 'Do something!!', CURRENT_TIMESTAMP,
        current_timestamp),
       ('bd096e33-a5ca-4878-8e44-c6c79d059e7c', '69cd6e0f-416e-4a4f-88eb-7a8d9a2dd591', 4, 'Do something!!', CURRENT_TIMESTAMP,
        current_timestamp),
       ('bd096e33-a5ca-4878-8e44-c6c79d059e7c', 'b125d9ba-00b7-428a-92b6-1cece5eb3c66', 4, 'Do something!!', CURRENT_TIMESTAMP,
        current_timestamp),
       ('bd096e33-a5ca-4878-8e44-c6c79d059e7c', '4447bfab-d83c-47f0-a0cf-ed2ebfd252ac', 3, 'Do something!!', CURRENT_TIMESTAMP,
        current_timestamp),

       ('acf86d11-49ba-4e02-b5ac-9c9c43719ef9', '4ec19391-e475-45a4-a82a-975b58cd1420', 4, 'Do something!!', CURRENT_TIMESTAMP,
        current_timestamp),
       ('acf86d11-49ba-4e02-b5ac-9c9c43719ef9', '4544e574-2604-4110-ab58-de8d534081a0', 4, 'Do something!!', CURRENT_TIMESTAMP,
        current_timestamp),
       ('acf86d11-49ba-4e02-b5ac-9c9c43719ef9', '59721847-17dc-41b2-9ae0-0e6619ecb2dd', 4, 'Do something!!', CURRENT_TIMESTAMP,
        current_timestamp),
       ('acf86d11-49ba-4e02-b5ac-9c9c43719ef9', 'b125d9ba-00b7-428a-92b6-1cece5eb3c66', 4, 'Do something!!', CURRENT_TIMESTAMP,
        current_timestamp),

       ('e8eddddc-dbc5-4aa1-b2cb-706b9ca6d8f3', '4447bfab-d83c-47f0-a0cf-ed2ebfd252ac', 4, 'Do something!!', CURRENT_TIMESTAMP,
        current_timestamp),
       ('e8eddddc-dbc5-4aa1-b2cb-706b9ca6d8f3', '43a73084-ecf4-4e29-b009-7612e642d78e', 4, 'Do something!!', CURRENT_TIMESTAMP,
        current_timestamp),
       ('e8eddddc-dbc5-4aa1-b2cb-706b9ca6d8f3', 'b125d9ba-00b7-428a-92b6-1cece5eb3c66', 4, 'Do something!!', CURRENT_TIMESTAMP,
        current_timestamp),
       ('e8eddddc-dbc5-4aa1-b2cb-706b9ca6d8f3', '43915b50-2971-456c-84e0-53d25c40963e', 4, 'Do something!!', CURRENT_TIMESTAMP,
        current_timestamp),

       ('350c3938-edce-4e04-b528-27ffcba6dd82', '4544e574-2604-4110-ab58-de8d534081a0', 2, 'Do something!!', CURRENT_TIMESTAMP,
        current_timestamp),
       ('350c3938-edce-4e04-b528-27ffcba6dd82', '4447bfab-d83c-47f0-a0cf-ed2ebfd252ac', 4, 'Do something!!', CURRENT_TIMESTAMP,
        current_timestamp),
       ('350c3938-edce-4e04-b528-27ffcba6dd82', '43915b50-2971-456c-84e0-53d25c40963e', 3, 'Do something!!', CURRENT_TIMESTAMP,
        current_timestamp),
       ('350c3938-edce-4e04-b528-27ffcba6dd82', 'b125d9ba-00b7-428a-92b6-1cece5eb3c66', 3, 'Do something!!', CURRENT_TIMESTAMP,
        current_timestamp);

--table JOB_SKILL
INSERT INTO jobtify_service.job_skill (job_id, skill_id, skill_level, more_infos, created_at, updated_at)
VALUES ('d2ff5b5b-943a-4df3-8301-8dc70e76efc2', '3c020408-134f-40cd-8d1f-451239325957', 3,
        'This job requires expertise in Java programming.', CURRENT_TIMESTAMP, current_timestamp),
       ('d2ff5b5b-943a-4df3-8301-8dc70e76efc2', '4447bfab-d83c-47f0-a0cf-ed2ebfd252ac', 2,
        'Python skills are essential for data processing tasks.', CURRENT_TIMESTAMP, current_timestamp),
       ('d2ff5b5b-943a-4df3-8301-8dc70e76efc2', 'f91d4496-1e22-4812-861e-885da53e2fe4', 4,
        'Data analysis skills are required to extract business insights.', CURRENT_TIMESTAMP, current_timestamp),

       ('21473a61-5a69-4d3b-87c5-9acf5a40be78', '41673336-4248-484e-80cf-539545a0bdb9', 3,
        'Machine learning expertise is critical for AI-related tasks.', CURRENT_TIMESTAMP, current_timestamp),
       ('21473a61-5a69-4d3b-87c5-9acf5a40be78', '02ff5329-1c77-47a6-8990-2ab78fe7994a', 2,
        'Cloud computing knowledge is needed for scalable solutions.', CURRENT_TIMESTAMP, current_timestamp),
       ('21473a61-5a69-4d3b-87c5-9acf5a40be78', '6967208b-2985-4fa9-9c9d-5e64a6915ba3', 4,
        'Cybersecurity skills are mandatory for network protection.', CURRENT_TIMESTAMP, current_timestamp),

       ('03116373-dd7f-44e1-88d9-83f67972e066', 'b9653698-1829-4897-9a64-8b3249829f79', 1,
        'Web development is required for designing user-facing systems.', CURRENT_TIMESTAMP, current_timestamp),
       ('03116373-dd7f-44e1-88d9-83f67972e066', '8af179f9-01bc-4cce-b5b4-c1c58a69bb6f', 2,
        'Basic mobile development knowledge is expected.', CURRENT_TIMESTAMP, current_timestamp),
       ('03116373-dd7f-44e1-88d9-83f67972e066', '7d4bc046-e843-42f1-80c5-c991be9232e6', 3,
        'Data visualization is important for clear reporting.', CURRENT_TIMESTAMP, current_timestamp),

       ('93403150-dec1-4a80-b28c-8ea9cd3861a8', '43a73084-ecf4-4e29-b009-7612e642d78e', 4,
        'DevOps skills are essential for maintaining CI/CD pipelines.', CURRENT_TIMESTAMP, current_timestamp),
       ('93403150-dec1-4a80-b28c-8ea9cd3861a8', '323bdf2d-85f2-4c65-9301-969dbdfe4d85', 3,
        'UI/UX design is necessary for improving the user experience.', CURRENT_TIMESTAMP, current_timestamp),
       ('93403150-dec1-4a80-b28c-8ea9cd3861a8', 'cbf1ebaf-cab8-42e8-93b5-c4aa02f2381f', 2,
        'Big data analytics is required for managing large data sets.', CURRENT_TIMESTAMP, current_timestamp),

       ('7f23be00-8e64-4fc6-a717-d7c10c92cc60', '59721847-17dc-41b2-9ae0-0e6619ecb2dd', 1,
        'AI research experience is critical for innovation.', CURRENT_TIMESTAMP, current_timestamp),
       ('7f23be00-8e64-4fc6-a717-d7c10c92cc60', '69cd6e0f-416e-4a4f-88eb-7a8d9a2dd591', 4,
        'Blockchain knowledge is needed for decentralized solutions.', CURRENT_TIMESTAMP, current_timestamp),
       ('7f23be00-8e64-4fc6-a717-d7c10c92cc60', '3756ac1c-abe5-41c7-a77a-bb0337a54ca6', 3,
        'IoT expertise is required for system integrations.', CURRENT_TIMESTAMP, current_timestamp),

       ('a12dedb6-559b-4bfa-b877-a4610fc6f86a', '17c2b261-42cd-40be-a9de-33aed6ef6e86', 2,
        'Software development skills are a key requirement.', CURRENT_TIMESTAMP, current_timestamp),
       ('a12dedb6-559b-4bfa-b877-a4610fc6f86a', '7bfcaf95-de8c-45ae-b1ff-3c18fa462d96', 3,
        'Game development knowledge is needed for this role.', CURRENT_TIMESTAMP, current_timestamp),
       ('a12dedb6-559b-4bfa-b877-a4610fc6f86a', '712026e9-f397-4972-9723-0d23e9fa083f', 4,
        'Networking expertise is critical for managing infrastructure.', CURRENT_TIMESTAMP, current_timestamp);


