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
            //ʹ�����ķ�����ȡ�ļ�
            BufferedReader br = new BufferedReader(new FileReader(
                    "result.txt"));
            //ʹ��TreeMap�����Զ��������Integer��
            TreeMap<String,Integer> treemap = new TreeMap<String,Integer>();
            //�����洢��ȡ�ĵ���
            String readLine = null;
            //��������
            int count = 0;
            while((readLine = br.readLine())!=null){
                //����ĸ����ΪСд
                readLine = readLine.toLowerCase();
                //�����е����Դ�д���
                //readLine  = readLine.toUpperCase();
                //���˳�ֻ������ĸ���ֶ�
                String[] str = readLine.split("[\\s]");
                //���˵�����ո񣬡�+����������ո����˼
                for(int i = 0;i<str.length;i++){
                    count++;
                    String word = str[i].trim();//trim()����ȥ���ַ�����β�Ŀո�
                    if(treemap.containsKey(word)){//�жϴ�ӳ���Ƿ����ָ������ӳ���ϵ
                        treemap.put(word, treemap.get(word)+1);
                    }else{
                        treemap.put(word, 1);
                    }
                }
            }

            System.out.println("���ֵ�����˳���������ͳ�Ƹ���:");
            System.out.println("���ʣ�"+"\t"+"ÿ�����ʳ��ֵ�Ƶ�ʣ�" );
            /**
             * ʹ�õ���������ȡֵ��
             * Iterator�ǵ�����
             * treemap.entrySet()�ǰ�TreeMap���͵�����ת���ɼ�������
             * treemap.entrySet().iterator()��ȡ���ϵĵ�����
             */
            Iterator<Map.Entry<String,Integer>> it  = treemap.entrySet().iterator();
            //�ж��Ƿ������һ������
            while(it.hasNext()){
                Map.Entry<String, Integer> entry = it.next();//��ȡmap��ÿһ����ֵ
                //������
                System.out.println(entry.getKey()+"        "+entry.getValue());
                br.close();//�ر���
            }
            System.out.println("��������Ϊ��"+count+"��");

        }catch(FileNotFoundException e){//
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
   
    
}