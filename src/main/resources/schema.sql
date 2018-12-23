

CREATE TABLE IF NOT EXISTS Organization( -- таблица организаци
    id         INTEGER  PRIMARY KEY AUTO_INCREMENT, -- id организации.
    version    INTEGER NOT NULL,
    name       VARCHAR(50) NOT NULL, -- название организации.
    full_name   VARCHAR(50) UNIQUE NOT NULL, -- Полное название организации.
    address    VARCHAR(50) NOT NULL, -- Юридический адрес организации
     phone     VARCHAR(50) UNIQUE NOT NULL, -- телефон организации
     inn       VARCHAR(50) UNIQUE NOT NULL, -- инн организации
     kpp       VARCHAR(50) UNIQUE NOT NULL, -- кпп организации
     is_active  BOOLEAN -- активна ли организация.
    );

CREATE TABLE IF NOT EXISTS Office( --офис организации
    id         INTEGER  PRIMARY KEY AUTO_INCREMENT, --id офиса
    version    INTEGER NOT NULL,
    org_id     INTEGER NOT NULL, -- id организации
    name       VARCHAR(50) UNIQUE NOT NULL, --название офиса
    address    VARCHAR(50) NOT NULL,--адрес офиса
    phone      VARCHAR(50) UNIQUE NOT NULL, --телефоный номер офиса
    is_active   BOOLEAN --активный ли офис
    );

CREATE TABLE IF NOT EXISTS User ( -- таблица работник
    id         INTEGER  PRIMARY KEY AUTO_INCREMENT, -- id работника
    office_id   INTEGER NOT NULL, -- в каком офисе работает работник
    first_name  VARCHAR(50) NOT NULL, --Имя работника
    last_name   VARCHAR(50) NOT NULL, -- Фамилия работника
    second_name VARCHAR(50) NOT NULL, -- Отчество работника
    middle_name VARCHAR(50) NOT NULL, -- Среднее имя(В англоязычных именах)
    position  VARCHAR(50)  NOT NULL, -- должность работника
    doc_id      INTEGER NOT NULL, -- id документа
    citizenship_id       INTEGER NOT NULL, -- id страны.
    is_identified  BOOLEAN --индивицирован лм работник
    );

CREATE TABLE IF NOT EXISTS docs( -- таблица документов
    id         INTEGER PRIMARY KEY AUTO_INCREMENT, -- id документа
    name       VARCHAR (100) NOT NULL, -- Название документа
    number     VARCHAR(50) NOT NULL, -- номер документа
    doc_date    DATE, -- дата создания документа
    code       INTEGER NOT NULL, -- код документа
     );

CREATE TABLE IF NOT EXISTS Citizenship( -- таблица "Страна"
    id         INTEGER PRIMARY KEY AUTO_INCREMENT, -- id Страны
    name       VARCHAR (50) NOT NULL, -- Название страны
    code       INTEGER NOT NULL, -- Код страны
    );

CREATE INDEX IX_Organization_full_name ON Organization (full_name);
CREATE INDEX IX_Organization_inn ON Organization (inn);
CREATE INDEX IX_Organization_kpp ON Organization (kpp);
CREATE INDEX IX_Organization_is_active ON Organization (is_active);

CREATE INDEX IX_Office_name ON Office (name);
CREATE INDEX IX_Office_phone ON Office (phone);
CREATE INDEX IX_Office_is_active ON Office (is_active);

CREATE INDEX IX_User_first_name ON User (first_name);
CREATE INDEX IX_User_second_name ON User  (second_name);
CREATE INDEX IX_User_last_name ON User (last_name);
CREATE INDEX IX_User_user_position ON User  (position);


CREATE INDEX IX_Office_org_id ON Office(org_id);
ALTER TABLE Office ADD FOREIGN KEY (org_id) REFERENCES Organization(id);
-- orgId в таблице Office ссылыется по внешнему ключу
-- на  id организации Organization(id)

CREATE INDEX IX_User_Office_id ON User (office_id);
ALTER TABLE User ADD FOREIGN KEY (office_id) REFERENCES Office(id);
 -- officeId в таблице User_man ссылыется по внешнему ключу
 -- на  id офиса Office(id)
CREATE INDEX IX_User_doc_id ON User (doc_id);
ALTER TABLE User ADD FOREIGN KEY (doc_id) REFERENCES docs(id);

CREATE INDEX IX_User_citizenship_id ON User (citizenship_id);
ALTER TABLE User ADD FOREIGN KEY (citizenship_id) REFERENCES Citizenship(id);

-- КОММЕНТАРИИ
COMMENT ON TABLE Organization IS 'таблица организаци';
COMMENT ON COLUMN Organization.id IS 'id организации';
COMMENT ON COLUMN Organization.name IS 'название организации';
COMMENT ON COLUMN Organization.full_name IS 'Полное название организации';
COMMENT ON COLUMN Organization.address  IS 'Юридический адрес организации';
COMMENT ON COLUMN Organization.phone IS 'телефон организации';
COMMENT ON COLUMN Organization.inn IS 'инн организации';
COMMENT ON COLUMN Organization.kpp  IS 'кпп организации';
COMMENT ON COLUMN Organization.is_active IS 'активна ли организация';

COMMENT ON TABLE Office IS 'офис организации';
COMMENT ON COLUMN Office.org_id IS 'id организации';
COMMENT ON COLUMN Office.name IS 'название офиса';
COMMENT ON COLUMN Office.address IS 'адрес офиса';
COMMENT ON COLUMN Office.phone  IS 'телефоный номер офиса';
COMMENT ON COLUMN Office.is_active IS 'активный ли офис';

COMMENT ON TABLE User IS 'таблица работник';
COMMENT ON COLUMN User.id IS 'id работника';
COMMENT ON COLUMN User.office_id  IS 'в каком офисе работает работник';
COMMENT ON COLUMN User.first_name IS 'Имя работника';
COMMENT ON COLUMN User.last_name  IS 'Фамилия работника';
COMMENT ON COLUMN User.second_name IS 'Отчество работника';
COMMENT ON COLUMN User.middle_name IS 'Среднее имя(В англоязычных именах)';
COMMENT ON COLUMN User.position  IS 'должность работника';
COMMENT ON COLUMN User.doc_id IS 'id документа';
COMMENT ON COLUMN User.citizenship_id IS 'id страны.';
COMMENT ON COLUMN User.is_identified IS 'аиндивицирован лм работник';

COMMENT ON TABLE docs IS 'таблица документов';
COMMENT ON COLUMN docs.id IS 'id документа';
COMMENT ON COLUMN docs.name IS 'Название документа';
COMMENT ON COLUMN docs.number IS 'номер документа';
COMMENT ON COLUMN docs.doc_date  IS 'дата создания документа';
COMMENT ON COLUMN docs.code IS 'код документа';

COMMENT ON TABLE Citizenship IS 'таблица -Страна';
COMMENT ON COLUMN Citizenship.id IS 'id Страны';
COMMENT ON COLUMN Citizenship.name IS 'Название страны';
COMMENT ON COLUMN Citizenship.code IS 'Код страны';
