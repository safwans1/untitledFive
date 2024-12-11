import java.util.Scanner;
public class Scramble {
    private String name;
    private String word;
    public String finalScrambledWord;
    private Scanner scan;
    private int tries;
    private WinOrLoss worl;
    private boolean guessed = false;
    private int triesLeft = 3;
    boolean usedHint = false;


    public Scramble(){
        word = null;
        finalScrambledWord = "";
        scan = new Scanner(System.in);
        tries = 0;
    }


    public void Enter() {
        Gif0 gui = new Gif0();
        gui.setVisible(true);
        gui.pack();
        gui.setTitle("Cutscene 0");
        System.out.println("--===<Who dare solve this riddle?>===-- (enter your name please)");
        name = scan.nextLine();
        WordChooser();
    }


    public void WordChooser(){
        int num = (int) (Math.random() * 6) + 1;
        if (num == 1){
            word = "CHAIR";
        }
        else if (num == 2){
            word = "CIDER";
        }
        else if (num == 3){
            word = "FLAME";
        }
        else if (num == 4){
            word = "RAMEN";
        }
        else if (num == 5){
            word = "ROACH";
        }
        else {
            word = "SCARF";
        }
        Shuffle();
    }


    public String Shuffle(){
        String scrambledWord = "";
        int n1, n2;
        do {
            n1 = (int) (Math.random() * 5);
            n2 = (int) (Math.random() * 5);
        }while (n1 >= n2);


        scrambledWord += word.substring(0,n1);
        scrambledWord += word.substring(n2,n2+1);
        scrambledWord += word.substring(n1+1,n2);
        scrambledWord += word.substring(n1,n1+1);
        scrambledWord += word.substring(n2,5);


        for (int i = 0; i < scrambledWord.length(); i++){
            boolean duplicate = false;
            for (int j = 0; j < finalScrambledWord.length(); j++){
                if (finalScrambledWord.substring(j,j+1).equals(scrambledWord.substring(i,i+1))){
                    duplicate = true;
                    break;
                }
            }
            if (!duplicate) {
                finalScrambledWord += scrambledWord.substring(i,i+1);
            }
        }
        if (finalScrambledWord.equals(word)){
            Shuffle();
        }
        return finalScrambledWord;
    }


    public void Hint(String wr){
        if (!usedHint){
            if (wr.equals("CHAIR")){
                System.out.println("--===<HINT>===-- \nIt is four-legged");
            }
            if (wr.equals("CIDER")){
                System.out.println("--===<HINT>===-- \nThey are made at orchards");
            }
            if (wr.equals("FLAME")){
                System.out.println("--===<HINT>===-- \nIt requires oxygen to live");
            }
            if (wr.equals("RAMEN")){
                System.out.println("--===<HINT>===-- \nIt goes great with boiled egg");
            }
            if (wr.equals("ROACH")){
                System.out.println("--===<HINT>===-- \nIt's an annoying little pest");
            }
            if (wr.equals("SCARF")){
                System.out.println("--===<HINT>===-- \nYou wear this in the winter");
            }
            usedHint = true;
        }
        else {
            System.out.println("--===<HINT>===-- \nThere are no more hints; sorry");
        }
    }


    public int Guess() {
        System.out.println("Very well, " + name + "... \n--===<Unscramble the word in all capital letters, or meet your doom...>===--");
        System.out.println("<Incorrect answers will be punished>");
        System.out.println("<Type \"H\" for a hint> \nyou only get one of those, so be careful!)");
        if (!guessed){
            String userInput = "";
            while (tries < 3 && !guessed) {
                System.out.println("--===<Unscramble this>===--\n" + finalScrambledWord);
                userInput = scan.nextLine();
                tries++;
                triesLeft--;
                if (!userInput.equals(word) && !userInput.equals("H")) {
                    System.out.println("WRONG! " + triesLeft + " tries left!");
                } else if (userInput.equals("H")) {
                    Hint(word);
                    tries--;
                    triesLeft++;
                }
                else {
                    guessed = true;
                }
            }
        }
        return triesLeft;
    }


    public void Test(){
        worl = new WinOrLoss(tries, guessed);
        worl.Outcome();
    }
}
