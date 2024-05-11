-- Personas / Principales --

-- TipoIdUsuario
CREATE TABLE user_id_type (

    code SERIAL PRIMARY KEY,
    name VARCHAR(30) NOT NULL

);

CREATE UNIQUE INDEX UIDX_uit ON user_id_type(name);

-- TipoUsuario
CREATE TABLE user_type (

    code SERIAL PRIMARY KEY,
    name VARCHAR(30) NOT NULL

);

CREATE UNIQUE INDEX UIDX_ust ON user_type(name);

-- Usuario
CREATE TABLE users (

    code SERIAL PRIMARY KEY,
    id_type_code INT REFERENCES user_id_type(code),
    id INT NOT NULL,
    name VARCHAR(100) NOT NULL,
    sign_up_date DATE NOT NULL,
    username VARCHAR(30) NOT NULL,
    password VARCHAR(20) NOT NULL,
    address VARCHAR(200) NOT NULL,
    phone VARCHAR(200) NOT NULL,
    email VARCHAR(100) NOT NULL,
    user_type_code INT REFERENCES user_type(code),
    verified BOOLEAN NOT NULL

);

CREATE UNIQUE INDEX UIDX_usr_id ON users(id_type_code, id);
CREATE UNIQUE INDEX UIDX_usr_username ON users(username);
CREATE UNIQUE INDEX UIDX_usr_email ON users(email);

-- Localización / Principales --

-- País
CREATE TABLE countries (

    code SERIAL PRIMARY KEY,
    name VARCHAR(60) NOT NULL

);

CREATE UNIQUE INDEX UIDX_cou ON countries(name);

-- Departamento/Provincia
CREATE TABLE provinces (

    code SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    country_code INT REFERENCES countries(code)

);

CREATE UNIQUE INDEX UIDX_prv ON provinces(name, country_code);

-- Ciudad
CREATE TABLE cities (

    code SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    province_code INT REFERENCES provinces(code)

);

CREATE UNIQUE INDEX UIDX_cit ON cities(name, province_code);

-- TipoIdOrganización
CREATE TABLE org_id_types (

    code SERIAL PRIMARY KEY,
    name VARCHAR(30) NOT NULL

);

CREATE UNIQUE INDEX UIDX_oit ON org_id_types(name);

-- TipoMódulo
CREATE TABLE module_types (

    code SERIAL PRIMARY KEY,
    name VARCHAR(30) NOT NULL

);

CREATE UNIQUE INDEX UIDX_mdt ON module_types(name);

-- TipoSede
CREATE TABLE sectional_types (

    code SERIAL PRIMARY KEY,
    name VARCHAR(30) NOT NULL

);

CREATE UNIQUE INDEX UIDX_sct ON sectional_types(name);

-- Organización
CREATE TABLE organizations (

    code SERIAL PRIMARY KEY,
    id_type_code INT REFERENCES org_id_types(code),
    id INT NOT NULL,
    name VARCHAR(70) NOT NULL,
    description VARCHAR(200) NOT NULL,
    admin_code INT REFERENCES users(code),
    verified BOOLEAN NOT NULL

);

CREATE UNIQUE INDEX UIDX_org ON organizations(id_type_code, id);

-- Sede
CREATE TABLE sectionals (

    code SERIAL PRIMARY KEY,
    organization_code INT REFERENCES organizations(code),
    name VARCHAR(70) NOT NULL,
    location VARCHAR(100) NOT NULL,
    phone INT NOT NULL,
    email VARCHAR(100) NOT NULL,
    admin_code INT REFERENCES users(code)

);

CREATE UNIQUE INDEX UIDX_sec ON sectionals(organization_code, location);

-- Módulo
CREATE TABLE modules (

    code SERIAL PRIMARY KEY,
    sectional_code INT REFERENCES sectionalS(code),
    type_code INT REFERENCES module_typeS(code),
    identifier VARCHAR(30) NOT NULL

);

CREATE UNIQUE INDEX UIDX_mod ON modules(sectional_code, identifier, type_code);

-- Reservas / Principales --

-- EstadoReserva
CREATE TABLE booking_status (

    code SERIAL PRIMARY KEY,
    name VARCHAR(30) NOT NULL

);

CREATE UNIQUE INDEX UIDX_bks ON booking_status(name);

-- TipoReserva
CREATE TABLE booking_types (

    code SERIAL PRIMARY KEY,
    name VARCHAR(30) NOT NULL

);

CREATE UNIQUE INDEX UIDX_bkt ON booking_types(name);

-- Personas / Intermedias --

-- Disponibilidad
CREATE TABLE availabilities (

    code SERIAL PRIMARY KEY,
    worker_code INT REFERENCES users(code),
    module_code INT REFERENCES modules(code),
    date DATE NOT NULL,
    start_time TIME NOT NULL,
    end_time TIME NOT NULL

);

CREATE UNIQUE INDEX UIDX_ava ON availabilities(worker_code, date, start_time, end_time);

-- UsuarioSede
CREATE TABLE sectional_users (

    code SERIAL PRIMARY KEY,
    user_code INT REFERENCES users(code),
    sectional_code INT REFERENCES sectionals(code)

);

CREATE UNIQUE INDEX UIDX_seu ON sectional_users(user_code, sectional_code);

-- UsuarioOrganización
CREATE TABLE organization_users (

    code SERIAL PRIMARY KEY,
    user_code INT REFERENCES users(code),
    organization_code INT REFERENCES organizations(code)

);

CREATE UNIQUE INDEX UIDX_oru ON organization_users(user_code, organization_code);

-- Reservas / Intermedias --

-- Reserva
CREATE TABLE bookings (

    code SERIAL PRIMARY KEY,
    client_code INT REFERENCES users(code),
    availability_code INT REFERENCES availabilities(code),
    type_code INT REFERENCES booking_types(code),
    status_code INT REFERENCES booking_status(code)

);

CREATE UNIQUE INDEX UIDX_bok ON bookings(client_code, availability_code);
