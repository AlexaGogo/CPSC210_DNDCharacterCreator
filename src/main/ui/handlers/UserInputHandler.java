package ui.handlers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Character;
import static ui.CharacterCreatorGUI.*;

public class UserInputHandler implements ActionListener {
    // this is a test !!!
    // still a test !!!

    // MODIFIES: CharacterCreatorGUI.character
    // EFFECTS: assigns user input to correct Character fields
    public void actionPerformed(ActionEvent e) {
        String field = e.getActionCommand();

        switch (field) {
            case "username" :
                character = new Character(userInput.getText());
                chooseRace();
        }

    }
}
