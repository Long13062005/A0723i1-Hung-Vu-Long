package Intl;

import java.util.Scanner;
import java.util.Stack;

public class Bracket {
	private String string;

    public Bracket(String string) {
        this.string = string;
    }
    public Boolean checkBracket(){
        Stack<Character> characterStack = new Stack<>();
        for(int i =0;i<string.length();i++){
            if((string.charAt(i)=='[')||(string.charAt(i)=='(')||(string.charAt(i)=='{')){
                characterStack.push(string.charAt(i));
            } else if ((string.charAt(i)==']')||(string.charAt(i)==')')||(string.charAt(i)=='}')) {
                if(characterStack.isEmpty()){
                    return false;
                }
                char left = characterStack.pop();
                if(!isMatching(left,string.charAt(i))){
                    return false;
                }
            }
        }
        return characterStack.isEmpty();
    }
    private boolean isMatching(char a, char b) {
        return (a == '[' && b == ']') || (a == '(' && b == ')') || (a == '{' && b == '}');
    }
    public static void main(String[] args) {
    	 Scanner scanner = new Scanner(System.in);
         System.out.println("Input your String : ");
         String string = scanner.nextLine();
         Bracket checkBracket=new Bracket(string);
         if(checkBracket.checkBracket()){
             System.out.println("It's OK");
         } else System.out.println("Some thing is wrong");
	}
}
