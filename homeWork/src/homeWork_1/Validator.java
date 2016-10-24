package homeWork_1;


import java.util.Scanner;

public class Validator
{
    private Scanner scanner = new Scanner(System.in);
    private static String number;
    private long num;
    private boolean correctNumber()
    {
        number = scanner.next();

        boolean cond = false;

        byte [] arrayNumberByte = number.getBytes();

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
        if (!cond)
        {
            if (number.length() != 10 && number.length() > 13)
            {
                System.out.println("Номер занадто довгий");
                System.out.println("Спробуйте ще:");
                cond = true;
            }else {
                if (number.length() < 10 )
                {
                    System.out.println("Номер занадто короткий");
                    System.out.println("Спробуйте ще:");
                    cond = true;
                }else  {
                    if (number.length() > 10 && number.length() < 13)
                    {
                        System.out.println("Ви ввели невірний код караїни");
                        System.out.println("Спробуйте ще:");
                        cond = true;
                    }else {
                        num = Long.parseLong(number);

                        if (number.length() == 10)
                        {
                            num = num / 1000000000;
                        }

                        if (number.length() == 10 && num != 0)
                        {
                            System.out.println("Номер без коду країни має починатися з 0");
                            System.out.println("Спробуйте ще:");
                            cond = true;
                        }else {
                            if (number.length() == 13 && !number.contains("+380"))
                            {
                                System.out.println("Ваш номер має починатися з коду країни +380");
                                System.out.println("Спробуйте ще:");
                                cond = true;
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
        Validator validator = new Validator();
        while (validator.correctNumber() == true)
        {
            if (validator.correctNumber() == true)
            {
                validator.correctNumber();
            }
        }
    }
}
