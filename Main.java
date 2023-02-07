import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;
class Main {
  public static void main(String[] args) {
    int comScore = 0;
    int userScore = 0;
    int[] scoreList;
    Scanner input = new Scanner(System.in);
    boolean quit = false;
    
    while (!quit){
      char computerInput = computer_input();
      char rawUserInput = user_input();
      char userInput = upper_char(rawUserInput);
      System.out.println("you have entered " + userInput);
      boolean check = checkChar(userInput);
      if (check == false){
        System.out.println("Wrong input");
        continue;
      }
      
      System.out.println("computer have entered " + computerInput);
      if(userInput == computerInput){
        System.out.println("draw");
        continue;
      }
      
      char winner = winOfTwo(userInput, computerInput);
      System.out.println("winner is " + winner);
      
      scoreList = getScore(userScore, comScore, userInput, computerInput);
      userScore = scoreList[0];
      comScore = scoreList[1];
      System.out.println("user score is " + userScore);
      System.out.println("computer score is " + comScore);
      System.out.println("---------------------------------------");
      System.out.println("Do you want to quit? (yes/no)");
      String answer = input.nextLine();
      if (answer.equalsIgnoreCase("yes")) {
        quit = true;
      }
    }
  }
  public static char computer_input(){
    char[] characters = {'P','R','S'};
    Random random = new Random();
    int index = random.nextInt(characters.length);
    char random_char = characters[index];
    return random_char;
  }
  public static char user_input(){
    Scanner user = new Scanner(System.in);
    System.out.println("enter you choice from R, P or S");
    char userInput = user.next().charAt(0);
    return userInput;
  }
  public static char winOfTwo(char input1, char input2){
    if (input1 == 'P'){
      if (input2 == 'R'){
        return 'P';
      }
      else{
        return 'S';
      }
    }
    else if(input1 == 'R'){
      if (input2 == 'S'){
        return 'R';
      }
      else{
        return 'P';
      }
    }
    else{
      if (input1 == 'P'){
        return 'S';
      }
      else{
        return 'R';
      }
    }
  }

  public static int[] getScore(int userScore, int computerScore, char userInput, char computerInput){
    if (userInput == 'P'){
      if (computerInput == 'R'){
        userScore += 1;
      }
      else{
        computerScore += 1;
      }
    }
    else if(userInput == 'R'){
      if (computerInput == 'S'){
        userScore += 1;
      }
      else{
        computerScore += 1;
      }
    }
    else{
      if (computerInput == 'P'){
        userScore += 1;
      }
      else{
        computerScore += 1;
      }
    }
    return new int[] { userScore, computerScore };
  }
  
  public static char upper_char(char input){
    char input2 = Character.toUpperCase(input);
    return input2;
    }
  public static boolean checkChar(char input){
    char[] validCharacters = {'P','R','S'};
    boolean isValid = Arrays.binarySearch(validCharacters, input) >= 0;
    return isValid;
    }
}