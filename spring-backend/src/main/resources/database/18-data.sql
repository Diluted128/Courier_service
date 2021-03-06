-- liquibase formatted sql
-- changeset wj:1

INSERT INTO ROLE VALUES (1, 'CLIENT');
INSERT INTO ROLE VALUES (2, 'COURIER');
INSERT INTO ROLE VALUES (3, 'OFFICE_WORKER');
INSERT INTO ROLE VALUES (4, 'ADMINISTRATOR');

INSERT INTO district VALUES(1,	'Stare Miasto');
INSERT INTO district VALUES(2,	'Krowodrza');
INSERT INTO district VALUES(3,	'Zwierzyniec');
INSERT INTO district VALUES(4,	'Dębniki');
INSERT INTO district VALUES(5,	'Podgórze');
INSERT INTO district VALUES(6,	'Grzegórzki');

INSERT INTO address VALUES( 1,   '15', NULL,	'50.06838422249052, 19.940506279883532', '31-150', 'Swiętego Filipa',	'Kraków', 1);
INSERT INTO address VALUES( 2,	'13',	null,	'50.05775081890523, 19.943025317690612', '31-038',	'Starowiślana',	'Kraków',	1);
INSERT INTO address VALUES( 3,	null,	null,	'50.07735534744172,19.926644820385505',	'30-011',	'Wrocławska',	'Kraków',	2);
INSERT INTO address VALUES( 4,	null,	null,	'50.07013668581254,19.91385965388764',	'30-001',	'Krowodrza',	'Kraków',	2);
INSERT INTO address VALUES( 5 ,	'23',	null,	'50.07013668581254,19.91385965388764',	'30-103',	'Michała Stachowicza',	'Kraków',	3);
INSERT INTO address VALUES( 6,	'4',	null,	'50.045973784866725,19.92695016269066',	'30-337',	'Władysława Mitkowskiego',	'Kraków',	4);
INSERT INTO address VALUES( 7,	'5',	null,	'50.043142503398066,19.951345824452694',	'30-537',	'Andrzeja Potebni',	'Kraków',	5);
INSERT INTO address VALUES(8,	null,	null,	'50.04977951249568, 19.968268267273555',	'30-703',	'Zabłocie',	'Kraków',	5);
INSERT INTO address VALUES(9,	'51',	null,	'50.074619738875384,19.95803223400859',	'31-510',	'Rakowicka',	'Kraków',	6);
INSERT INTO address VALUES(10,	'28',	null,	'50.043142503398066,19.951345824452694',	'31-543',	'Pułkownika Francesco Nullo',	'Kraków',	6);
INSERT INTO address VALUES(12,	'2',	null,	null,	'33-079',	'Armii Krajowej',	'Kraków',	2);
INSERT INTO address VALUES(13,	'3',	'8',	null,	'33-079',	'Aleja Kijowska',	'Kraków',	2);
INSERT INTO address VALUES(14,	'64',	null,	'50.079688716788766,19.91865679904364',	'33-079',	'Aleja Kijowska',	'Kraków',	2);
INSERT INTO address VALUES(15,	'7',	null,	'50.07622731560304,19.93167185405595',	'30-009',	'Józefa Firedleina',	'Kraków',	2);
INSERT INTO address VALUES(16,	'47',	'3',	'50.07168262603364,19.919711230762726',	'30-048',	'Urzędnicza',	'Kraków',	2);
INSERT INTO address VALUES(17,	'14',	null,	'50.06581972893273,19.90619202106936',	'30-051',	'Urzędnicza',	'Kraków',	2);
INSERT INTO address VALUES(18,	'11',	null,	'50.05775081890523,19.943025317690612',	'33-332',	'Walerego Goetla',	'Kraków',	2);
INSERT INTO address VALUES(19,	'7',	null,	'50.07217918147434,19.908331011953106',	'30-069',	'Mariana Smoluchowskiego',	'Kraków',	2);
INSERT INTO address VALUES(20,	'9',	null,	'50.067184999163445,19.934950312062707',	'33-332',	'Adama Asnyka',	'Kraków',	1);
INSERT INTO address VALUES(21,	'7',	null,	'50.06320440161198,19.945343569623542',	'31-033',	'Westerplatte',	'Kraków',	1);
INSERT INTO address VALUES(22,	'5',	null,	'50.05942330149562,19.93188734685993',	'31-108',	'Smoleńsk',	'Kraków',	1);
INSERT INTO address VALUES(23,	'2',	null,	'50.05102424007231,19.9476347572186',	'31-057',	'Wąska',	'Kraków',	1);
INSERT INTO address VALUES(24,	'4',	null,	'50.050204505549246,19.938834176941313',	'33-332',	'Elizy Orzeszkowej',	'Kraków',	1);
INSERT INTO address VALUES(25,	'63',	null,	'50.05601223446192,19.93810950825718',	'31-044', 'Grodzka',	'Kraków',	1);
INSERT INTO address VALUES(26,	'102', null,	'50.0570173082688,19.90093870147616',	'30-209',	'Królowej Jadwigi',	'Kraków',	3);
INSERT INTO address VALUES(27,	'41',	null, '50.05681981232319,19.90934151926821',	'30-119',	'Aleja Marszałka Ferdynanda Focha',	'Kraków',	3);
INSERT INTO address VALUES(28,	'1',	null,	'50.05338331150521,19.91146492067381',	'30-203',	'Ludwika Anczyca',	'Kraków', 3);
INSERT INTO address VALUES(29,	'37',	null,	'50.054586924982765,19.914998778734816',	'30-117',	'Salwatorska',	'Kraków',	3);
INSERT INTO address VALUES(30,	'11',	null,	'50.057570565792744,19.923192226133217',	'30-112',	'Rotmistrza Zbigniewa Dunin-Wąsowicza',	'Kraków',	3);
INSERT INTO address VALUES(31,	'6',	null,	'50.054932608641124,19.92508677296392',	'30-103',	'Włóczków',	'Kraków',	3);
INSERT INTO address VALUES(32,	'28',	'1',	'50.046653846169384,19.913005501666785',	'30-328',	'Praska',	'Kraków',	4);
INSERT INTO address VALUES(33,	'14',	null,	'50.04953470674906,19.920047237732216',	'30-328',	'Praska',	'Kraków',	4);
INSERT INTO address VALUES(34,	'13',	null,	'50.04984968468043,19.9278086132208',	'30-305',	'Kazimierza Pułaskiego',	'Kraków',	4);
INSERT INTO address VALUES(35,	'2',	null,	'50.04459875607352,19.91854288538116',	'30-320',	'Księdza Pawlickiego',	'Kraków',	4);
INSERT INTO address VALUES(36,	'51',	'6',	'50.04165800297113,19.922612172877322',	'30-347',	'Kapelanka',	'Kraków',	4);
INSERT INTO address VALUES(37,	'8',	null,	'50.04371286984208,19.930347886899085',	'30-334',	'Komandosów', 'Kraków',	5);
INSERT INTO address VALUES(38,	'11',	null,	'50.04461333825312,19.948227913268195',	'30-518',	'Rynek Podgórski',	'Kraków',	5);
INSERT INTO address VALUES(39,	'66',	null,	'50.03959089753981,19.941905165380337',	'30-504',	'Kalwaryjska',	'Kraków',	5);
INSERT INTO address VALUES(40,	'18',	null,	'50.04633190630014,19.95429947742641',	'30-547',	'Plac Bohaterów Getta',	'Kraków',	5);
INSERT INTO address VALUES(41,	'5',	null,	'50.04448028864531,19.959156884739283',	'30-532',	'Jana Henryka Dąbrowskiego',	'Kraków',	5);
INSERT INTO address VALUES(42,	'9',	null,	'50.04856292579332,19.961069680582607',	'30-710',	'Ślusarska', 'Kraków',	5);
INSERT INTO address VALUES(43,	'25',	null,	'50.04750353502194,19.969605030959766',	'30-705',	'Stanisława Klimeckiego',	'Kraków',	5);
INSERT INTO address VALUES(44,	'2',	null,	'50.05734412891182,19.95715611437577',	'31-540', 'Rzeźnicza',	'Kraków',	6);
INSERT INTO address VALUES(45,	'6',	null,	'50.05714200270857,19.977487517102993',	'31-566',	'Bajeczna',	'Kraków',	6);
INSERT INTO address VALUES(46,	'13',	null,	'50.06274472575269,19.973085770089217',	'31-553',	'Fabryczna',	'Kraków',	6);
INSERT INTO address VALUES(47,	'1',	null,	'50.06540581403563,19.952151945523035',	'31-511',	'Rakowicka',	'Kraków',	6);
INSERT INTO address VALUES(48,	'3',	null,	'50.066885344720085,19.961013669512045',	'31-525',	'Generała Józefa Chłopickiego',	'Kraków',	6);
INSERT INTO address VALUES(49,	'1',	null,	'50.07308550374495,19.96641293234513',	'31-463',	'Józefa Narzymskiego',	'Kraków',	6);

