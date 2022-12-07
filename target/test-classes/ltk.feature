Feature: Sign up for Shop LTK

Scenario: User sings up for Shop LTK
  Given user is on "https://www.shopltk.com"
  When user clicks Sign Up button
  And user signs up with email "my.ltk.test@gmail.com" and "password123" as password
  Then user is redirected to the discover page

Scenario: User is navigating the Shop LTK
  Given user is signed up
  When user selects the Shop navigation menu
  Then user is presented with the styles categories