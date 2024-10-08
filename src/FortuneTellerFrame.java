import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Random;

public class FortuneTellerFrame extends JFrame
{
    JPanel mainPnl, titlePnl, displayPnl, controlPnl;
    JButton getFortuneBtn, quitBtn;
    JLabel titleLbl;
    ImageIcon icon;
    JTextArea fortuneTA;
    JScrollPane scroller;
    Random gen = new Random();
    ArrayList<String> fortunes;


    public FortuneTellerFrame() throws HeadlessException
    {
        setTitle("Fortune Teller");
        setSize(625, 625);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mainPnl = new JPanel();
        mainPnl.setLayout(new BorderLayout());
        add(mainPnl, BorderLayout.NORTH);
        createTitlePanel();
        createDisplayPanel();
        createControlPanel();
        setVisible(true);
    }

    private void createTitlePanel()
    {
        titlePnl = new JPanel();
        titleLbl = new JLabel("Fortune teller!");
        icon = new ImageIcon("src//FortuneTeller.png");
        titleLbl = new JLabel("Fortune Teller", icon, JLabel.CENTER);
        titleLbl.setVerticalTextPosition(JLabel.BOTTOM);
        titleLbl.setHorizontalTextPosition(JLabel.CENTER);

        titlePnl.add(titleLbl);
        mainPnl.add(titlePnl, BorderLayout.NORTH);
    }
    private void createDisplayPanel()
    {
        displayPnl = new JPanel();
        fortuneTA = new JTextArea(10, 45);
        scroller = new JScrollPane(fortuneTA);
        displayPnl.add(scroller);
        mainPnl.add(displayPnl, BorderLayout.CENTER);
    }

    private void createControlPanel()
    {
        controlPnl = new JPanel();
        controlPnl.setLayout(new GridLayout(1, 2));
        getFortuneBtn = new JButton("Read my Fortune!");
        getFortuneBtn.addActionListener((ActionEvent ae) -> readFortune());
        quitBtn = new JButton("Quit");
        quitBtn.addActionListener((ActionEvent ae) -> System.exit(0));

        controlPnl.add(getFortuneBtn);
        controlPnl.add(quitBtn);

        mainPnl.add(controlPnl, BorderLayout.SOUTH);
    }

    {
        fortunes = new ArrayList<>();
        fortunes.add("You will learn to fly.");
        fortunes.add("You will be struck by lightning.");
        fortunes.add("You will win one million dollars.");
        fortunes.add("You will get hit by a train.");
        fortunes.add("You will spend 8 hours at the most boring opera.");
        fortunes.add("You will get an F on your next test");
        fortunes.add("You will become an astronaut at NASA.");
        fortunes.add("You will get robbed tonight");
        fortunes.add("I am in your walls.");
        fortunes.add("You will find a 100 dollar bill.");
        fortunes.add("You will get hit in the face with a soccer ball.");
        fortunes.add("A true evil has been unleashed.");
    }
    private void readFortune()
    {
        Random gen = new Random();
        int index;
        int lastIndex =1;
        do {
            index = gen.nextInt(fortunes.size());
        } while (index == lastIndex);
        lastIndex = index;
        String fortune = fortunes.get(index);
        fortuneTA.append(fortune + "\n");
    }
}