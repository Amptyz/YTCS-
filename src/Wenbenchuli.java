import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import java.util.*;

import com.huaban.analysis.jieba.JiebaSegmenter;


public class Wenbenchuli {
    public int wuru_Count;
    public int guli_Count;
    public int wenda_Count;
    public int yusu;
    public JiebaSegmenter segmenter;
    public List<String> result;
    public Set<String> wuru;
    public Set<String> guli;
    public Set<String> wenda;

    Wenbenchuli(){
        result=new ArrayList<>();
        wuru=new HashSet<>();
        guli=new HashSet<>();
        wenda=new HashSet<>();
        segmenter=new JiebaSegmenter();
        wuru_Count=0;
        guli_Count=0;
        wenda_Count=0;
        yusu=0;
    }
    private Set<String> readWordFile(String filepath){
        Set<String> wordSet=null;
        File file=new File(filepath);
        try {
            InputStreamReader read = new InputStreamReader(new FileInputStream(file), "utf-8");
            if (file.isFile() && file.exists()) {
                wordSet = new HashSet<String>();
                BufferedReader br = new BufferedReader(read);
                String txt;
                while ((txt = br.readLine()) != null) {
                    wordSet.add(txt);
                }
                br.close();
            }
            read.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    return wordSet;
    }
    public void show_result(){
        System.out.println(result);
        System.out.printf("wuru_Count=%d\n",wuru_Count);
        System.out.printf("guli_Count=%d\n",guli_Count);
        System.out.printf("wenda_Count=%d",wenda_Count);
    }
    public void GetString_analyse(String data){
        wuru=readWordFile("dicts/wuru.txt");
        guli=readWordFile("dicts/guli.txt");
        wenda=readWordFile("dicts/wenda.txt");

        result=segmenter.sentenceProcess(data);
        for(String s : result){
            if(wuru.contains(s)){
                wuru_Count++;
            }
            else if(guli.contains(s)){
                guli_Count++;
            }
            else if(wenda.contains(s)){
                wenda_Count++;
            }
        }
    }
}
