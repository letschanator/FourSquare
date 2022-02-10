package fourSquare;

import java.util.ArrayList;
import java.util.Arrays;

public class Four_Square {

    /**
     * the keyword used to from the top right square
     */
    private String keyword1;

    /**
     * the keyword used to form the bottom left square
     */
    private String keyword2;

    /**
     * stores a alphabet square to be used as the top left and bottom right squares
     */
    private ArrayList<ArrayList<String>> alphabetSquare;

    /**
     * stores the top right square
     */
    private ArrayList<ArrayList<String>> topRightSquare;

    /**
     * stores the bottom left square
     */
    private ArrayList<ArrayList<String>> bottomLeftSquare;

    /**
     * an Array List of valid charters to put in the keywords
     * valid charters include A-Z excluding Q
     */
    private ArrayList<String> letters = new ArrayList<>(Arrays.asList("A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","R","S","T","U","V","W","X","Y","Z"));

    /**
     * constructor for a Four Square
     * @param keyword1 the keyword used to form the top right square
     * @param keyword2 the keyword used to form the bottom left square
     */
    public Four_Square(String keyword1, String keyword2){
        this.keyword1 = keyword1;
        this.keyword2 = keyword2;
        checkInputs();
        alphabetSquare = new ArrayList<>(); // alphabet square is always the same so forms it immediately
        ArrayList<String> row = new ArrayList<>(Arrays.asList("a","b","c","d","e"));
        alphabetSquare.add(row);
        row = new ArrayList<>(Arrays.asList("f","g","h","i","j"));
        alphabetSquare.add(row);
        row = new ArrayList<>(Arrays.asList("k","l","m","n","o"));
        alphabetSquare.add(row);
        row = new ArrayList<>(Arrays.asList("p","r","s","t","u"));
        alphabetSquare.add(row);
        row = new ArrayList<>(Arrays.asList("v","w","x","y","z"));
        alphabetSquare.add(row);
        topRightSquare = new ArrayList<>();
        bottomLeftSquare = new ArrayList<>();
        formSquares();

    }

    /**
     * checks keyword 1 and keyword 2 for invalid charters
     * invalid charters are deleted
     */
    public void checkInputs(){
        String temp = "";
        for (int i = 0; i < keyword1.length(); i++){
            if(letters.indexOf(keyword1.substring(i,i+1)) != -1){ // if the current charter is in the letters array list
                temp = temp + keyword1.substring(i,i+1);
            }
        }
        keyword1 = temp;
        temp = "";
        for (int i = 0; i < keyword2.length(); i++){
            if(letters.indexOf(keyword2.substring(i,i+1)) != -1){
                temp = temp + keyword2.substring(i,i+1);
            }
        }
        keyword2 = temp;
    }

    /**
     * forms the top right and bottom left square
     */
    public void formSquares(){
        ArrayList<String> otherLetters1 =  letters; // a list of A-Z excluding Q, when a letter is found in keyword 1 or 2 removes that letter from the corresponding list
        ArrayList<String> otherLetters2 =  letters;
        ArrayList<String> lettersInKeyword1 = new ArrayList<>(); // keeps the unique letters in order for both keywords
        ArrayList<String> lettersInKeyword2 = new ArrayList<>();
        for(int i = 0; i < keyword1.length(); i++){
            String letter = keyword1.substring(i,i+1);
            if(lettersInKeyword1.indexOf(letter) == -1) { // if the current letter isn't already in the the letters array list
                for (int j = 0; j < 5; j++) {
                    if (alphabetSquare.get(j).indexOf(letter.toLowerCase()) != -1) {
                        otherLetters1.remove(letter);
                        lettersInKeyword1.add(letter);
                        break;
                    }
                }
            }
        }
        for(int i = 0; i < keyword2.length(); i++){
            String letter = keyword2.substring(i,i+1);
            if(lettersInKeyword2.indexOf(letter) == -1) {
                for (int j = 0; j < 5; j++) {
                    if (alphabetSquare.get(j).indexOf(letter.toLowerCase()) != -1) {
                        otherLetters2.remove(letter);
                        lettersInKeyword2.add(letter);
                        break;
                    }
                }
            }
        }
        int count1 = 0;
        int count2 = 0;
        for(int i = 0; i < 5; i++){
            ArrayList<String> row1 = new ArrayList<>();
            ArrayList<String> row2 = new ArrayList<>();
            for(int j = 0; j < 5; j++){
                if(count1 < lettersInKeyword1.size()){ // if we are still going through the letters in the keyword
                    row1.add(lettersInKeyword1.get(count1));
                }else{
                    row1.add(otherLetters1.get(count1 - lettersInKeyword1.size())); // count at this point is letters in keyword size + the letter in other letters currently
                }
                if(count2 < lettersInKeyword2.size()){
                    row2.add(lettersInKeyword2.get(count2));
                }else{
                    row2.add(otherLetters2.get(count2 - lettersInKeyword2.size()));
                }
                count1++;
                count2++;
            }
            topRightSquare.add(row1);
            bottomLeftSquare.add(row2);
        }
    }

    /**
     * getter for keyword1
     * @return keyword1
     */
    public String getKeyword1() {
        return keyword1;
    }

    /**
     * setter for keyword1
     * @param keyword1 the new keyword used to form the top right square
     */
    public void setKeyword1(String keyword1) {
        this.keyword1 = keyword1;
        checkInputs();
        formSquares();
    }

    /**
     * getter for keyword2
     * @return keyword2
     */
    public String getKeyword2() {
        return keyword2;
    }

    /**
     * setter for keyword2
     * @param keyword2 the new keyword used to form the bottom left square
     */
    public void setKeyword2(String keyword2) {
        this.keyword2 = keyword2;
        checkInputs();
        formSquares();
    }

    /**
     * getter for the alphabet square
     * @return an alphabet square
     */
    public ArrayList<ArrayList<String>> getAlphabetSquare() {
        return alphabetSquare;
    }


    /**
     * getter for the top right square
     * @return the top right square
     */
    public ArrayList<ArrayList<String>> getTopRightSquare() {
        return topRightSquare;
    }


    /**
     * getter for the bottom left square
     * @return the bottom left square
     */
    public ArrayList<ArrayList<String>> getBottomLeftSquare() {
        return bottomLeftSquare;
    }

    /**
     * the to String method for a Four Square
     * @return a string representation of the four squares in their proper places
     */
    @Override
    public String toString(){
        String ret = "";
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                ret = ret + alphabetSquare.get(i).get(j) + " ";
            }
            ret = ret + "   ";
            for(int j = 0; j < 5; j++){
                ret = ret + topRightSquare.get(i).get(j) + " ";
            }
            ret = ret + "\n";
        }
        ret = ret + "\n";
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                ret = ret + bottomLeftSquare.get(i).get(j) + " ";
            }
            ret = ret + "   ";
            for(int j = 0; j < 5; j++){
                ret = ret + alphabetSquare.get(i).get(j) + " ";
            }
            ret = ret + "\n";
        }

        return ret;
    }
}
