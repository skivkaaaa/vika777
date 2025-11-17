Типовые задачи на Java

  Задача 1: Разделение строки на символы в четных и нечетных позициях

java
public class StringSplit {
    public static void main(String[] args) {
        // Сохраним строку в переменной
        String str = "AaBbCcDd";
        
        // Создаем StringBuilder для результатов
        StringBuilder evenPositions = new StringBuilder();
        StringBuilder oddPositions = new StringBuilder();
        
        // Разделяем символы по позициям
        for (int i = 0; i < str.length(); i++) {
            if (i % 2 == 0) {
                // Четные индексы (0, 2, 4, ...)
                evenPositions.append(str.charAt(i));
            } else {
                // Нечетные индексы (1, 3, 5, ...)
                oddPositions.append(str.charAt(i));
            }
        }
        
        // Выводим результаты
        System.out.println("Символы на четных позициях: " + evenPositions);
        System.out.println("Символы на нечетных позициях: " + oddPositions);
    }
}

Задача 2: Разделение списка на буквы и цифры

java
import java.util.ArrayList;
import java.util.List;

public class ListSplit {
    public static void main(String[] args) {
        // Создаем исходный список
        List<Character> original = new ArrayList<>();
        original.add('a');
        original.add('1');
        original.add('b');
        original.add('2');
        original.add('c');
        original.add('3');
        
        // Создаем списки для результатов
        List<Character> letters = new ArrayList<>();
        List<Character> digits = new ArrayList<>();
        
        // Разделяем элементы
        for (char element : original) {
            if (Character.isLetter(element)) {
                // Если элемент - буква
                letters.add(element);
            } else if (Character.isDigit(element)) {
                // Если элемент - цифра
                digits.add(element);
            }
        }
        
        // Очищаем исходный список
        original.clear();
        
        // Выводим результаты
        System.out.println("Буквы: " + letters);
        System.out.println();
        System.out.println("Цифры: " + digits);
        System.out.println();
        System.out.println("Размер исходного списка после очистки: " + original.size());
    }
}
