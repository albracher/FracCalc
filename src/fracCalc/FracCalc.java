//Allen Phu P1, Fraction calculator, checkpoint #2 as of 11/17/18
package fracCalc;

import java.util.Scanner;

public class FracCalc {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        System.out.println("What is your equation?");
        String input = console.nextLine();
        while (!input.equals("quit")) {
            // System.out.println("Your equation is:" + input);
            System.out.println(produceAnswer(input));
            System.out.println("What is your next equation?");
            input = console.nextLine();
        }
    }

    /*
     * { // TODO: Read the input from the user and call produceAnswer with an
     * equation
     *
     * }
     */

    // ** IMPORTANT ** DO NOT DELETE THIS FUNCTION. This function will be used to
    // test your code
    // This function takes a String 'input' and produces the result
    //
    // input is a fraction string that needs to be evaluated. For your program, this
    // will be the user input.
    // e.g. input ==> "1/2 + 3/4"
    //
    // The function should return the result of the fraction after it has been
    // calculated
    // e.g. return ==> "1_1/4"

    //
    /*
     * public static void main(String[] args) { String test = "42"; int foundIt =
     * Integer.parseInt(test); System.out.println("foundIt = " + foundIt); } }
     */

    // use the space instead of the Operand

    public static String produceAnswer(String input) {
        int spaceIndex = input.indexOf(" ");
        // where is the first space? due to the nature of the problem, we only really
        // need to know where the first space is
        String firstOperand = input.substring(0, spaceIndex);
        // we want to use this for later, so keep it as it's own thing
        // System.out.println("firstOperand = " + firstOperand);
        String secondOperand = input.substring(spaceIndex + 3);
        // the second operand will always be 3 spaces after the first space to the end
        // of the String
        // same idea


        //Indexes of Underscore, Slash for firstOperand
        int indexOfUnderscore = firstOperand.indexOf("_");
        int indexOfSlash = firstOperand.indexOf("/");

        // prime the whole, numerator, and denominator
        String firstOperandWhole = "0";
        String firstOperandNumerator = "0";
        String firstOperandDenominator = "1";

        //If first operand is a mixed number
        if (firstOperand.contains("_") && (firstOperand.contains("/"))) {
            firstOperandWhole = firstOperand.substring(0, indexOfUnderscore);
            firstOperandNumerator = firstOperand.substring(indexOfUnderscore + 1, indexOfSlash);
            firstOperandDenominator = firstOperand.substring(indexOfSlash + 1);

            // if first operand is improper fraction
        } else if (!firstOperand.contains("_") && (firstOperand.contains("/"))) {
            firstOperandNumerator = firstOperand.substring(0, indexOfSlash);
            firstOperandDenominator = firstOperand.substring(indexOfSlash + 1);

            // if first operand is whole number
        } else if (!firstOperand.contains("_") && (!firstOperand.contains("/"))) {
            firstOperandWhole = firstOperand;
        }


        //indexes of Underscore and Slash for secondOperand
        int indexOfUnderscoreSec = secondOperand.indexOf("_");
        int indexOfSlashSec = secondOperand.indexOf("/");
        String secondOperandWhole = "0";
        String secondOperandNumerator = "0";
        String secondOperandDenominator = "1";

        // If the second operand is a Mixed Number
        if (secondOperand.contains("_") && (secondOperand.contains("/"))) {
            secondOperandWhole = secondOperand.substring(0, indexOfUnderscoreSec);
            secondOperandNumerator = secondOperand.substring(indexOfUnderscoreSec + 1, indexOfSlashSec);
            secondOperandDenominator = secondOperand.substring(indexOfSlashSec + 1);

            // if second operand is fraction
        } else if (!secondOperand.contains("_") && (secondOperand.contains("/"))) {
            secondOperandNumerator = secondOperand.substring(0, indexOfSlashSec);
            secondOperandDenominator = secondOperand.substring(indexOfSlashSec + 1);

            // if second operand is whole number
        } else if (!secondOperand.contains("_") && (!secondOperand.contains("/"))) {
            secondOperandWhole = secondOperand;
        }

        //parse all the previous Strings into Integers
        int firstOperandWholeInt = Integer.parseInt(firstOperandWhole);
        int firstOperandNumeratorInt = Integer.parseInt(firstOperandNumerator); //a
        int firstOperandDenominatorInt = Integer.parseInt(firstOperandDenominator); //b
        int secondOperandWholeInt = Integer.parseInt(secondOperandWhole);
        int secondOperandNumeratorInt = Integer.parseInt(secondOperandNumerator); //c
        int secondOperandDenominatorInt = Integer.parseInt(secondOperandDenominator); //d

        System.out.println("Before converting: firstOperandWholeInt = " + firstOperandWholeInt);
        System.out.println("Before converting: firstOperandNumeratorInt = " + firstOperandNumeratorInt);
        System.out.println("Before converting: firstOperandDenominatorInt = " + firstOperandDenominatorInt);
        System.out.println("Before converting: secondOperandWholeInt = " + secondOperandWholeInt);
        System.out.println("Before converting: secondOperandNumeratorInt = " + secondOperandNumeratorInt);
        System.out.println("Before converting: secondOperandDenominatorInt = " + secondOperandDenominatorInt);


        //convert everything into an improper fraction
        //If first operand is a mixed fraction
        if (firstOperand.contains("_") && (firstOperand.contains("/"))) {
            firstOperandNumeratorInt = (firstOperandDenominatorInt * firstOperandWholeInt) + firstOperandNumeratorInt;
            firstOperandDenominatorInt = firstOperandDenominatorInt;

            // if first operand is improper fraction
        } else if (!firstOperand.contains("_") && (firstOperand.contains("/"))) {
            firstOperandNumeratorInt = firstOperandNumeratorInt;
            firstOperandDenominatorInt = firstOperandDenominatorInt;

            // if first operand is whole number
        } else if (!firstOperand.contains("_") && (!firstOperand.contains("/"))) {
            firstOperandNumeratorInt = firstOperandWholeInt;
            firstOperandDenominatorInt = 1;

        } //if second operand is a mixed fraction
        if (secondOperand.contains("_") && (secondOperand.contains("/"))) {
            secondOperandNumeratorInt = (secondOperandDenominatorInt * secondOperandWholeInt) + secondOperandNumeratorInt;
            secondOperandDenominatorInt = secondOperandDenominatorInt;

            // if second operand is an improper fraction
        } else if (!secondOperand.contains("_") && (secondOperand.contains("/"))) {
            secondOperandNumeratorInt = secondOperandNumeratorInt;
            secondOperandDenominatorInt = secondOperandDenominatorInt;

            // if second operand is whole number
        } else if (!secondOperand.contains("_") && (!secondOperand.contains("/"))) {
            secondOperandNumeratorInt = secondOperandWholeInt;
            secondOperandDenominatorInt = 1;
        }

        System.out.println("firstOperandWholeInt = " + firstOperandWholeInt);
        System.out.println("firstOperandNumeratorInt = " + firstOperandNumeratorInt);
        System.out.println("firstOperandDenominatorInt = " + firstOperandDenominatorInt);
        System.out.println("secondOperandWholeInt = " + secondOperandWholeInt);
        System.out.println("secondOperandNumeratorInt = " + secondOperandNumeratorInt);
        System.out.println("secondOperandDenominatorInt = " + secondOperandDenominatorInt);

        int Upper = 0;
        int Lower = 0;
        //Begin addition/subtraction/division/multiplication
        //is it addition?
        if (input.contains("+")) {
            //ad - bc
            Upper = (firstOperandNumeratorInt * secondOperandDenominatorInt) + (secondOperandNumeratorInt * firstOperandDenominatorInt);
            //bd
            Lower = (firstOperandDenominatorInt * secondOperandDenominatorInt);
            //or is it subtraction?
        } else if (input.contains("-")) {
            //ad - bc
            //convert using new values
            Upper = (firstOperandNumeratorInt * secondOperandDenominatorInt) - (secondOperandNumeratorInt * firstOperandDenominatorInt);
            //bd
            //convert using new values
            Lower = (firstOperandDenominatorInt * secondOperandDenominatorInt);
            //or is it multiplication?
        } else if (input.contains("*")) {
            //convert using new values
            Upper = (firstOperandNumeratorInt * secondOperandNumeratorInt);
            Lower = (firstOperandDenominatorInt * secondOperandDenominatorInt);
            //or is it division?
            //convert using newer values
        } else {
            Upper = firstOperandNumeratorInt * secondOperandDenominatorInt;
            Lower = firstOperandDenominatorInt * secondOperandNumeratorInt;
        }
        System.out.println("Upper = " + Upper);
        System.out.println("Lower = " + Lower);


        // return whatever the result is by the end
        String firstOperandString = "First operand will be: " + "whole:" + firstOperandWhole + " numerator:" + firstOperandNumerator + " denominator:"
                + firstOperandDenominator;
        String secondOperandString = "Second operand will be: " + "whole:" + secondOperandWhole + " numerator:" + secondOperandNumerator + " denominator:"
                + secondOperandDenominator;

        return (Upper + "/" + Lower);

    }

}

//i don't know what this does, neither does it make the program run. we can uncomment it later
/*
 * { // TODO: Implement this function to produce the solution to the input
 *
 * // return ""; }
 *
 * // TODO: Fill in the space below with any helper methods that you think you
 * will need
 *
 * }
 */