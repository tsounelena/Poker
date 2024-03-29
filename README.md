## Poker test task 

### Технологии

* Java 8

## Task description

1. Реализовать класс для ранжирования покерных рук. Класс должен содержать конструктор, который принимает на вход строку, содержащую пять карт: 
```java
PokerHand hand = new PokerHand("KS 2H 5C JD TD");
```
  Характеристики входной строки:
        - В качестве разделителя используется пробел.
        - Описание каждой карты состоит из двух символов:
        - первый символ — это номинал карты. Допустимые значения: 2, 3, 4, 5, 6, 7, 8, 9, T(en), J(ack), Q(ueen), K(ing), A(ce);
        - второй символ — масть. Допустимые значения: S(pades), H(earts), D(iamonds), C(lubs).

2. Реализовать возможность сортировки рук по «силе» (рейтингу / рангу) от сильной к слабой: 
```java
ArrayList<PokerHand> hands = new ArrayList<PokerHand>(); 
hands.add(new PokerHand("KS 2H 5C JD TD")); 
hands.add(new PokerHand("2C 3C AC 4C 5C")); 
Collections.sort(hands);
```
Масть в подсчёте силы руки не участвует. Для упрощения считать, что туз в комбинациях стрит или стрит-флэш может быть только наивысшей картой.

3. Класс PokerHand должен быть покрыт unit-тестами (определение комбинаций и сравнение комбинаций).
