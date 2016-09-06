package TestLetterGrader;

import java.io.*;
import java.util.*;

public class LetterGrader {
    private FileReader reader;
    private FileWriter writer;
    private List<Student> students;

    public LetterGrader(String input, String output) {
        try {
            File inFile = new File(input);
            this.reader = new FileReader(inFile);
            File outFile = new File(output);
            outFile.createNewFile();
            this.writer = new FileWriter(outFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void calcLetterGrade() {
        for (Student student : this.students) {
            student.calcLetterGrade();
        }
    }
    
    public void printGrade() {
        String output = "";
        for (Student student : this.students) {
            output = output.concat(student.name + " " + student.letterGrade + "\n");
        }
        output = output.concat("\n");
        try {
            this.writer.write(output);
        } catch (IOException e) {
            e.printStackTrace();
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
        Scanner infile = new Scanner(this.reader);
        infile.useDelimiter("\n");
        this.students = new ArrayList();
        while (infile.hasNext()) {
            String line = infile.next();
            List<String> values = new LinkedList<>(Arrays.asList(line.split(",")));
            String name = values.remove(0);
            this.students.add(new Student(name, values));
        }
    }

    public void displayAverages() {
        List<Quiz> quizzes = new ArrayList();
        int quizIndex = 0;
        for (Student student : this.students) {
            for (int i = 0; i < student.scores.size(); i++) {
                if (quizIndex == 0) {
                    Quiz quiz = new Quiz();
                    quiz.addScore(student.scores.get(i));
                    quizzes.add(quiz);
                } else {
                    Quiz quiz = quizzes.get(i);
                    quiz.addScore(student.scores.get(i));
                }
            }
            quizIndex += 1;
        }

        for (Quiz quiz : quizzes) {
            quiz.calcScore();
        }

        String output = "\t\t\t\t";
        for (int i = 0; i < quizzes.size(); i++) {
            output = output.concat("\tQ" + (i + 1));
        }
        output = output.concat("\n");

        output = output.concat("Averages:");
        for (int i = 0; i < quizzes.size(); i++) {
            output = output.concat("\t" + quizzes.get(i).average);
        }
        output = output.concat("\n");

        output = output.concat("Min:\t\t");
        for (int i = 0; i < quizzes.size(); i++) {
            output = output.concat("\t" + quizzes.get(i).min);
        }
        output = output.concat("\n");

        output = output.concat("Max:\t\t");
        for (int i = 0; i < quizzes.size(); i++) {
            output = output.concat("\t" + quizzes.get(i).max);
        }
        output = output.concat("\n");
        try {
            this.writer.write(output);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void cleanUp() {
        try {
            this.reader.close();
            this.writer.flush();
            this.writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}