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

    @Test
    public void testPrintWinningMessage() {
        English game = new English();
        String userWord = "apple";
        String chosenWord = "apple";

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        game.printWinningMessage(userWord,chosenWord,game.youWonMessage);

        System.setOut(System.out);

        assertEquals("apple",userWord);
        assertEquals("CONGRATULATIONS! YOU WON! :)",game.youWonMessage);

        String expectedOutput = "Result: " + game.ANSI_GREEN_BACKGROUND + userWord.toUpperCase() + game.ANSI_RESET + "\n\n" + game.youWonMessage + "\n\n"+
        "The word's definition: https://www.merriam-webster.com/dictionary/" + chosenWord + "\n";
        assertEquals(expectedOutput, outContent.toString().replace("\r\n", "\n"));
    }

    @Test
    public void testPrintLosingMessage() {
        English game = new English();

        String chosenWord = "apple";

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        game.printLosingMessage(chosenWord,game.youLostMessage);

        System.setOut(System.out);

        assertEquals("YOU LOST :( THE WORD CHOSEN BY THE GAME IS: ",game.youLostMessage);

        String expectedOutput = "\n" + game.youLostMessage + chosenWord.toUpperCase() + ".\n\n" +
                "The word's definition: https://www.merriam-webster.com/dictionary/" + chosenWord + "\n";
        assertEquals(expectedOutput, outContent.toString().replace("\r\n", "\n"));
    }

    @Test
    public void testPrintingColouredAlphabet() {
        English game = new English();

        List<Character> greenLetters = new ArrayList<>();
        List<Character> yellowLetters = new ArrayList<>();
        List<Character> greyLetters = new ArrayList<>();
        String userWord = "apple";
        greenLetters.add(userWord.toUpperCase().charAt(0));
        yellowLetters.add(userWord.toUpperCase().charAt(1));
        greyLetters.add(userWord.toUpperCase().charAt(3));

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        game.printingColouredAlphabet(greenLetters, yellowLetters, greyLetters);

        System.setOut(System.out);

        // Normalize line separators to LF
        String expectedOutput = game.ANSI_GREEN_BACKGROUND + "A" + game.ANSI_RESET + " B C D E F G H I J K " +game.ANSI_GREY_BACKGROUND + "L" + game.ANSI_RESET + " M N O " +game.ANSI_YELLOW_BACKGROUND +"P" + game.ANSI_RESET + " Q R S T U V W X Y Z ";
        assertEquals(expectedOutput, outContent.toString().replace("\r\n", "\n"));
    }













}