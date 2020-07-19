Feature: Login to amezon account and search the mobiles, add 3 random mobiles to cart then procced for payment.

	Scenario: Navigate to Login Page.
		Given Amazon Home page.
		When Title of the page is equal to "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in".
		Then Click on the sign in button.
		Then Navigates to the LogIn page.

	Scenario: Login the registered user by username and password.
		Given Amazon login page.
		When Title of the page is equal to "Amazon Sign In".
		Then Enter username.
		And Click on continue button.
		Then Enter password.
		And Click on login button.
		Then Navigate to Home Page.

	Scenario: Search Mobiles and add 3 random mobiles to the cart.
		Given Amazon Home Page.
		When Title of the page contains "Amazon.in".
		Then Enter mobiles in search box.
		And Click on search icon.
		Then Pick 3 random items from the search result.
		Then Navigate to the cart page.

	Scenario: Proceed for checkout(payment).
		Given Amazon cart page.
		When Title of the page is equal to the "Amazon.in Shopping Cart".
		Then Click on procced to checkout buttton.
		Then Click on Delivery to this address button.
		Then Proceed for payment by clicking on continue.
		Then Title of the page is equal to "Preparing your order".





