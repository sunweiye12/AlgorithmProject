package 欢乐颂._06并查集和前缀树;

import java.util.HashMap;

import org.junit.Test;

/**
 * 前缀树结构(trie树)
	这是一种特殊的树结构,它的主要信息没有存储到节点上,而是存储到节点与节点的路径上
	开始的时候只有一个头节点,当你在将字符串"abc"添加到前缀树中时,会从头节点开始判断
	查找头节点有没有名为a的路,如果没有则创建一条名为a的路,然后创建一个节点,沿着a路到达在此节点判断是否有名为b的路,如果没有则创建名为b的路,
	然后再创建一个节点.到达此节点后判断是否有名为c的路,如果没有则创建此路和另一个节点,并结束.
	在此添加abd的时候会拿过头结点来看,有名为a的路.直接沿着a路来到节点,又发现有名为b的路沿着b路来到下一个节点,发现没有名为d的路,因此创建
	一条名为d的路,然后再连接一个节点
	
	由此我们知道,当前缀相同的字符串加入到前缀树时,起到了很好的复用效果.
		应用:判断一系列字符串中是否包含以另一个字符串开头的字符串
	如果在节点上存储字符串在此处结尾的次数.
		应用:就可以应用于判断一些列字符串中是否包含另一个字符串
	如果在节点上存储字符串在此处划过的次数.
		应用:判断一系列字符串中有多少包含以另一个字符串开头的字符串
 * @author Administrator
 *
 */
public class _03前缀树 {
	
	@Test
	public void main() {
		TrieTree trie = new TrieTree();
		trie.insert("zuoac");
		trie.insert("zuoa");
		trie.insert("zuoa");
		trie.insert("zuoab");
		trie.insert("zuoad");
		trie.delete("zuoa");
		System.out.println(trie.search("zuoa"));
		System.out.println(trie.prefixNum("zuo"));
	}
	
	
	//前缀树的节点
	public class TrieNode{
		public int path;   //有多少字符串划过此节点
		public int end;	   //有多少字符串以此节点结尾
		//每一条路由第一个参数传入的字符命名,第二个参数代表着此名字的路到达的下一个节点
		public HashMap<Character, TrieNode> nexts;	//表示此节点的路(们--因为可能有多条)  
		
		//初始化构造
		public TrieNode(){
			path = 0;
			end = 0;
			nexts =new HashMap<Character, TrieNode>();
		}
	}
	
	//构造前缀树结构
	public class TrieTree{
		private TrieNode root;
		//前缀树初始化,拿到一个头结点
		public TrieTree(){
			root = new TrieNode();
		}
		
		//前缀树中插入一个字符串
		public void insert(String str){
			if (str==null) {
				return;
			}
			char[] chs = str.toCharArray();//将字符串转化为字符数组
			TrieNode node = root; //node索引指向头节点
			for (int i = 0; i < chs.length; i++) {
				if (node.nexts.get(chs[i])==null) {	 //此节点不存在这条路
					node.nexts.put(chs[i], new TrieNode());	//创建一条路
				}
				//到达此路指向的下一个节点
				node = node.nexts.get(chs[i]);
				node.path++;	//划过数量加一
			}
			node.end++;	//遍历结束后指向尾部 此时end加一
		}
		
		//前缀树中删除一个字符串
		public void delete(String str){
			if (search(str)==0) {
				return;
			}
			char[] chs = str.toCharArray();//将字符串转化为字符数组
			//原理还是以依次遍历去path--,当时如果等path=0时,之后的路程联通path=0的节点都可以抛弃
			TrieNode node = root; //node索引指向头节点
			for (int i = 0; i < chs.length; i++) {
				if (--node.nexts.get(chs[i]).path==0) {	//如果下一个节点path-1后为0.则直接抛弃(并且执行了path--)
					node.nexts.put(chs[i], null);
					return;	//直将后面的抛弃,结束
				}
				//否则就得到下一路的节点
				node = node.nexts.get(chs[i]);
				//node.path--;	//前面已经执行过了
			}
			node.end--;	//走到最后一个字符减一
		}
		
		//查找前缀树中出现过几次str,返回出现的出现的次数(与插入字符串逻辑相似,返回最后一个的end值,如果遍历过程出现null则返回0)
		public int search(String str){
			if (str==null) {
				return 0;
			}
			char[] chs = str.toCharArray();//将字符串转化为字符数组
			TrieNode node = root; 		//node索引指向头节点
			for (int i = 0; i < chs.length; i++) {
				if (node.nexts.get(chs[i])==null) {	 //此节点不存在这条路
					return 0;	//没有插入过此字符,则返回0
				}
				//到达此路指向的下一个节点
				node = node.nexts.get(chs[i]);
			}
			return node.end;	//返回最后一个节点的end值
		}
		
		//查找前缀树中有多少包含以str字符串开头的字符串
		public int prefixNum(String str){
			if (str==null) {
				return 0;
			}
			char[] chs = str.toCharArray();//将字符串转化为字符数组
			TrieNode node = root; 		//node索引指向头节点
			for (int i = 0; i < chs.length; i++) {
				if (node.nexts.get(chs[i])==null) {	 //此节点不存在这条路
					return 0;	//没有插入过此字符,则返回0
				}
				//到达此路指向的下一个节点
				node = node.nexts.get(chs[i]);
			}
			return node.path;	//返回最后一个节点的path值
		}
	}

}
