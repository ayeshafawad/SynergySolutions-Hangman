package Model;

public class Player {
    
    public Integer numOfTries;
    public String playerName;

	public Player() {
		// TODO Auto-generated constructor stub
	}
        public Player(int name) {
            this.setPlayerName(Integer.toString(name));
            //Integer.toString(name)
		// TODO Auto-generated constructor stub
	}
        
        private String secretword;
	public String getSecretword() {
		return secretword;
	}
	public void setSecretword(String secretword) {
		this.secretword = secretword;
	}
        public int getNumOfTries() {
			return numOfTries;
		}
		public void setNumOfTries(int tries) {
			this.numOfTries = tries;
		}
        public String getPlayerName() {
			return playerName;
		}
		public void setPlayerName(String name) {
			this.playerName = name;
		}
}
