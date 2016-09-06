package TestLetterGrader;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Student {
    public String name;
    public List<Integer> scores;
    public String letterGrade;
        
    public Student(String name, List scores) {
        this.name = name;
//        System.out.println(name);
        this.scores = new ArrayList();
        for (Object score : scores) {
            int x = Integer.parseInt(((String) score).trim());
            this.scores.add(x);
        }
    }
    
    public void calcLetterGrade() {
    	
	    double weightedScore = calculateQuizzes() + calculateMidterm1() + calculateMidterm2() + calculateFinal();
    
	    if (weightedScore >= 90 ) {
	    	this.letterGrade = "A";
	    } else if (weightedScore >= 80 ) {
	        this.letterGrade = "B";
	    } else if (weightedScore >= 70) {
	    	this.letterGrade = "C";
	    } else if (weightedScore >= 60 ) {
	    	this.letterGrade = "D";
	    } else { 
	    	this.letterGrade = "F";
	    }
    }
    
//    public void calcAverages() {
//    	calculateAverageMidterm2();
//    }
    
    private Double calculateFinal() {
       	int finalExam = scores.get(6);
       	double weightedFinalExam = finalExam * .25; 
       	return weightedFinalExam;
    }
    
    private Double calculateMidterm1() {
       	int midterm1 = scores.get(4);
       	double weightedMidterm1 = midterm1 * .20;
       	return weightedMidterm1;
    }
    
    private Double calculateMidterm2() {
       	int midterm2 = scores.get(5);
       	double weightedMidterm2 = midterm2 * .15;
       	return weightedMidterm2;
    }
    
	private Double calculateQuizzes() {
    	Double totalQuizzesWeighted = 0.0;
       	for (int i = 0; i < scores.size()-3; i++) {
       		int quiz = scores.get(i);
       		totalQuizzesWeighted += quiz * .10;
    	}
		return totalQuizzesWeighted;
	}
	 
	public Integer getQuizScore(int index) {
		System.out.println(scores);
		 Integer quizScore = scores.get(index);
		 return quizScore; 
	}
	
//	public Double calculateAverageMidterm2() {
//       	int midterm2 = scores.get(5);
//       	double weightedMidterm2 = midterm2 * .15;
//       	System.out.println(weightedMidterm2);
//		Double averageMidterm = weightedMidterm2/scores.size();
////		System.out.println(averageMidterm);
//		return averageMidterm;
//	}

    public int scoreFromQuizAtIndex(int index) {
		return this.scores.get(index);
	}
}