@event
Feature: KidsGroupEvent validation

@event1
Scenario Outline: Verify the Minimum and Maximum Values in the Children input box and Adult drop down list in Book an Event page
Given User enter event location
When User select 90min package
Then Minimum children "<ChildrenMin>" and maximum children "<ChildrenMax>" should be available in dropdown select
Then  Minimum adult "<AdultMin>" and maximum adult "<AdultMax>" should be available in dropdown select

Examples:
|ChildrenMin|ChildrenMax|AdultMin|AdultMax|
|6|199|1|199|

@event2
Scenario Outline: Verify that "Time slots not available" Message displays For Group Event,When number of children increased more than available seats in Book a Group Event page
Given User enter event location
When User select 90min package
Then User enter children number "<num>" more than available seats in store
Then "Time slots not available" Message displays For Group Event

Examples:
|num|
|199|


@event3
Scenario: Verify payment/deposit details should not display while booking a event 
Given User enter event location
And User select package
And User enter number of children, adult attending including party date and time
Then payment/deposit details should not display while booking a event 

@event4
Scenario Outline: Verify the form validation in Group Party/Contact information in Contact information page
Given User is on conatact page
When User enter "<orgName>" "<orgPhone>" "<orgType>" "<adultName>" "<adultEmail>" "<email>" by keeping any one field as blank
Then Error message should be displayed

Examples:
|orgName|orgPhone|orgType|adultName|adultEmail|email|
|YES|YES|NO|YES|YES|YES|
|NO|YES|YES|YES|YES|YES|

@event5
Scenario: Verify user is able to generate Confirmation for Group Event site for 60 min package in Chrome browser for Irving Store
Given User enter event location 
And User select 60minutes package
And User enter number of children, adult attending including party date and time
When User enter organisation and contact details
Then confirmation number for group event should be generated

@event6
Scenario: Verify that duplicate reservations popup displayed before Booking a Group Event
Given User enter event location 
And User select 60minutes package
And User enter number of children, adult attending including party date and time
When User enter organisation info and contact details
Then Confirmation number is generated
When User book an event with same contact details
Then Duplicate popup should be appear


@event7
Scenario: Verify that "Time slots not available" Message displays For Group Event,When edit the number of children/adults increased more than available seats in location and Attendees section
Given User enter event location 
And User select 60minutes package
And User enter number of children, adult attending including party date and time
When User edits the number of children increased more than available seats in location and Attendees section
Then "Time slots not available" Message displays For Group Event



@event8
Scenario Outline: :Verify that the user selected details with an estimated total price of the Event are calculated properly on the Reservation Summary Screen.
Given User enter event location 
And User select "<package>"
And User enter number of "<children>" "<adult>" attending including party date and time
And User select "<package>" and verify price
When User enter organisation and contact details
And Confirmation number is generated
Then Estimated total price of the Event are calculated properly on the Reservation Summary Screen

Examples:
|package|children|adult|
|60min|8|3|

@event9
Scenario: :Verify that user should get the appropriate error message,when user does the overbooking in Payments page
Given User enter event location 
And User select 60minutes package
And User enter number of children, adult attending including party date and time
When user does the overbooking in Contact Information page
Then Appropriate error message should displayed

@event10
Scenario: Verify that user should get the appropriate error message,when user does the overbooking in Reservation Summary Page
Given User enter event location 
And User select 60minutes package
And User enter number of children, adult attending including party date and time
When User enter organisation info and contact details
Then Confirmation number is generated
When User does the overbooking in Reservation Summary Page
Then Appropriate error message should displayed


@event11
Scenario: Verify that the “Send Free Party Invitations” link functionality on the dashboard page
Given User enter event location 
And User select 60minutes package
And User enter number of children, adult attending including party date and time
When User enter organisation and contact details
Then Confirmation number is generated for booking
When User clicks "Send Free Party Invitations" link
Then It should directed to dashboard page

@event12
Scenario: Verify user is able to generate Confirmation for Group Event site for 90 min package in IE 11 browser for Fresno Store
Given User enter event location as Fresno Store
And User select 90min package
And User enter number of children, adult attending including party date and time
When User enter organisation and contact details
Then confirmation number for group event should be generated

@event13
Scenario: Verify that user should not be presented with an upgrade dialog if a lower tier package is selected
Given User enter event location 
And User select 60minutes package
When User enter number of kids and adult attending event
Then Upgrade dialog should not be present