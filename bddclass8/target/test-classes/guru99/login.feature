Feature: Customer Login
  As a customer,
  I can log in with valid user id and password
 
Scenario: Valid Login
  Given the user is on the login page
  When he enters %mngr105727% as user id
  And he enters %ytujudu% as password
  And he clicks the Login button
  Then ensure the manager id is %mngr105727%