# This is my another private project where I check my knowledge about API testing. For this purpose I used https://petstore.swagger.io/. 

So far I have managed and created tests for simple CRUD user endpoints.
My goal is to extend those tests for another user endpoints. Also I want to take care of different areas like pet and store endpoints.

# Technologies, tools and methodologies which I used:
- Java programming Language
- Selenium and Maven tools
- OOP methodology
- KISS and DRY programming principles

There are different approchaes for creating dummy data and I choosed 2 of them:
- provide data from excel file (DDT - data driven testing)


Download excel file with users data from: testData\\UsersFile.xlsx. Data should look like this:
![Excel](https://github.com/user-attachments/assets/632dee17-4b5a-4246-91f0-412d66840adf)

You can update users, add more or delete. 
Methods in ExcelUtility class read data from particular row and cell then they pass them in to DataProvider class.
DDTests class has methods which receive data from DataProvider methods
Results:
![ExcelResult](https://github.com/user-attachments/assets/5fe101c3-b077-4674-9584-dfc23e898c53)


- use additional library called Faker library
https://github.com/DiUS/java-faker
User class create new user object and returns data from each method. In EndpointsTests class before each class I create new Faker and new User object, then set particular data.
Results:
![USER](https://github.com/user-attachments/assets/2c5e6ee8-de90-42cd-9b23-d5107272970a)

























