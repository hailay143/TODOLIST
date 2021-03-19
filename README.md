# **Project :ToDo List Application**
### Project description and features:
This is a ToDo list application, with a texted based user interface. It is a simple command line JAVA program to create and manage a personal ToDo List.
The task list can be manipulated using Add, Delete, Edit and Save option.

*  The application take the following inputs for its proper functionality
  - task title
  - due date, todo the task
  - completion status of task
  - categorise under project, if any
* The application provides an option to sort the task list,
  - by date
  - by project type
* The application support the following requirements for task listing
  - Add a task
  - Edit task
  - Mark a task as done 
  - Remove task 
  - Save task list to data files, and Quit
  
### Platform used for the application development
> * IDE-IntelliJ IDEA
> * java 15.0.2
> * Gradle 6.8.3
> * junit.jupiter:junit-jupiter-api:5.6.2

## Class diagram
### The ToDoList class diagram
![IP Class diagram](https://user-images.githubusercontent.com/79463089/111063369-621a5180-84ae-11eb-976f-b796795a66de.jpg)

## Getting started
The application can be run from Gradle 
>(gradle build =>gradle run)

 Or using the .jar (Updating the run/debug configuration )
> java -jar

### Run with Gradle
The application can be started with Gradle's run command, as shown below.
.....
gradle run --console plain
.....

## User Manual
#### Starting the application
Running the application displays a main/welcome page of the application with the following details as shown below.

<img width="430" alt="Welcome:Main page" src="https://user-images.githubusercontent.com/79463089/111085859-9aa34500-8519-11eb-88b8-55b3c23de76d.png">

#### Display page for list of tasks
If user types number [1] and press ENTER key, the application will
display the options for user to get list of all previously added tasks
sorted by date or by project.

<img width="561" alt="Tasks display" src="https://user-images.githubusercontent.com/79463089/111086935-34b9bc00-851f-11eb-8de8-bd65e5e4676c.png">

#### Add a new task
If user types number [2] and press ENTER key, the application will
prompt the user to enter the required fields of a task to add in the
task list.

<img width="490" alt="Add new task" src="https://user-images.githubusercontent.com/79463089/111087199-89116b80-8520-11eb-8753-e1b37fb3d7c3.png">

#### Edit an existing task (update, mark as done, remove)
If user types number [3] and press ENTER key, the application will
display the list of all previously saved tasks with index number and
user has to select a task to perform any update, to mark as done or to remove.

<img width="727" alt="Edit task" src="https://user-images.githubusercontent.com/79463089/111087376-8f541780-8521-11eb-8031-d13e80a67342.png">

#### Save task list and closing the application 
If user types number [4] and press ENTER key, the application will save
data of all tasks from memory and write to the data file on disk (default filename is `TaskList.obj`).

<img width="538" alt="Closing the application" src="https://user-images.githubusercontent.com/79463089/111087513-50729180-8522-11eb-8c02-d071ea7f0c4e.png">


  
  
