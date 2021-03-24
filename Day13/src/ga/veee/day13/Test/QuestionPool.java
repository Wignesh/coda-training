package ga.veee.day13.Test;

import java.util.*;

public class QuestionPool {
    private ArrayList<Question> questions = new ArrayList<Question>();
    public int MAX;

    public void add(String question, String[] options, UUID id, int answer) {
        questions.add(new Question(question, options, id, answer));
        MAX = questions.size();
    }

    public ArrayList<Question> getRandomQuestion(int count) {
        Collections.shuffle(questions);
        return new ArrayList<Question>(questions.subList(0, count));
    }
}
