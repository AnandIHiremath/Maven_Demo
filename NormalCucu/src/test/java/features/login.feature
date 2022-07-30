Feature: Test login funcationality

Scenario: Check login is successful with valid credentials
Given browser is open
When user enters username and password 
Then user is navigated to home page
