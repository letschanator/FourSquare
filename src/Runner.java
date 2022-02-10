import fourSquare.Decryptor;
import fourSquare.Encryptor;
import fourSquare.Four_Square;

import java.util.Scanner;

public class Runner {

    /**
     * runner for both the encryptor and decryptor
     * @param Args arguments for the main
     */
    public static void main( String[] Args){
        Scanner src = new Scanner(System.in);
        Boolean keepGoing = true;
        while (keepGoing){
            System.out.print("Input the first keyword:");
            String keyword1 = src.nextLine();
            System.out.print("Input the second keyword:");
            String keyword2 = src.nextLine();
            Four_Square square = new Four_Square(keyword1,keyword2);
            if(square.getKeyword1().equals("") || square.getKeyword2().equals("")){
                System.out.println("The keywords should only be capital letters A-Z excluding Q, try again.");
                break;
            }
            System.out.println("The Squares made from those keywords:");
            System.out.println(square);
            System.out.print("Would you like to encrypt or decrypt a word, press 1 to encrypt or 2 to decrypt:");
            int input = src.nextInt();
            if(input != 1 && input != 2){
                System.out.println("Input only the numbers prompted, try again.");
                break;
            }
            src.nextLine();
            if(input == 1){
                System.out.print("What text would you like to encrypt:");
                String text = src.nextLine();
                Encryptor encryptor = new Encryptor(square,text);
                System.out.println("The encrypted text is: " + encryptor);
            }else{
                System.out.print("What text would you like to decrypt:");
                String text = src.nextLine();
                Decryptor decryptor = new Decryptor(square,text);
                System.out.println("The decrypted text is: " + decryptor);
            }
            System.out.print("would you like to encrypt or decrypt another word, 1 for yes or 2 for no:");
            int count = src.nextInt();
            if(count != 1 && count != 2){
                System.out.println("Input only the numbers prompted, try again.");
                break;
            }
            if (count == 2) {
                keepGoing = false;
            }
            src.nextLine();

        }
    }
}
