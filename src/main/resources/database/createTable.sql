-- CREATE DATABASE user;

CREATE SCHEMA users_scheme;

CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE users_scheme."user" (
                                     id UUID DEFAULT uuid_generate_v4() PRIMARY KEY,
                                     "username" VARCHAR(255) NOT NULL,
                                     "email" VARCHAR(100) NOT NULL,
                                     "password" VARCHAR(3000) NOT NULL,
                                     "status_user" VARCHAR(20),
                                     "date_create" TIMESTAMP default now(),
                                     "date_update" TIMESTAMP default now()
);

CREATE TABLE users_scheme."profiles" (
                                         id UUID PRIMARY KEY,
                                         user_id UUID NOT NULL,
                                         first_name VARCHAR(255) NOT NULL,
                                         last_name VARCHAR(255) NOT NULL,
                                         date_of_birth DATE,
                                         gender VARCHAR(6) NOT NULL,
                                         biography VARCHAR(2000),
                                         profile_picture VARCHAR(1024),
                                         created_at TIMESTAMP default now(),
                                         updated_at TIMESTAMP default now(),
                                         FOREIGN KEY (user_id) REFERENCES users_scheme."user" (id)
);

CREATE TABLE users_scheme."user_subscribers" (
                                                 id UUID PRIMARY KEY,
                                                 user_id UUID NOT NULL,
                                                 friend_id UUID NOT NULL,
                                                 friendship_status VARCHAR(255) NOT NULL,
                                                 created_at TIMESTAMP default now(),
                                                 updated_at TIMESTAMP default now(),
                                                 FOREIGN KEY (user_id) REFERENCES users_scheme."user"(id),
                                                 FOREIGN KEY (friend_id) REFERENCES users_scheme."user"(id)
);