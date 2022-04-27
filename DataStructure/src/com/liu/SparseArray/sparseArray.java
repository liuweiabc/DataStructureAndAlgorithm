package com.liu.SparseArray;

import java.io.*;

/**
 * @author liuwei
 * @date 2022/4/15
 * @apiNote
 */

public class sparseArray {
    public static void main(String[] args) throws IOException {
        //创建初始二维数组
        int [][]wuziqi = new int[11][11];
        wuziqi[1][2] = 1;
        wuziqi[2][3] = 2;
        wuziqi[3][4] = 2;

        for(int[] i:wuziqi){
            for(int j:i){
                System.out.printf("%d\t",j);
            }
            System.out.println();
        }

        //二维数组转稀疏数组
        int sum = 0;
        for(int[] i : wuziqi){
            for(int j:i){
                if(j != 0){
                    sum++;
                }
            }
        }
        int [][]SparseArray = new int[sum+1][3];
        SparseArray[0][0] = 11;
        SparseArray[0][1] = 11;
        SparseArray[0][2] = sum;
        int count = 0;
        for(int i = 0;i < 11;i++){
            for(int j = 0;j < 11;j++){
                if(wuziqi[i][j] != 0){
                    count++;
                    SparseArray[count][0] = i;
                    SparseArray[count][1] = j;
                    SparseArray[count][2] = wuziqi[i][j];
                }
            }
        }
        for(int[] i : SparseArray){
            System.out.printf("%d\t%d\t%d\t",i[0],i[1],i[2]);
            System.out.println();
        }

        int[][]wuziqi1 = new int[SparseArray[0][0]][SparseArray[0][1]];
        for(int i = 1;i < SparseArray.length;i++){
            wuziqi1[SparseArray[i][0]][SparseArray[i][1]] = SparseArray[i][2];
        }
        for(int[] i:wuziqi1){
            for(int j:i){
                System.out.printf("%d\t",j);
            }
            System.out.println();
        }

        // 保存稀疏数组
        File file = new File("map.data");
        FileOutputStream fos = new FileOutputStream(file);

        OutputStreamWriter write = new OutputStreamWriter(fos, "UTF-8");
        // 输出稀疏数组的形式
        System.out.println();
        System.out.println("得到的稀疏数组为~~~");
        for (int i = 0; i < SparseArray.length; i++) {
            System.out.printf("%d\t%d\t%d\t\n", SparseArray[i][0], SparseArray[i][1], SparseArray[i][2]);

            if (i == SparseArray.length - 1) {
                write.append(SparseArray[i][0] + "," + SparseArray[i][1] + "," + SparseArray[i][2]);
            } else {
                write.append(SparseArray[i][0] + "," + SparseArray[i][1] + "," + SparseArray[i][2] + "\n");
            }
        }

        System.out.println("写入文件中...");
        write.close();
        fos.close();

        // 创建 FileReader 对象
        FileInputStream fis = new FileInputStream(file);

        InputStreamReader reader = new InputStreamReader(fis, "UTF-8");
        StringBuffer sb = new StringBuffer();
        while (reader.ready()) {
            sb.append((char) reader.read());// 转成char加到StringBuffer对象中
        }

        System.out.println(sb.toString());
        reader.close();// 关闭读取流
        fis.close();// 关闭输入流,释放系统资源

        System.out.println("------------------------------恢复成稀疏数组_sparseArrHf");
        // 2.创建对应的稀疏数组
        String[] str = sb.toString().split(",");
        int sparseArrHf[][] = new int[str.length / 3][3];
        // 给稀疏数组赋值
        int i = 0;
        for (String s : str) {
            sparseArrHf[(i - (i % 3)) / 3][i % 3] = Integer.parseInt(s);
            i++;
        }
    }
}
