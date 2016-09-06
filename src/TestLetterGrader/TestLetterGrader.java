package TestLetterGrader;

public class TestLetterGrader {
    public static void main(String[] args) {
        LetterGrader lg = new LetterGrader(args[0], args[1]);
        lg.readScore();
        lg.calcLetterGrade();
        lg.printGrade();
//        lg.displayAverages();
    }
}