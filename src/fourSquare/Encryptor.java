package fourSquare;

import java.lang.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;

public class Encryptor{

    /**
     * stores the square used to encrypt the text
     */
    private Four_Square square;

    /**
     * the text to be encrypted
     */
    private String text;

    /**
     * the encrypted text
     */
    private String encrypted;

    /**
     * Array list of valid charters to go in the text
     * valid charters include A-Z excluding Q
     */
    private ArrayList<String> letters = new ArrayList<>(Arrays.asList("A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","R","S","T","U","V","W","X","Y","Z","a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","r","s","t","u","v","w","x","y","z"));

    /**
     * constructor for the encryptor
     * @param square the square to be used to encrypt the text
     * @param text the text to encrypt
     */
    public Encryptor(Four_Square square, String text){
        this.square = square;
        this.text = text;
        checkInputs();
        encrypted = "";
        encrypt();
    }

    /**
     * checks each charter in the text input to check for invalid charters
     * invalid charters are deleted from the text
     */
    public void checkInputs() {
        String temp = "";
        for (int i = 0; i < text.length(); i++) {
            if (letters.indexOf(text.substring(i, i + 1)) != -1) {
                temp = temp + text.substring(i, i + 1).toUpperCase();
            }
        }
        text = temp;
    }

    /**
     * getter for the text to be encrypted
     * @return the text to be encrypted
     */
    public String getText() {
        return text;
    }

    /**
     * setter for the text to be encrypted
     * @param text the new text to encrypt with e same square
     */
    public void setText(String text) {
        this.text = text;
        checkInputs();
        encrypt();
    }

    /**
     * getter for the encrypted text
     * @return the encrypted text
     */
    public String getEncrypted() {
        return encrypted;
    }

    /**
     * getter for the square used to encrypt the text
     * @return the square used to encrypt the text
     */
    public Four_Square getSquare() {
        return square;
    }

    /**
     * setter for the square to use to encrypt the text
     * @param square the new square to encrypt the text with
     */
    public void setSquare(Four_Square square) {
        this.square = square;
        encrypt();
    }

    /**
     * encrypts the text using the Four Square encryption technique
     */
    public void encrypt(){
        String temp = text;
        ArrayList<ArrayList<String>> alphabetSquare = square.getAlphabetSquare();
        while (temp.length() > 1){
            String letter1 = temp.substring(0,1);
            String letter2 = temp.substring(1,2);
            int[] letter1Index = new int[2]; //stores the row and column each of the letters appear in alphabet square
            int[] letter2Index = new int[2];
            for(int i = 0; i < 5; i++){
                for(int j = 0; j < 5; j++){
                    if(alphabetSquare.get(i).get(j).equalsIgnoreCase(letter1)){
                        letter1Index = new int[]{i, j};
                    }
                    if(alphabetSquare.get(i).get(j).equalsIgnoreCase(letter2)){
                        letter2Index = new int[]{i,j};
                    }
                }
            }
            //uses the top right and bottom left square to get the corresponding letters and adds them to the end of encrypted
            encrypted = encrypted + square.getTopRightSquare().get(letter1Index[0]).get(letter2Index[1]) + square.getBottomLeftSquare().get(letter2Index[0]).get(letter1Index[1]);
            temp = temp.substring(2); // gets rid of the first two letters from temp
        } // repeats until there are 0 or 1 letter left in temp
    }

    /**
     * to String method for the encrypted
     * @return the encrypted text
     */
    @Override
    public String toString(){
        return encrypted;
    }

}
