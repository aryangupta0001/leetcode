class Solution {
    public List<List<Integer>> subsets(int[] nums) {

        List<Integer> processed = new ArrayList<>();
        List<Integer> unprocessed = new ArrayList<>();

        for (int i : nums)
            unprocessed.add(i);

        return createSubsets(processed, unprocessed);

    }

    static List<List<Integer>> createSubsets(List processed, List unprocessed) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();

        if (unprocessed.size() == 0) {
            ans.add(processed);
            return ans;
        }

        List <Integer> newUnprocessed = new ArrayList<>(unprocessed.subList(1, unprocessed.size()));

        List <Integer> newProcessed1 = new ArrayList<>(processed);

        List<Integer> newProcessed2 = new ArrayList(processed);
        newProcessed2.add((Integer) unprocessed.get(0));


        ans.addAll(createSubsets(newProcessed1, newUnprocessed));

        ans.addAll(createSubsets(newProcessed2, newUnprocessed));

        return ans;
    }
}
