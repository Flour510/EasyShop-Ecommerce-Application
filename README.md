# Welcome to my EasyShop Ecommerce Application 🛍️ 

This is my 3rd and final capstone project for the learning phase of the YearUp program. 

In this repository, you will find Java code that builds an e-commerce application for a company named EasyShop. The website is already operational, but I was responsible for completing the code and fixing bugs through API testing. I used Postman to test application endpoints and validate the logic before adding any new features.

The application was built according to the following specifications:

In the…
### CategoriesController Class:
I implemented the missing code for each method function and added the proper annotations in the controller.

### MySqlCategoriesDao Class:
I wrote the code to implement the functions, as the necessary functions were already defined.

### ProductsController Class:
I tested the search logic to identify and fix bugs. The bugs included accessing products by category, products with a minimum price of 25, and products with a maximum price of 100.

### New Feature:
Once these requirements were met, I proceeded to add a new feature, including a ProfileController Class.

## ProfileController Class
Since this was an additional feature, I began by creating a new class and implementing the GET and PUT methods. 

The ProfileDao and MySqlProfileDao classes already existed to handle profile creation during user registration. I updated these DAO classes to include the getByUserId and update the methods. 

![Screenshot 2024-06-27 at 11 19 24 PM](https://github.com/Flour510/EasyShop-Ecommerce-Application/assets/99916123/6cc56da4-415b-4487-bf30-43c4195bc284)

![Screenshot 2024-06-27 at 11 20 02 PM](https://github.com/Flour510/EasyShop-Ecommerce-Application/assets/99916123/58c40fca-f89f-424d-9dae-a0997c86f44d)

## Interesting Part of the Code:
One piece of code I found particularly interesting to write was the logic for fixing a bug 🪲 in the ProductsController class. This bug took longer to resolve than I anticipated, and I only discovered the solution after seeking help. To fix the updateProduct method, all I had to do was change two words in the try/catch block. It's still surprising to me how minuscule bugs like this can take so much time to identify.  

This is the initial code:

![Screenshot 2024-06-27 at 11 29 58 PM](https://github.com/Flour510/EasyShop-Ecommerce-Application/assets/99916123/a7dd37d1-19c6-429e-8976-40f03473b2cd)

Here is the resolved solution:

![Screenshot 2024-06-27 at 11 30 40 PM](https://github.com/Flour510/EasyShop-Ecommerce-Application/assets/99916123/abb25db6-c83c-4a6b-8b6e-5de7cb8d6ce2)


