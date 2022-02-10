package fourSquare;

import java.lang.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Decryptor {

    /**
     * stores the square used to encrypt the text
     */
    private Four_Square square;

    /**
     * the text to be decrypted
     */
    private String text;

    /**
     * the decrypted text
     */
    private String decrypted;

    /**
     * Array list of valid charters to go in the text
     * valid charters include A-Z excluding Q
     */
    private ArrayList<String> letters = new ArrayList<>(Arrays.asList("A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","R","S","T","U","V","W","X","Y","Z","a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","r","s","t","u","v","w","x","y","z"));

    /**
     * constructor for a Decryptor
     * @param square the square used to encrypt the text
     * @param text the text to decrypt
     */
    public Decryptor(Four_Square square, String text){
        this.square = square;
        this.text = text;
        checkInputs();
        decrypted = "";
        decrypt();
    }

    /**
     * checks each charter in the text input to check for invalid charters
     * invalid charters are deleted from the text
     */
    public void checkInputs() {
        String temp = "";
        for (int i = 0; i < text.length(); i++) {
            if (letters.indexOf(text.substring(i, i + 1)) != -1) {
                temp = temp + text.substring(i, i + 1);
            }
        }
        text = temp;
    }

    /**
     * getter for the text to be decrypted
     * @return the text to be decrypted
     */
    public String getText() {
        return text;
    }

    /**
     * setter for the text to be encrypted
     * @param text the text to be encrypted
     */
    public void setText(String text) {
        this.text = text;
        checkInputs();
        decrypt();
    }

    /**
     * getter for the decrypted text
     * @return the decrypted text
     */
    public String getDecrypted() {
        return decrypted;
    }

    /**
     * getter for the square used to encrypt the text
     * @return the square used to encrypt and decrypt the text
     */
    public Four_Square getSquare() {
        return square;
    }

    /**
     * setter for the square used to encrypt the text
     * @param square the new square to use to decrypt the text
     */
    public void setSquare(Four_Square square) {
        this.square = square;
        decrypt();
    }

    /**
     * decrypts the text using the Four Square encryption technique
     */
    public void decrypt(){
        String temp = text;
        ArrayList<ArrayList<String>> topRightSquare = square.getTopRightSquare();
        ArrayList<ArrayList<String>> bottomRightSquare = square.getBottomLeftSquare();
        while (temp.length() > 1){
            String letter1 = temp.substring(0,1);
            String letter2 = temp.substring(1,2);
            int[] letter1Index = null; // stores the row and column of each of the letters in their respective squares
            int[] letter2Index = null;
            for(int i = 0; i < 5; i++){
                for(int j = 0; j < 5; j++){
                    if(topRightSquare.get(i).get(j).equalsIgnoreCase(letter1)){
                        letter1Index = new int[]{i, j};
                    }
                    if(bottomRightSquare.get(i).get(j).equalsIgnoreCase(letter2)){
                        letter2Index = new int[]{i,j};
                    }
                }
            }
            // finds the corresponding spots in the alphabet square and adds it to the end of the decrypted text
            decrypted = decrypted + square.getAlphabetSquare().get(letter1Index[0]).get(letter2Index[1]).toUpperCase() + square.getAlphabetSquare().get(letter2Index[0]).get(letter1Index[1]).toUpperCase();
            temp = temp.substring(2); // deletes the first to letters from temp
        } // repeats until only 0 or 1 letters remain in temp
    }

    /**
     * the to string method for a decryptor
     * @return the decrypted text
     */
    @Override
    public String toString(){
        return decrypted;
    }
}
