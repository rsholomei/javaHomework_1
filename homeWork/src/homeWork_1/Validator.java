package homeWork_1;

import java.util.Scanner;

public class Validator {
    private static Scanner scanner = new Scanner(System.in);
    private static String number;
    private static boolean numberContainLettersFlag;
    private static boolean numberLengthFlag;
    private static boolean numberValidatorFlag;
    private static int numberSum;
    private static String [] prefixOperator = {"039", "050", "063", "066", "067", "068", "091", "092", "093",
                                    "094", "095", "096", "097", "098", "099"};
    private static String enterTelephoneNumber()
    {
        System.out.println("Введіть ваш номер");
        number = scanner.next();
        return number;
    }

    private static boolean numberContainLetters()
    {
        byte [] arrayNumberByte = number.getBytes();
        for (int i = 0; i < arrayNumberByte.length; i++)
        {
            if (arrayNumberByte[i] < 42 && arrayNumberByte[i] > 58)
            {
                numberContainLettersFlag = true;
                break;
            }
        }
        return numberContainLettersFlag;
    }

    private static boolean numberLength()
    {
        if (number.length() == 10 || number.length() == 13)
        {
            numberLengthFlag = true;
        }
        return numberLengthFlag;
    }

    private static boolean numberPrefixOperation()
    {
        if (number.length() == 13 && number.contains("+380"))
        {
            number = number.substring(3, 13);
        }
        for (int i = 0; i < prefixOperator.length; i++ )
        {
            if (prefixOperator[i].equals(number.substring(0, 3)))
            {
                numberValidatorFlag = true;
                break;
            }
        }
        return numberValidatorFlag;
    }

    private static void numberValidator()
    {
        while (!numberContainLetters() || !numberLength() || !numberPrefixOperation())
        {
            System.out.println("Ви ввели некоректний номер. Спробуйте ще:");
            number = scanner.next();
        }
    }

    private static int numberPhoneSum()
    {
        numberValidator();
        System.out.println("Ви ввели коректний номер:");
        byte [] numberPhoneByte = number.getBytes();
        int [] numberPhoneInt = new int[numberPhoneByte.length];
        for (int i = 0; i < numberPhoneByte.length; i++)
        {
            numberPhoneInt[i] = numberPhoneByte[i] - 48;
            numberSum += numberPhoneInt[i];
        }
        System.out.println("Перша сума = " + numberSum);
        return numberSum;
    }

    private static int numberSumResult()
    {
        numberPhoneSum();
        int counter = 1;
        while (numberSum > 9)
        {
            int numeric1 = numberSum / 10;
            int numeric2 = numberSum % 10;
            numberSum = numeric1 + numeric2;
            counter++;
            System.out.println(counter + " сума = " + numberSum);
        }
        return numberSum;
    }
    private static String finalResult()
    {
        numberSumResult();
        switch (numberSum)
        {
            case 1:
                return "One";
            case 2:
                return "Two";
            case 3:
                return "Three";
            case 4:
                return "Four";
            default:
                return String.valueOf(numberSum);
        }
    }

    public static void main(String[] args)
    {
        enterTelephoneNumber();
        System.out.print("Кінцевий результат = " + finalResult());
    }
}
