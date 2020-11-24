package project_1;
import java.io.*;
import java.util.*;

public class entryPoint {
	
	static String dirPath = "C:\\SimplilearnProject1\\FileDirectory";  // class variable
	
	public static void main(String[] args) 
	{
		
		Scanner input = new Scanner(System.in);
		
		/*
		The first thing we need to do is create a directory which we will use to store all of the files created by this application.
		It's important to note that in case the directory already exists, nothing happens. Therefore, if the user creates files, then
		closes the application, and returns at a later stage, there won't be any issue of duplicate repositories.
		Note that the dirPath was made a class variable, since we will need it in different methods of the application.
		The dirPath points at the C drive because it contains the operating system and almost every computer has one.
		This was placed in a try block, so that in case a problem occurs (for example the user's C drive could be full), 
		the application informs the user.
		*/
		
		try 
		{
			
			File newDirectoryObject = new File(dirPath);
			
			if(newDirectoryObject.mkdirs()) 
			{
				;
			}
			else {
				;
			}	
		}
		catch(Exception e) 
		{
			System.out.println("Sorry, the application ran into an error. Please check that your C drive has memory available.");
			;
		}
	
		/*
		 Now we introduce the user to the application.
		 This includes details about the developer.
		 */
					
		System.out.println("Welcome to LockedMe.com!");
		System.out.println("");
		System.out.println("This application was developed by Valentin Gaudeau.");
		System.out.println("email contact: valgaudeau@outlook.com");
		System.out.println("");
		System.out.println("");	
		
		/*
		 Now we give the user the choice to navigate between 3 different options.
		 This is done using a switch statement, which is placed inside a while loop, and which presents the user with 3 options.
		 The reason we place the switch statement in a while loop is that we only want the application to stop running
		 when the user wants it to (choice which is given with option 3). The while loop is placed at this point so that each time
		 the user either returns to the main menu or enters an invalid input, all of the options he can choose from are displayed.
		 We also have a try/catch block for error handling, such that even if the user enters an invalid input (such as a String), 
		 the program can continue running properly. The error is handled with a graceful message.
		 */
		
		boolean run = true;
		
		while(run) 
		{
						
			System.out.println("You can now choose between 3 options:");
			System.out.println("1 - Return all file names in ascending order.");
			System.out.println("2 - Create, delete and search files.");
			System.out.println("3 - Close the application.");
			System.out.println("Please enter the number associated to the option of your choice:");
				
			try 
			{									
				int choice = input.nextInt();			
				if(choice > 0 && choice <= 3)
				{					
					switch(choice)
					{
						case 1:
							sort_Files_Ascending();
							break;
						case 2:
							file_Manager();
							break;
						case 3:
							System.out.println("Thank you for using this application, see you next time!");
							run = false;
							break;
					}
				}
				else 
				{
					System.out.println("Sorry, but this is not a valid option. Please enter a number from 1 to 3.");
				}
			}
			catch(Exception e) 
			{
			System.out.println("Sorry, but this is not a valid option. Please enter a number from 1 to 3.");
			input.nextLine(); // We need this, otherwise a non-valid input in the form of String for example will result in infinite loop.
			}
		}	
	}
	
	public static void sort_Files_Ascending() 
	{
				
		/*
		 The first option which the users can choose from the main menu.
		 This method sorts the files names in an ascending manner based on the ASCII value of their characters.
		 In order to do this, we first create an array in which we store the list of files in the directory being used by this application.
		 We then use the BubbleSort algorithm to perform the sorting.
		 Although this algorithm is not efficient, we will usually be dealing with a low number of files here.
		 The BubbleSort we implemented includes a performance improvement:
         The inner loop iterates under the conditions j < len-i-1. The reason why we include -i here is because at the end of each
         full pass within the inner loop, the element to the rightmost of the list (if we're sorting ascendingly) will be in the correct
         location. Therefore, we don't need to compare it to the other elements again.	 
		 */
		
		File directoryObject = new File(dirPath);
		String fileNames[] = directoryObject.list();
		
		int len = fileNames.length;
		
		if(fileNames.length == 0)
		{
			System.out.println("There are currently no files in the directory for this application.");
		}
		else 
		{
			for(int i = 0; i < len; i++) 
			{	
				for(int j = 0; j < len-i-1; j++) 
				{
					if(fileNames[j].compareTo(fileNames[j+1]) >= 1) 
					{
						String temp = fileNames[j];
						fileNames[j] = fileNames[j+1];
						fileNames[j+1] = temp;							
					}						
				}			
			}
			
			for (int i = 0; i < fileNames.length; i ++) 
			{
				System.out.println("File " + (i+1) + ": " + fileNames[i]);
			}	
		}
		
	}
	
