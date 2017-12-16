Feature: Customer Edit Customer
  As a valid branch manager of a bank,
  I should be able to edit customer
 
Scenario: Check Customer
  Given the user has logged in with user id "mngr105727" and password "ytujudu" 
  And the user is on the Edit Customer page
  When he submits "84173" as customer id
  Then ensure the customer name is "andrew"
  And ensure the customer gender is "male"
  And ensure the customer DoB is "1962-09-28"