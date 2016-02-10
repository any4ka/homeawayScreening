#Screening Exercise
Part I – Coding Exercise

##Web Application Test##
Web Browser:
* Chrome

Technology:
* Maven
* Selenium
* TestNG

Assumptions:
* Used the search feature of the site since "All Products" page did not have the phone required.
* Multiple implicit waits to make sure that the page had rendered correctly.
* Explicit wait is used to have the overlay properly load.

Bugs:
1.  When hitting the "Purchase" Button without any information entered, the screen goes back to the shopping cart.
    > Expected Result: Page is to refresh and the errors to appear above the required fields
2. The State text box disappears after coming back to the page.
    > Expected Result: text box to be present, while the drop down menu is not working.