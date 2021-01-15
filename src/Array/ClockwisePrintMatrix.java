package Array;

import java.util.ArrayList;


public class ClockwisePrintMatrix {
    public static void main(String[] args) {
        int[][] matrix = {{1},{2},{3},{4},{5}};
        new ClockwisePrintMatrix().printMatrix(matrix);
    }
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> list = new ArrayList<>();
        int lx = 0,ly = 0;
        int rx = matrix.length-1,ry=matrix[0].length-1;
         while (lx<=rx&&ly<=ry){
            print(list,matrix,lx++,ly++,rx--,ry--);
        }
//        print(list,matrix,1,1,2,2);

        return list;
    }

    //打印一圈
    public void print(ArrayList<Integer> list,int [][] matrix,int lx,int ly,int rx,int ry){
        for (int i = ly;i<=ry;i++){
            list.add(matrix[lx][i]);
        }

        CommonUtil.checkList(list);


        for (int i = lx+1; i<=rx; i++) {
            list.add(matrix[i][ry]);
        }
        CommonUtil.checkList(list);

        //只有一行不要这个
        if (rx-lx>0){
            for (int i = ry-1;i>=ly;i--){
                list.add(matrix[rx][i]);
            }
        }

        CommonUtil.checkList(list);

        //只有一列不要这个
        if (ry-ly>0){
            for (int i = rx-1;i>lx;i--){
                list.add(matrix[i][ly]);
            }
        }


        CommonUtil.checkList(list);
    }


}
