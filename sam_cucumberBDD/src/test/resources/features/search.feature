Feature: search feature
Scenario Outline: check search feature
Given login user and search button available
When Enter item and then use keyboard enter key
Then List of output relevant to input
Examples:
|item|
|online banking|
|transfer funds|