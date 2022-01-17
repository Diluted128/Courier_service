--
-- PostgreSQL database dump
--

-- Dumped from database version 14.1
-- Dumped by pg_dump version 14.1

-- Started on 2022-01-17 14:01:29

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 2 (class 3079 OID 16384)
-- Name: adminpack; Type: EXTENSION; Schema: -; Owner: -
--

CREATE EXTENSION IF NOT EXISTS adminpack WITH SCHEMA pg_catalog;


--
-- TOC entry 3434 (class 0 OID 0)
-- Dependencies: 2
-- Name: EXTENSION adminpack; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION adminpack IS 'administrative functions for PostgreSQL';


SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 211 (class 1259 OID 17886)
-- Name: address; Type: TABLE; Schema: public; Owner: postgres
--

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


ALTER TABLE public.address OWNER TO postgres;

--
-- TOC entry 212 (class 1259 OID 17893)
-- Name: application; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.application (
    id integer NOT NULL,
    email character varying(255),
    phone_number character varying(255),
    sender_name character varying(255),
    type integer
);


ALTER TABLE public.application OWNER TO postgres;

--
-- TOC entry 213 (class 1259 OID 17900)
-- Name: client; Type: TABLE; Schema: public; Owner: postgres
--

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


ALTER TABLE public.client OWNER TO postgres;

--
-- TOC entry 214 (class 1259 OID 17907)
-- Name: company; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.company (
    id integer NOT NULL,
    name character varying(255),
    type character varying(255)
);


ALTER TABLE public.company OWNER TO postgres;

--
-- TOC entry 215 (class 1259 OID 17912)
-- Name: credit_card; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.credit_card (
    id integer NOT NULL,
    cvv character varying(255),
    card_number character varying(255),
    expired character varying(255)
);


ALTER TABLE public.credit_card OWNER TO postgres;

