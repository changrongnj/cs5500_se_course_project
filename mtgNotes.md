# Meeting on 05/28 with Alan - Sprint 1 and coding preparation
* Scope
    * time range: 1 month
    * 6 months expectation
    * No UI requirement
* Parameters and Classes
    * Assign those realistic parameters manageable
    * Random generate as few parameters as possible
* Sprint 1
    * focus on the pilot code to generate data
    * go through with Alan next Thursday if possible
    * The techniques generating the code is the way we deliver the product for user needs; the features/parameters of the generated data from codes are the functionality of the code.

# Meeting on May 24, 2020
## Questions (to ask Alan)
* What is the range of data that we need to simulate?
    * Are the users allowed to specify the total date range (assuming no), or
    * Are users only allowed to specify a range inside the data we already simulated?
*	Adrienne mentioned that we are not expected to use statistics for this project.
    * No covariance, regression, correlation, standard deviation, etc. data
    * Is this in line with Alan’s expectations for us?
*	Assumptions while implementing the software:
    * Assume that we can specify the expected number of people per day for a given interval (e.g. in May, all Mondays have 1.0K people on average)
## Discussion Points
* Scope of sprint 1
    * Language: Java to support better OOD practices, Gradle-built.
    * Goal: Using the Class Diagram UML as the base, implement the classes and their relationships to each other for now.
    * Changes:
        * Add a class that contains information about the expected number of people per day (to simulate the data). Similar to a Scheduler
        * Add a class responsible for producing the csv file (View in MVC model)
        * Figure out a suitable way to keep track of Date and Time information.
            * May use the LocalDate class, which contains methods we might be able to take advantage of. Does not contain time information.
            * May create own Date/Time class with simple information that we need. In this case, can move some of the attributes in the Day class into the Date/Time class. 
    * Clarifications
        * For our project, we are allowed(?) to pre-specify the number of people per day for a given interval (e.g. all Mondays in April have 0.8K people)
        * For each day, we want to know the number of shoppers physically present during each hour of the store operation hours. 
            * Idea: Take advantage of the Random class or another simulation class supported by Java to create random visits throughout the store 
            * Should be able to generate more people during a particular hour. 
        * Final write-up:
            * “in this model we assumed <…>”
            * “In our analysis data, we generated…”
            * In the result of our data, we generated this based on what we assume…”
            * Answer the three questions in sprint 1.
* Quality Assurance (not included in sprint 0):
    * Will need to create some tests for the software.
    * Check that the number of people in the Schedule class (can be renamed something else as appropriate) are as expected.
    * Make tests for each of the four methods listed in Day
    * Make tests for additional methods that we may add.
    * Think about exception/edge cases and test for those as well.
    * May need to create custom exception classes as well.

* Outstanding Questions (Implementation/Design)
    * Best way to keep track of date and/or time?
    * The flow of inputs and outputs in our software?
    * What to include in the final csv file?
    * What other design patterns should we incorporate?
        * Consider: Using the Factory pattern for the subclasses of Day.

* Current Tasks
    * Implement the accessory classes (DayOfWeek, Weather, Visits) - Assigned to Andy
    * Implement the Day class (excluding methods) - Assigned to Rong (partially)
    * Implement a Date/Time class (May include LocalDate for the date portion) - Assigned to James (collaborate with Rong)
    * Create small-scaled simulation that includes expected csv output: - Assigned to Rong and James
    * Create test cases - Assigned to Andy (Collaborate with all)
    * Research preexisting simulation packages - Assigned to Rong (collaborate with all)
    * Implement Scheduler model that contains all of the expected number of people per day - Unassigned (may need this for simulation)
    * Implement csv output class - Unassigned (may need this for simulation)
    * Implement the subclass under the Day class - Unassigned


# Meeting on May 17,2020
* User story
    * Add more details
    * Do we need multiple viewpoints? We only have the user of Manager though...
* UML diagram
    * UML diagram types and tool: https://www.lucidchart.com/blog/types-of-UML-diagrams
    * another tool to draw diagram: https://online.visual-paradigm.com/diagrams/features/uml-tool/
* Abstract and requirements
    * need more clarification and help on this.

# Meeting on May 14, 2020
(participation: Qiushi, Rong, Andy, and Alan)
* Given the patten described in the project description, we will simulate the model and fit in the data
* Come up with the roles, and what they want to do
* Select the parameters consistent with the user stories
* Each row is a visit linked with the time parameter, with the date specified.

# Meeting on May 13,2020
(participation: Qiushi, Rong, and Andy)
* What is the input of the technical system? 
    * What the data is available?
         * Does the techical program have the individual shopper data?
    * How will these types of data be provided?
    * Individual shopper details is tracked? such as waiting time, spent in store, time they were at store, were there any events, weather as additional parameters?
* What the expectation of the software?
    * Are we trying to simulate the technical system they installed?
    * Are we trying to simulate the data?
    * Are we trying to develop the software allowing the user to generate the data with specified parameters they prefer?
* Submission of assignment
    * Sprint 0: submit as a group?
    * submit as PDF or URL?


