Feature:a cucumber assignment

  Scenario: create a user and login with right username and password

    Given create a user
    Then login user with right username and passsword

  Scenario: create a user with and login with wrong username and password

    Given create a user
    Then login user with wrong username and password

  Scenario: create many user then login them and delete them

    Given create many users
    Then login users
    Then delete users

  Scenario: create a user and update the mail adress and then get the updated user

    Given create a user
    Then update user mail adress
    Then get the updated user