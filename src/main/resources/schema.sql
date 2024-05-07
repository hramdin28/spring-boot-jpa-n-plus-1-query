create table TEAM
(
    id   varchar(36) not null,
    name varchar(255),
    primary key (id)
);


create table PLAYER
(
    num      integer     not null,
    id       varchar(36) not null,
    team_id  varchar(36) not null,
    name     varchar(255),
    position varchar(255) check (position in ('FORWARD', 'MIDFIELDER', 'DEFENDER')),
    primary key (id),
    CONSTRAINT fk_player_team FOREIGN KEY (team_id) REFERENCES team (id)
);