	public static void file_Manager() 
	{
		
		/*
		 The second option which the users can access from the main menu. 
		 This method allows users to create, delete and search for files.
		 There is also an option to navigate back to the main menu.
		 Once again, we use a switch statement in a while loop to accomplish this.
		 We also have a try/catch block for error handling, such that even if the user enters an invalid input, the program
		 can continue running properly. The error is handled with a graceful message.
		 The loop is placed at this point so that each time the user either returns to the main menu or enters an invalid input, 
		 all of the options he can choose from are displayed.
		 */
		
		Scanner input = new Scanner(System.in);	
		
		boolean run_Option2 = true;
				
		while(run_Option2) {
			
									
			System.out.println("Please choose between the following 4 options: ");
			System.out.println("1 - Create file");
			System.out.println("2 - Delete file");
			System.out.println("3 - Search for a file");
			System.out.println("4 - Navigate back to the main part of the application");
			System.out.println("Please enter the number associated to the option of your choice:");
				
			try 
			{
				int choice2 = input.nextInt();
				if(choice2 > 0 && choice2 <= 4)
				{			
					switch(choice2)
					{
					case 1:
						create_New_File();
						break;
					case 2:
						delete_Existing_file();
						break;
					case 3:
						search_Directory();
						break;
					case 4:
						run_Option2 = false;
						break;
					}
				}
				else
				{
					System.out.println("Sorry, but this is not a valid option. Please enter a number from 1 to 4.");	
				}
			}
			catch(Exception e) 
			{
				System.out.println("Sorry, but this is not a valid option. Please enter a number from 1 to 4.");
				input.nextLine();
			}
		}
	}
	
	public static void create_New_File() 
	{
		
		/*
		 Method called by the file_Manager method in order to create files.
		 If the method sees that a file with the user specified name already exists, an error is raised and handled.
		 We use concatenation of the dirPath with the chosen file name to ensure that the file is created in the directory which
		 has been created for this application.
		 */
		
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter the name of the file you wish to create: ");
		String file_name_to_create = input.nextLine();
		
		try 
		{
			
			File fileObject = new File(dirPath + "\\" + file_name_to_create); 
			
			if (fileObject.createNewFile()) 
			{
				System.out.println("New File is created!");
			} 
			else 
			{
				if(fileObject.exists()) 
				{
					System.out.println("File already exists");					
				}
			}
		}
		catch (IOException e) 
		{
			System.out.println("Sorry, the name you entered is not valid. Please try again");
		}
		
	}
	
	public static void delete_Existing_file() 
	{	
		/*
		 Method called by the file_Manager method in order to delete files.
		 If the method sees that there is no existing file with the name specified by the user, an error is raised and handled. 
		 We use concatenation of the dirPath with the chosen file name to ensure that the file which is deleted is searched for in the
		 directory which has been created for this application.
		 */
		
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter the name of the file which you would like to delete: ");
		String file_name_to_delete = input.nextLine();
		
		try 
		{			
			File fileObject = new File(dirPath + "\\" + file_name_to_delete);			
			if(fileObject.delete()) 
			{
				System.out.println(fileObject.getName() + " deleted");
			}
			else 
			{
				System.out.println("Sorry, file name was not found, please make sure you enter the name of an existing file");
			}
		}
		catch(Exception e) 
		{
			System.out.println("Sorry, the application ran into an error. Please try again");
		}
		
	}
	
	public static void search_Directory() {
		
		/*
		 Method called by the file_Manager method in order to search for files.
		 First, we store all of the file and directory names in the array fileNames. Then, we perform a Linear Search to see if the
		 name we are looking for is in the array. If it is, we return the absolute path of the file and confirm its existence to the user.
		 If the method sees that there is no existing file with the name specified by the user, an error is raised and handled.
		 We use concatenation of the dirPath with the chosen file name to ensure that the file which is searched for is in the
		 directory we have created for this application.
		 */
		
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter the name of the file which you would like to find: ");
		String file_name_to_find = input.nextLine();
		
		File directoryObject = new File(dirPath);
		String fileNames[] = directoryObject.list();
		
		int arrLength = fileNames.length;
		
		try 	
		{
			boolean fileNameFound = true;
			for (int i = 0; i < arrLength; i++)
			{
				if(fileNames[i].equals(file_name_to_find))
				{					
					fileNameFound = true;
					break;
				}
				else
				{
					fileNameFound = false;
				}
			}
			
			if (fileNameFound)
			{
				File fileObject = new File(dirPath + "\\" + file_name_to_find);
				System.out.println("File was found. Path: " + fileObject.getAbsolutePath());
			}
			else
			{
				System.out.println("Sorry, file name was not found, please make sure you enter the name of an existing file");
			}
					
		}
		catch(Exception e) {
			System.out.println("Sorry, the application ran into an error. Please try again");
		}
		
	}
	
}
