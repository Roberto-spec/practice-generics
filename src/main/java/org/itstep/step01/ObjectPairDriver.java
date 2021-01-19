package org.itstep.step01;

import org.itstep.step01.exeption.*;

/**
 * Класс для тестирования кортежа ObjectPair
 *
 * @author Nathan Sprague
 * @version V1, 8/2016
 */
public class ObjectPairDriver {

    /**
     * Создайте несколько пар стадионов, затем распечатайте название стадиона с наибольшей вместимостью.
     *
     * @param args Не используется
     */
    public static void main(String[] args) throws StadiumException {

        ObjectPair[] stadiums = new ObjectPair[3];
        stadiums[0] = new ObjectPair("Bridgeforth Stadium", 25000);
        stadiums[1] = new ObjectPair("Michigan Stadium", 109901);
        //stadiums[2] = new ObjectPair("Lane Stadium", "66,233");

        System.out.println(stadiums[0]);

        System.out.println(largestStadium(stadiums));

//        БОНУСНЫЙ ВОПРОС: Почему компилируется эта строка кода?
//                stadiums[0] = new ObjectPair("Bridgeforth Stadium", 25000);
//        БОНУСНЫЙ ОТВЕТ: ПОТОМУ ЧТО 25000 это Int и чтобы все сработал
//        нужно привести 25000 к Integer
    }

    /**
     * Возвращает название стадиона с наибольшей вместимостью.
     *
     * @param stadiums Массив ObjectPairs, где каждая пара содержит название стадиона, за которым следует целое число
     * @return Название стадиона с наибольшей вместимостью
     */
    public static String largestStadium(ObjectPair[] stadiums) throws StadiumException {
        // TODO: реализуйте это метод в соответствии с комментариями
        if (stadiums==null||stadiums.length==0){
            throw new EmptyArrayException("В данном массиве нет ни одного объекта");
        }
        if(stadiums.length==1){
            if(stadiums[0]==null){
                throw new EmptyObjectException("В найденом объекте нет информации");
            }
            return stadiums[0].getFirst().toString();
        }
        int max=0;
        int index=-1;
        for(int i=0;i<stadiums.length;i++){
            if(stadiums[i]==null){
                continue;
            }
            if(stadiums[i].getSecond().getClass().getName()=="java.lang.Integer"){
                if((int)(stadiums[i].getSecond())>max){
                    max=(int)(stadiums[i].getSecond());
                    index=i;
                }
            }
            else {
                throw new InvalidTypeException("Неподходящий тип данных");
            }
        }
        if (index==-1) {
            throw new NotFoundStadiumException("Мы не смогли найти подхоящий стадион");
        }
        return stadiums[index].getFirst().toString();
    }

}
