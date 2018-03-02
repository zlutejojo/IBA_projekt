# IBA_projekt

Level 2: použila jsem maven-archetype-webapp, používám lokálně nainstalovaný tomcat 8.0.47, jednotlivé URL viz níže. 

Level 8: 3. den jsem zkoušela nastavit a použít Hibernate, Hibernate neznám, nedařilo se mi projekt nastavit správně,
nejdál se mi podařilo dostat s návodem, kde se používá SessionFactory (nevím, ale jestli je to používaný způsob), v projektu jsou jen testovací metody.

Level 10: REST je pro implementaci StudentService s Listem (DB je nefunkční), funkční třída je cz.IBA.servlet.service.StudentServiceRest.

Level 11: JUNIT je pro implementaci StudentService s Listem (DB je nefunkční).



Ne na všechny weby jsou odkazy, aplikace obsahuje tyto URL:

vypsání Hello: root (bez paramatru)

vypsání Hello: root s parametrem: př./?x=4

vytvoření a uložení studenta: /studentCreate (od commitu 93067a6 - Level 7: pridani servisni vrstvy), /student (commit 6a33e59 - Level 5 a commit 6e82c6d - Level 6)) 

seznam vytvořených studentů: /studentList (pokud je seznam prázdný, tak se jen zobrazí prázdná stránka)

detail studenta s parametrem (vyžadován): př. /studentDetail?index=0

editace studenta s parametrem (vyžadován): př. /studentEdit?index=0

REST:

/rest/Student/index (kde index je index studenta v Listu)

Databáze není funkční. Používám hsqldb. Třída DbMain je pouze zkouška databáze bez použití Hibernate (používá StudentServiceDbImplTest - nejsou implementované všechny metody). JPAMain je jen testovací třída, kde jsem zkoušela připojení s Hibernate (StudentServiceDbImpl není implementovaný).

Projekt vznikl na macOS, web jsem procházela na Safari (jiné prohlížeče jsem netestovala).

Na projektu jsem pracovala 4 dny (3. den jsem strávila s Hibernate).

Za komentáře k projektu budu ráda.

Pěkný nový rok :)
