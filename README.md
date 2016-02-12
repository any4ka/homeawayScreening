#Screening Exercise
Part I – Coding Exercise

##Web Application Test##
Web Browser:
* Chrome

Technology:
* Maven
* Selenium
* TestNG
* Intellij
* Java 1.7

Assumptions:
* Used the search feature of the site since "All Products" page did not have the phone required.
* Multiple implicit waits to make sure that the page had rendered correctly.
* Explicit wait is used to have the overlay properly load.

Bugs:
* When hitting the "Purchase" Button without any information entered, the screen goes back to the shopping cart.
    * Expected Result: Page is to refresh and the errors to appear above the required fields
* The State text box disappears after coming back to the page.
    * Expected Result: text box to be present, while the drop down menu is not working.
    
Scenarios that use the profiles, I was not able to complete them. An email was sent out to toolsqa administrator to ask 
for correct test credentials. I am awaiting on the response. 