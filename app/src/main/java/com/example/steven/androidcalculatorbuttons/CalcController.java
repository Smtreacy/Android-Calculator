package com.example.steven.androidcalculatorbuttons;

/**
 * Created by steven on 9/20/2016.
 */
public class CalcController {
    public static String _equation = "";

    public static String[] operations = { "+", "-", "/", "*"};

    public static void insert(String input) {
        _equation += input;
    }

    public static double calculate() {
        String first = null;
        String third = null;
        String second = null;
        String fourth = null;
        String sign = null;

        Integer firstnum = null;
        Integer secondnum = null;
        Integer placement = null;

        for (int i = 0; i < _equation.length(); i ++) {
            char currentCharacter = _equation.charAt(i);
            if (currentCharacter != '+' &&
                    currentCharacter != '-' &&
                    currentCharacter != '/' &&
                    currentCharacter != '*') {

                if(first == null) {
                    first = (Character.toString(currentCharacter));
                    //We assign the firstNum Integer here to allow single digit operations
                    firstnum = Integer.parseInt(first);

                }

                else if (second == null) {
                    second = (Character.toString(currentCharacter));
                    //we assign the secondnum Integer here to allow single digit operation
                    secondnum = Integer.parseInt(second);
                }

                else if (third == null && placement == 1){
                    //we assign the third value to a string, to allow for double digit operations
                    third = (Character.toString(currentCharacter));
                    //Since the code reaches this far we know we are doing at least a double digit
                    //and single digit operation
                    //we combine the first two strings to give us a double digit

                    String combine1 = second + third;
                    //we combine the two values to get the double digit
                    firstnum = Integer.parseInt(first);
                    //we use our third digit as the other addition.
                    secondnum = Integer.parseInt(combine1);
                }

                else if (third == null && placement == 2){
                    //we assign the third value to a string, to allow for double digit operations
                    third = (Character.toString(currentCharacter));
                    //Since the code reaches this far we know we are doing at least a double digit
                    //and single digit operation
                    //we combine the first two strings to give us a double digit

                    String combine = first + second;
                    //we combine the two values to get the double digit
                    firstnum = Integer.parseInt(combine);
                    //we use our third digit as the other addition.
                    secondnum = Integer.parseInt(third);
                }


                else  if (fourth == null) {
                    //Since the code reaches this far we know we are doing at least a double digit
                    //operation so we combine the two that we stored to make them a double digit
                    String combine = first + second;
                    //We assign the fourth value to a string, to allow for double digit operations
                    fourth = (Character.toString(currentCharacter));
                    //Since the code reaches this far we know we are doing at least a double digit
                    //operation so we combine 3 and 4 to make them a double digit string
                    String combine2 = third + fourth;
                    secondnum = Integer.parseInt(combine2);
                    firstnum = Integer.parseInt(combine);



                }

            }
            else {
                sign = Character.toString(currentCharacter);
                placement = i;

            }
        }

        // Apply the math
        double answer = 0;
        switch(sign) {
            case "+":
                answer = firstnum + secondnum;
                break;
            case "-":
                answer = firstnum - secondnum;
                break;
            case "*":
                answer = firstnum * secondnum;
                break;

            case "/":
                answer = firstnum * secondnum;
                break;
        }

        return answer;
    }
}
