package com.java.training.soldiers;

public class Soldiers {

	public static void main(String[] args) {
		
		killSoldiers(100);
	}
	
	
	public static void killSoldiers(int numSoldiers) {
		int arrSoldiers[] = new int[numSoldiers];
		
		for(int i = 0; i<numSoldiers; i++) {
			arrSoldiers[i]=1;//soldiers alive
		}
		
		int sword=0;
		int toKill=sword+1;
		while(numSoldiers>1) {
			
			if(toKill==arrSoldiers.length) {//to restart the loop
				toKill=0;
			}
			
			if(arrSoldiers[toKill]==1 && sword!= toKill) {
				arrSoldiers[toKill]=0;//to kill the soldier
				numSoldiers--;
				if(numSoldiers>1) {
					if(sword<arrSoldiers.length-1) {
						for(int i=sword+1; i<arrSoldiers.length;i++) {
							
							if(arrSoldiers[i]==1) {//To pass the sword to the next one
								sword=i;
								i=arrSoldiers.length;
								toKill=sword+1;
							}else if(i==arrSoldiers.length-1) {//The last one pass the sword to the first
								i=-1;
							}
							
						}
					}
					else if(sword==arrSoldiers.length-1){//To pass the sword if it is at the last position
						sword=0;
						for(int i=sword+1; i<arrSoldiers.length;i++) {
							if(arrSoldiers[i]==1) {
								sword=i;
								i=arrSoldiers.length;
							}
						}
					}
				}
			}else if(arrSoldiers[toKill]==0 || sword== toKill){//To advance to the next soldier alive
				toKill++;
			}
		}
		
		
		int position=1;
		for(int soldier:arrSoldiers) {
			
			if(soldier==1) {
				System.out.println("the last position is: " +position);
			}else {
				position++;
			}
		}
	}
}
