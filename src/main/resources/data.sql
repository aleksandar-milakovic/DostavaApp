

INSERT INTO korisnik (id, e_mail, korisnicko_ime, lozinka, ime, prezime, uloga)
              VALUES (1,'a1@gmail.com','miroslav','$2y$12$NH2KM2BJaBl.ik90Z1YqAOjoPgSd0ns/bF.7WedMxZ54OhWQNNnh6','Miroslav','Simic','ADMIN');
INSERT INTO korisnik (id, e_mail, korisnicko_ime, lozinka, ime, prezime, uloga)
              VALUES (2,'b1@gmail.com','tamara','$2y$12$DRhCpltZygkA7EZ2WeWIbewWBjLE0KYiUO.tHDUaJNMpsHxXEw9Ky','Tamara','Milosavljevic','KORISNIK');
INSERT INTO korisnik (id, e_mail, korisnicko_ime, lozinka, ime, prezime, uloga )
              VALUES (3,'petar@maildrop.cc','petar','$2y$12$i6/mU4w0HhG8RQRXHjNCa.tG2OwGSVXb0GYUnf8MZUdeadE4voHbC','Petar','Jovic','KORISNIK');

INSERT INTO dostavljac (id,jmbg,broj_lk,ime_prezime )VALUES (1,'123456a','licna1','Aleksandar Milakovic');
INSERT INTO dostavljac (id,jmbg,broj_lk,ime_prezime )VALUES (2,'123456b','licna2','Nikola Pejakovic');
INSERT INTO dostavljac (id,jmbg,broj_lk,ime_prezime )VALUES (3,'123456c','licna3','James Bond');
INSERT INTO dostavljac (id,jmbg,broj_lk,ime_prezime )VALUES (4,'123456d','licna4','Aleksandar Makednoski');





INSERT INTO racun (id, broj_racuna,datum_kreiranja,ukupna_cena) VALUES (1,2571,'2020-03-06 15:30',850);
INSERT INTO racun (id, broj_racuna,datum_kreiranja,ukupna_cena) VALUES (2,2572,'2020-03-05 17:30',860);
INSERT INTO racun (id, broj_racuna,datum_kreiranja,ukupna_cena) VALUES (3,2573,'2020-03-04 12:30',400);
INSERT INTO racun (id, broj_racuna,datum_kreiranja,ukupna_cena) VALUES (4,2574,'2020-03-08 19:30',1500);





INSERT INTO  narudzba (id,broj_nar,datum_kreiranja,mesto_isporuke,cena,opis,dostavljac_id,racun_id) VALUES (1,2571,'2020-03-06 15:30','Veljak Petrovica 30',850,'jelo1',1,1);
INSERT INTO  narudzba (id,broj_nar,datum_kreiranja,mesto_isporuke,cena,opis,dostavljac_id,racun_id) VALUES (2,2572,'2020-03-05 17:30','Kosovksa 50',860,'jelo2',2,2);
INSERT INTO  narudzba (id,broj_nar,datum_kreiranja,mesto_isporuke,cena,opis,dostavljac_id,racun_id) VALUES (3,2573,'2020-03-04 12:30','Njegoseva 8',400,'jelo3',3,3);
INSERT INTO  narudzba (id,broj_nar,datum_kreiranja,mesto_isporuke,cena,opis,dostavljac_id,racun_id) VALUES (4,2574,'2020-03-08 19:30','Vojvode Bojovica 16',1500,'jelo4',4,4);




