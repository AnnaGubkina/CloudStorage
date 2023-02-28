insert into netology_diploma.users (username, password)
values ('anna@gmail.com', '$2y$10$Tl9yXUxqT9PyJQKirUMWBuV/vL5DRfEPKBWH5.CxhuxJ/ofGIoYmi'),
       ('User1@mail.ru', '$2y$10$ou4Vo91eLCTa43nXFZcSG.W0jZRmX5U37n7OQ.5cbAtCXEvvRTV6W');

insert into netology_diploma.roles (name)
values ('ROLE_USER'),
       ('ROLE_ADMIN');

insert into netology_diploma.user_roles (user_id, role_id)
values (1, 2),
       (2, 1);