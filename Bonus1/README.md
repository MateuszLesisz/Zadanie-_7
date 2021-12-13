# Zadanie dodatkowe 1

### Serwis samochodowy - aplikacja webowa :car: :blue_car: :oncoming_automobile:

###### Zakres: Spring Boot, Spring MVC, HTTP, Thymeleaf, HTTP, CSS, Bootstrap, zapis/odczyt plików, obsługa formatu JSON/XML, OOP, struktury danych, clean code

<br/>
Napisz program, do obsługi serwisu samochodowego.  

<br/>Program powinien umożliwiać 4 poniższe opcje:
1. wyświetlenie listy aktywnych pojazdów (przyjętych do serwisu, nienaprawionych)
2. dodanie nowego pojazdu (przyjęcie do serwisu)
3. naprawę pojazdu
4. zapis i wczytanie danych o pojazdach z pliku  

<br/>

##### Przyjęcie samochodu so serwisu:
Na stronie web powinien być dostępny formularz pozwalający na przyjęcie nowego pojazdu do naprawy.  
Wszystkie wprowadzane do formularza dane powinny być walidowane pod kątem ich poprawności.  
Samochód powinien mieć pole tekstowe "registration number", pole tekstowe "name" oraz pole logiczne "isFixed" (z wartością domyślną _false_), poza tym może mieć dowolne inne cechy (np. kolor, rocznik).  
Po zatwierdzeniu formularza samochód jest dodawany do listy aktywnych pojazdów i zapisywany do pliku.  
Aplikacja powinna obsługiwać pliki JSON lub XML (lub oba typy, a wybór pliku można zmienić w konfiguracji). Pliki te są wczytywane przy starcie aplikacji.  

<br/>

##### Lista aktywnych pojazdów:
Aplikacja powinna umożliwiać podgląd aktywnej listy pojazdów (jeszcze nienaprawionych) z wszystkimi dostępnymi informacjami o danym pojeździe.
Wyświetlenie listy powinno być dostępne z menu na stronie głównej (lub paska nawigacji).  
Lista wszystkich aktywnych pojazdów powinna zostać wczytana z pliku podczas uruchomienia aplikacji.  

<br/>

##### Naprawa samochodu:
Z aktywnej listy możemy wybrać jeden pojazd i go naprawić (np. poprzez naciśnięcie przycisku "napraw") - tylko jeden na raz.  
Dodatkowo można zaimplementować mechanizm wyszukiwania pojazdu do naprawy (np. po numerze rejestracyjnym lub nazwie).
Auto można naprawić tylko jeden na raz. Po naprawie samochód powinien zniknąć z listy aktywnych pojazdów.  
Naprawa samochodu polega na zamianie jego flagi "isFixed" z _false_ na _true_.  
Naprawione samochody powinny zostać zapisane do pliku json/xml w osobnym katalogu "fixed".  
W katalogu "fixed" nazwy plików to daty wykonywania napraw, wszystkie samochody naprawione tego samego dnia powinny być w jednym pliku.  
_Przykładowy scenariusz:_  
Jeżeli dnia 20.11.2020 naprawimy 2 pojazdy, a 21.11.2020 3 pojazdy, to w plikach odpowiadających danym dniom powinny znaleźć się listy o rozmiarach odpowiednio 2 i 3.

<br/>

#### Przykładowy wygląd aplikacji webowej (propozycja):

<br/>Pasek **`menu`**
_____________
| Pojazdy do naprawy | Dodaj nowy pojazd | Napraw pojazd | Pojazdy naprawione |
| ------------------ | ----------------- | ------------- |------------------- |
_____________

<br/><br/>widok **`Pojazdy do naprawy`**
_____________
| Numer rejestracyjny | Nazwa | Kolor | Rocznik | Data przyjęcia do serwisu |     |
| ------------------- | ----- | ----- |-------- | ------------------------- | --- |
| GD 1A234 | Audi A3 | czarny | 2015 | 2021-03-01 | [napraw]( ) |
| WI 6DE89 | Fiat Panda | niebieski | 2006 | 2021-03-03 | [napraw]( ) |
| CGR 657ABX | Skoda Rapid | czerwony | 2018 | 2021-03-04 | [napraw]( ) |
| GDA K12L | Opel Corsa | biały | 2016 | 2021-03-08 | [napraw]( ) |

