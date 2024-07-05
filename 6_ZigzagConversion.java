class Solution {
    public String convert(String s, int numRows) {
        String result = "";

      
// -----------------------------------------------------------------------------------
      // Solution 1 :-
        // int i = 0, j = 0, k = 0, row = 0;

        // if(numRows == 1)
        //     return s;
        
        // while(i<s.length())
        // {   
        //     result = result + s.charAt(i);
        //     // arr.add(s.charAt(i));
        //     i = i + (numRows-1)*2;
        // }

        // k = 1;

        // while(k<numRows-1)
        // {   i = k;

        //     if(i>=s.length())
        //         break;
                
        //     result = result + s.charAt(i);
        //     // arr.add(s.charAt(i));

        //     while(true)
        //     {   i = i + (numRows-1-k)*2;
        //         if(i>=s.length())
        //             break;
                
        //         result = result + s.charAt(i);
        //         // arr.add(s.charAt(i));

        //         i = i + (k*2);
        //         if(i>=s.length())
        //             break;
                
        //         result = result + s.charAt(i);
        //         // arr.add(s.charAt(i));
        //     }
        //     k++;
        // }

        // i = k;
        // while(i<s.length())
        // {   
        //     result = result + s.charAt(i);
        //     // arr.add(s.charAt(i));
        //     i = i + (k*2);
        // }


// -----------------------------------------------------------------------------------
// Solution 2 :-      
        ArrayList<ArrayList<Character>> matrix = new ArrayList<>();
        int i = 0, j = 0, k = 0;
      
        for(int i = 0; i<numRows; i++)
            matrix.add(new ArrayList<>());
      
        while(i<s.length())
        {   while(j<numRows && i<s.length())
                matrix.get(j++).add(s.charAt(i++));
            
            if(j>1)
                j-=2;
            else
                j = 0;

            while(j>0 && i<s.length())
                matrix.get(j--).add(s.charAt(i++));
        }

        j = 0;

        while(j<numRows)
        {   for(k = 0; k<matrix.get(j).size(); k++)
                result = result + matrix.get(j).get(k);
            j++;
        }

// ----------------------------------------------------------------------------------------

        return result;
    }

}
