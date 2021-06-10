//Ekampreet Kaur

import java.util.ArrayList;

/**
 * AssassinManager that keeps track of who is stalking whom and the history
 * of who killed whom by maintaining two linked lists, a list of players who
 * are currently alive in the "kill ring" and a list of players who are
 * currently dead in the "graveyard".
 *
 * @author YourNameHere
 * @version 1.0
 *
 */
public class AssassinManager {

    /**
     * killRingFront field: reference to the front node of the kill ring
     */
    private AssassinNode killRingFront;

    /**
     * graveyardFront field: reference to the front node of the graveyard (null if empty)
     */
    private AssassinNode graveyardFront;

    /**
     * Initialize a new assassin manager over the given list of people.
     * @param names
     * @throws IllegalArgumentException if the list is null or has a size of 0
     */
    public AssassinManager(ArrayList<String> names) {
        // You receive a list of names (as a parameter).
        // Take the names and build up the kill ring of linked nodes that
        // contains the names in the same order as you received them in
        // the ArrayList. You may assume that the names are non-empty, non-null
        // strings and that there are no duplicates.
        // Note: you receive a list of names as strings. You need to create a new
        // AssassinNode object for each player and put their name into the node
        // and connect the nodes together into a list that killRingFront references.

        // your code goes here
        System.out.println("checking " + names);
        
        for (int i = 0; i < names.size();i++) {
        add(names.get(i));
        }
        }
        
        //add method assassins with 
        //to the end of the kill ring list 
        private void add(String name) {
           if (killRingFront == null) { 
         killRingFront = new AssassinNode(name);
         }
         else {
         AssassinNode current = killRingFront;
         while (current.next != null) {
         current = current.next;
         }
         current.next = new AssassinNode(name);
       }
    }
         
    

    /**
     * Prints the names of the people in the kill ring, one per line, indented
     * by two spaces, as "name is stalking name". The behavior is unspecified if
     * the game is over.
     */
    public void printKillRing() {
                  
     System.out.println("Current kill ring:");
      AssassinNode current = killRingFront;
      while(current != null){
         if(current.next == null){
            System.out.println("\t" + current.name + " is stalking " + killRingFront.name);
         } else {
            System.out.println("\t" + current.name + " is stalking " + current.next.name);            
         }
         current = current.next;
      }
   }
    
    
    

    /**
     * Prints the names of the people in the graveyard, one per line, with each
     * line indented by two spaces, with output of the form "name was killed by
     * name". It should print the names in the opposite of the order in which
     * they were killed (most recently killed first, then next more recently
     * killed, and so on). It should produce no output if the graveyard is empty.
     */
    public void printGraveyard() {
        // your code goes here
        if(!isGameOver()){
         System.out.println("Current graveyard:");
      } else {
         System.out.println("The final graveyard is as follows:");
      }
      
      AssassinNode current = frontOfGraveyard;
      while(current != null){
         if(current.next == null){
            System.out.println("\t" + current.name + " was killed by " + current.killer);
         } else {
            System.out.println("\t" + current.name + " was killed by " + current.killer);            
         }
         current = current.next;
      }
      System.out.println();
    }
        
            }

    /**
     * Checks to see if <code>name</code> is in the current kill ring.
     * @param name name to check
     * @return true if the <code>name</code> is in the kill ring and false otherwise
     */
    public boolean killRingContains(){
      AssassinNode current = frontOfKillRing;
      while(AssassinNode current != null){
         if(current.name.equals(name)){
            return true;
         }
         current = current.next;
      }
      return false;
   }        

    /**
     * Checks to see if <code>name</code> is in the current graveyard.
     * @param name name to check
     * @return true if the <code>name</code> is in the graveyard and false otherwise
     */
    public boolean graveyardContains(String name){
      AssassinNode current = frontOfGraveyard;
      while(current != null){
         if(current.name.equals(name)){
            return true;
         }
         current = current.next;
      }
      return false;
   }
   
    /**
     * Checks to see if the game is over (if the kill ring has only one player
     * remaining).
     * @return true if the game is over and false otherwise
     */
   public boolean gameOver() {
		if(count(killRing) == 1)
		{
			return true;
		}
		return false;
	}
          /**
     * Obtains the name of the winner of the game.
     * @return name of the winner of the game or <code>null</code> if the game
     *         is not over
     */
      public String winner() {
		if(gameOver())
		{
			return killRing.name;
		}
		else
		{
			return null;
		}
		
	   }   
    /**
     * Transfers a player from the kill ring to the front of the graveyard. This
     * operation does not change the relative order of the kill ring. Case is
     * ignored in comparing names.
     * @param name the name of the player to be transferred from the kill ring
     *             to the graveyard
     * @throws IllegalStateException if the game is over
     * @throws IllegalArgumentException if the given name is not part of the kill ring
     */
    