# Testing ToolsQA's Book Store

This project contains tests for ToolsQA's book store app.

## Overview

This small project is for learning purposes only.
> It contains several red flags and anti-patterns. These will be addressed in the next section of this document.

The main goal of this project is to try out cucumber and some of its intermediate-level features.

I made a list of features that I'm interested in as a developer/tester.

I want to be able to:

1. write test specification using gherkin,
2. use keywords (aliases for constants) in gherkin instead of cluttering the scenarios with literals,
3. resolve keywords based on environment (e.g. my local server and remote test server has different admin accounts etc.),
4. not reinstantiate stateless objects between scenarios,
5. set the environment simply via maven profile.

## Red Flags

### Scenario setup and teardown via graphical browser interaction

The project has a number of testing and software development anti-patterns.

The most troubling of all is that the non-idempotent tests rely on a cleanup done via Selenium.
This was intentional, because I wanted to model a scenario,
where I have to test an application with the following qualities:

- the app is monolithic
- the app's layers are tightly coupled (e.g. views directly interact with entity manager, 2000s style)
- the app comes with burned in users, and you must use those in tests
- the app is tested in multiple environments (e.g. dev's local machine, company's test server, client's test server)
- different environments come with different burned in users and data
- the app can be interacted with only via graphical browser interaction, no REST no SOAP
- test setup and teardown can only be done via graphical browser interaction, no REST no SOAP

Due to these limitations, I didn't use DemoQA's REST to setup and teardown tests.

### Bad things happen under src/main

This is simply a failure on my part. I know that this is a big *no-no*, but in the real-life project I'm working on 
is configured via maven profiles.
In my case I needed to load different configurations based on spring profile.
Due to time constraints I choose the route of the least resistance, so I just ...ed spring's whole design and made this
frankenstein.

### Manually parsing of comma separated list of words

I'm talking about BookGherkinConverter::books.
It is error-prone due to directly indexing into a String.
Most importantly, it doesn't provide a good regex pattern for the user writing in gherkin because it matches everything.
I simply didn't have the time.

### Page objects

The currently used classes are not really page objects.
Once again: due to time constraints I had to code them fast.
But they achieved what I wanted: they are stateless.

### Features

I'm pretty new to feature files, so I'm experimenting with the scenarios' granularity.
One hand scenarios must be short, which means that stepdef methods should contain more lines of code.
On the other hand scenarios must not be vague, which means that stepdef methods should contain less lines of code.
So I have to try to find a balance between insanely long gherkin scenarios and insanely long stepdef method bodies.
It's a tough thing to do (at least for me)... but [I'm trying](https://youtu.be/mvy4YH9--Vw?t=472)

### Unused classes in io.github.rkeeves.bookstore.profilebasedgreet... Code smell?!

I wanted to demonstrate auto-config because some services in the real life app should be modeled this way.
On the other hand I wasn't able to come up with a use case for such feature in this bookstore app.
I left the classes in the project, because they still demonstrate that it can be done.
