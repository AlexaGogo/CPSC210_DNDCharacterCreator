# CPSC 210: Personal Project
## DnD Character Creator

Character creation in *Dungeons and Dragons 5e* can be a long and intricate process. The 293 page Player's Handbook, 
with pages crammed full of choices, game mechanics and background knowledge, is an intimidating resource for new 
players, and the countless guides and character sheet creators found online only seem to overwhelm or stifle their 
creativity further. My goal with this project is to create a character generator that guides players through the process
 and reduces the steep learning curve, similar to how a more experienced player would help a beginner or approach it
themselves. I want to make the game more accessible, much like how my friend introduced it to me. I'd also like to
streamline the process overall and eliminate the need to flip through multiple chapters to compare the hundreds of 
different options available, which in itself can take hours even for those who have done it before. Most, if not all,
descriptive text will be taken from the DND 5e Player's Handbook.

---

#### User Stories

- *As a user, I want to be able to create a new character*
- *As a user, I want to be able to view my character's information*
- *As a user, I want to be able to read more about unfamiliar character creation options presented to me*
- *As a user, I want to be able to add a race to my character sheet*
- *As a user, I want to be able to save a character I've created*
- *As a user, I want to be able to revisit characters I've created and look at their sheets*

---

#### Instructions for Grader (Phase 3)
- You can generate the first required event by pressing the "New Character" button and following the prompts
- You can generate the second required event by pressing the "View Sheets" button and deleting a character
- You can locate my visual component by pressing the help button during the "New Character" sequence
- You can save the state of my application by saving the character created during the "New Character" sequence
- The application automatically loads all created characters on startup

---

#### Phase 4
##### Task 2
**Type Hierarchy:** The classes Dwarf, Elf, and Human all implement the interface Race (Race is converted to an abstract 
class in the following task). All subclasses override the battleCry method to return different Strings based on race.
In later improvements, each subclass will handle ability modifiers and stat bonuses differently.  

##### Task 3
**Problem 1:** \
Creating Race as an Interface led to unnecessary coupling between all of the classes that inherit it. 
Furthermore, the risk of this coupling is **high**, because if we were to change the implementation of any shared 
methods in one subclass, we would have to change it for every subclass individually to keep the formatting and 
functionality the same, and a missed implementation wouldn't be caught until runtime (and even then, it would only 
occur if the specific race is chosen). 

**Solution:** \
I've converted Race into an abstract class to remove all duplication. Now every unique method implementation within the 
Race tree only appears once, and any future edits and additions will either only have to occur once, or will have all 
other necessary changes highlighted by IntelliJ. 

**Problem 2:** 

I've been using a generic ArrayList to store all the created characters instead of creating a specific class for it. 
This is problematic, because if I ever want to add functionality that specifically applies to a list of characters, I 
would have to design a method within my GUI class. This defies the Single Responsibility Principle and reduces the 
cohesiveness of my code. 

**Solution:** \
Creating a separate CharacterList class will keep all CharacterList functionality in one specified place, and will 
improve overall cohesion. 

##### Task 4
Image of UML diagram is in root folder
