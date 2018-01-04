package com.example.xdd;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 商蔚 on 2017/7/22.
 */

public class Info implements Serializable {
    /**
     * 精度
     */
    private double latitude;
    /**
     * 纬度
     */
    private double longitude;
    /**
     * 图片ID，服务器中为图片路径
     */
    private int imgId;
    /**
     * 姓名
     */
    private String name;
    /**
     * 帮助或者服务内容
     */
    private String content;
    /*
    * 信誉积分
     */
    private String credit;

    public static List<Info> infos = new ArrayList<Info>();

   static {
       infos.add(new Info(30.652696,104.056063, R.drawable.axin, "阿信", "帮我在城南买个火锅底料", "120"));

       infos.add(new Info(30.669488,104.061614, R.drawable.chenduling, "小陈","可以在成都地区跑个腿", "130"));

       infos.add(new Info(30.666397,104.034848,R.drawable.zhoujielun, "阿杰","想吃青羊区的李记兔头", "143"));

       infos.add(new Info(30.553369,114.305926, R.drawable.linjunjie, "大俊","我可以帮你们买江汉路附近的美食", "113"));

       infos.add(new Info(30.550239,114.309052, R.drawable.xuezhiqian,"小谦","我想配副眼睛","159"));

       infos.add(new Info(30.593933,114.277316, R.drawable.guobiting,"老郭","我想要一个孙中山纪念像！","148"));

       infos.add(new Info(39.915119,116.403963,R.drawable.alalei,"小蕾","我可以代买故宫门票哦","125"));

       infos.add(new Info(39.991002,116.328896,R.drawable.xiaoyan,"阿萌","我可以代买北京特产","254"));

       infos.add(new Info(39.916224,116.417435,R.drawable.dilireba,"胖迪","我想买个雕像","287"));

   }
    public Info()
    {
    }
    public Info(double latitude, double longitude, int imgId, String name,String content,String credit )
    {
        super();
        this.latitude = latitude;
        this.longitude = longitude;
        this.imgId = imgId;
        this.name = name;
        this.content = content;
        this.credit= credit;
    }
    public double getLatitude()
    {
        return latitude;
    }

    public void setLatitude(double latitude)
    {
        this.latitude = latitude;
    }

    public double getLongitude()
    {
        return longitude;
    }

    public void setLongitude(double longitude)
    {
        this.longitude = longitude;
    }

    public String getName()
    {
        return name;
    }

    public int getImgId()
    {
        return imgId;
    }

    public void setImgId(int imgId)
    {
        this.imgId = imgId;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getContent()
    {
        return content;
    }

    public void setContent(String content)
    {
        this.content = content;
    }

    public String getCredit()
    {
        return credit;
    }

    public void setCredit(String credit)
    {
        this.credit = credit;
    }

}
