-- liquibase formatted sql
-- changeset wj:1
CREATE TABLE public.client (
                               id integer NOT NULL,
                               email character varying(255),
                               first_name character varying(255),
                               last_name character varying(255),
                               password character varying(255),
                               phone_number character varying(255),
                               address_id integer,
                               credit_card_id integer
);

ALTER TABLE ONLY public.client
    ADD CONSTRAINT client_pkey PRIMARY KEY (id);

ALTER TABLE public.client OWNER TO postgres;