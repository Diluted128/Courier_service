-- liquibase formatted sql
-- changeset wj:1
CREATE TABLE public.credit_card (
                    id integer NOT NULL,
                    cvv character varying(255),
                    card_number character varying(255),
                    expired character varying(255)
);

ALTER TABLE ONLY public.credit_card
    ADD CONSTRAINT credit_card_pkey PRIMARY KEY (id);

ALTER TABLE public.credit_card OWNER TO postgres;