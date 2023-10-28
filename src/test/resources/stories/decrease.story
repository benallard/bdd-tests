JBehave Story - A decrease test

Meta:

Narrative:
As a user
I want to decrease a counter
So that I can have the counter's value decreased by 1

Scenario: when a user decreases a counter, its value is decreased by 1

Given a counter
And the counter has any integral value
When the user decreases the counter
Then the value of the counter must be 1 less than previous value