-- liquibase formatted sql
--changeset wj:1 runOnChange:true

ALTER TABLE  ADDRESS ADD FOREIGN KEY (district_id) REFERENCES district(id);

ALTER TABLE ADMINISTRATOR ADD FOREIGN KEY (role_id) REFERENCES role(id);

ALTER TABLE CLIENT ADD FOREIGN KEY (address_id) REFERENCES address(id);

ALTER TABLE CLIENT ADD  FOREIGN KEY (credit_card_id) REFERENCES credit_card(id);

ALTER TABLE CLIENT ADD FOREIGN KEY (role_id) REFERENCES role(id);

ALTER TABLE COURIER ADD FOREIGN KEY (role_id) REFERENCES role(id);

ALTER TABLE  COURIER ADD  FOREIGN KEY (district_id) REFERENCES district(id);

ALTER TABLE  DB_ORDER ADD FOREIGN KEY (client_id) REFERENCES client(id);

ALTER TABLE  DB_ORDER ADD FOREIGN KEY (addresee) REFERENCES address(id);

ALTER TABLE  DB_ORDER ADD FOREIGN KEY (company_id) REFERENCES company(id);

ALTER TABLE  DB_ORDER ADD  FOREIGN KEY (courier_id) REFERENCES courier(id);

ALTER TABLE  DEPARTMENT ADD  FOREIGN KEY (address_id) REFERENCES address(id);

ALTER TABLE  DEPARTMENT ADD  FOREIGN KEY (company_id) REFERENCES company(id);

ALTER TABLE  ITEM ADD FOREIGN KEY (company_id) REFERENCES company(id);

ALTER TABLE OFFICE_WORKER ADD FOREIGN KEY (role_id) REFERENCES role(id);

ALTER TABLE  OFFICE_WORKER ADD  FOREIGN KEY (address_id) REFERENCES address(id);

ALTER TABLE  ORDER_ITEM ADD FOREIGN KEY (item_id) REFERENCES item(id);

ALTER TABLE  ORDER_ITEM ADD  FOREIGN KEY (order_id) REFERENCES db_order(id);

ALTER TABLE  PACK_LOCKER ADD FOREIGN KEY (address_id) REFERENCES address(id);

ALTER TABLE  PACK ADD  FOREIGN KEY (order_id) REFERENCES db_order(id);

ALTER TABLE  PACK ADD  FOREIGN KEY (pack_locker_id) REFERENCES pack_locker(id);

ALTER TABLE  PACK ADD  FOREIGN KEY (courier_id) REFERENCES courier(id);














