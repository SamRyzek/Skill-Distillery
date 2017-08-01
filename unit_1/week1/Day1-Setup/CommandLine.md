## Set Up Initial Development Environment
You're going to use the command line to set up and use your initial development environment.
### Pull Student Files Repo
Open a terminal: *Cmd*-Space to open spotlight, start typing "terminal" until _Terminal_ is listed and launch it.

The terminal application gives you access to a *shell* command line.  This *command line interface* or CLI is the most basic and powerful way to access your system.  Your continued mastery of the shell will give you much higher productivity than you can achieve without it.
* In the terminal, change directories to your Desktop.

   ```
   cd ~/Desktop
   ```
   
  * In the shell, tilde (_~_) represents your account's home directory, */Users/yournamehere*
  * The _cd_ command changes your shell's current location in the file system.
* Clone the SD6 branch of the SkillDistillery SD-Files repo:

   ```
   git clone -b SD6 https://github.com/SkillDistillery/SD-Files.git
   ```
   
  * cd into the new *SD-Files/* folder to see what you pulled down from GitHub.
   ```
   cd SD-Files/
   ls
   cd unit1
   ls
   ls -l
   ```
     * The _ls_ command lists files.  _ls -l_ shows a long listing that includes file size, permissions, modification time, and other information.

### Copy course files for this week.

* Return to your home directory.
  ```
  cd
  pwd
  ```
    * The _cd_ command by itself takes you to your home directory.
    * The _pwd_ command stands for "print working directory" - it shows you where you are in the file system.  Make sure you are in your home directory.
    
* Create a new directory for the files and programs you'll create and use in this program.  We'll start laying out a directory structure and setting up the files we'll need to get started.
  ```
  mkdir SD
  cd SD
  mkdir Java Tools
  cd Java
  cp ~/Desktop/SD-Files/unit1/jfop.pdf .
  cp ~/Desktop/SD-Files/unit1/jfop.zip .
  unzip jfop.zip
  cd jfop
  ls
  ```
    * The _mkdir_ ("make directory") creates a new folder (we use the terms "folder" and "directory" interchangably).  You can give it multiple directory names (_Java_ and _Tools_, in this case) and it will create them all.
    * The _cp_ ("copy") command copies a file or files.  It takes an existing filename and a new name or location to copy it to.
    * The . ("dot") represents your current working directory, wherever that may be.
    * The _unzip_ command extracts a ZIP archive.  In this case, extracting  _jfop.zip_ creates a subdirectory named _jfop/_. 
