##Github Pages
####Overview
Github Pages is a tool maintained by Github that allows you to host a website directly from a Github repository.  
  
While it's features aren't quite as robust as a full server deployment of a project, it allows you to quickly and easily get started building your own web presence. It is also an excellent tool to use when getting started with front-end development as making changes to it are as easy as pushing to a Github repo.  

####Setup
You can follow the instructions at [https://pages.github.com/][ghpages], or the ones below to get up and running.  
  
Step 1:  
* Login to Github  
  
Step 2:  
* Create a new repository.
* Click the green "+New Repository" button.  
![Github Login](../imgs/gh_login.png)  
  
Step 3:  
* Name the repository "<YOUR USERNAME>.github.io"
* Ensure that the repository is public
* Click "Create Repository"  
![Create a repo](../imgs/create_repo.png)

Step 4:  
* Copy the "Quick Setup - ..." URL
* Open a Terminal
* Navigate to your desktop (or where ever you would like to store the repository directory)
* Type `$ git clone https://github.com/SkillDistillery/SkillDistillery.github.io.git` (use your URL instead)
    * This command will copy the directory structure from the github repository to your computer. The copied repository will already have git tracking and will be configured to use the repository you just created as a remote origin.  
![Clone Repository](../imgs/clone_repo.png)  
  
Step 5:  
* Now that you have a local repo, lets create an HTML file to make sure everything worked correctly.
    * Change directory into your repository directory `cd your_repo`
    * `vi index.html`  
![vi index.html](../imgs/cd_repo.png)
* Now you you are in a vi editor looking at a blank html document. Let's go traditional and write 'Hello world!'
    * `<h1>Hello world!</h1>`
    * Save and quit with `:wq`  
![Hello World](../imgs/vi_hello.png)  
  
Step 6:  
* Let's stage, commit and push our changes
    * `git status`
    * `git add index.html`
    * `git commit -m "init commit, hello world"`
    * `git push origin master`  
![Git this](../imgs/git_push.png)  
  
Step 7:  
* Now we can go see the code we pushed on github, go to https://github.com/<YOUR USERNAME>/<YOUR USERNAME>.github.io  
![Repostitory with index.html](../imgs/repo_content.png)  
* As you can see the file we created has been added to our repository on the master branch.
* The coolest part is that if you go to <YOUR USERNAME>.github.io you will see 'Hello world!' deployed live!  
![Hello World!](../imgs/hello_world_pages.png)

    
    


[ghpages]:https://pages.github.com/
