import java.util.Random;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        Random rng = new Random();

        int roundNumber = 0;
        int playerScore = 0;
        int computerScore = 0;

        boolean gameActive = true;

        System.out.println("Skriv in ditt namn.");
        String name = sc.nextLine();

        while(gameActive)
        {
            int playerDice = rng.nextInt(1, 7);
            int computerDice = rng.nextInt(1, 7);

            System.out.println("Du rullade " + playerDice);
            System.out.println("Datorn rullade " + computerDice);

            if (roundNumber > 2)
            {
                if (playerScore > computerScore)
                {
                    System.out.println(name + " har vunnit hela spelet!");
                }
                else if
                (playerScore < computerScore)
                {
                    System.out.println("Datorn har vunnit hela spelet!");
                }
                else
                {
                    System.out.println("Error");
                }

                System.out.println("Poängen blev:");
                System.out.println(name + ": " + playerScore + " Datorn: " + computerScore);

                System.out.println("Vill du fortsätta? y/n");

                while (true)
                {
                    char answer = sc.next().charAt(0);
                    answer = Character.toLowerCase(answer);

                    if (answer == 'y')
                    {
                        roundNumber = 0;
                        playerScore = 0;
                        computerScore = 0;
                        break;
                    }
                    else if (answer == 'n')
                    {
                        gameActive = false;
                        break;
                    }
                    else
                    {
                        System.out.println("Skriv antingen 'y' eller 'n'");
                    }
                }
            }
            else
            {
                if (playerDice > computerDice)
                {
                    playerScore++;
                    System.out.println(name + " har vunnit!");
                    roundNumber++;
                }
                else if (playerDice < computerDice)
                {
                    computerScore++;
                    System.out.println("Datorn har vunnit!");
                    roundNumber++;
                }
                else if (playerDice == computerDice)
                {
                    System.out.println("Det blev lika");
                }
            }

            sc.nextLine();
        }
    }
}