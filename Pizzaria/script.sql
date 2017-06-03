insert into permissao values(1,'ROLE_PIZZARIA');

insert into pizzaria values(1, now(), 'rua amazonas', 'admin', 'Pizzaria 1', '$2a$10$0ixp1qCrYmdCRQq8DFmR.eSVdXBnc.5psnniRc0bp5r6ldd1pR1G6');
insert into pizzaria values(2, now(), 'rua central', 'admin2', 'Pizzaria 2', '$2a$10$0ixp1qCrYmdCRQq8DFmR.eSVdXBnc.5psnniRc0bp5r6ldd1pR1G6');

insert into pizzaria_permissao values(1,1);
insert into pizzaria_permissao values(2,1);