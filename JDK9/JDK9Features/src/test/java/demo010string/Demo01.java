package demo010string;

/**
  String类底层结构的变化 
  动机：
       String类的当前实现将字符串存储在char[] 数组中，每个字符使用两个字节(16位)。从许多不同的应用程序收集的数据表明，字符串是堆使用的主要组成部分
而且，大多数据字符串对象只包含拉丁-1字符。这样的字符只需要一个字节的存储空间，因此这样的字符串对象的内部字符数组中的一半空间将被闲置。
       节省内存空间
  具体变化：
    String类内部由维护一个字符数组变化为维护一个字节数组
    JDK8：
    public final class String
       implements java.io.Serializable, Comparable<String>, CharSequence {
       / ** The value is used for character storage. * /
       private final char value[];
       ...
    }
     
    JDK9：
    public final class String
    implements java.io.Serializable, Comparable<String>, CharSequence {
        @Stable
        private final byte[] value;
        ...
    }

  StringBuffer与StringBuilder底层变化：
       由于String类底层已经发生变化，所以StringBuffer与StringBuilder底层也相应的发生了改变。
 */
public class Demo01 {
 
}
