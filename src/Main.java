import javax.swing.*;


public class Main {
    public static void main(String[] args) {
        Scramble w = new Scramble();
        w.Enter();
        System.out.println(w.Shuffle());
        w.Guess();
        w.Test();
    }
}
