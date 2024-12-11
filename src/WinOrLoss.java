public class WinOrLoss {
    private int triesTook;
    private boolean wordGuessed;
    private String result;


    public WinOrLoss(int t, boolean g){
        triesTook = t;
        wordGuessed = g;
    }


    public void Outcome(){
        if (triesTook == 1 || triesTook == 2){
            System.out.println("---=====<YOU WIN!>=====---");
            System.out.println("Player Status: Alive");
            System.out.println("Diamond Status: Intact");
            System.out.println("Attempts made: " + triesTook);
            Gif1 gui1 = new Gif1();
            gui1.setVisible(true);
            gui1.pack();
            gui1.setTitle("Cutscene 1");
        }
        else if (triesTook == 3 && wordGuessed){
            System.out.println("---=====<YOU WIN! ... well, you survived>=====---");
            System.out.println("Player Status: Alive");
            System.out.println("Diamond Status: Destroyed");
            System.out.println("Attempts made: " + triesTook);
            Gif1 gui1 = new Gif1();
            gui1.setVisible(true);
            gui1.pack();
            gui1.setTitle("Cutscene 1");
        }
        else {
            System.out.println("---=====<ka-BOOM!!! YOU LOSE!!!!!!!>=====---");
            System.out.println("Player Status: Blew Up");
            System.out.println("Diamond Status: No Hope");
            System.out.println("Attempts made: 3");
            Gif2 gui2 = new Gif2();
            gui2.setVisible(true);
            gui2.pack();
            gui2.setTitle("Cutscene 2");
        }
    }
}
