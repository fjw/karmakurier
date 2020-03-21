-- Adminer 4.7.6 PostgreSQL dump
\connect "postgres";
CREATE SEQUENCE person_id_seq INCREMENT 1 MINVALUE 1 MAXVALUE 2147483647 START  CACHE 1;
CREATE TABLE "public"."person" (
    "firstName" character varying NOT NULL,
    "lastName" character varying NOT NULL,
    "postalCode" character varying NOT NULL,
    "street" character varying NOT NULL,
    "city" character varying NOT NULL,
    "phoneNumber" character varying NOT NULL,
    "id" integer DEFAULT nextval('person_id_seq') NOT NULL,
    CONSTRAINT "person_id" PRIMARY KEY ("id")
) WITH (oids = false);
CREATE SEQUENCE requester_id_seq INCREMENT 1 MINVALUE 1 MAXVALUE 2147483647 START  CACHE 1;
CREATE TABLE "public"."requester" (
    "person_id" integer NOT NULL,
    "shopping_list" character varying NOT NULL,
    "dietary_requirements" character varying NOT NULL,
    "premium" boolean NOT NULL,
    "cash" boolean NOT NULL,
    "max_amount" numeric NOT NULL,
    "id" integer DEFAULT nextval('requester_id_seq') NOT NULL,
    CONSTRAINT "requester_id" PRIMARY KEY ("id"),
    CONSTRAINT "requester_person_id_fkey" FOREIGN KEY (person_id) REFERENCES person(id) ON UPDATE CASCADE ON DELETE CASCADE NOT DEFERRABLE
) WITH (oids = false);
CREATE SEQUENCE supporter_id_seq INCREMENT 1 MINVALUE 1 MAXVALUE 2147483647 START  CACHE 1;
CREATE TABLE "public"."supporter" (
    "person_id" integer NOT NULL,
    "email" character varying NOT NULL,
    "transport" character varying NOT NULL,
    "availability" character varying NOT NULL,
    "id" integer DEFAULT nextval('supporter_id_seq') NOT NULL,
    CONSTRAINT "supporter_id" PRIMARY KEY ("id"),
    CONSTRAINT "supporter_person_id_fkey" FOREIGN KEY (person_id) REFERENCES person(id) ON UPDATE CASCADE ON DELETE CASCADE NOT DEFERRABLE
) WITH (oids = false);
-- 2020-03-21 20:50:38.820662+00