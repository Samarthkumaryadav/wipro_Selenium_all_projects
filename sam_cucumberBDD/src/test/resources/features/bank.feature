Feature: Check online banking
Scenario: Online banking and statement download
Given zero bank home page should available with
When click on online banking hyperlink then click on online statements
And select savings from dropdownlist then select year and click on statements for downloading
Then Statement downloaded
