# --- Created by Slick DDL
# To stop Slick DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table "PLATFORMS" ("ID" BIGSERIAL PRIMARY KEY,"NAME" VARCHAR(254) NOT NULL,"UPDATED_AT" timestamp default now() NOT NULL,"CREATED_AT" timestamp default now() NOT NULL);
create table "PRODUCTS" ("ID" BIGSERIAL PRIMARY KEY,"NAME" VARCHAR(254) NOT NULL,"PLATFORM_ID" BIGINT NOT NULL,"VERSION" VARCHAR(254) NOT NULL,"DESCRIPTION" VARCHAR(254),"URL" VARCHAR(254) NOT NULL,"UPDATED_AT" timestamp default now() NOT NULL,"CREATED_AT" timestamp default now() NOT NULL);

# --- !Downs

drop table "PRODUCTS";
drop table "PLATFORMS";

