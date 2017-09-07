## Step 0 - Setup

### Overview
Let's set up the local working directory for your site.  You'll edit your pages here, and push them to a Github repository.  Later you'll deploy you site content to a web-accessible server.`

### Steps

1. Create a local working directory.

   ```bash
   mkdir -p ~/SD/HTML/PersonalSite/html/
   ```

2. Start framing out the content.

   ```bash
   cd ~/SD/HTML/PersonalSite/
   touch README.md
   touch html/index.html
   mkdir html/css/ html/images/
   ```

   Directory structure:
   ```
   ~/SD/HTML/
             PersonalSite/                ## Project root, location of local git repo
             PersonalSite/README.md       ## README.md for your Github repo
             PersonalSite/html/           ## Document root of your site content
             PersonalSite/html/index.html ## Your site home page
             PersonalSite/html/css/       ## Your stylesheets will go here
             PersonalSite/html/images/    ## Your images will go here
   ```

3. Initialize and configure local `git` repo.

   ```bash
   cd ~/SD/HTML/PersonalSite/
   git init
   git add .
   git commit -m "Lay out initial site structure"
   ```

4. Set up Github repo for site content. Log into your Github account and select `New repository`.  Name it `PersonalSite`, and do NOT initialize this repository with a README or add a .gitignore or license.  Click `Create repository`.  Copy the "Clone or download" link to the clipboard and set it as your remote `origin` url.  Make sure you can push to your remote repo:

   ```bash
   cd ~/SD/HTML/PersonalSite/
   git remote add origin git@github.com:YOURGITHUBNAMEHERE/PersonalSite.git
   git push origin master
   ```

   Refresh your github repo page and confirm your files are there.


[Up](../README.md) | [Next](../Step1/README.md)
