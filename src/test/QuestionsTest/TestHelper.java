package QuestionsTest;

public class TestHelper {

    // EFFECTS: Creates a fake user interaction.
    public static String createFakeUserInput(String... args) {
        String result = "";
        for (String save : args) {
            result += save + "\n";
        }
        return result;
    }
}
