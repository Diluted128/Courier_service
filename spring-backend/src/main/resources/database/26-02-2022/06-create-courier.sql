-- liquibase formatted sql
-- changeset wj:1
CREATE TABLE public.courier (
                                id integer NOT NULL,
                                PIN character varying(255),
                                email character varying(255),
                                first_name character varying(255),
                                last_name character varying(255),
                                phone_number character varying(255),
                                district_id integer,
                                password character varying(255),
                                distance integer,
                                location character varying(255),
                                cash real
);

ALTER TABLE ONLY public.courier
    ADD CONSTRAINT deliver_pkey PRIMARY KEY (id);

ALTER TABLE public.courier OWNER TO postgres;