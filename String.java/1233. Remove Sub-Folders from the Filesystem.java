// https://leetcode.com/problems/remove-sub-folders-from-the-filesystem/description/

// BRUTE 

class Solution {
    public List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder); // Sort folders lexicographically
        List<String> ans = new ArrayList<>();

        for(String str : folder)
        {
            int length = str.length();
            int i = 1; // start from 1st index

            boolean isSubFolder = false;

            while(i < length)
            {
                // when '/' comes we check, is the substring is present
                // any substring is present then just break
                if(str.charAt(i) == '/')
                {
                    if(ans.contains(str.substring(0,i))) 
                    {
                        isSubFolder = true; // this gone to true and break
                        break;
                    }
                }
                i++;
            }

            // out of the loop, check if it is a subfolder then donot take
            // otherwise if false the take it in ans List
            if(isSubFolder == false)
            {
                ans.add(str);
            }
        }
        return ans;
    }
}






//Approach-2 OPTIMAL (Using Sorting)
//T.C : O(n*logn) //You can consider the length of each character as well - O(n*L*logn)
//S.C : O(1)


class Solution {
    public List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder);
        List<String> ans = new ArrayList<>();

        // The first folder can never be a sub-folder after sorting
        ans.add(folder[0]);
        
        // Iterate through the sorted folders
        for(int i = 1; i < folder.length; i++)
        {
            String currentStr = folder[i];
            String lastStr = ans.get(ans.size() - 1);
            
            lastStr += "/"; // Add '/' to the last folder to check for sub-folder

            // If the current folder does not start with the last folder, it is not a sub-folder
            if(!currentStr.startsWith(lastStr))
            {
                ans.add(currentStr);
            }
        }

        return ans;
    }
}
