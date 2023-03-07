Nita Maria-Alexandra 324CA

Pentru datele din input am creat clasa "Input", pentru datele despre fiecare 
copil am creat clasa "ChildInputData", pentru datele initiale am folosit clasa
"InitialData", pentru update-urile despre copii am creat clasa "ChildUpdate",
pentru cadouri am creat clasa "GiftInputData", iar pentru o schimbare anuala
am creat clasa "AnnualChanges".

"BonusBuilder" modifica averageScore-ul initial, in functie de valoarea 
bonusului de cumintenie.

"Command" reprezinta interfata pentru comenzile facute asupra listei de copii 
si este implementata de clasele:

	- "AverageCommand": calculeaza averagescore-ul pentru fiecare copil, in
	functie de categoria de vasrta in care se incadreaza si daca are cel mult
	18 ani;

	- "BudgetCommand": calculeaza budgetUnit si bugetul pe care il are Mosul
	pentru fiecare copil;

	- "GiftsCommand": aplica strategia de impartire a cadourilor;

	- "UpdateCommand": mareste varsta fiecarui copil cu 1, adauga in lista de 
	copii noii copii, daca acestia au cel mult 18 ani, actualizeaza informatiile
	despre copiii primiti in lista "childrenUpdates", daca acei copii nu depasec 
	18 ani, actualizeaza bugetul mosului, adauga noi cadouri in lista de cadouri
	a Mosului;

	- "AverageCityCommand": creeaza un LinkedHashMap, in care cheia este 
	reprezentata de numele orasului, iar valoarea este media aritmetica a
	averageScore-urilor copiilor care locuiesc in orasul reprezentat de cheie.
	LinkedHashMap-ul este ordonat descrescator, in functie de valoare;

	- "CreateCityList": creeaza o lista cu toate orasele in care ar putea trece
	Mosul;

	- "YellowElfCommand": cauta in lista Mosului cadoul cel mai ieftin din 
	categoriile favorite ale copilului, care mai este in stoc, si il adauga in
	lista de cadouri a copilului.

"ApplyCommands" primeste comenzile si le executa.

"GiftStrategy" reprezinta interfata pentru strategiile aplicate pentru a 
imparti cadouri copiilor si este implementata de clasele:
	
	- "IdGift": adauga in lista de cadouri a fiecarui copil de cel mult
	18 ani cadourile pe care le poate cumpara Mosul in functie de preferintele
	copilului, cadourile pe care le are Mosul, bugetul alocat si cantitatea
	aflata in stoc la momentul respectiv. Cand este asignat un cadou, cantitatea
	lui scade cu o unitate;

	- "NiceScoreCityGifts": parcurg cheile din niceScoreCity si asignez copiilor 
	de cel mult 18 ani, care se afla in orasul "key", cadourile pe care le poate 
	cumpara Mosul in functie de preferintele copilului, cadourile pe care le are 
	Mosul, bugetul alocat si cantitatea aflata in stoc la momentul respectiv. 
	Cand este asignat un cadou, cantitatea lui scade cu o unitate;

	- "NiceScoreGifts": ordonez lista de copii in functie de avarageScore, o 
	parcurg si asignez copiilor de cel mult 18 ani cadourile pe care le poate 
	cumpara Mosul in functie de preferintele copilului, cadourile pe care le 
	are Mosul, bugetul alocat si cantitatea aflata in stoc la momentul respectiv.
	Cand este asignat un cadou, cantitatea lui scade cu o unitate. Dupa ce asignez
	cadourile, reordonez lista de copii in functie de id.

In clasa "Utils" exista o metoda care transforma un string intr-un enum(Category).

Clasele "AnnualChildren" si "Children" sunt folosite pentru a afisa output-ul.

In "Main" citesc inputul din fiecare test si aplic schimbarile anuale corespunzatoare fiecarui 
test, dupa care afisez output-ul.
