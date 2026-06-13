class Solution {
    public static final int land = Integer.MAX_VALUE;
    int[][] direction= {{1,0},{-1,0} ,{0,1} ,{0,-1}};
    public void islandsAndTreasure(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        Queue<Pair> queue = new LinkedList<>();

        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j] == 0){
                    queue.add(new Pair(i,j));
                }
            }
        }
         while(!queue.isEmpty()){
            Pair source = queue.poll();
            int r = source.row;
            int c = source.col;

            for(int[] dir : direction){
                int nr= r+dir[0];
                int nc= c+dir[1];
                if(nr <0 || nc<0 || nr >= grid.length || nc >= grid[0].length || grid[nr][nc] !=land)
                    continue ;
                grid[nr][nc] = 1+ grid[r][c];
                queue.add(new  Pair(nr,nc));
            }
        }           
    }      
}
class Pair {
    int row ;
    int col ;
    Pair(int row , int col){
        this.row = row;
        this.col = col;
    }
}
