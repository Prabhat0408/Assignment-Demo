Feature: Countdown Timer Feature

Background:
Given Eggmeter timer site is opened and page is loaded

Scenario: validate Eggmeter home page is loaded and user able to start the counter
	When User enters "25" and click Go button
	Then countdown starts on next page-CountdownPage
	Then validate counter starts as per given time in above step
	
	
Scenario: validate Eggmeter counter decreases by one sec with time increment
When User enters "25" and click Go button
Then countdown starts on next page-CountdownPage
Then Remaining time decreases in one-sec increments
