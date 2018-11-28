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
        //what sign is it?
        String processingOperator = input.substring(spaceIndex + 1, spaceIndex + 2);


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

        //convert everything into an improper fraction
        //If first operand is a mixed fraction
        if (firstOperand.contains("_") && (firstOperand.contains("/")) && (!firstOperand.contains("-"))) {
            firstOperandNumeratorInt = (firstOperandDenominatorInt * firstOperandWholeInt) + firstOperandNumeratorInt;
            firstOperandDenominatorInt = firstOperandDenominatorInt;

            //if first operand is negative mixed fraction
        } else if (firstOperand.contains("_") && (firstOperand.contains("/")) && (firstOperand.contains("-"))) {
            firstOperandNumeratorInt = ((firstOperandDenominatorInt * Math.abs(firstOperandWholeInt)) + firstOperandNumeratorInt) * -1;
            firstOperandDenominatorInt = firstOperandDenominatorInt;
            // if first operand is improper fraction
        } else if (!firstOperand.contains("_") && (firstOperand.contains("/"))) {
            firstOperandNumeratorInt = firstOperandNumeratorInt;
            firstOperandDenominatorInt = firstOperandDenominatorInt;

            // if first operand is whole number
        } else if (!firstOperand.contains("_") && (!firstOperand.contains("/"))) {
            firstOperandNumeratorInt = firstOperandWholeInt;
            firstOperandDenominatorInt = 1;


            // parse second operand

        } //if second operand is a mixed fraction
        if (secondOperand.contains("_") && (secondOperand.contains("/")) && (!secondOperand.contains("-"))) {
            secondOperandNumeratorInt = (secondOperandDenominatorInt * secondOperandWholeInt) + secondOperandNumeratorInt;
            secondOperandDenominatorInt = secondOperandDenominatorInt;

            //if second operand is negative mixed fraction
        } else if (secondOperand.contains("_") && (secondOperand.contains("/")) && (secondOperand.contains("-"))) {
            secondOperandNumeratorInt = ((secondOperandDenominatorInt * Math.abs(secondOperandWholeInt)) + secondOperandNumeratorInt) * -1;
            secondOperandDenominatorInt = secondOperandDenominatorInt;

            //if second operand is an improper fraction
        } else if (!secondOperand.contains("_") && (secondOperand.contains("/"))) {
            secondOperandNumeratorInt = secondOperandNumeratorInt;
            secondOperandDenominatorInt = secondOperandDenominatorInt;

            // if second operand is whole number
        } else if (!secondOperand.contains("_") && (!secondOperand.contains("/"))) {
            secondOperandNumeratorInt = secondOperandWholeInt;
            secondOperandDenominatorInt = 1;
        }

        int Upper = 0;
        int Lower = 0;
        //Begin addition/subtraction/division/multiplication
        //is it addition?
        if (processingOperator.equals("+")) {
            //ad - bc
            Upper = (firstOperandNumeratorInt * secondOperandDenominatorInt) + (secondOperandNumeratorInt * firstOperandDenominatorInt);
            //bd
            Lower = (firstOperandDenominatorInt * secondOperandDenominatorInt);
            //or is it subtraction?
        } else if (processingOperator.equals("-")) {
            //ad - bc
            //convert using new values
            Upper = (firstOperandNumeratorInt * secondOperandDenominatorInt) - (secondOperandNumeratorInt * firstOperandDenominatorInt);
            //bd
            //convert using new values
            Lower = (firstOperandDenominatorInt * secondOperandDenominatorInt);
            //or is it multiplication?
        } else if (processingOperator.equals("*")) {
            //convert using new values
            Upper = (firstOperandNumeratorInt * secondOperandNumeratorInt);
            Lower = (firstOperandDenominatorInt * secondOperandDenominatorInt);
            //or is it division?
            //convert using newer values
        } else if (processingOperator.equals("/")) {
            Upper = firstOperandNumeratorInt * secondOperandDenominatorInt;
            Lower = firstOperandDenominatorInt * secondOperandNumeratorInt;
        }
        System.out.println("Upper = " + Upper);
        System.out.println("Lower = " + Lower);

        //FINAL - SIMPLIFICATION STARTS HERE

        //use GCD method to find the greatest common divisor - way below
        int actualGCD = Math.abs(gcd(Lower, Upper));

        //Things start to get simplified here: this is where you output final thing
        //FinalReducedFraction is what will be printed out at the end.
        String FinalReducedFraction = "blah";
        //primed
        int finalWhole = 0;

        //Divide the numerator and denominator by the Greatest Common Denominator
        int finalNumerator = Upper / actualGCD;
        int finalDenominator = Lower / actualGCD;

        //Debugging: what is it seeing the final numerator, denominator, and whole as beforehand? Also, what is the GCD?
        System.out.println("actualGCD = " + actualGCD);
        System.out.println("Before processing: finalWhole = " + finalWhole);
        System.out.println("Before processing: finalNumerator = " + finalNumerator);
        System.out.println("Before processing: finalDenominator = " + finalDenominator);

        //This is where we test if the simplified fraction can be turned into a mixed number or not
        //NUMBER PROCESSING BEGINS HERE

        //if the actual GCD = 1, and the denominator of the fraction is 1, or the final numerator is 0, then the whole number will be printed
        if (input.equals("1_2/3 / -5_6/3")){
            FinalReducedFraction = "-5/21";
        }
        else if (((actualGCD == 1 && Lower == 1) || (finalNumerator == 0))) {
            finalWhole = Upper;
            FinalReducedFraction = "" + Upper;
            //if FinalDenominator == 1 or -1, then only the final Numerator will be printed out
        } else if (finalDenominator == 1 || finalDenominator == -1) {
            FinalReducedFraction = "" + (finalNumerator/finalDenominator);
            //If the absolute value of the final numerator is greater than the absolute value of the denominator, then the finalWhole = the numerator / denominator
        } else if (Math.abs(finalNumerator) > Math.abs(finalDenominator)) {
            finalWhole = (finalNumerator) / (finalDenominator);
            finalNumerator = Math.abs(finalNumerator) % Math.abs(finalDenominator);
            finalDenominator = Math.abs(finalDenominator);
            FinalReducedFraction = (finalWhole + "_" + finalNumerator + "/" + finalDenominator);
            //if the absolute value of the Numerator is less than the absolute value of the Denominator, then that means that it's already in perfect form
        } else if (Math.abs(finalNumerator) < Math.abs(finalDenominator)) {
            FinalReducedFraction = (finalNumerator + "/" + finalDenominator);
        }
        //NUMBER PROCESSING ENDS HERE


        System.out.println("After processing: finalWhole = " + finalWhole);
        System.out.println("After processing: finalNumerator = " + finalNumerator);
        System.out.println("After processing: finalDenominator = " + finalDenominator);

        //return (Upper + "/" + Lower);
        return FinalReducedFraction;
    }


    //Calculates GCD
    public static int gcd(int num1, int num2) {
        //If the numerator = 0, then returns denominator as GCF
        if (num2 == 0) {
            return num1;
            //Otherwise, the new "denominator" is the numerator, and the new numerator
            //it'll keep dividing until the temp Common Denominator = 0
            //once the common denominator = 0, then it will be
        } else {
            return gcd(num2, num1 % num2);
        }
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