package ui.handlers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static ui.CharacterCreatorGUI.*;

public class NavigationButtonHandler implements ActionListener {

    // EFFECTS: displays correct screen based on button selected
    public void actionPerformed(ActionEvent e) {
        String yourChoice = e.getActionCommand();

        switch (yourChoice) {
            case "start" :
                toggleMenuScreen(false);
                toggleCharacterCreatorScreen(true);
                break;
            case "view" :
                toggleMenuScreen(false);
                toggleViewSheetsSceen(true);
                break;
            case "back" :
                toggleViewSheetsSceen(false);
                toggleMenuScreen(true);
        }
    }
}
