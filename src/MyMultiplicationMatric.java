/**
 * Created by MadanNellore on 1/8/17.
 */
public class MyMultiplicationMatric {


    public int [][] secondmatrix= new int[][]{{1,1},{1,1}}; //2 X 2


   // public void multiplyMatrixs(){
   public static void main(String[] args) {

       int [][] firstmatrx = new int[][]{{1,1,1},{1,2,3},{1,1}}; //2 x 3
       System.out.println(" Array Size in the two Dimenisional Array :"+firstmatrx[1].length);

   for(int j=0;j<firstmatrx.length;j++) {

       for (int i = 0; i < firstmatrx[j].length; i++) {
           System.out.println("Matrix the of the Value :"+ j+" :" +firstmatrx[j][i]);

       }
   }
//
//       for(int i :firstmatrx[1])
//           System.out.println(i);

   }











}
