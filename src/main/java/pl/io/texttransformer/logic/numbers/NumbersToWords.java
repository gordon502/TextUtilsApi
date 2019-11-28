package pl.io.texttransformer.logic.numbers;

import pl.io.texttransformer.logic.Transformation;

public class NumbersToWords extends Transformation {

    private Transformation transformation;

    public NumbersToWords(Transformation transformation) {
        this.transformation = transformation;
    }

    @Override
    public String transform(String text){
        String[] splittedText = text.split(" ");

        for (int i = 0; i < splittedText.length; i++){
            String pom = "";
            String processedText = splittedText[i];
            if(processedText.length() > 0){
                if(isLastCharacterPoint(splittedText[i])){
                pom = splittedText[i].substring(splittedText[i].length() - 1);
                processedText = splittedText[i].substring(0, splittedText[i].length() - 1);
                }
            }
            if(isInteger(processedText)){
                splittedText[i] = singleNumberTransform(processedText) + pom;
            }
        }

        String joined = String.join(" ", splittedText);
        return transformation.transform(joined);
    }

    private String singleNumberTransform(String text){
        int number = Integer.valueOf(text);
        String[] onesArray = { "", "jeden ", "dwa ", "trzy ", "cztery ",
                "piec ", "szesc ", "siedem ", "osiem ", "dziewiec ", };

        String[] tensArray = { "", "jedenascie ", "dwanascie ", "trzynascie ",
                "czternascie ", "pietnascie ", "szesnascie ", "siedemnascie ",
                "osiemnascie ", "dziewietnascie ", };

        String[] fulltensArray = { "", "dziesiec ", "dwadziescia ",
                "trzydziesci ", "czterdziesci ", "piecdziesiąt ",
                "szescdziesiąt ", "siedemdziesiąt ", "osiemdziesiąt ",
                "dziewiecdziesiąt ", };

        String[] hundredsArray = { "", "sto ", "dwiescie ", "trzysta ", "czterysta ",
                "piecset ", "szescset ", "siedemset ", "osiemset ",
                "dziewiecset ", };

        String[][] groupsArray = { { "", "", "" },
                { "tysiąc ", "tysiące ", "tysiecy " },
                { "milion ", "miliony ", "milionów " },
                { "miliard ", "miliardy ", "miliardów " },
                { "bilion ", "biliony ", "bilionów " },
                { "biliard ", "biliardy ", "biliardów " },
                { "trylion ", "tryliony ", "trylionów " }, };


        long ones = 0/* jednosci */, tens = 0/* nastki */, fulltens = 0/* dziesiątki */, hundreds = 0/* setki */, groups = 0/* grupy */, ends = 0/* końcówwki */;
        String result = "";
        String sign = "";


        if (number < 0) {
            sign = "minus ";
            number = -number;
        }
        if (number == 0) {
            sign = "zero";
        }

        while (number != 0) {
            hundreds = number % 1000 / 100;
            fulltens = number % 100 / 10;
            ones = number % 10;

            if (fulltens == 1 & ones > 0) // if zajmujący sie nastkami
            {
                tens = ones;
                fulltens = 0;
                ones = 0;
            } else {
                tens = 0;
            }


            if (ones == 1 & hundreds + fulltens + tens == 0) {
                ends = 0;

                if (hundreds + fulltens == 0 && groups > 0)
                {
                    ones = 0;
                    result = groupsArray[(int) groups][(int) ends] + result;
                }
            } else if (ones == 2) {
                ends = 1;
            } else if (ones == 3) {
                ends = 1;
            } else if (ones == 4) {
                ends = 1;
            } else {
                ends = 2;
            }


            if (hundreds+fulltens+tens+ones > 0) {
                result = hundredsArray[(int) hundreds] + fulltensArray[(int) fulltens] + tensArray[(int) tens]
                        + onesArray[(int) ones] + groupsArray[(int) groups][(int) ends] + result;
            }

            number = number / 1000;
            groups = groups + 1;
        }

        result = sign + result;
        result = result.trim();
        return result;
    }


    private boolean isLastCharacterPoint(String text){
        String str = text.substring(text.length() - 1);
        if(str.equals(".") || str.equals(","))
            return true;
        else
            return false;
    }

    private boolean isInteger(String text){
        boolean numeric = true;
        try {
            Integer num = Integer.parseInt(text);
        } catch (NumberFormatException e) {
            numeric = false;
        }
        return  numeric;
    }
}
