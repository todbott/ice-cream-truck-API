# ice-cream-truck-API
A virtual ice cream truck, where users can buy ice cream via API calls, and ice cream truck owners can check inventory and profit.  Written in Spring Boot and deployed in the Google App Engine flexible environment.

I wrote the original source code for this project in July of 2021.  At that time, it was a Spring Boot backend API for an e-commerce smartphone app (the front end was written in Typescript and Angular).  The app required the user to log in before making any purchases, so originally, most of the endpoints of the API in this project were 'protected', using Spring Security.  Login and access management was done using JWT (Java Web Tokens).

For this reason, there are many files that exist in this project, but are not actually used by the Ice Cream Truck API (a whole bunch of security-related *.java files, a login controller, files which read and write usernames and passwords to the database, and many others).  Also, the original program was, as I mentioned, a Spring Boot backend API for the smartphone app, but it also had a *.html 'management portal' where admin could log in and add/edit the shop inventory.  For this reason, the project also contains Thymeleaf code for rendering html pages.  Lots of leftover files in here--that's why it might appear complex at first glance.

Happy ice cream buying, thank you for reading!
