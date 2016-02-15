Feature: Bowling game score calculation

	As a member of the bowling world Championship committee 
	I want to calculate the score of each game
	In order to determine the classification of each player
	
	Scenario Outline: Calculation of bowling game score 
		Given I have a game results sequence <game_results_sequence>
		When I calculate the score
		Then the score should be <score>
		
	Examples:
	| game_results_sequence   |    score   |
	| "--------------------"  |      0     |
	| "11111121111111111111"  |      21    |
	| "-------/------------"  |      10    |
	| "------4/------------"  |      10    |
	| "------4/-----/------"  |      20    |
	| "--------X----------"   |      10    |
	| "------XX----------"    |      30    |
	| "--------4/X--------"   |      30    |
	| "5/5/5/5/5/5/5/5/5/5/5" |      150   |
	| "XXXXXXXXXXXX"          |      300   |
