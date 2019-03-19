package p;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
public class main {
	
    public static void main(String[] args) throws FileNotFoundException,IOException{

        try{
            //使用流的方法读取文件
            BufferedReader br = new BufferedReader(new FileReader(
                    "result.txt"));
            //使用TreeMap方法自动将结果按Integer列
            TreeMap<String,Integer> treemap = new TreeMap<String,Integer>();
            //用来存储读取的单词
            String readLine = null;
            //单词总数
            int count = 0;
            while((readLine = br.readLine())!=null){
                //将字母排序为小写
                readLine = readLine.toLowerCase();
                //将所有单词以大写输出
                //readLine  = readLine.toUpperCase();
                //过滤出只含有字母的字段
                String[] str = readLine.split("[\\s]");
                //过滤掉多个空格，“+”代表多个空格的意思
                for(int i = 0;i<str.length;i++){
                    count++;
                    String word = str[i].trim();//trim()用来去掉字符串首尾的空格
                    if(treemap.containsKey(word)){//判断此映射是否包含指定键的映射关系
                        treemap.put(word, treemap.get(word)+1);
                    }else{
                        treemap.put(word, 1);
                    }
                }
            }

            System.out.println("按字典的输出顺序输出单词统计个数:");
            System.out.println("单词："+"\t"+"每个单词出现的频率：" );
            /**
             * 使用迭代器遍历取值：
             * Iterator是迭代器
             * treemap.entrySet()是把TreeMap类型的数据转换成集合类型
             * treemap.entrySet().iterator()获取集合的迭代器
             */
            Iterator<Map.Entry<String,Integer>> it  = treemap.entrySet().iterator();
            //判断是否存在下一个单词
            while(it.hasNext()){
                Map.Entry<String, Integer> entry = it.next();//获取map中每一个键值
                //输出结果
                System.out.println(entry.getKey()+"        "+entry.getValue());
                br.close();//关闭流
            }
            System.out.println("单词总数为："+count+"个");

        }catch(FileNotFoundException e){//
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
   
    
}
