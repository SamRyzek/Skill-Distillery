# Agile

* *Agile* or *Agile Software Development* are blanket terms that embody any number of Software Development & Project Management strategies.

* Agile is a Project (or Process) Management tool to increase productivity by empowering self-organizing teams to deliver incremental changes to a product over time in a manner that is highly adaptable to changes in product requirements based on both shifting market forces and customer/client feedback.

### Manifesto for Agile Software Development

* http://agilemanifesto.org/

>We are uncovering better ways of developing
software by doing it and helping others do it.
Through this work we have come to value:

>***Individuals and interactions*** over processes and tools

>***Working software*** over comprehensive documentation

>***Customer collaboration*** over contract negotiation

>***Responding to change*** over following a plan

>That is, while there is value in the items on
the right, we value the items on the left more.

### Principles behind the Agile Manifesto

* http://agilemanifesto.org/principles.html

>We follow these principles:

>Our highest priority is to satisfy the customer
through early and continuous delivery
of valuable software.

>Welcome changing requirements, even late in
development. Agile processes harness change for
the customer's competitive advantage.

>Deliver working software frequently, from a
couple of weeks to a couple of months, with a
preference to the shorter timescale.

>Business people and developers must work
together daily throughout the project.

>Build projects around motivated individuals.
Give them the environment and support they need,
and trust them to get the job done.

>The most efficient and effective method of
conveying information to and within a development
team is face-to-face conversation.

>Working software is the primary measure of progress.

>Agile processes promote sustainable development.
The sponsors, developers, and users should be able
to maintain a constant pace indefinitely.

>Continuous attention to technical excellence
and good design enhances agility.

>Simplicity--the art of maximizing the amount
of work not done--is essential.

>The best architectures, requirements, and designs
emerge from self-organizing teams.

>At regular intervals, the team reflects on how
to become more effective, then tunes and adjusts
its behavior accordingly.

# Examples of Agile Strategies / Process Frameworks

