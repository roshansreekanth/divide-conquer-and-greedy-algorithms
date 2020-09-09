/**
 * Classical Change making problem with an unlimited amount of coins of each
 * type. <br>
 * Version 2: Selection function with more elaborated policy: First
 * biggest-coin.<br>
 * Depending on the type of coins, it can lead to an optimal solution.<br>
 * The class encapsulates all the functions of the Greedy schema<br>
 */

public class ChangeMaking {

  // ---------------------------------------
  // Constructor
  // ---------------------------------------
  /**
   * Constructor of the class. Do not edit it.
   */
  public ChangeMaking() {
  }

  // -------------------------------------------------------------------
  // 1. selectionFunctionFirstCandidate--> It selects the first candidate
  // -------------------------------------------------------------------
  /**
   * Given a current solution that is not a final solution, this function selects
   * the new candidate to be added to it.<br>
   * The policy followed is very simple: Just pick the first unused item.
   * 
   * @param candidates: The MyList stating whether a candidate has been selected
   *        so far or not.
   * @return: The index of first candidate to be selected.
   */
  public int selectionFunctionFirstCandidate(MyList<Integer> candidates) {
    // -----------------------------
    // SET OF OPS
    // -----------------------------

    // -----------------------------
    // I. SCENARIO IDENTIFICATION
    // -----------------------------

    /*
     * Always picks the first element
     */

    // -----------------------------
    // II. SCENARIO IMPLEMENTATION
    // -----------------------------

    /*
     * Returns 0 as it is the first index
     */

    // -----------------------------
    // Output Variable --> Return FinalValue
    // -----------------------------
    // Retruns an Integer value

    return 0;

  }

  // -------------------------------------------------------------------
  // 1. selectionFunction --> It selects the next candidate to be considered.
  // -------------------------------------------------------------------
  /**
   * Given a current solution that is not a final solution, this function selects
   * the new candidate to be added to it.<br>
   * The policy followed is more elaborated: Pick the best coin according to the
   * objective function of minimizing the number of coins that make the change of
   * the amount.
   * 
   * @param candidates: List of candidates
   * @return: The index of candidate to be selected.
   */

  public int selectionFunctionBestCandidate(MyList<Integer> candidates) {
    // -----------------------------
    // SET OF OPS
    // -----------------------------

    // -----------------------------
    // I. SCENARIO IDENTIFICATION
    // -----------------------------

    /*
     * Scenario 1: The list is empty Scenario 2: The list is not empty
     */

    // -----------------------------
    // II. SCENARIO IMPLEMENTATION
    // -----------------------------

    /*
     * Scenario 1: If the list is empty, there are no more candidates to select, so
     * it returns -1. 
     * Scenario 2: If the list is not empty, the largest value is
     * chosen by looping through the list and storing the index of the largest
     * element in a variable and then returning it.
     */

    // -----------------------------
    // Output Variable --> Return FinalValue
    // -----------------------------
    // Retruns an Integer value based on the scenarios above.

    if (candidates == null || candidates.length() == 0) {
      return -1;
    }

    int largestIndex = 0;
    int largestCandidate = candidates.getElement(0);

    for (int i = 0; i < candidates.length(); i++) {
      int currentCandidate = candidates.getElement(i);
      if (currentCandidate >= largestCandidate) {
        largestCandidate = currentCandidate;
        largestIndex = i;
      }
    }
    return largestIndex;
  }

  // -------------------------------------------------------------------
  // 2. feasibilityTest --> It selects if a candidate can be added to the
  // solution.
  // -------------------------------------------------------------------
  /**
   * Given a current solution and a selected candidate, this function states
   * whether the candidate must be added to the solution or discarded.<br>
   * 
   * @param candidateValue: The value of the candidate coin selected.
   * @param amount: The amount of change we want to generate.
   * @param changeGenerated: The quantity of change we have generated so far.
   * @return: Whether the candidate fits or not into the solution.
   */

  public boolean feasibilityTest(int candidateValue, int amount, int changeGenerated) {
    // -----------------------------
    // SET OF OPS
    // -----------------------------

    // -----------------------------
    // I. SCENARIO IDENTIFICATION
    // -----------------------------

    /*
     * Scenario 1: The feasibility test fails Scenario 2: The feasibility test
     * passes
     */

    // -----------------------------
    // II. SCENARIO IMPLEMENTATION
    // -----------------------------

    /*
     * Scenario 1: If the amount given as change goes over the actual amount, it is
     * not feasible to select the candidate, so false is returned. 
     *  Scenario 2: If some more coins can be given and it doesn't go over 
     * the total amount, some more change can be given, so true is returned.
     */

    // -----------------------------
    // Output Variable --> Return FinalValue
    // -----------------------------
    // Retruns a boolean value based on the scenarios above.

    return candidateValue + changeGenerated <= amount;
  }

