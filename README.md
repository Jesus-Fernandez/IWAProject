# IWAProject

This is a demo project in order to validate my technical knowledge.
The website is about programming courses and students, students could
attend more than one course.

## Prerequisites

You need to install the following software

+ NodeJS>=8.5.0
+ npm>=4.6.1
+ java 1.8
+ MySQL>=5.7


## Running project

Before runnning the project, go to the terminal (command Prompt cmd in Microsoft Windows). Open MySQL client with a user that can create new users, in advance we know MySQL Server should be running.
```
mysql> create database db_charts; -- Create the new database
mysql> create user 'chartuser'@'localhost' identified by 'admincharts'; -- Creates the user
mysql> grant all on db_charts.* to 'chartuser'@'localhost'; -- Gives all the privileges to the new user on the newly created database
```

Also install http-server package
```
npm install http-server -g
```


In order to run this project, use different cmd windows and go into **executables folder** then type the following instructions:
```
http-server ./dist 7070
```
```
java -jar charts-1.0 7070
```

It´s important that **json folder** has to be next to the **charts-1.0.jar file**
