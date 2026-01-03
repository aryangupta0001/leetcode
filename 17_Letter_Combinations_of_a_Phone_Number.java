class Solution {
    public List<String> letterCombinations(String digits) {

        List<ArrayList<String>> chars = new ArrayList<ArrayList<String>>();

        List<String> ans = new ArrayList<>();

        chars.add(new ArrayList<>(Arrays.asList("a", "b", "c")));
        chars.add(new ArrayList<>(Arrays.asList("d", "e", "f")));
        chars.add(new ArrayList<>(Arrays.asList("g", "h", "i")));
        chars.add(new ArrayList<>(Arrays.asList("j", "k", "l")));
        chars.add(new ArrayList<>(Arrays.asList("m", "n", "o")));
        chars.add(new ArrayList<>(Arrays.asList("p", "q", "r", "s")));
        chars.add(new ArrayList<>(Arrays.asList("t", "u", "v")));
        chars.add(new ArrayList<>(Arrays.asList("w", "x", "y", "z")));

        int index = Character.getNumericValue(digits.charAt(0));

        ans.addAll(chars.get(index - 2));

        System.out.println(index);
        System.out.println(ans);

        return getCombinations(digits.substring(1), chars, ans);
    }

    static List<String> getCombinations(String digits, List<ArrayList<String>> chars, List<String> ans) {
        if (digits.length() == 0)
            return ans;

        int index = Character.getNumericValue(digits.charAt(0));

        List<String> current = new ArrayList<String>(chars.get(index - 2));
        int size = ans.size();

        for(int i = 0; i<current.size() - 1; i++)
            ans.addAll(ans.subList(0, size));
        
        for(int i = 0; i<current.size(); i++){
            for(int j = i*size; j<(i+1) * size; j++){
                ans.set(j, ans.get(j) + current.get(i));
            }
        }

        return getCombinations(digits.substring(1), chars, ans);
    }
}
