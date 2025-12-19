class Solution {
    public int[][] flipAndInvertImage(int[][] image) {

        for (int i = 0; i < image.length; i++) {
            int len = image[i].length;

            for(int j = 0; j < (len + 1)/2; j++){
                int temp = image[i][j];
                image[i][j] = image[i][len - 1 - j] ^ 1;
                // image[i][j] = image[i][len - 1 - j] > 0 ? 0 : 1;
                image[i][len - 1 - j] = temp ^ 1;
                // image[i][len - 1 - j] = temp > 0 ? 0 : 1;
            }
        }

        return image;
    }
}