INSERT INTO company VALUES(1,	'Zahir Kebab',	'RESTAURANT');
INSERT INTO company VALUES(2,	'Makarun',	'RESTAURANT');
INSERT INTO company VALUES(3,	'McDonalds',	'RESTAURANT');
INSERT INTO company VALUES(4,	'Pizza Hut',	'RESTAURANT');
INSERT INTO company VALUES(5,	'Biedronka',	'SUPERMARKET');
INSERT INTO company VALUES(6,	'Centrum Zdrowia',	'PHARMACY');

INSERT INTO courier VALUES(11,	'87321857323',	'robert.nowakowski@gmail.com',	'Robert',	'Nowakowski',	'+48847389192',	1,	'$2a$12$r/3vUp7W5vCD0JshbYpv4O5QbZQ072qfrogsZbAR820Dm.HPj2uje',	2499,	'50.067955163062784,19.94164732423471',	0, 2);
INSERT INTO courier VALUES(2,	'73234904234',	'jakub.spysinski@gmail.com',	'Jakub',	'Spysiński',	'+48193857773',	1,	'spysinski523',	6675,	'50.05759813004144,19.937044466377404',	8.04, 2);
INSERT INTO courier VALUES(3,	'71889332990',	'alan.romaniuk@gmail.com',	'Alan',	'Romaniuk',	'+4811394729',	2,	'romaniuk52',	0,	'50.07589631345883,19.917010174832377',	0, 2);
INSERT INTO courier VALUES(4,	'87489329009',	'lukasz.dziambor@gmail.com',	'Łukasz',	'Dziambor',	'+48394998332',	2,	'dziambor09',	0,	'50.069152838262305,19.914098185048736',	0, 2);
INSERT INTO courier VALUES(5,	'95437773128',	'jan.jeleniewski@gmail.com',	'Jan',	'Jeleniewski',	'+48391220992',	3,	'jeleniewski09',	0,	'50.05558986034918,19.9192996213463',	0, 2);
INSERT INTO courier VALUES(6,	'99314890248',	'kacper.komuniecki@gmail.com',	'Kacper',	'Komuniecki',	'+48310909328',	4,	'komuniecki4123',	0,	'50.04874231650456,19.926766891197342',	0, 2);
INSERT INTO courier VALUES(7,	'98489128759',	'roman.kania@gmail.com',	'Roman',	'Kania',	'+48449490211',	5,	'kania53',	0,	'50.044295515864164,19.948597725145238',	0, 2);
INSERT INTO courier VALUES(8,	'79312342905',	'slawomir.szumlas@gmail.com',	'Sławomir',	'Szumlas',	'+48402898772',	5,	'szumlas01',	0,	'50.04856058835353,19.960298763623136',	0, 2);
INSERT INTO courier VALUES(9,	'83389012848',	'anna.butor@gmail.com',	'Anna',	'Butor',	'+48123904302',	6,	'butor32',	0,	'50.05973561302371,19.96282653127284',	0, 2);
INSERT INTO courier VALUES(10,	'95312389883',	'jerzy.konduracki@gmail.com',	'Jerzy',	'Konduracki',	'+48389213849',	6,	'konduracki12',	0,	'50.06738974084795,19.959632078593856',	0, 2);

