import java.util.Random;

public class Control {
	Model model;
	View view;
	Random zufall = new Random();
	/** Constructor of the class Control
	 * 
	 * @throws InterruptedException
	 */
	public Control() throws InterruptedException {
		model = new Model();
		view = new View(model, this);
		restart();
	}
	
	/**
	 * Method that returns the Model
	 * @return the model
	 */
	public Model getModel() {
		return model;
	}

	/**
	 * Function that sets the Model
	 * @param model the model to set
	 */
	public void setModel(Model model) {
		this.model = model;
	}

	/**
	 * Function that returns the View
	 * @return the view
	 */
	public View getView() {
		return view;
	}

	/**
	 * Function that sets the View
	 * @param view the view to set
	 */
	public void setView(View view) {
		this.view = view;
	}
	/**
	 * Function that checks if someone wins the game
	 * @return checkWinner
	 */
	public boolean checkWinner() {
		if(calculate() == 11 || calculate() == 12) {
			if(calculate() == 11) model.setWinsX(model.getWinsX()+1);
			if(calculate() == 12) model.setWinsO(model.getWinsO()+1);
			view.setButtonEditable(false);
			return true;
		}
		return false;
	}
	/**
	 * Function that checks the board for a draw
	 * @return
	 */
	public boolean checkDraw() {
		if(calculate() == 1) {
			view.setButtonEditable(false);
			return true;
		}
		return false;
	}
	/**
	 * Function that switches the player after his turn
	 */
  	public void changePlayer() {
  		model.setCurrentPlayer1(!model.isCurrentPlayer1());
  	}
  	/**
  	 * Function that restarts the game
  	 */
  	public void restart() {
  		for(int i = 0; i < 3; i++) {
		  for(int j = 0; j < 3; j++) {
			  model.setFeld(0, i, j);
		  }
  		}
  		handleAI();
  		view.setButtonEditable(true);
  		zufall.nextBoolean();
  		model.setCurrentPlayer1(zufall.nextBoolean());
  		view.update();
  	}
  	private void handleAI() {
  		if((model.getPlayerNo() == 0) || (model.getPlayerNo() == 1 && !model.isCurrentPlayer1())) {
  			
  		}
	}

	/**
  	 * Function that sets the symbols X and O on the chosen fields on the board
  	 * @param x as X
  	 * @param y as O
  	 */
  	public void setField(int x, int y) {
	  
  		if(model.isCurrentPlayer1()) {
  			if(model.getFeld(x, y) == 0){
  				model.setFeld(1, x, y);
  				if(checkWinner())showPopUp();
  		  		if(checkDraw())showPopUp();
  		  		changePlayer();
  		  		view.update();
  			}
  		}else{
  			if(model.getFeld(x, y) == 0) {
  				model.setFeld(2, x, y);
  				if(checkWinner())showPopUp();
  		  		if(checkDraw())showPopUp();
  		  		changePlayer();
  		  		view.update();
  			}
  			
  		}
  		handleAI();
  		
 	}
  	/**
  	 * Function that shows the PopUp
  	 */
  	public void showPopUp() {
  		view.showPopUp();
  	}
  	/**
  	 * Function for calculating which player has won or if it is a draw
  	 * @return the calculation
  	 */
  	public int calculate() {
  		int zwischenFeld[][] = new int[3][3];
  		zwischenFeld = model.getFeld();
  		for(int i = 0; i < 3; i++) {
  			if(zwischenFeld[i][0] == 1 && zwischenFeld[i][1] == 1 && zwischenFeld[i][2] == 1) return 11;
  			if(zwischenFeld[i][0] == 2 && zwischenFeld[i][1] == 2 && zwischenFeld[i][2] == 2) return 12;
  		}
  		for(int i = 0; i < 3; i++) {
  			if(zwischenFeld[0][i] == 1 && zwischenFeld[1][i] == 1 && zwischenFeld[2][i] == 1) return 11;
  			if(zwischenFeld[0][i] == 2 && zwischenFeld[1][i] == 2 && zwischenFeld[2][i] == 2) return 12;
  		}
  		if(zwischenFeld[0][0] == 1 && zwischenFeld[1][1] == 1 && zwischenFeld[2][2] == 1) return 11;
  		if(zwischenFeld[0][0] == 2 && zwischenFeld[1][1] == 2 && zwischenFeld[2][2] == 2) return 12;
  		if(zwischenFeld[2][0] == 1 && zwischenFeld[1][1] == 1 && zwischenFeld[0][2] == 1) return 11;
  		if(zwischenFeld[2][0] == 2 && zwischenFeld[1][1] == 2 && zwischenFeld[0][2] == 2) return 12;
  		
  		for(int i = 0; i < 3; i++) {
  			for(int j = 0; j < 3; j++) {
  				if(zwischenFeld[i][j] == 0)return 0;
  			}
  		}
  		return 1;
  	}
  	/**
  	 * Function for calculating which player has won or if it is a draw
  	 * @return the calculation
  	 */
  	public int calculate(int zwischenFeld[][]) {
  		
  		for(int i = 0; i < 3; i++) {
  			if(zwischenFeld[i][0] == 1 && zwischenFeld[i][1] == 1 && zwischenFeld[i][2] == 1) return 11;
  			if(zwischenFeld[i][0] == 2 && zwischenFeld[i][1] == 2 && zwischenFeld[i][2] == 2) return 12;
  		}
  		for(int i = 0; i < 3; i++) {
  			if(zwischenFeld[0][i] == 1 && zwischenFeld[1][i] == 1 && zwischenFeld[2][i] == 1) return 11;
  			if(zwischenFeld[0][i] == 2 && zwischenFeld[1][i] == 2 && zwischenFeld[2][i] == 2) return 12;
  		}
  		if(zwischenFeld[0][0] == 1 && zwischenFeld[1][1] == 1 && zwischenFeld[2][2] == 1) return 11;
  		if(zwischenFeld[0][0] == 2 && zwischenFeld[1][1] == 2 && zwischenFeld[2][2] == 2) return 12;
  		if(zwischenFeld[2][0] == 1 && zwischenFeld[1][1] == 1 && zwischenFeld[0][2] == 1) return 11;
  		if(zwischenFeld[2][0] == 2 && zwischenFeld[1][1] == 2 && zwischenFeld[0][2] == 2) return 12;
  		
  		for(int i = 0; i < 3; i++) {
  			for(int j = 0; j < 3; j++) {
  				if(zwischenFeld[i][j] == 0)return 0;
  			}
  		}
  		return 1;
  	}
  	/**
	 * @param playerNo the playerNo to set
	 */
	public void setPlayerNo(int playerNo) {
		model.setPlayerNo(playerNo);
	}
  
}