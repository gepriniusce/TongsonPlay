package pr.tongson.principle.ocp.b;

import java.text.NumberFormat;
import java.util.ArrayList;

/**
 * <b>Create Date:</b> 2017/10/12<br>
 * <b>Author:</b> mmc_Kongming_Tongson <br>
 * <b>Email:</b> 289286298@qq.com<br>
 * <b>Description:</b> 书店 <br>
 */
public class BookStore {
    private final static ArrayList<IBook> bookList = new ArrayList<IBook>();

    static {
        bookList.add(new NovelBook("天龙八部", 3200, "金庸"));
        bookList.add(new NovelBook("巴黎圣母院", 5600, "雨果"));
        bookList.add(new NovelBook("悲惨世界", 3500, "雨果"));
        bookList.add(new NovelBook("金瓶梅", 4300, "兰陵笑笑生"));
        //增加计算机书籍 
        bookList.add(new ComputerBook("Think in Java", 4300, "Bruce Eckel", "编程语言"));
    }

    //模拟书店买书 
    public static void main(String[] args) {
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        formatter.setMaximumFractionDigits(2);
        System.out.println("------------书店买出去的书籍记录如下：---------------------");
        for (IBook book : bookList) {
            System.out.println("书籍名称：" + book.getName() + "\t书籍作者：" + book.getAuthor() + "\t书籍价格：" + formatter.format(book.getPrice() / 100.0) + "元");
        }
    }
}
