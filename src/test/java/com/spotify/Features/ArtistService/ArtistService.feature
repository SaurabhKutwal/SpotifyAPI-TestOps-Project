

Feature: Validate Artist API services

#######################################################################################################################

  Scenario: Get Spotify catalog information for a single artist identified by their unique Spotify ID.
    Given Artist name is Shreya Ghoshal
    When Make a Get request for info of given artist
    Then Verify status code is 200
    And Check the information

#######################################################################################################################

  Scenario: Get Spotify catalog information about an artist's top tracks by country.
    Given Artist name is Shreya Ghoshal
    When Make a Get request for top tracks of given artist
    Then Verify status code is 200
    And Check the list of tracks

#######################################################################################################################

  Scenario: Get Spotify catalog information about an artist's albums.
    Given Artist name is Shreya Ghoshal
    When Make a Get request for top albums of given artist
    Then Verify status code is 200
    And Check the list of albums

#######################################################################################################################