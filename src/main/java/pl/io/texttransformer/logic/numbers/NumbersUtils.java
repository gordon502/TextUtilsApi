package pl.io.texttransformer.logic.numbers;

import static pl.io.texttransformer.logic.numbers.WordsArrays.*;
import static pl.io.texttransformer.logic.numbers.WordsArrays.onesArray;


/**
 * Class with utility number methods.
 */
public class NumbersUtils {
    /**
     * Converts single number.
     * @param text - single number in String type without any non numeric characters
     * @return converted single number to word number
     */
    public String singleNumberTransform(String text){

        double number = Double.valueOf(text);
        int intNumber = (int) number;
        double copynumber = number * 100;
        int fractional = (int) copynumber;
        fractional = fractional % 100;


        long ones = 0/* jednosci */, tens = 0/* nastki */, fulltens = 0/* dziesiatki */, hundreds = 0/* setki */, groups = 0/* grupy */, ends = 0/* końcowwki */;
        String intResult = "";
        String sign = "";
        String fractResult = "";



        if (intNumber < 0) {
            sign = "minus ";
            intNumber = -intNumber;
        }
        if (intNumber == 0) {
            sign = "zero";
        }

        while (intNumber != 0) {
            hundreds = intNumber % 1000 / 100;
            fulltens = intNumber % 100 / 10;
            ones = intNumber % 10;

            if (fulltens == 1 & ones > 0){
                tens = ones;
                fulltens = 0;
                ones = 0;
            }
            else {
                tens = 0;
            }


            if (ones == 1 & hundreds + fulltens + tens == 0) {
                ends = 0;
                if (hundreds + fulltens == 0 && groups > 0) {
                    ones = 0;
                    intResult = groupsArray[(int) groups][(int) ends] + intResult;
                }
            }
            else if (ones == 2) { ends = 1; }
            else if (ones == 3) { ends = 1; }
            else if (ones == 4) { ends = 1; }
            else { ends = 2; }


            if (hundreds+fulltens+tens+ones > 0) {
                intResult = hundredsArray[(int) hundreds] + fulltensArray[(int) fulltens] + tensArray[(int) tens]
                        + onesArray[(int) ones] + groupsArray[(int) groups][(int) ends] + intResult;
            }

            intNumber = intNumber / 1000;
            groups = groups + 1;
        }

        if(fractional != 0) {
            fractResult = "i ";

            int pom = fractional;
            if (pom > 10 && pom < 19) {
                fractResult = fractResult + tensArray[pom % 10] + "setnych";
            }
            else if (pom % 10 == 0){
                if (pom / 10 == 1){ fractResult = fractResult + "jedna dziesiata"; }
                else if(pom / 10 == 2) {fractResult = fractResult + "dwie dziesiate"; }
                else if(pom / 10 > 4){ fractResult = fractResult + onesArray[pom/10] + "dziesiatych"; }
                else{ fractResult = fractResult + onesArray[pom/10] + "dziesiate"; }
            }
            else if (pom / 10 == 0){
                if(pom % 10 == 1) { fractResult = fractResult + "jedna setna"; }
                else if (pom % 10 == 2) { fractResult = fractResult + "dwie setne"; }
                else if (pom % 10 > 4) { fractResult = fractResult + onesArray[pom % 10] + "setnych"; }
                else { fractResult = fractResult + onesArray[pom % 10] + "setne"; }
            }
            else{
                fractResult = fractResult + fulltensArray[pom / 10];
                fractResult = fractResult + onesArray[pom % 10];
                fractResult = fractResult + "setnych";
            }
        }
        String result = sign + intResult;
        result = result + fractResult;
        result = result.trim();
        return result;
    }



}
