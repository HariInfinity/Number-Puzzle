package NumberPuzzle;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class NumberPuzzle {

    public static void main(String[] args) {
//        Random random = new Random();
//        System.out.println(random.nextInt(9));
        new LecNumberPuzzleGame();
    }

}

class LecNumberPuzzleGame extends JFrame {

//    JButton[] btn;
    JLabel winText;
    JButton[][] btn = new JButton[3][3];
    JButton buttonRestart;
    Random random = new Random();

    public LecNumberPuzzleGame() {
        setSize(392, 600);
        setVisible(true);
        setLayout(null);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowDeactivated(WindowEvent we) {
                super.windowDeactivated(we); //To change body of generated methods, choose Tools | Templates.
                System.exit(0);
            }
        });
        Font buttonFont = new Font("Calibri", Font.PLAIN, 100);
        Font font = new Font("Segoe UI", Font.PLAIN, 30);
        winText = new JLabel("");
        winText.setBounds(0, 385, 400, 100);
        winText.setFont(font);
        winText.setHorizontalAlignment(0);
        add(winText);
        
        int bSize = 125;
        int[] n = getRandomNumber();
        int c = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                JButton b = new JButton();
                b.setBounds(bSize * j, bSize * i, bSize, bSize);
                int finalI = i, finalJ = j;
                b.addActionListener((ae) -> buttonClick(b, finalI, finalJ));
                b.setFont(buttonFont);
                b.setText("" + (n[c] == 0 ? "" : "" + n[c]));
                c++;
                btn[i][j] = b;
                add(b);
            }
        }
        buttonRestart = new JButton("Restart");
        buttonRestart.setBounds(140, 490, 100, 40);
        buttonRestart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                restart();
            }
        });

        add(buttonRestart);
    }

    void buttonClick(JButton b, int i, int j) {
        if(winText.getText().equals("")) {
        if (i == 2 && j == 1) {
//            b.setText("*");
            if (btn[2][0].getText().equals("")) {
                btn[2][0].setText(b.getText());
                b.setText("");
            }
            if (btn[1][1].getText().equals("")) {
                btn[1][1].setText(b.getText());
                b.setText("");
            }
            if (btn[2][2].getText().equals("")) {
                btn[2][2].setText(b.getText());
                b.setText("");
            }
        }
        if (i == 2 && j == 0) {
            if (btn[1][0].getText().equals("")) {
                btn[1][0].setText(b.getText());
                b.setText("");
            }
            if (btn[2][1].getText().equals("")) {
                btn[2][1].setText(b.getText());
                b.setText("");
            }
        }
        if (i == 2 && j == 2) {
            if (btn[2][1].getText().equals("")) {
                btn[2][1].setText(b.getText());
                b.setText("");
            }
            if (btn[1][2].getText().equals("")) {
                btn[1][2].setText(b.getText());
                b.setText("");
            }
        }
        if (i == 1 && j == 1) {
            if (btn[2][1].getText().equals("")) {
                btn[2][1].setText(b.getText());
                b.setText("");
            }
            if (btn[1][0].getText().equals("")) {
                btn[1][0].setText(b.getText());
                b.setText("");
            }
            if (btn[0][1].getText().equals("")) {
                btn[0][1].setText(b.getText());
                b.setText("");
            }
            if (btn[1][2].getText().equals("")) {
                btn[1][2].setText(b.getText());
                b.setText("");
            }
        }
        if (i == 1 && j == 0) {
            if (btn[0][0].getText().equals("")) {
                btn[0][0].setText(b.getText());
                b.setText("");
            }
            if (btn[1][1].getText().equals("")) {
                btn[1][1].setText(b.getText());
                b.setText("");
            }
            if (btn[2][0].getText().equals("")) {
                btn[2][0].setText(b.getText());
                b.setText("");
            }
        }
        if (i == 1 && j == 2) {
            if (btn[1][1].getText().equals("")) {
                btn[1][1].setText(b.getText());
                b.setText("");
            }
            if (btn[0][2].getText().equals("")) {
                btn[0][2].setText(b.getText());
                b.setText("");
            }
            if (btn[2][2].getText().equals("")) {
                btn[2][2].setText(b.getText());
                b.setText("");
            }
        }
        if (i == 0 && j == 0) {
            if (btn[1][0].getText().equals("")) {
                btn[1][0].setText(b.getText());
                b.setText("");
            }
            if (btn[0][1].getText().equals("")) {
                btn[0][1].setText(b.getText());
                b.setText("");
            }
        }
        if (i == 0 && j == 1) {
            if (btn[0][0].getText().equals("")) {
                btn[0][0].setText(b.getText());
                b.setText("");
            }
            if (btn[1][1].getText().equals("")) {
                btn[1][1].setText(b.getText());
                b.setText("");
            }
            if (btn[0][2].getText().equals("")) {
                btn[0][2].setText(b.getText());
                b.setText("");
            }
        }
        if (i == 0 && j == 2) {
            if (btn[0][1].getText().equals("")) {
                btn[0][1].setText(b.getText());
                b.setText("");
            }
            if (btn[1][2].getText().equals("")) {
                btn[1][2].setText(b.getText());
                b.setText("");
            }
        }
        }
        winCheck();
    }

    private void restart() {

        int[] n = getRandomNumber();
//        String str = Integer.toString(random.nextInt(9));
        int c = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                btn[i][j].setText("" + (n[c] == 0 ? "" : "" + n[c]));
                c++;
                winText.setText("");
            }
        }
    }

    private int[] getRandomNumber() {
        Random rn = new Random();
        int[] a = {3,8,1,4,2,5,7,6,0};
        for (int i = 0; i < a.length; i++) {
            int r = rn.nextInt(a.length);
            int temp = a[i];
            a[i] = a[r];
            a[r] = temp;
        }
        return a;
    }

    private void winCheck() {
        if (btn[0][0].getText().equals("1") && btn[0][1].getText().equals("2") && btn[0][2].getText().equals("3") && btn[1][0].getText().equals("4") && btn[1][1].getText().equals("5") && btn[1][2].getText().equals("6") && btn[2][0].getText().equals("7") && btn[2][1].getText().equals("8") && btn[2][2].getText().equals("")) {
            winText.setText("You Won The Game!!");
        }
    }

}
