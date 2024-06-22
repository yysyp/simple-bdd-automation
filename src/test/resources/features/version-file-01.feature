Feature: the version can be retrieved
  Scenario: client makes call to GET /version
    When Get random value equals 9
    Then the client receives status code of 200


