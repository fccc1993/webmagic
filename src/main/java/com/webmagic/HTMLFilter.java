package com.webmagic;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by fccc on 2017/11/30.
 */

public class HTMLFilter {


    public static String delHTMLTag(String htmlStr){
        String regEx_script="<script[^>]*?>[\\s\\S]*?<\\/script>"; //定义script的正则表达式
        String regEx_style="<style[^>]*?>[\\s\\S]*?<\\/style>"; //定义style的正则表达式
        String regEx_html="<[^>]+>"; //定义HTML标签的正则表达式

        Pattern p_script=Pattern.compile(regEx_script,Pattern.CASE_INSENSITIVE);
        Matcher m_script=p_script.matcher(htmlStr);
        htmlStr=m_script.replaceAll(""); //过滤script标签

        Pattern p_style= Pattern.compile(regEx_style,Pattern.CASE_INSENSITIVE);
        Matcher m_style=p_style.matcher(htmlStr);
        htmlStr=m_style.replaceAll(""); //过滤style标签

        Pattern p_html=Pattern.compile(regEx_html,Pattern.CASE_INSENSITIVE);
        Matcher m_html=p_html.matcher(htmlStr);
        htmlStr=m_html.replaceAll(""); //过滤html标签

        return htmlStr.trim(); //返回文本字符串
    }