  // -------------------------------------------------------------------
  // 5. solutionTest --> It selects if the current solution is the final
  // solution
  // -------------------------------------------------------------------
  /**
   * Given a current solution, this function states whether it is a final solution
   * or it can still be improved.<br>
   * To determine it, it checks whether there is (at least) one item not picked
   * before that fits into the knapsack.
   * 
   * @param nbCandidates: number of candidates that have not been yet selected by
   *        the selection function
   * @return: Whether the current solution is the final solution.
   */
  public boolean solutionTest(MyList<Integer> candidates) {
    //-----------------------------
		//SET OF OPS
		//-----------------------------

    //-----------------------------
		// I. SCENARIO IDENTIFICATION
		//-----------------------------
    
    /* 
      Scenario 1: The list is empty
       Scenario 2: The list is not empty
    */

    //-----------------------------
		// II. SCENARIO IMPLEMENTATION 
		//-----------------------------
    
    /* Scenario 1: If the list is empty, there are no more candidates to select, so all the feasible candidates have been exhausted, so the problem is solved and a true value is returned.
       Scenario 2: If the list is not empty, there are still some candidates to select, so the problem can be run again to solve, and a false value is returned.
    */

    //-----------------------------
		//Output Variable --> Return FinalValue
		//-----------------------------
    // Retruns an boolean value based on the scenarios above.
    return candidates.length() == 0;
  }

  // -------------------------------------------------------------------
  // 4. objectiveFunction --> This function computes the value of the final
  // solution.
  // -------------------------------------------------------------------
  /**
   * Given the final solution to the problem, this function computes its objective
   * function value according to:<br>
   * How many coins are used in the solution.<br>
   * 
   * @param sol: The MyList containing the solution to the problem.
   * @return: The objective function value of such solution.
   */
  public int objectiveFunction(MyList<Integer> sol) {

    //-----------------------------
		// I. IMPLEMENTATION 
		//-----------------------------
    
    /* The function is called from solve() and it returns the length of the solution list when the problem is solved
    */

    //-----------------------------
		//Output Variable --> Return FinalValue
		//-----------------------------
    // Retruns an Integer value based on the scenarios above.
    return sol.length();
  }

  // -------------------------------------------------------------------
  // 5. solve --> This function solves the problem using a greedy algorithm.
  // -------------------------------------------------------------------
  /**
   * Given an instance of the GP1 problem, this function solves it using a greedy
   * algorithm.<br>
   * 
   * @param typeSelectFunc: Type of selection function to choose.
   * @param coinValues: A MyList containing the value of each type of coin
   *        supported.
   * @param amount: The amount of change we want to generate.
   * @return: A MyList containing the amount of coins of each type being selected.
   */
  public MyList<Integer> solve(int typeSelectFunc, MyList<Integer> coinValues, int amount) {
    MyList<Integer> res = new MyDynamicList<Integer>();
    int changeGenerated = 0;

    /* Creates a copy of coinValues so the original list is not destroyed when delete operations
     * are performed
     */
    MyList<Integer> changeableCoinValues = new MyDynamicList<Integer>();
    for (int i = 0; i < coinValues.length(); i++) {
      changeableCoinValues.addElement(i, coinValues.getElement(i));
    }

    int candidateIndex = 0;
    /* Keeps looping while the problem is not solved
    */
    while (!solutionTest(changeableCoinValues)) {

      switch (typeSelectFunc) {
      case 1: /*If the Dummy Selection method is chosen*/
        candidateIndex = selectionFunctionFirstCandidate(changeableCoinValues);
        break;

      case 2: /*If the Largest Selection method is chosen*/
        candidateIndex = selectionFunctionBestCandidate(changeableCoinValues);
        break;

      default:
        return res;
      }

      int candidateValue = changeableCoinValues.getElement(candidateIndex);
      if (feasibilityTest(candidateValue, amount, changeGenerated)) {
        res.addElement(res.length(), candidateValue);
        changeGenerated += candidateValue;
      } else {
        /*If the candidate is unsuitable for the solution, it is removed.*/
        changeableCoinValues.removeElement(candidateIndex);
      }
    }

    for (int i = 0; i < res.length(); i++) {
      System.out.print(res.getElement(i) + " ");
    }
    System.out.println("Coins used: " + objectiveFunction(res));
    return res;
  }
}
