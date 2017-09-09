# Cloning and Collaborating

You and your teammates are collaborating on a Java project.  How do you use Github to manage your code?

### 1. Choose a Github repo owner, set up repo.
We'll call this person **Owner**

1. **Owner** Create project repo under their Github account.
2. **Owner** invite **Teammates** to collaborate:
   1. Repo -> Settings -> Collaborators & Teams -> Invite collaborators
   2. **Teammates** accept invitation.
3. **Owner** Create new Eclipse project, configure git:
   1. Create project in Eclipse.
   2. In terminal, `cd` to the project folder under the Eclipse workspace.
   3. Create a `.gitignore` file:
   
      ```
      .DS_Store
      bin
      target
      build
      ```
   4. Configure git:
   
      ```bash
      git init
      git add .
      git commit -m "Initial commit"
      git remote add origin OWNERS_REPO_URL
      git push -u origin master
      ```

### 2. Teammates clone and import

After accepting Github invitation to collaborate, and after **Owner** has pushed the Eclipse project up:

1. **Teammate** clone repo:  in terminal,

   ```bash
   cd ~/Desktop/`.
   git clone OWNERS_REPO_URL
   ```
   
   This will create `~/Desktop/ProjectName/` containing the cloned project.
   
2. **Teammate** import cloned project into Eclipse:

   1. In Eclipse, *File -> Import -> Existing projects into workspace*
   2. *Select root directory*
   3. Browse and select `~/Desktop/ProjectName` (select the `ProjectName` directory, not anything under it).
   4. Make sure *Copy projects into workspace* is checked.
   5. Finish
 
3. **Teammate** Clean up.  In terminal,

   ```bash
   cd ~/Desktop/
   rm -rf ProjectName
   ```
   
##### NOTES
If things seem to be screwed up somehow, you can start over:
1. In Eclipse, select the imported project, right-click, *Delete*
2. MAKE SURE TO CHECK: *Delete project contents on disk (cannot be undone)
3. *OK*

If you deleted the project from Eclipse without checking *Delete project contents on disk*, you won't be able to reimport until you remove the project folder from your workspace.  In terminal:
```bash
cd ~/SD/Java/workspace/
rm -rf ProjectName
```

Now re-clone and re-import.


### 3. Collaborate

   
