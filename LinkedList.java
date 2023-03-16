/**
// Assignment #: 10
//         Name: Takahiro Wada
//    StudentID: 1216601204
// Lecture Time: MWF 9:05 - 9:55AM
//  Description: A linked list is a sequence of nodes with efficient
   element insertion and removal. This class
   contains a subset of the methods of the standard
   java.util.LinkedList class.
*/

import java.util.NoSuchElementException;
//import java.util.LinkedList;

public class LinkedList
{
   /**
      Constructs an empty linked list.
   */
   public LinkedList()
   {
      first = null;
   }

   /**
      Returns the first element in the linked list.
      @return the first element in the linked list
   */
   public Object getFirst()
   {
      if (first == null)
         throw new NoSuchElementException();
      return first.data;
   }

   /**
      Removes the first element in the linked list.
      @return the removed element
   */
   public Object removeFirst()
   {
      if (first == null)
         throw new NoSuchElementException();
      Object element = first.data;
      first = first.next;
      return element;
   }

   /**
      Adds an element to the front of the linked list.
      @param element the element to add
   */
   public void addFirst(Object element)
   {
      Node newNode = new Node();
      newNode.data = element;
      newNode.next = first;
      first = newNode;
   }



  public void add(int index, Object element)
  {
        ListIterator iterator = listIterator();
        int count = 0;
        int currentSize = size();
        if(index < 0 || index > currentSize)
        {
            IndexOutOfBoundsException ex = new IndexOutOfBoundsException();
            throw ex;
         }

         while(count <= currentSize)
         {
  	      if(count == index)
  	      {
  		   iterator.add(element);
  		   return;
  	       }
  	       count ++;
  	       iterator.next();

         }//end while loop

}//end method

   /*************** Add your methods here *******************************/
   
  //get method gets the element at the parameter
  //index in the linked list. If the index is out of bounds,
  //then it throws an exception.
  public Object get(int index)     
   {
      String output = null; 	//String to return the element at index
      try
         {
         LinkedListIterator listIterator = new LinkedListIterator();  	    
         listIterator.position = first;     		//Set to the front
         for(int i = 0; i < index; i++)		//For loop to interate until we reach to the desired index
         {
            listIterator.next(); 		
         }
         output = (String) listIterator.position.data; 		//output is set to the element at index
         }	
         catch(IndexOutOfBoundsException e)
         {
            System.out.println("The index is out of bounds\n");
         }
         return output;		//returns element at index


   }

   //remove method removes the element at the parameter
   //index in the linked list. If the index is out of bounds,
   //then it throws an exception.
   public Object remove(int index)
    {
         String output = null;
         try
         {
            LinkedListIterator listIterator = new LinkedListIterator();
            listIterator.position = first;		//set to the front
            for(int i = 0; i < index; i++)		//For loop to interate until we reach to the desired index
            {
               listIterator.remove();		//removes element at index
            }
            output = (String) listIterator.position.data;		//output is set to the element at index
         }
         catch(IndexOutOfBoundsException e)
         {
            System.out.println("The index is out of bounds\n");
         }
         return output;		//returns new linkedlist without the removed element


    }

   //search method returns the index of the parameter object
   //in the linked list if it exists. It return -1 if it does not
   //exits. If the index is out of bounds, then it throws an exception.
   public int search(Object element)		
    {
      try
      {
         LinkedListIterator listIterator = new LinkedListIterator();
         listIterator.position = first;			//set to the front
         int index = -1;
         int currentSize = size();		//size of current linkedlist
         for(int i = 0; i < currentSize; i++)   //For loop to interate each element and checks if element is equal to the parameter element
         {										
        	if(listIterator.position.data.equals(element))		//checks if they're equal to each other
            {
               index = i;		//index of desired element
               return index;	
            }
        	else
        	{
        		listIterator.next();
        	}
         }
         return index;
      }
      catch(IndexOutOfBoundsException e)
      {
         System.out.println("The index is out of bounds\n");
      }
	return -1;		//If element is not found then -1


    }

