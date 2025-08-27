Feature: validate login page 
Scenario Outline: Check for valid and invalid credentials 
Given login page should be open in default browser
When click on login button and enter <username1> and <password1>
And click on signin button check <status>
Then login successfully and open home page 
Examples:
|username1|password1|status|
|877676|password|fail|
|username|ngd46|fail|
|jhdkh7565|jkwyidt76|fail|
|username|password|success|


Scenario:

