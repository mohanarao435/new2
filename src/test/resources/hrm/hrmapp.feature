@All
Feature: Test HRM APP
Background:
Given user need to be HRM homepage
@Smoke
Scenario: verify HRM Username Field
When user enter username
Then verify username contains entered text or not
#And close browser
@Sanity
Scenario: verify HRM Password Field
When user enter password "admin123"
Then verify password contains entered text or not
#And close browser
@Smoke @Sanity
Scenario: verify login button functionality with valid data
When user enter hrm username "0"
|Admin|
|xyzz|
When user enter hrm password "0"
|admin123|
|xyzz|
And click on login
Then verify dashboard must open
#And close browser
@Retesting
Scenario: verify login button functionality with invalid data
When user enter hrm username "1"
|Admin|
|xyzz|
When user enter hrm password "1"
|admin123|
|xyzz|
And click on login
Then verify invalid credentials error msg is visible
#And close browser
@Risktesting
Scenario Outline:  verify login button functionality with valid and invalid data
When user enter orange hrm username as "<uname>"
And user enter orange hrm password as "<pass>"
And click on login
Then verify result page must contain either error msg or employeelist url
#And close browser
Examples: 
|uname|pass|
|Admin|admin123|
|Xyz|xyz|
|Admin|admin123|
|Xyz|xyz|
Scenario: forcefully making failed
When verifyoutput
Scenario: forcefully making failed 2
When verifyoutput
