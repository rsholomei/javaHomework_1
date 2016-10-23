package homeWork_1;

import java.util.Scanner;

/**
 * Created by ruslan on 22.10.16.
 */
public class Validator {
    public static void main(String[] args)
    {
        System.out.println("Введіть ваш номер телефону:");
        Scanner scanner = new Scanner(System.in);
        String number = "";
        long num = 0;



        while (number.length() != 10 && number.length() != 13
                || (number.length() == 13 && !number.contains("+380"))
                || (number.length() == 10 && num != 0)
                || (number.length() > 10 && number.length() < 13))

        {
            number = scanner.next();

            if (number.length() > 10 && number.length() < 13)
            {
                System.out.println("Ви ввели невірний код караїни");
                System.out.println("Спробуйте ще:");
            }
            if (number.length() < 10)
            {
                System.out.println("Номер занадто короткий");
                System.out.println("Спробуйте ще:");
            }

            if (number.length() != 10 && number.length() > 13)
            {
                System.out.println("Номер занадто довгий");
                System.out.println("Спробуйте ще:");
            }

            if (number.length() == 13 && !number.contains("+380"))
            {
                System.out.println("Ваш номер має починатися з коду країни +380");
                System.out.println("Спробуйте ще:");
            }
            num = Long.parseLong(number);

            if (number.length() == 10)
            {
                num = num / 1000000000;
            }

            if (number.length() == 10 && num != 0)
            {
                System.out.println("Номер без коду країни має починатися з 0");
                System.out.println("Спробуйте ще:");
            }
        }
        num = Long.parseLong(number);
        int sum = 0;
        int sum_1 = 0;
        int sum_2;
        int sum_3;

        int [] arrayNumeric = new int[number.length()];

        for (int i = 0;  i < number.length(); i++)
        {
            arrayNumeric [i] = (int) ((num % Math.pow(10, number.length()-(i)))
                    /Math.pow(10, number.length()-(i+1)));
            sum_1 += arrayNumeric[i];
            sum = sum_1;
        }
        System.out.println("Перша сума = " + sum);

        int numeric_1 = 0;
        int numeric_2 = 0;
        if (sum > 10)
        {
            numeric_1 = sum / 10;
            numeric_2 = sum % 10;
            sum_2 = numeric_1 + numeric_2;
            sum = sum_2;
            System.out.println("Друга сума = " + sum);
        }

        int numeric_11 = 0;
        int numeric_22 = 0;
        if (sum > 10)
        {
            numeric_11 = sum / 10;
            numeric_22 = sum % 10;
            sum_3 = numeric_11 + numeric_22;
            sum = sum_3;
            System.out.println("Третя сума = " + sum);
        }
            System.out.println("Кінцевий результат:");

            switch (sum)
            {
                case 1:
                    System.out.println("One");
                    break;
                case 2:
                    System.out.println("Two");
                    break;
                case 3:
                    System.out.println("Three");
                    break;
                case 4:
                    System.out.println("Four");
                    break;
                case 5:
                    System.out.println("5");
                    break;
                case 6:
                    System.out.println("6");
                    break;
                case 7:
                    System.out.println("7");
                    break;
                case 8:
                    System.out.println("8");
                    break;
                case 9:
                    System.out.println("9");
                    break;
            }
    }
}

