# TEALS Codespaces for Ephrata High School
## Creates a Development Container for Java on GitHub Codespaces

These instructions will guide you through the process of setting up Codespaces, an online IDE. _IDE_ stands for _Integrated Development Environment_, which is a program that software developers use to write code. You can use any text editor to write code, but an IDE makes it _much_ easier.

Think of Codespaces like Microsoft Word for code. You can write a really long essay in Notepad if you want to, but you'll almost always prefer to do it in Word or Google Docs.

### Create a Github account

Create a Github account. Github is a free service that stores code for you in the cloud. It is the industry standard for storing and sharing software code. Think of it like Google Drive for code!

For your username, `<firstname>-<lastinitial>-ephrata-teals` format. So, if your name was Jane Doe, your username would be `jane-d-ephrata-teals`.

  1. In a new tab in Chrome, go to https://github.com
  2. Click "Sign up" in the top right corner
  3. Enter your username in the `<firstname>-<lastinitial>-ephrata-teals` format
  4. Enter your `<firstname>-<lastinitial>-ephrata-teals@outlook.com` email
  5. Choose a password
  6. Solve the verification puzzle
  7. Click "Create account"
  8. In a new tab in Chrome, go to https://outlook.live.com/. You should see an email from Github asking you to verify your email address
  9. Open the email and click "Verify email address"
  
### Fork the EphrataTEALS repository

