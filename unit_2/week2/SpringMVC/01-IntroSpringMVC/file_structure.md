## File Structure
* A Dynamic Web Project has a specific file structure and it is important where you place certain files.
  
* Consider this example of a Dynamic Web Project's File structure as it is generated by Eclipse:
  
```bash
├── WebContent
│   ├── META-INF
│   │   └── MANIFEST.MF
│   ├── WEB-INF
│   │   ├── Lotto-servlet.xml
│   │   ├── lib
│   │   └── web.xml
│   ├── form.jsp
│   └── index.html
├── build
│   └── classes
├── pom.xml
├── src
│   ├── lotto
│   │   ├── Hopper.java
│   │   └── PingPongBall.java
│   └── web
│       └── LottoController.java
└── target
    ├── classes
    ├── m2e-wtp
    └── test-classes
```
  
* **WebContent**: The `WebContent` directory is aptly named as it is where all of your static web content should reside. This includes things like HTML (or JSP), CSS, JavaScript, and image files.
  
  * **WEB-INF**: Within the `WebContent` directory should be a `WEB-INF`. This is where you should place the `web.xml` and any *DispatcherServlet* files you have.
  
* **src**: The `src` directory should contain your Java packages for your application, this includes an POJOs, Controllers, or DAOs you may create.
  
* **build**, **target**: The `build` and `target` directories house the compiled classes of your application as well as compiled dependency files within your app. Generally speaking, you shouldn't need to alter/modify the content of these directories.

<hr>

[Prev](components_of_spring_mvc.md) | [Up](../README.md) | [Next](dependencies.md)
  
