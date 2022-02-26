-- liquibase formatted sql
-- changeset wj:1
CREATE TABLE public.db_orders (
                               id integer NOT NULL,
                               date character varying(255),
                               status character varying(255),
                               total_price real NOT NULL,
                               client_id integer,
                               company_id integer,
                               tip real NOT NULL,
                               courier_id integer,
                               reward real,
                               addresee integer
);

ALTER TABLE ONLY public.db_orders
    ADD CONSTRAINT orders_pkey PRIMARY KEY (id);

ALTER TABLE public.db_orders OWNER TO postgres;