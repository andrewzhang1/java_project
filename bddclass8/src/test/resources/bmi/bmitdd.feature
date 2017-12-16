Feature: Customer check BMI value and category
  As a customer,
  I want to check my BMI value and category using my weight and height
 
Scenario Outline: Bmi Check
  Given the user is on the BMI Calculate page
  When he enters "<height>" as height
  And he enters "<weight>" as weight
  And he clicks the Calculate button
  Then ensure the bmi category is "<category>"
  
  Examples: Data
  | height | weight | category |
  | 160 | 45 | Underweight |
  | 168 | 70 | Normal |
  | 181 | 89 | Overweight |
  | 178 | 100 | Obesity |