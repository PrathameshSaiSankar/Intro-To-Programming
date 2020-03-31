package chuckALuck;

public class Wallet {
	private float Wallet = 0;
	


	public float getWallet() {
		return Wallet;
	}
	
	public void addToWallet(float amount) {
		Wallet =  Wallet + amount;
	}
	
	public void removeFromWallet(float amount) {
		
		Wallet = Wallet - amount;
	}
	}

