-- liquibase formatted sql
-- changeset wj:1
CREATE TABLE public.order_item (
                                   order_id integer NOT NULL,
                                   item_id integer NOT NULL
);

ALTER TABLE public.order_item OWNER TO postgres;