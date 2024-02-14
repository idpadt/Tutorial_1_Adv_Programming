# ADVANCED PROGRAMMING

## TUTORIAL 1

### Reflection 1

v = applied
x = did not apply 
~ = doesn't feel the need based on project (maybe justified, maybe lazy)

#### Clean Code Principles
- Meaningful names v
- Function v
- Comments v
- Objects v
- Error handling x

I feel using meaningful names and making good functions in not hard. Comments and objects are a little more difficult. Sometimes i don't know if I'm using enough comments or not. And objects you need to understand the code and intricacies much more. Error handling i forgot to do.

#### Secure Coding
- Authentication ~
- Authorization ~
- Input Data Validation x
- Output Data Encoding ~
  For authentication, authorization, and output data encoding, i feel like the principles are too big to implement for a small project like this. For input data validation, i forgot to do too.

### Reflection 2

After writing the unit test, how do you feel?   
->Tired. Very tired. And much more complicated than just simply making the website itself, because I'm thinking of what are the test cases i should add.

How many unit tests should be made in a class?   
-> Enough for any situation. :)

How to make sure that our unit tests are enough to verify our program?  
-> If every part that can go wrong (i.e. error potential) is tested. From no input, to small and complex input, to very very large inputs. Coding is hard.

It would be good if you learned about code coverage.   
Code coverage is a metric that can help you understand how much of your source is tested.   
If you have 100% code coverage, does that mean your code has no bugs or errors?  
-> Most probably? For example, even big companies with large codes and hundreds of talented programmers can still miss some bugs and need to do tests multiple times.


## TUTORIAL 2

### Relfection

1. List the code quality issue(s) that you fixed during the exercise and explain your strategy on fixing them.
Based on SonarCloud Analysis:
- Fix a critical "code smell" that is "define a constant instead of duplication a literal String 3 times"
  A simple but important fix that was overlooked. Just have to make a constant variable.
- Fix a major "code smell" that is "remove commented out code in html"
  Again, something small that was overlooked. Just needed to delete the lines.

2. Look at your CI/CD workflows (GitHub)/pipelines (GitLab). Do you think the current implementation has met the definition of Continuous Integration and Continuous Deployment? Explain the reasons (minimum 3 sentences)!
For now? Absolutely not. Cux i didnt finish the exercise :P
However, if i have completed it, i assume it would met the definition of CI/CD. Because the CI (continuous integration) part is greatly helped by Github actions and SonarCloud.
And the CD (continuous deployment) part is helped by Koyeb. Because i choose to be push based (ie do the CI and CD when i push to the main repository), integrating and deploying my code becomes automated.



