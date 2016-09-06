package TestLetterGrader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class LetterGrader {
    private String inputName, outputName;
    private List<Student> students;

    public LetterGrader(String input, String output) {
        this.inputName = input;
        this.outputName = output;
    }

    public void calcLetterGrade() {
        for (Student student : this.students) {
            student.calcLetterGrade();
        }
    }
    
    public void printGrade() {
        for (Student student : this.students) {
            System.out.println(student.name + " " + student.letterGrade);
        }
    }
    
    public void getQuizScore() {
    	Object quizOnes = new ArrayList();
        
//    	System.out.println(scores);
//        for (Student student : this.students) {
//            student.calcAverages();
//        }
    }

    public void readScore() {
        try {
            Scanner infile = new Scanner(new FileReader(this.inputName));
            infile.useDelimiter("\n");
            this.students = new ArrayList();
            while (infile.hasNext()) {
                String line = infile.next();
                List<String> values = new LinkedList<>(Arrays.asList(line.split(",")));
                String name = values.remove(0);
                this.students.add(new Student(name, values));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}