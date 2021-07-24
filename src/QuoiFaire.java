import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QuoiFaire {
    private JTextArea resText;
    private JTextField champsTexteTemps;
    private JLabel labelTemps;

    public QuoiFaire() {
        calculerBouton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // lancer (et afficher) le calcul
                resText.setText("test1\n\nvoir\n\nDeux.");
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("QuoiFaire");
        frame.setContentPane(new QuoiFaire().panRacine);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    private JPanel panRacine;
    private JTextField champsTexteDefoulement;
    private JLabel labelDefoulement;
    private JTextField champsTexteMental;
    private JLabel labelMental;
    private JTextField champsTextePhysique;
    private JLabel labelPhysique;
    private JTextField champsTexteRelaxationtField1;
    private JLabel labelRelaxation;
    private JButton calculerBouton;

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
