create table medical_card
(
    id serial primary key,
    date_create date not null,
    status bool not null
);

create table department
(
    id serial primary key,
    name varchar unique not null,
    address varchar not null
);

create table patient
(
    id serial primary key,
    fio varchar not null,
    phone_number varchar unique not null,
    address varchar not null
);

create table service
(
    id serial primary key,
    name varchar not null,
    description text not null,
    date_rendering date not null,
    price int not null,

    department_id int references department (id) on delete set null
);

create table doctor
(
    id serial primary key,
    fio varchar not null,
    specalization text not null,
    department_id int references department (id) on delete set null
);

create table visit
(
    id serial primary key,
    date_visit date not null,
    patient_id int references patient (id) on delete set null,
    doctor_id int references doctor (id) on delete set null
);

create table service_visit
(
    service_id int,
    visit_id int,

    primary key (service_id, visit_id)
);

