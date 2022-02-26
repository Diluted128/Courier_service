-- liquibase formatted sql
-- changeset wj:1
CREATE TABLE public.address (
                    id integer NOT NULL,
                    flat_number character varying(255),
                    local_number character varying(255),
                    location character varying(255),
                    postal_code character varying(255),
                    street character varying(255),
                    town character varying(255),
                    district_id integer
);

ALTER TABLE ONLY public.address
    ADD CONSTRAINT address_pkey PRIMARY KEY (id);

ALTER TABLE public.address OWNER TO postgres;