# Chris Perry's Individual Project - Brew Day

This repository will hold the content for my Spring 2016 Enteprise Java individual project

## Problem Statement

Home brewers face a common issue.  They're inspired to create a recipe which might originate on a notepad or the back of a bar napkin.  The recipe is then created over a weekend and some notes are scribbled on some scrap paper in the garage.  This project will involve building a web application that will assist with home brewing.  It will help store, retrieve and modify recipes.  It will also contain equipment profiles (kettles, fermenters, etc) and will provide tools for common brewing calculations.

As far as web service integration goes I plan ot utilize existing brewing ingredient databases that are made accessible from the web.  

Potential web services include: 
- [openbeer.db](http://openbeer.github.io)
- [brewerydb.com](http://www.brewerydb.com)

The user interface design will be based upon the free [Start Bootstrap Admin template](http://startbootstrap.com/template-overviews/sb-admin-2/).

Other UIs considered are below:
- [DesignModo.com](http://designmodo.com/flat#buy)
- [Designscrazed.org](http://designscrazed.org/free-html-css3-ui-kits/)
- [Freebiesbug.com](http://freebiesbug.com/code-stuff/html-ui-kits/)
- [Opendesigns.org](http://www.opendesigns.org/design/leather-coffee/)
- [ui-cloud.com](http://ui-cloud.com/free-ui-elements/)

## Project Technologies/Techniques
This project will make extensive use of Hibernate to more easily deal with the numerous one-to-many foreign key relationships present in a data model such as this one (recipes with many lines, ingredients that can be shared across many recipes, etc.)

The site will be hosted on OpenShift and the data will be stored in a MySQL database.

jQuery and the Datatables.net plugin will be used to improve the navigation of the data.  This will serve as the independant research component of the project.  Twitter Bootstrap will also be used to provide a clean, responsive site design.

A few pages will be protected by security for demonstration purposes only.  A future redesign might incorporate more appropriate authentication.

A web service providing a RESTful API and returning a JSON response will be consumed and presented to the user.

Logging will be done via log4j and jUnit will be used for testing.

## Design Documents
- [Data Model](/DesignDocuments/DataModel/brewday_data_model.pdf)
- [Data Model Diagram (simplified)](/DesignDocuments/DataModel/brewday_data_model_diagram.pdf)
- UI Sketches
-- [1](/DesignDocuments/UI_Sketch/UI 1.JPG)
-- [2](/DesignDocuments/UI_Sketch/UI 2.JPG)
-- [3](/DesignDocuments/UI_Sketch/UI 3.JPG)
-- [4](/DesignDocuments/UI_Sketch/UI 4.JPG)

## [Project Plan](ProjectPlan.md)

## [Development Journal](Journal.md)