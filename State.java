//Siraj Mughal

public class State {
	
	String seq;
	State prev;
	
	State(String s) {
		seq = s;
	}


	boolean legal() {
		
		int currPos = this.seq.indexOf("9");            
		
		int prevPos = this.prev.seq.indexOf("9");  
		
		if (currPos - prevPos == -3 || currPos - prevPos == 3)
			return true;
		
		else if (prevPos == 0 || prevPos == 3 || prevPos == 6) {
			if (currPos == prevPos + 1)
				return true;
		}
		else if (prevPos == 2 || prevPos == 5 || prevPos == 8) {
			if (currPos == prevPos - 1)
				return true;
		}
		else if (prevPos == 1 || prevPos == 7) {
			if (currPos == prevPos + 1 || currPos == prevPos - 1)
				return true;
		}
	
		return false;
		}
			
	
	String swap(String sz, int j, int k) {
		String ret = "";
		
		char[] charArray = sz.toCharArray(); 
	
		char temp = charArray[j];
		charArray[j] = charArray[k];
		charArray[k] = temp;
		
		for (int i = 0; i < sz.length(); i++)
			ret += charArray[i];
	
		return ret;
	}
	
	State move(int j, int k) {
		
		State newState = new State(swap(this.seq, j, k));
		
		newState.prev = this;
		
		return newState;
	}
	void display() {
		System.out.println(seq); 
	}

}
