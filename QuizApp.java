import java.util.ArrayList;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

class Question {
    String questionText;
    String[] options;
    int correctAnswerIndex;

    public Question(String questionText, String[] options, int correctAnswerIndex) 
    {
        this.questionText = questionText;
        this.options = options;
        this.correctAnswerIndex = correctAnswerIndex;
    }

    public boolean isCorrect(int answerIndex) 
    {
        return answerIndex == correctAnswerIndex;
    }
}

public class QuizApp 
{
    private static final int TIME_LIMIT_SECONDS = 10;  // Time limit per question in seconds
    private static ArrayList<Question> questions = new ArrayList<>();
    private static int score = 0;
    private static ArrayList<Boolean> answerResults = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        loadQuestions();
        
        for (int i = 0; i < questions.size(); i++) {
            System.out.println("Question " + (i + 1) + ":");
            boolean answeredCorrectly = displayQuestionWithTimer(scanner, questions.get(i));
            answerResults.add(answeredCorrectly);
            if (answeredCorrectly) {
                score++;
            }
            System.out.println();
        }
        
        displayResults();
        scanner.close();
    }

    private static void loadQuestions() {
        questions.add(new Question(
            "What is the capital of France?",
            new String[] {"1. Berlin", "2. Paris", "3. Madrid", "4. Rome"},1
        ));
        questions.add(new Question(
            "What is the largest planet in our solar system?",
            new String[] {"1. Earth", "2. Mars", "3. Jupiter", "4. Saturn"},2
        ));
        questions.add(new Question(
            "Who wrote 'To Kill a Mockingbird'?",
            new String[] {"1. Harper Lee", "2. Ernest Hemingway", "3. Mark Twain", "4. F. Scott Fitzgerald"},0
        ));
    }

    private static boolean displayQuestionWithTimer(Scanner scanner, Question question) {
        System.out.println(question.questionText);
        for (String option : question.options) {
            System.out.println(option);
        }

        Timer timer = new Timer();
        final boolean[] timeOut = {false};
        
        // Start a timer that cancels after TIME_LIMIT_SECONDS
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                timeOut[0] = true;
                System.out.println("\nTime's up!");
                timer.cancel();
            }
        }, TIME_LIMIT_SECONDS * 1000);

        System.out.print("Enter your choice (1-4): ");
        int userAnswer = -1;
        if (!timeOut[0]) {
            userAnswer = scanner.nextInt() - 1;
        }
        
        timer.cancel();
        return !timeOut[0] && question.isCorrect(userAnswer);
    }

    private static void displayResults() {
        System.out.println("\nQuiz Complete!");
        System.out.println("Your final score: " + score + "/" + questions.size());
        
        for (int i = 0; i < questions.size(); i++) {
            System.out.println("Question " + (i + 1) + ": " + (answerResults.get(i) ? "Correct" : "Incorrect"));
        }
    }
}
