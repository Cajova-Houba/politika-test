INSERT INTO kategorie(id,nazev,rodKategorie_id,typ) VALUES("1","Senát",NULL,"Normal");
INSERT INTO kategorie(id,nazev,rodKategorie_id,typ) VALUES("2","Poslanecká sněmovna",NULL,"Normal");
INSERT INTO kategorie(id,nazev,rodKategorie_id,typ) VALUES("3","Strany",NULL,"Normal");
INSERT INTO kategorie(id,nazev,rodKategorie_id,typ) VALUES("4","Aktivita senátu","1","Normal");
INSERT INTO kategorie(id,nazev,rodKategorie_id,typ) VALUES("5","Členové","1","Osoby");
INSERT INTO kategorie(id,nazev,rodKategorie_id,typ) VALUES("6","Aktivita poslanecké sněmovny","2","Normal");
INSERT INTO kategorie(id,nazev,rodKategorie_id,typ) VALUES("7","Členové","2","Osoby");

INSERT INTO kategorie_osoba(osoba_id,kategorie_id) VALUES("1","7");
INSERT INTO kategorie_osoba(osoba_id,kategorie_id) VALUES("2","7");
INSERT INTO kategorie_osoba(osoba_id,kategorie_id) VALUES("3","7");
INSERT INTO kategorie_osoba(osoba_id,kategorie_id) VALUES("4","7");
INSERT INTO kategorie_osoba(osoba_id,kategorie_id) VALUES("5","7");

INSERT INTO osoba(id,name,info,funkce) VALUES("1","Bohuslav Sobotka","premiér","Premier");
INSERT INTO osoba(id,name,info,funkce) VALUES("2","Andej Babiš","ministr financí","MinFin");
INSERT INTO osoba(id,name,info,funkce) VALUES("3","Robert Pelikán","ministr spravedlnosti","MinSprav");
INSERT INTO osoba(id,name,info,funkce) VALUES("4","Milan Chovanec","ministr vnitra","MinVnitra");
INSERT INTO osoba(id,name,info,funkce) VALUES("5","Martin Stropnický","ministr obrany","MinObr");

INSERT INTO prispevek(id,datum,nadpis,text,zdroje,kategorie_id) VALUES("1","2016-1-1","Aktivita 1","asdasasd","zdroj","4");
INSERT INTO prispevek(id,datum,nadpis,text,zdroje,kategorie_id) VALUES("2","2016-1-1","Aktivita 2","asdasasd","zdroj","4");
INSERT INTO prispevek(id,datum,nadpis,text,zdroje,kategorie_id) VALUES("3","2016-1-1","Aktivita 3","asdasasd","zdroj","4");
INSERT INTO prispevek(id,datum,nadpis,text,zdroje,kategorie_id) VALUES("4","2016-1-1","Aktivita 12","asdasasd","zdroj","6");
INSERT INTO prispevek(id,datum,nadpis,text,zdroje,kategorie_id) VALUES("5","2016-1-1","Aktivita 8","asdasasd","zdroj","6");
INSERT INTO prispevek(id,datum,nadpis,text,zdroje,kategorie_id) VALUES("6","2016-1-1","Aktivita 7","asdasasd","zdroj","6");

