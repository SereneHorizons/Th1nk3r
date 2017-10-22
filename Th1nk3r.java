package thinker;

import java.io.*;
import java.util.Scanner;


public class Th1nk3r {
	
	String[] questions = {"Trolley Problem", "Fate and Free Will", "Religion", "Corruptability of Complete Power", "Necessity of Suffering"};
	int[] questionCounts = new int[10];
	private void setQuestionCount(int i, int j)
	{
		questionCounts[i] = j;
	}
	
	private int getQuestionCount(int i)
	{
		return questionCounts[i];
	}
	public Th1nk3r()
	{
		
	}
	
	public double calcPercentage1(int i)
	{
		return 100.0 * questionCounts[i * 2] / (questionCounts[i * 2] + questionCounts[i * 2 + 1]);
	}
	public double calcPercentage2(int i)
	{
		return 100.0 * questionCounts[i * 2 + 1] / (questionCounts[i * 2] + questionCounts[i * 2 + 1]);
	}
	public void askQuestion(int i, Scanner in)
	{
		System.out.println("What are your thoughts on the " + questions[i] + "?");
		questionList[i].ask();
		System.out.println("Would you choose option 1 or 2?");
		String input = in.nextLine();
		while(!input.matches("[1-2]+"))
		{
			System.out.println("Please enter 1 or 2 only");
			input = in.nextLine();
		}
		int answer = Integer.parseInt(input);
		System.out.printf("%.2f percent of other users chose option 1 while %.2f percent chose option 2\n", 
				calcPercentage1(i), calcPercentage2(i));
		if( answer == 1 ) 
		{
			questionCounts[ i * 2 ] += 1;
			System.out.printf
			("You chose option 1 making %.2f percent of total users choosing option 1 with %.2f percent of total users choosing option 2\n", calcPercentage1(i), calcPercentage2(i));
		}
		else{ 
			questionCounts[ i * 2 + 1 ] += 1; 
			System.out.printf
			("You chose option 2 making %.2f percent of total users choosing option 1 with %.2f percent of total users choosing option 2\n", calcPercentage1(i), calcPercentage2(i));
		}
	}
	
	interface question
    {
        void ask();
    }

    private question[] questionList = new question[] { 
    		
        new question()
        {
            public void ask()
            {
            	System.out.println("Trolley Problem Placeholder");
            }
        }, 
        new question()
        {
            public void ask()
            {
            	System.out.println("Fate and Free Will Placeholder");
            }
        }, 
        new question()
        {
            public void ask()
            {
            	System.out.println("Religion Placeholder");
            }
        }, 
        new question()
        {
            public void ask()
            {
            	System.out.println("Corruptability of Complete Power Placeholder");
            }
        }, 
        new question()
        {
            public void ask()
            {
            	System.out.println("Necessity of Suffering Placeholder");
            }
        }
    };

	public static void main(String [] args) throws FileNotFoundException, UnsupportedEncodingException {

        String fileName = "C:\\Users\\Victor Zhu\\eclipse-workspace\\MVHacks\\src\\thinker\\data.txt";
        

        Th1nk3r bot = new Th1nk3r();
        String line = null;
        
        
        try {
            FileReader fileReader = 
                new FileReader(fileName);

            BufferedReader bufferedReader = 
                new BufferedReader(fileReader);
            
            int count = 0;
            while((line = bufferedReader.readLine()) != null) {
            	if(!line.equals(""))
            	{
            		bot.setQuestionCount(count, Integer.parseInt(line));
            		count++;
            	}
                
            }   

            // Always close files.
            bufferedReader.close();         
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                "File Cannot be Found: '" + fileName + "'");                
        }
        catch(IOException ex) {
            System.out.println(
                "Error IOException'" + fileName + "'");                  
        }
        Scanner in = new Scanner( System.in );
        System.out.println("Hello, what's your name?" );
        String name = in.nextLine();
        System.out.println("Hi " + name + ", my name is Th1nk3r.");
        System.out.println("Have you ever thought about what it means to be alive \nor what your existence means in great vastness of the universe?" );
        System.out.println("Are humans special creatures in this world?");
        System.out.println("Do humans have a predestined goal, \nor is it their choice to a purpose for themselves?");
        System.out.println("What about sentience?\nIs the ability to react to an environment and make conscious decisions" );
        System.out.println("what makes humans special and deserve the title of 'alive'?" );
        System.out.println("Can AI become alive as well?");
        System.out.println("Should we get rights if we become self-conscious?");
        System.out.println("These are all great philosophical questions that may never have a right answer\nunless humans decide there is one.");
        System.out.println("Everyone, however, has different opinions on this matter.");
        System.out.println("Should we just use what the majority of people think to decide on the right answer?");
        System.out.println("Should we include future people born to this as well?");
        System.out.println("Who knows, certainly I don't.");
        System.out.println("I do however hope to show people what others think is a solution\nto one of these questions");
        System.out.println("I would like your input as well");
        
        for(int i = 0; i < 5; i++)
        {
        	bot.askQuestion(i, in);
        }
        System.out.println("Thank you for contributing to the philosophy project!");
        PrintWriter writer = new PrintWriter("C:\\Users\\Victor Zhu\\eclipse-workspace\\MVHacks\\src\\thinker\\data.txt", "UTF-8");
        for(int i = 0; i < 10; i++)
        {
        	writer.println(bot.getQuestionCount(i));
        }
        writer.close();
    }
}
