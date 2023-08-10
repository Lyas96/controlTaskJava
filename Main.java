import src.fileWriter;

import src.plaything;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static src.vars.allToys;
import static src.vars.winsToys;

public class Main {

    public static void main(String[] args) {
        //Сначала создаем игрушки
        plaything cat = new plaything(1, "cat", 10, 20);
        plaything dog = new plaything(2, "dog", 3, 5);
        plaything bird = new plaything(3, "bird", 4, 10);
        plaything fish = new plaything(4, "fish", 10, 30);
        plaything spiderman = new plaything(5, "spiderman", 6, 20);
        plaything superman = new plaything(6, "superman", 5, 8);

        //добавляем созданные игрушки в список с новым весом
        addToListWithNewWeight(cat, 5);
        addToListWithNewWeight(dog, 10);
        addToListWithNewWeight(bird, 21);
        addToListWithNewWeight(fish, 7);
        addToListWithNewWeight(spiderman, 45);
        addToListWithNewWeight(superman, 67);

        //показываем что у нас в общем списке игрушек
        System.out.println("all toys: ");
        showNewList(allToys);

        //формируем список призовых игрушек
        List<plaything> addedWinners = selectToyByMinWeight(allToys, 20);
        winsToys.addAll(addedWinners);

        //отображаем призовые игрушки
        System.out.println("winners list: ");
        showNewList(winsToys);

        //выбираем призовую игрушку на выдачу из призового списка
        plaything givedWinner = selectRandomToy(winsToys);
        //удаляем выданную игрушку из списка к выдаче
        winsToys.remove(givedWinner);

        //отображаем инфо о призовой игрушке на выдачу
        System.out.println("winner for giving: " + givedWinner.info());

        //пишем инфо в текстовый файл
        fileWriter.writeToy(givedWinner);

    }

    private static List<plaything> selectToyByMinWeight(ArrayList<plaything> allToys, int minWeight) {
        List<plaything> result = new ArrayList<>();
        for (plaything currentToy : allToys) {
            if (currentToy.getWeight() <= minWeight) {
                result.add(currentToy);
            }
        }
        return result;
    }

    private static plaything selectRandomToy(ArrayList<plaything> winsToys) {
        Random rand = new Random();
        int winnerElement = rand.nextInt(winsToys.size());
        return winsToys.get(winnerElement);
    }

    private static void addToListWithNewWeight(plaything newToy, int newWeight) {
        newToy.setWeight(newWeight);
        allToys.add(newToy);
    }

    private static void showNewList(ArrayList<plaything> myList) {
        int winListSize = myList.size();
        for (int i = 0; i < winListSize; i++) {
            System.out.print("toy [" + i + "]: " + myList.get(i).getName() + ", ");
        }
        System.out.println("");
    }
}