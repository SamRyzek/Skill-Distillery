## Introducing the Spring Tool Suite

You've been using Eclipse to develop your Dynamic Web Projects, and importing various Servlet API and Spring/MVC dependencies so you can create JSPs, configure servlets, use Spring annotations, and so on.

Eclipse is designed for extensibility and thousands of developers have contributed plugins and features that make Eclipse more convenient and productive for their particular work - Java Enterprise Edition development, Android app development, C++ development, PHP development, web front-end development, Cloud development, etc.  You can download these components from the Eclipse Marketplace and add them to your installed Eclipse.  You can also download an entire Eclipse IDE pre-bundled for a particular type of software development.

Since we'll continue developing Spring Web projects using MVC and REST, let's take a look at the Spring Tool Suite - an Eclipse bundle fully tricked out for all kinds of Java Spring development.

### Install STS
1. Download the STS bundle from https://spring.io/tools 
2. Extract this `.tar.gz` file and drag `STS.app` to your /Applications folder.
3. You'll probably want to drag `STS.app` to your Dock to create a shortcut.

### Launch STS
1. Launch `STS.app`
2. Set the workspace to: **/Users/_yournamehere_/SD/Java/stsworkspace**

### Configure Tomcat 8.0 Server
1. Servers: Click to create a new server
2. Apache | Tomcat 8.0 Server **Next**
3. Tomcat installation directory: **Browse** to ~/SD/Java/apache-tomcat-8.0.x **Open**
4. **Finish**
5. Double-click on the new server in the Servers view.
6. Overview | Server Locations | **Use Tomcat installation** (second radio button)
7. **Cmd-S** to save, then close the Server Overview page.

### Export Existing Projects from Eclipse
1. Open Eclipse (the original Java EE Eclipse).
2. File | Export | Archive File **Next**
   * *Select All*
   * *Browse* to /Users/_yournamehere_/SD/Java/projects.zip
   * **Finish**

### Turn Off Tomcat Server from Eclipse and Quit Eclipse
1. Servers | Tomcat 8.0 Server on localhost | **Stop**
2. Eclipse | Quit

### Import Existing Projects into STS
1. Open Spring Tool Suite
2. File | Import | General | Existing Projects into Workspace  **Next**
   * Select archive file
   * *Browse* to /Users/_yournamehere_/SD/Java/projects.zip
   * **Finish**

### Copy Working Sets Configuration to STS
1. **Quit STS**
2. Open a terminal.
```bash
cd ~/SD/Java/
cp workspace/.metadata/.plugins/org.eclipse.ui.workbench/workingsets.xml  stsworkspace/.metadata/.plugins/org.eclipse.ui.workbench/workingsets.xml
```
3. Launch `STS.app`
4. Package Explorer menu | Top-Level Elements | Working Sets **Finish**

### Welcome to Spring Tool Suite!
Original copies of your projects are still in your old workspace, which you can still open in JEE Eclipse.

If you had installed any custom plugins or themes in your old Eclipse, just install them again in STS.

[Up](../README.md) | [Next](STSTour.md)
