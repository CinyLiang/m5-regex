package regex;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    /**
     * The Main method for this assignment.
     * You can optionally run this to interactively try the three methods.
     * @param args parameters are unused
     */
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter a string: ");
        final String userInput = scanner.nextLine();
        scanner.close();
        System.out.println("You entered \"" + userInput + "\"");
        System.out.println(checkForPassword(userInput, 6));
        System.out.println(extractEmails(userInput));
        System.out.println(checkForDoubles(userInput));
    }

    // Method 1 for checking if a string matches a regex: using Pattern.matches

    /**
     * Returns whether a given string is non-empty, contains one lower case letter,
     * at least one upper case letter, at least one digit, and meets the minimum length.
     * @param str the string to check for the properties in
     * @param minLength the minimum length required for the password
     * @return whether the string satisfies the password requirements
     */
    public static boolean checkForPassword(String str, int minLength) {
        if ((str != null) && !(str.length() < minLength)) {
            final Pattern pattern = Pattern.compile("[A-Z]");
            final boolean propertyOne = pattern.matcher(str).find();
            final Pattern pattern2 = Pattern.compile("[a-z]");
            final boolean propertyTwo = pattern2.matcher(str).find();
            final Pattern pattern3 = Pattern.compile("[0-9]");
            final boolean propertyThree = pattern3.matcher(str).find();
            return (propertyOne && propertyTwo && propertyThree);
        }
        return false;
    }


    /**
     * Returns a list of email addresses that occur in a given string.
     * @param str the string to look for email addresses in
     * @return a list containing the email addresses in the string.
     */
    public static List<String> extractEmails(String str) {
        final List<String> result = new ArrayList<>();
        if (str == null) {
            return result;
        }
        final Pattern pattern = Pattern.compile("\\w*@mail\\.utoronto\\.ca|\\w*@utoronto\\.ca");
        final Matcher matcher = pattern.matcher(str);
        while (matcher.find()) {
            result.add(matcher.group());
        }
        return result;
    }

    // Method 3 for checking if a string conforms to a regex: using String.matches


    /**
     * Checks whether a given string contains the same capital letter twice.
     * @param str the string to look for doubles in
     * @return whether str contains the same capital letter twice.
     */
    public static boolean checkForDoubles(String str) {
        if (str == null) {
            return false;
        }
        final Pattern pattern = Pattern.compile("(.*([A-Z]).*)\\2.*");
        final Matcher matcher = pattern.matcher(str);
        return matcher.find();
    }
}
