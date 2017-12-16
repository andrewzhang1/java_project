Feature: Customer check BMI value and category
  As a customer,
  I want to check my BMI value and category using my weight and height
 
Scenario: Underweight
  Given the user is on the BMI Calculate page
  When he enters "160" as height
  And he enters "45" as weight
  And he clicks the Calculate button
  Then ensure the bmi category is "Underweight"
  
Scenario: Normal
  Given the user is on the BMI Calculate page
  When he enters "168" as height
  And he enters "70" as weight
  And he clicks the Calculate button
  Then ensure the bmi category is "Normal"