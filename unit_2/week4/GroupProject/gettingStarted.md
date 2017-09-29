## Getting Started With Your Group

Receiving a project with a broad range of deliverables can be overwhelming. Where do you start? This can be especially tricky when working in a group. People have different views on how to approach problems as well as expectations of the end product. Your first hurdle is coming up with an idea to build your project around. It is key that you choose something that is not only feasible in the allotted time frame, but also is engaging to all the members of your group. For this project the instructors and TA's will be acting as project managers. They will assist each group, providing technical guidance as well as getting you properly launched on an idea we deem feasible. If approached correctly this will be your first "full stack" application for your portfolio.

The design of your mySQL backend will directly effect what you are able to accomplish in terms of features for this project. It is imperative that you have this working before you move forward with the apps functionality. Get the schema designed and build the database tables before creating appropriate Java classes, and annotating them with JPA.

### Creating your project
**A SINGLE GROUP MEMBER SHOULD DO THE FOLLOWING STEPS**

* Create a new repo on GitHub.  
* Add your teammates as collaborators. Navigate to `Settings/Collaborators` and enter their usernames in the provided form.  
* Create new folder on your local machine:  
  * Initialize it as a git repository, `git init`
  * Link the local repo with the github repo you just created `git remote add origin https://github.com/username/repository-name`. The URL at the end will be specific to your GitHub and repo name.
* In this same folder, create a file named `.gitignore`. The preceding `.` on the filename indicates that it is a hidden file. Add the following to this file:
  * .DS_Store
  * target
  * build
  * bin
  * .metadata
  * .gradle
  * Servers
  * .recommenders
* In STS choose `File/Switch Workspace/Other`. Navigate to the folder you just created and open it.  
* Stub out your projects JPA and MVC project components. This includes all the gradle configuration.
* Create a README.md file that includes:  
  * Your names (or at least usernames).
  * The technologies you want to use.
  * Why you are building the application.
  * The methodologies you are using to build the application (group project, agile etc).
* Once you are satisfied and ready to sync up with the rest of your group, run a `git add .`, `git commit -m 'init commit'`, `git push origin master`. Due to the fact that the GitHub repo is empty, you can't pull before you push in this isolated instance.

### Synchronize environments between team members:
**THESE STEPS ARE FOR THE REMAINING MEMBERS OF THE GROUP THAT DID NOT CARRY OUT THE STEPS ABOVE**
**THEY ARE ALSO PREDICATED ON THE FACT THAT YOU HAVE ALREADY CONFIGURED GRADLE**

* Clone the repository to the location where you want your workspace to live.  `git clone https://github.com/username/repository-name`.  
  * You will need to get the URL from the GitHub repo that was created by your group mate.  
  * Cloning creates a folder with the content from the GitHub repo.  
* Initialize this folder as an STS workspace (open the folder with STS). Choose `File/Switch Workspace/Other` and navigate to the location you cloned the repo. Open that folder as a workspace.
  * The workspace will not be populated with the projects at this point. We need to manually import them.
* In STS choose `File`/`Import`/`Gradle`/`Existing Gradle Project` and click next.
* Find the cloned git repo in the browse feature. Select the MVC project folder to import. Because you already did the gradle config, the JPA project will automatically be brought in as a sub dependency.
* Click Finish
* Now your project is in your STS editor, and you can execute git commands from the same location.
