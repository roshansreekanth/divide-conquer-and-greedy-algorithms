




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
	// 1. recursiveDisplayElements --> Displays all elements of a MyList  
	//-------------------------------------------------------------------	
	/**
	 * Given a concrete MyList, this recursive algorithm displays its elements by screen (if any).
	 * @param m: The MyList we want to display its elements.	  
	 */	
	public void recursiveDisplayElements(MyList<Integer> m){

		//-----------------------------
		// I. SCENARIO IDENTIFICATION
		//-----------------------------
    
    /*Scenario 1: The list is empty
    * Scenario 2: The list is not empty
    */
	
		//-----------------------------
		// II. SCENARIO IMPLEMENTATION 
		//-----------------------------

    /*Scenario 1: If the list is empty it prints
    * a blank line
    *
    * Scenario 2: The first element is stored in
    * a variable and removed from the list. The
    * function is called again and the elements
    * are printed and removed. After all elements
    * are printed, they are added back to the list.
    */
    if(m == null || m.length() == 0)
    {
      System.out.println();
    }
    else
    {
      int e0 = m.getElement(0);
      m.removeElement(0);
      System.out.print(e0);
      recursiveDisplayElements(m);
      m.addElement(0, e0);
    }
					
	}

	//-------------------------------------------------------------------
	// 2. smallerMyList --> Filters all elements in MyList smaller than e
	//-------------------------------------------------------------------	
	/**
	 * The function filters all elements of MyList being smaller than 'e'  
	 * @param m: The MyList we want to check.
	 * @param e: The number 'e' we want to compare each element of MyList to.
	 * @return: The new MyList containing just the elements being smaller than 'e'  
	 */	
	public MyList<Integer> smallerMyList(MyList<Integer> m, int e){
		//-----------------------------
		//Output Variable --> InitialValue
		//-----------------------------
      MyList<Integer> res = new MyDynamicList<Integer>();

    //-----------------------------
		//SET OF OPS
		//-----------------------------

		//-----------------------------
		// I. SCENARIO IDENTIFICATION
		//-----------------------------

    /*Scenario 1: List is empty
    * Scenario 2: List is not empty
    */

    //-----------------------------
		// II. SCENARIO IMPLEMENTATION 
		//-----------------------------

    /*Scenario 1: If the list is empty it returns
    * res (which is initially empty but then takes
    * on the value of the elements recursively called)
    *
    *Scenario 2: The first element is taken from the
    *list, the element is deleted, and the function is *called again. When the base case is reached the 
    *values are compared against the input and the
    *smaller ones are added to the result. 
    */

    if(m.length() == 0)
    {
      return res;
    }
    else
    {
      int e0 = m.getElement(0);
      m.removeElement(0);
      res = smallerMyList(m, e);

      if(e0 < e)
      {
        res.addElement(res.length(), e0);
      }
      
      m.addElement(0, e0);
    }

		//-----------------------------
		//Output Variable --> Return FinalValue
		//-----------------------------		
		return res;	
	}

	//-------------------------------------------------------------------
	// 3. biggerMyList --> Filters all elements in MyList bigger than e
	//-------------------------------------------------------------------	
	/**
	 * The function filters all elements of MyList being bigger than 'e'  
	 * @param m: The MyList we want to check.
	 * @param e: The number 'e' we want to compare each element of MyList to.
	 * @return: The new MyList containing just the elements being bigger or equal than 'e'  
	 */	
	public MyList<Integer> biggerEqualMyList(MyList<Integer> m, int e){
		//-----------------------------
		//Output Variable --> InitialValue
		//-----------------------------
		MyList<Integer> res = new MyDynamicList<Integer>();
    //-----------------------------
		//SET OF OPS
		//-----------------------------

		//-----------------------------
		// I. SCENARIO IDENTIFICATION
		//-----------------------------

    /*Scenario 1: List is empty
    * Scenario 2: List is not empty
    */

    //-----------------------------
		// II. SCENARIO IMPLEMENTATION 
		//-----------------------------

    /*Scenario 1: If the list is empty it returns
    * res (which is initially empty but then takes
    * on the value of the elements recursively called)
    *
    *Scenario 2: The first element is taken from the
    *list, the element is deleted, and the function is *called again. When the base case is reached the 
    *values are compared against the input and the
    *larger ones are added to the result. 
    */
    
    if(m.length() == 0)
    {
      return res;
    }
    else
    {
      int e0 = m.getElement(0);
      m.removeElement(0);

      res = biggerEqualMyList(m, e);

      if(e0 >= e)
      {
        res.addElement(res.length(), e0);
      }
      m.addElement(0, e0);
    }

    return res;
	}
		
	//-------------------------------------------------------------------
	// 3. concatenate --> It concatenates 2 MyList   
	//-------------------------------------------------------------------	
	/**
	 * The function concatenates the content of 2 MyList.   
	 * @param m1: The first MyList.
	 * @param m2: The second MyList.
	 * @return: The new MyList resulting of concatenate the other 2 MyList
	 */	
	public MyList<Integer> concatenate(MyList<Integer> m1, MyList<Integer> m2){
		//-----------------------------
		//Output Variable --> InitialValue
		//-----------------------------
		MyList<Integer> res = null;
    //-----------------------------
		//SET OF OPS
		//-----------------------------

		//-----------------------------
		// I. SCENARIO IDENTIFICATION
		//-----------------------------

    /*Scenario 1: List 1 is empty
    * Scenario 2: List 1 is not empty
    */

    //-----------------------------
		// II. SCENARIO IMPLEMENTATION 
		//-----------------------------

    /*Instead of adding list1 and list2 together, 
     * list2 is tacked on to the end 
    * of list1 to avoid comparing the sizes and 
    * making it more complicated. 
    */
    int size = 0;
    int e0 = 0;
    int auxE = 0;

    if(m1.length() == 0)
    {
      res = new MyDynamicList<Integer>();
      size = m2.length()-1;
      while(size >= 0)
      {
        auxE = m2.getElement(size);
        res.addElement(0, auxE);
        size--;
      }

    }

      else
      {
          int m10 = m1.getElement(0);
          
          m1.removeElement(0);
          //m2.removeElement(0);

          res = concatenate(m1, m2);

          res.addElement(0, m10);
          //res.addElement(0, m20);

          m1.addElement(0, m10);
          //m2.addElement(0, m20);
      }

		return res;	
	}
	
	//-------------------------------------------------------------------
	// 4. quickSort --> Sort a MyList using the method quick sort
	//-------------------------------------------------------------------	
	/**
	 * Given a concrete MyList, it computes a new sorted list using the method Quick Sort.
	 * @param m: The MyList we want to sort.
	 * @return: The new MyList being sorted.	  	  
	 */	  
	public MyList<Integer> quickSort(MyList<Integer> m){
		//-----------------------------
		//Output Variable --> InitialValue
		//-----------------------------
     MyList<Integer> res = new MyDynamicList<Integer>();

		//-----------------------------
		//SET OF OPS
		//-----------------------------

		//-----------------------------
		// I. SCENARIO IDENTIFICATION
		//-----------------------------

    /*Scenario 1: The list has no elements
     *Scenario 2: The list has only one element
     *Scenario 3: The list has more than one element
     */
		//-----------------------------
		// II. SCENARIO IMPLEMENTATION 
		//-----------------------------
    
    /*The first element is picked as the pivot.
    * smallerMyList and biggerEqualMyList splits
    * it in two with the pivot as the anchor. The 
    * smaller and bigger lists are then recursively
    * called and sorted.  The pivobt is added to the
    * end of the smaller list and both the lists are
    * joined using the concatenate function. 
    */
    if (m.length() == 0)
    {
      return res;
    }
    else if(m.length() == 1)
    {
      res.addElement(0,m.getElement(0));
      return res;
    }
    else
    {
      int pivot = m.getElement(0);
      m.removeElement(0);
      MyList<Integer> smallM = smallerMyList(m, pivot);
      smallM = quickSort(smallM);
      MyList<Integer> bigM = biggerEqualMyList(m, pivot);
      bigM = quickSort(bigM);
      bigM.addElement(0, pivot);
      res = concatenate(smallM, bigM);
      
      m.addElement(0, pivot);

		//-----------------------------
		//Output Variable --> Return FinalValue
		//-----------------------------		
      return res;		
    }
		
	}		

}