In this step you'll be copying an existing Github _repository_ to your own account. You can think of a repository as a special kind of folder for code. It's actually much more complicated (and powerful) than that, but you'll learn about all of that another time.

  1. In a new tab in Chrome, go to https://github.com/DataSnowman/EphrataTEALS
  2. Click on "Fork" in the top right corner

        ![fork](https://raw.githubusercontent.com/DataSnowman/EphrataTEALS/master/images/fork.png)
        
  3. If you are asked "Where should we fork EphrataTEALS?", click on your new Github username

        ![forkdest](https://raw.githubusercontent.com/DataSnowman/EphrataTEALS/master/images/forkdest.png)

You now have a copy of the EphrataTEALS repository in your GitHub. This is what you should see:

![yourcopy](https://raw.githubusercontent.com/DataSnowman/EphrataTEALS/master/images/yourcopy.png)

My username was darsch so the repository shows up as `darsh/EphrataTEALS`.

Yours should be `<firstname>-<lastinitial>-ephrata-teals/EphrataTEALS`.

### Request access to the GitHub Codespaces beta

Click on https://github.com/features/codespaces/signup
to request access for GitHub Codespaces beta 

Click on the button "Sign in to sign up for the beta" and sign in with your GitHub user and password.

![requestbeta](https://raw.githubusercontent.com/DataSnowman/EphrataTEALS/master/images/GitHubCodespaces.png)

### Set up your GitHub Codespace

We're on to the last part - setting up your Codespace.

Once you have access to GitHub Codespaces it will show up on the top menu

![codespacemenu](https://raw.githubusercontent.com/DataSnowman/EphrataTEALS/master/images/codespacesMenu.png)


**Step 1: Create your Codespace**

  1. Click "Codespaces" on the top menu
  2. Click on "Create your first codespace" button
  
     ![codespacesCreate](https://raw.githubusercontent.com/DataSnowman/EphrataTEALS/master/images/createFirstCodespace.png)
     
  3. Enter your Repository and choose the master (or Main) branch

      ![codespacesCreateEnv](https://raw.githubusercontent.com/DataSnowman/EphrataTEALS/master/images/createCodespace.png)

  4. Click "Create codespace" button

  5. Wait for the environment to be created
  6. Wait for a minute or so while the environment is set up for you. It might look like nothing is happening, just be patient. 

**Step 2: Configure GitHub settings and remote for fork**

This step will involve entering some commands into the terminal, or command line. If this if the first time you've used a terminal, it can be intimidating. Don't worry! Just follow the directions and copy and paste the commands exactly. When an instruction says to _enter_ a command, it means to type (or paste) the command, and then press the Enter key to execute it.

  1. Open a terminal in your Codspace using the keyboard shortcut ``Ctrl + ` `` (you can also go to the menu in the top left and select Terminal > New Terminal) 
       
       ![terminalMenu](https://raw.githubusercontent.com/DataSnowman/EphrataTEALS/master/images/terminalMenu.png)

  Make sure it is a bash shell

  2. In the terminal, type or paste the following command and hit Enter:

```
pwd
```

  3. Now enter the following command (remember, "entering" a command means typing or pasting it into the terminal, then pressing Enter to execute it):

```
git status
```

  Your terminal should now look like the following, except it will say "EphrataTEALS" instead of "TEALS1":

  ![terminalOutput](https://raw.githubusercontent.com/DataSnowman/EphrataTEALS/master/images/terminalOutput.png)

  4. Enter the following command, replacing `<GitHubusername>` with the `<firstname>-<lastinitial>-ephrata-teals` username you created earlier:

```
git config --global user.name "<GitHubusername>"
```

  5. Confirm that you have set the username correctly by entering the following command:

```
git config --global user.name
```

  6. Enter the following command, replacing `email@example.com` with your `<firstname>-<lastinitial>-ephrata-teals@outlook.com` email:

```
git config --global user.email "email@example.com"
```

  7. Confirm that you have set the email address correctly by entering the following command:

```
git config --global user.email
```

  8. Enter the following command:

```
git remote -v
```

  9. Make sure that your terminal displays the following:

```
> origin  https://github.com/<firstname>-<lastinitial>-ephrata-teals/EphrataTEALS (fetch)
> origin  https://github.com/<firstname>-<lastinitial>-ephrata-teals/EphrataTEALS (push)
```
    
  10. Enter the following command as-is (_do not_ replace the username):

```
git remote add upstream https://github.com/DataSnowman/EphrataTEALS.git
```

  11. Enter the following command again:

```
git remote -v
```

  12. Make sure that your terminal displays the following:

```
> origin    https://github.com/<firstname>-<lastinitial>-ephrata-teals/EphrataTEALS (fetch)
> origin    https://github.com/<firstname>-<lastinitial>-ephrata-teals/EphrataTEALS (push)
> upstream  https://github.com/DataSnowman/EphrataTEALS.git (fetch)
> upstream  https://github.com/DataSnowman/EphrataTEALS.git (push)
```

  13. Finally, enter the following command:

```
git pull upstream master
```

**Step 3: Run your CodespacesBeta.java program!**

  1. In `sampleCode > GitHubCodespacesTest`, find `CodespacesBeta.java`.  The contents of the file should look like this:

```
package sampleCode.GitHubCodespacesTest;

public class CodespacesBeta {
    public static void main(String[] args) {
        String x = "Merry Christmas !!!";
        System.out.println(x);
        
    }
}
```
  2. Codespaces may automatically open some other tabs. If this happens, just close them and return to `CodespacesBeta.java`.
  3. On the sidebar, click the "Run" button (the one with the play button and the little bug):

   ![run](https://raw.githubusercontent.com/DataSnowman/EphrataTEALS/master/images/run.png)

  3. Click "Run and Debug". Again, Codespaces may automatically open some other tabs. If this happens, close them and click "Run and Debug" again.
  4. You should see the following output in the terminal:

  ![terminal](https://raw.githubusercontent.com/DataSnowman/EphrataTEALS/master/images/terminal.png)

Congratulations! You just ran your first program!

**Step 4: Copy the GitHubCodespacesTest folder and paste to studentWork folder and then change the code**

  1. In `CodespacesBeta.java`, find the line that reads `package sampleCode.GitHubCodespacesTest;`
  2. Change sampleCode to studentWork so it reads `package studentWork.GitHubCodespacesTest;`
  3. In `CodespacesBeta.java`, find the line that reads `System.out.println("Merry Christmas !!!");`
  4. Replace `Merry Christmas` with `Happy New Year` (or anything, really! You could write `Happy New Year <your dog's name>` or `Happy Christmas`)
  5. Click the "Run and Debug" button again
  6. You should see the new greeting in the terminal. You just wrote your first piece of code!
  7. To save your work, enter the following sequence of commands in the terminal:
  
```
git add -A
git commit -m "Modified CodespacesTest.java"
git push origin master
```

### In future classes:

At the beginning of each class, after opening your Codepsace, you will open a terminal window (with ``Ctrl + ` `` or using menu and going to Terminal > New Terminal). Then you will enter the following command:

```
git pull upstream master
```

This command gets any new code from the instructors that you will need for the class that day.

At the end of every class, you will run the following sequence of commands:

```
git add -A
git commit -m "<description of your work for the day>"
git push origin master
```
This will save your changes by pushing them changes to your forked repository.
