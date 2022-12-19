# cs320-project1
- How can I ensure that my code, program, or software is functional and secure?
Functional and secure have two different inputs for enabling them inside of code.  To make your code functional, it is imperative that good
tests be written to accurately test the functioning of the software. Simply being able to compile the binary successfully does not guarantee
that the code will be functional for an end user or business function. Writing tests first and then coding to those tests, otherwise known as
test driven development ensures that the program will function as intended. These may include white-box or black-box tests to fully exercise
all methods, variables, and lines of code in a particular class being tested. This is called the coverage of a particular group of tests and
the code coverage should be as high as possible.
Making code secure involves a different set of testing tools which can ensure that secure best practices are being followed and that the 
end code doesn't have any remaining known vulnerabilities. These are typically static testing tools and can be run against the code even 
before the code has been compiled. This allows security issues to be discovered very early on.

- How do I interpret user needs and incorporate them into a program?
The user needs are incorporated into the program in the form of requirements. The requirements are set in place early on in the development
process. The requirements can be coded directly into tests which ensure that the requirements make it into the final code. If the tests don't
pass successfully then the code won't be able to be promoted into production or higher level environments.

- How do I approach designing software?
There are many approaches to designing well functioning, anti-fragile, secure, and user delighting software. It all starts though with
understanding the business need and the customer requirements. Even the best performing most beautiful piece of software that doesn't address
a specific business need and the needs of the customers it serves will not have a great chance of being succesful in the long term. 
Given the importance of these two needs, the business and the customer, is why testing is so important. It ensures that these two critical
needs are met even through code changes and refactoring.
