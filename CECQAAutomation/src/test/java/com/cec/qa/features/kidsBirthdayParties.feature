@test
Feature: KidsBirthdayParties

@test1
Scenario: Verify user is able to generate Confirmation for Birthday Party for Star package in Chrome browser for Irving Store
Given User entered location details
When user choose star package
And user enter children adult party date and time
And user enter contact and payment details
Then user verifying confirmation number generated for star booking

@test2
Scenario: Verify that duplicate reservations popup displayed before Booking a Birthday Party
Given User is on the contact and payment info page
When User entered contact and payment details
Then Confirmation number should be generated
When User entered same contact and payment details twice
Then duplicate reservations popup displayed

@test3
Scenario Outline:  Verify the form validation for Birthday Star and Contact Information fields in Contact Information page
Given User is on the contact and payment page
When User entered "<Cname>" "<age>" "<gender>" "<Aname>" "<Phone>" "<email>" "<instore>" keeping any one field as blank
Then alert message should be displayed

Examples:
|Cname|age|gender|Aname|Phone|email|instore|
|NO|YES|YES|YES|YES|YES|YES|
|YES|NO|YES|YES|YES|YES|YES|
|YES|YES|NO|YES|YES|YES|YES|


@test4
Scenario: Verify payment/deposit details do not display while booking a party for a No-Deposit store
Given User select non deposit store location
When User choose star package
And User enter children adult party date and time
Then payment/deposit details do not display in payment page

@test5
Scenario Outline: Verify that user should get the payment options based on store location
Given User select "<store>" location
When User choose star package
And User enter children adult party date and time
Then payment options should be displayed is "<value>"

Examples:
|store|value|
#|IRVING, TX, USA| YES|
|FRESNO, CA, USA| NO|

@test6
Scenario: Verify that "Time slots not available" Message displays for Birthday,When Number Of Children Increased More Than Available Seats in Book a birthday page
Given User entered location details
When User choose star package
When User select maximum children and adult
Then "Time slots not available" Message displays for Birthday


@test7
Scenario Outline: Verify that user should be presented with an upgrade dialog if a lower tier package is selected
Given User entered location details
And User select the  lower "<package>" 
Then selected package should be upgraded to "<upgrade>"

Examples:
|package|upgrade|
|Star|SUPER STAR|
#|SuperStar|MEGA SUPER STAR|



@test8
Scenario: Verify that user can modify the quantity for optional items (up-sells) and verify the items and price in the Additional items section
Given User entered location details
When User choose MegaSuperStar package
And User enter children adult party date and time
And User enter contact and payment details
When User modify the quantity for optional items
Then price and items should be updated;

@test9
Scenario Outline: Verify that the user selected details with the price of items selected,required deposit and an estimated total price of the party are calculated properly On the Reservation Summary Screen.
Given User entered location details
When User choose "<package>"
And User enter number of "<children>" "<adults>" including party date and time details
Then User verify the selected "<package>" price
And User enter contact and payment details
And User add the additional item
Then User verify total price of the party are calculated properly On the Reservation Summary Screen

Examples:
|package|children|adults|
#|Star|10|3|
#|SuperStar|8|4|
|MegaStar|5|2|


@test10
Scenario: Verify that the user is able to modify the Birthday Star information for an existing reservation in in Payments Page
Given User entered location details
When User choose MegaSuperStar package
And User enter children adult party date and time
And User enter contact and payment details
Then ConfirmationNumber will be generated 
When User Edit the Birthday Star information in payments page
Then ConfirmationNumber will be generated
Then cancel the booking

@test11
Scenario: Verify that the user is able to modify the Contact information for an existing reservation in Reservation Summary Page 
Given User entered location details
When User choose MegaSuperStar package
And User enter children adult party date and time
And User enter contact and payment details
Then ConfirmationNumber will be generated
When User modify the Contact information for an existing reservation in Reservation Summary Page 
Then ConfirmationNumber will be generated
Then cancel the booking


@test12
Scenario Outline: Verify that the user is able to modify the Birthday package for an existing reservation in Reservation Summary Page
Given User entered location details
When User choose "<package>"
And User enter children adult party date and time
And User enter contact and payment details
Then ConfirmationNumber will be generated
When User change  selected "<package>" to "<modify>" package
Then User validate the "<modify>" package
Examples:
|package|modify|
|Star|SUPER STAR|
#|SuperStar|MEGA SUPER STAR|
#|MegaStar|SUPER STAR|


@test13
Scenario: Verify that "Time slots not available" Message displays For Birthday,When edit the number of children increased more than available seats in Location and Attendees 
Given User entered location details
When User choose MegaSuperStar package
And User enter children adult party date and time
When User edit the number of children increased more than available seats in Location and Attendees
Then "Time slots not available" Message displays for Birthday

@test14
Scenario Outline: Verify that user should have to acknowledge the in store deposit by clicking on a checkbox
Given User is on the contact and payment info page
When User entered "<Cname>" "<age>" "<gender>" "<Aname>" "<Phone>" "<email>"  and acknowledge the  "<instore>" deposit by clicking on a checkbox 
Then ConfirmationNumber will be generated
Then cancel the booking
Examples:
|Cname|age|gender|Aname|Phone|email|instore|
|YES|YES|YES|YES|YES|YES|YES|


@test15
Scenario: Verify that the “Send Free Party Invitations” link functionality on the dashboard page
Given User entered location details
When user choose star package
And user enter children adult party date and time
And user enter contact and payment details
Then ConfirmationNumber will be generated
When User clicks Send Free Party Invitations link
Then New tab of invitation should be open


@test16
Scenario: Verify user is able to generate Confirmation for Birthday Party for Superstar package in IE 11 browser for Fresno Store
Given User entered location details as Fresno Store
And User choose Superstar package
And User enter number of kids and adult attending for the party
And User enter birthday star info and contact details
Then ConfirmationNumber will be generated


@test17
Scenario Outline: Verify that the package selected in Kids-Birthday-Party Page is highlighted in PackInfo Page

Given User entered location details
When User choose "<package>"
And User enter number of kids and adult attending party
Then Selected "<package>" is highlighted in PackInfo Page
Examples:
|package|
#|STAR|
|SUPER STAR|

@test18
Scenario: Verify user is able to generate Confirmation for Birthday Party for Star package in IE 11 browser Franchise Stores(Tupelo,Ms 38804) with No Upgrade
Given User entered location details as Tupelo,Ms
When user choose star package
And User enter number of kids and adult attending for the party
And user enter contact and payment details
Then ConfirmationNumber will be generated

@test19
Scenario Outline: Verify the Minimum and Maximum Values in the Children and Adult drop down list
Given User entered location details
When User choose star package
Then Minimum children "<ChildrenMin>" and maximum children "<ChildrenMax>" should be available in dropdown select option
Then  Minimum adult "<AdultMin>" and maximum adult "<AdultMax>" should be available in dropdown select option

Examples: 
|ChildrenMin|ChildrenMax|AdultMin|AdultMax|
|4|199|1|199|

@test20
Scenario: Birthday:Verify that user should get the "No available timeslot. Select different date"error message, when user does the overbooking in Payments page
Given User entered location details
When User choose star package
And User enter children adult party date and time
When User does the overbooking in Payments page
Then "Time slots not available" Message displays for Birthday

@test100
Scenario: Verify user is able to generate Confirmation for Birthday Party for MegaSuperStar package in Safari browser for Fresno Store and Verify no Upgrade Popup displayed
Given User entered location details
When User choose MegaSuperStar package
And User enter children adult party date and time
And User enter contact and payment details
Then User verifying confirmation number generated for MegaSuperStar booking




