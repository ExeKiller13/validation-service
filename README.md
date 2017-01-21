# validation-service
***Task***

Write a WebService or jsp page. Users input their email address and password to get registered. Check legitimacy of the email and password.   
Regarding the password rules, please refer to Apple’s password rules (It must satisfy all the following four terms.)
* It must include numbers, letters, uppercase and lowercase letters.
* It can only be visible symbols of ASCII
* The number of letters and numbers in a row must be smaller than 4.(e.g. both 1234 and dcba are not allowed)
* The number of same characters are no more than 3. (e.g. both aaaa and 0000 are not allowed) 

***Solution***

I've realized a Spring REST Service. It have a simple registration form.
My system validate password by different criteria. I used a regular expressions for checking strings.

Used technologies: Spring Framework, Spring MVC, JUnit.
