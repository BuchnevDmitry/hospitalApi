create table medical_card
(
    id serial primary key,
    date_create date not null,
    status bool not null
);

create table patient
(
    id serial primary key,
    fio varchar not null,
    phone_number varchar unique not null,
    address varchar not null,
    medical_card_id int unique not null,

    foreign key (medical_card_id) references medical_card(id)
);

create table doctor
(
    id serial primary key,
    fio varchar not null,
    specalization text not null
);

create table visit
(
    id serial primary key,
    date_visit date not null,
    patient_id int references patient (id),
    doctor_id int references doctor (id)
);

create table department
(
    id serial primary key,
    name varchar unique not null,
    address varchar not null
);

create table doctor_department
(
    doctor_id int,
    department_id int,

    primary key (doctor_id, department_id)
);

create table service
(
    id serial primary key,
    name varchar not null,
    description text not null,
    date_rendering date not null,
    price int not null,

    department_id int references department (id)
);

create table service_visit
(
    service_id int,
    visit_id int,

    primary key (service_id, visit_id)
);

