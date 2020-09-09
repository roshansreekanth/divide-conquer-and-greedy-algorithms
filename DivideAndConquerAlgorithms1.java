

/**
 * The class contains the Divide and Conquer-based Algorithms we are using. 
 */
public class DivideAndConquerAlgorithms {

	//----------------------------------------------
	// Class constructor
	//----------------------------------------------	
	/**
	 * Constructor of the class. Do not edit it.
	 */
	public DivideAndConquerAlgorithms(){}
		
	//-------------------------------------------------------------------
	// 0. iterativeDisplayElements --> Displays all elements of a MyList 
	//-------------------------------------------------------------------	
	/**
	 * Given a concrete MyList, this iterative algorithm displays its elements by screen (if any).
	 * @param m: The MyList we want to display its elements.	  
	 */	
	public void iterativeDisplayElements(MyList<Integer> m){
		//-----------------------------
		//SET OF OPS
		//-----------------------------

		//-----------------------------
		// I. SCENARIO IDENTIFICATION
		//-----------------------------
		int scenario = 0; 
		
		//Rule 1. MyList is empty
		if (m.length() == 0) 
			scenario = 1;
		//Rule 2. MyList is non-empty
		else
			scenario = 2;

		//-----------------------------
		// II. SCENARIO IMPLEMENTATION 
		//-----------------------------
		switch(scenario){	
				
		//Rule 1. MyList is empty
		case 1: 
			//1. We print the empty message
			System.out.println("Empty MyList");
			
			break;
			
		//Rule 2. MyList is non-empty
		case 2: 
			//1. We print the initial message
			int size = m.length();
			System.out.println("MyList Contains the following " + size + " items: ");
			
			//2. We traverse the items
			for (int i = 0; i < size; i++)
				System.out.println("Item " + i + ": " + m.getElement(i));
			
			break;
	
		}
		
	}

	//-------------------------------------------------------------------
	// 1. maxInt --> Computes the maximum item of MyList 
	//-------------------------------------------------------------------	
	/**
	 * The function computes the maximum item of m (-1 if m is empty). 
	 * @param m: The MyList we want to compute its maximum item.
	 * @return: The maximum item of MyList	  
	 */	
  
	public int maxInt(MyList<Integer> m){
  //-----------------------------
  //SET OF OPS
  //-----------------------------

  //-----------------------------
  // I. SCENARIO IDENTIFICATION
  //-----------------------------

  /*Scenario 1: The list is empty
    Scenario 2: The list is not empty
  */

  //-----------------------------
  // II. SCENARIO IMPLEMENTATION 
  //-----------------------------
  /*Scenario 1: Base case: -1 is returned.
  * Scenario 2: The first element is selected and the removed. The 
  * function is recursively called and compared with the       * previous values. If it is the largest number, it is the
  * final return value.  
  */
    int res;
    if(m.length() == 0)
    {
      return -1;
    }
    else
    {
      int e0 = m.getElement(0);
      m.removeElement(0);
      res = maxInt(m);
      if (e0 > res)
      {
        res = e0;
      }
      m.addElement(0, e0);
    } 
  return res;
  }

	//-------------------------------------------------------------------
	// 2. isReverse --> Computes if MyList is sorted in decreasing order 
	//-------------------------------------------------------------------	
	/**
	 * The function computes whether m is sorted in decreasing order or not.  
	 * @param m: The MyList we want to check.
	 * @return: Whether m is sorted in decreasing order or not.  
	 */	
	public boolean isReverse(MyList<Integer> m){
  //-----------------------------
  //SET OF OPS
  //-----------------------------

  //-----------------------------
  // I. SCENARIO IDENTIFICATION
  //-----------------------------

  /*Scenario 1: The list is empty or has one element
    Scenario 2: The list is not empty
  */

  //-----------------------------
  // II. SCENARIO IMPLEMENTATION 
  //-----------------------------
  /*Scenario 1: Base case: true is returned
  * Scenario 2: If the currently selected element is 
  * greater than the next one, the value of res becomes
  * true and the rest of the elements are compared by
  * recursively calling the function again. If this condition
  * fails even once, res is set to false and is returned.
  */
    boolean res;
    if(m.length() < 2)
    {
      res = true;
    }
    else
    {
      int e0 = m.getElement(0); 
      int e1 = m.getElement(1);

      if(e0 >= e1) 
      {
        m.removeElement(0);
        res = isReverse(m);
        m.addElement(0, e0);
      }
      else
      {
        res = false;
      }
    }
    return res;
	}

	//-------------------------------------------------------------------
	// 3. getNumAppearances --> Computes the amount of times that integer appears in MyList  
	//-------------------------------------------------------------------	
	/**
	 * The function computes the amount of times that the integer n appears in m.   
	 * @param m: The MyList we want to use.
	 * @param n: The number we want to compute its appearances for.
	 * @return: The amount of appearances of n into m  
	 */	
  
