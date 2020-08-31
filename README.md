# TEALS Codespaces for Ephrata High School
## Creates a Development Container for Java on Visual Studio Codespaces

These instructions will guide you through the process of setting up Codespaces, an online IDE. _IDE_ stands for _Integrated Development Environment_, which is a program that software developers use to write code. You can use any text editor to write code, but an IDE makes it _much_ easier.

Think of Codespaces like Microsoft Word for code. You can write a really long essay in Notepad if you want to, but you'll almost always prefer to do it in Word or Google Docs.

## High level process

![codespacesProcess](https://raw.githubusercontent.com/DataSnowman/EphrataTEALS/master/images/codespacesProcess.png)


### Create an Azure for Students Subscription

Creating an Azure for Students subscription is a three-step process.

 1. Create a new Outlook.com email account
 2. Redeem your Student Verification Code
 3. Activate your subscription

**Step 1: Create a new Outlook.com email account**

The first step is to create a new Outlook.com email account to use with Codespaces. You will _only_ be using this account for Codespaces.

Your email should have the following format: `<firstname>-<lastinitial>-ephrata-teals@outlook.com`. So, for example, if your name was John Doe, your new email would be `john-d-ephrata-teals@outlook.com`.

 1. In Chrome, open a new Incognito window (Ctrl+Shift+N)
 2. Navigate to https://signup.live.com
 3. Click on the "Get A New Email Address" button
 4. Enter your new email address in the `<firstname>-<lastinitial>-ephrata-teals@outlook.com` format
 5. Create a new password for the account
 6. Uncheck the box that says "I would like information, tips, and offers about Microsoft products and services."
 7. Click "Next"
 8. Enter your first and last name
 9. Click "Next"
 10. Select "United States" for "Country/region" and enter your date of birth
 11. If prompted, validate using Captcha

After your account is created, you will be taken to your account page. Select "More Actions" and click "View Inbox".

**Step 2: Redeeming a Microsoft Azure Student Verification Code:**

  1. Open a new tab in the same Incognito window
  2. Navigate to http://aka.ms/azure4students
  3. Click the green "Activate now" button
  4. If prompted, sign in to the account you just created with the `<firstname>-<lastinitial>-ephrata-teals@outlook.com`
  5. In Step 1, "Identity Verification by phone", Enter your phone number
  6. Click "Text me"
  7. Enter the verification code that was texted to you and click "Verify code"
  8. In Step 2, "Student Verification", change the "Verification method" dropdown from "School email address" to "Verification code"
  9. Enter your personal verification code and click "Verify academic status"

Wait for the redemption process to finish. **Do not close any tabs or windows**. It may take up to 5 minutes.

**Step 3: Activate your subscription:**

When the redemption process is complete, it will redirect to the sign-up page.

  1. Under "Country/region", select "United States"
  2. Enter your first name, last name, email address (use the `<firstname>-<lastinitial>-ephrata-teals@outlook.com` you created in the first step), and phone number. You do not need to enter anything under "Company VatID" if you see that field.
  3. Click "Next"
  4. Check the box indicating that you agree to the terms
  5. Click "Sign up"

It may take a few minutes to process the request. Again, **do not close any tabs or windows**.
Once you are redirected to the "Welcome to Microsoft Azure" page, the process is complete. You can close this tab.

### Create a Github account

In the next step of the process you will create a Github account. Github is a free service that stores code for you in the cloud. It is the industry standard for storing and sharing software code. Think of it like Google Drive for code!

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

### Set up your Visual Studio Online Codespace

We're on to the last part - setting up your Codespace.

**Step 1: Create your Codespace**

  1. In a new tab in Chrome, go to https://online.visualstudio.com/
  2. Click "Get started", then click "Sign in"
  3. Sign in using the `<firstname>-<lastinitial>-ephrata-teals@outlook.com` account from before
  4. On the page that asks "Let this app access your info?", click "Yes"
  5. You will be redirected to the Codespaces landing page
  
     ![codespacesCreate](https://raw.githubusercontent.com/DataSnowman/EphrataTEALS/master/images/codespacesCreate.png)
     
  6. Click the dropdown on the top of the page that says "Create new plan", then click again to create a new billing plan
  7. Under "Subscription" select "Azure for Students" and under "Location" select "West US 2"
  8. Click "Create"
  9. After the billing plan has been created, click the "Create Codespace" button
  10. For "Codespace Name", enter something like "AP CS A" or "Java Codespace". You will be working in this Codespace throughout the year
  11. For "Github Repository", enter the name of your forked copy of the repository (`<firstname>-<lastinitial>-ephrata-teals/EphrataTEALS`)
  12. Under "Instance Type", select "Basic"
  13. Under "Suspend idle Codespace after...", select "30 minutes"
  14. Click "Create"

      ![codespacesCreateEnv](https://raw.githubusercontent.com/DataSnowman/EphrataTEALS/master/images/codespacesCreateEnv.png)

  15. Wait for the environment to be created, and then click "Connect" to connect to it.
  16. Wait for a minute or so while the environment is set up for you. It might look like nothing is happening, just be patient. 
  17. After the REFRESH NOW file has appeared, refresh the web page to ensure all of the extensions are loaded and you're ready to start.

**Step 2: Configure GitHub settings and remote for fork**

This step will involve entering some commands into the terminal, or command line. If this if the first time you've used a terminal, it can be intimidating. Don't worry! Just follow the directions and copy and paste the commands exactly. When an instruction says to _enter_ a command, it means to type (or paste) the command, and then press the Enter key to execute it.

  1. Open a terminal in your Codspace using the keyboard shortcut ``Ctrl + ` `` (you can also go to the menu in the top left and select Terminal > New Terminal) 
       
       ![terminalMenu](https://raw.githubusercontent.com/DataSnowman/EphrataTEALS/master/images/terminalMenu.png)

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

**Step 3: Run your first program!**

  1. In `sampleCode > Hello`, find `HelloWorld.java`.  The contents of the file should look like this:

```
public class HelloWorld {  
    public static void main (String [] args) {
        System.out.println("HelloWorld");
    }
}
```
  2. Codespaces may automatically open some other tabs. If this happens, just close them and return to `HelloWorld.java`.
  3. On the sidebar, click the "Run" button (the one with the play button and the little bug):

   ![run](https://raw.githubusercontent.com/DataSnowman/EphrataTEALS/master/images/run.png)

  3. Click "Run and Debug". Again, Codespaces may automatically open some other tabs. If this happens, close them and click "Run and Debug" again.
  4. You should see the following output in the terminal:

  ![terminal](https://raw.githubusercontent.com/DataSnowman/EphrataTEALS/master/images/terminal.png)

Congratulations! You just ran your first program!

**Step 4: Change the code**

  1. In `HelloWorld.java`, find the line that reads `System.out.println("HelloWorld");`
  2. Replace `HelloWorld` with `Hello <your name>` (or anything, really! You could write `Hello <your dog's name>` or `Hello chair`)
  3. Click the "Run and Debug" button again
  4. You should see the new greeting in the terminal. You just wrote your first piece of code!
  5. To save your work, enter the following sequence of commands in the terminal:
  
````
git add -a
git commit -m "Modified HelloWorld.java"
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
git add -a
git commit -m "<description of your work for the day>"
git push origin master
```
This will save your changes by pushing them changes to your forked repository.
