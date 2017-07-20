##Why Git on Github?
> It's 2013, and there's no way around it: you need to learn how to use GitHub. 

>Why? Because it's a social network that has completely changed the way we work. Having started as a developer's collaborative platform, GitHub is now the largest online storage space of collaborative works that exists in the world. Whether you're interested in participating in this global mind meld or in researching this massive file dump of human knowledge, you need to be here.   
>    - ReadWrite Magazine, [GitHub For Beginners: Don't Get Scared, Get Started][readwritegit]

#### Git  
* [CodeSchool: Try Git!][trygit] --> Highest recommend. Actual hands on with commands.
* [Setup Git!][setup] --> highly recommend
* [Getting Started][gitbasics] --> Official docs  
* [Version Control Overview][versioncontrol] --> read this if you want to know more about why you are doing vc
* [Install Git/Basic Commands][gitvid] --> VIDEO! For the visually inclined
* [Simple Git Guide][simplegit] --> this is a much simpler guide, that walks you through commands (easier to read then the official docs)
* [Lifehacker: How the heck do I use Github?][lifehack] --> simple walkthrough, might be of interest
* [Git Branching Interactive Application][gitbranch] --> slightly more advanced topic. This is about git branch workflow. Strongly recommend going through this tutorial before working with a team and doing workflow...it will be a tremendous help avoiding merge conflicts.

What do you really, absolutely, for reals need to know?
```bash
git init

git remote add origin #url

git status

git add #filename

git commit

git push #source #branch

git fetch #source #branch

git merge #branch

git branch #new_branch_name

git checkout #branch_name
```
If you know how to use all of those, you are crushing life. Here are a few handy dandy things to get out of trouble:
```bash
git log

git reset #options

git remote set-url origin #url
```
This probably seems like a ton of commands, but the reality is that 99.9% of the time you are only using `git add`, `git commit`, and `git push`. The others are either workflow oriented, fixing something your broke, or configuring a new repositiory.

#### Git vs Github
* [Git vs Github for 'Dummies'][gitvgh]
* [Is Git the Same as Github][gitsameasgh]
* [Why Use Github?][whygithub]  

**Key take away**: Git and Github are not the samething, serve different purposes, but share a lot of data. Git is version control, Github is a collaborative, open source, social networking/productivity tool.

#### Github and Open Source  
* [Contributing to Open Source on Github][opensource1]
* [Where can I find Open Source Projects?][opensource2]
* [How to 'fork' a repo][opensource3]
* [Stack Overflow: How to Contribute to Other's Code in Github][opensource4]
* [Guide to Open Source Licenses][opensource5]  

This is a really cool part of Github.  
  
Say you want to get noticed by a company, or show your mastery of a language, or just be a part of the community of developers. How would you do that? Github makes it pretty simple. On Github you can go to a repository, fork the code, update on your local environment, and submit your changes for review via a 'pull request'. Assuming your changes are valuable/valid, the repository owner(s) will review your code, and may even choose to merge you into their project...wait what...that's right, you just contributed to a bigger code base. This probably seems like the most daunting thing in the world. "I don't know anything yet, how could I possibly improve someone else's code", well, your are right and you're wrong. Some apps are going to be way out of your skill range...but that doesn't mean you couldn't update their documentation! If you are trying to learn something (say EmberJS), going through their docs and notice an error, misspelling, unbelievably confusing example etc, fix it, and submit a pull request. Get the ball rolling with something easy, work up to fixing 'real code' later, that will come in time.  
  
**Why would I fix someone else's code for free?**  
  
You are doing it for several reasons. First and most pressing, you are showcasing your ability to step into a codebase, understand what it is doing, fix something and use the proper control flow to submit your fix. That is literally the job you are going to be doing and showing employers that you can do it is priceless. Second, this is a community, building relationships and helping each other out is not only professionally beneficial, but in a saccharine high minded kind of way universally beneficial for all man kind. Third, practice, practice, practice.

#### Github Pages!!!! ---> Get on this.
* [Official Github Pages Docs][ghpages1]
* [Official Github Pages Guide][ghpages2]
* [Additional Guide][ghpages3]  

**What are Github Pages? Why should I 'Get on this'**  
It's a free website that you have a large amount of control over. Your site address will be your Github username.github.io. You can serve static HTML files (super easy), use a blogger tool like Jekyll, or build out a full on application on your own. It's pretty sweet.  

#### A Note about README.md files...  
* [How to write a good readme][readme1]
* [How to write a GREAT readme][readme2]  

Nothing is worse than going to a repository and finding no README...README files tell potential users what the repository contains, how to use it's contents (install/use instructions), might have some configuration notes, discussion of technology used etc... These documents are invaluable, and the better job you do crafting and maintaining your README, the more useable your code will be.

#### How to Write Good Commit Messages  
* [Chris Beam's Article: How to Write a Good Commit Message][goodcommits1]
* [Brief Style Guide][goodcommits2]
* [5 Tips for Writing Good Commits][goodcommits3]  

This is open to some debate. The general consensus seems to be focused around a few points. First, the first line of a commit message should not exceed 50 characters...that said, they should be a fairly descriptive 50 characters which accurately summarize the changes made within the commit. For instance, 'Changed stuff' is a bad commit message, as is 'Fixed bug'. On the other hand, 'Updated user login protocol' and 'Corrected user table schema' are descriptive enough to quickly orient a reader to the work that has been done. Second, commit messages should probably be fairly verbose, lines after the first should encompass more details about the changes made, the issue fixed, and any additional meta data that may be relevant if someone is reviewing what you did. Third...try to answer this question with your message, "why was this change necessary?".

#### The Dreaded Merge Conflict  
* [Git HowTo: Resolve Merge Conflicts][mergecon1]
* [Dealing with Merge Conflicts][mergecon2]  

First and foremost, get excited, you are using version control which means you cannot "break" anything...that said you can render things in a temporarily non-working state by accident...but you can always just roll back the merge and things will be hunky-dory again. Merge conflicts are Git's way of telling us it's confused. If two developers are working on the same file, and change the same line of code differently (even by a single character), git simply won't know who's changes should take precedence. As a result, git flags the differences and explodes noisily to draw your attention to the problem. At first this is annoying, you just want it to work and not have to spend time resolving these 'picky little conflicts', but as you start to realize how important this feature is, you'll grow to appreciate how much of a drama queen git is being. It's much better for you version control tool to fail loudly then quietly.  
  
**TLDR;** Merge conflicts are going to happen, you are going to freak out, squint at the resulting code, and do a bunch of googling. Over time, you'll get faster at resolving them, and adopt work flow that prevents them as much as possible.


[gitbasics]:http://git-scm.com/book/en/v2/Getting-Started-Git-Basics
[readwritegit]:http://readwrite.com/2013/09/30/understanding-github-a-journey-for-beginners-part-1
[setup]:https://help.github.com/articles/set-up-git/
[versioncontrol]:http://skillcrush.com/2013/02/11/version-control/
[gitvgh]:http://skillcrush.com/2013/02/11/version-control/
[gitsameasgh]:http://jahya.net/blog/git-vs-github/
[gitvid]:https://www.youtube.com/watch?v=tRTckrrCME4&list=PLHPcpp4e3JVrR1OCuUAAWLmWEVKok7zAq
[simplegit]:http://rogerdudler.github.io/git-guide/
[lifehack]:http://lifehacker.com/5983680/how-the-heck-do-i-use-github
[trygit]:https://www.codeschool.com/courses/try-git
[gitbranch]:http://pcottle.github.io/learnGitBranching/
[whygithub]:http://kbroman.org/github_tutorial/pages/why.html

[ghpages1]:https://pages.github.com/
[ghpages2]:https://guides.github.com/features/pages/
[ghpages3]:https://www.thinkful.com/learn/a-guide-to-using-github-pages/

[readme1]:http://stackoverflow.com/questions/2304863/how-to-write-a-good-readme
[readme2]:https://robots.thoughtbot.com/how-to-write-a-great-readme

[opensource1]:https://guides.github.com/activities/contributing-to-open-source/
[opensource2]:https://help.github.com/articles/where-can-i-find-open-source-projects-to-work-on/
[opensource3]:https://help.github.com/articles/fork-a-repo/
[opensource4]:http://stackoverflow.com/questions/4384776/how-do-i-contribute-to-others-code-in-github
[opensource5]:http://www.smashingmagazine.com/2010/03/a-short-guide-to-open-source-and-similar-licenses/

[goodcommits1]:http://chris.beams.io/posts/git-commit/
[goodcommits2]:https://github.com/erlang/otp/wiki/Writing-good-commit-messages
[goodcommits3]:https://robots.thoughtbot.com/5-useful-tips-for-a-better-commit-message

[mergecon1]:http://githowto.com/resolving_conflicts
[mergecon2]:http://www.git-tower.com/learn/git/ebook/command-line/advanced-topics/merge-conflicts
