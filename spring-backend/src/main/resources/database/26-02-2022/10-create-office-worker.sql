-- liquibase formatted sql
-- changeset wj:1
CREATE TABLE public.office_worker (
                                      id integer NOT NULL,
                                      pin character varying(255),
                                      cash integer,
                                      email character varying(255),
                                      first_name character varying(255),
                                      last_name character varying(255),
                                      phone_number character varying(255),
                                      address_id integer,
                                      password character varying(255),
                                      office_worker_type character varying(255)
);

ALTER TABLE ONLY public.office_worker
    ADD CONSTRAINT office_worker_pkey PRIMARY KEY (id);

ALTER TABLE public.office_worker OWNER TO postgres;