
public class Model {
	/**
	 * Constructor of the class Model
	 */
	private int winsX = 0, winsO = 0, games = 0, playerNo = 1;
	private int feld[] []=new int[3][3];
	private boolean currentPlayer1;
	
	/**
	 * Constructor of the class Model
	 *
	 */
	public  Model() {
		
	}
	/**
	 * Function that returns if player X wins
	 * @return the wins of player X
	 */
	public int getWinsX() {
		return winsX;
	}
	/**
	 * Function that sets the wins of player X
	 * @param winsX
	 */
	public void setWinsX(int winsX) {
		this.winsX = winsX;
	}
	/**
	 * Function that returns if player O wins
	 * @return the wins of player O
	 */
	public int getWinsO() {
		return winsO;
	}
	/**
	 * Function that sets the wins from player O
	 * @param winsO
	 */
	public void setWinsO(int winsO) {
		this.winsO = winsO;
	}
	/**
	 * Function that returns the played games
	 * @return the played games
	 */
	public int getGames() {
		return games;
	}
	/**
	 * Function that sets the games which were played
	 * @param games 
	 */
	public void setGames(int games) {
		this.games = games;
	}
	/**
	 * Function that returns the gameboard as array
	 * @return the field
	 */
	public int[][] getFeld() {
		return feld;
	}
	/**
	 * Function that sets the gameboard as array
	 * @param feld
	 */
	public void setFeld(int[][] feld) {
		this.feld = feld;
	}
	/**
	 * Function that returns the gameboard on a specific position
	 * @param i X coordinates
	 * @param j O coordinates
	 * @return
	 */
	public int getFeld(int i, int j) {
		return feld[i][j];
	}
	/**
	 * Function that sets the gameboard on a specific position
	 * @param feld it's the field
	 * @param i X coordinates
	 * @param j O coordinates
	 */
	public void setFeld(int feld, int i, int j) {
		this.feld[i][j] = feld;
	}
	/**
	 * Function that returns who is the current player
	 * @return the current player
	 */
	public boolean isCurrentPlayer1() {
		return currentPlayer1;
	}
	/**
	 * Function that sets who is the current player 
	 * @param currentPlayer1 shows the first player
	 */
	public void setCurrentPlayer1(boolean currentPlayer1) {
		this.currentPlayer1 = currentPlayer1;
	}
	/**
	 * @return the playerNo
	 */
	public int getPlayerNo() {
		return playerNo;
	}
	/**
	 * @param playerNo the playerNo to set
	 */
	public void setPlayerNo(int playerNo) {
		this.playerNo = playerNo;
	}
	
}