--
-- TOC entry 216 (class 1259 OID 17919)
-- Name: deliver; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.deliver (
    id integer NOT NULL,
    pesel character varying(255),
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


ALTER TABLE public.deliver OWNER TO postgres;

--
-- TOC entry 222 (class 1259 OID 18068)
-- Name: department; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.department (
    id integer NOT NULL,
    address_id integer,
    company_id integer
);


ALTER TABLE public.department OWNER TO postgres;

--
-- TOC entry 217 (class 1259 OID 17926)
-- Name: district; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.district (
    id integer NOT NULL,
    name character varying(255)
);


ALTER TABLE public.district OWNER TO postgres;

--
-- TOC entry 210 (class 1259 OID 17885)
-- Name: hibernate_sequence; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.hibernate_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.hibernate_sequence OWNER TO postgres;

--
-- TOC entry 223 (class 1259 OID 18088)
-- Name: hibernate_sequences; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.hibernate_sequences (
    sequence_name character varying(255) NOT NULL,
    next_val bigint
);


ALTER TABLE public.hibernate_sequences OWNER TO postgres;

--
-- TOC entry 221 (class 1259 OID 18036)
-- Name: item; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.item (
    id integer NOT NULL,
    description character varying(255),
    name character varying(255),
    price real NOT NULL,
    size character varying(255),
    company_id integer
);


ALTER TABLE public.item OWNER TO postgres;

--
-- TOC entry 218 (class 1259 OID 17931)
-- Name: office_worker; Type: TABLE; Schema: public; Owner: postgres
--

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


ALTER TABLE public.office_worker OWNER TO postgres;

--
-- TOC entry 224 (class 1259 OID 18095)
-- Name: order_item; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.order_item (
    order_id integer NOT NULL,
    item_id integer NOT NULL
);


ALTER TABLE public.order_item OWNER TO postgres;

--
-- TOC entry 220 (class 1259 OID 18021)
-- Name: order_type; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.order_type (
    id integer NOT NULL,
    price real NOT NULL,
    type character varying(255)
);


ALTER TABLE public.order_type OWNER TO postgres;

--
-- TOC entry 225 (class 1259 OID 18098)
-- Name: orders; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.orders (
    id integer NOT NULL,
    date character varying(255),
    status character varying(255),
    total_price real NOT NULL,
    client_id integer,
    company_id integer,
    tip real NOT NULL,
    deliver_id integer,
    reward real,
    addresee integer
);


ALTER TABLE public.orders OWNER TO postgres;

--
-- TOC entry 226 (class 1259 OID 18105)
-- Name: pack; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.pack (
    id integer NOT NULL,
    deliver_id integer,
    order_id integer,
    pack_locker_id integer
);


ALTER TABLE public.pack OWNER TO postgres;

--
-- TOC entry 219 (class 1259 OID 17948)
-- Name: pack_locker; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.pack_locker (
    id integer NOT NULL,
    address_id integer
);


ALTER TABLE public.pack_locker OWNER TO postgres;

--
-- TOC entry 3413 (class 0 OID 17886)
-- Dependencies: 211
-- Data for Name: address; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.address (id, flat_number, local_number, location, postal_code, street, town, district_id) FROM stdin;
51	2		\N	31-112	Smoleńsk	Kraków	1
53	13		\N	31-112	Smoleńsk	Kraków	1
55	7		\N	33-332	Józefa Sarego	Kraków	1
57	12		\N	31-116	Studencka	Kraków	1
11	54	3	\N	21-423	Malinowa	Kraków	\N
1	15	\N	50.06838422249052,19.940506279883532	31-150	Swiętego Filipa	Kraków	1
2	13	\N	50.05775081890523,19.943025317690612	31-038	Starowiślana	Kraków	1
3	\N	\N	50.07735534744172,19.926644820385505	30-011	Wrocławska	Kraków	2
4	\N	\N	50.07013668581254,19.91385965388764	30-001	Krowodrza	Kraków	2
5	23	\N	50.07013668581254,19.91385965388764	30-103	Michała Stachowicza	Kraków	3
6	4	\N	50.045973784866725,19.92695016269066	30-337	Władysława Mitkowskiego	Kraków	4
7	5	\N	50.043142503398066,19.951345824452694	30-537	Andrzeja Potebni	Kraków	5
8	\N	\N	50.04977951249568, 19.968268267273555	30-703	Zabłocie	Kraków	5
9	51	\N	50.074619738875384,19.95803223400859	31-510	Rakowicka	Kraków	6
10	28	\N	50.043142503398066,19.951345824452694	31-543	Pułkownika Francesco Nullo	Kraków	6
14	64	\N	50.079688716788766,19.91865679904364	33-079	Aleja Kijowska	Kraków	2
15	7	\N	50.07622731560304,19.93167185405595	30-009	Józefa Firedleina	Kraków	2
16	47	3	50.07168262603364,19.919711230762726	30-048	Urzędnicza	Kraków	2
17	14	\N	50.06581972893273,19.90619202106936	30-051	Urzędnicza	Kraków	2
18	11	\N	50.05775081890523,19.943025317690612	33-332	Walerego Goetla	Kraków	2
19	7	\N	50.07217918147434,19.908331011953106	30-069	Mariana Smoluchowskiego	Kraków	2
20	9	\N	50.067184999163445,19.934950312062707	33-332	Adama Asnyka	Kraków	1
21	7	\N	50.06320440161198,19.945343569623542	31-033	Westerplatte	Kraków	1
22	5	\N	50.05942330149562,19.93188734685993	31-108	Smoleńsk	Kraków	1
12	2	\N	\N	33-079	Armii Krajowej	Kraków	2
13	3	8	\N	33-079	Aleja Kijowska	Kraków	2
29	37	\N	50.054586924982765,19.914998778734816	30-117	Salwatorska	Kraków	3
30	11	\N	50.057570565792744,19.923192226133217	30-112	Rotmistrza Zbigniewa Dunin-Wąsowicza	Kraków	3
31	6	\N	50.054932608641124,19.92508677296392	30-103	Włóczków	Kraków	3
32	28	1	50.046653846169384,19.913005501666785	30-328	Praska	Kraków	4
33	14	\N	50.04953470674906,19.920047237732216	30-328	Praska	Kraków	4
34	13	\N	50.04984968468043,19.9278086132208	30-305	Kazimierza Pułaskiego	Kraków	4
35	2	\N	50.04459875607352,19.91854288538116	30-320	Księdza Pawlickiego	Kraków	4
36	51	6	50.04165800297113,19.922612172877322	30-347	Kapelanka	Kraków	4
37	8	\N	50.04371286984208,19.930347886899085	30-334	Komandosów	Kraków	5
38	11	\N	50.04461333825312,19.948227913268195	30-518	Rynek Podgórski	Kraków	5
39	66	\N	50.03959089753981,19.941905165380337	30-504	Kalwaryjska	Kraków	5
40	18	\N	50.04633190630014,19.95429947742641	30-547	Plac Bohaterów Getta	Kraków	5
41	5	\N	50.04448028864531,19.959156884739283	30-532	Jana Henryka Dąbrowskiego	Kraków	5
42	9	\N	50.04856292579332,19.961069680582607	30-710	Ślusarska	Kraków	5
43	25	\N	50.04750353502194,19.969605030959766	30-705	Stanisława Klimeckiego	Kraków	5
44	2	\N	50.05734412891182,19.95715611437577	31-540	Rzeźnicza	Kraków	6
45	6	\N	50.05714200270857,19.977487517102993	31-566	Bajeczna	Kraków	6
46	13	\N	50.06274472575269,19.973085770089217	31-553	Fabryczna	Kraków	6
47	1	\N	50.06540581403563,19.952151945523035	31-511	Rakowicka	Kraków	6
48	3	\N	50.066885344720085,19.961013669512045	31-525	Generała Józefa Chłopickiego	Kraków	6
49	1	\N	50.07308550374495,19.96641293234513	31-463	Józefa Narzymskiego	Kraków	6
23	2	\N	50.05102424007231,19.9476347572186	31-057	Wąska	Kraków	1
24	4	\N	50.050204505549246,19.938834176941313	33-332	Elizy Orzeszkowej	Kraków	1
25	63	\N	50.05601223446192,19.93810950825718	31-044	Grodzka	Kraków	1
26	102	\N	50.0570173082688,19.90093870147616	30-209	Królowej Jadwigi	Kraków	3
27	41	\N	50.05681981232319,19.90934151926821	30-119	Aleja Marszałka Ferdynanda Focha	Kraków	3
28	1	\N	50.05338331150521,19.91146492067381	30-203	Ludwika Anczyca	Kraków	3
52	3		\N	23-234	asdas	dasdad	2
50	27		\N	33-332	Karmelicka	Kraków	1
54	12		\N	31-123	Krupnicza	Kraków	1
56	4		\N	31-030	Bronowska	Kraków	1
\.


--
-- TOC entry 3414 (class 0 OID 17893)
-- Dependencies: 212
-- Data for Name: application; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.application (id, email, phone_number, sender_name, type) FROM stdin;
\.


--
-- TOC entry 3415 (class 0 OID 17900)
-- Dependencies: 213
-- Data for Name: client; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.client (id, email, first_name, last_name, password, phone_number, address_id, credit_card_id) FROM stdin;
47	jacoszekwojciech@gmail.com	Wojciech	Jacoszek	stBwljO2!	+48668144890	54	48
53	przyklad@gmail.com	Wojciech	Jacoszek	Przyklad1!	+48123123123	57	54
\.


--
-- TOC entry 3416 (class 0 OID 17907)
-- Dependencies: 214
-- Data for Name: company; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.company (id, name, type) FROM stdin;
1	Zahir Kebab	RESTAURANT
2	Makarun	RESTAURANT
3	McDonalds	RESTAURANT
4	Pizza Hut	RESTAURANT
5	Biedronka	SUPERMARKET
6	Centrum Zdrowia	PHARMACY
\.


--
-- TOC entry 3417 (class 0 OID 17912)
-- Dependencies: 215
-- Data for Name: credit_card; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.credit_card (id, cvv, card_number, expired) FROM stdin;
13	123	\N	01/12/2021
14	123	\N	01/12/2021
15	123	\N	01/12/2021
16	123	4123123412341234	01/12/2021
22	412	4123789078907890	02/01/2025
28	123	4123123412341234	01/09/2021
29	123	4123123412341234	12/01/2024
30	902	4123123412341234	02/12/2024
31	123	4123123412341234	01/02/2021
35	932	4123123412341234	01/02/2023
36	222	4222222222222222	01/01/2021
48	123	4123123412341234	01/01/2021
54	832	4123123412341234	01/01/2021
\.


--
-- TOC entry 3418 (class 0 OID 17919)
-- Dependencies: 216
-- Data for Name: deliver; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.deliver (id, pesel, email, first_name, last_name, phone_number, district_id, password, distance, location, cash) FROM stdin;
8	79312342905	slawomir.szumlas@gmail.com	Sławomir	Szumlas	+48402898772	5	szumlas01	0	50.04856058835353,19.960298763623136	0
5	95437773128	jan.jeleniewski@gmail.com	Jan	Jeleniewski	+48391220992	3	jeleniewski09	0	50.05558986034918,19.9192996213463	0
6	99314890248	kacper.komuniecki@gmail.com	Kacper	Komuniecki	+48310909328	4	komuniecki4123	0	50.04874231650456,19.926766891197342	0
7	98489128759	roman.kania@gmail.com	Roman	Kania	+48449490211	5	kania53	0	50.044295515864164,19.948597725145238	0
9	83389012848	anna.butor@gmail.com	Anna	Butor	+48123904302	6	butor32	0	50.05973561302371,19.96282653127284	0
3	71889332990	alan.romaniuk@gmail.com	Alan	Romaniuk	+4811394729	2	romaniuk52	0	50.07589631345883,19.917010174832377	0
4	87489329009	lukasz.dziambor@gmail.com	Łukasz	Dziambor	+48394998332	2	dziambor09	0	50.069152838262305,19.914098185048736	0
10	95312389883	jerzy.konduracki@gmail.com	Jerzy	Konduracki	+48389213849	6	konduracki12	0	50.06738974084795,19.959632078593856	0
1	87321857323	robert.nowakowski@gmail.com	Robert	Nowakowski	+48847389192	1	nowakowski2312	2499	50.067955163062784,19.94164732423471	0
2	73234904234	jakub.spysinski@gmail.com	Jakub	Spysiński	+48193857773	1	spysinski523	6675	50.05759813004144,19.937044466377404	8.04
\.


--
-- TOC entry 3424 (class 0 OID 18068)
-- Dependencies: 222
-- Data for Name: department; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.department (id, address_id, company_id) FROM stdin;
1	16	1
2	20	1
3	29	1
4	34	1
5	38	1
6	48	1
7	14	2
8	22	2
9	26	2
10	36	2
11	43	2
12	49	2
13	15	3
14	21	3
15	30	3
16	37	3
17	42	3
18	45	3
19	17	4
20	23	4
21	27	4
22	33	4
23	41	4
24	44	4
25	19	5
26	25	5
27	28	5
28	35	5
29	39	5
30	47	5
31	18	6
32	24	6
33	31	6
34	32	6
35	40	6
36	46	6
\.


--
-- TOC entry 3419 (class 0 OID 17926)
-- Dependencies: 217
-- Data for Name: district; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.district (id, name) FROM stdin;
1	Stare Miasto
2	Krowodrza
3	Zwierzyniec
4	Dębniki
5	Podgórze
6	Grzegórzki
\.


--
-- TOC entry 3425 (class 0 OID 18088)
-- Dependencies: 223
-- Data for Name: hibernate_sequences; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.hibernate_sequences (sequence_name, next_val) FROM stdin;
default	55
\.


--
-- TOC entry 3423 (class 0 OID 18036)
-- Dependencies: 221
-- Data for Name: item; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.item (id, description, name, price, size, company_id) FROM stdin;
12	\N	McZestaw BigMac	24.99	\N	3
13	\N	BurgerDrwala	19.99	\N	3
14	Grilowany kurczak, kukurydza, czerwona cebula, mozzarella, sos BBQ.	Pizza Teksas	35.99	MEDIUM	4
15	Peperoni, mozzarella, ziołowy sos pomidorowy.	Pizza peperoni	33.59	MEDIUM	4
16	Wołowina, pepperoni, cebula, zielona papryka, pieczarki, mozzarella, ziołowy sos pomidorowy	Pizza Supreme	35.99	MEDIUM	4
30	\N	Coca cola 0.5L	5.99	\N	2
31	\N	Mirinda 0,85L	9.99	\N	2
32	\N	7UP 0,85L	9.99	\N	2
33	\N	Coca cola 0.5L	5.99	\N	3
34	\N	Mirinda 0,85L	9.99	\N	3
35	\N	7UP 0,85L	9.99	\N	3
36	\N	Coca cola 0.5L	5.99	\N	4
37	\N	Mirinda 0,85L	9.99	\N	4
38	\N	7UP 0,85L	9.99	\N	4
1	\N	Rollo Kebab Samo mięso	24.99	MEDIUM	1
2	\N	Rollo Kebab Samo mięso	32.99	LARGE	1
3	\N	Rollo Kebab Amerykański	28.99	LARGE	1
4	\N	Rollo Kebab z Serem	21.99	MEDIUM	1
5	\N	Coca cola 0.5L	5.99	\N	1
6	Aromatyczny sos na bazie pomidorów pelati i rozmarynu, z mięsem wołowym, cebulą i marchwią.	Bolognese	17.99	MEDIUM	2
7	Wegetariański sos na bazie śmietany ze szpinakiem, serem, czosnkiem i przyprawami.	Szpinakowy	17.99	MEDIUM	2
8	Delikatny sos na bazie śmietany z dodatkiem kurczaka, cebulki i curry z przyprawami.	Currygodny Con Pollo	17.99	MEDIUM	2
10	\N	McNuggets	14.99	MEDIUM	3
11	\N	McNuggets	14.99	LARGE	3
18	\N	Mirinda 0,85L	9.99	\N	1
19	\N	7UP 0,85L	9.99	\N	1
20	\N	Jaja 10 sztuk	6.48	\N	5
21	\N	Masło	6.49	\N	5
22	1kg	Mąka Żytnia	3.98	\N	5
23	\N	Makaron	5.29	\N	5
24	300g	Chleb żytni	5.23	\N	5
25	250g	Parówki Berlinki	4.48	\N	5
26	500mg	Ibuprom 50szt	15.99	\N	6
27	\N	Gripex 12szt	18.99	\N	6
28	8mg	Flegamina 40szt tabletki	17.99	\N	6
29	\N	Termometr elektroniczny	12.99	\N	6
\.


--
-- TOC entry 3420 (class 0 OID 17931)
-- Dependencies: 218
-- Data for Name: office_worker; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.office_worker (id, pin, cash, email, first_name, last_name, phone_number, address_id, password, office_worker_type) FROM stdin;
1	85312039212	3400	jan.kulesza@gmail.com	Jan	Kulesza	+48395295230	11	jan123	BOOKKEEPER
2	74391448201	3500	aleksandra.pałaczuk@gmail.com	Aleksandra	Pałaczuk	+48381048221	12	aleksandra123	BOOKKEEPER
3	00312358321	0	wojciech.jacoszek@gmail.com	Wojciech	Jacoszek	+48578210331	13	admin	ADMINISTRATOR
\.


--
-- TOC entry 3426 (class 0 OID 18095)
-- Dependencies: 224
-- Data for Name: order_item; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.order_item (order_id, item_id) FROM stdin;
49	1
49	3
49	4
51	1
51	3
51	5
51	18
55	1
55	3
\.


--
-- TOC entry 3422 (class 0 OID 18021)
-- Dependencies: 220
-- Data for Name: order_type; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.order_type (id, price, type) FROM stdin;
\.


--
-- TOC entry 3427 (class 0 OID 18098)
-- Dependencies: 225
-- Data for Name: orders; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.orders (id, date, status, total_price, client_id, company_id, tip, deliver_id, reward, addresee) FROM stdin;
49	16-01-2022	DELIVERED	84.97	47	1	4	2	2.7	\N
50	16-01-2022	DELIVERED	10	47	\N	0	2	4.9	55
51	16-01-2022	DELIVERED	79.96	47	1	5	2	2.7	\N
52	16-01-2022	DELIVERED	10	47	\N	0	1	4.99	56
55	16-01-2022	DELIVERED	63.98	53	1	5	2	3.04	\N
\.


--
-- TOC entry 3428 (class 0 OID 18105)
-- Dependencies: 226
-- Data for Name: pack; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.pack (id, deliver_id, order_id, pack_locker_id) FROM stdin;
\.


--
-- TOC entry 3421 (class 0 OID 17948)
-- Dependencies: 219
-- Data for Name: pack_locker; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.pack_locker (id, address_id) FROM stdin;
1	1
2	2
3	3
4	4
5	5
6	6
7	7
8	8
9	9
10	10
\.


--
-- TOC entry 3435 (class 0 OID 0)
-- Dependencies: 210
-- Name: hibernate_sequence; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.hibernate_sequence', 36, true);


--
-- TOC entry 3226 (class 2606 OID 17892)
-- Name: address address_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.address
    ADD CONSTRAINT address_pkey PRIMARY KEY (id);


--
-- TOC entry 3228 (class 2606 OID 17899)
-- Name: application application_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.application
    ADD CONSTRAINT application_pkey PRIMARY KEY (id);


--
-- TOC entry 3230 (class 2606 OID 17906)
-- Name: client client_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.client
    ADD CONSTRAINT client_pkey PRIMARY KEY (id);


--
-- TOC entry 3232 (class 2606 OID 17911)
-- Name: company company_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.company
    ADD CONSTRAINT company_pkey PRIMARY KEY (id);


--
-- TOC entry 3234 (class 2606 OID 17918)
-- Name: credit_card credit_card_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.credit_card
    ADD CONSTRAINT credit_card_pkey PRIMARY KEY (id);


--
-- TOC entry 3236 (class 2606 OID 17925)
-- Name: deliver deliver_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.deliver
    ADD CONSTRAINT deliver_pkey PRIMARY KEY (id);


--
-- TOC entry 3248 (class 2606 OID 18072)
-- Name: department department_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.department
    ADD CONSTRAINT department_pkey PRIMARY KEY (id);


--
-- TOC entry 3238 (class 2606 OID 17930)
-- Name: district district_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.district
    ADD CONSTRAINT district_pkey PRIMARY KEY (id);


--
-- TOC entry 3250 (class 2606 OID 18092)
-- Name: hibernate_sequences hibernate_sequences_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.hibernate_sequences
    ADD CONSTRAINT hibernate_sequences_pkey PRIMARY KEY (sequence_name);


--
-- TOC entry 3246 (class 2606 OID 18042)
-- Name: item item_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.item
    ADD CONSTRAINT item_pkey PRIMARY KEY (id);


--
-- TOC entry 3240 (class 2606 OID 17937)
-- Name: office_worker office_worker_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.office_worker
    ADD CONSTRAINT office_worker_pkey PRIMARY KEY (id);


--
-- TOC entry 3244 (class 2606 OID 18025)
-- Name: order_type order_type_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.order_type
    ADD CONSTRAINT order_type_pkey PRIMARY KEY (id);


--
-- TOC entry 3252 (class 2606 OID 18104)
-- Name: orders orders_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.orders
    ADD CONSTRAINT orders_pkey PRIMARY KEY (id);


--
-- TOC entry 3242 (class 2606 OID 17952)
-- Name: pack_locker pack_locker_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pack_locker
    ADD CONSTRAINT pack_locker_pkey PRIMARY KEY (id);


--
-- TOC entry 3254 (class 2606 OID 18109)
-- Name: pack pack_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pack
    ADD CONSTRAINT pack_pkey PRIMARY KEY (id);


--
-- TOC entry 3266 (class 2606 OID 18120)
-- Name: orders FK1hq6doobj9gpsylfeq6vwyeca; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.orders
    ADD CONSTRAINT "FK1hq6doobj9gpsylfeq6vwyeca" FOREIGN KEY (client_id) REFERENCES public.client(id);


--
-- TOC entry 3255 (class 2606 OID 18150)
-- Name: address FK1w9mq8vt2qkbfkc52198trpgd; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.address
    ADD CONSTRAINT "FK1w9mq8vt2qkbfkc52198trpgd" FOREIGN KEY (district_id) REFERENCES public.district(id);


--
-- TOC entry 3264 (class 2606 OID 18110)
-- Name: order_item FK48wbbl34riw345jgu8hksgwe9; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.order_item
    ADD CONSTRAINT "FK48wbbl34riw345jgu8hksgwe9" FOREIGN KEY (item_id) REFERENCES public.item(id);


--
-- TOC entry 3261 (class 2606 OID 18083)
-- Name: item FK4ya9fmsbbxade2mx0osmi1r4n; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.item
    ADD CONSTRAINT "FK4ya9fmsbbxade2mx0osmi1r4n" FOREIGN KEY (company_id) REFERENCES public.company(id);


--
-- TOC entry 3260 (class 2606 OID 18008)
-- Name: pack_locker FK5iri2pygbtwx85k9kt6pj6upx; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pack_locker
    ADD CONSTRAINT "FK5iri2pygbtwx85k9kt6pj6upx" FOREIGN KEY (address_id) REFERENCES public.address(id);


--
-- TOC entry 3256 (class 2606 OID 17958)
-- Name: client FK64a9njla2p6s3bil4y4b1nbun; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.client
    ADD CONSTRAINT "FK64a9njla2p6s3bil4y4b1nbun" FOREIGN KEY (address_id) REFERENCES public.address(id);


--
-- TOC entry 3269 (class 2606 OID 18160)
-- Name: orders FK67ncegpraq1qbfowpbhbyqxre; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.orders
    ADD CONSTRAINT "FK67ncegpraq1qbfowpbhbyqxre" FOREIGN KEY (addresee) REFERENCES public.address(id);


--
-- TOC entry 3271 (class 2606 OID 18135)
-- Name: pack FKfxcwan20jcpq52pea9m0bkdp9; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pack
    ADD CONSTRAINT "FKfxcwan20jcpq52pea9m0bkdp9" FOREIGN KEY (order_id) REFERENCES public.orders(id);


--
-- TOC entry 3265 (class 2606 OID 18115)
-- Name: order_item FKgudsl0va08p9mc381uwy0xpkt; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.order_item
    ADD CONSTRAINT "FKgudsl0va08p9mc381uwy0xpkt" FOREIGN KEY (order_id) REFERENCES public.orders(id);


--
-- TOC entry 3258 (class 2606 OID 18014)
-- Name: deliver FKi8egeev8imp5pd6edn16366lk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.deliver
    ADD CONSTRAINT "FKi8egeev8imp5pd6edn16366lk" FOREIGN KEY (district_id) REFERENCES public.district(id);


--
-- TOC entry 3267 (class 2606 OID 18125)
-- Name: orders FKjpqn9qg3nnm9a7rape8qh2s6u; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.orders
    ADD CONSTRAINT "FKjpqn9qg3nnm9a7rape8qh2s6u" FOREIGN KEY (company_id) REFERENCES public.company(id);


--
-- TOC entry 3259 (class 2606 OID 17973)
-- Name: office_worker FKkoc3k7s28x2odx7egcoooynn6; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.office_worker
    ADD CONSTRAINT "FKkoc3k7s28x2odx7egcoooynn6" FOREIGN KEY (address_id) REFERENCES public.address(id);


--
-- TOC entry 3263 (class 2606 OID 18078)
-- Name: department FKml8cwhsij8o9tkhbhqbesb8cy; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.department
    ADD CONSTRAINT "FKml8cwhsij8o9tkhbhqbesb8cy" FOREIGN KEY (company_id) REFERENCES public.company(id);


--
-- TOC entry 3272 (class 2606 OID 18140)
-- Name: pack FKpa2qhdr6ygyfftr9mca9vor31; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pack
    ADD CONSTRAINT "FKpa2qhdr6ygyfftr9mca9vor31" FOREIGN KEY (pack_locker_id) REFERENCES public.pack_locker(id);


--
-- TOC entry 3270 (class 2606 OID 18130)
-- Name: pack FKr6st1kg9jycsn5ngkbv2bdlh2; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pack
    ADD CONSTRAINT "FKr6st1kg9jycsn5ngkbv2bdlh2" FOREIGN KEY (deliver_id) REFERENCES public.deliver(id);


--
-- TOC entry 3257 (class 2606 OID 17963)
-- Name: client FKrdh45afxykhecaa271fqswuy; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.client
    ADD CONSTRAINT "FKrdh45afxykhecaa271fqswuy" FOREIGN KEY (credit_card_id) REFERENCES public.credit_card(id);


--
-- TOC entry 3268 (class 2606 OID 18145)
-- Name: orders FKre3870s24o2dtfqkrymsydke3; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.orders
    ADD CONSTRAINT "FKre3870s24o2dtfqkrymsydke3" FOREIGN KEY (deliver_id) REFERENCES public.deliver(id);


--
-- TOC entry 3262 (class 2606 OID 18073)
-- Name: department FKs6swbfkvr1o0kvgvh4ndp61wp; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.department
    ADD CONSTRAINT "FKs6swbfkvr1o0kvgvh4ndp61wp" FOREIGN KEY (address_id) REFERENCES public.address(id);


-- Completed on 2022-01-17 14:01:30

--
-- PostgreSQL database dump complete
--

