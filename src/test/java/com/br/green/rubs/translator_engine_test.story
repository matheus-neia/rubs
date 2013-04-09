Scenario: Try to translate the term: I am sick
Given a Firefox browser
When a text to be translated is I am sick
Then the translation should be Eu estou doente

Scenario: Try to translate the term: I am sick 2
Given a Firefox browser
When a text to be translated is I am sick
Then the translation should be Estou doente

Scenario: Try to translate the term: I am sick again 3
Given a Firefox browser
When a text to be translated is I am sick again
Then the translation should be Estou doente de novo