  //-----------------------------
  //SET OF OPS
  //-----------------------------

  //-----------------------------
  // I. SCENARIO IDENTIFICATION
  //-----------------------------

  /*Scenario 1: The list is empty
    Scenario 2: The list is not empty
  */

  //-----------------------------
  // II. SCENARIO IMPLEMENTATION 
  //-----------------------------
  /*Scenario 1: Base case: 0 is returned.
  * Scenario 2: The first element is selected and the removed.  
  * If the first element is equal to the given one, 
  * the function is recursively called and 1 is also added
  * to the counter, and the function moves on to the next
  * element. If it is not the same as the give element, nothing
  * is done to the counter and the function is called again to 
  * check the next element (The selected element is deleted
  * first).  
  */
	public int getNumAppearances(MyList<Integer> m, int n)
  {
    int appearances;
    if(m.length() == 0)
    {
      return 0;
    } 

    else
    {
      int e0 = m.getElement(0);
      if(e0 == n)
      {
        m.removeElement(0);
        appearances = 1 + getNumAppearances(m, n);
      }
      else
      {
        m.removeElement(0);
        appearances = getNumAppearances(m, n);
      }
      m.addElement(0, e0);
    }
    return appearances;
  }
	
	//-------------------------------------------------------------------
	// 4. power --> Computes the m-est power of n
	//-------------------------------------------------------------------	
	/**
	 * The function computes n to the power of m.
	 * @param n: The base number.
	 * @param m: The power of n we want to compute
	 * @return: n to the power of m.  
	 */	
  //-----------------------------
  //SET OF OPS
  //-----------------------------

  //-----------------------------
  // I. SCENARIO IDENTIFICATION
  //-----------------------------

  /*Scenario 1: If the exponent is 0
    Scenario 2: If the exponenet is greater than 0
  */

  //-----------------------------
  // II. SCENARIO IMPLEMENTATION 
  //-----------------------------
  /*Scenario 1: Anything to the power 0 is 1, so 1 is returned.
  * The formula result = n * n ^ (m-1) is used, So the exponent
  * is recursively reduced until it reaches 0 and returns a value
  * of 1, like 2^2 = 2^0 + 2^0 + 2^0 + 2^0
  */
	public int power(int n, int m){
		 if(m == 0)
     {
       return 1;
     }
     else
     {
       return power(n , m-1) * n;
     }
	}
	
	//-------------------------------------------------------------------
	// 5. lucas --> Computes the n-est term of the Lucas series
	//-------------------------------------------------------------------	
	/**
	 * The function computes the n-est term of the Lucas series
	 * @param n: The n-est term of the series we want to compute
	 * @return: The term being computed 
	 */	
   //-----------------------------
  //SET OF OPS
  //-----------------------------

  //-----------------------------
  // I. SCENARIO IDENTIFICATION
  //-----------------------------

  /*Scenario 1: The number is less than 2
    Scenario 2: The number is greater than 2
  */

  //-----------------------------
  // II. SCENARIO IMPLEMENTATION 
  //-----------------------------
  /*Scenario 1: Base case is mathematically defined.
  * Scenario 2: The functionis called again so that the previous * element is added to the one before that to give the current   *element.
  */
	public int lucas(int n){
		 
     if(n < 2)
     {
       return n == 1 ? 1 : 2;
     }
     else
     {
       return lucas(n - 1) + lucas(n - 2);
     }
	}

	//-------------------------------------------------------------------
	// 6. drawImage --> Prints a pattern of a given length
	//-------------------------------------------------------------------	
	/**
	 * The function prints prints a pattern of a given length.
	 * *
	 * **
	 * ***
	 * ... 
	 * @param n: The length of the desired pattern
	 */	
   //-----------------------------
  //SET OF OPS
  //-----------------------------

  //-----------------------------
  // I. SCENARIO IDENTIFICATION
  //-----------------------------

  /*Scenario 1: n is 0
   *Scenario 2:n is greater than 0
  */

  //-----------------------------
  // II. SCENARIO IMPLEMENTATION 
  //-----------------------------
  /*Nothing is returned at base case, so the stars can be drawn *in  ascending order (from 1 star to n stars) and a line is
  * drawn. Two seperate functions are used. One to draw the stars
  * and the other to draw the lines.
  */
	public void drawImage(int n)
  {
    if(n == 0)
    {
      return;
    }
    else
    {
      drawImage(n-1);
      System.out.println();
      drawStar(n);
    }
  }

  public void drawStar(int n)
  {
    if(n == 0)
    {
      return;
    }
    else
    {
      System.out.print("*");
      drawStar(n-1);
    }
  }
}



//n = 0 no drawing
//n > 0  drawImage(n - 1)