- Lista powinna być posortowana według daty przyjęcia pojazdu do serwisu (ostatnio przyjęte auto trafia na dół listy).
_____________ 

<br/><br/>widok **`Dodaj nowy pojazd`**
_____________  
| Dodaj nowy pojazd |  | 
| ------------------ | ----- |
| **Numer rejestracyjny** | GA 85C27 |
| **Nazwa** | Renault Clio |
| **Kolor** | zielony |
| **Rocznik** | 2011 |
|  | [zapisz]( ) | 

- po zapisaniu auto powinno się pojawić na liście pojazdów do naprawy.
_____________  


<br/><br/>widok **`Napraw pojazd`**
_____________  
1. W pierwszym kroku jesteśmy proszeni o podanie numeru rejestracyjnego pojazdu:
```
Podaj numer samochodu do naprawy: GD 1A234
```
2. Jeśli numer rejestracyjny pojazdu jest prawidłowy i samochód nie został jeszcze naprawiony, to wyświetlone zostaną dane tego samochodu plus przycisk `napraw`:

| Numer rejestracyjny | Nazwa | Kolor | Rocznik | Data przyjęcia do serwisu |    |
| ------------------- | ----- | ----- |-------- | ------------------------- | ---|
| GD 1A234 | Audi A3 | czarny | 2015 | 2021-03-01 | [napraw]( ) |

3. Po naciśnięciu przycisku `napraw` zostaje zmieniony status tego pojazdu (nie będzie już widoczny na liście pojazdów do naprawy, a pojawia się na liście pojazdów naprawionych).
4. Jeśli brak pojazdu o podanym numerze rejestracyjnym lub został ten pojazd już naprawiony, to otrzymamy stosowny komunikat.
5. (Dla chętnych) Zamiast pola do wprowadzania numeru rejestracyjnego zaimplementować rozszerzony mechanizm wyszukiwania pojazdów, np. można wpisać tylko część nazwy (panda) lub kolor (biały). Jako wynik wyszukiwania otrzymamy listę pasujących do zapytania pojazdów.
_____________  

<br/><br/>widok **`Pojazdy naprawione`**
_____________
| Numer rejestracyjny | Nazwa | Kolor | Rocznik | Data naprawy |
| ------------------- | ----- | ----- |-------------- | --- |
| KR 5D852 | Toyota Yaris | srebrny | 2010 | 2021-03-13 |
| NIL 2FS36 | Ford Focus | brązowy | 2014 | 2021-03-10 |
| WSK 557GH | KIA Rio | grafitowy | 2017 | 2021-02-28 |

- Lista powinna być posortowana według daty naprawy (ostatnie naprawione na górze listy).
_____________   

<br/>

##### Wymagania:
- Aplikacja powinna wykorzystywać frameworki:
  - Spring Boot
  - Thymeleaf / Bootstrap

- Aplikacja powinna być napisana obiektowo i wykorzystywać wzorzec MVC.  
- Zadbaj o walidację danych wejściowych oraz wczytywanych plików.  
- Zadbaj o obsługę błędów. 
- Zwróć uwagę na zasady clean code.


## Forma oddania zadania
Jeśli chcesz podjąć się tego zadania, to daj mi o tym znać na Slacku w prywatnej wiadomości.

:heavy_exclamation_mark: Nie umieszczaj kodu w repozytorium homeworks! Utwórz własne repozytorium na swoim koncie na GitHubie dedykowane dla tego projektu. Ta aplikacja może być częścią twojego portfolio.
Po wykonaniu zadania (na feature branchu, zanim kod znajdzie się na branchu main/master), utwórz pull request i dodaj mnie jako reviewera.

---

## Extra Punktacja

Za prawidłowe rozwiązanie można zdobyć maksymalnie **15** punktów do ogólnej punktacji za prace domowe:
- za poprawnie i estetycznie zaimplementowaną warstwę widoków - :five:  pkt.
- za poprawnie zaimplementowaną warstwę kontrolerów i serwisów (logika biznesowa) - :five:  pkt.
- za poprawnie zaimplementowaną warstwę persystencji (zapis do plików) - :five:  pkt.


Osoby, które mają komplet punktów z prac domowych, również mogą wykonać to zadanie i zdobyć :two:  ekstra punkty procentowe do końcowego wyniku :yum:

### :clock12: Termin realizacji: 14.01.2022

#### Powodzenia!