INSERT INTO Organization (id, version, name, full_name, address, phone, inn, kpp, is_active) VALUES (1,1,'Biline', 'BEELINE LTD', 'ул.Цюрупы, 16', '8(499)123-45-67','beeline-inn', 'beeline-kpp',true);

INSERT INTO Organization (id, version, name,  full_name, address, phone, inn, kpp, is_active) VALUES (2,1,'Megafon', 'MEGAFON LTD', 'ул.Холмогоры, 16', '8(499)123-99-99','megafon-inn', 'megafon-kpp', true);

INSERT INTO Office (id, version,org_id, name, address, phone, is_active) VALUES (1,1, 1,'Билайн-отрадное' ,'ул.отрадная, 7','8(499)123-45-01', true);
INSERT INTO Office (id, version,org_id, name, address, phone, is_active) VALUES (2,1, 1,'Билайн-вднх' ,'ул.вднх, 7','8(499)123-45-02', true);

INSERT INTO Office (id, version,org_id, name, address, phone, is_active) VALUES (3,1, 2,'Мегафон-измайлово' ,'ул.измайлово, 7','8(499)123-99-01', true);
INSERT INTO Office (id, version,org_id, name, address, phone, is_active) VALUES (4,1, 2,'Мегафон-марьино' ,'ул.марьино, 7','8(499)123-99-02', true);



INSERT INTO docs (id, name, number, doc_date, code) VALUES (1,'паспорт', '123123123','2010-10-10', 25);
INSERT INTO docs (id, name, number, doc_date, code) VALUES (2,'воен.билет', '73753573','2010-10-10', 25);
INSERT INTO docs (id, name, number, doc_date, code) VALUES (3,'паспорт', '73793345','2010-10-10', 25);
INSERT INTO docs (id, name, number, doc_date, code) VALUES (4,'вод.удост.', '8634334364','2010-10-10', 25);
INSERT INTO docs (id, name, number, doc_date, code) VALUES (5,'паспорт', '123123123','2010-10-10', 25);
INSERT INTO docs (id, name, number, doc_date, code) VALUES (6,'воен. билет', '986737343','2010-10-10', 25);
INSERT INTO docs (id, name, number, doc_date, code) VALUES (7,'паспорт', '6884534334','2010-10-10', 25);
INSERT INTO docs (id, name, number, doc_date, code) VALUES (8,'паспорт', '3333333333','2010-10-10', 25);

INSERT INTO Citizenship (id, name, code) VALUES (1, 'РФ', 323);

INSERT INTO Citizenship (id, name, code) VALUES (2, 'ЕС',584);

INSERT INTO User (id,version, office_id, first_name, last_name, second_name, middle_name, position, phone, doc_id, citizenship_id, is_identified) VALUES (1,1, 1, 'Пётр', 'иванов', 'иванович', 'iii', 'менеджер','333331',3,1,true);

INSERT INTO User (id,version, office_id, first_name, last_name, second_name, middle_name, position, phone, doc_id, citizenship_id, is_identified) VALUES (2,1, 1, 'Яушев ', 'Юрий ', 'Мечиславович', 'iii', 'директор','333332',1,1,true);

INSERT INTO User(id, version, office_id, first_name, last_name, second_name, middle_name, position, phone, doc_id, citizenship_id, is_identified) VALUES (3, 1,2, ' Тимур ', 'Гавриленко', 'Фомевич', 'iii', 'менеджер','333333',5,2,true);

INSERT INTO User (id,version,  office_id, first_name, last_name, second_name, middle_name, position, phone, doc_id, citizenship_id, is_identified) VALUES (4,1, 2, 'Кондрат ', 'Катасонов ', 'Владимирович', 'iii', 'директор','333334',2,1,true);

INSERT INTO User(id,version,  office_id, first_name, last_name, second_name, middle_name, position, phone, doc_id, citizenship_id, is_identified) VALUES (5,1, 3, ' Севастьян ', 'Рождественский', 'Касьянович', 'iii', 'менеджер','333335',8,2,true);

INSERT INTO User(id, version, office_id, first_name, last_name, second_name, middle_name, position, phone, doc_id, citizenship_id, is_identified) VALUES (6, 1,3, ' Никанор ', 'Ябловский', 'Сидорович', 'iii', 'директор','333336',6,1,true);

INSERT INTO User (id,version,  office_id, first_name, last_name, second_name, middle_name, position, phone, doc_id, citizenship_id, is_identified) VALUES (7,1, 4, ' Роман ', 'Потапов', ' Аникитевич', 'iii', 'менеджер','333337',4,1,true);


INSERT INTO User (id, version, office_id, first_name, last_name, second_name, middle_name, position, phone, doc_id, citizenship_id, is_identified) VALUES (8,1, 4, ' Ираклий ', 'Макаров', 'Сергеевич', 'iii', 'уборщик','333338',7,1,true);