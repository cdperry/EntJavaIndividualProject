# Journal


## Week 1

01/18/2016

Tasks Completed:

- Got caught up on week 1 readings
- Set up my environment (IntelliJ, Git, OpenShift, MySQL, TomEE+)
- Performed week 1 activities in-class to further familiarize myself with Git and IntelliJ
- Started noodling on an idea for a project

I'm thinking about creating a Java app that will let me store and retrieve information about home brewing (receipes, equipment setup, common calculations, etc.)  At this point I'm still trying to figure out how a web service could be integrated into a project such as this.


## Week 2

01/25/2016

Tasks Completed:

- Got caught up on week 2 readings
- Completed week 2 exercises.  Found 'SantaInAnElevator' to be interesting, had a hard time with the Unit Testing exercises.  Thinking of
negative tests was a bit difficult.
- Solidified project idea and came up with paper mock-ups for the user interface.


## Week 3

02/01/2016

Tasks Completed: 

- Got caught up on week 3 readings
- Completed the SQL DAO and Hibernate DAO exercises
- Haven't started my project yet.  Definitely finding that this course is much more time-intensive than the previous two courses in the certificate program.
- Need to start moving on the project - at this point finding time to work on the readings, the exercises and the project is running counter to the fact that I'm leaving my current job and starting a new one (finishing up major projects and trying to get things in order before I leave)  Hoping the noise settles after 2/22 when I start the new gig.


## Week 4

02/08/2016

- Started researching a UI HTML/CSS template for my project
- Started looking at Bootstrap

## Week 5

02/15/2016

- Completed readings and exercises
- Started building a template .JSP page for my project which involved deconstructing a bootstrap template into its constituent components, removing the pieces I didn't need and testing to make sure that the page display displayed properly.
- Wasn't able to focus too much on the course as I was completing an SAP BusinessObjects upgrade for my employer.  Ended up spending the entire weekend performing the upgrade and dealing with issues stemming from the upgrade.  So much for testing ...

## Week 6

02/22/2016
- Completed readings
- Started a new job with the Department of Children and Families (State of Wisconsin)
- Wasn't able to attend class on 2/24 due to a late-running meeting at the new job
- Completed exercises and caught up on in-class materials over the weekend

## Week 7

02/29/2016
- Completed readings and in-class exercises
- Completed Bootstrap presentation for the first half of the class (Extracurriculars)
- Started working on a project plan which I am very behind on
- Wrote up the problem statement for our team project (Fat Yeti - Snow Depth Web Service)
- Started sketching out the database design for the project, creating the DAOs and connecting the bits and pieces of the project together
- Need to make sure I have some things to show for the code review next week

## Week 8

03/07/2016
- Completed readings, attended class and completed in-class exercises
- Code review

## Week 8.5
- Spring Break!  Didn't go to Mexico ...

## Week 9

03/21/2016
- Completed readings, missed class due to work

## Week 10

03/28/2016
- Completed readings, attended class and completed in-class exercises
- Worked on team project (FatYeti), got frustrated by RESTful web services.
- Started using Maven for the team project as it greatly simplified managing dependencies.

## Week 11

04/04/2016
- Completed readings, attended class and completed in-class exercises
- Worked on team project (FatYeti). No longer frustrated by RESTful web services thanks to the Jackson demo.

## Week 12

04/11/2016
- Completed readings, attended class and completed in-class exercises
- Completed team project (FatYeti)
- Decided that I'll be doing another research topic for my second extracurricular presentation.  There are a number of tutorials that I have found online (free) and through Udemy (paid) that will be helpful for this.

## Week 13

04/18/2016
- The calendar shows I've got about a month left.  While the entity/persistence (DAO) and DAO testing are pretty much done I have not made adequate progress on the controller portion.  I need to get moving on that.
- continued learning about design patterns for my second extracurricular presentation

## Week 14

04/25/2016
- Continuing to make progress on the UI, starting to dabble a bit in jQuery to help with modals.  I was having trouble getting JSP variables into my modal based on selected table rows.  Using HTML data-* attributes and jQuery I was able to get past this issue. 
- Continued work on controllers and the persistence layer
- Did my second extracurricular presentation on design patterns

## Week 14

04/25/2016
- Starting to feel the pressure - there are only three weeks left to get this done.
- Mr. or Mrs. Mkyong are a life-saver.  Their website ([www.mkyong.com](http://www.mkyong.com)) provides a treasure trove of Java + Hibernate materials.  This has been really helpful for getting the one-to-one, one-to-many and many-to-one relationships working with the XML hibernate configuration.  People seem to be using the Hibernate annotations more these days, maybe something to investigate in the future
- UI is coming along.  Still mad at myself for creating such a complicated data model (and thus necessitating a bajillion controllers)
- Final code review

## Week 15

05/02/2016
- Due to time constraints I won't be able to incorporate the openbeer.db or brewerydb.com web services.  That'll have to wait until version 2.0.  Instead I'll be displaying a random Chuck Norris joke on the front page of my application because, as everyone knows, we all love a good Chuck Norris joke.  There is a site that provides the jokes via REST and returning the response as JSON - [http://www.icndb.com](http://www.icndb.com).  Good stuff.
- Wrapping up the UI by incorporating jQuery and Datatables.net to make things all nice and pretty.

## Week 16

05/09/2016
- This is the final push
- OpenShift proved to be quite challenging to work with.  I found that when I pushed my project to OpenShift while it was still deployed the Git deploy process would not fully un-deploy my application.  This caused a lot of frustration as my servlets simply wouldn't respond.  The solution was to use the Tomcat Manager to manually un-deploy my app before re-deploying via Git.
- Authentication also proved more complicated than necessary.  I found that the MySQL library was not included in the DIY Tomcat configuration so that needed to be added.  Once that was in place I found tha MySQL was case-sensitive when it came to table names (but not column names ...)  Between the two of these issues I spent many hours trying to get authentication to work, truly a frustrating experience.  Logging was helpful, as was Stack Exchange.
- Of course I'm having trouble with my web service.  The hosting provider that hosts my Chuck Norris jokes site sends an HTTP 403 (Forbidden) response when accessing the API from OpenShift; it works fine locally.  I tried finding some free proxies to use for the demo but didn't have any luck. I'll just demo that part locally and show the (funny?) error message on OpenShift.


