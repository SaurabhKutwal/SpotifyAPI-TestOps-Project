
  Feature: Validate Playlist API services


    Background: Starting Playlist Serivce modules
      Given Create PlaylistService Entity


  #######################################################################################################################

    @PlaylistService
    Scenario: Get the details of given spotify playlist
      Given Name of playlist is <playListName>
      When Make a Get request for playlist details
      Then Verify status code is 200
      And Check the name, id & description of given playlist

      Examples:
        | playListName  |
        | MyPlaylist    |

  #######################################################################################################################

    @PlaylistService
    Scenario: Upadte the details of given spotify playlist
      Given Name of playlist is <playListName>
      When Make a put request for playlist update
      Then Verify status code is 200

      Examples:
        | playListName  |
        | MyPlaylist    |

  #######################################################################################################################

    @PlaylistService
    Scenario: Get full details of the items of a playlist
      Given Name of playlist is <playListName>
      When Make a Get request for playlist tracks
      Then Verify status code is 200
      And check the tracks of playlist

      Examples:
        | playListName  |
        | MyPlaylist    |

  #######################################################################################################################

    @PlaylistService
    Scenario: Add one or more items to a playlist.
      Given Name of playlist is <playListName>
      And Song name is <songName>
      When Make a put request to add tracks to given playlist
      Then Verify status code is 201

    Examples:
      | playListName  | songName       |
      | MyPlaylist    | TainuKhabarNahi |

  #######################################################################################################################

    @PlaylistService
    Scenario: Remove one or more items from a user's playlist.
      Given Name of playlist is <playListName>
      And Song name is <songName>
      When Make a delete request to remove tracks from given playlist
      Then Verify status code is 200

      Examples:
        | playListName  | songName       |
        | MyPlaylist    | TainuKhabarNahi |

  #######################################################################################################################


