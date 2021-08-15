package ui.handlers;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HelpPopUpHandler implements ActionListener {
    JFrame popup = new JFrame("GUI implementation took a lot longer than I expected :(");

    public void actionPerformed(ActionEvent e) {
        popup.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        popup.setSize(1500,800);
        popup.add(new JLabel(new ImageIcon("./data/tobs.jpg")));
        popup.setVisible(true);
    }
}