    public static void main(String[] args) {
        String text="content:\t<div id=\"sina_keyword_ad_area2\" class=\"articalContent   \"> \n" +
                " <br> \n" +
                " <div> \n" +
                "  <table style=\"width: 692px; height: 5286px;\" cellpadding=\"0\" cellspacing=\"0\"> \n" +
                "   <tbody> \n" +
                "    <tr> \n" +
                "     <td><br> &nbsp;<wbr>&nbsp;<wbr>&nbsp;<wbr> 曾经有那么个时代，没有那么多新奇的工具，没有语音指挥，没有精确到秒的团队插件，没有打地鼠，没有数据化的研究，没有GS，没有物品等级，没有详细到每 场战斗的伤害统计；那时候都不怎么会玩，T常常只会拉BOSS，常常小怪打死治疗不管，OT也是常事，治疗也只会管那么几个人，dps也很少研究手法，很 多人都不会加天赋；那时只有战士是T，法师还都是冰法，术士只是拉人和发糖的，会治疗的职业都只能治疗，盗贼常常是地板王，猎人经常带不同的宝宝来 raid。<br> &nbsp;<wbr> &nbsp;<wbr>&nbsp;<wbr>&nbsp;<wbr>但是那个时候充满了探索的乐趣，那个时候的团队频道不会只被DBM的警报填满，大家经常一起分析打法；那个时候还有职业频道，大家经常一起交流职业心得，而不是只说装备怎么分；那个时候所有人都犯过傻，灭团也不会像现在这么不能忍受。<br> &nbsp;<wbr> &nbsp;<wbr>&nbsp;<wbr>&nbsp;<wbr>个人认为，要评个整个WOW最佳休闲本，祖格可以说当之无愧。刚开ZG那会大家还在刷MC到黑，这个风格清新的户外副本无疑是个好去处，装备也有相 当的吸引力。但是当时祖格可以说还有点难，但是随着各种BUG的发现，很多菜鸟团队也能很容易的车翻除金度外的所有BOSS。而直至NAXX通关，ZG都 因为头腿附魔而不可替代，一身T3的高玩也基本每个CD都去碾压。祖格也是WOW最初的G团兴起的地方，另一个地方就是安其拉废墟，但是随着装备的提升， 技能书的普及，废墟的吸引力逐渐下降，经常一趟只分个几十G，而祖格却因为龙虎、附魔以及宝石硬币反而坚挺。这里也是单刷胜地，从最开始60级法师单刷鳄 鱼挑战极限，盗贼偷矿偷草，到后来单刷龙虎以及乌龟书，至今仍有人乐此不疲。<br> &nbsp;<wbr> &nbsp;<wbr>&nbsp;<wbr>&nbsp;<wbr>昨天听说在CTM祖格被改成5人本了，没事翻出游戏，去祖格转了转，做个留恋吧。下面开始祖格怀旧之旅：<br> &nbsp;<wbr> &nbsp;<wbr> <img STYLE=\"cursor:pointer;\" src=\"http://simg.sinajs.cn/blog7style/images/common/sg_trans.gif\" real_src=\"http://pic1.178.com/22/222173/month_1105/1105120955ce1c69aab0fb096f.jpg\" ALT=\"WoWScrnShot_051111_191308.jpg\" HEIGHT=\"375\" WIDTH=\"600\" NAME=\"aimg_334933\" TITLE=\"怀旧帖——祖格还是那个祖格，而我们已不是当初的我们\"><br> &nbsp;<wbr> &nbsp;<wbr> 炸弹人，当年被炸死的可不少<br> &nbsp;<wbr> &nbsp;<wbr> <img STYLE=\"cursor:pointer;\" src=\"http://simg.sinajs.cn/blog7style/images/common/sg_trans.gif\" real_src=\"http://pic1.178.com/22/222173/month_1105/110512095581b8786405248ff4.jpg\" ALT=\"WoWScrnShot_051111_191320.jpg\" HEIGHT=\"375\" WIDTH=\"600\" NAME=\"aimg_334934\" TITLE=\"怀旧帖——祖格还是那个祖格，而我们已不是当初的我们\"><br> &nbsp;<wbr> &nbsp;<wbr> 一号，蝙蝠女，大喊“XXX，赐予我力量吧！”，飞身而下。<br> &nbsp;<wbr> &nbsp;<wbr> <img STYLE=\"cursor:pointer;\" src=\"http://simg.sinajs.cn/blog7style/images/common/sg_trans.gif\" real_src=\"http://pic1.178.com/22/222173/month_1105/11051209551b0a49df038c9a5d.jpg\" ALT=\"WoWScrnShot_051111_191420.jpg\" HEIGHT=\"375\" WIDTH=\"600\" NAME=\"aimg_334935\" TITLE=\"怀旧帖——祖格还是那个祖格，而我们已不是当初的我们\"><br> &nbsp;<wbr> &nbsp;<wbr> 蝙蝠变身了，会招小弟，那时少有T会群拉，小弟大家都是近战顶风作案，乱刀砍死。还会扔燃烧瓶，当时烧死的也不少。<br> &nbsp;<wbr> &nbsp;<wbr> <img STYLE=\"cursor:pointer;\" src=\"http://simg.sinajs.cn/blog7style/images/common/sg_trans.gif\" real_src=\"http://pic1.178.com/22/222173/month_1105/1105120955c036b8f383ea092f.jpg\" ALT=\"WoWScrnShot_051111_191538.jpg\" HEIGHT=\"375\" WIDTH=\"600\" NAME=\"aimg_334937\" TITLE=\"怀旧帖——祖格还是那个祖格，而我们已不是当初的我们\"><br> &nbsp;<wbr> &nbsp;<wbr>Loot，这腰带当年我法师想了好几个CD才拿到。<br> &nbsp;<wbr> &nbsp;<wbr> <img STYLE=\"cursor:pointer;\" src=\"http://simg.sinajs.cn/blog7style/images/common/sg_trans.gif\" real_src=\"http://pic1.178.com/22/222173/month_1105/110512095566b106f70ade62ec.jpg\" ALT=\"WoWScrnShot_051111_191950.jpg\" HEIGHT=\"375\" WIDTH=\"600\" NAME=\"aimg_334938\" TITLE=\"怀旧帖——祖格还是那个祖格，而我们已不是当初的我们\"><br> &nbsp;<wbr> &nbsp;<wbr>毒蛇女，当时连连看经常死人，大家也不看攻略，很久以后才知道这个技能...最后的台词，宁静...终于来临了...经常被小德拿去做宏。<br> &nbsp;<wbr> &nbsp;<wbr> <img STYLE=\"cursor:pointer;\" src=\"http://simg.sinajs.cn/blog7style/images/common/sg_trans.gif\" real_src=\"http://pic1.178.com/22/222173/month_1105/11051209561e274fdf6f6009bc.jpg\" ALT=\"WoWScrnShot_051111_192002.jpg\" HEIGHT=\"375\" WIDTH=\"600\" NAME=\"aimg_334939\" TITLE=\"怀旧帖——祖格还是那个祖格，而我们已不是当初的我们\"><br> &nbsp;<wbr> &nbsp;<wbr>这个是后面版本加的指环，好歹是个紫的，红手。<br> &nbsp;<wbr> &nbsp;<wbr> <img STYLE=\"cursor:pointer;\" src=\"http://simg.sinajs.cn/blog7style/images/common/sg_trans.gif\" real_src=\"http://pic1.178.com/22/222173/month_1105/110512095687666a3fe345a776.jpg\" ALT=\"WoWScrnShot_051111_193731.jpg\" HEIGHT=\"375\" WIDTH=\"600\" NAME=\"aimg_334941\" TITLE=\"怀旧帖——祖格还是那个祖格，而我们已不是当初的我们\"><br> &nbsp;<wbr> &nbsp;<wbr>血领主，大家应该都熟的很了...没龙...<br> &nbsp;<wbr> &nbsp;<wbr> <img STYLE=\"cursor:pointer;\" src=\"http://simg.sinajs.cn/blog7style/images/common/sg_trans.gif\" real_src=\"http://pic1.178.com/22/222173/month_1105/11051209567d548700afa3eb3f.jpg\" ALT=\"WoWScrnShot_051111_194412.jpg\" HEIGHT=\"375\" WIDTH=\"600\" NAME=\"aimg_334942\" TITLE=\"怀旧帖——祖格还是那个祖格，而我们已不是当初的我们\"><br> &nbsp;<wbr> &nbsp;<wbr>老虎，其实挺难的，自从有了脱战3次就变身的神奇bug之后，就是野团的小菜了。当然有次打老虎，团里十几个人都勇敢的去尝试卡BUG，结果他们跳不上被拍死了...那次我笑了一下午。<br> &nbsp;<wbr> &nbsp;<wbr> <img STYLE=\"cursor:pointer;\" src=\"http://simg.sinajs.cn/blog7style/images/common/sg_trans.gif\" real_src=\"http://pic1.178.com/22/222173/month_1105/1105120956835cc2c66a7a1a4f.jpg\" ALT=\"WoWScrnShot_051111_194907.jpg\" HEIGHT=\"375\" WIDTH=\"600\" NAME=\"aimg_334943\" TITLE=\"怀旧帖——祖格还是那个祖格，而我们已不是当初的我们\"><br> &nbsp;<wbr> &nbsp;<wbr>豹子，DPS不够的时候还有点难...祈祷不要标记了去啃布甲。出个18格包，当时也算是一个小宝贝。<br> &nbsp;<wbr> &nbsp;<wbr> <img STYLE=\"cursor:pointer;\" src=\"http://simg.sinajs.cn/blog7style/images/common/sg_trans.gif\" real_src=\"http://pic1.178.com/22/222173/month_1105/110512095653974108efe8115a.jpg\" ALT=\"WoWScrnShot_051111_195837.jpg\" HEIGHT=\"375\" WIDTH=\"600\" NAME=\"aimg_334944\" TITLE=\"怀旧帖——祖格还是那个祖格，而我们已不是当初的我们\"><br> &nbsp;<wbr> &nbsp;<wbr>哈卡，哈卡心是好东西...打的时候老是被晕，看来少打了一个祭司。一下子竟然没想起来。<br> &nbsp;<wbr> &nbsp;<wbr> <img STYLE=\"cursor:pointer;\" src=\"http://simg.sinajs.cn/blog7style/images/common/sg_trans.gif\" real_src=\"http://pic1.178.com/22/222173/month_1105/110512095667dc8f9f8d734461.jpg\" ALT=\"WoWScrnShot_051111_200941.jpg\" HEIGHT=\"375\" WIDTH=\"600\" NAME=\"aimg_334949\" TITLE=\"怀旧帖——祖格还是那个祖格，而我们已不是当初的我们\"><br> &nbsp;<wbr> &nbsp;<wbr>蜘蛛，被我遗忘了...需要两个T的BOSS，小蜘蛛也很讨厌。<br> &nbsp;<wbr> &nbsp;<wbr> <img STYLE=\"cursor:pointer;\" src=\"http://simg.sinajs.cn/blog7style/images/common/sg_trans.gif\" real_src=\"http://pic1.178.com/22/222173/month_1105/11051209551f3b4512f3e551b6.jpg\" ALT=\"WoWScrnShot_051111_201541.jpg\" HEIGHT=\"375\" WIDTH=\"600\" NAME=\"aimg_334932\" TITLE=\"怀旧帖——祖格还是那个祖格，而我们已不是当初的我们\"><br> &nbsp;<wbr> &nbsp;<wbr>金度，有多少个团队就有多少种打法...诅咒要解？不要解？当然，最后其实就几个要点：DPS快，打图腾，尽量双T，就行了。骷髅池都不用怎么管。</td> \n" +
                "    </tr> \n" +
                "   </tbody> \n" +
                "  </table> \n" +
                "  <div> \n" +
                "   <dl> \n" +
                "    <dt>\n" +
                "     <br>\n" +
                "    </dt> \n" +
                "    <dd> \n" +
                "     <p><a href=\"http://hzyt.g.178.com/bbs/attachment.php?aid=MzM0OTM2fGM3ZThmNWJjfDEzMDUxNjkwOTV8NDZmYXBXV3FzcEJUakNuNWNwYVo4MGM0Uy9NeFc3MUprRXNMeVF0cEpIcVVlSG8=&amp;nothumb=yes\" target=\"_blank\" name=\"aid334936\">WoWScrnShot_051111_191528.jpg</a> <em>(343.83 KB)</em></p> \n" +
                "     <p>&nbsp;<wbr></p> \n" +
                "     <p><img STYLE=\"cursor: pointer;\" src=\"http://simg.sinajs.cn/blog7style/images/common/sg_trans.gif\" real_src=\"http://pic1.178.com/22/222173/month_1105/110512095593f1df1321b80e61.jpg\" ALT=\"WoWScrnShot_051111_191528.jpg\" HEIGHT=\"375\" WIDTH=\"600\" NAME=\"aimg_334936\" TITLE=\"怀旧帖——祖格还是那个祖格，而我们已不是当初的我们\"></p> \n" +
                "    </dd> \n" +
                "   </dl> \n" +
                "   <dl> \n" +
                "    <dt>\n" +
                "     <br>\n" +
                "    </dt> \n" +
                "    <dd> \n" +
                "     <p><a href=\"http://hzyt.g.178.com/bbs/attachment.php?aid=MzM0OTQwfDhhYjMxZjQ2fDEzMDUxNjkwOTV8NDZmYXBXV3FzcEJUakNuNWNwYVo4MGM0Uy9NeFc3MUprRXNMeVF0cEpIcVVlSG8=&amp;nothumb=yes\" target=\"_blank\" name=\"aid334940\">WoWScrnShot_051111_192006.jpg</a> <em>(391.49 KB)</em></p> \n" +
                "     <p>&nbsp;<wbr></p> \n" +
                "     <p><img STYLE=\"cursor: pointer;\" src=\"http://simg.sinajs.cn/blog7style/images/common/sg_trans.gif\" real_src=\"http://pic1.178.com/22/222173/month_1105/1105120956c420193b2c1bda9a.jpg\" ALT=\"WoWScrnShot_051111_192006.jpg\" HEIGHT=\"375\" WIDTH=\"600\" NAME=\"aimg_334940\" TITLE=\"怀旧帖——祖格还是那个祖格，而我们已不是当初的我们\"></p> \n" +
                "    </dd> \n" +
                "   </dl> \n" +
                "   <dl> \n" +
                "    <dt>\n" +
                "     <br>\n" +
                "    </dt> \n" +
                "    <dd> \n" +
                "     <p><a href=\"http://hzyt.g.178.com/bbs/attachment.php?aid=MzM0OTQ1fGIxOTFlNThifDEzMDUxNjkwOTV8NDZmYXBXV3FzcEJUakNuNWNwYVo4MGM0Uy9NeFc3MUprRXNMeVF0cEpIcVVlSG8=&amp;nothumb=yes\" target=\"_blank\" name=\"aid334945\">WoWScrnShot_051111_200235.jpg</a> <em>(292.67 KB)</em></p> \n" +
                "     <p>&nbsp;<wbr></p> \n" +
                "     <p><img STYLE=\"cursor: pointer;\" src=\"http://simg.sinajs.cn/blog7style/images/common/sg_trans.gif\" real_src=\"http://pic1.178.com/22/222173/month_1105/1105120956e152bd4aa217b86b.jpg\" ALT=\"WoWScrnShot_051111_200235.jpg\" HEIGHT=\"375\" WIDTH=\"600\" NAME=\"aimg_334945\" TITLE=\"怀旧帖——祖格还是那个祖格，而我们已不是当初的我们\"></p> \n" +
                "    </dd> \n" +
                "   </dl> \n" +
                "   <dl> \n" +
                "    <dt>\n" +
                "     <br>\n" +
                "    </dt> \n" +
                "    <dd> \n" +
                "     <p><a href=\"http://hzyt.g.178.com/bbs/attachment.php?aid=MzM0OTQ2fDM2NzcwNDYyfDEzMDUxNjkwOTV8NDZmYXBXV3FzcEJUakNuNWNwYVo4MGM0Uy9NeFc3MUprRXNMeVF0cEpIcVVlSG8=&amp;nothumb=yes\" target=\"_blank\" name=\"aid334946\">WoWScrnShot_051111_200245.jpg</a> <em>(124.98 KB)</em></p> \n" +
                "     <p>&nbsp;<wbr></p> \n" +
                "     <p><img STYLE=\"cursor: pointer;\" src=\"http://simg.sinajs.cn/blog7style/images/common/sg_trans.gif\" real_src=\"http://pic1.178.com/22/222173/month_1105/11051209566bdfdde524067719.jpg\" ALT=\"WoWScrnShot_051111_200245.jpg\" HEIGHT=\"375\" WIDTH=\"600\" NAME=\"aimg_334946\" TITLE=\"怀旧帖——祖格还是那个祖格，而我们已不是当初的我们\"></p> \n" +
                "    </dd> \n" +
                "   </dl> \n" +
                "   <dl> \n" +
                "    <dt>\n" +
                "     <br>\n" +
                "    </dt> \n" +
                "    <dd> \n" +
                "     <p><a href=\"http://hzyt.g.178.com/bbs/attachment.php?aid=MzM0OTQ3fDQ2Yjc5NWQ2fDEzMDUxNjkwOTV8NDZmYXBXV3FzcEJUakNuNWNwYVo4MGM0Uy9NeFc3MUprRXNMeVF0cEpIcVVlSG8=&amp;nothumb=yes\" target=\"_blank\" name=\"aid334947\">WoWScrnShot_051111_200929.jpg</a> <em>(428.15 KB)</em></p> \n" +
                "     <p>&nbsp;<wbr></p> \n" +
                "     <p><img STYLE=\"cursor: pointer;\" src=\"http://simg.sinajs.cn/blog7style/images/common/sg_trans.gif\" real_src=\"http://pic1.178.com/22/222173/month_1105/11051209563936d4eac040da6b.jpg\" ALT=\"WoWScrnShot_051111_200929.jpg\" HEIGHT=\"375\" WIDTH=\"600\" NAME=\"aimg_334947\" TITLE=\"怀旧帖——祖格还是那个祖格，而我们已不是当初的我们\"></p> \n" +
                "    </dd> \n" +
                "   </dl> \n" +
                "   <dl> \n" +
                "    <dt>\n" +
                "     <br>\n" +
                "    </dt> \n" +
                "    <dd> \n" +
                "     <p><a href=\"http://hzyt.g.178.com/bbs/attachment.php?aid=MzM0OTQ4fDY2NjA5M2EyfDEzMDUxNjkwOTV8NDZmYXBXV3FzcEJUakNuNWNwYVo4MGM0Uy9NeFc3MUprRXNMeVF0cEpIcVVlSG8=&amp;nothumb=yes\" target=\"_blank\" name=\"aid334948\">WoWScrnShot_051111_200935.jpg</a> <em>(427.17 KB)</em></p> \n" +
                "     <p>&nbsp;<wbr></p> \n" +
                "     <p><img STYLE=\"cursor: pointer;\" src=\"http://simg.sinajs.cn/blog7style/images/common/sg_trans.gif\" real_src=\"http://pic1.178.com/22/222173/month_1105/1105120956edfc3cfa6b98a9e2.jpg\" ALT=\"WoWScrnShot_051111_200935.jpg\" HEIGHT=\"375\" WIDTH=\"600\" NAME=\"aimg_334948\" TITLE=\"怀旧帖——祖格还是那个祖格，而我们已不是当初的我们\"></p> \n" +
                "    </dd> \n" +
                "   </dl> \n" +
                "  </div> \n" +
                " </div> \n" +
                "</div>";
        String afterText = HTMLFilter.delHTMLTag(text);
        System.out.println(afterText);
    }
}
