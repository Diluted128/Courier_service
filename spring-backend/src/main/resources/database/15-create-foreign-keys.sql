-- liquibase formatted sql
--changeset wj:1 runOnChange:true

ALTER TABLE  db_orders
    ADD CONSTRAINT "FK1hq6doobj9gpsylfeq6vwyeca" FOREIGN KEY (client_id) REFERENCES client(id);

ALTER TABLE  address
    ADD CONSTRAINT "FK1w9mq8vt2qkbfkc52198trpgd" FOREIGN KEY (district_id) REFERENCES district(id);

ALTER TABLE  order_item
    ADD CONSTRAINT "FK48wbbl34riw345jgu8hksgwe9" FOREIGN KEY (item_id) REFERENCES item(id);

ALTER TABLE  item
    ADD CONSTRAINT "FK4ya9fmsbbxade2mx0osmi1r4n" FOREIGN KEY (company_id) REFERENCES company(id);

ALTER TABLE  pack_locker
    ADD CONSTRAINT "FK5iri2pygbtwx85k9kt6pj6upx" FOREIGN KEY (address_id) REFERENCES address(id);

ALTER TABLE  client
    ADD CONSTRAINT "FK64a9njla2p6s3bil4y4b1nbun" FOREIGN KEY (address_id) REFERENCES address(id);

ALTER TABLE  db_orders
    ADD CONSTRAINT "FK67ncegpraq1qbfowpbhbyqxre" FOREIGN KEY (addresee) REFERENCES address(id);

ALTER TABLE  pack
    ADD CONSTRAINT "FKfxcwan20jcpq52pea9m0bkdp9" FOREIGN KEY (order_id) REFERENCES db_orders(id);

ALTER TABLE  order_item
    ADD CONSTRAINT "FKgudsl0va08p9mc381uwy0xpkt" FOREIGN KEY (order_id) REFERENCES db_orders(id);

ALTER TABLE  courier
    ADD CONSTRAINT "FKi8egeev8imp5pd6edn16366lk" FOREIGN KEY (district_id) REFERENCES district(id);

ALTER TABLE  db_orders
    ADD CONSTRAINT "FKjpqn9qg3nnm9a7rape8qh2s6u" FOREIGN KEY (company_id) REFERENCES company(id);

ALTER TABLE  office_worker
    ADD CONSTRAINT "FKkoc3k7s28x2odx7egcoooynn6" FOREIGN KEY (address_id) REFERENCES address(id);

ALTER TABLE  department
    ADD CONSTRAINT "FKml8cwhsij8o9tkhbhqbesb8cy" FOREIGN KEY (company_id) REFERENCES company(id);

ALTER TABLE  pack
    ADD CONSTRAINT "FKpa2qhdr6ygyfftr9mca9vor31" FOREIGN KEY (pack_locker_id) REFERENCES pack_locker(id);

ALTER TABLE  pack
    ADD CONSTRAINT "FKr6st1kg9jycsn5ngkbv2bdlh2" FOREIGN KEY (courier_id) REFERENCES courier(id);

ALTER TABLE  client
    ADD CONSTRAINT "FKrdh45afxykhecaa271fqswuy" FOREIGN KEY (credit_card_id) REFERENCES credit_card(id);

ALTER TABLE  db_orders
    ADD CONSTRAINT "FKre3870s24o2dtfqkrymsydke3" FOREIGN KEY (courier_id) REFERENCES courier(id);

ALTER TABLE  department
    ADD CONSTRAINT "FKs6swbfkvr1o0kvgvh4ndp61wp" FOREIGN KEY (address_id) REFERENCES address(id);