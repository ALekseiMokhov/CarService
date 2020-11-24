CREATE USER IF NOT EXISTS "SA" SALT '332595ab53680f56' HASH '0e1e55b02cc3e5d005710628cc84e8a6ede0b7470d9541035e0d79772bf181ab' ADMIN;
CREATE SCHEMA IF NOT EXISTS "SENLA" AUTHORIZATION "SA";
CREATE CACHED TABLE "PUBLIC"."USER_ROLES"(
    "USER_ID" BINARY NOT NULL,
    "ROLES" VARCHAR(255)
);
CREATE CACHED TABLE "PUBLIC"."USERS"(
    "ID" BINARY NOT NULL,
    "NAME" VARCHAR(255),
    "PASSWORD" VARCHAR(255)
);
CREATE CACHED TABLE "PUBLIC"."PLACES"(
    "ID" BINARY NOT NULL,
    "BOOKEDDATES" BINARY(255)
);
CREATE CACHED TABLE "PUBLIC"."ORDERS"(
    "ID" BINARY NOT NULL,
    "DATEBOOKED" DATE,
    "FINISHOFEXECUTION" DATE,
    "STARTOFEXECUTION" DATE,
    "STATUS" INTEGER,
    "VERSION" BIGINT,
    "PLACE_ID" BINARY
);
CREATE CACHED TABLE "PUBLIC"."MASTERS"(
    "ID" BINARY NOT NULL,
    "BOOKEDDATES" BINARY(255),
    "DAILYPAYMENT" DOUBLE NOT NULL,
    "FULLNAME" VARCHAR(255),
    "SPECIALITY" VARCHAR(255),
    "VERSION" BIGINT,
    "ORDER_ID" BINARY
);
ALTER TABLE "PUBLIC"."USER_ROLES" ADD CONSTRAINT "PUBLIC"."FKJUWNGUPHJ5T4RHH2SWD2AG6UV" FOREIGN KEY("USER_ID") REFERENCES "PUBLIC"."USERS"("ID") NOCHECK;
ALTER TABLE "PUBLIC"."USERS" ADD CONSTRAINT "PUBLIC"."CONSTRAINT_4D" PRIMARY KEY("ID");
ALTER TABLE "PUBLIC"."PLACES" ADD CONSTRAINT "PUBLIC"."CONSTRAINT_8C" PRIMARY KEY("ID");
ALTER TABLE "PUBLIC"."ORDERS" ADD CONSTRAINT "PUBLIC"."FKOQ6PBD7UM89XCCACM0XSK0XJX" FOREIGN KEY("PLACE_ID") REFERENCES "PUBLIC"."PLACES"("ID") NOCHECK;
ALTER TABLE "PUBLIC"."ORDERS" ADD CONSTRAINT "PUBLIC"."CONSTRAINT_8" PRIMARY KEY("ID");
ALTER TABLE "PUBLIC"."MASTERS" ADD CONSTRAINT "PUBLIC"."FK8IF4V118YBOBTOK6H9HV9H8VC" FOREIGN KEY("ORDER_ID") REFERENCES "PUBLIC"."ORDERS"("ID") NOCHECK;
ALTER TABLE "PUBLIC"."MASTERS" ADD CONSTRAINT "PUBLIC"."CONSTRAINT_5" PRIMARY KEY("ID");
-- 1 +/- SELECT COUNT(*) FROM PUBLIC.USER_ROLES;
-- 1 +/- SELECT COUNT(*) FROM PUBLIC.USERS;
-- 0 +/- SELECT COUNT(*) FROM PUBLIC.PLACES;
-- 0 +/- SELECT COUNT(*) FROM PUBLIC.ORDERS;
-- 0 +/- SELECT COUNT(*) FROM PUBLIC.MASTERS;
(19 строки, 27 ms)