INSERT INTO department VALUES(1,  16,	1);
INSERT INTO department VALUES(2,	20,	1);
INSERT INTO department VALUES(3,	29,	1);
INSERT INTO department VALUES(4,	34,	1);
INSERT INTO department VALUES(5,	38,	1);
INSERT INTO department VALUES(6,	48,	1);
INSERT INTO department VALUES(7,	14,	2);
INSERT INTO department VALUES(8,	22,	2);
INSERT INTO department VALUES(9,	26,	2);
INSERT INTO department VALUES(10,	36,	2);
INSERT INTO department VALUES(11,	43,	2);
INSERT INTO department VALUES(12,	49,	2);
INSERT INTO department VALUES(13,	15,	3);
INSERT INTO department VALUES(14, 21,	3);
INSERT INTO department VALUES(15, 30,	3);
INSERT INTO department VALUES(16,	37,	3);
INSERT INTO department VALUES(17,	42,	3);
INSERT INTO department VALUES(18,	45,	3);
INSERT INTO department VALUES(19,	17,	4);
INSERT INTO department VALUES(20,	23,	4);
INSERT INTO department VALUES(21,	27,	4);
INSERT INTO department VALUES(22,	33,	4);
INSERT INTO department VALUES(23,	41,	4);
INSERT INTO department VALUES(24, 44,	4);
INSERT INTO department VALUES(25,	19,	5);
INSERT INTO department VALUES(26,	25,	5);
INSERT INTO department VALUES(27,	28,	5);
INSERT INTO department VALUES(28,	35,	5);
INSERT INTO department VALUES(29,	39,	5);
INSERT INTO department VALUES(30,	47,	5);
INSERT INTO department VALUES(31,	18,	6);
INSERT INTO department VALUES(32,	24,	6);
INSERT INTO department VALUES(33,	31,	6);
INSERT INTO department VALUES(34,	32,	6);
INSERT INTO department VALUES(35,	40,	6);
INSERT INTO department VALUES(36,	46,	6);

