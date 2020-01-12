package pl.io.texttransformer.logic.numbers;

import pl.io.texttransformer.logic.Transformation;

import static pl.io.texttransformer.logic.numbers.WordsArrays.*;

/**
 * Replace numbers in given sentence to word numbers in polish language.
 * Class supports conversion to two decimal places for float numbers.
 */
public class NumbersToWords extends Transformation {

    private Transformation transformation;
    private NumbersUtils numbersUtils;

    /**
     * Class constructor.
     * @param transformation
     */
    public NumbersToWords(Transformation transformation) {
        this.transformation = transformation;
        this.numbersUtils = new NumbersUtils();
    }

    public NumbersToWords(Transformation transformation, NumbersUtils numbersUtils) {
        this.transformation = transformation;
        this.numbersUtils = numbersUtils;
    }


    /**
     * Main method providing conversion.
     * @param text to convert
     * @return converted text with replaced numbers to word numbers
     */
    @Override
    public String transform(String text){
        String[] splittedText = text.split(" ");

        for (int i = 0; i < splittedText.length; i++){
            String pom = "";
            String processedText = splittedText[i];
            if(processedText.length() > 0){
                while(isLastCharacterNonAlphaNumeric(processedText)){
                    pom = processedText.substring(processedText.length() - 1) + pom;
                    processedText = processedText.substring(0, processedText.length() - 1);
                }
            }
            processedText = processedText.replace(",", ".");
            if(isNumber(processedText)){
                splittedText[i] = numbersUtils.singleNumberTransform(processedText) + pom;
            }
        }

        String joined = String.join(" ", splittedText);
        return transformation.transform(joined);
    }



    /**
     * Check if is given string a number.
     * @param text
     * @return true or false
     */
    private boolean isNumber(String text){
        boolean numeric = true;
        try {
            Double num = Double.parseDouble(text);
        } catch (NumberFormatException e) {
            numeric = false;
        }
        return  numeric;
    }

    /**
     * Check if last character in given word is special sign.
     * @param text
     * @return true or false
     */
    public static boolean isLastCharacterNonAlphaNumeric(String text){
        char c = text.charAt(text.length()-1);
        if (!Character.isDigit(c) && !Character.isLetter(c))
            return true;
        else
            return false;
    }
}
