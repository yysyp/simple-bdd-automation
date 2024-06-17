Feature: the version can be retrieved
  Scenario: client makes call to GET /version
    When the client calls /version with 1
    Then the client receives status code of 200
    And the client receives server version Result = 1

