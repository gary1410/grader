package TestLetterGrader;

import java.util.ArrayList;
import java.util.List;

public class Quiz {
    public List<Integer> scores;
    public int average;
    public int max;
    public int min;

    public Quiz() {
        this.scores = new ArrayList();
    }

    public void addScore(int score) {
        this.scores.add(score);
    }

    public void calcScore() {
        int avg = 0;
        int max = 0;
        int min = 100;
        for (int i = 0; i < this.scores.size(); i++) {
            int score = this.scores.get(i);
            avg += score;
            if (max < score) {
                max = score;
            }
            if (min > score) {
                min = score;
            }
        }
        this.average = avg / this.scores.size();
        this.max = max;
        this.min = min;
    }
}
