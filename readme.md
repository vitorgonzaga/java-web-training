# Servlet training

## Learning

- How write a service servlet that attends methods;
- How to read parameters from client request into servlet;
- Using html forms to send information in post request;
- Understanding the role of model classes or domains that represents the real world;
- How to create dinamic pages using Scriptlets (<% %>) into JSP;
- How to use the RequestDispatcher from HttpServletRequest class to call a JSP from a servlet;
- How to set and get an attribute from request (setAttribute(...) or getAttribute(...)); 
- How to use Expression Language (${ .. }) in JSP
- JSTL is the tags default library and doesn't come with Tomcat. Should to be imported as JAR file or as Maven Dependency;
- JSTL define 4 taglibs, the most important are `core` (flow control) and `fmt` (format):
- We need to import these taglibs in JSP:
  ```
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
  ```
- JSTL and EL (Expression Language) should be used together;
- How to use tags like `c:if`, `c:forEach`, `c:url`;
- from `fmt` I see `fmt:formatDate`;
- JARS file should keep inside `WEB-INF/lib` folder in project;
- When should use redirect by client (response.sendRedirect(path)) instead server;
- The HTTP code used for redirect is 30X (301 or 302);
- The importance of web.xml file;
- what is IOC (Inversion of Control);
- How Tomcat works as servlet container;
- How to initialize Tomcat by command line;
- How to generate WAR file;
- How to deploy this app using another instance of Tomcat.

## Part 2 (branch "part-2")
- Refactor the project to implement the MVC design (Model-View-Controller);
- JSPs are part of View layer, the "UnicaEntradaServlet.java" joined with Actions classes are Controller layer and we have the Empresa class as a Model, with business rules;
- The JSPs files should be in WEB-INF folder and they are called by Controller layer;
- Development of a basic login interface with e-mail and passoword and a User class;
- How to set and get attributes in HttpSession Object that is automatically created by Tomcat;

## 🔗 Links
[![linkedin](https://img.shields.io/badge/linkedin-0A66C2?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/vitorgonzaga/)