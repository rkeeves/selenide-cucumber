Feature: User can add and remove books to/from her collection of books

  Background:
    Given browser is ready

  Scenario: User can add one book to her collection
    Given on Profile view, logged in as user-regular
    When user switches to Book Store view
    When user visits book0 via book table
    When user successfully adds the detailed book to collection
    When user switches to Profile view
    Then user sees only [book0] in book table

  Scenario: User can add two books to her collection
    Given on Profile view, logged in as user-regular
    When user switches to Book Store view
    When user visits book0 via book table
    When user successfully adds the detailed book to collection
    When user goes back to Book Store view from Details
    When user visits book1 via book table
    When user successfully adds the detailed book to collection
    When user switches to Profile view
    Then user sees only [book0, book1] in book table

  Scenario: User can delete a book from her collection
    Given on Profile view, logged in as user-regular
    When user switches to Book Store view
    When user visits book0 via book table
    When user successfully adds the detailed book to collection
    When user switches to Profile view
    When user deletes book0 via book table
    Then user sees only [] in book table

  Scenario: User can add two books to her collection
    Given on Profile view, logged in as user-regular
    When user switches to Book Store view
    When user visits book0 via book table
    When user successfully adds the detailed book to collection
    When user goes back to Book Store view from Details
    When user visits book1 via book table
    When user successfully adds the detailed book to collection
    When user switches to Profile view
    When user deletes book1 via book table
    Then user sees only [book0] in book table