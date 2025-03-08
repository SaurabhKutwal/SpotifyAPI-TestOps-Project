
  Feature: validate User API service

  #######################################################################################################################

    Scenario: Verify that We get User Profile Details for valid token request
      Given Make a RequestSpecification with correct authorization token
      When Make a Get request for profile
      Then Verify status code is 200
      And Check Name And Id

  #######################################################################################################################

    Scenario: Verify that We get error msg for invalid token request
      Given Make a RequestSpecification with wrong authorization token
      When Make a Get request for profile
      Then Verify status code is 401
      And error msg should be Invalid access token

  #######################################################################################################################

    Scenario: Verifyt that we can Follow artist
      Given Make a RequestSpecification with correct authorization token
      When Make a put request for following artists
      Then Verify status code is 204

  #######################################################################################################################

    Scenario: Verifyt that we can Unfollow artist
      Given Make a RequestSpecification with correct authorization token
      When Make a delete request for unfollowing artists
      Then Verify status code is 204

  #######################################################################################################################

    Scenario: Get the current user's followed artists.
      Given Make a RequestSpecification with correct authorization token
      When Make a Get request for followed artists
      Then Verify status code is 200
      And Verify List of artists

  #######################################################################################################################