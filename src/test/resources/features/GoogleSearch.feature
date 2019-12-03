#Owner : Wboufaden


@Scénario1

  Feature: Recherche

    Scenario: Recherche simple Google
    Given Le navigateur est ouvert
      And "Google" est affichee
    When une recherche du terme "Football" est realisee
    Then verifier la recherche