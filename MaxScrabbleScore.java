import java.util.Scanner;
import java.util.ArrayList;


public class MaxScrabbleScore extends TextFileAccessor {
    ArrayList<String>Line = new ArrayList<>();
    ArrayList<Integer>Score = new ArrayList<>();
    Scanner scan;

    public void processFile() {
        while (scan.hasNext()) {
            int MaxScore = 0;
            String MaxLine = "";
            int CurrentScore = 0;
            int LetterScore = 0;
            String CurrentLine = scan.nextLine();
            CurrentLine = CurrentLine.toLowerCase();
            for (int i = 0; i < CurrentLine.length(); i++) {
                if (Character.isLetter(CurrentLine.charAt(i))) {
                    if (CurrentLine.charAt(i) == 'a') {
                        LetterScore = 1;
                    }
                    if (CurrentLine.charAt(i) == 'b') {
                        LetterScore = 3;
                    }
                    if (CurrentLine.charAt(i) == 'c') {
                        LetterScore = 3;
                    }
                    if (CurrentLine.charAt(i) == 'd') {
                        LetterScore = 2;
                    }
                    if (CurrentLine.charAt(i) == 'e') {
                        LetterScore = 1;
                    }
                    if (CurrentLine.charAt(i) == 'f') {
                        LetterScore = 4;
                    }
                    if (CurrentLine.charAt(i) == 'g') {
                        LetterScore = 2;
                    }
                    if (CurrentLine.charAt(i) == 'h') {
                        LetterScore = 4;
                    }
                    if (CurrentLine.charAt(i) == 'i') {
                        LetterScore = 1;
                    }
                    if (CurrentLine.charAt(i) == 'j') {
                        LetterScore = 8;
                    }
                    if (CurrentLine.charAt(i) == 'k') {
                        LetterScore = 5;
                    }
                    if (CurrentLine.charAt(i) == 'l') {
                        LetterScore = 1;
                    }
                    if (CurrentLine.charAt(i) == 'm') {
                        LetterScore = 3;
                    }
                    if (CurrentLine.charAt(i) == 'n') {
                        LetterScore = 1;
                    }
                    if (CurrentLine.charAt(i) == 'o') {
                        LetterScore = 1;
                    }
                    if (CurrentLine.charAt(i) == 'p') {
                        LetterScore = 3;
                    }
                    if (CurrentLine.charAt(i) == 'q') {
                        LetterScore = 10;
                    }
                    if (CurrentLine.charAt(i) == 'r') {
                        LetterScore = 1;
                    }
                    if (CurrentLine.charAt(i) == 's') {
                        LetterScore = 1;
                    }
                    if (CurrentLine.charAt(i) == 't') {
                        LetterScore = 1;
                    }
                    if (CurrentLine.charAt(i) == 'u') {
                        LetterScore = 1;
                    }
                    if (CurrentLine.charAt(i) == 'v') {
                        LetterScore = 4;
                    }
                    if (CurrentLine.charAt(i) == 'w') {
                        LetterScore = 4;
                    }
                    if (CurrentLine.charAt(i) == 'x') {
                        LetterScore = 8;
                    }
                    if (CurrentLine.charAt(i) == 'y') {
                        LetterScore = 4;
                    }
                    if (CurrentLine.charAt(i) == 'z') {
                        LetterScore = 10;
                    }
                    if ((i + 1) % 4 == 0) {
                        LetterScore = 2 * LetterScore;
                    }
                    else if ((i+1) % 9 == 0){
                        LetterScore = 3*LetterScore;
                        }
                    CurrentScore = CurrentScore + LetterScore;
                    LetterScore = 0;
                    }


                    }
                if (CurrentScore > MaxScore){
                    MaxScore = CurrentScore;
                    MaxLine = CurrentLine;
                }
                CurrentScore = 0;
                Line.clear();
                Line.add(MaxLine);
                Score.clear();
                Score.add(MaxScore);
            }
            scan.close();
        }

    public String getReportStr(){
        return("Max Scrabble Score: " + Score.get(0) + "for this line: " + Line.get(0));
    }


    }
