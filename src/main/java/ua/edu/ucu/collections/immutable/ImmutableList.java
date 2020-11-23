package ua.edu.ucu.collections.immutable;

// У результаті змін, що призводять на модифікації
// колекції має повертатись нова колекція

public interface ImmutableList {

    ImmutableList add(Object e);
    // додає елемент у кінець колекції

    ImmutableList add(int index, Object e);
    // додає елемент до колекції за індексом
    // та кидає виключну ситуацію, якщо індекс
    // виходить за межі колекції

    ImmutableList addAll(Object[] c);
    // додає масив елементів у кінець колекції

    ImmutableList addAll(int index, Object[] c);
    // додає масив елементів починаючи з зазначеного індексу
    // та кидає виключну ситуацію,
    // якщо індекс виходить за межі колекції

    Object get(int index);
    // повертає елемент за індексом та кидає виключну ситуацію,
    // якщо індекс виходить за межі колекції

    ImmutableList remove(int index);
    // видаляє елемент за індексом та кидає виключну ситуацію,
    // якщо індекс виходить за межі колекції

    ImmutableList set(int index, Object e);
    // змінює значення елемента за індексом
    // та кидає виключну ситуацію,
    // якщо індекс виходить за межі колекції

    int indexOf(Object e);
    // шукає індекс елемента
    // (повертає індекс першого знайденого
    // або -1, якщо елемент відсутній)

    int size();
    // розмір колекції

    ImmutableList clear();
    // очищує вміст колекції

    boolean isEmpty();
    // якщо у колеції немає елементів - повертає true

    Object[] toArray();
    // перетворює колекцію на масив обєктів

    @Override
    String toString();
    // повертає рядок, де через кому відображаютсься
    // елементи колекції
}
