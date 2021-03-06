import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import java.awt.Dimension;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyEvent;

import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

public class ke extends JFrame{

    private final JFrame frame;
    private JTextField textField;
    private JButton send;
    private JLabel friend;
    private JPanel panelOutput;
    private JTextArea textArea;
    private JScrollPane jsp;
    private int count = 0;
    private String comment = "";
    private int first = 1;

    public static void main(String[] args) {
        ke gui = new ke();
        gui.frame.setVisible(true);
        gui.frame.setPreferredSize(new Dimension(1125,250));
    }

    public ke() {
        frame = new JFrame();
        frame.setTitle("");
        //The program terminates when exiting the interface.
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Set the position, width and height of the interface.
        frame.setBounds(300, 10, 1000, 800);
        frame.getContentPane().setLayout(null);
        label();
        // Use to print the times of "ENTER" key pressed
        TimesInPeriod();
    }

    private void label() {
        SentenceListener sentenceListener = new SentenceListener();

        textField = new JTextField();
        textField.addActionListener(sentenceListener);
        frame.getContentPane().add(textField);

        send = new JButton("send");
        frame.getContentPane().add(send);
        //Push the send.
        send.addActionListener(sentenceListener);

        // rewrite use textarea
        textArea = new JTextArea("Your output will appear here.\nIf you want to cheer, press ENTER in this area as many times as you can.");
        textArea.setLineWrap(true);
        textArea.setEditable(false);
        // not editable
        textArea.addKeyListener(new KeyAdapter() {
            // listen when ENTER is pressed
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    count++;
                }
            }
        });

        // Add scroll to textarea
        jsp = new JScrollPane(textArea);

        panelOutput = new JPanel();
        panelOutput.setLayout(null);
        panelOutput.add(jsp);
        frame.getContentPane().add(panelOutput);

        friend = new JLabel("Your Friend");
        friend.setOpaque(true);
        friend.setBackground(Color.WHITE);
        //Words are displayed from the top.
        friend.setVerticalAlignment(SwingConstants.TOP);
        frame.getContentPane().add(friend);

        //When the interface is resized.
        frame.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                resizeFrame();
            }
        });
    }
    public void resizeFrame() {
        //How much the height has changed.
        int height = frame.getHeight() - 800;
        textField.setBounds(100, 675 + height/2, 300, 40);
        send.setBounds(425, 675 + height/2, 100, 40);
        panelOutput.setBounds(10, 10 + height/2, 1000, 600);
        // size and location of textarea and scroll
        jsp.setBounds(0, 0, 1000, 600);
        friend.setBounds(1100, 10 + height/2, 400, 700);
    }

    private String CommentFormat(String s, String user){
        // get time(local)
        Calendar ca = Calendar.getInstance();
        int hour = ca.get(Calendar.HOUR_OF_DAY);
        int minute = ca.get(Calendar.MINUTE);

        String cf = "";
        cf = hour + ":" + minute + "  " + user + "  " + s + "\n";
        return cf;
    }

    private void TimesInPeriod(){
        Timer timer = new Timer();

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                String cheer = Integer.toString(count) + " times pressed.";
                if(count == 0 || count == 1){
                    //System.out.println("None\n");
                }else if(count == 2){
                    cheer = "cheered!     " + cheer;
                    System.out.println("Low\n");
                }else if(count >= 3 && count <= 5){
                    cheer = "cheered!!     " + cheer;
                    System.out.println("Medium\n");
                }else if(count >= 6){
                    cheer = "cheered!!!     " + cheer;
                    System.out.println("High\n");
                }else {
                    System.out.println("Error\n");
                }
                if (count >= 2) {
                    if (first == 0) {
                        textArea.append(CommentFormat(cheer, "User"));
                    } else {
                        textArea.setText(CommentFormat(cheer, "User"));
                        first = 0;
                    }
                }
                count = 0;
            }
        }, 0, 1000);
    }

    private class SentenceListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            int empty = 0;
            if(textField.getText().length() == 0){
                empty = 1;
            }
            else{
                comment = CommentFormat(textField.getText(), "User");
            }
            if(empty != 1)
            {
                if(first == 0){
                    textArea.append(comment);
                }else{
                    textArea.setText(comment);
                    first = 0;
                }
            }
            textField.setText("");
        }
    }

}
