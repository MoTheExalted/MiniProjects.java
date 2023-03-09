import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.HashSet;

public class puzzleGame extends JFrame implements ActionListener{
    JFrame frame;
    JPanel panel;
    JButton[] buttons;
    puzzleGame(){
        frame=new JFrame("Puzzle Game");
        //constructs a 3x3 panel so that my buttons look like a keypad
        JPanel buttonPanel=new JPanel(new GridLayout(3,3));

        Font font=new Font("Ariel",Font.BOLD,30);
        buttons=new JButton[9];

        //placing buttons similar to a numeric keypad to a panel
        for (int i=0;i<buttons.length;i++){
            buttons[i]=new JButton(String.valueOf(i+1));
            buttons[i].setFont(font);
            buttons[i].addActionListener(this);
        }

        //Randomize the layout of the buttons
        HashSet<Integer> set=new HashSet<>();
        //the set will check if the randomindex has already been accessed and swapped. the do-while will swap if necessary
        for (int i=0;i<buttons.length;i++) {
            int randomIndex;
            do{
                randomIndex = (int) (Math.random() * buttons.length);
            }
            while (set.contains(randomIndex));
                set.add(randomIndex);
                JButton temp=buttons[i];
                buttons[i]=buttons[randomIndex];
                buttons[randomIndex]=temp;
        }

        //adds random space to the keypad
        int randomIndex = (int) (Math.random() * buttons.length);
        buttons[randomIndex].setText("");
        for (JButton button:buttons){
            buttonPanel.add(button);
        }

        //Make a panel above a keypad that explains what the game is
        JLabel label=new JLabel("A Blank space will be placed instead of a number. Your job is to put " +
                "the numbers in the correct order. Numbers can't move diagonally");
        label.setFont(new Font("Ariel",Font.PLAIN,20));
        JPanel labelPanel=new JPanel(new BorderLayout());
        labelPanel.add(label,BorderLayout.CENTER);


        frame.add(labelPanel,BorderLayout.NORTH);
        frame.add(buttonPanel,BorderLayout.CENTER);
        frame.pack();
        frame.setSize(1000,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        //for buttons around 1
        if (e.getSource()==buttons[0]){
            String label=buttons[0].getText();
            if (buttons[1].getText().equals("")){
                buttons[1].setText(label);
                buttons[0].setText("");
            }
            if (buttons[3].getText().equals("")){
                buttons[3].setText(label);
                buttons[0].setText("");
            }
        }

        //for buttons around 2
        if (e.getSource()==buttons[1]){
            String label=buttons[1].getText();
            if (buttons[0].getText().equals("")){
                buttons[0].setText(label);
                buttons[1].setText("");
            }
            if (buttons[2].getText().equals("")){
                buttons[2].setText(label);
                buttons[1].setText("");
            }
            if (buttons[4].getText().equals("")){
                buttons[4].setText(label);
                buttons[1].setText("");
            }
        }

        //for buttons around 3
        if (e.getSource()==buttons[2]){
            String label=buttons[2].getText();
            if (buttons[1].getText().equals("")){
                buttons[1].setText(label);
                buttons[2].setText("");
            }
            if (buttons[5].getText().equals("")){
                buttons[5].setText(label);
                buttons[2].setText("");
            }
        }

        //for buttons around 4
        if (e.getSource()==buttons[3]){
            String label=buttons[3].getText();
            if (buttons[0].getText().equals("")){
                buttons[0].setText(label);
                buttons[3].setText("");
            }
            if (buttons[4].getText().equals("")){
                buttons[4].setText(label);
                buttons[3].setText("");
            }
            if (buttons[6].getText().equals("")){
                buttons[6].setText(label);
                buttons[3].setText("");
            }
        }

        //for buttons around 5
        if (e.getSource()==buttons[4]){
            String label=buttons[4].getText();
            if (buttons[1].getText().equals("")){
                buttons[1].setText(label);
                buttons[4].setText("");
            }
            if (buttons[3].getText().equals("")){
                buttons[3].setText(label);
                buttons[4].setText("");
            }
            if (buttons[5].getText().equals("")){
                buttons[5].setText(label);
                buttons[4].setText("");
            }
            if (buttons[7].getText().equals("")){
                buttons[7].setText(label);
                buttons[4].setText("");
            }


        }

        //for buttons around 6
        if (e.getSource()==buttons[5]){
            String label=buttons[5].getText();
            if (buttons[2].getText().equals("")){
                buttons[2].setText(label);
                buttons[5].setText("");
            }
            if (buttons[4].getText().equals("")){
                buttons[4].setText(label);
                buttons[5].setText("");
            }
            if (buttons[8].getText().equals("")){
                buttons[8].setText(label);
                buttons[5].setText("");
            }
        }

        //for buttons around 7
        if (e.getSource()==buttons[6]){
            String label=buttons[6].getText();
            if (buttons[3].getText().equals("")){
                buttons[3].setText(label);
                buttons[6].setText("");
            }
            if (buttons[7].getText().equals("")){
                buttons[7].setText(label);
                buttons[6].setText("");
            }
        }

        //for buttons around 8
        if (e.getSource()==buttons[7]){
            String label=buttons[7].getText();
            if (buttons[6].getText().equals("")){
                buttons[6].setText(label);
                buttons[7].setText("");
            }
            if (buttons[8].getText().equals("")){
                buttons[8].setText(label);
                buttons[7].setText("");
            }
            if (buttons[4].getText().equals("")){
                buttons[4].setText(label);
                buttons[7].setText("");
            }
        }

        //for buttons around 6
        if (e.getSource()==buttons[8]){
            String label=buttons[8].getText();
            if (buttons[7].getText().equals("")){
                buttons[7].setText(label);
                buttons[8].setText("");
            }
            if (buttons[5].getText().equals("")){
                buttons[5].setText(label);
                buttons[8].setText("");
            }
        }

        //conditions for winning the game
        //if 9 is out
        if (buttons[0].getText().equals("1") && buttons[1].getText().equals("2")
                && buttons[2].getText().equals("3") && buttons[3].getText().equals("4")
                && buttons[4].getText().equals("5") && buttons[5].getText().equals("6")
                && buttons[6].getText().equals("7") && buttons[7].getText().equals("8")){
            JOptionPane.showMessageDialog(this, "You Won!!!");

        }

        //if 8 is out
        if (buttons[0].getText().equals("1") && buttons[1].getText().equals("2")
                && buttons[2].getText().equals("3") && buttons[3].getText().equals("4")
                && buttons[4].getText().equals("5") && buttons[5].getText().equals("6")
                && buttons[6].getText().equals("7") && buttons[8].getText().equals("9")){
            JOptionPane.showMessageDialog(this, "You Won!!!");

        }

        //if 7 is out
        if (buttons[0].getText().equals("1") && buttons[1].getText().equals("2")
                && buttons[2].getText().equals("3") && buttons[3].getText().equals("4")
                && buttons[4].getText().equals("5") && buttons[5].getText().equals("6")
                && buttons[7].getText().equals("8") && buttons[8].getText().equals("9")){
            JOptionPane.showMessageDialog(this, "You Won!!!");

        }

        //if 6 is out
        if (buttons[0].getText().equals("1") && buttons[1].getText().equals("2")
                && buttons[2].getText().equals("3") && buttons[3].getText().equals("4")
                && buttons[4].getText().equals("5") && buttons[6].getText().equals("7")
                && buttons[7].getText().equals("8") && buttons[8].getText().equals("9")){
            JOptionPane.showMessageDialog(this, "You Won!!!");

        }

        //if 5 is out
        if (buttons[0].getText().equals("1") && buttons[1].getText().equals("2")
                && buttons[2].getText().equals("3") && buttons[3].getText().equals("4")
                && buttons[5].getText().equals("6") && buttons[6].getText().equals("7")
                && buttons[7].getText().equals("8") && buttons[8].getText().equals("9")){
            JOptionPane.showMessageDialog(this, "You Won!!!");

        }

        //if 4 is out
        if (buttons[0].getText().equals("1") && buttons[1].getText().equals("2")
                && buttons[2].getText().equals("3") && buttons[4].getText().equals("5")
                && buttons[5].getText().equals("6") && buttons[6].getText().equals("7")
                && buttons[7].getText().equals("8") && buttons[8].getText().equals("9")){
            JOptionPane.showMessageDialog(this, "You Won!!!");

        }

        //if 3 is out
        if (buttons[0].getText().equals("1") && buttons[1].getText().equals("2")
                && buttons[3].getText().equals("4") && buttons[4].getText().equals("5")
                && buttons[5].getText().equals("6") && buttons[6].getText().equals("7")
                && buttons[7].getText().equals("8") && buttons[8].getText().equals("9")){
            JOptionPane.showMessageDialog(this, "You Won!!!");

        }

        //if 2 is out
        if (buttons[0].getText().equals("1") && buttons[2].getText().equals("3")
                && buttons[3].getText().equals("4") && buttons[4].getText().equals("5")
                && buttons[5].getText().equals("6") && buttons[6].getText().equals("7")
                && buttons[7].getText().equals("8") && buttons[8].getText().equals("9")){
            JOptionPane.showMessageDialog(this, "You Won!!!");

        }

        //if 1 is out
        if (buttons[1].getText().equals("2") && buttons[2].getText().equals("3")
                && buttons[3].getText().equals("4") && buttons[4].getText().equals("5")
                && buttons[5].getText().equals("6") && buttons[6].getText().equals("7")
                && buttons[7].getText().equals("8") && buttons[8].getText().equals("9")){
            JOptionPane.showMessageDialog(this, "You Won!!!");

        }

    }

    public static void main(String[] args) {
        new puzzleGame();
    }

}