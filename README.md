QuizApp is a simple command-line quiz application written in Java that presents multiple-choice questions to the user with a time limit per question. Each question must be answered within a set time frame (10 seconds, by default), after which the quiz moves to the next question. The program keeps track of correct and incorrect answers and displays the final score at the end.

Features
Timed Questions: Users have a limited time (10 seconds by default) to answer each question. If time runs out, the quiz moves to the next question.
Multiple-Choice Questions: Each question has four answer options. Users can choose their answer by entering the corresponding option number.
Score Tracking: The application calculates the user’s final score and displays whether each question was answered correctly or incorrectly.
Easy-to-extend Question Bank: New questions can easily be added to the quiz.

How It Works
Load Questions: A set of questions is predefined in the code. Each question has a text, four possible options, and the index of the correct answer.
Timer Functionality: A timer gives the user a limited time to answer each question. If time runs out, the application automatically moves on to the next question, displaying a "Time's up!" message.
Display Results: After all questions are answered (or time expires for each), the final score and a breakdown of correct/incorrect answers are displayed.

Code Structure
Question Class: Represents each question, including the question text, answer options, and correct answer index. It also contains a method to check if the user-selected answer is correct.
QuizApp Class: Manages the quiz flow, including:
Loading questions
Displaying each question with a timer
Capturing user input
Tracking score and answer correctness

Future Enhancements
Dynamic Question Loading: Add functionality to load questions from an external file or database.
Difficulty Levels: Implement multiple levels (easy, medium, hard) with varied question timers.
Category Selection: Allow users to select categories for questions (e.g., General Knowledge, Science, History).
Score Persistence: Store scores and track user progress over time.
