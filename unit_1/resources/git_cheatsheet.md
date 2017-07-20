##Git Cheatsheet

#### Create a new repo on GitHub
```bash
https://github.com/new
# Name the repo MyProject.git
```

####Initialize an Eclipse project as a Git Repo on your computer
```bash
cd ~/SD/Java/workspace/MyProject
git init
```

####Create a .gitignore
```bash
# Create a hidden file called gitignore
touch .gitignore

# Now add the names of files you want to ignore to the 
# .gitignore file in a text editor.
# Add the following, each on its own line:
bin
.DS_Store
```

####Add a Remote Github Repository to a Local Repo
```bash
git remote add origin #https://github.com/#username/#repositoryname.git

git remote -v
```

####Push Local Changes to Github Repository
```bash
git status
git add #filename
git commit #filename
git pull origin master
git push origin master
```

####Unstage a File You Added
```bash
git reset HEAD #file_name
```

####Remove Deleted Files
```bash
git rm #filename
```

####Clone a repository
```bash
git clone #https://github.com/#username/#repositoryname.git
```

####Create and Use a Branch
```bash
#To list branches
git branch

#To create a new branch
git branch #branch_name

#To use a branch
git checkout #branch_name
```

####Push a Branch to Github (ie. not master)
```bash
git pull origin master
git push origin #branch_name
```
