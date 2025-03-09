
Feature: Validate Artist API services

  Background: Starting Artist Serivce modules
    Given Create ArtistService Entity

#######################################################################################################################

  @ArtistService
  Scenario Outline: Get Spotify catalog information for a single artist identified by their unique Spotify ID.
    Given Artist name is <artistName>
    When Make a Get request for info of given artist
    Then Verify status code is 200
    And Check the information

  Examples:
    | artistName  |
    |ShreyaGhoshal|
    |ARRaheman    |
    |HoneySingh   |
    |ArijitSingh  |


#######################################################################################################################

  @ArtistService
  Scenario Outline: Get Spotify catalog information about an artist's top tracks by country.
    Given Artist name is <artistName>
    When Make a Get request for top tracks of given artist
    Then Verify status code is 200
    And Check the list of tracks

  Examples:
      | artistName  |
      |ShreyaGhoshal|
      |ARRaheman    |
      |HoneySingh   |
      |ArijitSingh  |

#######################################################################################################################

  @ArtistService
  Scenario Outline: Get Spotify catalog information about an artist's albums.
    Given Artist name is <artistName>
    When Make a Get request for top albums of given artist
    Then Verify status code is 200
    And Check the list of albums

    Examples:
      | artistName  |
      |ShreyaGhoshal|
      |ARRaheman    |
      |HoneySingh   |
      |ArijitSingh  |

#######################################################################################################################