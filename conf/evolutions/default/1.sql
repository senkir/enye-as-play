# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table mobile_application (
  name                      varchar(255),
  id                        bigint,
  platform                  varchar(255),
  version_name              varchar(255),
  preview                   boolean,
  updated_at                varchar(255),
  created_at                varchar(255))
;




# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists mobile_application;

SET REFERENTIAL_INTEGRITY TRUE;

