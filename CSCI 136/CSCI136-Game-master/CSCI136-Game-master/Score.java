/**************************
 * Names: Beau Goldberg & Kellen Donahue
 * Date: 3/9/2018
 * Function: Keeps Score
 * ************************
 */

public class Score {
	
	//Attributes
	Score Score = new Score(0,0,0);
	private int score;
	private int highScore=0, highScore2=0, highScore3=0;
	private String finalscores;
	
	
	//Methods
	public Score(int highScore, int highScore2,int highScore3)
	{
		this.highScore = highScore;
		this.highScore2 = highScore2;
		this.highScore3 = highScore3;
	}
	
	//Updates score when player runs into an object 
	public int updateScore()
	{
		return score++;
	}
	
	public String HighScore()
	{
		if (score > highScore3 && score > highScore2 && score > highScore)
		{
			this.highScore3 = this.highScore2;
			this.highScore2 = this.highScore;
			this.highScore = score;
			finalscores = "<html><body> Congrats! You Got A High Score!" + "<br>" + "Your Score was: " + score + "<br>" +
							Score.toString();
		}
		else if (score > highScore3 && score > highScore2 && score < highScore)
		{
			this.highScore3 = this.highScore2;
			this.highScore2 = score;
			finalscores = "<html><body> Congrats! You Got A High Score!" + "<br>" + "Your Score was: " + score + "<br>" +
							Score.toString();
		}
		else if (score > highScore3 && score < highScore2 && score < highScore)
		{
			this.highScore3 = score;
			finalscores = "<html><body> Congrats! You Got A High Score!" + "<br>" + "Your Score was: " + score + "<br>" +
							Score.toString();
		}
		else 
		{
			finalscores = "Your Score was: " + score;
		}
	return finalscores;
	}
	
	public String toString()
	{
		return "<html><body> HIGHSCORE 1: " + highScore + "<br>" +
				"HIGHSCORE 2: " + highScore2 + "<br>" + 
				"HIGHSCORE 3: " + highScore3 + "<body><html>";
	}

}

