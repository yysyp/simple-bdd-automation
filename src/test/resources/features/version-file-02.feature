Feature: the version can be retrieved
  Scenario Outline: client makes call to GET /version outline
    When the client calls /version with <num>
    Then the client receives status code of <code>
    And the client receives server version <version>
    Examples:
      | num | code | version    |
      | 1   | 200  | Result = 1 |
      | 0   | 200  | / by zero  |

