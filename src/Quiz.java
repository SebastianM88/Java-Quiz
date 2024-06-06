import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Quiz implements ActionListener {

    // Here is the code made for presenting the questions of Array types of our quiz
    String[] questions = {
            "What is OOP?",
            "What does JVM stand for in the context of Java?",
            "What is a constructor in Java?",
            "What is inheritance in Java?"
    };

    // Here is the code which present each option
    String[][] options = {
            {"Object Oriented Programming", "A software tool","A Java library" , "A type of variable"},
            {"Java Version Manager", "Java Virtual Machine", "Java Variable Method", "Just Very Massive"},
            {"A Java library", "A special class", "An interface", "A method to create objects"},
            {"Inherits properties", "Cannot be inherited", "Reusing code", "Cannot have subclasses"}
    };

    // And the code with the right answer for each question
    char[] answers = {
            'A',
            'B',
            'D',
            'A'
    };

    // Here are ours variables which are going to use
    char answer;
    int index;
    int correct_guesses = 0;
    int total_questions = questions.length;
    int results;
    int seconds = 10;

    // Here are all the elements of our interface
    JFrame frame = new JFrame();
    JTextField textField = new JTextField();
    JTextArea textArea = new JTextArea();
    JButton buttonA = new JButton();
    JButton buttonB = new JButton();
    JButton buttonC = new JButton();
    JButton buttonD = new JButton();
    JLabel answer_labelA = new JLabel();
    JLabel answer_labelB = new JLabel();
    JLabel answer_labelC = new JLabel();
    JLabel answer_labelD = new JLabel();
    JLabel time_label = new JLabel();
    JLabel second_left = new JLabel();
    JTextField number_right = new JTextField();
    JTextField percentage = new JTextField();

    // The Code for setting our timer and they time limit
    Timer timer = new Timer(1000, new ActionListener() {

        // Code meant to put into action our timer, and if the time expired to show us a result
        @Override
        public void actionPerformed(ActionEvent e) {

            seconds--;
            second_left.setText(String.valueOf(seconds));
            if(seconds<=0) {
                displayAnswer();
            }
        }
    });

    // Our builder that will host all the code elements of our interface
    public Quiz() {

        // Code for displaying the frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,650);
        frame.getContentPane().setBackground(new Color(50,50,50));
        frame.setLayout(null);
        frame.setResizable(false);

        // Our code where the question number will be presented
        textField.setBounds(0, 0, 800,50 );
        textField.setBackground(new Color(25, 25, 25));
        textField.setForeground(new Color(25,255,0));
        textField.setFont(new Font("MV Boli", Font.BOLD, 30));
        textField.setBorder(BorderFactory.createBevelBorder(1));
        textField.setHorizontalAlignment(JTextField.CENTER);
        textField.setEditable(false);

        // The code where the question will be presented
        textArea.setBounds(0, 50, 800,50 );
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setBackground(new Color(25, 25, 25));
        textArea.setForeground(new Color(25,255,0));
        textArea.setFont(new Font("MV Boli", Font.BOLD, 30));
        textArea.setBorder(BorderFactory.createBevelBorder(1));
        textArea.setEditable(false);

        /* the necessary code to create the interface of each button to
        display the letter corresponding to each question option */
        buttonA.setBounds(0,100,100,100);
        buttonA.setFont(new Font("MV Boli", Font.BOLD, 35));
        buttonA.setFocusable(false);
        buttonA.addActionListener(this);
        buttonA.setText("A");

        /* the necessary code to create the interface of each button to
        display the letter corresponding to each question option */
        buttonB.setBounds(0,200,100,100);
        buttonB.setFont(new Font("MV Boli", Font.BOLD, 35));
        buttonB.setFocusable(false);
        buttonB.addActionListener(this);
        buttonB.setText("B");

        /* the necessary code to create the interface of each button to
        display the letter corresponding to each question option */
        buttonC.setBounds(0,300,100,100);
        buttonC.setFont(new Font("MV Boli", Font.BOLD, 35));
        buttonC.setFocusable(false);
        buttonC.addActionListener(this);
        buttonC.setText("C");

        /* the necessary code to create the interface of each button to
        display the letter corresponding to each question option */
        buttonD.setBounds(0,400,100,100);
        buttonD.setFont(new Font("MV Boli", Font.BOLD, 35));
        buttonD.setFocusable(false);
        buttonD.addActionListener(this);
        buttonD.setText("D");

        // Code to expose the text of each question option
        answer_labelA.setBounds(125,100,600,100);
        answer_labelA.setBackground(new Color(50,50,50));
        answer_labelA.setForeground(new Color(25,255,0));
        answer_labelA.setFont(new Font("MB Boli",Font.BOLD, 35));

        // Code to expose the text of each question option
        answer_labelB.setBounds(125,200,500,100);
        answer_labelB.setBackground(new Color(50,50,50));
        answer_labelB.setForeground(new Color(25,255,0));
        answer_labelB.setFont(new Font("MB Boli",Font.BOLD, 35));

        // Code to expose the text of each question option
        answer_labelC.setBounds(125,300,500,100);
        answer_labelC.setBackground(new Color(50,50,50));
        answer_labelC.setForeground(new Color(25,255,0));
        answer_labelC.setFont(new Font("MB Boli",Font.BOLD, 35));

        // Code to expose the text of each question option
        answer_labelD.setBounds(125,400,500,100);
        answer_labelD.setBackground(new Color(50,50,50));
        answer_labelD.setForeground(new Color(25,255,0));
        answer_labelD.setFont(new Font("MB Boli",Font.BOLD, 35));

        // Code to create the interface that will present us the remaining seconds
        second_left.setBounds(685,515,100,100);
        second_left.setBackground(new Color(25,25,25));
        second_left.setForeground(new Color(255,0, 0));
        second_left.setFont(new Font("MB Boli", Font.BOLD, 60 ));
        second_left.setBorder(BorderFactory.createBevelBorder(1));
        second_left.setOpaque(true);
        second_left.setHorizontalAlignment(JTextField.CENTER);
        second_left.setText(String.valueOf(seconds));

        /* The code to create a simple name displayed above our interface
        that displays the remaining seconds */
        time_label.setBounds(685,485,100,25);
        time_label.setBackground(new Color(50,50,50));
        time_label.setForeground(new Color(255,0,0));
        time_label.setFont(new Font("MB Boli",Font.BOLD, 20 ));
        time_label.setHorizontalAlignment(JTextField.CENTER);
        time_label.setText("time :)");

        /* The code that will deal with the display of an interface that will
        present the number of correct answers */
        number_right.setBounds(350,225,200,100);
        number_right.setBackground(new Color(25,25,25));
        number_right.setForeground(new Color(25,255,0));
        number_right.setFont(new Font("MB Boli",Font.BOLD, 50 ));
        number_right.setBorder(BorderFactory.createBevelBorder(1));
        number_right.setHorizontalAlignment(JTextField.CENTER);
        number_right.setEditable(false);

        /* The code that will handle the display of an interface that will
        present the percentage of our correct answers */
        percentage.setBounds(350,325,200,100);
        percentage.setBackground(new Color(25,25,25));
        percentage.setForeground(new Color(25,255,0));
        percentage.setFont(new Font("MB Boli",Font.BOLD, 50 ));
        percentage.setBorder(BorderFactory.createBevelBorder(1));
        percentage.setHorizontalAlignment(JTextField.CENTER);
        percentage.setEditable(false);

        // The code to add all our elements on the frame for being displayed
        frame.add(time_label);
        frame.add(second_left);
        frame.add(answer_labelA);
        frame.add(answer_labelB);
        frame.add(answer_labelC);
        frame.add(answer_labelD);
        frame.add(buttonA);
        frame.add(buttonB);
        frame.add(buttonC);
        frame.add(buttonD);
        frame.add(textArea);
        frame.add(textField);
        frame.setVisible(true);

        nextQuestion();

    }

    // Here is the code that aims to start the timer and display each question in row
    public void nextQuestion()  {

        if(index >= total_questions) {

            results();
        } else {

            textField.setText("Question" + (index + 1));
            textArea.setText(questions[index]);
            answer_labelA.setText(options[index][0]);
            answer_labelB.setText(options[index][1]);
            answer_labelC.setText(options[index][2]);
            answer_labelD.setText(options[index][3]);
            timer.start();
        }
    }

    // Here is the code to count each answer separately
    @Override
    public void actionPerformed(ActionEvent e) {

        /* Code Peter set that our buttons can not be accessed after
        time has expired and become inaccessible until the next question */
        buttonA.setEnabled(false);
        buttonB.setEnabled(false);
        buttonC.setEnabled(false);
        buttonD.setEnabled(false);

        if (e.getSource()==buttonA) {

            answer = 'A';
            if (answer == answers[index]) {
                correct_guesses++;
            }
        }
        if (e.getSource()==buttonB) {

            answer = 'B';
            if (answer == answers[index]) {
                correct_guesses++;
            }
        }
        if (e.getSource()==buttonC) {

            answer = 'C';
            if (answer == answers[index]) {
                correct_guesses++;
            }
        }
        if (e.getSource()==buttonD) {

            answer = 'D';
            if (answer == answers[index]) {
                correct_guesses++;
            }
        }

        displayAnswer();
    }

    /* Here is the code that aims at choosing a variant to present us the
    correct answer in green color and also the wrong answers to display them in red */
    public void displayAnswer() {

        timer.stop();
        buttonA.setEnabled(false);
        buttonB.setEnabled(false);
        buttonC.setEnabled(false);
        buttonD.setEnabled(false);

        if (answers[index] != 'A')
            answer_labelA.setForeground(new Color(255,0,0));
        if (answers[index] != 'B')
            answer_labelB.setForeground(new Color(255,0,0));
        if (answers[index] != 'C')
            answer_labelC.setForeground(new Color(255,0,0));
        if (answers[index] != 'D')
            answer_labelD.setForeground(new Color(255,0,0));

        // here we wanted to set the timeline to offer a 2-second break before posting the next question
        Timer pause = new Timer(2000, new ActionListener() {

            // method to display the correct option in green color comparable to the others
            @Override
            public void actionPerformed(ActionEvent e) {

                answer_labelA.setForeground(new Color(25,255,0));
                answer_labelB.setForeground(new Color(25,255,0));
                answer_labelC.setForeground(new Color(25,255,0));
                answer_labelD.setForeground(new Color(25,255,0));

                answer = ' ';
                seconds = 10;
                second_left.setText(String.valueOf(seconds));
                buttonA.setEnabled(true);
                buttonB.setEnabled(true);
                buttonC.setEnabled(true);
                buttonD.setEnabled(true);
                index++;
                nextQuestion();
            }
        });
        pause.setRepeats(false);
        pause.start();
    }

    // The method that aims to calculate all the answers offered and to show us the number of correct answers and their percentage of success
    public void results(){

        buttonA.setEnabled(false);
        buttonB.setEnabled(false);
        buttonC.setEnabled(false);
        buttonD.setEnabled(false);

        results = (int)((correct_guesses/(double)total_questions )*100);

        textField.setText("Results!");
        textArea.setText("");
        answer_labelA.setText("");
        answer_labelB.setText("");
        answer_labelC.setText("");
        answer_labelD.setText("");

        number_right.setText("(" + correct_guesses + "/" + total_questions + ")" );
        percentage.setText(results + "%");

        frame.add(number_right);
        frame.add(percentage);
    }
}