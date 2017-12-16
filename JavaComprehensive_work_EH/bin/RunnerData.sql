connect 'jdbc:derby:RunnerDB;create=true';

create table RunnerStats (
    name     varchar(20),
    speed    double,
    restPct  double
    );

insert into RunnerStats values ( 'Tortoise',  10,  0 );
insert into RunnerStats values ( 'Hare',     100, 90 );
insert into RunnerStats values ( 'Dog',       50, 70 );
insert into RunnerStats values ( 'Cat',       30, 75 );

disconnect;
