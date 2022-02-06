import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.util.ArrayList;

public class QuoiFaire {
    private JTextArea resText;
    private JTextField champsTexteTemps;
    private JLabel labelTemps;
    public static int INVALIDE = 9999;

    ArrayList<Activite> activites_ = new ArrayList<>();

    public QuoiFaire() {
        calculerBouton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // lancer (et afficher) le calcul
                String res = Calculer();
                resText.setText(res);
            }
        });

        LireXml();
    }

    private String Calculer() {
        int defoulement = Integer.parseInt(champsTexteDefoulement.getText());
        int constructif = Integer.parseInt(champsTexteConstructif.getText());
        int mental = Integer.parseInt(champsTexteMental.getText());
        int physique = Integer.parseInt(champsTextePhysique.getText());
        int relaxation = Integer.parseInt(champsTexteRelaxationtField1.getText());
        int temps = Integer.parseInt(champsTexteTemps.getText());

        for (Activite act:activites_
             ) {
            act.CalculerScore(temps, constructif, physique, mental, defoulement, relaxation);
        }

        activites_.sort(( obj1, obj2) -> obj1.compare(obj1, obj2));

        String res = "";
        for (Activite act:activites_ ) {
            if (act.score_ == INVALIDE)
                res = res + " x INVALIDE x " + act.nom_ + " : " + act.score_ + "\n";
            else
                res = res + act.nom_ + " : " + act.score_ + "\n";
        }

        return res;
    }

    private void LireXml() {
        try
        {
            //creating a constructor of file class and parsing an XML file
            File file = new File("D:\\boulot\\java\\QuoiFaire\\out\\production\\QuoiFaire\\Activites.xml");
            //an instance of factory that gives a document builder
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            //an instance of builder to parse the specified xml file
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(file);
            doc.getDocumentElement().normalize();
            NodeList nodeList = doc.getElementsByTagName("Activite");
            // nodeList is not iterable, so we are using for loop
            for (int itr = 0; itr < nodeList.getLength(); itr++)
            {
                Node node = nodeList.item(itr);
                if (node.getNodeType() == Node.ELEMENT_NODE)
                {
                    Element eElement = (Element) node;

                    activites_.add(new Activite(
                            eElement.getAttribute("nom"),
                            Integer.parseInt(eElement.getAttribute("duree_min")),
                            Integer.parseInt(eElement.getAttribute("duree_max")),
                            Integer.parseInt(eElement.getAttribute("constructif")),
                            Integer.parseInt(eElement.getAttribute("energie_physique")),
                            Integer.parseInt(eElement.getAttribute("energie_mentale")),
                            Integer.parseInt(eElement.getAttribute("defoulement")),
                            Integer.parseInt(eElement.getAttribute("relaxation"))
                    ));
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
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
    private JTextField champsTexteConstructif;
    private JLabel labelConstructif;

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