![Agile](https://assets.toggl.com/images/software-development-methods-explained-with-cars-toggl-infographic-02.jpg)

### Kanban
* Kanban is a process visualization tool which aims at keeping work focused, highlighting problems before they exist, and encourages incremental changes to occur continuously.

* The five core principles (as much as they can be agreed upon) of Kanban are:

1: Visualize Workflow

  * A board (be it physical or virtual) of columns populated with tasks represented by cards or sticky notes

  * Example:

![Kanban](http://kanbanblog.com/explained/image/kanban-board-2.png)

* Having a publicly visible board gives the team immediate comprehension of the work in progress as well as what work remains to be done. It also assigns ownership of tasks to team members empowering others to take ownership of deciding what task is logically next based on the requirements of remaining tasks.

2: Limit Work In Process (WIP)

* A single team member should never own more than one card, this ensures that incomplete code is not getting stale and tasks which are started are carried to completion, thus limiting wasted time and keeping the team focused on one thing at a time.

3: Manage Flow

* Each task a team completes informs the team on how best to complete and prioritize subsequent tasks. Thus, a team's 'Flow Efficiency' should increase over time.

4: Make Process Policies Explicit

* Limit the likelihood of problems, or misunderstandings by attaching clear definitions of completion to tasks ('Definition of Done'), and giving them 'Acceptance Criteria' which will inform the team of what it takes for that feature to be accepted as a completed component of the application.

5: Improve Collaboratively

* With each iteration/increment of work the team should evaluate their effectiveness and seek to make changes to improve their workflow.

### Lean

![Lean](https://www.researchgate.net/profile/Taghi_Javdani_Gandomani/publication/311322764/figure/fig2/AS:435670750633986@1480883409984/Fig-2-Lean-Thinking-Sequential-Steps-IV-CASE-STUDY-The-company-under-study-was-a.png)

* Lean is a set of Software Development (or Manufacturing) principles summarized below:

1: Eliminate Waste
  * Stick to requirement, don't build non-prioritized features
  * Partially completed code is wasted productivity, focus on tasks that can be finished

2: Build Quality In
  * Practice TDD and Continuous Integration
  * Don't track bugs, avoid adding them
  * Refactor code to improve quality

3: Create Knowledge
  * Get constant feedback by running builds frequently, integrating across features and demoing the product to make sure that requirements are being met correctly

4: Defer Commitment
  * Wait until the last possible moment to make irreversible decisions, this empowers the developers to reject vendor lock in and keep as many options open as possible

5: Deliver Fast
  * Ship code frequently and demo new features as they come online to refine the product in as close to real time as possible

6: Respect People
  * Teams are self-organizing and each team member is empowered to complete their assigned tasks in the manner of their choosing, relying on their technical expertise

7: Optimize the Whole
  * Complete features in a realistic time frame and do not allow 'time crunches' to result in reduced quality
  * Do not sacrifice quality of testing to increase rate of development, code maintainability must be maintained

### Scrum

![Scrum](http://scrumprimer.org/overview/anime_scrum_overview_green.png)

* Scrum is a framework for organizing and managing work, not a strict standardized process to be followed methodically. An individual company's implementation of Scrum should follow certain principles, but may be substantially different than another company's implementation

* Scrum describes 3 roles:

  * ***Product Owner*** :
    * Central point of product leadership
    * Responsible for deciding which features and functionality to build, and in what order they should be prioritized
    * Answers questions about product requirement and collaborates with the Scrum Master and Scrum Team to ensure the team stays on task and on time

  * ***Scrum Master*** :
    * Promotes scrum values, principles and practices
    * Facilitates scrum ceremonies
    * protects the Team from blockers (be they injected requirement from management, or internal team distractions)

  * ***Scrum Team (or just Team)*** :
    * Diverse self-organizing team
    * Determines how tasks are assigned, tracked and completed
    * Collaborates with Product Owner and Scrum Master to complete work during the sprint

* Scrum describes 3 artifacts (maintained documentation):

  * ***Product Backlog*** :
    * A prioritized and ordered list of items which represent features, functionality, or bugs that need to be worked on.
    * The backlog is ever changing and items may be prioritized or deprioritized based on stakeholders feedback, or shifting market forces.

  * ***Sprint Goal*** :
    * Before a new Sprint begins, the Product Owner and Team will review the highest priority items on the the Product Backlog and select some subset of them as a realistically achievable goal to accomplish during the next sprint.

  * ***Sprint Backlog*** :
    * The Team breaks down the Sprint Goal into a set of tasks, these tasks and the Product Backlog items they represent form the Sprint Backlog.

* Scrum describes 5 ceremonies:

  * ***Sprint Planning*** :
    * Members : Product Owner, Team, Scrum Master
    * Team accepts some number of Product Backlog items and refines their Acceptance Criteria and Definition of Done with the Product Owner so that they align to the vision
    * Usually time boxed to 1-4 hours

  * ***Sprint*** :
    * Members : Product Owner, Team, Scrum Master
    * A fixed amount of time during which work will be accomplished.
    * Sprints MUST PRODUCE a potentially shippable product increment that has additional feature set to the previous increment.
    * Sprints last between 1-4 weeks and do not change length. (i.e. if you do 2 week sprints, you only do 2 week sprints)

  * ***Daily Scrum*** :
    * Members : Product Owner (Optional), Team, Scrum Master
    * A once daily 15 minute "stand up" meeting where the team discusses the state of task completion, discusses any blockers and resolves as well as raises any issues.

  * ***Sprint Review*** :
    * Members : Product Owner, Team, Scrum Master, Stakeholders/Customers
    * The Product Owner demos the Sprint's increment to the Stakeholders/Clients.
    * The Scrum Master facilitates the Stakeholders/Clients giving feedback based on the increment to the Team directly.
    * The Product Owner and Team use the feedback to inspect and adapt the product, deepening the usefulness and marketability of the product as well as expediting development by getting constant feedback.
    * This may result in a process of "Product Backlog Refinement" where the backlog has additional items added or altered.

  * ***Sprint Retrospective*** :
    * Members : Product Owner, Team, Scrum Master
    * An *inspect-and-adapt* activity where the Scrum roles come together to refine their processes and discuss how they can be more effective during the next Sprint. Usually time boxed to 1-4 hours.

### Resources
* *[An Example Checklist for ScrumMasters][checklist]*

* *[The Scrum Guide][guide] : The Definitive Guide to Scrum : The Rules of the Game*


[checklist]:http://scrummasterchecklist.org/pdf/ScrumMaster_Checklist_12_unbranded.pdf
[guide]:https://www.scrumguides.org/docs/scrumguide/v2016/2016-Scrum-Guide-US.pdf
