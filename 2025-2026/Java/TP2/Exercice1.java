package tp2;

import java.util.Arrays;

public class Exercice1 {
    private int[] tab;
    
    //Question 1
    public Exercice1(){
	this.tab = new int[]{120, 350, 200, 500, 175, 90, 300};
	showTab();
    }
    
    //Question 2
    public void showTab(){
	System.out.println(Arrays.toString(tab));
    }
    
    //Question 3
    public int sum(){
	int x = 0;
	for(int i : tab){
	    x += i;
	}
	return x;
    }
    
    //Question 4
    public int min(){
	int x = tab[0]; 
	for(int i : tab){
	    x = (i < x) ? i : x;
	}
	return x;
    }
    
    //Question 5
    public double avg(){
	return sum() / tab.length;
    }
    
    //Question 6
    public void sort(){
	Arrays.sort(tab);
    }
    
    
}