   //The appendAfter method searches the first occurrence
   //of the first parameter string, and append(add)
   //the second parameter string after the first string
   //occurrence.
   //If the linked list does not contain any string that is
   //same as the first parameter string, then
   //the second parameter string is added at the end of the
   //linked list.
   public void appendAfter(Object str1, Object str2)		
    {
     LinkedListIterator listIterator = new LinkedListIterator();
     listIterator.position = first;		//set to the front
     while(listIterator.hasNext())		//Loop to iterate each element inside LinkedList
     {
    	 if(listIterator.position.data.equals(str1))		//Checks if they're equal to each other	
    	 {
    		 listIterator.next(); 			
    		 listIterator.add(str2);			//Add string after the first string
    		 break;
    	 }
    	 else
    	 {
    		 listIterator.next();
    	 }
     }
     return;		//return new linkedlist with str2


    }

   //countOccurrences methods counts how many times the parameter object
   //appears in the linked list and return the number. It returns 0
   //if the parameter object does not exist in the linked list.
   public int countOccurrences(Object element)	
    {
	   LinkedListIterator listIterator = new LinkedListIterator();
	   listIterator.position = first;		//set to the front
       int count = 1;
        while(listIterator.hasNext())		//Loop to iterate each element inside LinkedList
        {
        	if(listIterator.position.data.equals(element))	//checks if they're equal to each other
        	{
        		listIterator.next();
        		count++;		//counts the number of same elements
        	}
        	else
        	{
        		listIterator.next();
        	}
        }
        return count;		//returns the number of same elements inside linkedlist
       

    }

   //The method size return the current size of the linked list,
   //that is, the number of elements in it.
   public int size()		
    {
	   LinkedListIterator listIterator = new LinkedListIterator();
      int count = 0;
      if(first == null)
      {
         return 0;		//if empty then size is 0
      }
      while(listIterator.hasNext())		//Loop to iterate each element inside LinkedList
      {
    	 listIterator.next();
         count++;		//counts the number of elements inside linkedlist
      }
      return count;		//returns the number of elements inside linkedlist



    }

   //The toString method returns a string containing the content
   //of the linked list. In this assignment, the linked list will
   //contain only string, so it returns a concatenation of all strings
   //in the linked list.
   public String toString()
    {
	   LinkedListIterator listIterator = new LinkedListIterator();
	   String result = "{ ";
	   while(listIterator.hasNext())		//Loop to iterate each element inside LinkedList
	   {
		   result += listIterator.next() + " ";		//prints all of the elements inside the linkedlist into String result
	   }
	   result += "}\n";
	   return result;		//returns the list of elements inside the linkedlist
	   
    }



   /***************************************************************/

   /**
      Returns an iterator for iterating through this list.
      @return an iterator for iterating through this list
   */
   public ListIterator listIterator()
   {
      return new LinkedListIterator();
   }

   private Node first;

   private class Node
   {
      public Object data;
      public Node next;
   }

   private class LinkedListIterator implements ListIterator
   {   //instance variables for the ListIterator class
	   private Node position;
       private Node previous;
      /**
         Constructs an iterator that points to the front
         of the linked list.
      */
      public LinkedListIterator()
      {
         position = null;
         previous = null;
      }

      /**
         Moves the iterator past the next element.
         @return the traversed element
      */
      public Object next()
      {
         if (!hasNext())
            throw new NoSuchElementException();
         previous = position; // Remember for remove

         if (position == null)
            position = first;
         else
            position = position.next;

         return position.data;
      }

      /**
         Tests if there is an element after the iterator
         position.
         @return true if there is an element after the iterator
         position
      */
      public boolean hasNext()
      {
         if (position == null)
            return first != null;
         else
            return position.next != null;
      }

      /**
         Adds an element before the iterator position
         and moves the iterator past the inserted element.
         @param element the element to add
      */
      public void add(Object element)
      {
         if (position == null)
         {
            addFirst(element);
            position = first;
         }
         else
         {
            Node newNode = new Node();
            newNode.data = element;
            newNode.next = position.next;
            position.next = newNode;
            position = newNode;
         }
         previous = position;
      }

      /**
         Removes the last traversed element. This method may
         only be called after a call to the next() method.
      */
      public void remove()
      {
         if (previous == position)
            throw new IllegalStateException();

         if (position == first)
         {
            removeFirst();
         }
         else
         {
            previous.next = position.next;
         }
         position = previous;
      }

      /**
         Sets the last traversed element to a different
         value.
         @param element the element to set
      */
      public void set(Object element)
      {
         if (position == null)
            throw new NoSuchElementException();
         position.data = element;
      }

     
   }
}



