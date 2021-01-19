package org.itstep.step03;

import org.itstep.step02.Pair;

import java.util.Iterator;
import java.util.NoSuchElementException;

///**
// * Итерируемая коллекция объектов Pair.
// *
// * @author Michael S. Kirkpatrick and Nathan Sprague
// * @version V1, 8/2017
// */
public class Pairs<K, V> implements Iterable<Pair<K, V>> {

    /* TODO: Объявить массив фиксированного размера (максимум 10 элементов) объектов Pair */
    private final static int SIZE=10;
    private Pair<K,V>[] pairs;
    private int cur;

    /**
     * Создайте коллекцию, в которой будут храниться элементы, добавленные парами.
     */
    public Pairs() {
        pairs=new Pair[SIZE];
        cur=0;
    }

    /**
     * TODO: Создайте новую пару и добавьте ее в коллекцию, если есть место.
     *
     * @param first  Первый объект
     * @param second Второй объект
     * @return true - если пара была добавлена, false - в противном случае
     */
    public boolean addPair(K first, V second) {
        if(cur!=10){
            pairs[cur]=new Pair<K,V>(first,second);
            cur++;
            return true;
        }
        return false;
    }


    @Override
    public Iterator<Pair<K, V>> iterator() {
        return new PairIterator();
    }

    /*
     * TODO: Реализуйте итератор здесь на основе документации API по адресу
     * https://docs.oracle.com/javase/10/docs/api/java/util/Iterator.html Throw the exceptions as
     * specified
     */
    private class PairIterator implements Iterator<Pair<K, V>> {
        int index;
        /**
         * TODO: Проверить наличие следующего элемента в итераторе
         */
        @Override
        public boolean hasNext() {
            if(index<cur){
                return true;
            }
            return false;
        }

        /**
         * TODO: Вернуть следующую пару в итератор.
         * @throws NoSuchElementException - если больше нет элементов для итерации
         */
        @Override
        public Pair<K, V> next() {
            if(hasNext()){
                return pairs[index++];
            }
            throw new NoSuchElementException("Нет больше элементов для итерации");
        }

        /**
         * TODO: Удалите предыдущую пару, возвращенную функцией next()
         */
        @Override
        public void remove() {
            for (int i = index; i < cur; i++) {
                pairs[i - 1] = pairs[i];
            }
            pairs[--cur] = null;

        }
    }
}
