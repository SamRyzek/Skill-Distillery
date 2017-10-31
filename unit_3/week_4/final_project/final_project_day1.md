# Day 1 process

### Creating your project
**A SINGLE GROUP MEMBER SHOULD DO THE FOLLOWING STEPS**
1. Create a Github repository:
  * add group members as collaborators
  * create a README which states:
    * group member names
    * application's intended purpose
    * technologies involved (decide on technologies)
  * create a .gitignore, add:
    * `.DS_Store`
    * `target`
    * `build`
    * `bin`
    * `.metadata`
    * `.gradle`
    * `Servers`
    * `.recommenders`

  * Add your teammates as collaborators. Navigate to `Settings/Collaborators` and enter their usernames in the provided form.  
  * Create new folder on your local machine:  
  * Initialize it as a git repository, `git init`
  * Link the local repo with the github repo you just created `git remote add origin https://github.com/username/repository-name`. The URL at the end will be specific to your GitHub and repo name.

  * In STS choose `File/Switch Workspace/Other`. Navigate to the folder you just created and open it.  
  * Stub out your projects JPA and REST project components. This includes all the gradle configuration.
  # (YOU MUST DO THE FULL GRADLE SETUP BEFORE YOUR'E TEAMMATES CAN SYNCHRONIZE THEIR ENVIRONMENTS!!!!!!!!!!!!!!!!)
  * Create a README.md file that includes:  
    * Your names (or at least usernames).
    * The technologies you want to use.
    * Why you are building the application.
    * The methodologies you are using to build the application (group project, agile etc).
  * Once you are satisfied and ready to sync up with the rest of your group, run a `git add .`, `git commit -m 'init commit'`, `git push origin master`. Due to the fact that the GitHub repo is empty, you can't pull before you push in this isolated instance.


2. Synchronize environments between team members:
**THESE STEPS ARE FOR THE REMAINING MEMBERS OF THE GROUP THAT DID NOT CARRY OUT THE STEPS ABOVE**
**THEY ARE ALSO PREDICATED ON THE FACT THAT YOU HAVE ALREADY CONFIGURED GRADLE**

  * In terminal navigate to a location where you would like your workspace to live. Clone the repository to this location.  `git clone https://github.com/username/repository-name`.  
    * You will need to get the URL from the GitHub repo that was created by your group mate.  
    * Cloning creates a folder with the content from the GitHub repo.  
  * Open this folder as an STS workspace (open the folder with STS) -> Choose `File/Switch Workspace/Other` and navigate to the location you cloned the repo. Open that folder as a workspace.
    * The workspace will not be populated with the projects at this point. We need to manually import them.
  * In STS choose `File`/`Import`/`Gradle`/`Existing Gradle Project` and click next.
  * Find the cloned git repo in the browse feature. Select the REST project folder to import. Because you already did the gradle config, the JPA project will automatically be brought in as a sub dependency.
  * Click Finish
  * Now your project is in your STS editor, and you can execute git commands from the same location.

3. Deploy 'Hello World' to your production environment.
  * this is a smoke test to ensure that your production environment works without the burden of additional logic or dependencies.

4. Configure your production database
  * create any and all database users who will have permission to the database in the production environment.

5. Match your local database configuration to your production database configuration (i.e. same username/password configuration). This is to ensure the user `test@localhost` with password `test` exists both locally and on your AWS environment allowing you to never have to alter your `persistence.xml`.
  * this will aid in development and prevent issues with deployment down the road

6. Determine what comprises the MVP of your application.
  * list the core MVP features and the required components of those features in the README of your Github repository.
  * be extremely clear on what is essential to your MVP vs what is a desired future feature...you MUST complete your MVP by Friday, so err on the side of caution.
  * create a wireframe to keep your team on the same page regarding your applications design.  

7. Setup a kanban (trello or similar)
  * create user stories and features in an icebox that are required for your MVP
  * ensure that team can access kanban and lay down ground rules about communication scope of work to prevent stepping on each others toes.

8. Begin development in earnest
