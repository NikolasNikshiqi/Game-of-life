public class Board {
    private int x,y;
    private int[][] field;
    Board(int rows, int cols){
        x = rows;
        y = cols;
        field = new int[x][y];
    }
    public void initBoard(){
        for(int i = 0;i< x;i++){
            for(int j = 0;j<y;j++){
                field[i][j] = 0;
            }
        }
    }
    public int[][] getField(){
        return field;
    }
    public int getX(){
        return  x;
    }
    public int getY(){
        return y;
    }
}