INSERT INTO item VALUES(1,	NULL,	'Rollo Kebab Samo mięso',	24.99,	'MEDIUM',	1);
INSERT INTO item VALUES(2,	NULL,	'Rollo Kebab Samo mięso',	32.99,	'LARGE',	1);
INSERT INTO item VALUES(3,	NULL,	'Rollo Kebab Amerykański',	28.99,	'LARGE',	1);
INSERT INTO item VALUES(4,	NULL,	'Rollo Kebab z Serem',	21.99,	'MEDIUM',	1);
INSERT INTO item VALUES(5,	NULL,	'Coca cola 0.5L',	5.99,	NULL,	1);
INSERT INTO item VALUES(6,	'Aromatyczny sos na bazie pomidorów pelati i rozmarynu, z mięsem wołowym, cebulą i marchwią.',	'Bolognese',	17.99,	'MEDIUM',	2);
INSERT INTO item VALUES(7,	'Wegetariański sos na bazie śmietany ze szpinakiem, serem, czosnkiem i przyprawami.',	'Szpinakowy',	17.99,	'MEDIUM',	2);
INSERT INTO item VALUES(8,	'Delikatny sos na bazie śmietany z dodatkiem kurczaka, cebulki i curry z przyprawami.', 'Currygodny Con Pollo',	17.99,	'MEDIUM',	2);
INSERT INTO item VALUES(10,	NULL,	'McNuggets',	14.99,	'MEDIUM',	3);
INSERT INTO item VALUES(11,	NULL,	'McNuggets',	14.99,	'LARGE',	3);
INSERT INTO item VALUES(12,	NULL,	'McZestaw BigMac',	24.99,	NULL,	3);
INSERT INTO item VALUES(13,	NULL,	'BurgerDrwala',	19.99,	NULL,	3);
INSERT INTO item VALUES(14,	'Grilowany kurczak, kukurydza, czerwona cebula, mozzarella, sos BBQ.',	'Pizza Teksas',	35.99,	'MEDIUM',	4);
INSERT INTO item VALUES(15,	'Peperoni, mozzarella, ziołowy sos pomidorowy.',	'Pizza peperoni',	33.59,	'MEDIUM',	4);
INSERT INTO item VALUES(16,	'Wołowina, pepperoni, cebula, zielona papryka, pieczarki, mozzarella, ziołowy sos pomidorowy',	'Pizza Supreme',	35.99,	'MEDIUM',	4);
INSERT INTO item VALUES(30,	NULL,	'Coca cola 0.5L',	5.99,	NULL,	2);
INSERT INTO item VALUES(31,	NULL,	'Mirinda 0,85L',	9.99,	NULL,	2);
INSERT INTO item VALUES(32,	NULL,	'7UP 0,85L',	9.99,	NULL,	2);
INSERT INTO item VALUES(33,	NULL,	'Coca cola 0.5L',	5.99,	NULL,	3);
INSERT INTO item VALUES(34,	NULL,	'Mirinda 0,85L',	9.99,	NULL,	3);
INSERT INTO item VALUES(35,	NULL,	'7UP 0,85L',	9.99,	NULL,	3);
INSERT INTO item VALUES(36,	NULL,	'Coca cola 0.5L',	5.99,	NULL,	4);
INSERT INTO item VALUES(37,	NULL,	'Mirinda 0,85L',	9.99,	NULL,	4);
INSERT INTO item VALUES(38,	NULL,	'7UP 0,85L',	9.99,	NULL,	4);
INSERT INTO item VALUES(18,	NULL,	'Mirinda 0,85L',	9.99,	NULL,	1);
INSERT INTO item VALUES(19,	NULL,	'7UP 0,85L',	9.99,	NULL,	1);
INSERT INTO item VALUES(20,	NULL,	'Jaja 10 sztuk',	'6.48',	NULL,	5);
INSERT INTO item VALUES(21,	NULL, 'Masło',	6.49,	NULL,	5);
INSERT INTO item VALUES(22,	'1kg',	'Mąka Żytnia',	3.98,	NULL,	5);
INSERT INTO item VALUES(23,	NULL,	'Makaron',	5.29,	NULL,	5);
INSERT INTO item VALUES(24,	'300g',	'Chleb żytni',	5.23,	NULL,	5);
INSERT INTO item VALUES(25,	'250g',	'Parówki Berlinki',	4.48,	NULL,	5);
INSERT INTO item VALUES(26,	'500mg',	'Ibuprom 50szt',	15.99,	NULL,	6);
INSERT INTO item VALUES(27,	NULL,	'Gripex 12szt',	18.99,	NULL,	6);
INSERT INTO item VALUES(28,	'8mg',	'Flegamina 40szt tabletki',	17.99,	NULL,	6);
INSERT INTO item VALUES(29,	NULL,	'Termometr elektroniczny',	12.99,	NULL,	6);

INSERT INTO office_worker VALUES(1,	'74391448201',	3500,	'aleksandra.pałaczuk@gmail.com',	'Aleksandra',	'Pałaczuk',	'+48381048221',	12,	'$2a$12$3/XFQcZofv4T.w78hWYoF.89GM7vBtObHLNvF7d3yV9pSN1fRbxci',	3);


INSERT INTO pack_locker VALUES(1,	1);
INSERT INTO pack_locker VALUES(2,	2);
INSERT INTO pack_locker VALUES(3,	3);
INSERT INTO pack_locker VALUES(4,	4);
INSERT INTO pack_locker VALUES(5,	5);
INSERT INTO pack_locker VALUES(6,	6);
INSERT INTO pack_locker VALUES(7,	7);
INSERT INTO pack_locker VALUES(8,	8);
INSERT INTO pack_locker VALUES(9,	9);
INSERT INTO pack_locker VALUES(10, 10);

