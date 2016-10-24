package homeWork_1;


import java.util.Scanner;

public class Validator
{
    private Scanner scanner = new Scanner(System.in);
    private static String numberString;
    static boolean cond;
    private static long numberLong;
    private int counter;
    private String [] prefixOper;
    private boolean correctNumber()
    {
        prefixOper = new String[15];
        prefixOper[0] = "039";  prefixOper[1] = "050"; prefixOper[2] = "063"; prefixOper[3] = "066"; prefixOper[4] = "067";
        prefixOper[5] = "068";  prefixOper[6] = "091"; prefixOper[7] = "092"; prefixOper[8] = "093"; prefixOper[9] = "094";
        prefixOper[10] = "095"; prefixOper[11] = "096"; prefixOper[12] = "097"; prefixOper[13] = "098"; prefixOper[14] = "099";
        numberString = scanner.next();


        cond = false;

        byte [] arrayNumberByte = numberString.getBytes();

        for (int i = 0; i < arrayNumberByte.length; i++)
        {
            if (arrayNumberByte[i] < 42 || arrayNumberByte[i] > 58)
            {
                System.out.println("Номер не може містити букв");
                System.out.println("Спробуйте ще:");
                cond = true;
                break;
            }
        }

        if (numberString.length() == 10)
        {
            for (int i = 0; i < prefixOper.length; i++ )
            {
                if (prefixOper[i].equals(numberString.substring(0, 3)))
                {
                    counter++;
                }
            }
            if (counter == 0)
            {
                System.out.println("Ви ввели невірний префікс мобільного оператора");
                System.out.println("Спробуйте ще:");
                cond = true;
            }
        }

        if (numberString.length() == 13 && numberString.contains("+380"))
        {
            for (int i = 0; i < prefixOper.length; i++ )
            {
                if (prefixOper[i].equals(numberString.substring(3, 6)))
                {
                    counter++;
                }
            }
            if (counter == 0)
            {
                System.out.println("Ви ввели невірний префікс мобільного оператора");
                System.out.println("Спробуйте ще:");
                cond = true;
            }
        }

        if (!cond)
        {
            if (numberString.length() != 10 && numberString.length() > 13)
            {
                System.out.println("Номер занадто довгий");
                System.out.println("Спробуйте ще:");
                cond = true;
            }else {
                if (numberString.length() < 10 )
                {
                    System.out.println("Номер занадто короткий");
                    System.out.println("Спробуйте ще:");
                    cond = true;
                }else  {
                    if (numberString.length() > 10 && numberString.length() < 13 && !numberString.contains("+380"))
                    {
                        System.out.println("Ви ввели невірний код караїни");
                        System.out.println("Спробуйте ще:");
                        cond = true;
                    }else {
                        numberLong = Long.parseLong(numberString);

                        if (numberString.length() == 10)
                        {
                            numberLong = numberLong / 1000000000;
                        }

                        if (numberString.length() == 10 && numberLong != 0)
                        {
                            System.out.println("Номер без коду країни має починатися з 0");
                            System.out.println("Спробуйте ще:");
                            cond = true;
                        }else {
                            if (numberString.length() == 13 && !numberString.contains("+380"))
                            {
                                System.out.println("Ваш номер має починатися з коду країни +380");
                                System.out.println("Спробуйте ще:");
                                cond = true;
                            }
                            else {
                                cond = false;
                            }
                        }
                    }
                }
            }
        }

        return cond;

    }
    public static void main(String[] args)
    {
        System.out.println("Введіть ваш номар телефону:");
        Validator validator = new Validator();
        while (validator.correctNumber() == true) {}

        if (cond == false)
        {
            System.out.println("Ви ввели коректний номер:");
            numberLong = Long.parseLong(numberString);
            int sum = 0;
            int sum_1 = 0;
            int sum_2;
            int sum_3;

            int [] arrayNumeric = new int[numberString.length()];

            for (int i = 0;  i < numberString.length(); i++)
            {
                arrayNumeric [i] = (int) ((numberLong % Math.pow(10, numberString.length()-(i)))
                        /Math.pow(10, numberString.length()-(i+1)));
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

            switch (sum) {
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
}
