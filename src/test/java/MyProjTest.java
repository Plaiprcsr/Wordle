import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;


import static org.junit.jupiter.api.Assertions.*;

class MyProjTest {
    private String chosenWordWithoutAccents = "apple";
    private String chosenWord = "apple";

    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    void setUp() {

    }
    @Test
    void testPrintInstructions() {
        // Setup variables
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        //Setup game
        English game = new English();
        game.printInstructions();

        //Assert
        String printedMessage = outputStream.toString();
        assertTrue(printedMessage.contains("The game has chosen a 5-letter word for you to guess."));
        assertTrue(printedMessage.contains("You have 6 tries. In each guess, the game will confirm which letters the chosen word and the guessed word have in common:"));
        assertTrue(printedMessage.contains("green"));
        assertTrue(printedMessage.contains("yellow"));
        assertTrue(printedMessage.contains("grey"));


    }
    @Test
    void testObtainValidUserWord() {
        English game = new English();

        // Mock wordlist
        List<String> wordList = new ArrayList<>();
        wordList.add("apple");
        wordList.add("grape");
        wordList.add("testt");


        // Mock user input
        ByteArrayInputStream input1 = new ByteArrayInputStream("grape".getBytes());
        System.setIn(input1);

        //Assert
        String userWord = game.obtainValidUserWord(wordList, 0);
        assertEquals("grape", userWord);


    }

    @Test
    void testPrintDefinitionLink() {
        // Setup variables
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        English game = new English();
        game.printDefinitionLink("apple");

        String printedMessage = outputStream.toString();
        assertTrue(printedMessage.contains("The word's definition: https://www.merriam-webster.com/dictionary/apple"));

        System.setOut(System.out);
    }

    @Test
    void testReplaceChar() {
        English game = new English();

        String originalStr = "apple";
        String modifiedStr = game.replaceChar(originalStr, 'x', 2);
        assertEquals("apxle", modifiedStr);
    }

    @Test
    void testGetRandomWord() {
        English game = new English();

        List<String> wordList = new ArrayList<>();
        wordList.add("apple");
        wordList.add("which");
        wordList.add("green");

        String randomWord = game.getRandomWord(wordList);

        assertTrue(wordList.contains(randomWord));
    }
    @Test
    void testPrintFirstWordRequest() {
        English game = new English();

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        //Setup game

        game.askForFirstGuess();

        //Assert
        String printedMessage = outputStream.toString();
        assertTrue(printedMessage.contains("Please write down your first guess:"));

    }

    @Test
    public void testReadDictionary() {
        English game = new English();
        List<String> dictionary = game.readDictionary("dictionary.txt");
        assertEquals(2519, dictionary.size()); // Replace with the actual dictionary size
    }













}