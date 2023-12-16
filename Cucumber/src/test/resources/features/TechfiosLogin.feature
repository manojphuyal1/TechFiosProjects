
@LoginFeatures @regression 
Feature: Techfios Login functionality validation

Background 
Given User is on codefios loginpage


@Scenerio1, @Smoke
Scenario Outline: User should be able to login with valid creditional

#Given User is on codefios loginpage
When User enters username as "<username>"
When User enters password as "<password>"
When User clicks on signin button
Then User should land on dashboard page

Examples:
|username|password|
|demo1@codefios.com|abc123| 
|demo1@codefios.com|abc1234|




#@Scenerio2, @Smoke
#Scenario: User should be able to login with valid creditional

#//Given User is on codefios login page

#When User enters username as "demo11@codefios.com"
#When User enters password as "abc123"
#When User clicks on signin button
#Then User should land on dashboard page