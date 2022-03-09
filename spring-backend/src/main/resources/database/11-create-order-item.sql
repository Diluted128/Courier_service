-- liquibase formatted sql
-- changeset wj:1 runOnChange:true
CREATE TABLE order_item (
                                   order_id integer NOT NULL,
                                   item_id integer NOT NULL
);
