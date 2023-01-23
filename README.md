# Online Banking System

Problem Description:


The objective of this project is to maintain the accounts and transactions like withdrawing, depositing money, transferring and viewing all the details of transactions. Bank provides account number to the customer for dealing transactions in the bank. An accountant registers a customer using his/her details. 


 ![ER diagram](https://lh6.googleusercontent.com/-zlI1jSs_OL6kSrRsFhgy9kkayJYVFrYHpkw4rPdFpumJNPQSkg4eaL62pywxfeTg6M=w2400)
 
 ![Flow Diagram](https://lh3.googleusercontent.com/XVYCcmag8YyKN2buaDxd0DvbQZECprekYFKKCk1ESynnLjFF1TPv4v_4F03mosNRymc=w2400)


Users of this project are:

1. Accountants
2. Customers


Roles of Accountant are

1. Login using his/her username and password
2. Adding new account for customer
3. Editing already available account
4. Removing the account by using account number
5. Viewing particular account details by giving account number
6. Viewing all the account details
7. Taking care of deposit and withdrawal operations



Roles of Customer are

1. Login using his/her username and password
2. Transfer the money from his account to other account
3. Checking the transaction history


Tables used in this project are:

Customer

It has the following fields:

1. Account Number
2. Name
3. Email
4. Password
5. Phone Number
6. Address
7. Balance

Accountant

It has the following fields:

1. Accountant ID
2. Password
3. Accountant Name

Transactions 

It has the following fields:

1. Transactions ID
2. Account Number
3. Deposit
4. Withdraw
5. Time Of transaction
